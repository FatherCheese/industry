package cookie.industry.core.block.machines.entities;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.Tag;
import cookie.industry.Industry2;
import cookie.industry.core.block.energy.TileEntityEnergyConductorDamageable;
import cookie.industry.core.block.machines.upgrades.MachineUpgradeBase;
import cookie.industry.core.block.machines.upgrades.MachineUpgradePulling;
import cookie.industry.core.block.machines.upgrades.MachineUpgradePushing;
import cookie.industry.extra.IAcceptsUpgrades;
import cookie.industry.extra.IIOPreviewer;
import cookie.industry.extra.IOTypes;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.core.util.IItemIO;
import sunsetsatellite.catalyst.core.util.TickTimer;
import sunsetsatellite.catalyst.energy.api.IEnergyItem;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TileEntityMachineBase extends TileEntityEnergyConductorDamageable implements IAcceptsUpgrades, IItemIO, IIOPreviewer {
    protected ItemStack[] slots = new ItemStack[2];
    protected final HashMap<Direction, MachineUpgradeBase> upgrades = new HashMap<>();

    public boolean active = false;
    public HashMap<Direction, Connection> itemConnections = new HashMap<>();
    public HashMap<Direction, Integer> activeItemSlots = new HashMap<>();
    public IOTypes ioType = IOTypes.NONE;
    public TickTimer ioPreviewTimer = new TickTimer(this, this::disableIOPreview, 20, false);

    public TileEntityMachineBase() {
        for (Direction dir : Direction.values()) {
            this.itemConnections.put(dir, Connection.NONE);
            this.activeItemSlots.put(dir, 0);
        }
    }

    @Override
    public boolean installUpgrade(Direction dir, MachineUpgradeBase upgradeBase) {
        if (upgrades.get(dir) == null) {
            upgrades.put(dir, upgradeBase);
            upgradeBase.onInstall(dir, this);
            return true;
        }

        return false;
    }

    @Override
    public boolean installUpgrade(Direction dir, MachineUpgradeBase upgradeBase, EntityPlayer player) {
        if (upgrades.get(dir) == null) {
            upgrades.put(dir, upgradeBase);
            upgradeBase.onInstall(dir, this, player);
            return true;
        }

        return false;
    }

    @Override
    public boolean removeUpgrade(Direction dir) {
        MachineUpgradeBase installedUpgrade = upgrades.get(dir);
        if (installedUpgrade != null) {
            EntityItem item = new EntityItem(worldObj, x, y, z, new ItemStack(installedUpgrade.getItem()));
            worldObj.entityJoinedWorld(item);

            installedUpgrade.onRemove();
            upgrades.remove(dir);

            return true;
        }

        return false;
    }

    @Override
    public boolean removeUpgrade(Direction dir, EntityPlayer player) {
        MachineUpgradeBase installedUpgrade = upgrades.get(dir);
        if (installedUpgrade != null) {
            EntityItem item = new EntityItem(worldObj, x, y, z, new ItemStack(installedUpgrade.getItem()));
            worldObj.entityJoinedWorld(item);

            installedUpgrade.onRemove(player);
            upgrades.remove(dir);

            return true;
        }

        return false;
    }

    @Override
    public boolean removeUpgrade(Direction dir, MachineUpgradeBase upgradeBase) {
        MachineUpgradeBase installedUpgrade = upgrades.get(dir);
        if (installedUpgrade != null && installedUpgrade == upgradeBase) {
            EntityItem item = new EntityItem(worldObj, x, y, z, new ItemStack(installedUpgrade.getItem()));
            worldObj.entityJoinedWorld(item);

            installedUpgrade.onRemove();
            upgrades.remove(dir);

            return true;
        }

        return false;
    }

    @Override
    public boolean removeUpgrade(Direction dir, MachineUpgradeBase upgradeBase, EntityPlayer player) {
        MachineUpgradeBase installedUpgrade = upgrades.get(dir);
        if (installedUpgrade != null && installedUpgrade == upgradeBase) {
            EntityItem item = new EntityItem(worldObj, x, y, z, new ItemStack(installedUpgrade.getItem()));
            worldObj.entityJoinedWorld(item);

            installedUpgrade.onRemove(player);
            upgrades.remove(dir);

            return true;
        }

        return false;
    }

    @Override
    public boolean hasUpgrade(Direction dir, Class<? extends MachineUpgradeBase> upgradeBase) {
        return upgrades.get(dir) != null && upgrades.get(dir).getClass().isAssignableFrom(upgradeBase);
    }

    @Override
    public boolean hasUpgrade(Class<? extends MachineUpgradeBase> upgradeBase) {
        return upgrades.values().stream().anyMatch((C) -> C != null && upgradeBase.isAssignableFrom(C.getClass()));
    }

    @Override
    public HashMap<Direction, MachineUpgradeBase> getUpgrades() {
        return upgrades;
    }

    @Override
    public void tick() {
        super.tick();

        if (!worldObj.isClientSide) {
            if (slots[0] != null && slots[0].getItem() instanceof IEnergyItem) {
                provide(slots[0], maxProvide, false);
                onInventoryChanged();
            }

            if (slots[1] != null && slots[1].getItem() instanceof IEnergyItem) {
                receive(slots[1], maxReceive, false);
                onInventoryChanged();
            }

            upgrades.values().stream().filter(Objects::nonNull).forEach(MachineUpgradeBase::tick);

            for (Direction dir : Direction.values()) {
                if (upgrades.get(dir) instanceof MachineUpgradePushing) {
                    itemConnections.put(dir, Connection.OUTPUT);
                    activeItemSlots.put(dir, 3);
                }

                if (upgrades.get(dir) instanceof MachineUpgradePulling) {
                    itemConnections.put(dir, Connection.INPUT);
                    activeItemSlots.put(dir, 2);
                }
            }
        }
    }

    @Override
    public int getActiveItemSlotForSide(Direction dir) {
        if (activeItemSlots.get(dir) == -1) {
            if (itemConnections.get(dir) == Connection.INPUT) {
                for (int i = 0; i < slots.length; i++) {
                    ItemStack content = slots[i];
                    if (content == null) return i;
                }
            } else if (itemConnections.get(dir) == Connection.OUTPUT) {
                for (int i = 0; i < slots.length; i++) {
                    ItemStack content = slots[i];
                    if (content != null) return i;
                }
            }

            return 0;
        }

        return activeItemSlots.get(dir);
    }

    @Override
    public int getActiveItemSlotForSide(Direction dir, ItemStack stack) {
        if (activeItemSlots.get(dir) == -1) {
            if (itemConnections.get(dir) == Connection.INPUT) {
                for (int i = 0; i < slots.length; i++) {
                    ItemStack content = slots[i];
                    if (content == null || (content.isItemEqual(stack) && content.stackSize <= content.getMaxStackSize()))
                        return i;
                }
            } else if (itemConnections.get(dir) == Connection.OUTPUT) {
                for (int i = 0; i < slots.length; i++) {
                    ItemStack content = slots[i];
                    if (content != null) return i;
                }
            }

            return 0;
        }

        return activeItemSlots.get(dir);
    }

    @Override
    public Connection getItemIOForSide(Direction dir) {
        return itemConnections.get(dir);
    }

    @Override
    public void setItemIOForSide(Direction dir, Connection con) {
        itemConnections.put(dir, con);
    }

    @Override
    public IOTypes getType() {
        return ioType;
    }

    @Override
    public void setPreview(IOTypes type) {
        this.ioType = type;
    }

    @Override
    public void setTempPreview(IOTypes type, int ticks) {
        ioPreviewTimer.value = ticks;
        ioPreviewTimer.max = ticks;
        ioPreviewTimer.unpause();
        this.ioType = type;
    }

    @Override
    public void disableIOPreview() {
        ioType = IOTypes.NONE;
    }

    @Override
    public void writeToNBT(CompoundTag tag) {
        super.writeToNBT(tag);
        CompoundTag upgradesTag = new CompoundTag();

        for (Map.Entry<Direction, MachineUpgradeBase> entry : upgrades.entrySet()) {
            if (entry.getValue() == null) continue;
            CompoundTag upgradeTag = new CompoundTag();
            entry.getValue().writeToNBT(upgradeTag);
            upgradesTag.putCompound(String.valueOf(entry.getKey().ordinal()), upgradeTag);
        }

        tag.put("Upgrades", upgradesTag);
    }

    @Override
    public void readFromNBT(CompoundTag tag) {
        super.readFromNBT(tag);
        CompoundTag upgradesTag = tag.getCompound("Upgrades");

        for (Map.Entry<String, Tag<?>> entry : upgradesTag.getValue().entrySet()) {
            Direction dir = Direction.values()[Integer.parseInt(entry.getKey())];
            CompoundTag coverTag = (CompoundTag) entry.getValue();
            String type = coverTag.getString("Type");
            try {
                MachineUpgradeBase upgrade = (MachineUpgradeBase) Class.forName(type).getConstructor().newInstance();
                upgrade.setup(dir,this);
                upgrades.put(dir, upgrade);
            } catch (InstantiationException |
                     IllegalAccessException |
                     InvocationTargetException |
                     NoSuchMethodException |
                     ClassNotFoundException e) {
                Industry2.logger.error("Could not read from NBT!");
                Industry2.logger.error(e.getMessage(), e);
            }
        }
    }
}

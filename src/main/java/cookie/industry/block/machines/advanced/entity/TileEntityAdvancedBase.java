package cookie.industry.block.machines.advanced.entity;

import cookie.industry.I2Config;
import cookie.industry.block.energy.entity.TileEntityEnergyConductorDamageable;
import cookie.industry.item.I2Items;
import cookie.industry.recipe.fuel.AdvancedRedstoneFuel;
import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.ListTag;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.core.player.inventory.InventorySorter;
import net.minecraft.core.util.helper.Sides;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.core.util.IItemIO;
import sunsetsatellite.catalyst.energy.impl.ItemEnergyContainer;

public class TileEntityAdvancedBase extends TileEntityEnergyConductorDamageable implements IInventory, IItemIO {
    protected ItemStack[] contents;
    protected AdvancedRedstoneFuel redstoneFuel = new AdvancedRedstoneFuel();
    protected int currentSpeed = 0;
    protected int currentEnergy = 0;
    protected int currentTransformers = 0;
    private int currentPuller = 0;
    private int currentPusher = 0;
    public boolean active = false;
    public int redstone = 0;
    public int currentMachineTime = 0;
    public int maxRedstone = 8000;
    public int maxMachineTime = 200;

    public TileEntityAdvancedBase() {
        contents = new ItemStack[11];

        setCapacity(I2Config.cfg.getInt("Energy Values.mvMachineStorage"));
        setTransfer(I2Config.cfg.getInt("Energy Values.mvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.mvIO"));

        for (Direction dir : Direction.values())
            setConnection(dir, Connection.INPUT);
    }

    @Override
    public int getSizeInventory() {
        return contents.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return contents[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (contents[i] != null) {
            if (contents[i].stackSize <= j) {
                ItemStack itemstack = contents[i];
                contents[i] = null;
                return itemstack;
            } else {
                ItemStack splitStack = contents[i].splitStack(j);
                if (contents[i].stackSize <= 0) {
                    contents[i] = null;
                }

                return splitStack;
            }
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        contents[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
            itemStack.stackSize = getInventoryStackLimit();

        onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return null;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        if (worldObj.getBlockTileEntity(x, y, z) != this)
            return false;

        return entityPlayer.distanceToSqr(x + 0.5f, y + 0.5f, z + 0.5f) <= 64;
    }

    @Override
    public void sortInventory() {
        InventorySorter.sortInventory(contents);
    }

    @Override
    public void onInventoryChanged() {
        super.onInventoryChanged();
        for (int upgradesSize = 7; upgradesSize < 11; upgradesSize++) {
            currentSpeed = 0;
            currentEnergy = 0;
            currentTransformers = 0;
            maxMachineTime = 200;
            capacity = I2Config.cfg.getInt("Energy Values.mvMachineStorage");

            if (contents[upgradesSize] != null) {
                if (contents[upgradesSize].getItem() == I2Items.SPEED_UPGRADE) {
                    currentSpeed += 1;
                    maxMachineTime *= 1 - 0.3;
                }

                if (contents[upgradesSize].getItem() == I2Items.ENERGY_UPGRADE) {
                    currentEnergy += 1;
                    capacity += 10000;
                }

                if (contents[upgradesSize].getItem() == I2Items.TRANSFORMER_UPGRADE)
                    currentTransformers += 1;

                if (contents[upgradesSize].getItem() == I2Items.PULLER_UPGRADE)
                    currentPuller = 1;

                if (contents[upgradesSize].getItem() == I2Items.PUSHER_UPGRADE)
                    currentPusher = 1;
            }
        }
    }

    private void pullFromTop() {
        TileEntity tile = worldObj.getBlockTileEntity(x, y + 1, z);
        if (tile instanceof IInventory) {
            for (int tileInv = 0; tileInv < ((IInventory) tile).getSizeInventory(); tileInv++) {
                ItemStack tileStack = ((IInventory) tile).getStackInSlot(tileInv);

                if (tileStack != null) {
                    if (tileStack.stackSize - 2 > 0) {

                        for (int inputSlots = 2; inputSlots < 4; inputSlots++) {
                            if (contents[inputSlots] == null) {
                                contents[inputSlots] = new ItemStack(tileStack.getItem().id, 1, tileStack.getMetadata());
                                --tileStack.stackSize;
                            }
                            if (contents[inputSlots] != null && contents[inputSlots].stackSize + 2 <= contents[inputSlots].getMaxStackSize())
                                if (contents[inputSlots] != null && contents[inputSlots].itemID == tileStack.itemID && contents[inputSlots].getMetadata() == tileStack.getMetadata()) {
                                    ++contents[inputSlots].stackSize;
                                    --tileStack.stackSize;
                                }
                        }
                    }
                }
            }
        }
    }

    private void pushToSide() {
        int meta = worldObj.getBlockMetadata(x, y, z);
        TileEntity tile;

        switch (meta) {
            default:
            case 2:
                tile = worldObj.getBlockTileEntity(x - 1, y, z);
                break;
            case 3:
                tile = worldObj.getBlockTileEntity(x + 1, y, z);
                break;
            case 4:
                tile = worldObj.getBlockTileEntity(x, y, z + 1);
                break;
            case 5:
                tile = worldObj.getBlockTileEntity(x, y, z - 1);
                break;
        }

        if (tile instanceof IInventory) {
            for (int tileInv = 0; tileInv < ((IInventory) tile).getSizeInventory(); tileInv++) {
                ItemStack tileStack = ((IInventory) tile).getStackInSlot(tileInv);

                for (int outputSlots = 4; outputSlots < 6; outputSlots++) {
                    if (contents[outputSlots] != null) {
                        if (tileStack == null) {
                            ((IInventory) tile).setInventorySlotContents(tileInv, new ItemStack(contents[outputSlots].getItem(), 1, contents[outputSlots].getMetadata()));
                            --contents[outputSlots].stackSize;
                        }

                        if (tileStack != null && tileStack.stackSize + 1 <= tileStack.getMaxStackSize())
                            if (tileStack.itemID == contents[outputSlots].itemID && tileStack.getMetadata() == contents[outputSlots].getMetadata()) {
                                ++tileStack.stackSize;
                                --contents[outputSlots].stackSize;
                            }

                        if (contents[outputSlots].stackSize <= 0)
                            contents[outputSlots] = null;
                    }
                }
            }
        }
    }

    private void pullFromBottom() {
        TileEntity tile = worldObj.getBlockTileEntity(x, y - 1, z);
        if (tile instanceof IInventory) {
            for (int tileInv = 0; tileInv < ((IInventory) tile).getSizeInventory(); tileInv++) {
                ItemStack tileStack = ((IInventory) tile).getStackInSlot(tileInv);

                if (tileStack != null) {
                    if (tileStack.stackSize - 1 > 0) {

                        if (contents[6] == null) {
                            contents[6] = new ItemStack(tileStack.getItem().id, 1, tileStack.getMetadata());
                            --tileStack.stackSize;
                        }
                        if (contents[6] != null && contents[6].stackSize + 2 < contents[6].getMaxStackSize())
                            if (contents[6] != null && contents[6].itemID == tileStack.itemID && contents[6].getMetadata() == tileStack.getMetadata()) {
                                ++contents[6].stackSize;
                                --tileStack.stackSize;
                            }
                    }
                }
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!worldObj.isClientSide) {
            if (getStackInSlot(0) != null && getStackInSlot(0).getItem() instanceof ItemEnergyContainer) {
                provide(getStackInSlot(0), getMaxProvide(), false);
                onInventoryChanged();
            }

            if (getStackInSlot(1) != null && getStackInSlot(1).getItem() instanceof ItemEnergyContainer) {
                receive(getStackInSlot(1), getMaxReceive(), false);
                onInventoryChanged();
            }

            if (currentTransformers == 1)
                setMaxReceive(I2Config.cfg.getInt("Energy Values.hvIO"));
            else if (currentTransformers >= 2)
                setMaxReceive(I2Config.cfg.getInt("Energy Values.ehvIO"));

            if (currentPuller > 0) {
                pullFromTop();
                pullFromBottom();
            }

            if (currentPusher > 0)
                pushToSide();

            if (currentMachineTime > maxMachineTime)
                currentMachineTime = 0;

            if (contents[6] != null && redstoneFuel.getRedstoneList().containsKey(contents[6].getItem().id)) {
                int newRedstoneLevel = redstoneFuel.getYield(contents[6].getItem().id);

                if (redstoneFuel.getRedstoneFuel(contents[6].getItem().id) != 0 && redstone + newRedstoneLevel <= maxRedstone) {
                    redstone += newRedstoneLevel;
                    --contents[6].stackSize;

                    if (contents[6].stackSize <= 0)
                        contents[6] = null;
                }
            }
        }
    }

    @Override
    public void writeToNBT(CompoundTag CompoundTag) {
        super.writeToNBT(CompoundTag);
        CompoundTag.putInt("MachineTime", currentMachineTime);
        CompoundTag.putInt("Energy", energy);
        CompoundTag.putInt("Redstone", redstone);

        ListTag listTag = new ListTag();
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] != null) {
                CompoundTag compoundTag2 = new CompoundTag();

                compoundTag2.putInt("Slot", i);
                contents[i].writeToNBT(compoundTag2);
                listTag.addTag(compoundTag2);
            }
        }
        CompoundTag.put("Items", listTag);
    }

    @Override
    public void readFromNBT(CompoundTag CompoundTag) {
        super.readFromNBT(CompoundTag);
        currentMachineTime = CompoundTag.getInteger("MachineTime");
        energy = CompoundTag.getInteger("Energy");
        redstone = CompoundTag.getInteger("Redstone");

        ListTag listTag = CompoundTag.getList("Items");

        contents = new ItemStack[getSizeInventory()];
        for (int i = 0; i < listTag.tagCount(); i++) {
            CompoundTag compoundTag2 = (com.mojang.nbt.CompoundTag) listTag.tagAt(i);
            int slot = compoundTag2.getInteger("Slot");

            if (slot >= 0 && slot < contents.length)
                contents[slot] = ItemStack.readItemStackFromNbt(compoundTag2);
        }
    }

    @Override
    public int getActiveItemSlotForSide(Direction direction) {
        int meta = worldObj.getBlockMetadata(x, y, z);
        int index = Sides.orientationLookUpHorizontal[6 * meta + direction.getSide()];
        direction = Direction.getDirectionFromSide(index);

        if (direction == Direction.Y_POS) {
            for (int inputSlots = 2; inputSlots < 4; inputSlots++) {
                if (contents[inputSlots] == null || contents[inputSlots].stackSize < 64)
                    return inputSlots;
            }
            return 2;
        }

        if (direction == Direction.X_POS) {
            for (int outputSlots = 4; outputSlots < 6; outputSlots++) {
                if (contents[outputSlots] != null)
                    return outputSlots;
            }
            return 4;
        }

        if (direction == Direction.Y_NEG)
            return 6;

        return -1;
    }

    @Override
    public int getActiveItemSlotForSide(Direction direction, ItemStack stack) {
        return 0;
    }

    @Override
    public Connection getItemIOForSide(Direction direction) {
        int meta = worldObj.getBlockMetadata(x, y, z);
        int index = Sides.orientationLookUpHorizontal[6 * meta + direction.getSide()];
        direction = Direction.getDirectionFromSide(index);

        switch (direction) {
            case Y_POS:
            case Y_NEG:
                return Connection.INPUT;
            case X_POS:
                return Connection.OUTPUT;
        }

        return Connection.NONE;
    }
}

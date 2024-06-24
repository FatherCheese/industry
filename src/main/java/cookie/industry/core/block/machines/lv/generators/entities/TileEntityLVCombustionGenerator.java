package cookie.industry.core.block.machines.lv.generators.entities;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.ListTag;
import cookie.industry.core.I2Config;
import cookie.industry.core.block.machines.entities.TileEntityMachineBase;
import cookie.industry.core.recipe.fuel.GeneratorFuel;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.core.util.IItemIO;

public class TileEntityLVCombustionGenerator extends TileEntityMachineBase implements IItemIO, IInventory {
    public int machineTick = 0;
    public int finalMachineTick = 0;
    private final GeneratorFuel fuel = new GeneratorFuel();
    public TileEntityLVCombustionGenerator() {
        maxProvide = I2Config.cfg.getInt("Energy Values.lvIO");
        maxReceive = I2Config.cfg.getInt("Energy Values.lvIO");
        setCapacity(I2Config.cfg.getInt("Energy Values.lvMachineStorage"));

        active = false;
        slots = new ItemStack[3];

        for (Direction dir : Direction.values()) {
            setConnection(dir, Connection.OUTPUT);
        }
    }

    @Override
    public int getActiveItemSlotForSide(Direction dir) {
        return dir == Direction.Y_POS ? 2 : 0;
    }

    @Override
    public int getActiveItemSlotForSide(Direction dir, ItemStack stack) {
        return dir == Direction.Y_POS ? 2 : 0;
    }

    @Override
    public Connection getItemIOForSide(Direction dir) {
        return dir == Direction.Y_POS ? Connection.INPUT : Connection.NONE;

    }

    @Override
    public int getSizeInventory() {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (slots[i] != null) {
            if (slots[i].stackSize <= j) {
                ItemStack contents = slots[i];

                slots[i] = null;
                return contents;
            } else {
                ItemStack splitStack = slots[i].splitStack(j);
                if (slots[i].stackSize <= 0) slots[i] = null;

                return splitStack;
            }
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        slots[i] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit())
            stack.stackSize = getInventoryStackLimit();

        onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "IndustryLVCombustionGenerator";
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return worldObj.getBlockTileEntity(x, y, z) == this && player.distanceToSqr(x + 0.5, y + 0.5, z + 0.5) <= 64;
    }

    @Override
    public void sortInventory() {

    }

    @Override
    public void writeToNBT(CompoundTag tag) {
        super.writeToNBT(tag);
        tag.putInt("MachineTick", machineTick);
        tag.putInt("FinalMachineTick", finalMachineTick);

        ListTag listTag = new ListTag();
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null) {
                CompoundTag tag2 = new CompoundTag();

                tag2.putInt("Slots", i);
                slots[i].writeToNBT(tag2);
                listTag.addTag(tag2);
            }
        }
        tag.put("Items", listTag);
    }

    @Override
    public void readFromNBT(CompoundTag tag) {
        super.readFromNBT(tag);
        machineTick = tag.getInteger("MachineTick");
        finalMachineTick = tag.getInteger("FinalMachineTick");

        ListTag listTag = tag.getList("Items");
        slots = new ItemStack[getSizeInventory()];

        for (int i = 0; i < listTag.tagCount(); i++) {
            CompoundTag tag2 = (CompoundTag) listTag.tagAt(i);
            int slot = tag2.getInteger("Slots");

            if (slot >= 0 && slot < slots.length)
                slots[slot] = ItemStack.readItemStackFromNbt(tag2);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!worldObj.isClientSide) {
            // Fuel slot (2)
            // If slot 2 is NOT null and has fuel, and the machine ISN'T on; then consume it and then move onto step 2.
            // Which is set the machine time to the fuel yield and increase the tick until it matches max.
            if ((slots[2] != null && fuel.getFuelList().containsKey(slots[2].itemID)) && (energy < capacity && finalMachineTick == 0)) {
                slots[2].stackSize--;
                finalMachineTick = fuel.getYield(slots[2].itemID);

                if (slots[2].stackSize <= 0) slots[2] = null;

                worldObj.markBlockNeedsUpdate(x, y, z);
                onInventoryChanged();
            }

            if (finalMachineTick > 0) {
                active = true;
                machineTick++;

                modifyEnergy(1);

                if (machineTick >= finalMachineTick) {
                    finalMachineTick = 0;
                    machineTick = 0;

                    active = false;
                    worldObj.markBlockNeedsUpdate(x, y, z);
                }
            }
        }
    }
}

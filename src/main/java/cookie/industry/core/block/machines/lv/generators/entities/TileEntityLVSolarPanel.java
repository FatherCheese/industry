package cookie.industry.core.block.machines.lv.generators.entities;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.ListTag;
import cookie.industry.core.I2Config;
import cookie.industry.core.block.machines.entities.TileEntitySolarBase;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;

public class TileEntityLVSolarPanel extends TileEntitySolarBase implements IInventory {

    public TileEntityLVSolarPanel() {
        maxProvide = I2Config.cfg.getInt("Energy Values.lvIO");
        maxReceive = I2Config.cfg.getInt("Energy Values.lvIO");
        setCapacity(I2Config.cfg.getInt("Energy Values.lvMachineStorage"));

        canSeeTheSky = false;
        active = false;

        for (Direction dir : Direction.values()) {
            setConnection(dir, dir != Direction.Y_POS ? Connection.OUTPUT : Connection.NONE);
        }
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
        return "IndustryLVSolarPanel";
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
        ListTag listTag = tag.getList("Items");
        slots = new ItemStack[getSizeInventory()];

        for (int i = 0; i < listTag.tagCount(); i++) {
            CompoundTag tag2 = (CompoundTag) listTag.tagAt(i);
            int slot = tag2.getInteger("Slots");

            if (slot >= 0 && slot < slots.length)
                slots[slot] = ItemStack.readItemStackFromNbt(tag2);
        }
    }
}

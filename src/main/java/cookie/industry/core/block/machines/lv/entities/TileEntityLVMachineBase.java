package cookie.industry.core.block.machines.lv.entities;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.ListTag;
import cookie.industry.core.block.machines.entities.TileEntityMachineBase;
import cookie.industry.extra.IMachine;
import cookie.industry.extra.api.MachineTier;
import cookie.industry.extra.api.MachineTiers;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;

public class TileEntityLVMachineBase extends TileEntityMachineBase implements IMachine, IInventory {
    private final MachineTier machineTier = MachineTiers.LOW_VOLTAGE;
    public int machineTick = 0;
    public final int finalMachineTick = 200;

    public TileEntityLVMachineBase() {
        setMaxReceive(machineTier.getVoltageInt());
        setMaxProvide(machineTier.getVoltageInt());
        setCapacity(machineTier.getVoltageInt() * 10);
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
        return "";
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
    public MachineTier getMachineTier() {
        return machineTier;
    }

    @Override
    public boolean canProduce() {
        return false;
    }

    @Override
    public void produceItem() {

    }
}

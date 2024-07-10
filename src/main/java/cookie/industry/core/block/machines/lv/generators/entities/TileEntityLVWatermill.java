package cookie.industry.core.block.machines.lv.generators.entities;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.ListTag;
import cookie.industry.core.I2Config;
import cookie.industry.core.block.machines.entities.TileEntityMachineBase;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;

public class TileEntityLVWatermill extends TileEntityMachineBase implements IInventory {

    public TileEntityLVWatermill() {
        maxProvide = I2Config.cfg.getInt("Energy Values.lowVoltage");
        maxReceive = I2Config.cfg.getInt("Energy Values.lowVoltage");
        setCapacity(I2Config.cfg.getInt("Energy Values.lowVoltage") * 10);

        active = false;

        for (Direction dir : Direction.values()) {
            if (dir == Direction.Y_POS || dir == Direction.Y_NEG) setConnection(dir, Connection.OUTPUT);
            else setConnection(dir, Connection.NONE);
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
        return "IndustryLVWatermill";
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

    @Override
    public void tick() {
        super.tick();

        if (!worldObj.isClientSide) {
            for (int watX = x - 1; watX < x + 2; watX++) {
                for (int watZ = z - 1; watZ < z + 2; watZ++) {
                    if (watX != x && watZ != z) {
                        if (worldObj.getBlockMaterial(watX, y, watZ) != Material.water) return;
                        active = true;
                    }
                }
            }

            if (active) modifyEnergy(1);
        }
    }
}

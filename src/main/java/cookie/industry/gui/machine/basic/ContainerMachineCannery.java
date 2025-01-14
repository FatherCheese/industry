package cookie.industry.gui.machine.basic;

import cookie.industry.block.machines.basic.entity.TileEntityMachineCannery;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.player.inventory.slot.SlotFurnace;
import sunsetsatellite.catalyst.energy.impl.ContainerEnergy;

import java.util.List;

public class ContainerMachineCannery extends ContainerEnergy {
    private int energy = 0;
    private int currentMachineTime = 0;
    InventoryPlayer inventory;
    TileEntityMachineCannery tileEntity;

    public ContainerMachineCannery(InventoryPlayer inventory, TileEntityMachineCannery tileEntity) {
        this.inventory = inventory;
        this.tileEntity = tileEntity;

        tile = tileEntity;
        addSlot(new Slot(tileEntity, 0, 8, 17));
        addSlot(new Slot(tileEntity, 1, 8, 53));
        addSlot(new Slot(tileEntity, 2, 56, 17));
        addSlot(new Slot(tileEntity, 3, 56, 53));
        addSlot(new SlotFurnace(inventory.player, tileEntity, 4, 116, 35));
        addSlot(new Slot(tileEntity, 5, 184, 8));
        addSlot(new Slot(tileEntity, 6, 184, 26));
        addSlot(new Slot(tileEntity, 7, 184, 44));
        addSlot(new Slot(tileEntity, 8, 184, 62));

        for(int xSlot = 0; xSlot < 3; ++xSlot)
            for (int ySlot = 0; ySlot < 9; ++ySlot)
                addSlot(new Slot(inventory, ySlot + xSlot * 9 + 9, 8 + ySlot * 18, 84 + xSlot * 18));

        for(int hotbar = 0; hotbar < 9; ++hotbar)
            addSlot(new Slot(inventory, hotbar, 8 + hotbar * 18, 142));
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return ((TileEntityMachineCannery) tile).canInteractWith(entityPlayer);
    }

    @Override
    public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
        if (slot.id >= 5 && slot.id <= 41) { // Entire inventory
            if (target == 1)    // Batteries
                return getSlots(0, 1, true);

            if (target == 2)    // Ingredients
                return getSlots(2, 1, false);

            if (target == 3)    // Cans or Cells
                return getSlots(3, 1, false);

            if (slot.id < 33)   // Inventory > Hotbar
                return getSlots(32, 9, false);

            // Hotbar > Inventory
            return getSlots(5, 27, false);
        }
        if (slot.id < 0)
            return null;

        return getSlots(5, 36, false);
    }

    @Override
    public void updateInventory() {
        super.updateInventory();

        for(ICrafting crafter : this.crafters) {
            if (this.energy != tileEntity.energy)
                crafter.updateCraftingInventoryInfo(this, 0, tileEntity.energy);

            if (this.currentMachineTime != tileEntity.currentMachineTime)
                crafter.updateCraftingInventoryInfo(this, 1, tileEntity.currentMachineTime);
        }
    }

    @Override
    public void updateClientProgressBar(int id, int value) {
        tileEntity = (TileEntityMachineCannery) tile;
        if (id == 0)
            tileEntity.energy = value;

        if (id == 1)
            tileEntity.currentMachineTime = value;
    }
}

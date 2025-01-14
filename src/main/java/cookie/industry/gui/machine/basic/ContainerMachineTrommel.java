package cookie.industry.gui.machine.basic;

import cookie.industry.block.machines.basic.entity.TileEntityMachineTrommel;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.player.inventory.slot.SlotFurnace;
import sunsetsatellite.catalyst.energy.impl.ContainerEnergy;

import java.util.List;

public class ContainerMachineTrommel extends ContainerEnergy {
    private int energy = 0;
    private int currentMachineTime = 0;
    InventoryPlayer inventory;
    TileEntityMachineTrommel tileEntity;

    public ContainerMachineTrommel(InventoryPlayer inventory, TileEntityMachineTrommel tileEntity) {
        this.inventory = inventory;
        this.tileEntity = tileEntity;

        this.tile = tileEntity;
        addSlot(new Slot(tileEntity, 0, 8, 17));
        addSlot(new Slot(tileEntity, 1, 8, 53));

        // Input slots
        addSlot(new Slot(tileEntity, 2, 80, 15));
        addSlot(new Slot(tileEntity, 3, 100, 35));
        addSlot(new Slot(tileEntity, 4, 80, 55));
        addSlot(new Slot(tileEntity, 5, 60, 35));

        // Output slots
        for (int outXSlot = 0; outXSlot < 2; ++outXSlot)
            for ( int outYSlot = 0; outYSlot < 4; ++outYSlot)
                addSlot(new SlotFurnace(inventory.player, tileEntity, outYSlot + outXSlot * 4 + 6, 134 + outXSlot * 18, 8 + outYSlot * 18));

        // Upgrade Slots
        addSlot(new Slot(tileEntity, 14, 184, 8));
        addSlot(new Slot(tileEntity, 15, 184, 26));
        addSlot(new Slot(tileEntity, 16, 184, 44));
        addSlot(new Slot(tileEntity, 17, 184, 62));

        // Inventory
        for(int xSlot = 0; xSlot < 3; ++xSlot)
            for (int ySlot = 0; ySlot < 9; ++ySlot)
                addSlot(new Slot(inventory, ySlot + xSlot * 9 + 9, 8 + ySlot * 18, 84 + xSlot * 18));

        for(int hotbar = 0; hotbar < 9; ++hotbar)
            addSlot(new Slot(inventory, hotbar, 8 + hotbar * 18, 142));
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return ((TileEntityMachineTrommel) tile).canInteractWith(entityPlayer);
    }

    @Override
    public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
        if (slot.id >= 6 && slot.id <= 42) { // Entire inventory
            if (target == 1)    // Batteries
                return getSlots(0, 2, false);

            if (target == 2)    // Ingredients
                return getSlots(2, 4, false);

            if (slot.id < 34)   // Inventory > Hotbar
                return getSlots(32, 9, false);

            // Hotbar > Inventory
            return getSlots(6, 27, false);
        }
        if (slot.id < 0)
            return null;

        return getSlots(6, 36, false);
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
        tileEntity = (TileEntityMachineTrommel) tile;
        if (id == 0)
            tileEntity.energy = value;

        if (id == 1)
            tileEntity.currentMachineTime = value;
    }
}

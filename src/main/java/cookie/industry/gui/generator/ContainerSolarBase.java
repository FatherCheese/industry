package cookie.industry.gui.generator;

import cookie.industry.block.energy.generator.entity.TileEntitySolarBase;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;
import sunsetsatellite.catalyst.energy.impl.ContainerEnergy;

public class ContainerSolarBase extends ContainerEnergy {
    private int energy = 0;
    InventoryPlayer inventory;
    TileEntitySolarBase tileEntity;

    public ContainerSolarBase(InventoryPlayer inventory, TileEntitySolarBase tileEntity) {
        this.inventory = inventory;
        this.tileEntity = tileEntity;

        tile = tileEntity;
        addSlot(new Slot(tileEntity, 0, 8, 17));
        addSlot(new Slot(tileEntity, 1, 8, 53));

        for(int xSlot = 0; xSlot < 3; ++xSlot)
            for (int ySlot = 0; ySlot < 9; ++ySlot)
                addSlot(new Slot(inventory, ySlot + xSlot * 9 + 9, 8 + ySlot * 18, 84 + xSlot * 18));

        for(int hotbar = 0; hotbar < 9; ++hotbar)
            addSlot(new Slot(inventory, hotbar, 8 + hotbar * 18, 142));
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return ((TileEntitySolarBase) tile).canInteractWith(entityPlayer);
    }

    @Override
    public void updateInventory() {
        super.updateInventory();

        for(ICrafting crafter : this.crafters) {
            if (this.energy != tileEntity.energy)
                crafter.updateCraftingInventoryInfo(this, 0, tileEntity.energy);
        }
    }

    @Override
    public void updateClientProgressBar(int id, int value) {
        tileEntity = (TileEntitySolarBase) tile;
        if (id == 0)
            tileEntity.energy = value;
    }
}

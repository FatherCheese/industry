package cookie.industry.client.gui.machines.lv.generators;

import cookie.industry.core.block.machines.lv.generators.entities.TileEntityLVSolarPanel;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;
import sunsetsatellite.catalyst.energy.impl.ContainerEnergy;

public class ContainerLVSolarPanel extends ContainerEnergy {
    private final TileEntityLVSolarPanel tileEntity;
    public ContainerLVSolarPanel(InventoryPlayer inventory, TileEntityLVSolarPanel tileEntity) {
        this.tileEntity = tileEntity;
        tile = tileEntity;

        addSlot(new Slot(tileEntity, 0, 80, 17));
        addSlot(new Slot(tileEntity, 1, 80, 53));

        // PLAYER INVENTORY //
        // Main Inventory
        for (int xSlots = 0; xSlots < 3; ++xSlots) {
            for (int ySlots = 0; ySlots < 9; ySlots++) {
                addSlot(new Slot(inventory, ySlots + xSlots * 9 + 9, 8 + ySlots * 18, 84 + xSlots * 18));
            }
        }

        // Hotbar
        for (int hotbar = 0; hotbar < 9; hotbar++) {
            addSlot(new Slot(inventory, hotbar, 8 + hotbar * 18, 142));
        }
    }


    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return tileEntity.canInteractWith(player);
    }

    @Override
    public void updateInventory() {
        super.updateInventory();

        for (ICrafting crafter : crafters) {
            if (this.energy != tileEntity.energy)
                crafter.updateCraftingInventoryInfo(this, 0, tileEntity.energy);
        }
    }

    @Override
    public void updateClientProgressBar(int id, int value) {
        if (id == 0) tileEntity.energy = value;
    }
}

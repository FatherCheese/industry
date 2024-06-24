package cookie.industry.client.gui.machines.lv.production;

import cookie.industry.core.block.machines.lv.entities.TileEntityLVMachineBase;
import cookie.industry.core.block.machines.lv.production.entities.TileEntityLVCompressor;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.player.inventory.slot.SlotFurnace;
import sunsetsatellite.catalyst.energy.impl.ContainerEnergy;

public class ContainerLVMachineBase extends ContainerEnergy {
    private final TileEntityLVMachineBase tileEntity;
    private final int energy = 0;
    private final int machineTick = 0;
    public ContainerLVMachineBase(InventoryPlayer inventory, TileEntityLVMachineBase tileEntity) {
        this.tileEntity = tileEntity;
        tile = tileEntity;

        addSlot(new Slot(tileEntity, 0, 8, 17));
        addSlot(new Slot(tileEntity, 1, 8, 53));
        addSlot(new Slot(tileEntity, 2, 56, 35));
        addSlot(new SlotFurnace(inventory.player, tileEntity, 3, 116, 35));

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

            if (this.machineTick != tileEntity.machineTick)
                crafter.updateCraftingInventoryInfo(this, 1, tileEntity.machineTick);
        }
    }

    @Override
    public void updateClientProgressBar(int id, int value) {
        if (id == 0) tileEntity.energy = value;
        if (id == 1) tileEntity.machineTick = value;
    }
}

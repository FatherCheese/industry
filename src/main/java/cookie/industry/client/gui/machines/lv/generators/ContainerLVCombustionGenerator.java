package cookie.industry.client.gui.machines.lv.generators;

import cookie.industry.core.block.machines.lv.generators.entities.TileEntityLVCombustionGenerator;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;
import sunsetsatellite.catalyst.energy.impl.ContainerEnergy;

public class ContainerLVCombustionGenerator extends ContainerEnergy {
    private final int energy = 0;
    private final int machineTick = 0;
    private final int finalMachineTick = 0;
    private final TileEntityLVCombustionGenerator tileEntity;
    public ContainerLVCombustionGenerator(InventoryPlayer inventory, TileEntityLVCombustionGenerator tileEntity) {
        this.tileEntity = tileEntity;
        tile = tileEntity;

        addSlot(new Slot(tileEntity, 0, 8, 17));
        addSlot(new Slot(tileEntity, 1, 8, 53));
        addSlot(new Slot(tileEntity, 2, 80, 35));

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

            if (this.finalMachineTick != tileEntity.finalMachineTick)
                crafter.updateCraftingInventoryInfo(this, 2, tileEntity.finalMachineTick);
        }
    }

    @Override
    public void updateClientProgressBar(int id, int value) {
        if (id == 0) tileEntity.energy = value;
        if (id == 1) tileEntity.machineTick = value;
        if (id == 2) tileEntity.finalMachineTick = value;
    }
}

package turniplabs.industry.gui

import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.player.inventory.InventoryPlayer
import net.minecraft.core.player.inventory.slot.Slot
import sunsetsatellite.energyapi.template.containers.ContainerEnergy
import turniplabs.industry.blocks.entities.TileEntitySolarBase

class ContainerSolarBase(inventory: InventoryPlayer?, tileEntity: TileEntitySolarBase) : ContainerEnergy() {

    init {
        tile = tileEntity
        addSlot(Slot(tileEntity, 0, 80, 35))

        for (ySlot in 0..2) for (xSlot in 0..8)
            addSlot(
                Slot(
                    inventory,
                    xSlot + ySlot * 9 + 9,
                    8 + xSlot * 18,
                    84 + ySlot * 18
                )
            )
        for (hotbar in 0..8)
            addSlot(Slot(inventory, hotbar, 8 + hotbar * 18, 142))
    }

    override fun isUsableByPlayer(entityPlayer: EntityPlayer?): Boolean {
        return (tile as TileEntitySolarBase).canInteractWith(entityPlayer)
    }
}
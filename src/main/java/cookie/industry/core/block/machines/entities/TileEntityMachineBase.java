package cookie.industry.core.block.machines.entities;

import cookie.industry.core.block.energy.TileEntityEnergyConductorDamageable;
import net.minecraft.core.item.ItemStack;
import sunsetsatellite.catalyst.energy.api.IEnergyItem;

public class TileEntityMachineBase extends TileEntityEnergyConductorDamageable {
    public boolean active = false;
    protected ItemStack[] slots = new ItemStack[2];

    @Override
    public void tick() {
        super.tick();

        if (!worldObj.isClientSide) {
            if (slots[0] != null && slots[0].getItem() instanceof IEnergyItem) {
                provide(slots[0], maxProvide, false);
                onInventoryChanged();
            }

            if (slots[1] != null && slots[1].getItem() instanceof IEnergyItem) {
                receive(slots[1], maxReceive, false);
                onInventoryChanged();
            }
        }
    }
}

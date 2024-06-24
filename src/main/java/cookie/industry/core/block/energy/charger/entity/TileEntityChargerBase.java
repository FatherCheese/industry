package cookie.industry.core.block.energy.charger.entity;

import cookie.industry.core.block.energy.TileEntityEnergyConductorDamageable;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.energy.api.IEnergyItem;

public class TileEntityChargerBase extends TileEntityEnergyConductorDamageable {

    public TileEntityChargerBase() {
        for (Direction dir : Direction.values())
            setConnection(dir, Connection.NONE);

        setConnection(Direction.Y_NEG, Connection.INPUT);
    }

    @Override
    public void tick() {
        super.tick();

        EntityPlayer player = worldObj.getClosestPlayer(x, y + 1, z, 1.0F);
        if (player != null) {
            ItemStack[] plyrInv = player.inventory.mainInventory;
            for (ItemStack stack : plyrInv) {
                if (stack != null) {
                    if (stack.getItem() instanceof IEnergyItem) {
                        provide(stack, getMaxProvide(), false);
                        player.inventory.onInventoryChanged();
                    }
                }
            }
        }
    }
}

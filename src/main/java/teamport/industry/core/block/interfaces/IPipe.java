package teamport.industry.core.block.interfaces;

import net.minecraft.core.item.ItemStack;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;

public interface IPipe {
    ItemStack receive(Direction dir, ItemStack received);
    ItemStack provide(Direction dir, ItemStack provided);

    void notifyOfReceive(IPipe pipe);

    void notifyOfProvide(IPipe pipe);

    boolean canConnect(Direction dir, Connection con);
}

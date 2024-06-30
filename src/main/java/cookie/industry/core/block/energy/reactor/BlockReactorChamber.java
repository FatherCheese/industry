package cookie.industry.core.block.energy.reactor;

import cookie.industry.core.block.energy.reactor.entity.TileEntityReactorNewer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.Catalyst;

public class BlockReactorChamber extends Block {

    public BlockReactorChamber(String key, int id, Material material) {
        super(key, id, material);
    }

    @Override
    public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side _side, double xPlaced, double yPlaced) {
        if (!world.isClientSide) {
            Side[] sides = new Side[]{Side.NORTH, Side.SOUTH, Side.EAST, Side.WEST, Side.BOTTOM, Side.TOP};
            for (Side side : sides) {
                int reactorX = x + side.getOffsetX();
                int reactorY = y + side.getOffsetY();
                int reactorZ = z + side.getOffsetZ();
                TileEntity tileEntity = world.getBlockTileEntity(reactorX, reactorY, reactorZ);

                if (!(tileEntity instanceof TileEntityReactorNewer) || !((TileEntityReactorNewer) tileEntity).isAssembled())
                    continue;
                Catalyst.displayGui(player, tileEntity, ((TileEntityReactorNewer) tileEntity).getInvName());
                break;
            }
        }
        return true;
    }
}

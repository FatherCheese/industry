package cookie.industry.core.block.energy.reactor;

import cookie.industry.core.block.energy.reactor.entity.TileEntityReactorIO;
import cookie.industry.core.block.energy.reactor.entity.TileEntityReactorNew;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.Catalyst;

public class BlockReactorIO extends BlockTileEntity {

    public BlockReactorIO(String key, int id, Material material) {
        super(key, id, material);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityReactorIO();
    }

    @Override
    public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side _side, double xPlaced, double yPlaced) {
        if (!world.isClientSide) {
            Side[] sides = new Side[]{Side.NORTH, Side.SOUTH, Side.EAST, Side.WEST, Side.BOTTOM, Side.TOP};
            for (Side side : sides) {
                int reactorY = y + side.getOffsetY();
                TileEntity tileEntity = world.getBlockTileEntity(x, reactorY, z);

                if (!(tileEntity instanceof TileEntityReactorNew) || !((TileEntityReactorNew) tileEntity).isAssembled())
                    continue;
                Catalyst.displayGui(player, tileEntity, ((TileEntityReactorNew) tileEntity).getInvName());
                break;
            }
        }
        return true;
    }
}

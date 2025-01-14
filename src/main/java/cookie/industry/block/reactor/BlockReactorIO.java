package cookie.industry.block.reactor;

import cookie.industry.block.reactor.entity.TileEntityReactorIO;
import cookie.industry.block.reactor.entity.TileEntityReactorNew;
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
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
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

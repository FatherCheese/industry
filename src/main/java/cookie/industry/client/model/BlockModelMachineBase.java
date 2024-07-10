package cookie.industry.client.model;

import cookie.industry.core.block.machines.entities.TileEntityMachineBase;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.helper.Sides;
import net.minecraft.core.world.WorldSource;

public class BlockModelMachineBase extends BlockModelStandard<Block> {
    IconCoordinate frontTexture;
    IconCoordinate frontActiveTexture;
    IconCoordinate sideTexture;

    public BlockModelMachineBase(Block block, String frontTexture, String frontActiveTexture, String sideTexture) {
        super(block);

        this.frontTexture = TextureRegistry.getTexture("industry:block/" + frontTexture);
        this.frontActiveTexture = TextureRegistry.getTexture("industry:block/" + frontActiveTexture);
        this.sideTexture = TextureRegistry.getTexture("industry:block/" + sideTexture);
    }

    @Override
    public IconCoordinate getBlockTexture(WorldSource blockAccess, int x, int y, int z, Side side) {
        int data = blockAccess.getBlockMetadata(x, y, z);
        int index = Sides.orientationLookUpHorizontal[6 * Math.min(data, 5) + side.getId()];
        if (index >= Sides.orientationLookUpHorizontal.length) return BLOCK_TEXTURE_UNASSIGNED;

        TileEntity tile = blockAccess.getBlockTileEntity(x,y,z);
        if (tile instanceof TileEntityMachineBase) {
            if (index != 2) {
                return sideTexture;
            }

            return ((TileEntityMachineBase) tile).active ? frontActiveTexture : frontTexture;
        }
        return super.getBlockTexture(blockAccess, x, y, z, side);
    }
}

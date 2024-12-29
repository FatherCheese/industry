package teamport.industry.core.block.logic;

import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import teamport.industry.core.block.entity.TileEntityPipe;

public class BlockLogicPipe extends BlockTileEntity {
    public BlockLogicPipe(String key, int id, Material material) {
        super(key, id, material);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityPipe();
    }

    @Override
    public boolean isSolidRender() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}

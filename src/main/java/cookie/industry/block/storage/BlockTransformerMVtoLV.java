package cookie.industry.block.storage;

import cookie.industry.block.storage.entity.TileEntityTransformerMVtoLV;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

public class BlockTransformerMVtoLV extends BlockTileEntity {

    public BlockTransformerMVtoLV(String key, int id, Material material) {
        super(key, id, material);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityTransformerMVtoLV();
    }
}

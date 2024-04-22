package cookie.industry.block.storage;

import cookie.industry.block.storage.entity.TileEntityBatboxLV;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

public class BlockBatboxLV extends BlockBatbox {
    public BlockBatboxLV(String key, int id, Material material) {
        super(key, id, material);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityBatboxLV();
    }
}

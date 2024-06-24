package cookie.industry.core.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.block.material.Material;

public class BlockLeavesRubberwood extends BlockLeavesBase {

    public BlockLeavesRubberwood(String key, int id) {
        super(key, id, Material.leaves);
    }

    @Override
    protected Block getSapling() {
        return I2BlocksNew.RUBBERWOOD_SAPLING;
    }
}

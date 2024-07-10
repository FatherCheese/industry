package cookie.industry.core.block;

import cookie.industry.core.I2BlocksNew;
import cookie.industry.core.world.WorldFeatureRubberTree;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class BlockSaplingRubberwood extends BlockSaplingBase {

    public BlockSaplingRubberwood(String key, int id) {
        super(key, id);
    }

    public void growTree(World world, int x, int y, int z, Random random) {
        world.setBlock(x, y, z, 0);

        WorldFeature tree = new WorldFeatureRubberTree(I2BlocksNew.RUBBERWOOD_LEAVES.id,4 + random.nextInt(3) + 1);
        if (!tree.generate(world, random, x, y, z)) {
            world.setBlock(x, y, z, this.id);
        }
    }
}

package teamport.industry.extra.mixin;

import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkDecorator;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.industry.core.IndConfig;
import teamport.industry.core.block.IndBlocks;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class, remap = false)
public abstract class ChunkDecoratorOverworldMixin implements ChunkDecorator {

    @Shadow @Final private World world;

    @Inject(method = "decorate", at = @At("TAIL"))
    private void industry_decorateOres(Chunk chunk, CallbackInfo ci) {
        int chunkX = chunk.xPosition;
        int chunkZ = chunk.zPosition;
        int minY = world.getWorldType().getMinY();
        int maxY = world.getWorldType().getMaxY();
        int rangeY = maxY + 1 - minY;
        float oreHeightModifier = (float) rangeY / 128;
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = world.getHeightValue(x + 16, z + 16);
        Random rand = new Random(world.getRandomSeed());

        // COPPER ORE //
        if (IndConfig.cfg.getBoolean("Spawning.copperOre")) {
            for (int height = 0; (float) height < 24 * oreHeightModifier; ++height) {
                int randX = x + rand.nextInt(16);
                int randY = minY + rand.nextInt(rangeY / 2);
                int randZ = z + rand.nextInt(16);
                (new WorldFeatureOre(IndBlocks.ORE_COPPER_STONE.id, 12, true)).generate(world, rand, randX, randY, randZ);
            }
        }

        // TIN ORE //
        if (IndConfig.cfg.getBoolean("Spawning.tinOre")) {
            for (int height = 0; (float) height < 20 * oreHeightModifier; ++height) {
                int randX = x + rand.nextInt(16);
                int randY = minY + rand.nextInt(rangeY / 2);
                int randZ = z + rand.nextInt(16);
                (new WorldFeatureOre(IndBlocks.ORE_TIN_STONE.id, 8, true)).generate(world, rand, randX, randY, randZ);
            }
        }

        // URANIUM ORE //
        if (IndConfig.cfg.getBoolean("Spawning.uraniumOre")) {
            for (int height = 0; (float) height < 2 * oreHeightModifier; ++height) {
                int randX = x + rand.nextInt(16);
                int randY = minY + rand.nextInt(rangeY / 3);
                int randZ = z + rand.nextInt(16);
                (new WorldFeatureOre(IndBlocks.ORE_URANIUM_STONE.id, 4, true)).generate(world, rand, randX, randY, randZ);
            }
        }
    }
}

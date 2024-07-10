package cookie.industry.extra.mixin;

import cookie.industry.core.I2Config;
import cookie.industry.core.I2BlocksNew;
import cookie.industry.core.world.WorldFeatureRubberTree;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkDecorator;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import net.minecraft.core.world.noise.PerlinNoise;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class, remap = false)
public abstract class ChunkFeatureOverworldMixin implements ChunkDecorator {

    @Shadow @Final private World world;

    @Shadow @Final private PerlinNoise treeDensityNoise;

    @Inject(method = "decorate", at = @At("TAIL"))
    private void industry_decorate(Chunk chunk, CallbackInfo ci) {
        int chunkX = chunk.xPosition;
        int chunkZ = chunk.zPosition;
        int minY = world.getWorldType().getMinY();
        int maxY = world.getWorldType().getMaxY();
        int rangeY = maxY + 1 - minY;
        float oreHeightModifier = (float)rangeY / 128.0F;
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = world.getHeightValue(x + 16, z + 16);
        Random rand = new Random(this.world.getRandomSeed());
        long l1 = rand.nextLong() / 2L * 2L + 1L;
        long l2 = rand.nextLong() / 2L * 2L + 1L;
        rand.setSeed((long)chunkX * l1 + (long)chunkZ * l2 ^ world.getRandomSeed());
        Biome biome = world.getBlockBiome(x + 16, y, z + 16);

        if (I2Config.cfg.getBoolean("World Gen.copperOre")) {
            for (int i = 0; (float) i < 20.0F * oreHeightModifier; i++) {
                int oreX = x + rand.nextInt(16);
                int oreY = minY + rand.nextInt(rangeY / 2);
                int oreZ = z + rand.nextInt(16);
                new WorldFeatureOre(I2BlocksNew.STONE_COPPER_ORE.id, 6, true).generate(this.world, rand, oreX, oreY, oreZ);
            }
        }

        if (I2Config.cfg.getBoolean("World Gen.tinOre")) {
            for (int i = 0; (float) i < 20.0F * oreHeightModifier; i++) {
                int oreX = x + rand.nextInt(16);
                int oreY = minY + rand.nextInt(rangeY / 2);
                int oreZ = z + rand.nextInt(16);
                new WorldFeatureOre(I2BlocksNew.STONE_TIN_ORE.id, 8, true).generate(this.world, rand, oreX, oreY, oreZ);
            }
        }

        // Does this even work?
        if (I2Config.cfg.getBoolean("World Gen.treeRubberwood")) {
            int k4 = (int)((treeDensityNoise.get((double)x * 0.25, (double)z * 0.25) / 8.0 + rand.nextDouble() * 4.0 + 4.0) / 3.0);
            int treeDensity = 0;
            if (rand.nextInt(10) == 0) treeDensity++;

            if (biome == Biomes.OVERWORLD_FOREST) treeDensity += k4 + 5;

            for (int i = 0; i < treeDensity; i++) {
                int treeX = x + rand.nextInt(16) + 8;
                int treeZ = z + rand.nextInt(16) + 8;
                WorldFeature feature = new WorldFeatureRubberTree(I2BlocksNew.RUBBERWOOD_LEAVES.id, 4 + rand.nextInt(3) + 1);

                feature.func_517_a(1.0, 1.0, 1.0);
                feature.generate(world, rand, treeX, world.getHeightValue(treeX, treeZ), treeZ);
            }
        }
    }
}

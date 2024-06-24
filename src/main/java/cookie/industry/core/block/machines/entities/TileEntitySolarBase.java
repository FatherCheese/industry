package cookie.industry.core.block.machines.entities;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.weather.WeatherClear;

public class TileEntitySolarBase extends TileEntityMachineBase {
    public boolean canSeeTheSky;

    private boolean isSkyVisible() {
        for (int height = y + 1; height < worldObj.getHeightBlocks(); height++) {
            Block block = worldObj.getBlock(x, height, z);

            if (block != null && block.isSolidRender()) return false;
        }

        return true;
    }

    @Override
    public void tick() {
        super.tick();

        // If the block can see the sky, it's day time, and the weather is clear...
        // Then generate energy and set boolean to true. Otherwise, don't and set boolean to false.
        if (!worldObj.isClientSide) {
            if (isSkyVisible() &&
                    worldObj.isDaytime() &&
                    worldObj.weatherManager.getCurrentWeather() instanceof WeatherClear) {
                canSeeTheSky = true;
                active = true;
            } else {
                canSeeTheSky = false;
                active = false;
            }

            if (active) modifyEnergy(1);
        }
    }
}

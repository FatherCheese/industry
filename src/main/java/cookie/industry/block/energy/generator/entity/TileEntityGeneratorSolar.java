package cookie.industry.block.energy.generator.entity;

import cookie.industry.I2Config;

public class TileEntityGeneratorSolar extends TileEntitySolarBase {
    public TileEntityGeneratorSolar() {
        super(1);

        setCapacity(I2Config.cfg.getInt("Energy Values.elvMachineStorage"));
        setTransfer(I2Config.cfg.getInt("Energy Values.elvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustrySolar";
    }
}

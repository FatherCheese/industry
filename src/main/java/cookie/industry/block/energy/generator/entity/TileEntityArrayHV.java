package cookie.industry.block.energy.generator.entity;

import cookie.industry.I2Config;

public class TileEntityArrayHV extends TileEntitySolarBase {

    public TileEntityArrayHV() {
        super(I2Config.cfg.getInt("Energy Values.hvIO"));

        setCapacity(I2Config.cfg.getInt("Energy Values.hvIO"));
        setTransfer(I2Config.cfg.getInt("Energy Values.hvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustryArrayHV";
    }
}

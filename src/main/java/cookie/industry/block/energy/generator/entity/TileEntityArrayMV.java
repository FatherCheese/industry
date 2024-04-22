package cookie.industry.block.energy.generator.entity;

import cookie.industry.I2Config;

public class TileEntityArrayMV extends TileEntitySolarBase {

    public TileEntityArrayMV() {
        super(I2Config.cfg.getInt("Energy Values.mvIO"));

        setCapacity(I2Config.cfg.getInt("Energy Values.mvIO"));
        setTransfer(I2Config.cfg.getInt("Energy Values.mvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustryArrayMV";
    }
}

package cookie.industry.block.energy.generator.entity;

import cookie.industry.I2Config;

public class TileEntityArrayEHV extends TileEntitySolarBase {

    public TileEntityArrayEHV() {
        super(I2Config.cfg.getInt("Energy Values.ehvIO"));

        setCapacity(I2Config.cfg.getInt("Energy Values.ehvIO"));
        setTransfer(I2Config.cfg.getInt("Energy Values.ehvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustryArrayEHV";
    }
}

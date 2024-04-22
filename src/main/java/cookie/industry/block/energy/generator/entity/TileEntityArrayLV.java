package cookie.industry.block.energy.generator.entity;

import cookie.industry.I2Config;

public class TileEntityArrayLV extends TileEntitySolarBase {

    public TileEntityArrayLV() {
        super(I2Config.cfg.getInt("Energy Values.lvIO"));

        setCapacity(I2Config.cfg.getInt("Energy Values.lvIO"));
        setTransfer(I2Config.cfg.getInt("Energy Values.lvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustryArrayLV";
    }
}

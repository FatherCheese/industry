package cookie.industry.block.storage.entity;

import cookie.industry.I2Config;

public class TileEntityBatboxEHV extends TileEntityBatboxBase {

    public TileEntityBatboxEHV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.ehvBatteryStorage") * 3);
        setTransfer(I2Config.cfg.getInt("Energy Values.ehvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.ehvIO"));
        setMaxProvide(I2Config.cfg.getInt("Energy Values.ehvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustryBatboxEHV";
    }
}

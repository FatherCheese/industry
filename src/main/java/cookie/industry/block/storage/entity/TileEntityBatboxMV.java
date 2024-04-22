package cookie.industry.block.storage.entity;

import cookie.industry.I2Config;

public class TileEntityBatboxMV extends TileEntityBatboxBase {

    public TileEntityBatboxMV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.mvBatteryStorage") * 3);
        setTransfer(I2Config.cfg.getInt("Energy Values.mvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.mvIO"));
        setMaxProvide(I2Config.cfg.getInt("Energy Values.mvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustryBatboxMV";
    }
}

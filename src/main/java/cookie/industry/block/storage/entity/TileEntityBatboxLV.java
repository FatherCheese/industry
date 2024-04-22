package cookie.industry.block.storage.entity;

import cookie.industry.I2Config;

public class TileEntityBatboxLV extends TileEntityBatboxBase {

    public TileEntityBatboxLV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.lvBatteryStorage") * 3);
        setTransfer(I2Config.cfg.getInt("Energy Values.lvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.lvIO"));
        setMaxProvide(I2Config.cfg.getInt("Energy Values.lvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustryBatboxLV";
    }
}

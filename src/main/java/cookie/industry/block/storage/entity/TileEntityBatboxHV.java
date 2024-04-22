package cookie.industry.block.storage.entity;

import cookie.industry.I2Config;

public class TileEntityBatboxHV extends TileEntityBatboxBase {

    public TileEntityBatboxHV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.hvBatteryStorage") * 3);
        setTransfer(I2Config.cfg.getInt("Energy Values.hvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.hvIO"));
        setMaxProvide(I2Config.cfg.getInt("Energy Values.hvIO"));
    }

    @Override
    public String getInvName() {
        return "IndustryBatboxHV";
    }
}

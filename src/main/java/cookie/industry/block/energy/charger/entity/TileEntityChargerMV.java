package cookie.industry.block.energy.charger.entity;

import cookie.industry.I2Config;

public class TileEntityChargerMV extends TileEntityChargerBase {

    public TileEntityChargerMV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.mvMachineStorage"));
        setTransfer(I2Config.cfg.getInt("Energy Values.mvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.mvIO"));
    }
}

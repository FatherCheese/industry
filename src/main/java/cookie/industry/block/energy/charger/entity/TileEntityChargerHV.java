package cookie.industry.block.energy.charger.entity;

import cookie.industry.I2Config;

public class TileEntityChargerHV extends TileEntityChargerBase {

    public TileEntityChargerHV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.hvMachineStorage"));
        setTransfer(I2Config.cfg.getInt("Energy Values.hvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.hvIO"));
    }
}

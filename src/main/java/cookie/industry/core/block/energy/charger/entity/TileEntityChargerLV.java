package cookie.industry.core.block.energy.charger.entity;

import cookie.industry.core.I2Config;

public class TileEntityChargerLV extends TileEntityChargerBase {

    public TileEntityChargerLV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.lvMachineStorage"));
        setTransfer(I2Config.cfg.getInt("Energy Values.lvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.lvIO"));
    }
}

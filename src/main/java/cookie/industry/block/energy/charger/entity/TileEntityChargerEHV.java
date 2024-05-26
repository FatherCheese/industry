package cookie.industry.block.energy.charger.entity;

import cookie.industry.I2Config;

public class TileEntityChargerEHV extends TileEntityChargerBase {

    public TileEntityChargerEHV() {
        super();
        setCapacity(I2Config.cfg.getInt("Energy Values.ehvMachineStorage"));
        setTransfer(I2Config.cfg.getInt("Energy Values.ehvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.ehvIO"));
    }
}

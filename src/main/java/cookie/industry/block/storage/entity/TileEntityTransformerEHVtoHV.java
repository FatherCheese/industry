package cookie.industry.block.storage.entity;

import cookie.industry.I2Config;

public class TileEntityTransformerEHVtoHV extends TileEntityTransformerBase {

    public TileEntityTransformerEHVtoHV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.hvIO"));
        setTransfer(I2Config.cfg.getInt("Energy Values.hvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.ehvIO"));
    }
}

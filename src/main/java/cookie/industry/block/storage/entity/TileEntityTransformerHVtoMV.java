package cookie.industry.block.storage.entity;

import cookie.industry.I2Config;

public class TileEntityTransformerHVtoMV extends TileEntityTransformerBase {

    public TileEntityTransformerHVtoMV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.mvIO"));
        setTransfer(I2Config.cfg.getInt("Energy Values.mvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.hvIO"));
    }
}

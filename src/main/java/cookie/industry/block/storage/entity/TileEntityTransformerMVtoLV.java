package cookie.industry.block.storage.entity;

import cookie.industry.I2Config;

public class TileEntityTransformerMVtoLV extends TileEntityTransformerBase {

    public TileEntityTransformerMVtoLV() {
        setCapacity(I2Config.cfg.getInt("Energy Values.lvIO"));
        setTransfer(I2Config.cfg.getInt("Energy Values.lvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.mvIO"));
    }
}

package cookie.industry.core.block.energy.reactor.entity;

import cookie.industry.core.I2Config;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.energy.impl.TileEntityEnergyConductor;

public class TileEntityReactorRTG extends TileEntityEnergyConductor {

    public TileEntityReactorRTG() {
        setCapacity(I2Config.cfg.getInt("Energy Values.elvIO") * 2);
        setMaxProvide(I2Config.cfg.getInt("Energy Values.elvIO") * 2);
        setMaxReceive(I2Config.cfg.getInt("Energy Values.elvIO") * 2);

        for (Direction dir : Direction.values())
            setConnection(dir, Connection.OUTPUT);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.energy <= this.capacity) ++this.energy;
    }
}

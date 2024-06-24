package cookie.industry.core.block.energy.cables.entity;

import cookie.industry.core.block.energy.TileEntityEnergyConductorDamageable;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;

public class TileEntityCable extends TileEntityEnergyConductorDamageable {
    public TileEntityCable() {
    }

    public TileEntityCable(int capacity, int energy, int transfer, int dangerLevel) {
        setCapacity(capacity);
        setEnergy(energy);
        setTransfer(transfer);

        for (Direction dir : Direction.values())
            setConnection(dir, Connection.BOTH);
    }
}

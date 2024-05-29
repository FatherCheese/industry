package cookie.industry.block.energy.cables.entity;

import com.mojang.nbt.CompoundTag;
import cookie.industry.block.energy.entity.TileEntityEnergyConductorDamageable;
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

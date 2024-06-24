package cookie.industry.core.block.energy.reactor.entity;

import cookie.industry.core.I2Config;
import com.mojang.nbt.CompoundTag;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.energy.impl.TileEntityEnergyConductor;

public class TileEntityReactorIO extends TileEntityEnergyConductor {

    public TileEntityReactorIO() {
        setCapacity(I2Config.cfg.getInt("Energy Values.ehvIO"));
        setMaxProvide(I2Config.cfg.getInt("Energy Values.ehvIO"));
        setMaxReceive(I2Config.cfg.getInt("Energy Values.ehvIO"));

        for (Direction dir : Direction.values())
            setConnection(dir, Connection.OUTPUT);

        setConnection(Direction.Y_POS, Connection.INPUT);
        setConnection(Direction.Y_NEG, Connection.INPUT);
    }

    @Override
    public void writeToNBT(CompoundTag compoundTag) {
        super.writeToNBT(compoundTag);
        compoundTag.putInt("Energy", energy);
    }

    @Override
    public void readFromNBT(CompoundTag compoundTag) {
        super.readFromNBT(compoundTag);
        energy = compoundTag.getInteger("Energy");
    }
}

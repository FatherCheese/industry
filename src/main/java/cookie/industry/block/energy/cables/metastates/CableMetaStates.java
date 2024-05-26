package cookie.industry.block.energy.cables.metastates;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.world.WorldSource;
import sunsetsatellite.catalyst.energy.impl.TileEntityEnergyConductor;
import useless.dragonfly.model.blockstates.processed.MetaStateInterpreter;

import java.util.HashMap;

public class CableMetaStates extends MetaStateInterpreter {

    private boolean isEnergyBlock(WorldSource worldSource, int x, int y, int z) {
        TileEntity tile = worldSource.getBlockTileEntity(x, y, z);
        return tile instanceof TileEntityEnergyConductor;
    }

    @Override
    public HashMap<String, String> getStateMap(WorldSource worldSource, int x, int y, int z, Block block, int meta) {
        HashMap<String, String> result = new HashMap<>();
        boolean north = isEnergyBlock(worldSource, x, y, z - 1);
        boolean east = isEnergyBlock(worldSource, x + 1, y, z);
        boolean south = isEnergyBlock(worldSource, x, y, z + 1);
        boolean west = isEnergyBlock(worldSource, x - 1, y, z);
        boolean up = isEnergyBlock(worldSource, x, y + 1, z);
        boolean down = isEnergyBlock(worldSource, x, y - 1, z);

        result.put("north", north ? "true" : "false");
        result.put("east", east ? "true" : "false");
        result.put("south", south ? "true" : "false");
        result.put("west", west ? "true" : "false");
        result.put("up", up ? "true" : "false");
        result.put("down", down ? "true" : "false");
        return result;
    }
}

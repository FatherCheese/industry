package cookie.industry.core.block.energy.cables.metastates;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import org.useless.dragonfly.model.blockstates.processed.MetaStateInterpreter;
import sunsetsatellite.catalyst.energy.impl.TileEntityEnergyConductor;

import java.util.HashMap;

public class NewCableMetaState extends MetaStateInterpreter {
    private boolean isEnergyBlock(WorldSource world, int x, int y, int z) {
        TileEntity tile = world.getBlockTileEntity(x, y, z);
        return tile instanceof TileEntityEnergyConductor;
    }

    private Side getSide(WorldSource world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        return Side.getSideById(meta);
    }

    @Override
    public HashMap<String, String> getStateMap(WorldSource world, int x, int y, int z, Block block, int meta) {
        HashMap<String, String> result = new HashMap<>();
        // Directions
        boolean north = isEnergyBlock(world, x, y, z - 1);
        boolean east = isEnergyBlock(world, x + 1, y, z);
        boolean south = isEnergyBlock(world, x, y, z + 1);
        boolean west = isEnergyBlock(world, x - 1, y, z);
        boolean top = isEnergyBlock(world, x, y + 1, z);
        boolean bottom = isEnergyBlock(world, x, y - 1, z);

        // Faces
        Side direction = Side.getSideById(meta);
        Side topSide = getSide(world, x, y + 1, z);
        Side bottomSide = getSide(world, x, y - 1, z);

        result.put("north", north ? "true" : "false");
        result.put("east", east ? "true" : "false");
        result.put("south", south ? "true" : "false");
        result.put("west", west ? "true" : "false");
        result.put("top", top ? "true" : "false");
        result.put("bottom", bottom ? "true" : "false");

        result.put("direction", String.valueOf(direction.getId()));
        result.put("topside", String.valueOf(topSide.getId()));
        result.put("bottomside", String.valueOf(bottomSide.getId()));
        return result;
    }
}

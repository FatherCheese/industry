package cookie.industry.compat.terrainapi;

import cookie.industry.Industry2;
import useless.terrainapi.api.TerrainAPI;

public class TerrainAPIPlugin implements TerrainAPI {
    @Override
    public String getModID() {
        return Industry2.MOD_ID;
    }

    @Override
    public void onInitialize() {
        new OverworldInitialization().init();
    }
}

package cookie.industry.extra.api;

import java.util.ArrayList;
import java.util.List;

public class MachineTier {
    protected final String MOD_ID;
    protected final String tier;
    protected final int voltageInt;
    protected final List<MachineTier> machineTiers = new ArrayList<>();

    public MachineTier(String MOD_ID, String tier, int tierInList) {
        this.MOD_ID = MOD_ID;
        this.tier = tier;
        this.voltageInt = tierInList;
    }

    public String getTier() {
        return tier;
    }

    public int getVoltageInt() {
        return voltageInt;
    }

    public List<MachineTier> getMachineTiers() {
        return machineTiers;
    }
}

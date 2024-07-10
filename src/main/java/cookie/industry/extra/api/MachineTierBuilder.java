package cookie.industry.extra.api;

public class MachineTierBuilder {
    private final String MOD_ID;
    private String tier;
    private int voltageInt;

    public MachineTierBuilder(String MOD_ID) {
        this.MOD_ID = MOD_ID;
    }

    public MachineTierBuilder setTier(String tier) {
        this.tier = tier;
        return this;
    }

    public MachineTierBuilder setVoltageInt(int voltageInt) {
        this.voltageInt = voltageInt;
        return this;
    }

    public MachineTier build() {
        MachineTier machineTier = new MachineTier(MOD_ID, tier, voltageInt);
        MachineTiers.machineTiers.add(machineTier);
        return machineTier;
    }
}

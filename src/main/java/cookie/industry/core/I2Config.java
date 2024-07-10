package cookie.industry.core;

import cookie.industry.Industry2;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

public class I2Config {
    private static final Toml properties = new Toml("Industry2's TOML Config");
    public static TomlConfigHandler cfg;
    static {
        properties.addCategory("Industry2")
                .addEntry("cfgVersion", 5);

        properties.addCategory("Machine storage is x10 the number, and battery storage is x4 that.", "Energy Values")
                .addEntry("lowVoltage", 60)
                .addEntry("mediumVoltage", 120)
                .addEntry("highVoltage", 240)
                .addEntry("extraHighVoltage", 480);

        properties.addCategory("World Gen")
                .addEntry("copperOre", true)
                .addEntry("tinOre", true)
                .addEntry("treeRubberwood", true);

        properties.addCategory("IDs")
                .addEntry("startingBlockID", 1100)
                .addEntry("startingItemID", 17000);

        cfg = new TomlConfigHandler(Industry2.MOD_ID, properties);
    }
}

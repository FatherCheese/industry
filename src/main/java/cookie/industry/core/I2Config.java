package cookie.industry.core;

import cookie.industry.Industry2;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

public class I2Config {
    public static ConfigUpdater updater = ConfigUpdater.fromProperties();
    private static final Toml properties = new Toml("Industry2's TOML Config");
    public static TomlConfigHandler cfg;
    static {
        properties.addCategory("Industry2")
                .addEntry("cfgVersion", 5);

        properties.addCategory("Energy Values")
                .addEntry("lvIO", 60)
                .addEntry("mvIO", 120)
                .addEntry("hvIO", 240)
                .addEntry("ehvIO", 480)
                .addEntry("lvBatteryStorage", 1800)
                .addEntry("mvBatteryStorage", 18000)
                .addEntry("hvBatteryStorage", 180000)
                .addEntry("ehvBatteryStorage", 180000)
                .addEntry("lvMachineStorage", 1800)
                .addEntry("hvMachineStorage", 18000)
                .addEntry("mvMachineStorage", 180000)
                .addEntry("ehvMachineStorage", 180000);

        properties.addCategory("World Gen")
                .addEntry("copperOre", true)
                .addEntry("tinOre", true)
                .addEntry("treeRubberwood", true);

        properties.addCategory("IDs")
                .addEntry("startingBlockID", 1100)
                .addEntry("startingItemID", 17000);

        cfg = new TomlConfigHandler(updater, Industry2.MOD_ID, properties);
    }
}

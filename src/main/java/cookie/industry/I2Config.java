package cookie.industry;

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
                .addEntry("elvIO", 4)
                .addEntry("lvIO", 32)
                .addEntry("mvIO", 128)
                .addEntry("hvIO", 512)
                .addEntry("ehvIO", 2048)
                .addEntry("lvBatteryStorage", 10000)
                .addEntry("mvBatteryStorage", 100000)
                .addEntry("hvBatteryStorage", 1000000)
                .addEntry("ehvBatteryStorage", 10000000)
                .addEntry("elvMachineStorage", 100)
                .addEntry("lvMachineStorage", 1000)
                .addEntry("mvMachineStorage", 10000)
                .addEntry("ehvMachineStorage", 100000);

        properties.addCategory("World Gen")
                .addEntry("copperOre", true)
                .addEntry("tinOre", true)
                .addEntry("treeRubberwood", true);


        properties.addCategory("IDs")
                .addEntry("startingBlockID", 1000)
                .addEntry("startingItemID", 17000);

        cfg = new TomlConfigHandler(updater, Industry2.MOD_ID, properties);
    }
}

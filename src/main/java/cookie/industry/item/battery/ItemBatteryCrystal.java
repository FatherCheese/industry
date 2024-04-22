package cookie.industry.item.battery;

import cookie.industry.I2Config;

public class ItemBatteryCrystal extends ItemBatteryBase {

    public ItemBatteryCrystal(String name, int i) {
        super(name, i,
                I2Config.cfg.getInt("Energy Values.hvBatteryStorage"),
                I2Config.cfg.getInt("Energy Values.hvIO"),
                I2Config.cfg.getInt("Energy Values.hvIO"),
                "battery_crystal_4.png",
                "battery_crystal_3.png",
                "battery_crystal_2.png",
                "battery_crystal_1.png",
                "battery_crystal_0.png");
    }
}

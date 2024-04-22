package cookie.industry.item.battery;

import cookie.industry.I2Config;

public class ItemBatteryAdvanced extends ItemBatteryBase {

    public ItemBatteryAdvanced(String name, int i) {
        super(name, i,
                I2Config.cfg.getInt("Energy Values.mvBatteryStorage"),
                I2Config.cfg.getInt("Energy Values.mvIO"),
                I2Config.cfg.getInt("Energy Values.mvIO"),
                "battery_advanced_4.png",
                "battery_advanced_3.png",
                "battery_advanced_2.png",
                "battery_advanced_1.png",
                "battery_advanced_0.png");
    }
}

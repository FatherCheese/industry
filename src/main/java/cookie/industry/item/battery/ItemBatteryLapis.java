package cookie.industry.item.battery;

import cookie.industry.I2Config;

public class ItemBatteryLapis extends ItemBatteryBase {

    public ItemBatteryLapis(String name, int i) {
        super(name, i,
                I2Config.cfg.getInt("Energy Values.ehvBatteryStorage"),
                I2Config.cfg.getInt("Energy Values.ehvIO"),
                I2Config.cfg.getInt("Energy Values.ehvIO"),
                "battery_lapis_4.png",
                "battery_lapis_3.png",
                "battery_lapis_2.png",
                "battery_lapis_1.png",
                "battery_lapis_0.png");
    }
}

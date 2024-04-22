package cookie.industry.item.battery;

import cookie.industry.I2Config;

public class ItemBatteryRedstone extends ItemBatteryBase {

    public ItemBatteryRedstone(String name, int i) {
        super(name, i,
                I2Config.cfg.getInt("Energy Values.lvBatteryStorage"),
                I2Config.cfg.getInt("Energy Values.lvIO"),
                I2Config.cfg.getInt("Energy Values.lvIO"),
                "battery_redstone_4.png",
                "battery_redstone_3.png",
                "battery_redstone_2.png",
                "battery_redstone_1.png",
                "battery_redstone_0.png");
    }
}

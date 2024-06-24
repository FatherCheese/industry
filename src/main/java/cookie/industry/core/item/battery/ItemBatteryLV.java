package cookie.industry.core.item.battery;

import cookie.industry.core.I2Config;

public class ItemBatteryLV extends ItemBatteryBase {

    public ItemBatteryLV(String name, int i) {
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

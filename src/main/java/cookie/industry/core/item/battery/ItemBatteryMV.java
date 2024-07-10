package cookie.industry.core.item.battery;

import cookie.industry.core.I2Config;

public class ItemBatteryMV extends ItemBatteryBase {

    public ItemBatteryMV(String name, int i) {
        super(name, i,
                I2Config.cfg.getInt("Energy Values.mediumVoltage") * 4,
                I2Config.cfg.getInt("Energy Values.mediumVoltage"),
                I2Config.cfg.getInt("Energy Values.mediumVoltage"),
                "battery_advanced_4.png",
                "battery_advanced_3.png",
                "battery_advanced_2.png",
                "battery_advanced_1.png",
                "battery_advanced_0.png");
    }
}

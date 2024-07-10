package cookie.industry.core.item.battery;

import cookie.industry.core.I2Config;

public class ItemBatteryEHV extends ItemBatteryBase {

    public ItemBatteryEHV(String name, int i) {
        super(name, i,
                I2Config.cfg.getInt("Energy Values.extraHighVoltage") * 4,
                I2Config.cfg.getInt("Energy Values.extraHighVoltage"),
                I2Config.cfg.getInt("Energy Values.extraHighVoltage"),
                "battery_lapis_4.png",
                "battery_lapis_3.png",
                "battery_lapis_2.png",
                "battery_lapis_1.png",
                "battery_lapis_0.png");
    }
}

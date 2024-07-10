package cookie.industry.extra.api;

import cookie.industry.core.I2Config;

import java.util.ArrayList;
import java.util.List;

import static cookie.industry.Industry2.MOD_ID;

public class MachineTiers {
    public static final List<MachineTier> machineTiers = new ArrayList<>();

    public static final MachineTier LOW_VOLTAGE = new MachineTierBuilder(MOD_ID)
            .setTier("Low Voltage")
            .setVoltageInt(I2Config.cfg.getInt("Energy Values.lowVoltage"))
            .build();

    public static final MachineTier MEDIUM_VOLTAGE = new MachineTierBuilder(MOD_ID)
            .setTier("Medium Voltage")
            .setVoltageInt(I2Config.cfg.getInt("Energy Values.mediumVoltage"))
            .build();

    public static final MachineTier HIGH_VOLTAGE = new MachineTierBuilder(MOD_ID)
            .setTier("High Voltage")
            .setVoltageInt(I2Config.cfg.getInt("Energy Values.highVoltage"))
            .build();

    public static final MachineTier EXTRA_HIGH_VOLTAGE = new MachineTierBuilder(MOD_ID)
            .setTier("Extra High Voltage")
            .setVoltageInt(I2Config.cfg.getInt("Energy Values.extraHighVoltage"))
            .build();
}

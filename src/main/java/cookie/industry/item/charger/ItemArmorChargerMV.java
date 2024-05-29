package cookie.industry.item.charger;

import cookie.industry.I2Config;
import net.minecraft.core.item.material.ArmorMaterial;

public class ItemArmorChargerMV extends ItemArmorChargerBase {
    public ItemArmorChargerMV(String name, int id, ArmorMaterial material, int armorPiece) {
        super(name,
                id,
                material,
                armorPiece,
                I2Config.cfg.getInt("Energy Values.mvBatteryStorage") * 2,
                I2Config.cfg.getInt("Energy Values.mvIO"),
                I2Config.cfg.getInt("Energy Values.mvIO")
        );
    }
}

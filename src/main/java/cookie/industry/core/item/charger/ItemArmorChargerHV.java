package cookie.industry.core.item.charger;

import cookie.industry.core.I2Config;
import net.minecraft.core.item.material.ArmorMaterial;

public class ItemArmorChargerHV extends ItemArmorChargerBase {
    public ItemArmorChargerHV(String name, int id, ArmorMaterial material, int armorPiece) {
        super(name,
                id,
                material,
                armorPiece,
                I2Config.cfg.getInt("Energy Values.hvBatteryStorage") * 2,
                I2Config.cfg.getInt("Energy Values.hvIO"),
                I2Config.cfg.getInt("Energy Values.hvIO")
        );
    }
}

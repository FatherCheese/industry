package cookie.industry.core.item.charger;

import cookie.industry.core.I2Config;
import net.minecraft.core.item.material.ArmorMaterial;

public class ItemArmorChargerEHV extends ItemArmorChargerBase {
    public ItemArmorChargerEHV(String name, int id, ArmorMaterial material, int armorPiece) {
        super(name,
                id,
                material,
                armorPiece,
                I2Config.cfg.getInt("Energy Values.ehvBatteryStorage") * 2,
                I2Config.cfg.getInt("Energy Values.ehvIO"),
                I2Config.cfg.getInt("Energy Values.ehvIO")
        );
    }
}

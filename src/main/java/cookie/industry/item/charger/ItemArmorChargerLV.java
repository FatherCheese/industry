package cookie.industry.item.charger;

import cookie.industry.I2Config;
import net.minecraft.core.item.material.ArmorMaterial;

public class ItemArmorChargerLV extends ItemArmorChargerBase {
    public ItemArmorChargerLV(String name, int id, ArmorMaterial material, int armorPiece) {
        super(name,
                id,
                material,
                armorPiece,
                I2Config.cfg.getInt("Energy Values.lvBatteryStorage") * 2,
                I2Config.cfg.getInt("Energy Values.lvIO"),
                I2Config.cfg.getInt("Energy Values.lvIO")
        );
    }
}

package cookie.industry.item;

import cookie.industry.Industry2;
import cookie.industry.I2Config;
import cookie.industry.IndustryTags;
import cookie.industry.block.I2Blocks;
import cookie.industry.item.battery.ItemBatteryAdvanced;
import cookie.industry.item.battery.ItemBatteryCrystal;
import cookie.industry.item.battery.ItemBatteryLapis;
import cookie.industry.item.battery.ItemBatteryRedstone;
import cookie.industry.item.charger.*;
import cookie.industry.item.radioactive.ItemCellRedstoneT1;
import cookie.industry.item.radioactive.ItemCellRedstoneT2;
import cookie.industry.item.radioactive.ItemCellRedstoneT3;
import cookie.industry.item.radioactive.ItemRadioactive;
import cookie.industry.item.toolelectric.*;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.ItemFoodStackable;
import net.minecraft.core.item.ItemPlaceable;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tag.ItemTags;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemHelper;

public class I2Items {
    private final String MOD_ID = Industry2.MOD_ID;

    private int itemID = I2Config.cfg.getInt("IDs.startingItemID");
    private int nextItemID(String itemName) {
        return ++itemID;
    }

    private static ArmorMaterial armorMaterialHazmat;
    private static ArmorMaterial armorMaterialIridium;
    private static ArmorMaterial MAT_ARMOR_LV_CHARGER;
    private static ArmorMaterial MAT_ARMOR_MV_CHARGER;
    private static ArmorMaterial MAT_ARMOR_HV_CHARGER;
    private static ArmorMaterial MAT_ARMOR_EHV_CHARGER;

    // Raw Ore
    public static Item RAW_TIN;
    public static Item RAW_COPPER;
    public static Item IRIDIUM_INGOT;

    // Dust
    public static Item TIN_DUST;
    public static Item COPPER_DUST;
    public static Item BRONZE_DUST;
    public static Item IRON_DUST;
    public static Item GOLD_DUST;
    public static Item COAL_DUST;

    // Ingots
    public static Item TIN_INGOT;
    public static Item COPPER_INGOT;
    public static Item BRONZE_INGOT;
    public static Item ACTIVATED_REDSTONE_INGOT;

    // Plates
    public static Item TIN_PLATE;
    public static Item COPPER_PLATE;
    public static Item BRONZE_PLATE;
    public static Item IRON_PLATE;
    public static Item GOLD_PLATE;
    public static Item STEEL_PLATE;
    public static Item IRIDIUM_PLATE;

    // Cables
    public static Item TIN_CABLE;
    public static Item COPPER_CABLE;
    public static Item GOLD_CABLE;
    public static Item STEEL_CABLE;
    public static Item INSULATED_STEEL_TIN;
    public static Item INSULATED_COPPER_CABLE;
    public static Item INSULATED_GOLD_CABLE;
    public static Item INSULATED_STEEL_CABLE;

    // Tools
    public static Item TOOL_TREETAP;
    public static Item TOOL_HAMMER;
    public static Item TOOL_CUTTERS;
    public static Item TOOL_WRENCH;
    public static Item TOOL_CHAINSAW;
    public static Item TOOL_DRILL;
    public static Item TOOL_GOLDEN_DRILL;
    public static Item TOOL_DIAMOND_DRILL;
    public static Item TOOL_NANOSWORD;
    public static Item TOOL_NANOHOE;
    public static Item TOOL_ELECTRIC_WRENCH;

    // Armor
    public static Item HAZMAT_HELMET;
    public static Item HAZMAT_CHESTPLATE;
    public static Item HAZMAT_LEGGINGS;
    public static Item HAZMAT_BOOTS;
    public static Item IRIDIUM_HELMET;
    public static Item IRIDIUM_CHESTPLATE;
    public static Item IRIDIUM_LEGGINGS;
    public static Item IRIDIUM_BOOTS;

    // Batteries
    public static Item LV_BATTERY;
    public static Item MV_BATTERY;
    public static Item HV_BATTERY;
    public static Item EHV_BATTERY;

    // Cells
    public static Item EMPTY_CELL;
    public static Item WATER_CELL;
    public static Item LAVA_CELL;
    public static Item T1_REDSTONE_CELL;
    public static Item T2_REDSTONE_CELL;
    public static Item T3_REDSTONE_CELL;
    public static Item EMPTY_T1_REDSTONE_CELL;
    public static Item EMPTY_T2_REDSTONE_CELL;
    public static Item COOLANT_CELL;

    // Miscellaneous
    public static Item EMPTY_CAN;
    public static Item FOOD_CAN;
    public static Item RESIN;
    public static Item RUBBER;
    public static Item LV_CIRCUIT;
    public static Item MV_CIRCUIT;
    public static Item SCRAP;

    public static Item PLATE_REACTOR;
    public static Item REACTOR_VENT;

    public static Item IRIDIUM_SCRAP;
    public static Item PLATE_UPGRADE;
    public static Item SPEED_UPGRADE;
    public static Item TRANSFORMER_UPGRADE;
    public static Item ENERGY_UPGRADE;
    public static Item PUSHER_UPGRADE;
    public static Item PULLER_UPGRADE;
    public static Item BLASTING_UPGRADE;

    public static Item JOFFO_CAKES;

    public static Item LV_CHARGER_BLOCK;
    public static Item MV_CHARGER_BLOCK;
    public static Item HV_CHARGER_BLOCK;
    public static Item EHV_CHARGER_BLOCK;

    public static Item LV_CHARGER;
    public static Item MV_CHARGER;
    public static Item HV_CHARGER;
    public static Item EHV_CHARGER;

    private void tagItems() {
        LV_BATTERY.withTags(IndustryTags.PREVENT_ITEM_RECYCLING, IndustryTags.PREVENT_FABRICATING);
        MV_BATTERY.withTags(IndustryTags.PREVENT_ITEM_RECYCLING, IndustryTags.PREVENT_FABRICATING);
        HV_BATTERY.withTags(IndustryTags.PREVENT_ITEM_RECYCLING, IndustryTags.PREVENT_FABRICATING);
        EHV_BATTERY.withTags(IndustryTags.PREVENT_ITEM_RECYCLING, IndustryTags.PREVENT_FABRICATING);
        SCRAP.withTags(IndustryTags.PREVENT_ITEM_RECYCLING, IndustryTags.PREVENT_FABRICATING);
        ACTIVATED_REDSTONE_INGOT.withTags(ItemTags.renderFullbright);
        IRIDIUM_INGOT.withTags(IndustryTags.PREVENT_FABRICATING);
        IRIDIUM_PLATE.withTags(IndustryTags.PREVENT_FABRICATING);
        IRIDIUM_HELMET.withTags(IndustryTags.PREVENT_FABRICATING);
        IRIDIUM_CHESTPLATE.withTags(IndustryTags.PREVENT_FABRICATING);
        IRIDIUM_LEGGINGS.withTags(IndustryTags.PREVENT_FABRICATING);
        IRIDIUM_BOOTS.withTags(IndustryTags.PREVENT_FABRICATING);

        Item.flint.withTags(IndustryTags.PREVENT_ITEM_RECYCLING);
        Item.seedsWheat.withTags(IndustryTags.PREVENT_ITEM_RECYCLING);
        Item.stick.withTags(IndustryTags.PREVENT_ITEM_RECYCLING);
        Item.string.withTags(IndustryTags.PREVENT_ITEM_RECYCLING);
    }

    private void initializeArmorMats() {
        armorMaterialHazmat = ArmorHelper.createArmorMaterial(MOD_ID, "hazmat", 500, 0.0f, 0.0f, 150.0f, 0.0f);
        armorMaterialIridium = ArmorHelper.createArmorMaterial(MOD_ID, "iridium", -1, 100.0f, 100.0f, 100.0f, 100.0f);
        MAT_ARMOR_LV_CHARGER = ArmorHelper.createArmorMaterial(MOD_ID, "charger_lv", -1, 0, 0, 0, 0);
        MAT_ARMOR_MV_CHARGER = ArmorHelper.createArmorMaterial(MOD_ID, "charger_mv", -1, 0, 0, 0, 0);
        MAT_ARMOR_HV_CHARGER = ArmorHelper.createArmorMaterial(MOD_ID, "charger_hv", -1, 0, 0, 0, 0);
        MAT_ARMOR_EHV_CHARGER = ArmorHelper.createArmorMaterial(MOD_ID, "charger_ehv", -1, 0, 0, 0, 0);
    }

    public void initializeItems() {
        initializeArmorMats();

        RAW_TIN = ItemHelper.createItem(MOD_ID,
                new Item("ore.raw.tin", nextItemID("oreRawTin")),
                "raw_tin.png");

        RAW_COPPER = ItemHelper.createItem(MOD_ID,
                new Item("ore.raw.copper", nextItemID("oreRawCopper")),
                "raw_copper.png");

        TIN_DUST = ItemHelper.createItem(MOD_ID,
                new Item("dust.tin", nextItemID("dustTin")),
                "dust_tin.png");

        COPPER_DUST = ItemHelper.createItem(MOD_ID,
                new Item("dust.copper", nextItemID("dustCopper")),
                "dust_copper.png");

        BRONZE_DUST = ItemHelper.createItem(MOD_ID,
                new Item("dust.bronze", nextItemID("dustBronze")),
                "dust_bronze.png");

        IRON_DUST = ItemHelper.createItem(MOD_ID,
                new Item("dust.iron", nextItemID("dustIron")),
                "dust_iron.png");

        GOLD_DUST = ItemHelper.createItem(MOD_ID,
                new Item("dust.gold", nextItemID("dustGold")),
                "dust_gold.png");

        COAL_DUST = ItemHelper.createItem(MOD_ID,
                new Item("dust.coal", nextItemID("dustCoal")),
                "dust_coal.png");

        TIN_INGOT = ItemHelper.createItem(MOD_ID,
                new Item("ingot.tin", nextItemID("ingotTin")),
                "ingot_tin.png");

        COPPER_INGOT = ItemHelper.createItem(MOD_ID,
                new Item("ingot.copper", nextItemID("ingotCopper")),
                "ingot_copper.png");

        BRONZE_INGOT = ItemHelper.createItem(MOD_ID,
                new Item("ingot.bronze", nextItemID("ingotBronze")),
                "ingot_bronze.png");

        ACTIVATED_REDSTONE_INGOT = ItemHelper.createItem(MOD_ID,
                new ItemRadioactive("ingot.redstone", nextItemID("ingotActivatedRedstone")),
                "ingot_activated_redstone.png");

        IRIDIUM_INGOT = ItemHelper.createItem(MOD_ID,
                new Item("ingot.iridium", nextItemID("ingotIridium")),
                "ingot_iridium.png");

        TIN_PLATE = ItemHelper.createItem(MOD_ID,
                new Item("plate.tin", nextItemID("plateTin")),
                "plate_tin.png");

        COPPER_PLATE = ItemHelper.createItem(MOD_ID,
                new Item("plate.copper", nextItemID("plateCopper")),
                "plate_copper.png");

        BRONZE_PLATE = ItemHelper.createItem(MOD_ID,
                new Item("plate.bronze", nextItemID("plateBronze")),
                "plate_bronze.png");

        IRON_PLATE = ItemHelper.createItem(MOD_ID,
                new Item("plate.iron", nextItemID("plateIron")),
                "plate_iron.png");

        GOLD_PLATE = ItemHelper.createItem(MOD_ID,
                new Item("plate.gold", nextItemID("plateGold")),
                "plate_gold.png");

        STEEL_PLATE = ItemHelper.createItem(MOD_ID,
                new Item("plate.steel", nextItemID("plateSteel")),
                "plate_steel.png");

        IRIDIUM_PLATE = ItemHelper.createItem(MOD_ID,
                new Item("plate.iridium", nextItemID("plateIridium")),
                "plate_iridium.png");

        TIN_CABLE = ItemHelper.createItem(MOD_ID,
                new ItemCable("cable.tin", nextItemID("itemCableTin"), I2Blocks.TIN_CABLE),
                "cable_tin.png");

        COPPER_CABLE = ItemHelper.createItem(MOD_ID,
                new ItemCable("cable.copper", nextItemID("itemCableCopper"), I2Blocks.COPPER_CABLE),
                "cable_copper.png");

        GOLD_CABLE = ItemHelper.createItem(MOD_ID,
                new ItemCable("cable.gold", nextItemID("itemCableGold"), I2Blocks.GOLD_CABLE),
                "cable_gold.png");

        STEEL_CABLE = ItemHelper.createItem(MOD_ID,
                new ItemCable("cable.steel", nextItemID("itemCableSteel"), I2Blocks.STEEL_CABLE),
                "cable_steel.png");

        INSULATED_STEEL_TIN = ItemHelper.createItem(MOD_ID,
                new ItemCable("insulated.cable.tin", nextItemID("itemInsulatedCableTin"), I2Blocks.INSULATED_TIN_CABLE),
                "cable_insulated_tin.png");

        INSULATED_COPPER_CABLE = ItemHelper.createItem(MOD_ID,
                new ItemCable("insulated.cable.copper", nextItemID("itemInsulatedCableCopper"), I2Blocks.INSULATED_COPPER_CABLE),
                "cable_insulated_copper.png");

        INSULATED_GOLD_CABLE = ItemHelper.createItem(MOD_ID,
                new ItemCable("insulated.cable.gold", nextItemID("itemInsulatedCableGold"), I2Blocks.INSULATED_GOLD_CABLE),
                "cable_insulated_gold.png");

        INSULATED_STEEL_CABLE = ItemHelper.createItem(MOD_ID,
                new ItemCable("insulated.cable.steel", nextItemID("itemInsulatedCableSteel"), I2Blocks.INSULATED_STEEL_CABLE),
                "cable_insulated_steel.png");

        TOOL_TREETAP = ItemHelper.createItem(MOD_ID,
                new ItemTreetap("tool.treetap", nextItemID("toolTreetap")),
                "tool_treetap.png").setMaxStackSize(1);

        TOOL_HAMMER = ItemHelper.createItem(MOD_ID,
                new ItemTools("tool.hammer", nextItemID("toolHammer")),
                "tool_hammer.png");

        TOOL_CUTTERS = ItemHelper.createItem(MOD_ID,
                new ItemTools("tool.cutters", nextItemID("toolCutters")),
                "tool_cutters.png");

        TOOL_WRENCH = ItemHelper.createItem(MOD_ID,
                new ItemWrench("tool.wrench", nextItemID("toolWrench")),
                "tool_wrench.png").setMaxStackSize(1);

        TOOL_CHAINSAW = ItemHelper.createItem(MOD_ID,
                new ItemToolChainsaw("tool.chainsaw", nextItemID("toolChainsaw")),
                "tool_chainsaw.png");

        TOOL_DRILL = ItemHelper.createItem(MOD_ID,
                new ItemToolDrill("tool.drill", nextItemID("toolDrill"), ToolMaterial.iron),
                "tool_drill.png");

        TOOL_GOLDEN_DRILL = ItemHelper.createItem(MOD_ID,
                new ItemToolDrill("tool.drill.gold", nextItemID("toolDrillGold"), ToolMaterial.gold),
                "tool_drill_gold.png");

        TOOL_DIAMOND_DRILL = ItemHelper.createItem(MOD_ID,
                new ItemToolDrill("tool.drill.diamond", nextItemID("toolDrillDiamond"), ToolMaterial.diamond),
                "tool_drill_diamond.png");

        TOOL_NANOSWORD = ItemHelper.createItem(MOD_ID,
                new ItemToolNanoSword("tool.nanosword", nextItemID("toolNanoSword")));

        TOOL_NANOHOE = ItemHelper.createItem(MOD_ID,
                new ItemToolNanoHoe("tool.nanohoe", nextItemID("")));

        TOOL_ELECTRIC_WRENCH = ItemHelper.createItem(MOD_ID,
                new ItemToolElectricWrench("tool.wrench.electric", nextItemID("")),
                "tool_electric_wrench.png");

        HAZMAT_HELMET = ItemHelper.createItem(MOD_ID,
                new ItemArmor("armor.helmet.hazmat", nextItemID("armorHelmetHazmat"), armorMaterialHazmat, 0),
                "armor_hazmat_helmet.png");

        HAZMAT_CHESTPLATE = ItemHelper.createItem(MOD_ID,
                new ItemArmor("armor.chestplate.hazmat", nextItemID("armorChestplateHazmat"), armorMaterialHazmat, 1),
                "armor_hazmat_chestplate.png");

        HAZMAT_LEGGINGS = ItemHelper.createItem(MOD_ID,
                new ItemArmor("armor.leggings.hazmat", nextItemID("armorLeggingsHazmat"), armorMaterialHazmat, 2),
                "armor_hazmat_leggings.png");

        HAZMAT_BOOTS = ItemHelper.createItem(MOD_ID,
                new ItemArmor("armor.boots.hazmat", nextItemID("armorBootsHazmat"), armorMaterialHazmat, 3),
                "armor_hazmat_boots.png");

        IRIDIUM_HELMET = ItemHelper.createItem(MOD_ID,
                new ItemArmorIridium("armor.helmet.iridium", nextItemID("armorHelmetIridium"), armorMaterialIridium, 0),
                "armor_iridium_helmet.png");

        IRIDIUM_CHESTPLATE = ItemHelper.createItem(MOD_ID,
                new ItemArmorIridium("armor.chestplate.iridium", nextItemID("armorChestplateIridium"), armorMaterialIridium, 1),
                "armor_iridium_chestplate.png");

        IRIDIUM_LEGGINGS = ItemHelper.createItem(MOD_ID,
                new ItemArmorIridium("armor.leggings.iridium", nextItemID("armorLeggingsIridium"), armorMaterialIridium, 2),
                "armor_iridium_leggings.png");

        IRIDIUM_BOOTS = ItemHelper.createItem(MOD_ID,
                new ItemArmorIridium("armor.boots.iridium", nextItemID("armorBootsIridium"), armorMaterialIridium, 3),
                "armor_iridium_boots.png");

        LV_BATTERY = ItemHelper.createItem(MOD_ID,
                new ItemBatteryRedstone("battery.redstone", nextItemID("batteryRedstone")));

        MV_BATTERY = ItemHelper.createItem(MOD_ID,
                new ItemBatteryAdvanced("battery.advanced", nextItemID("batteryAdvanced")));

        HV_BATTERY = ItemHelper.createItem(MOD_ID,
                new ItemBatteryCrystal("battery.crystal", nextItemID("batteryCrystal")));

        EHV_BATTERY = ItemHelper.createItem(MOD_ID,
                new ItemBatteryLapis("battery.lapis", nextItemID("batteryLapis")));

        EMPTY_CELL = ItemHelper.createItem(MOD_ID,
                new ItemCell("cell.empty", nextItemID("cellEmpty")),
                "cell_empty.png");

        WATER_CELL = ItemHelper.createItem(MOD_ID,
                new Item("cell.water", nextItemID("cellWater")),
                "cell_water.png");

        LAVA_CELL = ItemHelper.createItem(MOD_ID,
                new Item("cell.lava", nextItemID("cellLava")),
                "cell_lava.png");

        T1_REDSTONE_CELL = ItemHelper.createItem(MOD_ID,
                new ItemCellRedstoneT1("cell.redstone.t1", nextItemID("cellRedstoneT1")),
                "cell_redstone_t1.png").setMaxStackSize(1);

        T2_REDSTONE_CELL = ItemHelper.createItem(MOD_ID,
                new ItemCellRedstoneT2("cell.redstone.t2", nextItemID("cellRedstoneT2")),
                "cell_redstone_t2.png").setMaxStackSize(1);

        T3_REDSTONE_CELL = ItemHelper.createItem(MOD_ID,
                new ItemCellRedstoneT3("cell.redstone.t3", nextItemID("cellRedstoneT3")),
                "cell_redstone_t3.png").setMaxStackSize(1);

        EMPTY_T1_REDSTONE_CELL = ItemHelper.createItem(MOD_ID,
                new ItemRadioactive("cell.redstone.empty.t1", nextItemID("cellRedstoneT1Empty")),
                "cell_redstone_empty_t1.png").setMaxStackSize(1);

        EMPTY_T2_REDSTONE_CELL = ItemHelper.createItem(MOD_ID,
                new ItemRadioactive("cell.redstone.empty.t2", nextItemID("cellRedstoneT2Empty")),
                "cell_redstone_empty_t2.png").setMaxStackSize(1);

        COOLANT_CELL = ItemHelper.createItem(MOD_ID,
                new ItemCellCoolant("cell.coolant", nextItemID("cellCoolant")),
                "cell_coolant.png").setMaxStackSize(1);

        EMPTY_CAN = ItemHelper.createItem(MOD_ID,
                new Item("can.empty", nextItemID("canEmpty")),
                "can_empty.png");

        FOOD_CAN = ItemHelper.createItem(MOD_ID,
                new ItemFoodStackable("can.food", nextItemID("canFood"), 2, false, 20),
                "can_food.png").setMaxStackSize(10);

        RESIN = ItemHelper.createItem(MOD_ID,
                new Item("resin", nextItemID("resin")),
                "resin.png");

        RUBBER = ItemHelper.createItem(MOD_ID,
                new Item("rubber", nextItemID("rubber")),
                "rubber.png");

        LV_CIRCUIT = ItemHelper.createItem(MOD_ID,
                new Item("circuit", nextItemID("circuitBasic")),
                "circuit.png");

        MV_CIRCUIT = ItemHelper.createItem(MOD_ID,
                new Item("circuitadvanced", nextItemID("circuitAdvanced")),
                "circuit_advanced.png");

        SCRAP = ItemHelper.createItem(MOD_ID,
                new Item("scrap", nextItemID("scrap")),
                "scrap.png");

        PLATE_REACTOR = ItemHelper.createItem(MOD_ID,
                new Item("reactorplate", nextItemID("reactorPlate")),
                "plate_reactor.png");
        REACTOR_VENT = ItemHelper.createItem(MOD_ID,
                new Item("reactorvent", nextItemID("reactorVent")),
                "upgrade_vent.png");

        IRIDIUM_SCRAP = ItemHelper.createItem(MOD_ID,
                new Item("ingot.iridium.scrap", nextItemID("ingotIridiumScrap")),
                "ingot_iridium_scrap.png");

        PLATE_UPGRADE = ItemHelper.createItem(MOD_ID,
                new Item("upgrade.plate", nextItemID("upgradePlate")),
                "plate_upgrade.png");
        SPEED_UPGRADE = ItemHelper.createItem(MOD_ID,
                new Item("upgrade.speed", nextItemID("upgradeSpeed")).setMaxStackSize(4),
                "upgrade_speed.png");
        TRANSFORMER_UPGRADE = ItemHelper.createItem(MOD_ID,
                new Item("upgrade.transformer", nextItemID("upgradeTransformer")).setMaxStackSize(4),
                "upgrade_transformer.png");
        ENERGY_UPGRADE = ItemHelper.createItem(MOD_ID,
                new Item("upgrade.energy", nextItemID("upgradeEnergy")).setMaxStackSize(4),
                "upgrade_energy.png");
        PUSHER_UPGRADE = ItemHelper.createItem(MOD_ID,
                new Item("upgrade.pusher", nextItemID("upgradePusher")).setMaxStackSize(4),
                "upgrade_pusher.png");
        PULLER_UPGRADE = ItemHelper.createItem(MOD_ID,
                new Item("upgrade.puller", nextItemID("upgradePuller")).setMaxStackSize(4),
                "upgrade_puller.png");
        BLASTING_UPGRADE = ItemHelper.createItem(MOD_ID,
                new Item("upgrade.blasting", nextItemID("upgradeBlasting")).setMaxStackSize(4),
                "upgrade_blasting.png");

        JOFFO_CAKES = ItemHelper.createItem(MOD_ID,
                new ItemFoodStackable("food.joffos", nextItemID("foodJoffos"), 1, false, 10),
                "food_joffos.png");

        LV_CHARGER_BLOCK = ItemHelper.createItem(MOD_ID,
                new ItemPlaceable("lv_charger", nextItemID(""), I2Blocks.LV_CHARGER),
                "charger_lv.png");
        MV_CHARGER_BLOCK = ItemHelper.createItem(MOD_ID,
                new ItemPlaceable("mv_charger", nextItemID(""), I2Blocks.MV_CHARGER),
                "charger_mv.png");
        HV_CHARGER_BLOCK = ItemHelper.createItem(MOD_ID,
                new ItemPlaceable("hv_charger", nextItemID(""), I2Blocks.HV_CHARGER),
                "charger_hv.png");
        EHV_CHARGER_BLOCK = ItemHelper.createItem(MOD_ID,
                new ItemPlaceable("ehv_charger", nextItemID(""), I2Blocks.EHV_CHARGER),
                "charger_ehv.png");

        LV_CHARGER = ItemHelper.createItem(MOD_ID,
                new ItemArmorChargerLV("armor_lv_charger", nextItemID(""), MAT_ARMOR_LV_CHARGER, 1),
                "armor_charger_lv.png");
        MV_CHARGER = ItemHelper.createItem(MOD_ID,
                new ItemArmorChargerMV("armor_mv_charger", nextItemID(""), MAT_ARMOR_MV_CHARGER, 1),
                "armor_charger_mv.png");
        HV_CHARGER = ItemHelper.createItem(MOD_ID,
                new ItemArmorChargerHV("armor_hv_charger", nextItemID(""), MAT_ARMOR_HV_CHARGER, 1),
                "armor_charger_hv.png");
        EHV_CHARGER = ItemHelper.createItem(MOD_ID,
                new ItemArmorChargerEHV("armor_ehv_charger", nextItemID(""), MAT_ARMOR_EHV_CHARGER, 1),
                "armor_charger_ehv.png");

        tagItems();
    }
}

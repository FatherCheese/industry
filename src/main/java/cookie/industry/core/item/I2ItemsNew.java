package cookie.industry.core.item;

import cookie.industry.core.I2Config;
import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.item.battery.ItemBatteryEHV;
import cookie.industry.core.item.battery.ItemBatteryHV;
import cookie.industry.core.item.battery.ItemBatteryLV;
import cookie.industry.core.item.battery.ItemBatteryMV;
import cookie.industry.core.item.battery.model.ItemModelBattery;
import cookie.industry.core.item.radioactive.ItemCellRedstoneT1;
import cookie.industry.core.item.radioactive.ItemCellRedstoneT2;
import cookie.industry.core.item.radioactive.ItemCellRedstoneT3;
import cookie.industry.core.item.radioactive.ItemRadioactive;
import cookie.industry.core.item.toolelectric.*;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBed;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.material.ToolMaterial;
import turniplabs.halplibe.helper.ItemBuilder;

import static cookie.industry.Industry2.MOD_ID;

public class I2ItemsNew {

    // MISCELLANEOUS //
    public static Item RAW_TIN;
    public static Item RAW_COPPER;
    public static Item RAW_TITANIUM;
    public static Item EMPTY_CAN;
    public static Item FILLED_CAN;
    public static Item JOFFO_CAKES;
    public static Item LV_CHARGING_PAD;
    public static Item MV_CHARGING_PAD;
    public static Item HV_CHARGING_PAD;
    public static Item EHV_CHARGING_PAD;
    public static Item REACTOR_VENT;

    // DUST //
    public static Item TIN_DUST;
    public static Item COPPER_DUST;
    public static Item BRONZE_DUST;
    public static Item IRON_DUST;
    public static Item GOLD_DUST;
    public static Item COAL_DUST;

    // INGOTS //
    public static Item TIN_INGOT;
    public static Item COPPER_INGOT;
    public static Item BRONZE_INGOT;
    public static Item ACTIVATED_REDSTONE_INGOT;
    public static Item TITANIUM_INGOT;
    public static Item CRUDE_IRIDIUM;
    public static Item IRIDIUM_INGOT;

    // PLATES //
    public static Item TIN_PLATE;
    public static Item COPPER_PLATE;
    public static Item BRONZE_PLATE;
    public static Item IRON_PLATE;
    public static Item GOLD_PLATE;
    public static Item STEEL_PLATE;
    public static Item IRIDIUM_PLATE;
    public static Item UPGRADE_PLATE;
    public static Item REACTOR_PLATE;

    // CABLES //
    public static Item COPPER_CABLE;
    public static Item GOLD_CABLE;
    public static Item STEEL_CABLE;
    public static Item TITANIUM_CABLE;
    public static Item INSULATED_COPPER_CABLE;
    public static Item INSULATED_GOLD_CABLE;
    public static Item INSULATED_STEEL_CABLE;
    public static Item INSULATED_TITANIUM_CABLE;

    // TOOLS //
    public static Item TREETAP;
    public static Item HAMMER;
    public static Item CUTTERS;
    public static Item WRENCH;
    public static Item CHAINSAW;
    public static Item IRON_DRILL;
    public static Item GOLDEN_DRILL;
    public static Item DIAMOND_DRILL;
    public static Item NANOSWORD;
    public static Item NANOHOE;
    public static Item ELECTRIC_TREETAP;
    public static Item ELECTRIC_CUTTERS;
    public static Item ELECTRIC_WRENCH;

    // ARMOR //
    public static Item LV_BATTERY_PACK;
    public static Item MV_BATTERY_PACK;
    public static Item HV_BATTERY_PACK;
    public static Item EHV_BATTERY_PACK;
    public static Item HAZMAT_HELMET;
    public static Item HAZMAT_CHESTPLATE;
    public static Item HAZMAT_LEGGINGS;
    public static Item HAZMAT_BOOTS;
    public static Item ELECTRIC_HAZMAT_HELMET;
    public static Item ELECTRIC_HAZMAT_CHESTPLATE;
    public static Item ELECTRIC_HAZMAT_LEGGINGS;
    public static Item ELECTRIC_HAZMAT_BOOTS;
    public static Item IRIDIUM_HELMET;
    public static Item IRIDIUM_CHESTPLATE;
    public static Item IRIDIUM_LEGGINGS;
    public static Item IRIDIUM_BOOTS;

    // CRAFTING //
    public static Item LV_BATTERY;
    public static Item MV_BATTERY;
    public static Item HV_BATTERY;
    public static Item EHV_BATTERY;
    public static Item LV_CIRCUIT;
    public static Item MV_CIRCUIT;
    public static Item HV_CIRCUIT;
    public static Item EHV_CIRCUIT;
    public static Item RESIN;
    public static Item RUBBER_BALL;
    public static Item SCRAP;
    public static Item BUCKET_OF_OIL;
    public static Item PLASTIC;

    // CELLS //
    public static Item EMPTY_CELL;
    public static Item WATER_CELL;
    public static Item LAVA_CELL;
    public static Item COOLANT_CELL;
    public static Item OIL_CELL;
    public static Item TIER_1_REDSTONE_CELL;
    public static Item TIER_2_REDSTONE_CELL;
    public static Item TIER_3_REDSTONE_CELL;
    public static Item DEPLETED_TIER_1_REDSTONE_CELL;
    public static Item DEPLETED_TIER_2_REDSTONE_CELL;

    // UPGRADES //
    public static Item MACHINE_SPEED_UPGRADE;
    public static Item MACHINE_ENERGY_UPGRADE;
    public static Item MACHINE_BREAKER_UPGRADE;
    public static Item MACHINE_PUSHING_UPGRADE;
    public static Item MACHINE_PULLING_UPGRADE;
    public static Item MACHINE_TRANSFORMER_UPGRADE;
    public static Item MACHINE_BLASTING_UPGRADE;
    public static Item MACHINE_INTERNAL_STORAGE_UPGRADE;

    public static Item ARMOR_HEAT_PROOFING_UPGRADE;
    public static Item ARMOR_SPRINTING_UPGRADE;
    public static Item ARMOR_FALLING_UPGRADE;
    public static Item ARMOR_CROP_WALKING_UPGRADE;

    private static int startingID = I2Config.cfg.getInt("IDs.startingItemID");
    private static int nextID() {
        return ++startingID;
    }

    public static void initializeItems() {
        RAW_TIN = new ItemBuilder(MOD_ID)
                .build(new Item("raw_tin", nextID()));
        RAW_COPPER = new ItemBuilder(MOD_ID)
                .build(new Item("raw_copper", nextID()));
        RAW_TITANIUM = new ItemBuilder(MOD_ID)
                .build(new Item("raw_titanium", nextID()));

        TIN_DUST = new ItemBuilder(MOD_ID)
                .build(new Item("tin_dust", nextID()));
        COPPER_DUST = new ItemBuilder(MOD_ID)
                .build(new Item("copper_dust", nextID()));
        BRONZE_DUST = new ItemBuilder(MOD_ID)
                .build(new Item("bronze_dust", nextID()));
        IRON_DUST = new ItemBuilder(MOD_ID)
                .build(new Item("iron_dust", nextID()));
        GOLD_DUST = new ItemBuilder(MOD_ID)
                .build(new Item("gold_dust", nextID()));
        COAL_DUST = new ItemBuilder(MOD_ID)
                .build(new Item("coal_dust", nextID()));

        TIN_INGOT = new ItemBuilder(MOD_ID)
                .build(new Item("tin_ingot", nextID()));
        COPPER_INGOT = new ItemBuilder(MOD_ID)
                .build(new Item("copper_ingot", nextID()));
        BRONZE_INGOT = new ItemBuilder(MOD_ID)
                .build(new Item("bronze_ingot", nextID()));
        ACTIVATED_REDSTONE_INGOT = new ItemBuilder(MOD_ID)
                .build(new ItemRadioactive("activated_redstone_ingot", nextID()));
        TITANIUM_INGOT = new ItemBuilder(MOD_ID)
                .build(new Item("titanium_ingot", nextID()));
        CRUDE_IRIDIUM = new ItemBuilder(MOD_ID)
                .build(new Item("crude_iridium", nextID()));
        IRIDIUM_INGOT = new ItemBuilder(MOD_ID)
                .build(new Item("iridium_ingot", nextID()));

        TIN_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("tin_plate", nextID()));
        COPPER_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("copper_plate", nextID()));
        BRONZE_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("bronze_plate", nextID()));
        IRON_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("iron_plate", nextID()));
        GOLD_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("gold_plate", nextID()));
        STEEL_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("steel_plate", nextID()));
        IRIDIUM_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("iridium_plate", nextID()));
        UPGRADE_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("upgrade_plate", nextID()));
        REACTOR_PLATE = new ItemBuilder(MOD_ID)
                .build(new Item("reactor_plate", nextID()));

        COPPER_CABLE = new ItemBuilder(MOD_ID)
                .build(new ItemCable("copper_cable", nextID(), I2BlocksNew.COPPER_CABLE));
        GOLD_CABLE = new ItemBuilder(MOD_ID)
                .build(new ItemCable("gold_cable", nextID(), I2BlocksNew.GOLD_CABLE));
        STEEL_CABLE = new ItemBuilder(MOD_ID)
                .build(new ItemCable("steel_cable", nextID(), I2BlocksNew.STEEL_CABLE));
        TITANIUM_CABLE = new ItemBuilder(MOD_ID)
                .build(new ItemCable("titanium_cable", nextID(), I2BlocksNew.TITANIUM_CABLE));
        INSULATED_COPPER_CABLE = new ItemBuilder(MOD_ID)
                .build(new ItemCable("insulated_copper_cable", nextID(), I2BlocksNew.INSULATED_COPPER_CABLE));
        INSULATED_GOLD_CABLE = new ItemBuilder(MOD_ID)
                .build(new ItemCable("insulated_gold_cable", nextID(), I2BlocksNew.INSULATED_GOLD_CABLE));
        INSULATED_STEEL_CABLE = new ItemBuilder(MOD_ID)
                .build(new ItemCable("insulated_steel_cable", nextID(), I2BlocksNew.INSULATED_STEEL_CABLE));
        INSULATED_TITANIUM_CABLE = new ItemBuilder(MOD_ID)
                .build(new ItemCable("insulated_titanium_cable", nextID(), I2BlocksNew.INSULATED_TITANIUM_CABLE));

        TREETAP = new ItemBuilder(MOD_ID)
                .build(new ItemTreetap("treetap", nextID()));
        HAMMER = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new Item("hammer", nextID()));
        CUTTERS = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemCutters("cutters", nextID()));
        WRENCH = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemWrench("wrench", nextID()));
        CHAINSAW = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemToolChainsaw("chainsaw", nextID()));
        IRON_DRILL = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemToolDrill("iron_drill", nextID(), ToolMaterial.iron));
        GOLDEN_DRILL = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemToolDrill("gold_drill", nextID(), ToolMaterial.gold));
        DIAMOND_DRILL = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemToolDrill("diamond_drill", nextID(), ToolMaterial.diamond));
        NANOSWORD = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemToolNanoSword("nanosword", nextID()));
        NANOHOE = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemToolNanoHoe("nanohoe", nextID()));
        ELECTRIC_TREETAP = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new Item("electric_treetap", nextID()));
        ELECTRIC_CUTTERS = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new Item("electric_cutters", nextID()));
        ELECTRIC_WRENCH = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelStandard(item, null).setRotateWhenRendering().setFull3D())
                .setStackSize(1)
                .build(new ItemToolElectricWrench("electric_wrench", nextID()));

        // TODO - Armor Mats
        // TODO - Electric Hazmat Stuff
 /*
        LV_BATTERY_PACK = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("lv_battery_pack", nextID(), "", 1));
        MV_BATTERY_PACK = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("mv_battery_pack", nextID(), "", 1));
        HV_BATTERY_PACK = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("hv_battery_pack", nextID(), "", 1));
        EHV_BATTERY_PACK = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("ehv_battery_pack", nextID(), "", 1));

        HAZMAT_HELMET = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("hazmat_helmet", nextID(), "", 0));
        HAZMAT_CHESTPLATE = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("hazmat_chestplate", nextID(), "", 1));
        HAZMAT_LEGGINGS = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("hazmat_leggings", nextID(), "", 2));
        HAZMAT_BOOTS = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("hazmat_boots", nextID(), "", 3));

        ELECTRIC_HAZMAT_HELMET = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("electric_hazmat_helmet", nextID(), "", 0));
        ELECTRIC_HAZMAT_CHESTPLATE = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("electric_hazmat_chestplate", nextID(), "", 1));
        ELECTRIC_HAZMAT_LEGGINGS = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("electric_hazmat_leggings", nextID(), "", 2));
        ELECTRIC_HAZMAT_BOOTS = new ItemBuilder(MOD_ID)
                .build(new ItemArmor("electric_hazmat_boots", nextID(), "", 3));

        IRIDIUM_HELMET = new ItemBuilder(MOD_ID)
                .build(new ItemArmorIridium("iridium_helmet", nextID(), "", 0));
        IRIDIUM_CHESTPLATE = new ItemBuilder(MOD_ID)
                .build(new ItemArmorIridium("iridium_chestplate", nextID(), "", 1));
        IRIDIUM_LEGGINGS = new ItemBuilder(MOD_ID)
                .build(new ItemArmorIridium("iridium_leggings", nextID(), "", 2));
        IRIDIUM_BOOTS = new ItemBuilder(MOD_ID)
                .build(new ItemArmorIridium("iridium_boots", nextID(), "", 3));
                */

        LV_BATTERY = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelBattery(item, MOD_ID))
                .build(new ItemBatteryLV("lv_battery", nextID()));
        MV_BATTERY = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelBattery(item, MOD_ID))
                .build(new ItemBatteryMV("mv_battery", nextID()));
        HV_BATTERY = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelBattery(item, MOD_ID))
                .build(new ItemBatteryHV("hv_battery", nextID()));
        EHV_BATTERY = new ItemBuilder(MOD_ID)
                .setItemModel(item -> new ItemModelBattery(item, MOD_ID))
                .build(new ItemBatteryEHV("ehv_battery", nextID()));
        LV_CIRCUIT = new ItemBuilder(MOD_ID)
                .build(new Item("lv_circuit", nextID()));
        MV_CIRCUIT = new ItemBuilder(MOD_ID)
                .build(new Item("mv_circuit", nextID()));
        HV_CIRCUIT = new ItemBuilder(MOD_ID)
                .build(new Item("hv_circuit", nextID()));
        EHV_CIRCUIT = new ItemBuilder(MOD_ID)
                .build(new Item("ehv_circuit", nextID()));
        RESIN = new ItemBuilder(MOD_ID)
                .build(new Item("resin", nextID()));
        RUBBER_BALL = new ItemBuilder(MOD_ID)
                .build(new Item("rubber_ball", nextID()));

        BUCKET_OF_OIL = new ItemBuilder(MOD_ID)
                .build(new Item("bucket_of_oil", nextID()));

        EMPTY_CELL = new ItemBuilder(MOD_ID)
                .build(new ItemCell("empty_cell", nextID()));
        WATER_CELL = new ItemBuilder(MOD_ID)
                .build(new Item("water_cell", nextID()));
        LAVA_CELL = new ItemBuilder(MOD_ID)
                .build(new Item("lava_cell", nextID()));
        COOLANT_CELL = new ItemBuilder(MOD_ID)
                .build(new ItemCellCoolant("coolant_cell", nextID()));
        OIL_CELL = new ItemBuilder(MOD_ID)
                .build(new ItemCell("oil_cell", nextID()));
        TIER_1_REDSTONE_CELL = new ItemBuilder(MOD_ID)
                .build(new ItemCellRedstoneT1("tier_1_redstone_cell", nextID()));
        TIER_2_REDSTONE_CELL = new ItemBuilder(MOD_ID)
                .build(new ItemCellRedstoneT2("tier_2_redstone_cell", nextID()));
        TIER_3_REDSTONE_CELL = new ItemBuilder(MOD_ID)
                .build(new ItemCellRedstoneT3("tier_3_redstone_cell", nextID()));
        DEPLETED_TIER_1_REDSTONE_CELL = new ItemBuilder(MOD_ID)
                .build(new Item("depleted_tier_1_redstone_cell", nextID()));
        DEPLETED_TIER_2_REDSTONE_CELL = new ItemBuilder(MOD_ID)
                .build(new Item("depleted_tier_2_redstone_cell", nextID()));

        // TODO - Block refactor for the charging pad items.
/*
        LV_CHARGING_PAD = new ItemBuilder(MOD_ID)
                .build(new ItemPlaceable("lv_charging_pad", nextID(), ""));
        MV_CHARGING_PAD = new ItemBuilder(MOD_ID)
                .build(new ItemPlaceable("mv_charging_pad", nextID(), ""));
        HV_CHARGING_PAD = new ItemBuilder(MOD_ID)
                .build(new ItemPlaceable("hv_charging_pad", nextID(), ""));
        EHV_CHARGING_PAD = new ItemBuilder(MOD_ID)
                .build(new ItemPlaceable("ehv_charging_pad", nextID(), ""));
                */

        // TODO - Armor upgrades
        MACHINE_SPEED_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("machine_speed_upgrade", nextID()));
        MACHINE_ENERGY_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("machine_energy_upgrade", nextID()));
        MACHINE_BREAKER_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("machine_breaker_upgrade", nextID()));
        MACHINE_PUSHING_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("machine_pushing_upgrade", nextID()));
        MACHINE_PULLING_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("machine_pulling_upgrade", nextID()));
        MACHINE_TRANSFORMER_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("machine_transformer_upgrade", nextID()));
        MACHINE_BLASTING_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("machine_blasting_upgrade", nextID()));
        ARMOR_HEAT_PROOFING_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("armor_heat_proofing_upgrade", nextID()));
        ARMOR_SPRINTING_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("armor_sprinting_upgrade", nextID()));
        ARMOR_FALLING_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("armor_falling_upgrade", nextID()));
        ARMOR_CROP_WALKING_UPGRADE = new ItemBuilder(MOD_ID)
                .build(new Item("armor_crop_walking_upgrade", nextID()));

        EMPTY_CAN = new ItemBuilder(MOD_ID)
                .build(new Item("empty_can", nextID()));
        FILLED_CAN = new ItemBuilder(MOD_ID)
                .build(new ItemFood("filled_can", nextID(), 2, 20, false, 20));
        JOFFO_CAKES = new ItemBuilder(MOD_ID)
                .build(new ItemFood("joffo_cakes", nextID(), 1, 0, false, 16));

        REACTOR_VENT = new ItemBuilder(MOD_ID)
                .build(new Item("reactor_vent", nextID()));
        SCRAP = new ItemBuilder(MOD_ID)
                .build(new ItemScrap("scrap", nextID()));
    }
}

package cookie.industry.recipe;

import cookie.industry.block.I2Blocks;
import cookie.industry.item.I2Items;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import sunsetsatellite.catalyst.energy.api.LookupFuelEnergy;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBlastFurnace;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderFurnace;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShapeless;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static cookie.industry.Industry2.MOD_ID;

public class I2Recipes implements RecipeEntrypoint {
    public static final RecipeNamespace INDUSTRY = new RecipeNamespace();
    public static final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));

    private void initializeItemRecipes() {
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.COPPER_DUST)
                .addInput(I2Items.COPPER_DUST)
                .addInput(I2Items.COPPER_DUST)
                .addInput(I2Items.TIN_DUST)
                .create("bronze_dust_from_dusts", new ItemStack(I2Items.BRONZE_DUST, 4));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Blocks.BLOCK_OF_TIN)
                .create("tin_ingot_from_block", new ItemStack(I2Items.TIN_INGOT, 9));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Blocks.BLOCK_OF_COPPER)
                .create("copper_ingot_from_block", new ItemStack(I2Items.COPPER_INGOT, 9));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Blocks.BLOCK_OF_BRONZE)
                .create("bronze_ingot_from_block", new ItemStack(I2Items.BRONZE_INGOT, 9));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_HAMMER)
                .addInput(I2Items.TIN_INGOT)
                .create("tin_plate_from_hammer", I2Items.TIN_PLATE.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_HAMMER)
                .addInput(I2Items.COPPER_INGOT)
                .create("copper_plate_from_hammer", I2Items.COPPER_PLATE.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_HAMMER)
                .addInput(I2Items.BRONZE_INGOT)
                .create("bronze_plate_from_hammer", I2Items.BRONZE_PLATE.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_HAMMER)
                .addInput(Item.ingotIron)
                .create("iron_plate_from_hammer", I2Items.TIN_PLATE.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_HAMMER)
                .addInput(Item.ingotGold)
                .create("gold_plate_from_hammer", I2Items.GOLD_PLATE.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_HAMMER)
                .addInput(Item.ingotSteel)
                .create("steel_plate_from_hammer", I2Items.STEEL_PLATE.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_CUTTERS)
                .addInput(I2Items.TIN_INGOT)
                .create("tin_cable_from_cutters", new ItemStack(I2Items.TIN_CABLE, 2));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_CUTTERS)
                .addInput(I2Items.COPPER_INGOT)
                .create("copper_cable_from_cutters", new ItemStack(I2Items.COPPER_CABLE, 2));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_CUTTERS)
                .addInput(Item.ingotGold)
                .create("gold_cable_from_cutters", new ItemStack(I2Items.GOLD_CABLE, 2));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_CUTTERS)
                .addInput(Item.ingotSteel)
                .create("steel_cable_from_cutters", new ItemStack(I2Items.STEEL_CABLE, 2));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.RUBBER)
                .addInput(I2Items.TIN_CABLE)
                .create("insulated_tin_cable", new ItemStack(I2Items.INSULATED_STEEL_TIN.getDefaultStack()));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.RUBBER)
                .addInput(I2Items.COPPER_CABLE)
                .create("insulated_copper_cable", new ItemStack(I2Items.INSULATED_COPPER_CABLE.getDefaultStack()));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.RUBBER)
                .addInput(I2Items.GOLD_CABLE)
                .create("insulated_gold_cable", new ItemStack(I2Items.INSULATED_GOLD_CABLE.getDefaultStack()));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.RUBBER)
                .addInput(I2Items.STEEL_CABLE)
                .create("insulated_steel_cable", new ItemStack(I2Items.INSULATED_STEEL_CABLE.getDefaultStack()));

        new RecipeBuilderShaped(MOD_ID, "111", "121", " 2 ")
                .addInput('1', Item.ingotIron)
                .addInput('2', Item.stick)
                .create("hammer", I2Items.TOOL_HAMMER.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", " 1 ", "2 2")
                .addInput('1', I2Items.IRON_PLATE)
                .addInput('2', Item.ingotIron)
                .create("cutters", I2Items.TOOL_CUTTERS.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", "111", " 1 ")
                .addInput('1', I2Items.BRONZE_PLATE)
                .create("wrench", I2Items.TOOL_WRENCH.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", "232")
                .addInput('1', I2Items.INSULATED_STEEL_TIN)
                .addInput('2', I2Items.TIN_PLATE)
                .addInput('3', Item.dustRedstone)
                .create("lv_battery", I2Items.LV_BATTERY.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", "242")
                .addInput('1', I2Items.INSULATED_COPPER_CABLE)
                .addInput('2', I2Items.BRONZE_PLATE)
                .addInput('3', Item.sulphur)
                .addInput('4', Item.dustRedstone)
                .create("mv_battery_1", I2Items.MV_BATTERY.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", "242")
                .addInput('1', I2Items.INSULATED_COPPER_CABLE)
                .addInput('2', I2Items.BRONZE_PLATE)
                .addInput('3', Item.dustRedstone)
                .addInput('4', Item.sulphur)
                .create("mv_battery_2", I2Items.MV_BATTERY.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "232", "121")
                .addInput('1', I2Items.INSULATED_GOLD_CABLE)
                .addInput('2', Item.dustRedstone)
                .addInput('3', Item.diamond)
                .create("hv_battery", I2Items.HV_BATTERY.getDefaultStack());

        // TODO - Change this to an HV circuit
        new RecipeBuilderShaped(MOD_ID, "121", "343", "121")
                .addInput('1', I2Items.INSULATED_STEEL_CABLE)
                .addInput('2', new ItemStack(Item.dye, 1, 4))
                .addInput('3', I2Items.MV_CIRCUIT)
                .addInput('4', Item.diamond)
                .create("ehv_battery", I2Items.EHV_BATTERY.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "1 1", " 1 ")
                .addInput('1', I2Items.TIN_INGOT)
                .create("empty_cell", new ItemStack(I2Items.EMPTY_CELL, 4));

        new RecipeBuilderShaped(MOD_ID, "1 1", " 1 ")
                .addInput('1', I2Items.TIN_INGOT)
                .create("empty_can", new ItemStack(I2Items.EMPTY_CAN, 3));

        new RecipeBuilderShaped(MOD_ID, "111", "232", "111")
                .addInput('1', I2Items.INSULATED_COPPER_CABLE)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Items.IRON_PLATE)
                .create("lv_circuit", I2Items.LV_CIRCUIT.getDefaultStack());

        // TODO - Change this to plastic (or make HV circuits use it)
        new RecipeBuilderShaped(MOD_ID, "111", "234", "111")
                .addInput('1', I2Items.INSULATED_GOLD_CABLE)
                .addInput('2', Item.quartz)
                .addInput('3', I2Items.STEEL_PLATE)
                .addInput('4', Item.dustRedstone)
                .create("mv_circuit", I2Items.MV_CIRCUIT.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 11", "231", "42 ")
                .addInput('1', I2Items.IRON_PLATE)
                .addInput('2', I2Items.BRONZE_INGOT)
                .addInput('3', I2Items.LV_CIRCUIT)
                .addInput('4', I2Items.LV_BATTERY)
                .create("chainsaw", I2Items.TOOL_CHAINSAW.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121", "343")
                .addInput('1', I2Items.IRON_PLATE)
                .addInput('2', I2Items.LV_CIRCUIT)
                .addInput('3', I2Items.BRONZE_INGOT)
                .addInput('4', I2Items.LV_BATTERY)
                .create("drill_iron", I2Items.TOOL_DRILL.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121")
                .addInput('1', Item.ingotGold)
                .addInput('2', I2Items.TOOL_DRILL)
                .create("drill_gold", I2Items.TOOL_GOLDEN_DRILL.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121")
                .addInput('1', Item.diamond)
                .addInput('2', I2Items.TOOL_DRILL)
                .create("drill_diamond", I2Items.TOOL_DIAMOND_DRILL.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", " 2 ", "343")
                .addInput('1', Item.quartz)
                .addInput('2', Item.dustGlowstone)
                .addInput('3', I2Items.STEEL_PLATE)
                .addInput('4', I2Items.HV_BATTERY)
                .create("nanosword", I2Items.TOOL_NANOSWORD.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "12 ", " 3 ", " 4 ")
                .addInput('1', Item.quartz)
                .addInput('2', Item.dustGlowstone)
                .addInput('3', I2Items.HV_BATTERY)
                .addInput('4', I2Items.STEEL_PLATE)
                .create("nanohoe", I2Items.TOOL_NANOHOE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", "121", " 3 ")
                .addInput('1', I2Items.IRON_PLATE)
                .addInput('2', I2Items.BRONZE_INGOT)
                .addInput('3', I2Items.LV_BATTERY)
                .create("electric_wrench", I2Items.TOOL_ELECTRIC_WRENCH.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "111", "121", " 3 ")
                .addInput('1', I2Items.RUBBER)
                .addInput('2', Block.glass)
                .addInput('3', new ItemStack(Item.dye, 1, 11))
                .create("armor_helmet_hazmat", I2Items.HAZMAT_HELMET.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "121", "111", "111")
                .addInput('1', I2Items.RUBBER)
                .addInput('2', new ItemStack(Item.dye, 1, 11))
                .create("armor_chestplate_hazmat", I2Items.HAZMAT_CHESTPLATE.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "111", "121", "1 1")
                .addInput('1', I2Items.RUBBER)
                .addInput('2', new ItemStack(Item.dye, 1, 11))
                .create("armor_leggings_hazmat", I2Items.HAZMAT_LEGGINGS.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "1 1")
                .addInput('1', I2Items.RUBBER)
                .create("armor_boots_hazmat", I2Items.HAZMAT_BOOTS.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "131")
                .addInput('1', I2Items.IRIDIUM_INGOT)
                .addInput('2', I2Items.EHV_BATTERY)
                .addInput('3', Block.glassTinted)
                .create("armor_helmet_iridium", I2Items.IRIDIUM_HELMET.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "121", "111")
                .addInput('1', I2Items.IRIDIUM_INGOT)
                .addInput('2', I2Items.EHV_BATTERY)
                .create("armor_chestplate_iridium", I2Items.IRIDIUM_CHESTPLATE.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "111", "2 2", "1 1")
                .addInput('1', I2Items.IRIDIUM_INGOT)
                .addInput('2', I2Items.EHV_BATTERY)
                .create("armor_leggings_iridium", I2Items.IRIDIUM_LEGGINGS.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "2 2")
                .addInput('1', I2Items.IRIDIUM_INGOT)
                .addInput('2', I2Items.EHV_BATTERY)
                .create("armor_boots_iridium", I2Items.IRIDIUM_BOOTS.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.STEEL_PLATE)
                .addInput(I2Items.STEEL_PLATE)
                .create("reactor_plate_from_plates", I2Items.PLATE_REACTOR.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_HAMMER)
                .addInput(Item.ingotSteel)
                .addInput(Item.ingotSteel)
                .create("reactor_plate_from_hammer", I2Items.PLATE_REACTOR.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_CUTTERS)
                .addInput(I2Items.PLATE_REACTOR)
                .create("reactor_vent", I2Items.REACTOR_VENT.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.IRON_PLATE)
                .addInput(I2Items.IRON_PLATE)
                .create("upgrade_plate_from_plates", I2Items.PLATE_UPGRADE.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.TOOL_HAMMER)
                .addInput(Item.ingotIron)
                .addInput(Item.ingotIron)
                .create("upgrade_plate_from_hammer", I2Items.PLATE_UPGRADE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121", " 3 ")
                .addInput('1', I2Items.COOLANT_CELL)
                .addInput('2', I2Items.PLATE_UPGRADE)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("speed_upgrade", I2Items.SPEED_UPGRADE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 2", " 3 ", "456")
                .addInput('1', I2Items.INSULATED_COPPER_CABLE)
                .addInput('2', I2Items.INSULATED_GOLD_CABLE)
                .addInput('3', I2Items.PLATE_UPGRADE)
                .addInput('4', I2Items.INSULATED_STEEL_CABLE)
                .addInput('5', I2Items.LV_CIRCUIT)
                .addInput('6', I2Items.INSULATED_STEEL_TIN)
                .create("transformer_upgrade", I2Items.TRANSFORMER_UPGRADE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', I2Items.LV_BATTERY)
                .addInput('2', I2Items.PLATE_UPGRADE)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("energy_upgrade", I2Items.ENERGY_UPGRADE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', Block.pistonBaseSticky)
                .addInput('2', I2Items.PLATE_UPGRADE)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("puller_upgrade", I2Items.PULLER_UPGRADE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', Block.pistonBase)
                .addInput('2', I2Items.PLATE_UPGRADE)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("pusher_upgrade", I2Items.PUSHER_UPGRADE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121", " 3 ")
                .addInput('1', Item.nethercoal)
                .addInput('2', I2Items.PLATE_UPGRADE)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("blasting_upgrade", I2Items.BLASTING_UPGRADE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", " 1 ")
                .addInput('1', new ItemStack(Item.dye, 1, 3))
                .addInput('2', Item.wheat)
                .addInput('3', Block.pumpkin)
                .create("joffo_cake", I2Items.JOFFO_CAKES.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "111", "232", "111")
                .addInput('1', "minecraft:planks")
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Items.LV_BATTERY)
                .create("lv_charger", I2Items.LV_CHARGER_BLOCK.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "111", "232", "111")
                .addInput('1', I2Items.BRONZE_PLATE)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Items.MV_BATTERY)
                .create("mv_charger", I2Items.MV_CHARGER_BLOCK.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "111", "232", "111")
                .addInput('1', I2Items.IRON_PLATE)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Items.HV_BATTERY)
                .create("hv_charger", I2Items.HV_CHARGER_BLOCK.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "111", "232", "111")
                .addInput('1', I2Items.STEEL_PLATE)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Items.EHV_BATTERY)
                .create("ehv_charger", I2Items.EHV_CHARGER_BLOCK.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", "212", "1 1")
                .addInput('1', Item.cloth)
                .addInput('2', I2Items.LV_BATTERY)
                .create("lv_charging_pack", I2Items.LV_CHARGER.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "212", "1 1")
                .addInput('1', Item.cloth)
                .addInput('2', I2Items.MV_BATTERY)
                .create("mv_charging_pack", I2Items.MV_CHARGER.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "212", "1 1")
                .addInput('1', Item.cloth)
                .addInput('2', I2Items.HV_BATTERY)
                .create("hv_charging_pack", I2Items.HV_CHARGER.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "212", "1 1")
                .addInput('1', Item.cloth)
                .addInput('2', I2Items.EHV_BATTERY)
                .create("ehv_charging_pack", I2Items.EHV_CHARGER.getDefaultStack());
    }

    private void initializeBlockRecipes() {
        RecipeBuilderShaped templateIngotBlock = new RecipeBuilderShaped(MOD_ID, "111", "111", "111");
        RecipeBuilderShaped templateCasing = new RecipeBuilderShaped(MOD_ID, "111", "121", "111");
        RecipeBuilderShaped templateSolar = new RecipeBuilderShaped(MOD_ID, "111", "121", "111");
        RecipeBuilderShaped templateBatbox = new RecipeBuilderShaped(MOD_ID, "121", "333", "111");
        RecipeBuilderShaped templateTransformer = new RecipeBuilderShaped(MOD_ID, "121", "134", "454");
        RecipeBuilderShaped templateMachineFurnace = new RecipeBuilderShaped(MOD_ID, " 1 ", "232", " 4 ");

        templateIngotBlock
                .addInput('1', I2Items.TIN_INGOT)
                .create("tin_block_from_ingot", I2Blocks.BLOCK_OF_TIN.getDefaultStack());
        templateIngotBlock
                .addInput('1', I2Items.COPPER_INGOT)
                .create("copper_block_from_ingot", I2Blocks.BLOCK_OF_COPPER.getDefaultStack());
        templateIngotBlock
                .addInput('1', I2Items.BRONZE_INGOT)
                .create("bronze_block_from_ingot", I2Blocks.BLOCK_OF_BRONZE.getDefaultStack());

        // TODO - Change 2nd tier, redstone/bronze/MV
        // TODO - Add 3rd tier, oil/steel/HV
        templateCasing
                .addInput('1', I2Items.IRON_PLATE)
                .addInput('2', I2Items.LV_BATTERY)
                .create("lv_machine_casing", I2Blocks.LV_MACHINE_CASING.getDefaultStack());
        templateCasing
                .addInput('1', I2Items.STEEL_PLATE)
                .addInput('2', I2Items.MV_BATTERY)
                .create("mv_machine_casing", I2Blocks.MV_MACHINE_CASING.getDefaultStack());
        templateCasing
                .addInput('1', I2Items.PLATE_REACTOR)
                .addInput('2', I2Items.EHV_BATTERY)
                .create("ehv_machine_casing", I2Blocks.EHV_MACHINE_CASING.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2")
                .addInput('1', I2Blocks.LV_MACHINE_CASING)
                .addInput('2', Block.furnaceStoneIdle)
                .create("lv_generator", I2Blocks.LV_GENERATOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "232", "121")
                .addInput('1', Item.stick)
                .addInput('2', "minecraft:planks")
                .addInput('3', I2Blocks.LV_GENERATOR)
                .create("lv_generator_watermill", I2Blocks.LV_WATERMILL.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121", " 1 ")
                .addInput('1', I2Blocks.BLOCK_OF_TIN)
                .addInput('2', I2Blocks.LV_GENERATOR)
                .create("lv_generator_windmill", I2Blocks.LV_WINDMILL.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "121", "343")
                .addInput('1', Block.glass)
                .addInput('2', I2Items.EMPTY_CELL)
                .addInput('3', I2Items.STEEL_PLATE)
                .addInput('4', I2Blocks.LV_GENERATOR)
                .create("lv_generator_geothermal", I2Blocks.LV_GEOTHERMAL_GENERATOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "212", "343")
                .addInput('1', I2Items.COAL_DUST)
                .addInput('2', Block.glassTinted)
                .addInput('3', I2Items.LV_CIRCUIT)
                .addInput('4', I2Blocks.LV_GENERATOR)
                .create("ulv_generator_solar_1", I2Blocks.ULV_SOLAR_PANEL.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "212", "343")
                .addInput('1', Block.glassTinted)
                .addInput('2', I2Items.COAL_DUST)
                .addInput('3', I2Items.LV_CIRCUIT)
                .addInput('4', I2Blocks.LV_GENERATOR)
                .create("ulv_generator_solar_2", I2Blocks.ULV_SOLAR_PANEL.getDefaultStack());

        templateSolar
                .addInput('1', I2Blocks.ULV_SOLAR_PANEL)
                .addInput('2', I2Blocks.LV_BATBOX)
                .create("lv_generator_solar", I2Blocks.LV_SOLAR_ARRAY.getDefaultStack());

        templateSolar
                .addInput('1', I2Blocks.LV_SOLAR_ARRAY)
                .addInput('2', I2Blocks.MV_BATBOX)
                .create("mv_generator_solar", I2Blocks.MV_SOLAR_ARRAY.getDefaultStack());

        templateSolar
                .addInput('1', I2Blocks.MV_SOLAR_ARRAY)
                .addInput('2', I2Blocks.HV_BATBOX)
                .create("hv_generator_solar", I2Blocks.HV_SOLAR_ARRAY.getDefaultStack());

        templateSolar
                .addInput('1', I2Blocks.HV_SOLAR_ARRAY)
                .addInput('2', I2Blocks.EHV_BATBOX)
                .create("ehv_generator_solar", I2Blocks.EHV_SOLAR_ARRAY.getDefaultStack());

        templateBatbox
                .addInput('1', "minecraft:planks")
                .addInput('2', I2Items.INSULATED_STEEL_TIN)
                .addInput('3', I2Items.LV_BATTERY)
                .create("lv_batbox", I2Blocks.LV_BATBOX.getDefaultStack());

        templateBatbox
                .addInput('1', I2Items.BRONZE_PLATE)
                .addInput('2', I2Items.INSULATED_COPPER_CABLE)
                .addInput('3', I2Items.MV_BATTERY)
                .create("mv_batbox", I2Blocks.MV_BATBOX.getDefaultStack());

        templateBatbox
                .addInput('1', I2Items.IRON_PLATE)
                .addInput('2', I2Items.INSULATED_GOLD_CABLE)
                .addInput('3', I2Items.HV_BATTERY)
                .create("hv_batbox", I2Blocks.HV_BATBOX.getDefaultStack());

        templateBatbox
                .addInput('1', I2Items.STEEL_PLATE)
                .addInput('2', I2Items.INSULATED_STEEL_CABLE)
                .addInput('3', I2Items.EHV_BATTERY)
                .create("ehv_batbox", I2Blocks.EHV_BATBOX.getDefaultStack());

        templateTransformer
                .addInput('1', I2Items.BRONZE_PLATE)
                .addInput('2', I2Items.INSULATED_COPPER_CABLE)
                .addInput('3', I2Items.LV_BATTERY)
                .addInput('4', "minecraft:planks")
                .addInput('5', I2Items.INSULATED_STEEL_TIN)
                .create("mv_to_lv_transformer", I2Blocks.MV_TO_LV_TRANSFORMER.getDefaultStack());

        templateTransformer
                .addInput('1', I2Items.IRON_PLATE)
                .addInput('2', I2Items.INSULATED_GOLD_CABLE)
                .addInput('3', I2Items.MV_BATTERY)
                .addInput('4', I2Items.BRONZE_PLATE)
                .addInput('5', I2Items.INSULATED_COPPER_CABLE)
                .create("hv_to_mv_transformer", I2Blocks.HV_TO_MV_TRANSFORMER.getDefaultStack());

        templateTransformer
                .addInput('1', I2Items.STEEL_PLATE)
                .addInput('2', I2Items.INSULATED_STEEL_CABLE)
                .addInput('3', I2Items.HV_BATTERY)
                .addInput('4', I2Items.IRON_PLATE)
                .addInput('5', I2Items.INSULATED_GOLD_CABLE)
                .create("ehv_to_hv_transformer", I2Blocks.EHV_TO_HV_TRANSFORMER.getDefaultStack());

        templateMachineFurnace
                .addInput('1', I2Items.LV_CIRCUIT)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Blocks.LV_MACHINE_CASING)
                .addInput('4', Block.furnaceStoneIdle)
                .create("lv_machine_furnace", I2Blocks.LV_ELECTRIC_FURNACE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "111", "232", " 4 ")
                .addInput('1', Item.flint)
                .addInput('2', "minecraft:cobblestones")
                .addInput('3', I2Blocks.LV_MACHINE_CASING)
                .addInput('4', I2Items.LV_CIRCUIT)
                .create("lv_machine_macerator", I2Blocks.LV_MACERATOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", "121", "131")
                .addInput('1', "minecraft:stones")
                .addInput('2', I2Blocks.LV_MACHINE_CASING)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("lv_machine_compressor", I2Blocks.LV_COMPRESSOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", "121", " 3 ")
                .addInput('1', Item.ingotIron)
                .addInput('2', I2Blocks.LV_MACHINE_CASING)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("lv_machine_wiremill", I2Blocks.LV_WIREMILL.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "131")
                .addInput('1', I2Items.TOOL_TREETAP)
                .addInput('2', I2Blocks.LV_MACHINE_CASING)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("lv_machine_extractor", I2Blocks.LV_EXTRACTOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232")
                .addInput('1', I2Items.LV_CIRCUIT)
                .addInput('2', Block.dirt)
                .addInput('3', I2Blocks.LV_MACHINE_CASING)
                .create("lv_machine_recycler", I2Blocks.LV_RECYCLER.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', I2Blocks.LV_MACHINE_CASING)
                .addInput('2', Block.trommelIdle)
                .addInput('3', I2Items.LV_CIRCUIT)
                .create("lv_machine_trommel", I2Blocks.LV_ELECTRIC_TROMMEL.getDefaultStack());

        templateMachineFurnace
                .addInput('1', I2Items.MV_CIRCUIT)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Blocks.MV_MACHINE_CASING)
                .addInput('4', Block.furnaceStoneIdle)
                .create("mv_machine_furnace", I2Blocks.MV_ELECTRIC_FURNACE.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', Block.spikes)
                .addInput('2', I2Blocks.MV_MACHINE_CASING)
                .addInput('3', I2Items.MV_CIRCUIT)
                .create("mv_machine_macerator", I2Blocks.MV_MACERATOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", " 3 ")
                .addInput('1', Block.obsidian)
                .addInput('2', I2Blocks.MV_MACHINE_CASING)
                .addInput('3', I2Items.MV_CIRCUIT)
                .create("mv_machine_compressor", I2Blocks.MV_COMPRESSOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', Item.quartz)
                .addInput('2', I2Blocks.MV_MACHINE_CASING)
                .addInput('3', I2Items.MV_CIRCUIT)
                .create("mv_machine_wiremill", I2Blocks.MV_WIREMILL.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", " 4 ")
                .addInput('1', I2Items.COOLANT_CELL)
                .addInput('2', I2Items.TOOL_TREETAP)
                .addInput('3', I2Blocks.MV_MACHINE_CASING)
                .addInput('4', I2Items.MV_CIRCUIT)
                .create("mv_machine_extractor", I2Blocks.MV_EXTRACTOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "232", "121")
                .addInput('1', I2Items.COAL_DUST)
                .addInput('2', Block.blockCoal)
                .addInput('3', Block.obsidian)
                .create("hardened_coal", I2Blocks.HARDENED_CARBON.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput("industry:rubber_logs")
                .create("rubber_log_to_planks", new ItemStack(Block.planksOakPainted, 4, 15));

        // TODO - Change reactor to use new HV items
        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', I2Items.MV_CIRCUIT)
                .addInput('2', I2Blocks.EHV_MACHINE_CASING)
                .addInput('3', Block.furnaceBlastIdle)
                .create("nuclear_reactor", I2Blocks.NUCLEAR_REACTOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2")
                .addInput('1', I2Items.MV_CIRCUIT)
                .addInput('2', I2Blocks.EHV_MACHINE_CASING)
                .create("nuclear_chamber", I2Blocks.NUCLEAR_CHAMBER.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "1")
                .addInput('1', I2Items.INSULATED_STEEL_CABLE)
                .addInput('2', I2Blocks.EHV_MACHINE_CASING)
                .create("nuclear_io", I2Blocks.NUCLEAR_CHAMBER_IO.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', I2Items.T1_REDSTONE_CELL)
                .addInput('2', I2Blocks.EHV_MACHINE_CASING)
                .addInput('3', I2Items.COOLANT_CELL)
                .create("ulv_generator_rtg", I2Blocks.ULV_NUCLEAR_RTG.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "343", "151")
                .addInput('1', I2Items.MV_CIRCUIT)
                .addInput('2', Block.netherrack)
                .addInput('3', Block.blockRedstone)
                .addInput('4', I2Blocks.EHV_MACHINE_CASING)
                .addInput('5', "minecraft:stones")
                .create("energy_fabricator", I2Blocks.ENERGY_FABRICATOR.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "111", "121", "111")
                .addInput('1', I2Items.BRONZE_PLATE)
                .addInput('2', Block.noteblock)
                .create("alarm", I2Blocks.ALARM.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.WATER_CELL)
                .addInput(I2Items.LAVA_CELL)
                .create("obsidian_from_cells", Block.obsidian.getDefaultStack());
    }

    private void initializeFurnaceRecipes() {
        new RecipeBuilderFurnace(MOD_ID)
                .setInput("industry:ores_copper")
                .create("copper_ores_to_ingot", I2Items.COPPER_INGOT.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput("industry:ores_tin")
                .create("tin_ores_to_ingot", I2Items.TIN_INGOT.getDefaultStack());

        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.TIN_DUST)
                .create("tin_dust_to_ingot", I2Items.TIN_INGOT.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.COPPER_DUST)
                .create("copper_dust_to_ingot", I2Items.COPPER_INGOT.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.BRONZE_DUST)
                .create("bronze_dust_to_ingot", I2Items.BRONZE_INGOT.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.IRON_DUST)
                .create("iron_dust_to_ingot", Item.ingotIron.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.GOLD_DUST)
                .create("gold_dust_to_ingot", Item.ingotGold.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(Item.dustRedstone)
                .create("redstone_dust_to_ingot", I2Items.ACTIVATED_REDSTONE_INGOT.getDefaultStack());

        new RecipeBuilderFurnace(MOD_ID)
                .setInput("industry:rubber_logs")
                .create("rubber_logs_to_charcoal", new ItemStack(Item.coal, 1, 1));

        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput("industry:ores_copper")
                .create("copper_ores_to_ingot", I2Items.COPPER_INGOT.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput("industry:ores_tin")
                .create("tin_ores_to_ingot", I2Items.TIN_INGOT.getDefaultStack());

        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.TIN_DUST)
                .create("tin_dust_to_ingot", I2Items.TIN_INGOT.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.COPPER_DUST)
                .create("copper_dust_to_ingot", I2Items.COPPER_INGOT.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.BRONZE_DUST)
                .create("bronze_dust_to_ingot", I2Items.BRONZE_INGOT.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.IRON_DUST)
                .create("iron_dust_to_ingot", Item.ingotIron.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.GOLD_DUST)
                .create("gold_dust_to_ingot", Item.ingotGold.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(Item.dustRedstone)
                .create("redstone_dust_to_ingot", I2Items.ACTIVATED_REDSTONE_INGOT.getDefaultStack());
    }

    @Override
    public void onRecipesReady() {
        Registries.ITEM_GROUPS.register("industry:rubber_logs", Registries.stackListOf(I2Blocks.RUBBERWOOD_LOG, I2Blocks.RUBBERWOOD_RESIN_LOG, I2Blocks.EMPTY_RUBBERWOOD_RESIN_LOG));
        Registries.ITEM_GROUPS.register("industry:ores_copper", Registries.stackListOf(I2Blocks.BASALT_COPPER_ORE, I2Blocks.STONE_COPPER_ORE, I2Blocks.LIMESTONE_COPPER_ORE, I2Blocks.GRANITE_COPPER_ORE, I2Items.RAW_COPPER));
        Registries.ITEM_GROUPS.register("industry:ores_tin", Registries.stackListOf(I2Blocks.BASALT_TIN_ORE, I2Blocks.STONE_TIN_ORE, I2Blocks.LIMESTONE_TIN_ORE, I2Blocks.GRANITE_TIN_ORE, I2Items.RAW_TIN));

        initializeItemRecipes();
        initializeBlockRecipes();
        initializeFurnaceRecipes();

        LookupFuelFurnace.instance.addFuelEntry(I2Items.COAL_DUST.id, 1600);
        LookupFuelEnergy.fuelEnergy().addFuelEntry(I2Items.COAL_DUST.id, 8);
    }

    @Override
    public void initNamespaces() {
        Registries.RECIPES.register("industry", INDUSTRY);
        INDUSTRY.register("workbench", WORKBENCH);
    }
}

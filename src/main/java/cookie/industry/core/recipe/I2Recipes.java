package cookie.industry.core.recipe;

import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.item.I2ItemsNew;
import cookie.industry.core.recipe.registries.I2RecipeRegistries;
import cookie.industry.core.recipe.registries.builders.*;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderFurnace;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static cookie.industry.Industry2.MOD_ID;

public class I2Recipes implements RecipeEntrypoint {

    private void registerFurnaceRecipes() {
        new RecipeBuilderFurnace(MOD_ID)
                .setInput("industry:tin_ores")
                .create("tin_ore_to_tin_ingot", I2ItemsNew.TIN_INGOT.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2ItemsNew.TIN_DUST)
                .create("tin_dust_to_tin_ingot", I2ItemsNew.TIN_INGOT.getDefaultStack());

        new RecipeBuilderFurnace(MOD_ID)
                .setInput("industry:copper_ores")
                .create("copper_ore_to_copper_ingot", I2ItemsNew.COPPER_INGOT.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2ItemsNew.COPPER_DUST)
                .create("copper_dust_to_copper_ingot", I2ItemsNew.COPPER_INGOT.getDefaultStack());

        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2ItemsNew.BRONZE_DUST)
                .create("bronze_dust_to_bronze_ingot", I2ItemsNew.BRONZE_INGOT.getDefaultStack());

        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2ItemsNew.RAW_TITANIUM)
                .create("raw_titanium_to_titanium_ingot", I2ItemsNew.TITANIUM_INGOT.getDefaultStack());
    }

    private void registerMaceratorRecipes() {
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(I2ItemsNew.TIN_INGOT)
                .create("tin_ingot_to_tin_dust", I2ItemsNew.TIN_DUST.getDefaultStack());
        new RecipeBuilderMacerator(MOD_ID)
                .setInput("industry:tin_ores")
                .create("tin_ore_to_two_tin_dust", new ItemStack(I2ItemsNew.TIN_DUST, 2));
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(I2BlocksNew.BLOCK_OF_TIN)
                .create("tin_block_to_nine_tin_dust", new ItemStack(I2ItemsNew.TIN_DUST, 9));

        new RecipeBuilderMacerator(MOD_ID)
                .setInput(I2ItemsNew.COPPER_INGOT)
                .create("copper_ingot_to_copper_dust", I2ItemsNew.COPPER_DUST.getDefaultStack());
        new RecipeBuilderMacerator(MOD_ID)
                .setInput("industry:copper_ores")
                .create("raw_copper_to_two_copper_dust", new ItemStack(I2ItemsNew.COPPER_DUST, 2));
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(I2BlocksNew.BLOCK_OF_COPPER)
                .create("copper_block_to_nine_copper_dust", new ItemStack(I2ItemsNew.COPPER_DUST, 9));

        new RecipeBuilderMacerator(MOD_ID)
                .setInput(I2ItemsNew.BRONZE_INGOT)
                .create("bronze_ingot_to_bronze_dust", I2ItemsNew.BRONZE_DUST.getDefaultStack());
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(I2BlocksNew.BLOCK_OF_BRONZE)
                .create("bronze_block_to_nine_bronze_dust", new ItemStack(I2ItemsNew.BRONZE_DUST, 9));

        new RecipeBuilderMacerator(MOD_ID)
                .setInput(Item.ingotIron)
                .create("iron_ingot_to_iron_dust", I2ItemsNew.IRON_DUST.getDefaultStack());
        new RecipeBuilderMacerator(MOD_ID)
                .setInput("minecraft:iron_ores")
                .create("iron_ore_to_two_iron_dust", new ItemStack(I2ItemsNew.IRON_DUST, 2));
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(Item.oreRawIron)
                .create("raw_iron_to_two_iron_dust", new ItemStack(I2ItemsNew.IRON_DUST, 2));
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(Block.blockIron)
                .create("iron_block_to_nine_iron_dust", new ItemStack(I2ItemsNew.IRON_DUST, 9));

        new RecipeBuilderMacerator(MOD_ID)
                .setInput(Item.ingotGold)
                .create("gold_ingot_to_gold_dust", I2ItemsNew.GOLD_DUST.getDefaultStack());
        new RecipeBuilderMacerator(MOD_ID)
                .setInput("minecraft:gold_ores")
                .create("gold_ore_to_two_gold_dust", new ItemStack(I2ItemsNew.GOLD_DUST, 2));
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(Item.oreRawGold)
                .create("raw_gold_to_two_gold_dust", new ItemStack(I2ItemsNew.GOLD_DUST, 2));
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(Block.blockGold)
                .create("gold_block_to_nine_gold_dust", new ItemStack(I2ItemsNew.GOLD_DUST, 9));

        new RecipeBuilderMacerator(MOD_ID)
                .setInput(Item.coal)
                .create("coal_to_coal_dust", I2ItemsNew.COAL_DUST.getDefaultStack());
        new RecipeBuilderMacerator(MOD_ID)
                .setInput(Block.blockCoal)
                .create("coal_block_to_nine_coal_dust", new ItemStack(I2ItemsNew.COAL_DUST, 8));

    }

    private static void registerCompressorRecipes() {
        new RecipeBuilderCompressor(MOD_ID)
                .setInput(I2ItemsNew.TIN_INGOT)
                .create("tin_ingot_to_two_tin_plates", new ItemStack(I2ItemsNew.TIN_PLATE, 2));
        new RecipeBuilderCompressor(MOD_ID)
                .setInput(I2BlocksNew.BLOCK_OF_TIN)
                .create("tin_block_to_eighteen_tin_plates", new ItemStack(I2ItemsNew.TIN_PLATE, 18));

        new RecipeBuilderCompressor(MOD_ID)
                .setInput(I2ItemsNew.COPPER_INGOT)
                .create("copper_ingot_to_two_copper_plates", new ItemStack(I2ItemsNew.COPPER_PLATE, 2));
        new RecipeBuilderCompressor(MOD_ID)
                .setInput(I2BlocksNew.BLOCK_OF_COPPER)
                .create("copper_block_to_eighteen_copper_plates", new ItemStack(I2ItemsNew.COPPER_PLATE, 18));

        new RecipeBuilderCompressor(MOD_ID)
                .setInput(I2ItemsNew.BRONZE_INGOT)
                .create("bronze_ingot_to_two_bronze_plates", new ItemStack(I2ItemsNew.BRONZE_PLATE, 2));
        new RecipeBuilderCompressor(MOD_ID)
                .setInput(I2BlocksNew.BLOCK_OF_BRONZE)
                .create("bronze_block_to_eighteen_bronze_plates", new ItemStack(I2ItemsNew.BRONZE_PLATE, 18));

        new RecipeBuilderCompressor(MOD_ID)
                .setInput(Item.ingotIron)
                .create("iron_ingot_to_two_iron_plates", new ItemStack(I2ItemsNew.IRON_PLATE, 2));
        new RecipeBuilderCompressor(MOD_ID)
                .setInput(Block.blockIron)
                .create("iron_block_to_eighteen_iron_plates", new ItemStack(I2ItemsNew.IRON_PLATE, 18));

        new RecipeBuilderCompressor(MOD_ID)
                .setInput(Item.ingotGold)
                .create("gold_ingot_to_two_gold_plates", new ItemStack(I2ItemsNew.GOLD_PLATE, 2));
        new RecipeBuilderCompressor(MOD_ID)
                .setInput(Block.blockGold)
                .create("gold_block_to_eighteen_gold_plates", new ItemStack(I2ItemsNew.GOLD_PLATE, 18));

        new RecipeBuilderCompressor(MOD_ID)
                .setInput(Item.ingotSteel)
                .create("steel_ingot_to_two_steel_plates", new ItemStack(I2ItemsNew.STEEL_PLATE, 2));
        new RecipeBuilderCompressor(MOD_ID)
                .setInput(Block.blockSteel)
                .create("steel_block_to_eighteen_steel_plates", new ItemStack(I2ItemsNew.STEEL_PLATE, 18));

        new RecipeBuilderCompressor(MOD_ID)
                .setInput(I2ItemsNew.IRIDIUM_INGOT)
                .create("iridium_ingot_to_iridium_plate", I2ItemsNew.IRIDIUM_PLATE.getDefaultStack());

//        new RecipeBuilderCompressor(MOD_ID)
//                .setInput(I2BlocksNew.HARDENED_CARBON)
//                .create("hardened_carbon_to_diamond", Item.diamond.getDefaultStack());
    }

    private void registerWiremillRecipes() {
        new RecipeBuilderWiremill(MOD_ID)
                .setInput(I2ItemsNew.COPPER_INGOT)
                .create("copper_ingot_to_four_copper_cables", new ItemStack(I2ItemsNew.COPPER_CABLE, 4));
        new RecipeBuilderWiremill(MOD_ID)
                .setInput(I2BlocksNew.BLOCK_OF_COPPER)
                .create("copper_block_to_thirty_six_copper_cables", new ItemStack(I2ItemsNew.COPPER_CABLE, 36));

        new RecipeBuilderWiremill(MOD_ID)
                .setInput(Item.ingotGold)
                .create("gold_ingot_to_four_gold_cables", new ItemStack(I2ItemsNew.GOLD_CABLE, 4));
        new RecipeBuilderWiremill(MOD_ID)
                .setInput(Block.blockGold)
                .create("gold_block_to_thirty_six_gold_cables", new ItemStack(I2ItemsNew.GOLD_CABLE, 36));

        new RecipeBuilderWiremill(MOD_ID)
                .setInput(Item.ingotSteel)
                .create("steel_ingot_to_four_steel_cables", new ItemStack(I2ItemsNew.STEEL_CABLE, 4));
        new RecipeBuilderWiremill(MOD_ID)
                .setInput(Block.blockSteel)
                .create("steel_block_to_thirty_six_steel_cables", new ItemStack(I2ItemsNew.STEEL_CABLE, 36));

        new RecipeBuilderWiremill(MOD_ID)
                .setInput(I2ItemsNew.TITANIUM_INGOT)
                .create("titanium_ingot_to_four_titanium_cables", new ItemStack(I2ItemsNew.TITANIUM_CABLE, 4));
        new RecipeBuilderWiremill(MOD_ID)
                .setInput(I2BlocksNew.BLOCK_OF_TITANIUM)
                .create("titanium_block_to_thirty_six_titanium_cables", new ItemStack(I2ItemsNew.TITANIUM_CABLE, 36));

        new RecipeBuilderWiremill(MOD_ID)
                .setInput("minecraft:wools")
                .create("wool_to_four_string", new ItemStack(Item.string, 4));
    }

    private void registerExtractorRecipess() {
        new RecipeBuilderExtractor(MOD_ID)
                .setInput("industry:rubberwood_logs")
                .create("rubberwood_log_to_resin", I2ItemsNew.RESIN.getDefaultStack());

        new RecipeBuilderExtractor(MOD_ID)
                .setInput(I2BlocksNew.RUBBERWOOD_SAPLING)
                .create("rubberwood_sapling_to_resin", I2ItemsNew.RESIN.getDefaultStack());

        new RecipeBuilderExtractor(MOD_ID)
                .setInput(I2ItemsNew.RESIN)
                .create("resin_to_two_rubber_balls", new ItemStack(I2ItemsNew.RUBBER_BALL, 2));

        new RecipeBuilderExtractor(MOD_ID)
                .setInput(I2ItemsNew.WATER_CELL)
                .create("water_cell_to_coolant_cell", I2ItemsNew.COOLANT_CELL.getDefaultStack());

        new RecipeBuilderExtractor(MOD_ID)
                .setInput(I2ItemsNew.DEPLETED_TIER_1_REDSTONE_CELL)
                .create("depleted_redstone_cell_to_tier_2_redstone_cell", I2ItemsNew.TIER_2_REDSTONE_CELL.getDefaultStack());

        new RecipeBuilderExtractor(MOD_ID)
                .setInput(I2ItemsNew.DEPLETED_TIER_2_REDSTONE_CELL)
                .create("depleted_redstone_cell_to_tier_3_redstone_cell", I2ItemsNew.TIER_3_REDSTONE_CELL.getDefaultStack());
    }

    private void registerCanningRecipes() {
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodFishRaw)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 1)
                .create("raw_fish_to_one_can", I2ItemsNew.FILLED_CAN.getDefaultStack());
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodCookie)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 1)
                .create("cookie_to_one_can", I2ItemsNew.FILLED_CAN.getDefaultStack());
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.cherry)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 1)
                .create("cherry_to_one_can", I2ItemsNew.FILLED_CAN.getDefaultStack());

        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodApple)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 2)
                .create("apple_to_two_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 2));
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodPorkchopRaw)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 2)
                .create("raw_pork_to_two_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 2));

        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodBread)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 3)
                .create("bread_to_three_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 3));
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodFishCooked)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 3)
                .create("cooked_fish_to_three_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 3));

        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodPorkchopCooked)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 4)
                .create("cooked_pork_to_four_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 4));
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodPumpkinPie)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 4)
                .create("pumpkin_pie_to_four_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 4));

        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodStewMushroom)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 5)
                .create("mushroom_stew_to_five_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 5));

        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodCake)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 6)
                .create("cake_to_six_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 6));

        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.foodAppleGold)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CAN), 21)
                .create("golden_apple_to_twenty_one_cans", new ItemStack(I2ItemsNew.FILLED_CAN, 21));

        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.bucketWater)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CELL), 1)
                .create("water_bucket_to_water_cell", I2ItemsNew.WATER_CELL.getDefaultStack());
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(Item.bucketLava)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CELL), 1)
                .create("lava_bucket_to_lava_cell", I2ItemsNew.LAVA_CELL.getDefaultStack());
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(I2ItemsNew.BUCKET_OF_OIL)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CELL), 1)
                .create("oil_bucket_to_oil_cell", I2ItemsNew.OIL_CELL.getDefaultStack());
        new RecipeBuilderCanningMachine(MOD_ID)
                .setInput(I2ItemsNew.ACTIVATED_REDSTONE_INGOT)
                .setCan(new ItemStack(I2ItemsNew.EMPTY_CELL), 1)
                .create("activated_redstone_to_redstone_cell", I2ItemsNew.TIER_1_REDSTONE_CELL.getDefaultStack());
    }

    @Override
    public void onRecipesReady() {
        RecipeBuilder.addItemsToGroup(
                MOD_ID,
                "copper_ores",
                I2BlocksNew.STONE_COPPER_ORE,
                I2BlocksNew.BASALT_COPPER_ORE,
                I2BlocksNew.LIMESTONE_COPPER_ORE,
                I2BlocksNew.GRANITE_COPPER_ORE,
                I2ItemsNew.RAW_COPPER
        );
        RecipeBuilder.addItemsToGroup(
                MOD_ID,
                "tin_ores",
                I2BlocksNew.STONE_TIN_ORE,
                I2BlocksNew.BASALT_TIN_ORE,
                I2BlocksNew.LIMESTONE_TIN_ORE,
                I2BlocksNew.GRANITE_TIN_ORE,
                I2ItemsNew.RAW_TIN
        );
        RecipeBuilder.addItemsToGroup(
                MOD_ID,
                "rubberwood_logs",
                I2BlocksNew.RUBBERWOOD_LOG,
                I2BlocksNew.RUBBERWOOD_RESIN_LOG,
                I2BlocksNew.EMPTY_RUBBERWOOD_RESIN_LOG
        );

        registerFurnaceRecipes();
        registerMaceratorRecipes();
        registerCompressorRecipes();
        registerWiremillRecipes();
        registerExtractorRecipess();
        registerCanningRecipes();
    }

    @Override
    public void initNamespaces() {
        new I2RecipeRegistries();
        Registries.RECIPES.register("industry", I2RecipeRegistries.INDUSTRY);
    }
}

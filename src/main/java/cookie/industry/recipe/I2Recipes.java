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
                .addInput(I2Items.dustCopper)
                .addInput(I2Items.dustCopper)
                .addInput(I2Items.dustCopper)
                .addInput(I2Items.dustTin)
                .create("bronze_dust_from_dusts", new ItemStack(I2Items.dustBronze, 4));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Blocks.blockTin)
                .create("tin_ingot_from_block", new ItemStack(I2Items.ingotTin, 9));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Blocks.blockCopper)
                .create("copper_ingot_from_block", new ItemStack(I2Items.ingotCopper, 9));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Blocks.blockBronze)
                .create("bronze_ingot_from_block", new ItemStack(I2Items.ingotBronze, 9));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolHammer)
                .addInput(I2Items.ingotTin)
                .create("tin_plate_from_hammer", I2Items.plateTin.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolHammer)
                .addInput(I2Items.ingotCopper)
                .create("copper_plate_from_hammer", I2Items.plateCopper.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolHammer)
                .addInput(I2Items.ingotBronze)
                .create("bronze_plate_from_hammer", I2Items.plateBronze.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolHammer)
                .addInput(Item.ingotIron)
                .create("iron_plate_from_hammer", I2Items.plateTin.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolHammer)
                .addInput(Item.ingotGold)
                .create("gold_plate_from_hammer", I2Items.plateGold.getDefaultStack());
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolHammer)
                .addInput(Item.ingotSteel)
                .create("steel_plate_from_hammer", I2Items.plateSteel.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolCutters)
                .addInput(I2Items.ingotTin)
                .create("tin_cable_from_cutters", new ItemStack(I2Items.itemCableTin, 2));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolCutters)
                .addInput(I2Items.ingotCopper)
                .create("copper_cable_from_cutters", new ItemStack(I2Items.itemCableCopper, 2));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolCutters)
                .addInput(Item.ingotGold)
                .create("gold_cable_from_cutters", new ItemStack(I2Items.itemCableGold, 2));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolCutters)
                .addInput(Item.ingotSteel)
                .create("steel_cable_from_cutters", new ItemStack(I2Items.itemCableSteel, 2));

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.rubber)
                .addInput(I2Items.itemCableTin)
                .create("insulated_tin_cable", new ItemStack(I2Items.itemInsulatedCableTin.getDefaultStack()));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.rubber)
                .addInput(I2Items.itemCableCopper)
                .create("insulated_copper_cable", new ItemStack(I2Items.itemInsulatedCableCopper.getDefaultStack()));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.rubber)
                .addInput(I2Items.itemCableGold)
                .create("insulated_gold_cable", new ItemStack(I2Items.itemInsulatedCableGold.getDefaultStack()));
        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.rubber)
                .addInput(I2Items.itemCableSteel)
                .create("insulated_steel_cable", new ItemStack(I2Items.itemInsulatedCableSteel.getDefaultStack()));

        new RecipeBuilderShaped(MOD_ID, "111", "121", " 2 ")
                .addInput('1', Item.ingotIron)
                .addInput('2', Item.stick)
                .create("hammer", I2Items.toolHammer.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", " 1 ", "2 2")
                .addInput('1', I2Items.plateIron)
                .addInput('2', Item.ingotIron)
                .create("cutters", I2Items.toolCutters.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", "111", " 1 ")
                .addInput('1', I2Items.plateBronze)
                .create("wrench", I2Items.toolWrench.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", "232")
                .addInput('1', I2Items.itemInsulatedCableTin)
                .addInput('2', I2Items.plateTin)
                .addInput('3', Item.dustRedstone)
                .create("lv_battery", I2Items.lvBattery.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", "242")
                .addInput('1', I2Items.itemInsulatedCableCopper)
                .addInput('2', I2Items.plateBronze)
                .addInput('3', Item.sulphur)
                .addInput('4', Item.dustRedstone)
                .create("mv_battery_1", I2Items.mvBattery.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", "242")
                .addInput('1', I2Items.itemInsulatedCableCopper)
                .addInput('2', I2Items.plateBronze)
                .addInput('3', Item.dustRedstone)
                .addInput('4', Item.sulphur)
                .create("mv_battery_2", I2Items.mvBattery.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "232", "121")
                .addInput('1', I2Items.itemInsulatedCableGold)
                .addInput('2', Item.dustRedstone)
                .addInput('3', Item.diamond)
                .create("hv_battery", I2Items.hvBattery.getDefaultStack());

        // TODO - Change this to an HV circuit
        new RecipeBuilderShaped(MOD_ID, "121", "343", "121")
                .addInput('1', I2Items.itemInsulatedCableSteel)
                .addInput('2', new ItemStack(Item.dye, 1, 4))
                .addInput('3', I2Items.mvCircuit)
                .addInput('4', Item.diamond)
                .create("ehv_battery", I2Items.ehvBattery.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "1 1", " 1 ")
                .addInput('1', I2Items.ingotTin)
                .create("empty_cell", new ItemStack(I2Items.cellEmpty, 4));

        new RecipeBuilderShaped(MOD_ID, "1 1", " 1 ")
                .addInput('1', I2Items.ingotTin)
                .create("empty_can", new ItemStack(I2Items.canEmpty, 3));

        new RecipeBuilderShaped(MOD_ID, "111", "232", "111")
                .addInput('1', I2Items.itemInsulatedCableCopper)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Items.plateIron)
                .create("lv_circuit", I2Items.lvCircuit.getDefaultStack());

        // TODO - Change this to plastic (or make HV circuits use it)
        new RecipeBuilderShaped(MOD_ID, "111", "234", "111")
                .addInput('1', I2Items.itemInsulatedCableGold)
                .addInput('2', Item.quartz)
                .addInput('3', I2Items.plateSteel)
                .addInput('4', Item.dustRedstone)
                .create("mv_circuit", I2Items.mvCircuit.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 11", "231", "42 ")
                .addInput('1', I2Items.plateIron)
                .addInput('2', I2Items.ingotBronze)
                .addInput('3', I2Items.lvCircuit)
                .addInput('4', I2Items.lvBattery)
                .create("chainsaw", I2Items.toolChainsaw.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121", "343")
                .addInput('1', I2Items.plateIron)
                .addInput('2', I2Items.lvCircuit)
                .addInput('3', I2Items.ingotBronze)
                .addInput('4', I2Items.lvBattery)
                .create("drill_iron", I2Items.toolDrill.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121")
                .addInput('1', Item.ingotGold)
                .addInput('2', I2Items.toolDrill)
                .create("drill_gold", I2Items.toolDrillGold.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121")
                .addInput('1', Item.diamond)
                .addInput('2', I2Items.toolDrillDiamond)
                .create("drill_diamond", I2Items.toolDrillDiamond.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", " 2 ", "343")
                .addInput('1', Item.quartz)
                .addInput('2', Item.dustGlowstone)
                .addInput('3', I2Items.plateSteel)
                .addInput('4', I2Items.hvBattery)
                .create("nanosword", I2Items.toolNanoSword.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "111", "121", " 3 ")
                .addInput('1', I2Items.rubber)
                .addInput('2', Block.glass)
                .addInput('3', new ItemStack(Item.dye, 1, 11))
                .create("armor_helmet_hazmat", I2Items.armorHelmetHazmat.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "121", "111", "111")
                .addInput('1', I2Items.rubber)
                .addInput('2', new ItemStack(Item.dye, 1, 11))
                .create("armor_chestplate_hazmat", I2Items.armorChestplateHazmat.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "111", "121", "1 1")
                .addInput('1', I2Items.rubber)
                .addInput('2', new ItemStack(Item.dye, 1, 11))
                .create("armor_leggings_hazmat", I2Items.armorLeggingsHazmat.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "1 1")
                .addInput('1', I2Items.rubber)
                .create("armor_boots_hazmat", I2Items.armorBootsHazmat.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "131")
                .addInput('1', I2Items.ingotIridium)
                .addInput('2', I2Items.ehvBattery)
                .addInput('3', Block.glassTinted)
                .create("armor_helmet_iridium", I2Items.armorHelmetIridium.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "121", "111")
                .addInput('1', I2Items.ingotIridium)
                .addInput('2', I2Items.ehvBattery)
                .create("armor_chestplate_iridium", I2Items.armorChestplateIridium.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "111", "2 2", "1 1")
                .addInput('1', I2Items.ingotIridium)
                .addInput('2', I2Items.ehvBattery)
                .create("armor_leggings_iridium", I2Items.armorLeggingsIridium.getDefaultStack());
        new RecipeBuilderShaped(MOD_ID, "1 1", "2 2")
                .addInput('1', I2Items.ingotIridium)
                .addInput('2', I2Items.ehvBattery)
                .create("armor_boots_iridium", I2Items.armorBootsIridium.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.plateSteel)
                .addInput(I2Items.plateSteel)
                .create("reactor_plate_from_plates", I2Items.reactorPlate.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolHammer)
                .addInput(Item.ingotSteel)
                .addInput(Item.ingotSteel)
                .create("reactor_plate_from_hammer", I2Items.reactorPlate.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolCutters)
                .addInput(I2Items.reactorPlate)
                .create("reactor_vent", I2Items.reactorVent.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.plateIron)
                .addInput(I2Items.plateIron)
                .create("upgrade_plate_from_plates", I2Items.upgradePlate.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.toolHammer)
                .addInput(Item.ingotIron)
                .addInput(Item.ingotIron)
                .create("upgrade_plate_from_hammer", I2Items.upgradePlate.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121", " 3 ")
                .addInput('1', I2Items.cellCoolant)
                .addInput('2', I2Items.upgradePlate)
                .addInput('3', I2Items.lvCircuit)
                .create("speed_upgrade", I2Items.upgradeSpeed.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 2", " 3 ", "456")
                .addInput('1', I2Items.itemInsulatedCableCopper)
                .addInput('2', I2Items.itemInsulatedCableGold)
                .addInput('3', I2Items.upgradePlate)
                .addInput('4', I2Items.itemInsulatedCableSteel)
                .addInput('5', I2Items.lvCircuit)
                .addInput('6', I2Items.itemInsulatedCableTin)
                .create("transformer_upgrade", I2Items.upgradeTransformer.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', I2Items.lvBattery)
                .addInput('2', I2Items.upgradePlate)
                .addInput('3', I2Items.lvCircuit)
                .create("energy_upgrade", I2Items.upgradeEnergy.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', Block.pistonBaseSticky)
                .addInput('2', I2Items.upgradePlate)
                .addInput('3', I2Items.lvCircuit)
                .create("puller_upgrade", I2Items.upgradePuller.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', Block.pistonBase)
                .addInput('2', I2Items.upgradePlate)
                .addInput('3', I2Items.lvCircuit)
                .create("pusher_upgrade", I2Items.upgradePusher.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121", " 3 ")
                .addInput('1', Item.nethercoal)
                .addInput('2', I2Items.upgradePlate)
                .addInput('3', I2Items.lvCircuit)
                .create("blasting_upgrade", I2Items.upgradeBlasting.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", " 1 ")
                .addInput('1', new ItemStack(Item.dye, 1, 3))
                .addInput('2', Item.wheat)
                .addInput('3', Block.pumpkin)
                .create("joffo_cake", I2Items.foodJoffos.getDefaultStack());
    }

    private void initializeBlockRecipes() {
        RecipeBuilderShaped templateIngotBlock = new RecipeBuilderShaped(MOD_ID, "111", "111", "111");
        RecipeBuilderShaped templateCasing = new RecipeBuilderShaped(MOD_ID, "111", "121", "111");
        RecipeBuilderShaped templateSolar = new RecipeBuilderShaped(MOD_ID, "111", "121", "111");
        RecipeBuilderShaped templateBatbox = new RecipeBuilderShaped(MOD_ID, "121", "333", "111");
        RecipeBuilderShaped templateTransformer = new RecipeBuilderShaped(MOD_ID, "121", "134", "454");
        RecipeBuilderShaped templateMachineFurnace = new RecipeBuilderShaped(MOD_ID, " 1 ", "232", " 4 ");

        templateIngotBlock
                .addInput('1', I2Items.ingotTin)
                .create("tin_block_from_ingot", I2Blocks.blockTin.getDefaultStack());
        templateIngotBlock
                .addInput('1', I2Items.ingotCopper)
                .create("copper_block_from_ingot", I2Blocks.blockCopper.getDefaultStack());
        templateIngotBlock
                .addInput('1', I2Items.ingotBronze)
                .create("bronze_block_from_ingot", I2Blocks.blockBronze.getDefaultStack());

        // TODO - Change 2nd tier, redstone/bronze/MV
        // TODO - Add 3rd tier, oil/steel/HV
        templateCasing
                .addInput('1', I2Items.plateIron)
                .addInput('2', I2Items.lvBattery)
                .create("lv_machine_casing", I2Blocks.lvMachineCasing.getDefaultStack());
        templateCasing
                .addInput('1', I2Items.plateSteel)
                .addInput('2', I2Items.mvBattery)
                .create("mv_machine_casing", I2Blocks.mvMachineCasing.getDefaultStack());
        templateCasing
                .addInput('1', I2Items.reactorPlate)
                .addInput('2', I2Items.ehvBattery)
                .create("ehv_machine_casing", I2Blocks.ehvMachineCasing.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2")
                .addInput('1', I2Blocks.lvMachineCasing)
                .addInput('2', Block.furnaceStoneIdle)
                .create("lv_generator", I2Blocks.lvGenerator.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "232", "121")
                .addInput('1', Item.stick)
                .addInput('2', "minecraft:planks")
                .addInput('3', I2Blocks.lvGenerator)
                .create("lv_generator_watermill", I2Blocks.lvGeneratorWatermill.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "121", " 1 ")
                .addInput('1', I2Blocks.blockTin)
                .addInput('2', I2Blocks.lvGenerator)
                .create("lv_generator_windmill", I2Blocks.lvGeneratorWindmill.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "121", "343")
                .addInput('1', Block.glass)
                .addInput('2', I2Items.cellEmpty)
                .addInput('3', I2Items.plateSteel)
                .addInput('4', I2Blocks.lvGenerator)
                .create("lv_generator_geothermal", I2Blocks.lvGeneratorGeothermal.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "212", "343")
                .addInput('1', I2Items.dustCoal)
                .addInput('2', Block.glassTinted)
                .addInput('3', I2Items.lvCircuit)
                .addInput('4', I2Blocks.lvGenerator)
                .create("ulv_generator_solar_1", I2Blocks.ulvGeneratorSolar.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "212", "343")
                .addInput('1', Block.glassTinted)
                .addInput('2', I2Items.dustCoal)
                .addInput('3', I2Items.lvCircuit)
                .addInput('4', I2Blocks.lvGenerator)
                .create("ulv_generator_solar_2", I2Blocks.ulvGeneratorSolar.getDefaultStack());

        templateSolar
                .addInput('1', I2Blocks.ulvGeneratorSolar)
                .addInput('2', I2Blocks.lvBatbox)
                .create("lv_generator_solar", I2Blocks.lvGeneratorSolar.getDefaultStack());

        templateSolar
                .addInput('1', I2Blocks.lvGeneratorSolar)
                .addInput('2', I2Blocks.mvBatbox)
                .create("mv_generator_solar", I2Blocks.mvGeneratorSolar.getDefaultStack());

        templateSolar
                .addInput('1', I2Blocks.mvGeneratorSolar)
                .addInput('2', I2Blocks.hvBatbox)
                .create("hv_generator_solar", I2Blocks.hvGeneratorSolar.getDefaultStack());

        templateSolar
                .addInput('1', I2Blocks.hvGeneratorSolar)
                .addInput('2', I2Blocks.ehvBatbox)
                .create("ehv_generator_solar", I2Blocks.ehvGeneratorSolar.getDefaultStack());

        templateBatbox
                .addInput('1', "minecraft:planks")
                .addInput('2', I2Items.itemInsulatedCableTin)
                .addInput('3', I2Items.lvBattery)
                .create("lv_batbox", I2Blocks.lvBatbox.getDefaultStack());

        templateBatbox
                .addInput('1', I2Items.plateBronze)
                .addInput('2', I2Items.itemInsulatedCableCopper)
                .addInput('3', I2Items.mvBattery)
                .create("mv_batbox", I2Blocks.mvBatbox.getDefaultStack());

        templateBatbox
                .addInput('1', I2Items.plateIron)
                .addInput('2', I2Items.itemInsulatedCableGold)
                .addInput('3', I2Items.hvBattery)
                .create("hv_batbox", I2Blocks.hvBatbox.getDefaultStack());

        templateBatbox
                .addInput('1', I2Items.plateSteel)
                .addInput('2', I2Items.itemInsulatedCableSteel)
                .addInput('3', I2Items.ehvBattery)
                .create("ehv_batbox", I2Blocks.ehvBatbox.getDefaultStack());

        templateTransformer
                .addInput('1', I2Items.plateBronze)
                .addInput('2', I2Items.itemInsulatedCableCopper)
                .addInput('3', I2Items.lvBattery)
                .addInput('4', "minecraft:planks")
                .addInput('5', I2Items.itemInsulatedCableTin)
                .create("mv_to_lv_transformer", I2Blocks.transformerMVtoLV.getDefaultStack());

        templateTransformer
                .addInput('1', I2Items.plateIron)
                .addInput('2', I2Items.itemInsulatedCableGold)
                .addInput('3', I2Items.mvBattery)
                .addInput('4', I2Items.plateBronze)
                .addInput('5', I2Items.itemInsulatedCableCopper)
                .create("hv_to_mv_transformer", I2Blocks.transformerHVtoMV.getDefaultStack());

        templateTransformer
                .addInput('1', I2Items.plateSteel)
                .addInput('2', I2Items.itemInsulatedCableSteel)
                .addInput('3', I2Items.hvBattery)
                .addInput('4', I2Items.plateIron)
                .addInput('5', I2Items.itemInsulatedCableGold)
                .create("ehv_to_hv_transformer", I2Blocks.transformerEHVtoHV.getDefaultStack());

        templateMachineFurnace
                .addInput('1', I2Items.lvCircuit)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Blocks.lvMachineCasing)
                .addInput('4', Block.furnaceStoneIdle)
                .create("lv_machine_furnace", I2Blocks.lvMachineFurnace.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "111", "232", " 4 ")
                .addInput('1', Item.flint)
                .addInput('2', "minecraft:cobblestones")
                .addInput('3', I2Blocks.lvMachineCasing)
                .addInput('4', I2Items.lvCircuit)
                .create("lv_machine_macerator", I2Blocks.lvMachineMacerator.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", "121", "131")
                .addInput('1', "minecraft:stones")
                .addInput('2', I2Blocks.lvMachineCasing)
                .addInput('3', I2Items.lvCircuit)
                .create("lv_machine_compressor", I2Blocks.lvMachineCompressor.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1 1", "121", " 3 ")
                .addInput('1', Item.ingotIron)
                .addInput('2', I2Blocks.lvMachineCasing)
                .addInput('3', I2Items.lvCircuit)
                .create("lv_machine_wiremill", I2Blocks.lvMachineWiremill.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "131")
                .addInput('1', I2Items.toolTreetap)
                .addInput('2', I2Blocks.lvMachineCasing)
                .addInput('3', I2Items.lvCircuit)
                .create("lv_machine_extractor", I2Blocks.lvMachineExtractor.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232")
                .addInput('1', I2Items.lvCircuit)
                .addInput('2', Block.dirt)
                .addInput('3', I2Blocks.lvMachineCasing)
                .create("lv_machine_recycler", I2Blocks.lvMachineRecycler.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', I2Blocks.lvMachineCasing)
                .addInput('2', Block.trommelIdle)
                .addInput('3', I2Items.lvCircuit)
                .create("lv_machine_trommel", I2Blocks.lvMachineTrommel.getDefaultStack());

        templateMachineFurnace
                .addInput('1', I2Items.mvCircuit)
                .addInput('2', Item.dustRedstone)
                .addInput('3', I2Blocks.mvMachineCasing)
                .addInput('4', Block.furnaceStoneIdle)
                .create("mv_machine_furnace", I2Blocks.mvMachineFurnace.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', Block.spikes)
                .addInput('2', I2Blocks.mvMachineCasing)
                .addInput('3', I2Items.mvCircuit)
                .create("mv_machine_meractor", I2Blocks.mvMachineMacerator.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", " 3 ")
                .addInput('1', Block.obsidian)
                .addInput('2', I2Blocks.mvMachineCasing)
                .addInput('3', I2Items.mvCircuit)
                .create("mv_machine_compressor", I2Blocks.mvMachineCompressor.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', Item.quartz)
                .addInput('2', I2Blocks.mvMachineCasing)
                .addInput('3', I2Items.mvCircuit)
                .create("mv_machine_wiremill", I2Blocks.mvMachineWiremill.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, " 1 ", "232", " 4 ")
                .addInput('1', I2Items.cellCoolant)
                .addInput('2', I2Items.toolTreetap)
                .addInput('3', I2Blocks.mvMachineCasing)
                .addInput('4', I2Items.mvCircuit)
                .create("mv_machine_extractor", I2Blocks.mvMachineExtractor.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "232", "121")
                .addInput('1', I2Items.dustCoal)
                .addInput('2', Block.blockCoal)
                .addInput('3', Block.obsidian)
                .create("hardened_coal", I2Blocks.hardenedCoal.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput("industry:rubber_logs")
                .create("rubber_log_to_planks", new ItemStack(Block.planksOakPainted, 4, 15));

        // TODO - Change reactor to use new HV items
        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', I2Items.mvCircuit)
                .addInput('2', I2Blocks.ehvMachineCasing)
                .addInput('3', Block.furnaceBlastIdle)
                .create("nuclear_reactor", I2Blocks.nuclearReactor.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2")
                .addInput('1', I2Items.mvCircuit)
                .addInput('2', I2Blocks.ehvMachineCasing)
                .create("nuclear_chamber", I2Blocks.nuclearChamber.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "1")
                .addInput('1', I2Items.itemInsulatedCableSteel)
                .addInput('2', I2Blocks.ehvMachineCasing)
                .create("nuclear_io", I2Blocks.nuclearIO.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
                .addInput('1', I2Items.cellRedstoneT1)
                .addInput('2', I2Blocks.ehvMachineCasing)
                .addInput('3', I2Items.cellCoolant)
                .create("ulv_generator_rtg", I2Blocks.ulvGeneratorRTG.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "121", "343", "151")
                .addInput('1', I2Items.mvCircuit)
                .addInput('2', Block.netherrack)
                .addInput('3', Block.blockRedstone)
                .addInput('4', I2Blocks.ehvMachineCasing)
                .addInput('5', "minecraft:stones")
                .create("energy_fabricator", I2Blocks.energyFabricator.getDefaultStack());

        new RecipeBuilderShaped(MOD_ID, "111", "121", "111")
                .addInput('1', I2Items.plateBronze)
                .addInput('2', Block.noteblock)
                .create("alarm", I2Blocks.alarm.getDefaultStack());

        new RecipeBuilderShapeless(MOD_ID)
                .addInput(I2Items.cellWater)
                .addInput(I2Items.cellLava)
                .create("obsidian_from_cells", Block.obsidian.getDefaultStack());
    }

    private void initializeFurnaceRecipes() {
        new RecipeBuilderFurnace(MOD_ID)
                .setInput("industry:ores_copper")
                .create("copper_ores_to_ingot", I2Items.ingotCopper.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput("industry:ores_tin")
                .create("tin_ores_to_ingot", I2Items.ingotTin.getDefaultStack());

        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.dustTin)
                .create("tin_dust_to_ingot", I2Items.ingotTin.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.dustCopper)
                .create("copper_dust_to_ingot", I2Items.ingotCopper.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.dustBronze)
                .create("bronze_dust_to_ingot", I2Items.ingotBronze.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.dustIron)
                .create("iron_dust_to_ingot", Item.ingotIron.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(I2Items.dustGold)
                .create("gold_dust_to_ingot", Item.ingotGold.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(Item.dustRedstone)
                .create("redstone_dust_to_ingot", I2Items.ingotActivatedRedstone.getDefaultStack());

        new RecipeBuilderFurnace(MOD_ID)
                .setInput("industry:rubber_logs")
                .create("rubber_logs_to_charcoal", new ItemStack(Item.coal, 1, 1));

        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput("industry:ores_copper")
                .create("copper_ores_to_ingot", I2Items.ingotCopper.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput("industry:ores_tin")
                .create("tin_ores_to_ingot", I2Items.ingotTin.getDefaultStack());

        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.dustTin)
                .create("tin_dust_to_ingot", I2Items.ingotTin.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.dustCopper)
                .create("copper_dust_to_ingot", I2Items.ingotCopper.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.dustBronze)
                .create("bronze_dust_to_ingot", I2Items.ingotBronze.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.dustIron)
                .create("iron_dust_to_ingot", Item.ingotIron.getDefaultStack());
        new RecipeBuilderBlastFurnace(MOD_ID)
                .setInput(I2Items.dustGold)
                .create("gold_dust_to_ingot", Item.ingotGold.getDefaultStack());
        new RecipeBuilderFurnace(MOD_ID)
                .setInput(Item.dustRedstone)
                .create("redstone_dust_to_ingot", I2Items.ingotActivatedRedstone.getDefaultStack());
    }

    @Override
    public void onRecipesReady() {
        Registries.ITEM_GROUPS.register("industry:rubber_logs", Registries.stackListOf(I2Blocks.logRubberWood, I2Blocks.logRubberWoodResin, I2Blocks.logRubberWoodResinFull));
        Registries.ITEM_GROUPS.register("industry:ores_copper", Registries.stackListOf(I2Blocks.oreCopperBasalt, I2Blocks.oreCopperStone, I2Blocks.oreCopperLimestone, I2Blocks.oreCopperGranite, I2Items.oreRawCopper));
        Registries.ITEM_GROUPS.register("industry:ores_tin", Registries.stackListOf(I2Blocks.oreTinBasalt, I2Blocks.oreTinStone, I2Blocks.oreTinLimestone, I2Blocks.oreTinGranite, I2Items.oreRawTin));

        initializeItemRecipes();
        initializeBlockRecipes();
        initializeFurnaceRecipes();

        LookupFuelFurnace.instance.addFuelEntry(I2Items.dustCoal.id, 1600);
        LookupFuelEnergy.fuelEnergy().addFuelEntry(I2Items.dustCoal.id, 8);
    }

    @Override
    public void initNamespaces() {
        Registries.RECIPES.register("industry", INDUSTRY);
        INDUSTRY.register("workbench", WORKBENCH);
    }
}

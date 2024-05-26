package cookie.industry.block;

import cookie.industry.Industry2;
import cookie.industry.I2Config;
import cookie.industry.IndustryTags;
import cookie.industry.block.energy.cables.*;
import cookie.industry.block.energy.cables.entity.TileEntityCable;
import cookie.industry.block.energy.cables.metastates.CableMetaStates;
import cookie.industry.block.energy.charger.BlockChargerEHV;
import cookie.industry.block.energy.charger.BlockChargerHV;
import cookie.industry.block.energy.charger.BlockChargerLV;
import cookie.industry.block.energy.charger.BlockChargerMV;
import cookie.industry.block.energy.charger.entity.*;
import cookie.industry.block.energy.generator.*;
import cookie.industry.block.energy.generator.entity.*;
import cookie.industry.block.machines.advanced.*;
import cookie.industry.block.machines.advanced.entity.*;
import cookie.industry.block.machines.basic.*;
import cookie.industry.block.machines.basic.entity.*;
import cookie.industry.block.machines.endgame.BlockEnergyFabricator;
import cookie.industry.block.machines.endgame.entity.TileEntityEnergyFabricator;
import cookie.industry.block.reactor.BlockReactor;
import cookie.industry.block.reactor.BlockReactorChamber;
import cookie.industry.block.reactor.BlockReactorIO;
import cookie.industry.block.reactor.BlockReactorRTG;
import cookie.industry.block.reactor.entity.TileEntityReactorIO;
import cookie.industry.block.reactor.entity.TileEntityReactorNewer;
import cookie.industry.block.reactor.entity.TileEntityReactorRTG;
import cookie.industry.block.storage.*;
import cookie.industry.block.storage.entity.*;
import cookie.industry.gui.generator.*;
import cookie.industry.gui.generator.reactor.ContainerReactorNewer;
import cookie.industry.gui.generator.reactor.GuiReactorNewer;
import cookie.industry.gui.machine.advanced.*;
import cookie.industry.gui.machine.basic.*;
import cookie.industry.gui.machine.endgame.ContainerFabricator;
import cookie.industry.gui.machine.endgame.GuiFabricator;
import cookie.industry.gui.storage.*;
import net.minecraft.client.render.block.color.BlockColorLeaves;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSounds;
import sunsetsatellite.catalyst.Catalyst;
import sunsetsatellite.catalyst.core.util.MpGuiEntry;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.block.BlockModelDragonFly;

public class I2Blocks {
    private final String MOD_ID = Industry2.MOD_ID;

    private int blockID = I2Config.cfg.getInt("IDs.startingBlockID");
    private int nextBlockID() {
        return ++blockID;
    }

    // Ore
    public static Block oreTinStone;
    public static Block oreTinBasalt;
    public static Block oreTinLimestone;
    public static Block oreTinGranite;
    public static Block oreCopperStone;
    public static Block oreCopperBasalt;
    public static Block oreCopperLimestone;
    public static Block oreCopperGranite;

    // Material Blocks
    public static Block blockTin;
    public static Block blockCopper;
    public static Block blockBronze;

    // Cables
    public static Block blockCableTin;
    public static Block blockCableCopper;
    public static Block blockCableGold;
    public static Block blockCableSteel;
    public static Block blockInsulatedCableTin;
    public static Block blockInsulatedCableCopper;
    public static Block blockInsulatedCableGold;
    public static Block blockInsulatedCableSteel;

    // Machines
    public static Block lvMachineCasing;
    public static Block mvMachineCasing;
    public static Block hvMachineCasing;
    public static Block ehvMachineCasing;
    public static Block lvGenerator;
    public static Block lvGeneratorWatermill;
    public static Block lvGeneratorWindmill;
    public static Block lvGeneratorGeothermal;
    public static Block ulvGeneratorSolar;
    public static Block lvGeneratorSolar;
    public static Block mvGeneratorSolar;
    public static Block hvGeneratorSolar;
    public static Block ehvGeneratorSolar;
    public static Block lvBatbox;
    public static Block mvBatbox;
    public static Block hvBatbox;
    public static Block ehvBatbox;
    public static Block transformerMVtoLV;
    public static Block transformerHVtoMV;
    public static Block transformerEHVtoHV;
    public static Block lvMachineFurnace;
    public static Block lvMachineMacerator;
    public static Block lvMachineCompressor;
    public static Block lvMachineWiremill;
    public static Block lvMachineExtractor;
    public static Block lvMachineRecycler;
    public static Block machineCannery;
    public static Block lvMachineTrommel;
    public static Block mvMachineFurnace;
    public static Block mvMachineMacerator;
    public static Block mvMachineCompressor;
    public static Block mvMachineWiremill;
    public static Block mvMachineExtractor;

    // Miscellaneous
    public static Block hardenedCoal;
    public static Block leavesRubberWood;
    public static Block logRubberWood;
    public static Block logRubberWoodResin;
    public static Block logRubberWoodResinFull;
    public static Block saplingRubberWood;

    // Nuclear
    public static Block nuclearReactor;
    public static Block nuclearChamber;
    public static Block nuclearIO;
    public static Block ulvGeneratorRTG;

    // End Game
    public static Block energyFabricator;

    public static Block alarm;
    public static Block LV_CHARGER;
    public static Block MV_CHARGER;
    public static Block HV_CHARGER;
    public static Block EHV_CHARGER;

    private void initializePickaxeLevels() {
        ItemToolPickaxe.miningLevels.put(oreTinStone, 1);
        ItemToolPickaxe.miningLevels.put(oreTinBasalt, 1);
        ItemToolPickaxe.miningLevels.put(oreTinLimestone, 1);
        ItemToolPickaxe.miningLevels.put(oreTinGranite, 1);
        ItemToolPickaxe.miningLevels.put(oreCopperStone, 1);
        ItemToolPickaxe.miningLevels.put(oreCopperBasalt, 1);
        ItemToolPickaxe.miningLevels.put(oreCopperLimestone, 1);
        ItemToolPickaxe.miningLevels.put(oreCopperGranite, 1);
        ItemToolPickaxe.miningLevels.put(LV_CHARGER, 1);
        ItemToolPickaxe.miningLevels.put(blockTin, 2);
        ItemToolPickaxe.miningLevels.put(blockCopper, 2);
        ItemToolPickaxe.miningLevels.put(blockBronze, 2);
        ItemToolPickaxe.miningLevels.put(lvGenerator, 2);
        ItemToolPickaxe.miningLevels.put(lvMachineCasing, 2);
        ItemToolPickaxe.miningLevels.put(mvMachineCasing, 2);
        ItemToolPickaxe.miningLevels.put(lvGeneratorWatermill, 2);
        ItemToolPickaxe.miningLevels.put(lvGeneratorWindmill, 2);
        ItemToolPickaxe.miningLevels.put(lvGeneratorGeothermal, 2);
        ItemToolPickaxe.miningLevels.put(lvGeneratorSolar, 2);
        ItemToolPickaxe.miningLevels.put(mvGeneratorSolar, 2);
        ItemToolPickaxe.miningLevels.put(hvGeneratorSolar, 2);
        ItemToolPickaxe.miningLevels.put(ehvGeneratorSolar, 2);
        ItemToolPickaxe.miningLevels.put(mvBatbox, 2);
        ItemToolPickaxe.miningLevels.put(hvBatbox, 2);
        ItemToolPickaxe.miningLevels.put(ehvBatbox, 2);
        ItemToolPickaxe.miningLevels.put(transformerMVtoLV, 2);
        ItemToolPickaxe.miningLevels.put(transformerHVtoMV, 2);
        ItemToolPickaxe.miningLevels.put(transformerEHVtoHV, 2);
        ItemToolPickaxe.miningLevels.put(alarm, 2);
        ItemToolPickaxe.miningLevels.put(ulvGeneratorRTG, 2);
        ItemToolPickaxe.miningLevels.put(MV_CHARGER, 2);
        ItemToolPickaxe.miningLevels.put(HV_CHARGER, 2);
        ItemToolPickaxe.miningLevels.put(EHV_CHARGER, 2);
        ItemToolPickaxe.miningLevels.put(hardenedCoal, 3);
    }

    private void registerGUIs() {
        Catalyst.GUIS.register("IndustryGenerator", new MpGuiEntry(TileEntityGenerator.class, GuiGenerator.class, ContainerGenerator.class));
        Catalyst.GUIS.register("IndustryWatermill", new MpGuiEntry(TileEntityGeneratorWatermill.class,GuiGeneratorWatermill.class,  ContainerGeneratorWatermill.class));
        Catalyst.GUIS.register("IndustryWindmill", new MpGuiEntry(TileEntityGeneratorWindmill.class,GuiGeneratorWindmill.class,  ContainerGeneratorWindmill.class));
        Catalyst.GUIS.register("IndustryGeothermal", new MpGuiEntry(TileEntityGeneratorGeothermal.class,GuiGeneratorGeothermal.class,  ContainerGeneratorGeothermal.class));
        Catalyst.GUIS.register("IndustrySolar", new MpGuiEntry(TileEntityGeneratorSolar.class,GuiGeneratorSolar.class,  ContainerSolarBase.class));
        Catalyst.GUIS.register("IndustryArrayLV", new MpGuiEntry(TileEntityArrayLV.class,GuiArrayLV.class,  ContainerSolarBase.class));
        Catalyst.GUIS.register("IndustryArrayMV", new MpGuiEntry(TileEntityArrayMV.class,GuiArrayMV.class,  ContainerSolarBase.class));
        Catalyst.GUIS.register("IndustryArrayHV", new MpGuiEntry(TileEntityArrayHV.class,GuiArrayHV.class,  ContainerSolarBase.class));
        Catalyst.GUIS.register("IndustryArrayEHV", new MpGuiEntry(TileEntityArrayEHV.class,GuiArrayEHV.class,  ContainerSolarBase.class));
        Catalyst.GUIS.register("IndustryBatboxLV", new MpGuiEntry(TileEntityBatboxLV.class,GuiBatboxLV.class,  ContainerBatboxBase.class));
        Catalyst.GUIS.register("IndustryBatboxMV", new MpGuiEntry(TileEntityBatboxMV.class,GuiBatboxMV.class,  ContainerBatboxBase.class));
        Catalyst.GUIS.register("IndustryBatboxHV", new MpGuiEntry(TileEntityBatboxHV.class,GuiBatboxHV.class,  ContainerBatboxBase.class));
        Catalyst.GUIS.register("IndustryBatboxEHV", new MpGuiEntry(TileEntityBatboxEHV.class,GuiBatboxEHV.class,  ContainerBatboxBase.class));
        Catalyst.GUIS.register("IndustryMachineFurnace", new MpGuiEntry(TileEntityMachineFurnace.class,GuiMachineFurnace.class,  ContainerMachineBase.class));
        Catalyst.GUIS.register("IndustryMachineMacerator", new MpGuiEntry(TileEntityMachineMacerator.class,GuiMachineMacerator.class,  ContainerMachineBase.class));
        Catalyst.GUIS.register("IndustryMachineCompressor", new MpGuiEntry(TileEntityMachineCompressor.class,GuiMachineCompressor.class,  ContainerMachineBase.class));
        Catalyst.GUIS.register("IndustryMachineWiremill", new MpGuiEntry(TileEntityMachineWiremill.class,GuiMachineWiremill.class,  ContainerMachineBase.class));
        Catalyst.GUIS.register("IndustryMachineExtractor", new MpGuiEntry(TileEntityMachineExtractor.class,GuiMachineExtractor.class,  ContainerMachineBase.class));
        Catalyst.GUIS.register("IndustryMachineRecycler", new MpGuiEntry(TileEntityMachineRecycler.class,GuiMachineRecycler.class,  ContainerMachineBase.class));
        Catalyst.GUIS.register("IndustryMachineCannery", new MpGuiEntry(TileEntityMachineCannery.class,GuiMachineCannery.class,  ContainerMachineCannery.class));
        Catalyst.GUIS.register("IndustryMachineTrommel", new MpGuiEntry(TileEntityMachineTrommel.class,GuiMachineTrommel.class,  ContainerMachineTrommel.class));
        Catalyst.GUIS.register("IndustryAdvancedFurnace", new MpGuiEntry(TileEntityAdvancedFurnace.class,GuiAdvancedFurnace.class,  ContainerAdvancedBase.class));
        Catalyst.GUIS.register("IndustryAdvancedMacerator", new MpGuiEntry(TileEntityAdvancedMacerator.class,GuiAdvancedMacerator.class,  ContainerAdvancedBase.class));
        Catalyst.GUIS.register("IndustryAdvancedCompressor", new MpGuiEntry(TileEntityAdvancedCompressor.class,GuiAdvancedCompressor.class,  ContainerAdvancedBase.class));
        Catalyst.GUIS.register("IndustryAdvancedWiremill", new MpGuiEntry(TileEntityAdvancedWiremill.class,GuiAdvancedWiremill.class,  ContainerAdvancedBase.class));
        Catalyst.GUIS.register("IndustryAdvancedExtractor", new MpGuiEntry(TIleEntityAdvancedExtractor.class,GuiAdvancedExtractor.class,  ContainerAdvancedBase.class));
        Catalyst.GUIS.register("IndustryReactor", new MpGuiEntry(TileEntityReactorNewer.class, GuiReactorNewer.class,  ContainerReactorNewer.class));
        Catalyst.GUIS.register("IndustryFabricator", new MpGuiEntry(TileEntityEnergyFabricator.class,GuiFabricator.class,  ContainerFabricator.class));
    }

    private void createTileEntities() {
        EntityHelper.Core.createTileEntity(TileEntityCable.class, "Cable");
        EntityHelper.Core.createTileEntity(TileEntityGenerator.class, "IndustryGenerator");
        EntityHelper.Core.createTileEntity(TileEntityGeneratorWatermill.class, "IndustryWatermill");
        EntityHelper.Core.createTileEntity(TileEntityGeneratorWindmill.class, "IndustryWindmill");
        EntityHelper.Core.createTileEntity(TileEntityGeneratorGeothermal.class, "IndustryGeothermal");
        EntityHelper.Core.createTileEntity(TileEntityGeneratorSolar.class, "IndustrySolar");
        EntityHelper.Core.createTileEntity(TileEntityArrayLV.class, "IndustryArrayLV");
        EntityHelper.Core.createTileEntity(TileEntityArrayMV.class, "IndustryArrayMV");
        EntityHelper.Core.createTileEntity(TileEntityArrayHV.class, "IndustryArrayHV");
        EntityHelper.Core.createTileEntity(TileEntityArrayEHV.class, "IndustryArrayEHV");
        EntityHelper.Core.createTileEntity(TileEntityBatboxLV.class, "IndustryBatboxLV");
        EntityHelper.Core.createTileEntity(TileEntityBatboxMV.class, "IndustryBatboxMV");
        EntityHelper.Core.createTileEntity(TileEntityBatboxHV.class, "IndustryBatboxHV");
        EntityHelper.Core.createTileEntity(TileEntityBatboxEHV.class, "IndustryBatboxEHV");
        EntityHelper.Core.createTileEntity(TileEntityTransformerMVtoLV.class, "IndustryTransformerMVtoLV");
        EntityHelper.Core.createTileEntity(TileEntityTransformerHVtoMV.class, "IndustryTransformerHVtoMV");
        EntityHelper.Core.createTileEntity(TileEntityTransformerEHVtoHV.class, "IndustryTransformerEHVtoHV");
        EntityHelper.Core.createTileEntity(TileEntityMachineFurnace.class, "IndustryMachineFurnace");
        EntityHelper.Core.createTileEntity(TileEntityMachineMacerator.class, "IndustryMachineMacerator");
        EntityHelper.Core.createTileEntity(TileEntityMachineCompressor.class, "IndustryMachineCompressor");
        EntityHelper.Core.createTileEntity(TileEntityMachineWiremill.class, "IndustryMachineWiremill");
        EntityHelper.Core.createTileEntity(TileEntityMachineExtractor.class, "IndustryMachineExtractor");
        EntityHelper.Core.createTileEntity(TileEntityMachineRecycler.class, "IndustryMachineRecycler");
        EntityHelper.Core.createTileEntity(TileEntityMachineCannery.class, "IndustryMachineCannery");
        EntityHelper.Core.createTileEntity(TileEntityMachineTrommel.class, "IndustryMachineTrommel");
        EntityHelper.Core.createTileEntity(TileEntityAdvancedFurnace.class, "IndustryAdvancedFurnace");
        EntityHelper.Core.createTileEntity(TileEntityAdvancedMacerator.class, "IndustryAdvancedMacerator");
        EntityHelper.Core.createTileEntity(TileEntityAdvancedCompressor.class, "IndustryAdvancedCompressor");
        EntityHelper.Core.createTileEntity(TileEntityAdvancedWiremill.class, "IndustryAdvancedWiremill");
        EntityHelper.Core.createTileEntity(TIleEntityAdvancedExtractor.class, "IndustryAdvancedExtractor");
        EntityHelper.Core.createTileEntity(TileEntityReactorNewer.class, "IndustryReactor");
        EntityHelper.Core.createTileEntity(TileEntityReactorIO.class, "IndustryReactorIO");
        EntityHelper.Core.createTileEntity(TileEntityEnergyFabricator.class, "IndustryFabricator");
        EntityHelper.Core.createTileEntity(TileEntityReactorRTG.class, "IndustryReactorRTG");
        EntityHelper.Core.createTileEntity(TileEntityChargerLV.class, "IndustryChargerLV");
        EntityHelper.Core.createTileEntity(TileEntityChargerMV.class, "IndustryChargerMV");
        EntityHelper.Core.createTileEntity(TileEntityChargerHV.class, "IndustryChargerHV");
        EntityHelper.Core.createTileEntity(TileEntityChargerEHV.class, "IndustryChargerEHV");
    }

    public void initializeBlocks() {
        BlockBuilder oreBuilder = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.STONE)
                .setHardness(3.5f)
                .setResistance(5.0f)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE);

        BlockBuilder MaterialBlockBuilder = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.METAL)
                .setHardness(5.0f)
                .setResistance(10.0f)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE);

        BlockBuilder cableBuilder = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.METAL)
                .setHardness(0.2f)
                .setResistance(0.0f)
                .setTags(BlockTags.NOT_IN_CREATIVE_MENU);

        BlockBuilder insulatedCableBuilder = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.CLOTH)
                .setHardness(0.2f)
                .setResistance(0.0f)
                .setTags(BlockTags.NOT_IN_CREATIVE_MENU);

        BlockBuilder machineBuilderBlank = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.METAL)
                .setHardness(5.0f)
                .setResistance(0.0f)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE);

        BlockBuilder machineBuilder = machineBuilderBlank
                .setTopBottomTexture("machine_casing_basic.png")
                .setEastTexture("machine_casing_basic.png")
                .setSouthTexture("machine_casing_basic.png")
                .setWestTexture("machine_casing_basic.png");

        BlockBuilder advancedMachineBuilder = machineBuilderBlank
                .setTopBottomTexture("machine_casing_advanced.png")
                .setEastTexture("machine_casing_advanced.png")
                .setSouthTexture("machine_casing_advanced.png")
                .setWestTexture("machine_casing_advanced.png");

        oreTinStone = oreBuilder
                .setTextures("ore_tin_stone.png")
                .build(new BlockOreTin("ore.tin.stone", nextBlockID(), Material.stone));

        oreTinBasalt = oreBuilder
                .setTextures("ore_tin_basalt.png")
                .build(new BlockOreTin("ore.tin.basalt", nextBlockID(), Material.stone));

        oreTinLimestone = oreBuilder
                .setTextures("ore_tin_limestone.png")
                .build(new BlockOreTin("ore.tin.limestone", nextBlockID(), Material.stone));

        oreTinGranite = oreBuilder
                .setTextures("ore_tin_granite.png")
                .build(new BlockOreTin("ore.tin.granite", nextBlockID(), Material.stone));

        oreCopperStone = oreBuilder
                .setTextures("ore_copper_stone.png")
                .build(new BlockOreCopper("ore.copper.stone", nextBlockID(), Material.stone));

        oreCopperBasalt = oreBuilder
                .setTextures("ore_copper_basalt.png")
                .build(new BlockOreCopper("ore.copper.basalt", nextBlockID(), Material.stone));

        oreCopperLimestone = oreBuilder
                .setTextures("ore_copper_limestone.png")
                .build(new BlockOreCopper("ore.copper.limestone", nextBlockID(), Material.stone));

        oreCopperGranite = oreBuilder
                .setTextures("ore_copper_granite.png")
                .build(new BlockOreCopper("ore.copper.granite", nextBlockID(), Material.stone));

        blockTin = MaterialBlockBuilder
                .setTopTexture("block_tin_top.png")
                .setSideTextures("block_tin_sides.png")
                .setBottomTexture("block_tin_bottom.png")
                .build(new Block("block.tin", nextBlockID(), Material.metal));

        blockCopper = MaterialBlockBuilder
                .setTopTexture("block_copper_top.png")
                .setSideTextures("block_copper_sides.png")
                .setBottomTexture("block_copper_bottom.png")
                .build(new Block("block.copper", nextBlockID(), Material.metal));

        blockBronze = MaterialBlockBuilder
                .setTopTexture("block_bronze_top.png")
                .setSideTextures("block_bronze_sides.png")
                .setBottomTexture("block_bronze_bottom.png")
                .build(new Block("block.bronze", nextBlockID(), Material.metal));

        blockCableTin = cableBuilder
                .setTextures("block_tin_top.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/cable_base.json"),
                        ModelHelper.getOrCreateBlockState(MOD_ID, "cable_tin.json"), new CableMetaStates(), true))
                .build(new BlockCableTin("cable.tin", nextBlockID(), Material.metal));

        blockCableCopper = cableBuilder
                .setTextures("block_copper_top.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/cable_base.json"),
                        ModelHelper.getOrCreateBlockState(MOD_ID, "cable_copper.json"), new CableMetaStates(), true))
                .build(new BlockCableCopper("cable.copper", nextBlockID(), Material.metal));

        blockCableGold = cableBuilder
                .setTextures(17, 4)
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/cable_base.json"),
                        ModelHelper.getOrCreateBlockState(MOD_ID, "cable_gold.json"), new CableMetaStates(), true))
                .build(new BlockCableGold("cable.gold", nextBlockID(), Material.metal));

        blockCableSteel = cableBuilder
                .setTextures(19, 4)
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/cable_base.json"),
                        ModelHelper.getOrCreateBlockState(MOD_ID, "cable_steel.json"), new CableMetaStates(), true))
                .build(new BlockCableSteel("cable.steel", nextBlockID(), Material.metal));

        blockInsulatedCableTin = insulatedCableBuilder
                .setTextures("insulated_cable_tin.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/cable_base.json"),
                        ModelHelper.getOrCreateBlockState(MOD_ID, "insulated_cable_tin.json"), new CableMetaStates(), true))
                .build(new BlockInsulatedCableTin("cable.tin", nextBlockID(), Material.cloth));

        blockInsulatedCableCopper = insulatedCableBuilder
                .setTextures("insulated_cable_copper.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/cable_base.json"),
                        ModelHelper.getOrCreateBlockState(MOD_ID, "insulated_cable_copper.json"), new CableMetaStates(), true))
                .build(new BlockInsulatedCableCopper("cable.copper", nextBlockID(), Material.cloth));

        blockInsulatedCableGold = insulatedCableBuilder
                .setTextures("insulated_cable_gold.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/cable_base.json"),
                        ModelHelper.getOrCreateBlockState(MOD_ID, "insulated_cable_gold.json"), new CableMetaStates(), true))
                .build(new BlockInsulatedCableGold("cable.gold", nextBlockID(), Material.cloth));

        blockInsulatedCableSteel = insulatedCableBuilder
                .setTextures("insulated_cable_steel.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/cable_base.json"),
                        ModelHelper.getOrCreateBlockState(MOD_ID, "insulated_cable_steel.json"), new CableMetaStates(), true))
                .build(new BlockInsulatedCableSteel("cable.steel", nextBlockID(), Material.cloth));

        lvMachineCasing = machineBuilderBlank
                .setTextures("machine_casing_basic.png")
                .build(new Block("machine.casing", nextBlockID(), Material.metal));

        mvMachineCasing = machineBuilderBlank
                .setTextures("machine_casing_advanced.png")
                .build(new Block("machine.casing.advanced", nextBlockID(), Material.metal));

        ehvMachineCasing = machineBuilder
                .setTextures("reactor_casing_sides.png")
                .build(new Block("machine.casing.ehv", nextBlockID(), Material.metal));

        lvGenerator = machineBuilder
                .setNorthTexture("generator.png")
                .build(new BlockGenerator("generator", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        lvGeneratorWatermill = machineBuilderBlank
                .setTopBottomTexture("machine_casing_basic.png")
                .setSideTextures("generator_watermill.png")
                .build(new BlockGeneratorWatermill("generator.watermill", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        lvGeneratorWindmill = machineBuilder
                .setNorthTexture("generator_windmill.png")
                .build(new BlockGeneratorWindmill("generator.windmill", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        lvGeneratorGeothermal = machineBuilder
                .setNorthTexture("generator_geothermal.png")
                .build(new BlockGeneratorGeothermal("generator.geothermal", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        ulvGeneratorSolar = machineBuilderBlank
                .setTopTexture("generator_solar.png")
                .setSideTextures("machine_casing_basic.png")
                .setBottomTexture("machine_casing_basic.png")
                .build(new BlockGeneratorSolar("generator.solar", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        lvGeneratorSolar = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.WOOD)
                .setHardness(5.0f)
                .setResistance(0.0f)
                .setTopTexture("arrayLV.png")
                .setBottomTexture("batboxLV_bottom.png")
                .setNorthTexture("batboxLV_front.png")
                .setSouthTexture("batboxLV_front.png")
                .setEastTexture("batboxLV_sides.png")
                .setWestTexture("batboxLV_sides.png")
                .build(new BlockArrayLV("array.lv", nextBlockID(), Material.wood))
                .withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_PICKAXE);

        mvGeneratorSolar = machineBuilderBlank
                .setTopTexture("arrayMV.png")
                .setBottomTexture("batboxMV_bottom.png")
                .setNorthTexture("batboxMV_front.png")
                .setSouthTexture("batboxMV_front.png")
                .setEastTexture("batboxMV_sides.png")
                .setWestTexture("batboxMV_sides.png")
                .build(new BlockArrayMV("array.mv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        hvGeneratorSolar = machineBuilderBlank
                .setTopTexture("generator_solar.png")
                .setBottomTexture("batboxHV_bottom.png")
                .setNorthTexture("batboxHV_front.png")
                .setSouthTexture("batboxHV_front.png")
                .setEastTexture("batboxHV_sides.png")
                .setWestTexture("batboxHV_sides.png")
                .build(new BlockArrayHV("array.hv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        ehvGeneratorSolar = machineBuilderBlank
                .setTopTexture("arrayEHV.png")
                .setBottomTexture("batboxEHV_bottom.png")
                .setNorthTexture("batboxEHV_front.png")
                .setSouthTexture("batboxEHV_front.png")
                .setEastTexture("batboxEHV_sides.png")
                .setWestTexture("batboxEHV_sides.png")
                .build(new BlockArrayEHV("array.ehv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        lvBatbox = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.WOOD)
                .setHardness(5.0f)
                .setResistance(0.0f)
                .setTopTexture("batboxLV_top.png")
                .setBottomTexture("batboxLV_bottom.png")
                .setNorthTexture("batboxLV_front.png")
                .setSouthTexture("batboxLV_front.png")
                .setEastTexture("batboxLV_sides.png")
                .setWestTexture("batboxLV_sides.png")
                .build(new BlockBatboxLV("batbox.lv", nextBlockID(), Material.wood))
                .withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_PICKAXE);

        mvBatbox = machineBuilderBlank
                .setTopTexture("batboxMV_top.png")
                .setBottomTexture("batboxMV_bottom.png")
                .setNorthTexture("batboxMV_front.png")
                .setSouthTexture("batboxMV_front.png")
                .setEastTexture("batboxMV_sides.png")
                .setWestTexture("batboxMV_sides.png")
                .build(new BlockBatboxMV("batbox.mv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        hvBatbox = machineBuilderBlank
                .setTopTexture("batboxHV_top.png")
                .setBottomTexture("batboxHV_bottom.png")
                .setNorthTexture("batboxHV_front.png")
                .setSouthTexture("batboxHV_front.png")
                .setEastTexture("batboxHV_sides.png")
                .setWestTexture("batboxHV_sides.png")
                .build(new BlockBatboxHV("batbox.hv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        ehvBatbox = machineBuilderBlank
                .setTopTexture("batboxEHV_top.png")
                .setBottomTexture("batboxEHV_bottom.png")
                .setNorthTexture("batboxEHV_front.png")
                .setSouthTexture("batboxEHV_front.png")
                .setEastTexture("batboxEHV_sides.png")
                .setWestTexture("batboxEHV_sides.png")
                .build(new BlockBatboxEHV("batbox.ehv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        transformerMVtoLV = machineBuilderBlank
                .setTopTexture("batboxMV_top.png")
                .setBottomTexture("batboxLV_bottom.png")
                .setNorthTexture("transformerMV_LV_front.png")
                .setSouthTexture("transformerMV_LV_front.png")
                .setEastTexture("transformerMV_LV_sides.png")
                .setWestTexture("transformerMV_LV_sides.png")
                .build(new BlockTransformerMVtoLV("transformer.mvtolv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        transformerHVtoMV = machineBuilderBlank
                .setTopTexture("batboxHV_top.png")
                .setBottomTexture("batboxMV_bottom.png")
                .setNorthTexture("transformerHV_MV_front.png")
                .setSouthTexture("transformerHV_MV_front.png")
                .setEastTexture("transformerHV_MV_sides.png")
                .setWestTexture("transformerHV_MV_sides.png")
                .build(new BlockTransformerHVtoMV("transformer.hvtomv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        transformerEHVtoHV = machineBuilderBlank
                .setTopTexture("batboxEHV_top.png")
                .setBottomTexture("batboxHV_bottom.png")
                .setNorthTexture("transformerEHV_HV_front.png")
                .setSouthTexture("transformerEHV_HV_front.png")
                .setEastTexture("transformerEHV_HV_sides.png")
                .setWestTexture("transformerEHV_HV_sides.png")
                .build(new BlockTransformerEHVtoHV("transformer.ehvtohv", nextBlockID(), Material.metal))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        lvMachineFurnace = machineBuilder
                .setNorthTexture("machine_furnace.png")
                .build(new BlockMachineFurnace("machine.furnace", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        lvMachineMacerator = machineBuilder
                .setNorthTexture("machine_macerator.png")
                .build(new BlockMachineMacerator("machine.macerator", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        lvMachineCompressor = machineBuilder
                .setNorthTexture("machine_compressor.png")
                .build(new BlockMachineCompressor("machine.compressor", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        lvMachineWiremill = machineBuilder
                .setNorthTexture("machine_wiremill.png")
                .build(new BlockMachineWiremill("machine.wiremill", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        lvMachineExtractor = machineBuilder
                .setNorthTexture("machine_extractor.png")
                .build(new BlockMachineExtractor("machine.extractor", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        lvMachineRecycler = machineBuilder
                .setNorthTexture("machine_recycler.png")
                .build(new BlockMachineRecycler("machine.recycler", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        machineCannery = machineBuilder
                .setNorthTexture("machine_cannery.png")
                .build(new BlockMachineCannery("machine.cannery", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        lvMachineTrommel = machineBuilder
                .setNorthTexture("machine_trommel.png")
                .build(new BlockMachineTrommel("machine.trommel", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        mvMachineFurnace = advancedMachineBuilder
                .setNorthTexture("advanced_furnace.png")
                .build(new BlockAdvancedFurnace("advanced.furnace", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        mvMachineMacerator = advancedMachineBuilder
                .setNorthTexture("advanced_macerator.png")
                .build(new BlockAdvancedMacerator("advanced.macerator", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        mvMachineCompressor = advancedMachineBuilder
                .setNorthTexture("advanced_compressor.png")
                .build(new BlockAdvancedCompressor("advanced.compressor", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        mvMachineWiremill = advancedMachineBuilder
                .setNorthTexture("advanced_wiremill.png")
                .build(new BlockAdvancedWiremill("advanced.wiremill", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        mvMachineExtractor = advancedMachineBuilder
                .setNorthTexture("advanced_extractor.png")
                .build(new BlockAdvancedExtractor("advanced.extractor", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        hardenedCoal = new BlockBuilder(MOD_ID)
                .setTextures("hardened_coal.png")
                .setBlockSound(BlockSounds.STONE)
                .setHardness(10.0f)
                .setResistance(2000.0f)
                .build(new Block("block.coal.hardened", nextBlockID(), Material.stone))
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        leavesRubberWood = new BlockBuilder(MOD_ID)
                .setTextures(2, 20)
                .setBlockSound(BlockSounds.GRASS)
                .setBlockColor(new BlockColorLeaves("pine"))
                .setHardness(0.2f)
                .setLightOpacity(1)
                .build(new BlockLeavesRubberwood("leaves.rubber", nextBlockID()))
                .withTags(BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS)
                .setTicking(true)
                .withDisabledNeighborNotifyOnMetadataChange()
                .withDisabledStats();

        logRubberWood = new BlockBuilder(MOD_ID)
                .setTopBottomTexture("log_rubber_top.png")
                .setSideTextures("log_rubber.png")
                .setBlockSound(BlockSounds.WOOD)
                .setHardness(2.0f)
                .build(new BlockLog("log.rubber", nextBlockID()))
                .withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
                .withDisabledNeighborNotifyOnMetadataChange();

        logRubberWoodResin = new BlockBuilder(MOD_ID)
                .setTopBottomTexture("log_rubber_top.png")
                .setSideTextures("log_rubber.png")
                .setBlockSound(BlockSounds.WOOD)
                .setHardness(2.0f)
                .setBlockModel(new BlockModelRenderBlocks(27))
                .build(new BlockLogResin("log.rubber.resin", nextBlockID()))
                .withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT, BlockTags.NOT_IN_CREATIVE_MENU)
                .withDisabledNeighborNotifyOnMetadataChange();

        logRubberWoodResinFull = new BlockBuilder(MOD_ID)
                .setTopBottomTexture("log_rubber_top.png")
                .setSideTextures("log_rubber.png")
                .setBlockSound(BlockSounds.WOOD)
                .setHardness(2.0f)
                .setBlockModel(new BlockModelRenderBlocks(27))
                .build(new BlockLogResinFull("log.rubber.resin", nextBlockID()))
                .withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
                .withDisabledNeighborNotifyOnMetadataChange();

        saplingRubberWood = new BlockBuilder(MOD_ID)
                .setTextures("sapling_rubber.png")
                .setBlockSound(BlockSounds.GRASS)
                .setBlockModel(new BlockModelRenderBlocks(1))
                .build(new BlockSaplingRubberwood("sapling.rubber", nextBlockID()))
                .withTags(BlockTags.BROKEN_BY_FLUIDS)
                .setTicking(true)
                .withDisabledNeighborNotifyOnMetadataChange();

        nuclearReactor = new BlockBuilder(MOD_ID)
                .setTopBottomTexture("reactorIO_bottom.png")
                .setSideTextures("reactor.png")
                .setBlockSound(BlockSounds.METAL)
                .setHardness(10.0f)
                .setResistance(0.0f)
                .build(new BlockReactor("reactor", nextBlockID(), false));

        nuclearChamber = new BlockBuilder(MOD_ID)
                .setTopBottomTexture("reactor_casing_top.png")
                .setSideTextures("reactor_casing_sides.png")
                .setBlockSound(BlockSounds.METAL)
                .setHardness(10.0f)
                .setResistance(0.0f)
                .build(new BlockReactorChamber("reactor.chamber", nextBlockID(), Material.metal));

        nuclearIO = new BlockBuilder(MOD_ID)
                .setTopTexture("reactorIO_top.png")
                .setBottomTexture("reactorIO_bottom.png")
                .setNorthTexture("reactorIO_front.png")
                .setSouthTexture("reactorIO_front.png")
                .setEastTexture("reactorIO_sides.png")
                .setWestTexture("reactorIO_sides.png")
                .setBlockSound(BlockSounds.METAL)
                .setHardness(10.0F)
                .setResistance(0.0F)
                .build(new BlockReactorIO("reactor.io", nextBlockID(), Material.metal));

        ulvGeneratorRTG = new BlockBuilder(MOD_ID)
                .setTextures("reactor_casing_top.png")
                .setBlockSound(BlockSounds.METAL)
                .setHardness(10.0F)
                .setResistance(0.0F)
                .build(new BlockReactorRTG("reactor.rtg", nextBlockID()));

        energyFabricator = new BlockBuilder(MOD_ID)
                .setTopBottomTexture("machine_casing_advanced.png")
                .setNorthTexture("endgame_fabricator.png")
                .setEastTexture("machine_casing_advanced.png")
                .setSouthTexture("machine_casing_advanced.png")
                .setWestTexture("machine_casing_advanced.png")
                .setBlockSound(BlockSounds.METAL)
                .setHardness(10.0f)
                .setResistance(0.0f)
                .build(new BlockEnergyFabricator("fabricator", nextBlockID(), Material.metal))
                .withTags(IndustryTags.REQUIRES_WRENCH);

        alarm = new BlockBuilder(MOD_ID)
                .setTopBottomTexture("block_bronze_sides.png")
                .setSideTextures("alarm_front.png")
                .setBlockSound(BlockSounds.METAL)
                .setHardness(5.0F)
                .build(new BlockAlarm("alarm", nextBlockID()))
                .setTicking(true)
                .withTags(BlockTags.MINEABLE_BY_PICKAXE);

        LV_CHARGER = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.WOOD)
                .setHardness(5.0f)
                .setResistance(0.0f)
                .setTextures("charger_lv.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/charger/charger_lv.json"))
                )
                .setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_PICKAXE)
                .build(new BlockChargerLV("lv_charger", nextBlockID()));

        MV_CHARGER = machineBuilder
                .setTextures("charger_mv.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/charger/charger_mv.json"))
                )
                .setTags(BlockTags.NOT_IN_CREATIVE_MENU)
                .build(new BlockChargerMV("mv_charger", nextBlockID()));

        HV_CHARGER = machineBuilder
                .setTextures("charger_hv.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/charger/charger_hv.json"))
                )
                .setTags(BlockTags.NOT_IN_CREATIVE_MENU)
                .build(new BlockChargerHV("hv_charger", nextBlockID()));

        EHV_CHARGER = machineBuilder
                .setTextures("charger_ehv.png")
                .setBlockModel(new BlockModelDragonFly(
                        ModelHelper.getOrCreateBlockModel(MOD_ID, "block/charger/charger_ehv.json"))
                )
                .setTags(BlockTags.NOT_IN_CREATIVE_MENU)
                .build(new BlockChargerEHV("ehv_charger", nextBlockID()));

        registerGUIs();
        createTileEntities();
        initializePickaxeLevels();
    }
}

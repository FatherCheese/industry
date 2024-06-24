package cookie.industry.core.block;

import cookie.industry.client.gui.batteryboxes.ContainerLVBatterybox;
import cookie.industry.client.gui.batteryboxes.GuiLVBatterybox;
import cookie.industry.client.gui.machines.lv.generators.*;
import cookie.industry.client.gui.machines.lv.production.*;
import cookie.industry.core.I2Config;
import cookie.industry.core.I2Tags;
import cookie.industry.core.block.energy.batteryboxes.BlockLVBatterybox;
import cookie.industry.core.block.energy.batteryboxes.entities.TileEntityLVBatterybox;
import cookie.industry.core.block.energy.cables.*;
import cookie.industry.core.block.energy.cables.entity.TileEntityCable;
import cookie.industry.core.block.energy.cables.metastates.CableMetaStates;
import cookie.industry.core.block.machines.lv.generators.BlockLVCombustionGenerator;
import cookie.industry.core.block.machines.lv.generators.BlockLVSolarPanel;
import cookie.industry.core.block.machines.lv.generators.BlockLVWatermill;
import cookie.industry.core.block.machines.lv.generators.entities.TileEntityLVCombustionGenerator;
import cookie.industry.core.block.machines.lv.generators.entities.TileEntityLVSolarPanel;
import cookie.industry.core.block.machines.lv.generators.entities.TileEntityLVWatermill;
import cookie.industry.core.block.machines.lv.models.BlockModelMachineBase;
import cookie.industry.core.block.machines.lv.production.*;
import cookie.industry.core.block.machines.lv.production.entities.*;
import net.minecraft.client.render.block.model.BlockModelAxisAligned;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelHorizontalRotation;
import net.minecraft.client.render.block.model.BlockModelLeaves;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import org.useless.dragonfly.model.block.DFBlockModelBuilder;
import sunsetsatellite.catalyst.Catalyst;
import sunsetsatellite.catalyst.core.util.MpGuiEntry;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;

import static cookie.industry.Industry2.MOD_ID;

public class I2BlocksNew {

    // MISCELLANEOUS //
    public static Block BLOCK_OF_TIN;
    public static Block BLOCK_OF_COPPER;
    public static Block BLOCK_OF_BRONZE;
    public static Block BLOCK_OF_TITANIUM;
    public static Block ALARM;
    public static Block RUBBERWOOD_LOG;
    public static Block RUBBERWOOD_RESIN_LOG;
    public static Block EMPTY_RUBBERWOOD_RESIN_LOG;
    public static Block RUBBERWOOD_LEAVES;
    public static Block RUBBERWOOD_SAPLING;
    public static Block HARDENED_CARBON;

    // ORES //
    public static Block STONE_TIN_ORE;
    public static Block BASALT_TIN_ORE;
    public static Block LIMESTONE_TIN_ORE;
    public static Block GRANITE_TIN_ORE;
    public static Block STONE_COPPER_ORE;
    public static Block BASALT_COPPER_ORE;
    public static Block LIMESTONE_COPPER_ORE;
    public static Block GRANITE_COPPER_ORE;

    // CABLES //
    public static Block COPPER_CABLE;
    public static Block GOLD_CABLE;
    public static Block STEEL_CABLE;
    public static Block TITANIUM_CABLE;
    public static Block INSULATED_COPPER_CABLE;
    public static Block INSULATED_GOLD_CABLE;
    public static Block INSULATED_STEEL_CABLE;
    public static Block INSULATED_TITANIUM_CABLE;

    // LV MACHINES //
    public static Block LV_MACHINE_CASING;
    public static Block LV_COMBUSTION_GENERATOR;
    public static Block LV_WATERMILL;
    public static Block LV_SOLAR_PANEL;

    public static Block LV_FURNACE;
    public static Block LV_MACERATOR;
    public static Block LV_COMPRESSOR;
    public static Block LV_WIREMILL;
    public static Block LV_EXTRACTOR;
    public static Block LV_RECYCLER;
    public static Block LV_CANNING_MACHINE;
    public static Block LV_TROMMEL;

    // MV MACHINES //
    public static Block MV_MACHINE_CASING;
    public static Block MV_OIL_GENERATOR;

    public static Block MV_FURNACE;
    public static Block MV_MACERATOR;
    public static Block MV_COMPRESSOR;
    public static Block MV_WIREMILL;
    public static Block MV_EXTRACTOR;
    public static Block MV_RECYCLER;
    public static Block MV_CANNERY;
    public static Block MV_TROMMEL;
    public static Block MV_OIL_DRILL;

    // HV MACHINES //
    public static Block HV_MACHINE_CASING;
    public static Block HV_GEOTHERMAL_GENERATOR;
    public static Block HV_WINDMILL;

    public static Block HV_FURNACE;
    public static Block HV_MACERATOR;
    public static Block HV_COMPRESSOR;
    public static Block HV_WIREMILL;
    public static Block HV_EXTRACTOR;
    public static Block HV_RECYCLER;
    public static Block HV_CANNERY;
    public static Block HV_TROMMEL;
    public static Block HV_CORE_DRILL;

    // EHV_MACHINES //
    public static Block EHV_MACHINE_CASING;
    public static Block EHV_FURNACE;
    public static Block EHV_MACERATOR;
    public static Block EHV_COMPRESSOR;
    public static Block EHV_WIREMILL;
    public static Block EHV_EXTRACTOR;
    public static Block EHV_RECYCLER;
    public static Block EHV_CANNERY;
    public static Block EHV_TROMMEL;
    public static Block EHV_CORE_DRILL;
    public static Block ENERGY_FABRICATOR;

    // MISCELLANEOUS MACHINES //
    public static Block LV_SOLAR_ARRAY;
    public static Block MV_SOLAR_ARRAY;
    public static Block HV_SOLAR_ARRAY;
    public static Block EHV_SOLAR_ARRAY;
    public static Block LV_BATTERYBOX;
    public static Block MV_BATTERY_BOX;
    public static Block HV_BATTERY_BOX;
    public static Block EHV_BATTERY_BOX;
    public static Block EHV_TO_HV_TRANSFORMER;
    public static Block HV_TO_MV_TRANSFORMER;
    public static Block MV_TO_LV_TRANSFORMER;
    public static Block LV_CHARGING_PAD;
    public static Block MV_CHARGING_PAD;
    public static Block HV_CHARGING_PAD;
    public static Block EHV_CHARGING_PAD;

    // NUCLEAR STUFF //
    public static Block REACTOR_CORE;
    public static Block REACTOR_CHAMBER;
    public static Block REACTOR_IO;
    public static Block REACTOR_RTG;

    private static int startingID = I2Config.cfg.getInt("IDs.startingBlockID");
    private static int nextID() {
        return ++startingID;
    }

    private static void initializeTiles() {
        EntityHelper.createTileEntity(TileEntityCable.class, "IndustryCable");
        EntityHelper.createTileEntity(TileEntityLVCombustionGenerator.class, "IndustryLVCombustionGenerator");
        EntityHelper.createTileEntity(TileEntityLVWatermill.class, "IndustryLVWatermill");
        EntityHelper.createTileEntity(TileEntityLVSolarPanel.class, "IndustryLVSolarPanel");
        EntityHelper.createTileEntity(TileEntityLVFurnace.class, "IndustryLVFurnace");
        EntityHelper.createTileEntity(TileEntityLVMacerator.class, "IndustryLVMacerator");
        EntityHelper.createTileEntity(TileEntityLVCompressor.class, "IndustryLVCompressor");
        EntityHelper.createTileEntity(TileEntityLVWiremill.class, "IndustryLVWiremill");
        EntityHelper.createTileEntity(TileEntityLVExtractor.class, "IndustryLVExtractor");
        EntityHelper.createTileEntity(TileEntityLVRecycler.class, "IndustryLVRecycler");
        EntityHelper.createTileEntity(TileEntityLVCanningMachine.class, "IndustryLVCanningMachine");

        EntityHelper.createTileEntity(TileEntityLVBatterybox.class, "IndustryLVBatterybox");
    }

    private static void initializeGUIs() {
        Catalyst.GUIS.register("IndustryLVCombustionGenerator", new MpGuiEntry(TileEntityLVCombustionGenerator.class, GuiLVCombustionGenerator.class, ContainerLVCombustionGenerator.class));
        Catalyst.GUIS.register("IndustryLVWatermill", new MpGuiEntry(TileEntityLVWatermill.class, GuiLVWatermill.class, ContainerLVWatermill.class));
        Catalyst.GUIS.register("IndustryLVSolarPanel", new MpGuiEntry(TileEntityLVSolarPanel.class, GuiLVSolarPanel.class, ContainerLVSolarPanel.class));
        Catalyst.GUIS.register("IndustryLVFurnace", new MpGuiEntry(TileEntityLVFurnace.class, GuiLVFurnace.class, ContainerLVMachineBase.class));
        Catalyst.GUIS.register("IndustryLVMacerator", new MpGuiEntry(TileEntityLVMacerator.class, GuiLVMacerator.class, ContainerLVMachineBase.class));
        Catalyst.GUIS.register("IndustryLVCompressor", new MpGuiEntry(TileEntityLVCompressor.class, GuiLVCompressor.class, ContainerLVMachineBase.class));
        Catalyst.GUIS.register("IndustryLVWiremill", new MpGuiEntry(TileEntityLVWiremill.class, GuiLVWiremill.class, ContainerLVMachineBase.class));
        Catalyst.GUIS.register("IndustryLVExtractor", new MpGuiEntry(TileEntityLVExtractor.class, GuiLVExtractor.class, ContainerLVMachineBase.class));
        Catalyst.GUIS.register("IndustryLVRecycler", new MpGuiEntry(TileEntityLVRecycler.class, GuiLVRecycler.class, ContainerLVMachineBase.class));
        Catalyst.GUIS.register("IndustryLVCanningMachine", new MpGuiEntry(TileEntityLVCanningMachine.class, GuiLVCanningMachine.class, ContainerLVCanningMachine.class));

        Catalyst.GUIS.register("IndustryLVBatterybox", new MpGuiEntry(TileEntityLVBatterybox.class, GuiLVBatterybox.class, ContainerLVBatterybox.class));
    }

    public static void initializeBlocks() {
        BlockBuilder LOG_BUILDER = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.WOOD)
                .setHardness(2.0F)
                .setTopBottomTextures("industry:block/rubberwood_log_top")
                .setSideTextures("industry:block/rubberwood_log_sides")
                .setBlockModel(BlockModelAxisAligned::new);

        BlockBuilder ORE_BUILDER = new BlockBuilder(MOD_ID)
                .setHardness(3.0F)
                .setResistance(5.0F)
                .setBlockSound(BlockSounds.STONE)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE);

        BlockBuilder MATERIAL_BLOCK_BUILDER = new BlockBuilder(MOD_ID)
                .setHardness(5.0F)
                .setResistance(10.0F)
                .setBlockSound(BlockSounds.METAL)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE);

        BlockBuilder CABLE_BUILDER = new BlockBuilder(MOD_ID)
                .setHardness(1.0F)
                .setTags(BlockTags.NOT_IN_CREATIVE_MENU, I2Tags.MINEABLE_BY_CUTTERS);

        BlockBuilder MACHINE_BUILDER = new BlockBuilder(MOD_ID)
                .setHardness(5.0F)
                .setBlockSound(BlockSounds.METAL)
                .setTags(I2Tags.MINEABLE_BY_WRENCH, BlockTags.MINEABLE_BY_PICKAXE);


        RUBBERWOOD_LOG = LOG_BUILDER
                .setTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE)
                .build(new BlockLog("rubberwood_log", nextID()))
                .withDisabledNeighborNotifyOnMetadataChange();

        RUBBERWOOD_RESIN_LOG = LOG_BUILDER
                .setTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE)
                .build(new BlockLogResinFull("rubberwood_resin_log", nextID()))
                .withDisabledNeighborNotifyOnMetadataChange();

        EMPTY_RUBBERWOOD_RESIN_LOG = LOG_BUILDER
                .setTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_AXE, BlockTags.NOT_IN_CREATIVE_MENU)
                .build(new BlockLogResin("empty_rubberwood_resin_log", nextID()))
                .withDisabledNeighborNotifyOnMetadataChange();

        RUBBERWOOD_LEAVES = new BlockBuilder(MOD_ID)
                .setHardness(0.2F)
                .setTextures("industry:block/rubberwood_leaves")
                .setBlockSound(BlockSounds.GRASS)
                .setBlockModel(block -> new BlockModelLeaves<>(block, "industry:block/rubberwood_leaves"))
                .setTags(BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS)
                .build(new BlockLeavesRubberwood("rubberwood_leaves", nextID()))
                .withLightBlock(1)
                .withDisabledStats()
                .withDisabledNeighborNotifyOnMetadataChange();

        RUBBERWOOD_SAPLING = new BlockBuilder(MOD_ID)
                .setTextures("industry:block/rubberwood_sapling")
                .setBlockSound(BlockSounds.GRASS)
                .setBlockModel(BlockModelCrossedSquares::new)
                .setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR)
                .build(new BlockSaplingRubberwood("rubberwood_sapling", nextID()))
                .withDisabledNeighborNotifyOnMetadataChange();

        STONE_TIN_ORE = ORE_BUILDER
                .setTextures("industry:block/ore_tin_stone")
                .build(new BlockOreTin("stone_tin_ore", nextID()));
        BASALT_TIN_ORE = ORE_BUILDER
                .setTextures("industry:block/ore_tin_basalt")
                .build(new BlockOreTin("basalt_tin_ore", nextID()));
        LIMESTONE_TIN_ORE = ORE_BUILDER
                .setTextures("industry:block/ore_tin_limestone")
                .build(new BlockOreTin("limestone_tin_ore", nextID()));
        GRANITE_TIN_ORE = ORE_BUILDER
                .setTextures("industry:block/ore_tin_granite")
                .build(new BlockOreTin("granite_tin_ore", nextID()));
        STONE_COPPER_ORE = ORE_BUILDER
                .setTextures("industry:block/ore_copper_stone")
                .build(new BlockOreCopper("stone_tin_ore", nextID()));
        BASALT_COPPER_ORE = ORE_BUILDER
                .setTextures("industry:block/ore_copper_basalt")
                .build(new BlockOreCopper("basalt_tin_ore", nextID()));
        LIMESTONE_COPPER_ORE = ORE_BUILDER
                .setTextures("industry:block/ore_copper_limestone")
                .build(new BlockOreCopper("limestone_tin_ore", nextID()));
        GRANITE_COPPER_ORE = ORE_BUILDER
                .setTextures("industry:block/ore_copper_granite")
                .build(new BlockOreCopper("granite_tin_ore", nextID()));

        BLOCK_OF_TIN = MATERIAL_BLOCK_BUILDER
                .setTopTexture("industry:block/block_tin_top")
                .setSideTextures("industry:block/block_tin_sides")
                .setBottomTexture("industry:block/block_tin_bottom")
                .build(new Block("block_of_tin", nextID(), Material.metal));
        BLOCK_OF_COPPER = MATERIAL_BLOCK_BUILDER
                .setTopTexture("industry:block/block_copper_top")
                .setSideTextures("industry:block/block_copper_sides")
                .setBottomTexture("industry:block/block_copper_bottom")
                .build(new Block("block_of_copper", nextID(), Material.metal));
        BLOCK_OF_BRONZE = MATERIAL_BLOCK_BUILDER
                .setTopTexture("industry:block/block_bronze_top")
                .setSideTextures("industry:block/block_bronze_sides")
                .setBottomTexture("industry:block/block_bronze_bottom")
                .build(new Block("block_of_bronze", nextID(), Material.metal));
        BLOCK_OF_TITANIUM = MATERIAL_BLOCK_BUILDER
                .setTopTexture("industry:block/block_titanium_top")
                .setSideTextures("industry:block/block_titanium_sides")
                .setBottomTexture("industry:block/block_titanium_bottom")
                .build(new Block("block_of_titanium", nextID(), Material.metal));

        COPPER_CABLE = CABLE_BUILDER
                .setTextures("industry:block/block_copper_top")
                .setBlockSound(BlockSounds.METAL)
                .setBlockModel(block -> new DFBlockModelBuilder(MOD_ID)
                        .setBlockModel("block/cable_base.json")
                        .setBlockState("cable_copper.json")
                        .setMetaStateInterpreter(new CableMetaStates())
                        .build(block))
                .build(new BlockCableCopper("copper_cable", nextID()));
        GOLD_CABLE = CABLE_BUILDER
                .setTextures("minecraft:block/block_gold_top")
                .setBlockSound(BlockSounds.METAL)
                .setBlockModel(block -> new DFBlockModelBuilder(MOD_ID)
                        .setBlockModel("block/cable_base.json")
                        .setBlockState("cable_gold.json")
                        .setMetaStateInterpreter(new CableMetaStates())
                        .build(block))
                .build(new BlockCableGold("gold_cable", nextID()));
        STEEL_CABLE = CABLE_BUILDER
                .setTextures("minecraft:block/block_steel_top")
                .setBlockSound(BlockSounds.METAL)
                .setBlockModel(block -> new DFBlockModelBuilder(MOD_ID)
                        .setBlockModel("block/cable_base.json")
                        .setBlockState("cable_steel.json")
                        .setMetaStateInterpreter(new CableMetaStates())
                        .build(block))
                .build(new BlockCableSteel("steel_cable", nextID()));
        TITANIUM_CABLE = CABLE_BUILDER
                .setTextures("industry:block/block_titanium_top")
                .setBlockSound(BlockSounds.METAL)
                .setBlockModel(block -> new DFBlockModelBuilder(MOD_ID)
                        .setBlockModel("block/cable_base.json")
                        .setBlockState("cable_titanium.json")
                        .setMetaStateInterpreter(new CableMetaStates())
                        .build(block))
                .build(new BlockCableTitanium("titanium", nextID()));
        INSULATED_COPPER_CABLE = CABLE_BUILDER
                .setTextures("industry:block/insulated_copper_cable")
                .setBlockSound(BlockSounds.CLOTH)
                .setBlockModel(block -> new DFBlockModelBuilder(MOD_ID)
                        .setBlockModel("block/cable_base.json")
                        .setBlockState("insulated_cable_copper.json")
                        .setMetaStateInterpreter(new CableMetaStates())
                        .build(block))
                .build(new BlockInsulatedCableCopper("insulated_copper_cable", nextID()));
        INSULATED_GOLD_CABLE = CABLE_BUILDER
                .setTextures("industry:block/insulated_gold_cable")
                .setBlockSound(BlockSounds.CLOTH)
                .setBlockModel(block -> new DFBlockModelBuilder(MOD_ID)
                        .setBlockModel("block/cable_base.json")
                        .setBlockState("insulated_cable_gold.json")
                        .setMetaStateInterpreter(new CableMetaStates())
                        .build(block))
                .build(new BlockInsulatedCableGold("insulated_gold_cable", nextID()));
        INSULATED_STEEL_CABLE = CABLE_BUILDER
                .setTextures("industry:block/insulated_steel_cable")
                .setBlockSound(BlockSounds.CLOTH)
                .setBlockModel(block -> new DFBlockModelBuilder(MOD_ID)
                        .setBlockModel("block/cable_base.json")
                        .setBlockState("insulated_cable_steel.json")
                        .setMetaStateInterpreter(new CableMetaStates())
                        .build(block))
                .build(new BlockInsulatedCableSteel("insulated_steel_cable", nextID()));
        INSULATED_TITANIUM_CABLE = CABLE_BUILDER
                .setBlockSound(BlockSounds.CLOTH)
                .setBlockModel(block -> new DFBlockModelBuilder(MOD_ID)
                        .setBlockModel("block/cable_base.json")
                        .setBlockState("insulated_cable_titanium.json")
                        .setMetaStateInterpreter(new CableMetaStates())
                        .build(block))
                .build(new BlockInsulatedCableTitanium("insulated_tin_cable", nextID()));

        LV_MACHINE_CASING = MACHINE_BUILDER
                .setTextures("industry:block/lv_machine_casing")
                .build(new Block("lv_machine_casing", nextID(), Material.metal));
        LV_COMBUSTION_GENERATOR = MACHINE_BUILDER
                .setNorthTexture("industry:block/lv_machine_casing")
                .setSouthTexture("industry:block/lv_combustion_generator_off")
                .setEastWestTextures("industry:block/lv_machine_casing")
                .setTopBottomTextures("industry:block/lv_machine_casing")
                .setBlockModel(block -> new BlockModelMachineBase(
                        block,
                        "lv_combustion_generator_off",
                        "lv_combustion_generator_on",
                        "lv_machine_casing")
                )
                .build(new BlockLVCombustionGenerator("lv_combustion_generator", nextID()));
        LV_WATERMILL = MACHINE_BUILDER
                .setSideTextures("industry:block/lv_watermill")
                .setTopBottomTextures("industry:block/lv_machine_top")
                .build(new BlockLVWatermill("lv_watermill", nextID()));
        LV_SOLAR_PANEL = MACHINE_BUILDER
                .setTopTexture("industry:block/lv_solar")
                .setNorthSouthTextures("industry:block/lv_batterybox_front")
                .setEastWestTextures("industry:block/lv_batterybox_sides")
                .setBottomTexture("industry:block/lv_batterybox_bottom")
                .build(new BlockLVSolarPanel("lv_solar_panel", nextID()));

        LV_FURNACE = MACHINE_BUILDER
                .setNorthTexture("industry:block/lv_machine_casing")
                .setSouthTexture("industry:block/lv_furnace_off")
                .setEastWestTextures("industry:block/lv_machine_casing")
                .setTopBottomTextures("industry:block/lv_machine_casing")
                .setBlockModel(block -> new BlockModelMachineBase(
                        block,
                        "lv_furnace_off",
                        "lv_furnace_on",
                        "lv_machine_casing"
                        )
                )
                .build(new BlockLVFurnace("lv_furnace", nextID()));
        LV_MACERATOR = MACHINE_BUILDER
                .setNorthTexture("industry:block/lv_machine_casing")
                .setSouthTexture("industry:block/lv_macerator_off")
                .setEastWestTextures("industry:block/lv_machine_casing")
                .setTopBottomTextures("industry:block/lv_machine_casing")
                .setBlockModel(block -> new BlockModelMachineBase(
                                block,
                                "lv_macerator_off",
                                "lv_macerator_on",
                                "lv_machine_casing"
                        )
                )
                .build(new BlockLVMacerator("lv_macerator", nextID()));
        LV_COMPRESSOR = MACHINE_BUILDER
                .setNorthTexture("industry:block/lv_machine_casing")
                .setSouthTexture("industry:block/lv_compressor_off")
                .setEastWestTextures("industry:block/lv_machine_casing")
                .setTopBottomTextures("industry:block/lv_machine_casing")
                .setBlockModel(block -> new BlockModelMachineBase(
                                block,
                                "lv_compressor_off",
                                "lv_compressor_on",
                                "lv_machine_casing"
                        )
                )
                .build(new BlockLVCompressor("lv_compressor", nextID()));
        LV_WIREMILL = MACHINE_BUILDER
                .setNorthTexture("industry:block/lv_machine_casing")
                .setSouthTexture("industry:block/lv_wiremill_off")
                .setEastWestTextures("industry:block/lv_machine_casing")
                .setTopBottomTextures("industry:block/lv_machine_casing")
                .setBlockModel(block -> new BlockModelMachineBase(
                                block,
                                "lv_wiremill_off",
                                "lv_wiremill_on",
                                "lv_machine_casing"
                        )
                )
                .build(new BlockLVWiremill("lv_wiremill", nextID()));
        LV_EXTRACTOR = MACHINE_BUILDER
                .setNorthTexture("industry:block/lv_machine_casing")
                .setSouthTexture("industry:block/lv_extractor_off")
                .setEastWestTextures("industry:block/lv_machine_casing")
                .setTopBottomTextures("industry:block/lv_machine_casing")
                .setBlockModel(block -> new BlockModelMachineBase(
                                block,
                                "lv_extractor_off",
                                "lv_extractor_on",
                                "lv_machine_casing"
                        )
                )
                .build(new BlockLVExtractor("lv_extractor", nextID()));

        LV_RECYCLER = MACHINE_BUILDER
                .setNorthTexture("industry:block/lv_machine_casing")
                .setSouthTexture("industry:block/lv_recycler_off")
                .setEastWestTextures("industry:block/lv_machine_casing")
                .setTopBottomTextures("industry:block/lv_machine_casing")
                .setBlockModel(block -> new BlockModelMachineBase(
                                block,
                                "lv_recycler_off",
                                "lv_recycler_on",
                                "lv_machine_casing"
                        )
                )
                .build(new BlockLVRecycler("lv_recycler", nextID()));

        LV_CANNING_MACHINE = MACHINE_BUILDER
                .setNorthTexture("industry:block/lv_canning_machine")
                .setSouthTexture("industry:block/lv_machine_casing")
                .setEastWestTextures("industry:block/lv_machine_casing")
                .setTopBottomTextures("industry:block/lv_machine_casing")
                .setBlockModel(BlockModelHorizontalRotation::new)
                .build(new BlockLVCanningMachine("lv_canning_machine", nextID()));

        LV_BATTERYBOX = MACHINE_BUILDER
                .setNorthSouthTextures("industry:block/lv_batterybox_front")
                .setEastWestTextures("industry:block/lv_batterybox_sides")
                .setTopTexture("industry:block/lv_batterybox_top")
                .setBottomTexture("industry:block/lv_batterybox_bottom")
                .build(new BlockLVBatterybox("lv_batterybox", nextID()));

        initializeTiles();
        initializeGUIs();
    }
}

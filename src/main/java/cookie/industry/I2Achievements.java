package cookie.industry;

import cookie.industry.block.I2Blocks;
import cookie.industry.item.I2Items;
import net.minecraft.client.render.TextureFX;
import net.minecraft.core.Global;
import net.minecraft.core.achievement.Achievement;
import net.minecraft.core.achievement.AchievementList;
import net.minecraft.core.util.helper.Side;
import org.lwjgl.opengl.GL11;
import turniplabs.halplibe.util.achievements.AchievementPage;
import turniplabs.halplibe.util.achievements.GuiAchievements;

import java.util.Random;

public class I2Achievements extends AchievementPage {
    public static final Achievement ROOT1 = new Achievement(AchievementList.achievementList.size() + 1,"industry.resin", -3, -1, I2Items.RESIN, null);
    public static final Achievement ROOT2 = new Achievement(AchievementList.achievementList.size() + 1,"industry.ores", -3, 1, I2Blocks.STONE_COPPER_ORE, ROOT1);
    public static final Achievement TOOL1 = new Achievement(AchievementList.achievementList.size() + 1,"industry.hammer", -1, 0, I2Items.TOOL_HAMMER, ROOT2);
    public static final Achievement TOOL2 = new Achievement(AchievementList.achievementList.size() + 1,"industry.cutters", 0, 0, I2Items.TOOL_CUTTERS, TOOL1);
    public static final Achievement CABLES = new Achievement(AchievementList.achievementList.size() + 1, "industry.cables", 2, 0, I2Items.INSULATED_STEEL_TIN, TOOL2);
    public static final Achievement GENERATOR = new Achievement(AchievementList.achievementList.size() + 1, "industry.generator", 5, 0, I2Blocks.LV_GENERATOR, CABLES);
    public static final Achievement FURNACE = new Achievement(AchievementList.achievementList.size() + 1, "industry.furnace", 4, -1, I2Blocks.LV_ELECTRIC_FURNACE, GENERATOR);
    public static final Achievement MACERATOR = new Achievement(AchievementList.achievementList.size() + 1, "industry.macerator", 4, -2, I2Blocks.LV_MACERATOR, GENERATOR);
    public static final Achievement COMPRESSOR = new Achievement(AchievementList.achievementList.size() + 1, "industry.compressor", 4, -3, I2Blocks.LV_COMPRESSOR, GENERATOR);
    public static final Achievement WIREMILL = new Achievement(AchievementList.achievementList.size() + 1, "industry.wiremill", 4, -4, I2Blocks.LV_WIREMILL, GENERATOR);
    public static final Achievement EXTRACTOR = new Achievement(AchievementList.achievementList.size() + 1, "industry.extractor", 6, -1, I2Blocks.LV_EXTRACTOR, GENERATOR);
    public static final Achievement RECYCLER = new Achievement(AchievementList.achievementList.size() + 1, "industry.recycler", 6, -2, I2Blocks.LV_RECYCLER, GENERATOR);
    public static final Achievement CANNERY = new Achievement(AchievementList.achievementList.size() + 1, "industry.cannery", 6, -3, I2Blocks.LV_CANNERY, GENERATOR);
    public static final Achievement TROMMEL = new Achievement(AchievementList.achievementList.size() + 1, "industry.trommel", 6, -4, I2Blocks.LV_ELECTRIC_TROMMEL, GENERATOR);
    public static final Achievement WATERMILL = new Achievement(AchievementList.achievementList.size() + 1, "industry.watermill", 4, 1, I2Blocks.LV_WATERMILL, GENERATOR);
    public static final Achievement WINDMILL = new Achievement(AchievementList.achievementList.size() + 1, "industry.windmill", 4, 2, I2Blocks.LV_WINDMILL, GENERATOR);
    public static final Achievement GEOTHERMAL = new Achievement(AchievementList.achievementList.size() + 1, "industry.geothermal", 4, 3, I2Blocks.LV_GEOTHERMAL_GENERATOR, GENERATOR);
    public static final Achievement SOLAR = new Achievement(AchievementList.achievementList.size() + 1, "industry.solar", 6, 1, I2Blocks.ULV_SOLAR_PANEL, GENERATOR);
    public static final Achievement ARRAY1 = new Achievement(AchievementList.achievementList.size() + 1, "industry.array.lv", 6, 2, I2Blocks.LV_SOLAR_ARRAY, SOLAR);
    public static final Achievement ARRAY2 = new Achievement(AchievementList.achievementList.size() + 1, "industry.array.mv", 6, 3, I2Blocks.MV_SOLAR_ARRAY, ARRAY1);
    public static final Achievement ARRAY3 = new Achievement(AchievementList.achievementList.size() + 1, "industry.array.hv", 6, 4, I2Blocks.HV_SOLAR_ARRAY, ARRAY2);
    public static final Achievement ARRAY4 = new Achievement(AchievementList.achievementList.size() + 1, "industry.array.ehv", 6, 5, I2Blocks.EHV_SOLAR_ARRAY, ARRAY3);
    public static final Achievement BATBOX1 = new Achievement(AchievementList.achievementList.size() + 1, "industry.batbox", 9, 0, I2Blocks.LV_BATBOX, GENERATOR);
    public static final Achievement DRILL1 = new Achievement(AchievementList.achievementList.size() + 1, "industry.drill", 9, -2, I2Items.TOOL_DRILL, BATBOX1);
    public static final Achievement DRILL2 = new Achievement(AchievementList.achievementList.size() + 1, "industry.drill.gold", 9, -3, I2Items.TOOL_GOLDEN_DRILL, DRILL1);
    public static final Achievement DRILL3 = new Achievement(AchievementList.achievementList.size() + 1, "industry.drill.diamond", 9, -4, I2Items.TOOL_DIAMOND_DRILL, DRILL2);
    public static final Achievement CHAINSAW = new Achievement(AchievementList.achievementList.size() + 1, "industry.chainsaw", 8, -2, I2Items.TOOL_CHAINSAW, DRILL1);
    public static final Achievement NANOSWORD = new Achievement(AchievementList.achievementList.size() + 1, "industry.nanosword", 10, -2, I2Items.TOOL_NANOSWORD, DRILL1);
    public static final Achievement REACTOR = new Achievement(AchievementList.achievementList.size() + 1, "industry.reactor", 9, 7, I2Blocks.NUCLEAR_REACTOR, BATBOX1);
    public static final Achievement FABRICATOR = new Achievement(AchievementList.achievementList.size() + 1, "industry.fabricator", 7, 7, I2Blocks.ENERGY_FABRICATOR, REACTOR);
    public static final Achievement IRIDIUM = new Achievement(AchievementList.achievementList.size() + 1, "industry.iridium", 5, 7, I2Items.IRIDIUM_INGOT, FABRICATOR);
    public static final Achievement IRIDIUMARMOR = new Achievement(AchievementList.achievementList.size() + 1, "industry.iridiumarmor", 4, 7, I2Items.IRIDIUM_HELMET, IRIDIUM);


    public I2Achievements() {
        super("Industry2", "industry2.achievements.page");
        achievementList.add(ROOT1);
        achievementList.add(ROOT2);
        achievementList.add(TOOL1);
        achievementList.add(TOOL2);
        achievementList.add(CABLES);
        achievementList.add(GENERATOR);
        achievementList.add(FURNACE);
        achievementList.add(MACERATOR);
        achievementList.add(COMPRESSOR);
        achievementList.add(WIREMILL);
        achievementList.add(EXTRACTOR);
        achievementList.add(RECYCLER);
        achievementList.add(CANNERY);
        achievementList.add(TROMMEL);
        achievementList.add(WATERMILL);
        achievementList.add(WINDMILL);
        achievementList.add(GEOTHERMAL);
        achievementList.add(SOLAR);
        achievementList.add(ARRAY1);
        achievementList.add(ARRAY2);
        achievementList.add(ARRAY3);
        achievementList.add(ARRAY4);
        achievementList.add(BATBOX1);
        achievementList.add(DRILL1);
        achievementList.add(DRILL2);
        achievementList.add(DRILL3);
        achievementList.add(CHAINSAW);
        achievementList.add(NANOSWORD);
        achievementList.add(REACTOR);
        achievementList.add(FABRICATOR);
        achievementList.add(IRIDIUM);
        achievementList.add(IRIDIUMARMOR);
    }

    @Override
    public void getBackground(GuiAchievements guiAchievements, Random random, int iOffset, int jOffset, int blockX1, int blockY1, int blockX2, int blockY2) {
        int l7 = 0;
        while (l7 * 16 - blockY2 < 155) {
            float f5 = 0.6f - (float)(blockY1 + l7) / 25.0f * 0.3f;
            GL11.glColor4f(f5, f5, f5, 1.0f);
            int i8 = 0;
            while (i8 * 16 - blockX2 < 224) {
                int k8 = I2Blocks.LV_MACHINE_CASING.getBlockTextureFromSideAndMetadata(Side.BOTTOM,0);
                guiAchievements.drawTexturedModalRect(iOffset + i8 * 16 - blockX2, jOffset + l7 * 16 - blockY2, k8 % Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain, k8 / Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain, 16, 16, TextureFX.tileWidthTerrain, 1.0f / (float)(Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain));
                ++i8;
            }
            ++l7;
        }
    }
}

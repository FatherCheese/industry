package cookie.industry.recipe;

import cookie.industry.block.I2Blocks;
import cookie.industry.item.I2Items;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

import java.util.HashMap;

public class RecipesMacerator {
    private static final HashMap<Integer, ItemStack> recipeList = new HashMap<>();

    public RecipesMacerator() {
        addRecipe(I2Blocks.BLOCK_OF_TIN.id, new ItemStack(I2Items.TIN_DUST, 9));
        addRecipe(I2Blocks.STONE_TIN_ORE.id, new ItemStack(I2Items.TIN_DUST, 2));
        addRecipe(I2Blocks.BASALT_TIN_ORE.id, new ItemStack(I2Items.TIN_DUST, 2));
        addRecipe(I2Blocks.LIMESTONE_TIN_ORE.id, new ItemStack(I2Items.TIN_DUST, 2));
        addRecipe(I2Blocks.GRANITE_TIN_ORE.id, new ItemStack(I2Items.TIN_DUST, 2));
        addRecipe(I2Items.RAW_TIN.id, new ItemStack(I2Items.TIN_DUST, 2));
        addRecipe(I2Items.TIN_INGOT.id, new ItemStack(I2Items.TIN_DUST, 1));

        addRecipe(I2Blocks.BLOCK_OF_COPPER.id, new ItemStack(I2Items.COPPER_DUST, 9));
        addRecipe(I2Blocks.STONE_COPPER_ORE.id, new ItemStack(I2Items.COPPER_DUST, 2));
        addRecipe(I2Blocks.BASALT_COPPER_ORE.id, new ItemStack(I2Items.COPPER_DUST, 2));
        addRecipe(I2Blocks.LIMESTONE_COPPER_ORE.id, new ItemStack(I2Items.COPPER_DUST, 2));
        addRecipe(I2Blocks.GRANITE_COPPER_ORE.id, new ItemStack(I2Items.COPPER_DUST, 2));
        addRecipe(I2Items.RAW_COPPER.id, new ItemStack(I2Items.COPPER_DUST, 2));
        addRecipe(I2Items.COPPER_INGOT.id, new ItemStack(I2Items.COPPER_DUST, 1));

        addRecipe(I2Blocks.BLOCK_OF_BRONZE.id, new ItemStack(I2Items.BRONZE_DUST, 9));
        addRecipe(I2Items.BRONZE_INGOT.id, new ItemStack(I2Items.BRONZE_DUST, 1));

        addRecipe(Block.blockIron.id, new ItemStack(I2Items.IRON_DUST, 9));
        addRecipe(Block.oreIronStone.id, new ItemStack(I2Items.IRON_DUST, 2));
        addRecipe(Block.oreIronBasalt.id, new ItemStack(I2Items.IRON_DUST, 2));
        addRecipe(Block.oreIronLimestone.id, new ItemStack(I2Items.IRON_DUST, 2));
        addRecipe(Block.oreIronGranite.id, new ItemStack(I2Items.IRON_DUST, 2));
        addRecipe(Item.oreRawIron.id, new ItemStack(I2Items.IRON_DUST, 2));
        addRecipe(Item.ingotIron.id, new ItemStack(I2Items.IRON_DUST, 1));

        addRecipe(Block.blockGold.id, new ItemStack(I2Items.GOLD_DUST, 9));
        addRecipe(Block.oreGoldStone.id, new ItemStack(I2Items.GOLD_DUST, 2));
        addRecipe(Block.oreGoldBasalt.id, new ItemStack(I2Items.GOLD_DUST, 2));
        addRecipe(Block.oreGoldLimestone.id, new ItemStack(I2Items.GOLD_DUST, 2));
        addRecipe(Block.oreGoldGranite.id, new ItemStack(I2Items.GOLD_DUST, 2));
        addRecipe(Item.oreRawGold.id, new ItemStack(I2Items.GOLD_DUST, 2));
        addRecipe(Item.ingotGold.id, new ItemStack(I2Items.GOLD_DUST, 1));

        addRecipe(Block.blockCoal.id, new ItemStack(I2Items.COAL_DUST, 8));
        addRecipe(Item.coal.id, new ItemStack(I2Items.COAL_DUST, 1));
    }

    public static void addRecipe(int input, ItemStack output) {
        recipeList.put(input, output);
    }

    public ItemStack getRecipeResult(int i) {
        return recipeList.get(i);
    }

    public HashMap<Integer, ItemStack> getRecipeList() {
        return recipeList;
    }
}

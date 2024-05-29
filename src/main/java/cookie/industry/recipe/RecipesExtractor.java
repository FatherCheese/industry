package cookie.industry.recipe;

import cookie.industry.block.I2Blocks;
import cookie.industry.item.I2Items;
import net.minecraft.core.item.ItemStack;

import java.util.HashMap;

public class RecipesExtractor {
    private static final HashMap<Integer, ItemStack> recipeList = new HashMap<>();

    public RecipesExtractor() {
        addRecipe(I2Blocks.RUBBERWOOD_LOG.id, new ItemStack(I2Items.RUBBER, 1));
        addRecipe(I2Blocks.RUBBERWOOD_RESIN_LOG.id, new ItemStack(I2Items.RUBBER, 1));
        addRecipe(I2Blocks.EMPTY_RUBBERWOOD_RESIN_LOG.id, new ItemStack(I2Items.RUBBER, 1));
        addRecipe(I2Blocks.RUBBERWOOD_SAPLING.id, new ItemStack(I2Items.RUBBER, 1));
        addRecipe(I2Items.RESIN.id, new ItemStack(I2Items.RUBBER, 3));

        addRecipe(I2Items.WATER_CELL.id, new ItemStack(I2Items.COOLANT_CELL, 1));

        addRecipe(I2Items.EMPTY_T1_REDSTONE_CELL.id, new ItemStack(I2Items.T2_REDSTONE_CELL));
        addRecipe(I2Items.EMPTY_T2_REDSTONE_CELL.id, new ItemStack(I2Items.T3_REDSTONE_CELL));
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

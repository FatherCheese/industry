package cookie.industry.recipe;

import cookie.industry.block.I2Blocks;
import cookie.industry.item.I2Items;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

import java.util.HashMap;

public class RecipesCompressor {
    private static final HashMap<Integer, ItemStack> recipeList = new HashMap<>();

    public RecipesCompressor() {
        addRecipe(I2Items.TIN_INGOT.id, new ItemStack(I2Items.TIN_PLATE, 2));
        addRecipe(I2Blocks.BLOCK_OF_TIN.id, new ItemStack(I2Items.TIN_PLATE, 18));

        addRecipe(I2Items.COPPER_INGOT.id, new ItemStack(I2Items.COPPER_PLATE, 2));
        addRecipe(I2Blocks.BLOCK_OF_COPPER.id, new ItemStack(I2Items.COPPER_PLATE, 18));

        addRecipe(I2Items.BRONZE_INGOT.id, new ItemStack(I2Items.BRONZE_PLATE, 2));
        addRecipe(I2Blocks.BLOCK_OF_BRONZE.id, new ItemStack(I2Items.BRONZE_PLATE, 18));

        addRecipe(I2Items.IRIDIUM_INGOT.id, new ItemStack(I2Items.IRIDIUM_PLATE, 1));

        addRecipe(Item.ingotIron.id, new ItemStack(I2Items.IRON_PLATE, 2));
        addRecipe(Block.blockIron.id, new ItemStack(I2Items.IRON_PLATE, 18));

        addRecipe(Item.ingotGold.id, new ItemStack(I2Items.GOLD_PLATE, 2));
        addRecipe(Block.blockGold.id, new ItemStack(I2Items.GOLD_PLATE, 18));

        addRecipe(Item.ingotSteel.id, new ItemStack(I2Items.STEEL_PLATE, 2));
        addRecipe(Block.blockSteel.id, new ItemStack(I2Items.STEEL_PLATE, 18));

        addRecipe(I2Blocks.HARDENED_CARBON.id, new ItemStack(Item.diamond, 1));
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

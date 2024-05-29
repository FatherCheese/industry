package cookie.industry.recipe;

import cookie.industry.block.I2Blocks;
import cookie.industry.item.I2Items;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

import java.util.HashMap;

public class RecipesWiremill {
    private static final HashMap<Integer, ItemStack> recipeList = new HashMap<>();

    public RecipesWiremill() {
        addRecipe(I2Items.TIN_INGOT.id, new ItemStack(I2Items.TIN_CABLE, 4));
        addRecipe(I2Blocks.BLOCK_OF_TIN.id, new ItemStack(I2Items.TIN_CABLE, 36));

        addRecipe(I2Items.COPPER_INGOT.id, new ItemStack(I2Items.COPPER_CABLE, 4));
        addRecipe(I2Blocks.BLOCK_OF_COPPER.id, new ItemStack(I2Items.COPPER_CABLE, 36));

        addRecipe(Item.ingotGold.id, new ItemStack(I2Items.GOLD_CABLE, 4));
        addRecipe(Block.blockGold.id, new ItemStack(I2Items.GOLD_CABLE, 36));

        addRecipe(Item.ingotSteel.id, new ItemStack(I2Items.STEEL_CABLE, 4));
        addRecipe(Block.blockSteel.id, new ItemStack(I2Items.STEEL_CABLE, 36));

        addRecipe(Block.wool.id, new ItemStack(Item.string, 4));
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

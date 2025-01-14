package cookie.industry.recipe;

import cookie.industry.item.I2Items;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

import java.util.HashMap;

public class RecipesCannery {
    private static final HashMap<Integer, ItemStack> recipeList = new HashMap<>();

    public RecipesCannery() {
        addRecipe(Item.foodFishRaw.id, 1);
        addRecipe(Item.foodCookie.id, 1);
        addRecipe(Item.cherry.id, 1);
        addRecipe(Item.foodApple.id, 2);
        addRecipe(Item.foodPorkchopRaw.id, 2);
        addRecipe(Item.foodBread.id, 3);
        addRecipe(Item.foodFishCooked.id, 3);
        addRecipe(Item.foodPorkchopCooked.id, 4);
        addRecipe(Item.foodStewMushroom.id, 5);
        addRecipe(Item.foodCake.id, 6);
        addRecipe(Item.foodAppleGold.id, 21);

        addSpecialRecipe(I2Items.ACTIVATED_REDSTONE_INGOT.id, new ItemStack(I2Items.T1_REDSTONE_CELL, 1));
    }

    public static void addRecipe(int input, int outputCount) {
        recipeList.put(input, new ItemStack(I2Items.FOOD_CAN, outputCount));
    }

    public static void addSpecialRecipe(int input, ItemStack output) {
        recipeList.put(input, output);
    }

    public ItemStack getRecipeResult(int i) {
        return recipeList.get(i);
    }

    public HashMap<Integer, ItemStack> getRecipeList() {
        return recipeList;
    }
}

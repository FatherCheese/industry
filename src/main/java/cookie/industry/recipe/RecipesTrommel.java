package cookie.industry.recipe;

import cookie.industry.item.I2Items;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class RecipesTrommel implements RecipeEntrypoint {
    @Override
    public void onRecipesReady() {
        Registries.RECIPES.TROMMEL.getItem("dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2Items.RAW_TIN), 1), 0.5f);
        Registries.RECIPES.TROMMEL.getItem("dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2Items.RAW_COPPER), 1), 0.5f);
        Registries.RECIPES.TROMMEL.getItem("gravel").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2Items.RAW_TIN), 1, 2), 10.0f);
        Registries.RECIPES.TROMMEL.getItem("gravel").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2Items.RAW_COPPER), 1, 2), 10.0f);
        Registries.RECIPES.TROMMEL.getItem("rich_dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2Items.RAW_TIN), 1, 2), 15.0f);
        Registries.RECIPES.TROMMEL.getItem("rich_dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2Items.RAW_COPPER), 1, 2), 15.0f);
        Registries.RECIPES.TROMMEL.getItem("soul_sand").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2Items.RAW_TIN), 1), 1.0f);
        Registries.RECIPES.TROMMEL.getItem("soul_sand").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2Items.RAW_COPPER), 1), 1.0f);
    }

    @Override
    public void initNamespaces() {
        Registries.RECIPES.register("industry", I2Recipes.INDUSTRY);
        I2Recipes.INDUSTRY.register("trommel", Registries.RECIPES.TROMMEL);
    }
}

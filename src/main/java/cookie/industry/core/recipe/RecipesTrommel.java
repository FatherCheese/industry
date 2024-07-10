package cookie.industry.core.recipe;

import cookie.industry.core.I2ItemsNew;
import cookie.industry.core.recipe.registries.I2RecipeRegistries;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class RecipesTrommel implements RecipeEntrypoint {
    @Override
    public void onRecipesReady() {
        Registries.RECIPES.TROMMEL.getItem("dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2ItemsNew.RAW_TIN), 1), 0.5f);
        Registries.RECIPES.TROMMEL.getItem("dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2ItemsNew.RAW_COPPER), 1), 0.5f);
        Registries.RECIPES.TROMMEL.getItem("gravel").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2ItemsNew.RAW_TIN), 1, 2), 10.0f);
        Registries.RECIPES.TROMMEL.getItem("gravel").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2ItemsNew.RAW_COPPER), 1, 2), 10.0f);
        Registries.RECIPES.TROMMEL.getItem("rich_dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2ItemsNew.RAW_TIN), 1, 2), 15.0f);
        Registries.RECIPES.TROMMEL.getItem("rich_dirt").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2ItemsNew.RAW_COPPER), 1, 2), 15.0f);
        Registries.RECIPES.TROMMEL.getItem("soul_sand").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2ItemsNew.RAW_TIN), 1), 1.0f);
        Registries.RECIPES.TROMMEL.getItem("soul_sand").getOutput().addEntry(new WeightedRandomLootObject(new ItemStack(I2ItemsNew.RAW_COPPER), 1), 1.0f);
    }

    @Override
    public void initNamespaces() {
        Registries.RECIPES.register("industry", I2RecipeRegistries.INDUSTRY);
        I2RecipeRegistries.INDUSTRY.register("trommel", Registries.RECIPES.TROMMEL);
    }
}

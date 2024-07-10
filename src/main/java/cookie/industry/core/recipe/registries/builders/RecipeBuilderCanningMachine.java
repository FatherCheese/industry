package cookie.industry.core.recipe.registries.builders;

import cookie.industry.core.I2BlocksNew;
import cookie.industry.core.recipe.registries.entries.RecipeEntryCanningMachine;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBase;

@SuppressWarnings({"unused"})
public class RecipeBuilderCanningMachine extends RecipeBuilderBase {
    private final RecipeSymbol[] inputs = new RecipeSymbol[2];

    public RecipeBuilderCanningMachine(String modID) {
        super(modID);
    }

    // INPUTS //
    public RecipeBuilderCanningMachine setInput(RecipeSymbol symbol) {
        inputs[0] = symbol;
        return this;
    }

    public RecipeBuilderCanningMachine setInput(ItemStack input) {
        return setInput(new RecipeSymbol(input));
    }

    public RecipeBuilderCanningMachine setInput(String itemGroup) {
        return setInput(new RecipeSymbol(itemGroup));
    }

    public RecipeBuilderCanningMachine setInput(IItemConvertible input) {
        return setInput(new RecipeSymbol(new ItemStack(input, 0)));
    }

    public RecipeBuilderCanningMachine setInput(IItemConvertible input, int meta) {
        return setInput(new RecipeSymbol(new ItemStack(input, 1, meta)));
    }
    
    // CANS //
    public RecipeBuilderCanningMachine setCan(RecipeSymbol symbol) {
        inputs[1] = symbol;
        return this;
    }

    public RecipeBuilderCanningMachine setCan(ItemStack can, int amount) {
        return setCan(new RecipeSymbol(can, amount));
    }

    public RecipeBuilderCanningMachine setCan(String itemGroup, int amount) {
        return setCan(new RecipeSymbol(itemGroup, amount));
    }

    public RecipeBuilderCanningMachine setCan(IItemConvertible can, int amount) {
        return setCan(new RecipeSymbol(new ItemStack(can), amount));
    }

    public RecipeBuilderCanningMachine setCan(IItemConvertible can, int meta, int amount) {
        return setCan(new RecipeSymbol(new ItemStack(can, 1, meta), amount));
    }

    @SuppressWarnings({"unchecked"})
    public void create(String recipeID, ItemStack outputStack) {
        ((RecipeGroup<RecipeEntryCanningMachine>) RecipeBuilder.getRecipeGroup(modID, "canning", new RecipeSymbol(I2BlocksNew.LV_CANNING_MACHINE.getDefaultStack())))
                .register(recipeID, new RecipeEntryCanningMachine(inputs, outputStack));
    }
}

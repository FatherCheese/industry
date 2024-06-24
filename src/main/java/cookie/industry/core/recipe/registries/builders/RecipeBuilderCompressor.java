package cookie.industry.core.recipe.registries.builders;

import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.recipe.registries.entries.RecipeEntryCompressor;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBase;

import java.util.Objects;

@SuppressWarnings({"unused"})
public class RecipeBuilderCompressor extends RecipeBuilderBase {
    protected RecipeSymbol input;

    public RecipeBuilderCompressor(String modID) {
        super(modID);
    }

    public RecipeBuilderCompressor setInput(IItemConvertible input){
        return setInput(input, 0);
    }


    public RecipeBuilderCompressor setInput(IItemConvertible input, int meta){
        return setInput(new ItemStack(input, 1, meta));
    }

    public RecipeBuilderCompressor setInput(ItemStack input){
        return setInput(new RecipeSymbol(input));
    }

    public RecipeBuilderCompressor setInput(String itemGroup){
        return setInput(new RecipeSymbol(itemGroup));
    }

    public RecipeBuilderCompressor setInput(RecipeSymbol input){
        RecipeBuilderCompressor builder = this.clone(this);
        builder.input = Objects.requireNonNull(input, "Input symbol must not be null!");
        return builder;
    }

    @SuppressWarnings({"unchecked"})
    public void create(String recipeID, ItemStack outputStack) {
        Objects.requireNonNull(input, "Input symbol must not be null!");
        ((RecipeGroup<RecipeEntryCompressor>) RecipeBuilder.getRecipeGroup(modID, "compressor", new RecipeSymbol(I2BlocksNew.LV_COMPRESSOR.getDefaultStack())))
                .register(recipeID, new RecipeEntryCompressor(input, outputStack));
    }
}

package cookie.industry.core.recipe.registries.builders;

import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.recipe.registries.entries.RecipeEntryExtractor;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBase;

import java.util.Objects;

@SuppressWarnings({"unused"})
public class RecipeBuilderExtractor extends RecipeBuilderBase {
    protected RecipeSymbol input;

    public RecipeBuilderExtractor(String modID) {
        super(modID);
    }

    public RecipeBuilderExtractor setInput(IItemConvertible input){
        return setInput(input, 0);
    }


    public RecipeBuilderExtractor setInput(IItemConvertible input, int meta){
        return setInput(new ItemStack(input, 1, meta));
    }

    public RecipeBuilderExtractor setInput(ItemStack input){
        return setInput(new RecipeSymbol(input));
    }

    public RecipeBuilderExtractor setInput(String itemGroup){
        return setInput(new RecipeSymbol(itemGroup));
    }

    public RecipeBuilderExtractor setInput(RecipeSymbol input){
        RecipeBuilderExtractor builder = this.clone(this);
        builder.input = Objects.requireNonNull(input, "Input symbol must not be null!");
        return builder;
    }

    @SuppressWarnings({"unchecked"})
    public void create(String recipeID, ItemStack outputStack) {
        Objects.requireNonNull(input, "Input symbol must not be null!");
        ((RecipeGroup<RecipeEntryExtractor>) RecipeBuilder.getRecipeGroup(modID, "extractor", new RecipeSymbol(I2BlocksNew.LV_EXTRACTOR.getDefaultStack())))
                .register(recipeID, new RecipeEntryExtractor(input, outputStack));
    }
}

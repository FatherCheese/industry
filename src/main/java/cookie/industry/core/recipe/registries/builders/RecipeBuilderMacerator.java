package cookie.industry.core.recipe.registries.builders;

import cookie.industry.core.I2BlocksNew;
import cookie.industry.core.recipe.registries.entries.RecipeEntryMacerator;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBase;

import java.util.Objects;

@SuppressWarnings({"unused"})
public class RecipeBuilderMacerator extends RecipeBuilderBase {
    protected RecipeSymbol input;

    public RecipeBuilderMacerator(String modID) {
        super(modID);
    }

    public RecipeBuilderMacerator setInput(IItemConvertible input){
        return setInput(input, 0);
    }


    public RecipeBuilderMacerator setInput(IItemConvertible input, int meta){
        return setInput(new ItemStack(input, 1, meta));
    }

    public RecipeBuilderMacerator setInput(ItemStack input){
        return setInput(new RecipeSymbol(input));
    }

    public RecipeBuilderMacerator setInput(String itemGroup){
        return setInput(new RecipeSymbol(itemGroup));
    }

    public RecipeBuilderMacerator setInput(RecipeSymbol input){
        RecipeBuilderMacerator builder = this.clone(this);
        builder.input = Objects.requireNonNull(input, "Input symbol must not be null!");
        return builder;
    }

    @SuppressWarnings({"unchecked"})
    public void create(String recipeID, ItemStack outputStack) {
        Objects.requireNonNull(input, "Input symbol must not be null!");
        ((RecipeGroup<RecipeEntryMacerator>) RecipeBuilder.getRecipeGroup(modID, "macerator", new RecipeSymbol(I2BlocksNew.LV_MACERATOR.getDefaultStack())))
                .register(recipeID, new RecipeEntryMacerator(input, outputStack));
    }
}

package cookie.industry.core.recipe.registries.builders;

import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.recipe.registries.entries.RecipeEntryWiremill;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBase;

import java.util.Objects;

@SuppressWarnings({"unused"})
public class RecipeBuilderWiremill extends RecipeBuilderBase {
    protected RecipeSymbol input;

    public RecipeBuilderWiremill(String modID) {
        super(modID);
    }

    public RecipeBuilderWiremill setInput(IItemConvertible input){
        return setInput(input, 0);
    }


    public RecipeBuilderWiremill setInput(IItemConvertible input, int meta){
        return setInput(new ItemStack(input, 1, meta));
    }

    public RecipeBuilderWiremill setInput(ItemStack input){
        return setInput(new RecipeSymbol(input));
    }

    public RecipeBuilderWiremill setInput(String itemGroup){
        return setInput(new RecipeSymbol(itemGroup));
    }

    public RecipeBuilderWiremill setInput(RecipeSymbol input){
        RecipeBuilderWiremill builder = this.clone(this);
        builder.input = Objects.requireNonNull(input, "Input symbol must not be null!");
        return builder;
    }

    @SuppressWarnings({"unchecked"})
    public void create(String recipeID, ItemStack outputStack) {
        Objects.requireNonNull(input, "Input symbol must not be null!");
        ((RecipeGroup<RecipeEntryWiremill>) RecipeBuilder.getRecipeGroup(modID, "wiremill", new RecipeSymbol(I2BlocksNew.LV_WIREMILL.getDefaultStack())))
                .register(recipeID, new RecipeEntryWiremill(input, outputStack));
    }
}

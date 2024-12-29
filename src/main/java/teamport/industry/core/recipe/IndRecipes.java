package teamport.industry.core.recipe;

import teamport.industry.Industry;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class IndRecipes implements RecipeEntrypoint {

    @Override
    public void onRecipesReady() {

    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(Industry.MOD_ID);
    }
}

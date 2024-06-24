package cookie.industry.core.recipe.registries.entries;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.*;
import net.minecraft.core.item.ItemStack;

import java.util.List;
import java.util.Objects;

public class RecipeEntryWiremill extends RecipeEntryBase<RecipeSymbol, ItemStack, Void> {
    public RecipeEntryWiremill(RecipeSymbol input, ItemStack output) {
        super(input, output, null);
    }

    public RecipeEntryWiremill() {
    }

    @Override
    public Void getData() {
        return null;
    }

    @Override
    public boolean containsData(Void data) {
        return false;
    }

    public boolean matches(ItemStack stack) {
        return getInput().matches(stack);
    }

    private boolean matchesRecipe(SearchQuery query) {
        if (query.query.getLeft() == SearchQuery.QueryType.NAME) {
            if (query.strict && getOutput().getDisplayName().equalsIgnoreCase(query.query.getRight())) return true;

            return !query.strict && getOutput().getDisplayName().toLowerCase().contains(query.query.getRight().toLowerCase());
        } else if (query.query.getLeft() == SearchQuery.QueryType.GROUP && !Objects.equals(query.query.getRight(), "")) {
            List<ItemStack> groupStacks = new RecipeSymbol(query.query.getRight()).resolve();
            if (groupStacks == null) return false;

            return groupStacks.contains(getOutput());
        }

        return false;
    }

    private boolean matchesUsage(SearchQuery query) {
        for (ItemStack stack : getInput().resolve()) {
            if (stack != null) {
                if (query.query.getLeft() == SearchQuery.QueryType.NAME) {
                    if (query.strict && stack.getDisplayName().equalsIgnoreCase(query.query.getRight())) return true;

                    return !query.strict && stack.getDisplayName().toLowerCase().contains(query.query.getRight().toLowerCase());
                } else if (query.query.getLeft() == SearchQuery.QueryType.GROUP && !Objects.equals(query.query.getRight(), "")) {
                    List<ItemStack> groupStacks = new RecipeSymbol(query.query.getRight()).resolve();
                    if (groupStacks == null) return false;

                    return groupStacks.contains(getOutput());
                }
            }
        }

        return false;
    }

    private boolean matchesScope(SearchQuery query) {
        if (query.scope.getLeft() == SearchQuery.SearchScope.NONE) return true;
        else {
            if (query.scope.getLeft() == SearchQuery.SearchScope.NAMESPACE) {
                RecipeNamespace namespace = Registries.RECIPES.getItem(query.scope.getRight());
                return namespace == parent.getParent();
            } else if (query.scope.getLeft() == SearchQuery.SearchScope.NAMESPACE_GROUP) {
                RecipeGroup<RecipeEntryWiremill> group;
                try {
                    group = Registries.RECIPES.getGroupFromKey(query.scope.getRight());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    group = null;
                }

                return group == parent;
            }
        }

        return false;
    }

    public boolean matchesQuery(SearchQuery query) {
        switch (query.mode) {
            case ALL:
                if ((matchesRecipe(query) || matchesUsage(query)) && matchesScope(query)) {
                    return true;
                }
                break;
            case RECIPE:
                if (matchesRecipe(query) && matchesScope(query)) {
                    return true;
                }
                break;
            case USAGE:
                if (matchesUsage(query) && matchesScope(query)) {
                    return true;
                }
        }

        return false;
    }

    public boolean matchesQueryIgnoreExceptions(SearchQuery query) {
        try {
            return matchesQuery(query);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}

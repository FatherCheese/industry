package cookie.industry.core.recipe.registries;

import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.recipe.registries.entries.*;
import net.minecraft.core.data.registry.recipe.*;

public class I2RecipeRegistries extends RecipeRegistry {
    public static final RecipeNamespace INDUSTRY = new RecipeNamespace();
    public static final RecipeGroup<RecipeEntryMacerator> MACERATOR = new RecipeGroup<>(new RecipeSymbol(I2BlocksNew.LV_MACERATOR.getDefaultStack()));
    public static final RecipeGroup<RecipeEntryCompressor> COMPRESSOR = new RecipeGroup<>(new RecipeSymbol(I2BlocksNew.LV_COMPRESSOR.getDefaultStack()));
    public static final RecipeGroup<RecipeEntryWiremill> WIREMILL = new RecipeGroup<>(new RecipeSymbol(I2BlocksNew.LV_WIREMILL.getDefaultStack()));
    public static final RecipeGroup<RecipeEntryExtractor> EXTRACTOR = new RecipeGroup<>(new RecipeSymbol(I2BlocksNew.LV_EXTRACTOR.getDefaultStack()));
    public static final RecipeGroup<RecipeEntryCanningMachine> CANNING_MACHINE = new RecipeGroup<>(new RecipeSymbol(I2BlocksNew.LV_CANNING_MACHINE.getDefaultStack()));

    public I2RecipeRegistries() {
        INDUSTRY.register("macerator", MACERATOR);
        INDUSTRY.register("compressor", COMPRESSOR);
        INDUSTRY.register("wiremill", WIREMILL);
        INDUSTRY.register("extractor", EXTRACTOR);
        INDUSTRY.register("canning", CANNING_MACHINE);
    }
}

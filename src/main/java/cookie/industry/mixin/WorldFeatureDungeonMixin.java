package cookie.industry.mixin;

import cookie.industry.item.I2Items;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.generate.feature.WorldFeatureDungeon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = WorldFeatureDungeon.class, remap = false)
public class WorldFeatureDungeonMixin {

    @Inject(method = "pickCheckLootItem", at = @At("TAIL"), cancellable = true)
    private void industry_iridiumLoot(Random random, CallbackInfoReturnable<ItemStack> cir) {
        int indI = random.nextInt(15);
        if (indI == 0)
            cir.setReturnValue(new ItemStack(I2Items.IRIDIUM_SCRAP));
    }
}

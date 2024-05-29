package cookie.industry.mixin;

import cookie.industry.item.I2Items;
import cookie.industry.item.charger.ItemArmorChargerBase;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sunsetsatellite.catalyst.energy.api.IEnergyItem;

@Mixin(value = Entity.class, remap = false)
public abstract class EntityMixin {
    @Shadow public abstract ItemStack[] getInventory();

    @Shadow protected boolean fireImmune;

    @Unique
    private final Entity industryThisAs = (Entity) (Object) this;

    @Unique
    private boolean isArmoured(Entity entity) {
        for (int i = 0; i < 4; i++)
            if (!(entity instanceof EntityPlayer) || ((EntityPlayer) entity).inventory.armorInventory[i] == null)
                return false;

        return ((EntityPlayer) entity).inventory.armorInventory[3].itemID == I2Items.IRIDIUM_HELMET.id     &&
                ((EntityPlayer) entity).inventory.armorInventory[2].itemID == I2Items.IRIDIUM_CHESTPLATE.id &&
                ((EntityPlayer) entity).inventory.armorInventory[1].itemID == I2Items.IRIDIUM_LEGGINGS.id   &&
                ((EntityPlayer) entity).inventory.armorInventory[0].itemID == I2Items.IRIDIUM_BOOTS.id;
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void industry_lavaIridiumProtection(CallbackInfo ci) {
        if (isArmoured(industryThisAs))
            fireImmune = true;
        if (!isArmoured(industryThisAs))
            fireImmune = false;
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void industry_chargerTick(CallbackInfo ci) {
        if (industryThisAs != null && industryThisAs instanceof EntityPlayer) {
            ItemStack armorStack = ((EntityPlayer) industryThisAs).inventory.armorInventory[2];
            if (armorStack != null && armorStack.getItem() instanceof ItemArmorChargerBase) {
                ItemStack[] stacks = ((EntityPlayer) industryThisAs).inventory.mainInventory;

                for (ItemStack stack : stacks) {
                    if (stack != null && stack.getItem() instanceof IEnergyItem) {
                        if ((((ItemArmorChargerBase) armorStack.getItem()).getEnergy(armorStack) > 0) &&
                                (((IEnergyItem) stack.getItem()).getEnergy(stack) < ((IEnergyItem) stack.getItem()).getCapacity(stack))) {
                            // Hardcoded values because I can't seem to get the correct values per charger. WTF?
                            ((ItemArmorChargerBase) armorStack.getItem()).modifyEnergy(armorStack, -1);
                            ((IEnergyItem) stack.getItem()).modifyEnergy(stack, 1);
                        }
                    }
                }
            }
        }
    }
}

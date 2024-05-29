package cookie.industry.mixin.achievement;

import cookie.industry.I2Achievements;
import cookie.industry.block.I2Blocks;
import cookie.industry.item.I2Items;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.SlotCrafting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SlotCrafting.class, remap = false)
public abstract class SlotCraftingMixin {

    @Shadow private EntityPlayer thePlayer;

    @Inject(method = "onPickupFromSlot", at = @At("TAIL"))
    private void industry_pickupFromSlot(ItemStack itemStack, CallbackInfo ci) {
        Item item = itemStack.getItem();
        if (item.id == I2Items.TOOL_HAMMER.id)
            thePlayer.addStat(I2Achievements.TOOL1, 1);

        if (item.id == I2Items.TOOL_CUTTERS.id)
            thePlayer.addStat(I2Achievements.TOOL2, 1);

        if (item.id == I2Items.INSULATED_STEEL_TIN.id ||
                item.id == I2Items.INSULATED_COPPER_CABLE.id ||
                item.id == I2Items.INSULATED_GOLD_CABLE.id ||
                item.id == I2Items.INSULATED_STEEL_CABLE.id)
            thePlayer.addStat(I2Achievements.CABLES, 1);

        if (item.id == I2Blocks.LV_GENERATOR.id)
            thePlayer.addStat(I2Achievements.GENERATOR, 1);

        if (item.id == I2Blocks.LV_ELECTRIC_FURNACE.id)
            thePlayer.addStat(I2Achievements.FURNACE, 1);

        if (item.id == I2Blocks.LV_MACERATOR.id)
            thePlayer.addStat(I2Achievements.MACERATOR, 1);

        if (item.id == I2Blocks.LV_COMPRESSOR.id)
            thePlayer.addStat(I2Achievements.COMPRESSOR, 1);

        if (item.id == I2Blocks.LV_WIREMILL.id)
            thePlayer.addStat(I2Achievements.WIREMILL, 1);

        if (item.id == I2Blocks.LV_EXTRACTOR.id)
            thePlayer.addStat(I2Achievements.EXTRACTOR, 1);

        if (item.id == I2Blocks.LV_RECYCLER.id)
            thePlayer.addStat(I2Achievements.RECYCLER, 1);

        if (item.id == I2Blocks.LV_CANNERY.id)
            thePlayer.addStat(I2Achievements.CANNERY, 1);

        if (item.id == I2Blocks.LV_ELECTRIC_TROMMEL.id)
            thePlayer.addStat(I2Achievements.TROMMEL, 1);

        if (item.id == I2Blocks.LV_WATERMILL.id)
            thePlayer.addStat(I2Achievements.WATERMILL, 1);

        if (item.id == I2Blocks.LV_WINDMILL.id)
            thePlayer.addStat(I2Achievements.WINDMILL, 1);

        if (item.id == I2Blocks.LV_GEOTHERMAL_GENERATOR.id)
            thePlayer.addStat(I2Achievements.GEOTHERMAL, 1);

        if (item.id == I2Blocks.ULV_SOLAR_PANEL.id)
            thePlayer.addStat(I2Achievements.SOLAR, 1);

        if (item.id == I2Blocks.ULV_SOLAR_PANEL.id)
            thePlayer.addStat(I2Achievements.SOLAR, 1);

        if (item.id == I2Blocks.LV_SOLAR_ARRAY.id)
            thePlayer.addStat(I2Achievements.ARRAY1, 1);

        if (item.id == I2Blocks.MV_SOLAR_ARRAY.id)
            thePlayer.addStat(I2Achievements.ARRAY2, 1);

        if (item.id == I2Blocks.HV_SOLAR_ARRAY.id)
            thePlayer.addStat(I2Achievements.ARRAY3, 1);

        if (item.id == I2Blocks.EHV_SOLAR_ARRAY.id)
            thePlayer.addStat(I2Achievements.ARRAY4, 1);

        if (item.id == I2Blocks.LV_BATBOX.id)
            thePlayer.addStat(I2Achievements.BATBOX1, 1);

        if (item.id == I2Items.TOOL_DRILL.id)
            thePlayer.addStat(I2Achievements.DRILL1, 1);

        if (item.id == I2Items.TOOL_GOLDEN_DRILL.id)
            thePlayer.addStat(I2Achievements.DRILL2, 1);

        if (item.id == I2Items.TOOL_DIAMOND_DRILL.id)
            thePlayer.addStat(I2Achievements.DRILL3, 1);

        if (item.id == I2Items.TOOL_CHAINSAW.id)
            thePlayer.addStat(I2Achievements.CHAINSAW, 1);

        if (item.id == I2Items.TOOL_NANOSWORD.id)
            thePlayer.addStat(I2Achievements.NANOSWORD, 1);

        if (item.id == I2Blocks.NUCLEAR_REACTOR.id)
            thePlayer.addStat(I2Achievements.REACTOR, 1);

        if (item.id == I2Blocks.ENERGY_FABRICATOR.id)
            thePlayer.addStat(I2Achievements.FABRICATOR, 1);

        if (item.id == I2Items.IRIDIUM_INGOT.id)
            thePlayer.addStat(I2Achievements.IRIDIUM, 1);

        if (item.id == I2Items.IRIDIUM_HELMET.id ||
                item.id == I2Items.IRIDIUM_CHESTPLATE.id ||
                item.id == I2Items.IRIDIUM_LEGGINGS.id ||
                item.id == I2Items.IRIDIUM_BOOTS.id)
            thePlayer.addStat(I2Achievements.IRIDIUMARMOR, 1);
    }
}

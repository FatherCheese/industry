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
        if (item.id == I2Items.toolHammer.id)
            thePlayer.addStat(I2Achievements.TOOL1, 1);

        if (item.id == I2Items.toolCutters.id)
            thePlayer.addStat(I2Achievements.TOOL2, 1);

        if (item.id == I2Items.itemInsulatedCableTin.id ||
                item.id == I2Items.itemInsulatedCableCopper.id ||
                item.id == I2Items.itemInsulatedCableGold.id ||
                item.id == I2Items.itemInsulatedCableSteel.id)
            thePlayer.addStat(I2Achievements.CABLES, 1);

        if (item.id == I2Blocks.lvGenerator.id)
            thePlayer.addStat(I2Achievements.GENERATOR, 1);

        if (item.id == I2Blocks.lvMachineFurnace.id)
            thePlayer.addStat(I2Achievements.FURNACE, 1);

        if (item.id == I2Blocks.lvMachineMacerator.id)
            thePlayer.addStat(I2Achievements.MACERATOR, 1);

        if (item.id == I2Blocks.lvMachineCompressor.id)
            thePlayer.addStat(I2Achievements.COMPRESSOR, 1);

        if (item.id == I2Blocks.lvMachineWiremill.id)
            thePlayer.addStat(I2Achievements.WIREMILL, 1);

        if (item.id == I2Blocks.lvMachineExtractor.id)
            thePlayer.addStat(I2Achievements.EXTRACTOR, 1);

        if (item.id == I2Blocks.lvMachineRecycler.id)
            thePlayer.addStat(I2Achievements.RECYCLER, 1);

        if (item.id == I2Blocks.machineCannery.id)
            thePlayer.addStat(I2Achievements.CANNERY, 1);

        if (item.id == I2Blocks.lvMachineTrommel.id)
            thePlayer.addStat(I2Achievements.TROMMEL, 1);

        if (item.id == I2Blocks.lvGeneratorWatermill.id)
            thePlayer.addStat(I2Achievements.WATERMILL, 1);

        if (item.id == I2Blocks.lvGeneratorWindmill.id)
            thePlayer.addStat(I2Achievements.WINDMILL, 1);

        if (item.id == I2Blocks.lvGeneratorGeothermal.id)
            thePlayer.addStat(I2Achievements.GEOTHERMAL, 1);

        if (item.id == I2Blocks.ulvGeneratorSolar.id)
            thePlayer.addStat(I2Achievements.SOLAR, 1);

        if (item.id == I2Blocks.ulvGeneratorSolar.id)
            thePlayer.addStat(I2Achievements.SOLAR, 1);

        if (item.id == I2Blocks.lvGeneratorSolar.id)
            thePlayer.addStat(I2Achievements.ARRAY1, 1);

        if (item.id == I2Blocks.mvGeneratorSolar.id)
            thePlayer.addStat(I2Achievements.ARRAY2, 1);

        if (item.id == I2Blocks.hvGeneratorSolar.id)
            thePlayer.addStat(I2Achievements.ARRAY3, 1);

        if (item.id == I2Blocks.ehvGeneratorSolar.id)
            thePlayer.addStat(I2Achievements.ARRAY4, 1);

        if (item.id == I2Blocks.lvBatbox.id)
            thePlayer.addStat(I2Achievements.BATBOX1, 1);

        if (item.id == I2Items.toolDrill.id)
            thePlayer.addStat(I2Achievements.DRILL1, 1);

        if (item.id == I2Items.toolDrillGold.id)
            thePlayer.addStat(I2Achievements.DRILL2, 1);

        if (item.id == I2Items.toolDrillDiamond.id)
            thePlayer.addStat(I2Achievements.DRILL3, 1);

        if (item.id == I2Items.toolChainsaw.id)
            thePlayer.addStat(I2Achievements.CHAINSAW, 1);

        if (item.id == I2Items.toolNanoSword.id)
            thePlayer.addStat(I2Achievements.NANOSWORD, 1);

        if (item.id == I2Blocks.nuclearReactor.id)
            thePlayer.addStat(I2Achievements.REACTOR, 1);

        if (item.id == I2Blocks.energyFabricator.id)
            thePlayer.addStat(I2Achievements.FABRICATOR, 1);

        if (item.id == I2Items.ingotIridium.id)
            thePlayer.addStat(I2Achievements.IRIDIUM, 1);

        if (item.id == I2Items.armorHelmetIridium.id ||
                item.id == I2Items.armorChestplateIridium.id ||
                item.id == I2Items.armorLeggingsIridium.id ||
                item.id == I2Items.armorBootsIridium.id)
            thePlayer.addStat(I2Achievements.IRIDIUMARMOR, 1);
    }
}

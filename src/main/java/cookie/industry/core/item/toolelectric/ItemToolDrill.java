package cookie.industry.core.item.toolelectric;

import cookie.industry.core.I2Config;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolPickaxe;

public class ItemToolDrill extends ItemToolElectric {
    public ItemToolDrill(String name, int id, ToolMaterial toolMaterial) {
        super(name, id, toolMaterial);

        this.material = toolMaterial;
        baseCapacity = I2Config.cfg.getInt("Energy Values.lvBatteryStorage");
        baseReceive = I2Config.cfg.getInt("Energy Values.lvIO");
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        return getEnergy(stack) > 0 && (block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) || block.hasTag(BlockTags.MINEABLE_BY_SHOVEL)) ? material.getEfficiency(false) : 0.0F;
    }


    @Override
    public boolean canHarvestBlock(EntityLiving entityLiving, ItemStack itemStack, Block block) {
        Integer miningLevel = ItemToolPickaxe.miningLevels.get(block);

        if (miningLevel != null) {
            return (this.material.getMiningLevel() >= miningLevel);
        } else return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) || block.hasTag(BlockTags.MINEABLE_BY_SHOVEL);

    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1) {
        modifyEnergy(itemstack, -100);
        return true;
    }
}

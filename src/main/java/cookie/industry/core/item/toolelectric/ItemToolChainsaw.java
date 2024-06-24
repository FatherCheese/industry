package cookie.industry.core.item.toolelectric;

import cookie.industry.core.I2Config;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;

public class ItemToolChainsaw extends ItemToolElectric {

    public ItemToolChainsaw(String name, int id) {
        super(name, id, ToolMaterial.iron);
        this.baseCapacity = I2Config.cfg.getInt("Energy Values.lvBatteryStorage");
        this.baseReceive = I2Config.cfg.getInt("Energy Values.lvIO");
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        return getEnergy(stack) > 0 && (block.hasTag(BlockTags.MINEABLE_BY_AXE) || block.hasTag(BlockTags.MINEABLE_BY_SHEARS)) ? 1.0F : 0.0F;
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        return block.hasTag(BlockTags.MINEABLE_BY_AXE) || block.hasTag(BlockTags.MINEABLE_BY_SHEARS);
    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1) {
        modifyEnergy(itemstack, -100);
        return true;
    }
}

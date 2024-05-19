package cookie.industry.item;

import cookie.industry.IndustryTags;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemWrench extends Item {
    public ItemWrench(String name, int id) {
        super(name, id);
        setMaxDamage(127);
        setFull3D();
        setMaxStackSize(1);
    }
    @Override
    public boolean onBlockDestroyed(World world, ItemStack stack, int id, int x, int y, int z, EntityLiving living) {
        Block block = Block.blocksList[id];
        if (block != null && block.getHardness() > 0.0f && block.hasTag(IndustryTags.REQUIRES_WRENCH)) {
            stack.damageItem(1, living);

            return true;
        } else {
            stack.damageItem(2, living);
        }

        return false;
    }
    @Override
    public boolean canHarvestBlock(Block block) {
        return block.hasTag(IndustryTags.REQUIRES_WRENCH);
    }

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block) {
        return block.hasTag(IndustryTags.REQUIRES_WRENCH) ? 5.0F : 1.0F;
    }
}

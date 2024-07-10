package cookie.industry.core.item;

import cookie.industry.core.I2Tags;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemCutters extends Item {
    public ItemCutters(String name, int id) {
        super(name, id);
        setMaxDamage(127);
        setMaxStackSize(1);
    }
    @Override
    public boolean onBlockDestroyed(World world, ItemStack stack, int id, int x, int y, int z, EntityLiving living) {
        Block block = Block.blocksList[id];
        if (block != null && block.getHardness() > 0.0f && block.hasTag(I2Tags.MINEABLE_BY_CUTTERS)) {
            stack.damageItem(1, living);

            return true;
        } else {
            stack.damageItem(2, living);
        }

        return false;
    }
    @Override
    public boolean canHarvestBlock(EntityLiving living, ItemStack stack, Block block) {
        return block.hasTag(I2Tags.MINEABLE_BY_CUTTERS);
    }

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block) {
        return block.hasTag(I2Tags.MINEABLE_BY_CUTTERS) ? 5.0F : 1.0F;
    }
}

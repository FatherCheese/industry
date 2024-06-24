package cookie.industry.core.item.toolelectric;

import cookie.industry.core.I2Config;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.world.World;

public class ItemToolNanoSword extends ItemToolElectric {
    private int damageTimer = 0;
    private boolean active = false;

    // TODO - Fix on/off texture for NanoSword.
    public ItemToolNanoSword(String name, int id) {
        super(name, id, ToolMaterial.steel);
        setHasSubtypes(true);
        setMaxDamage(0);

        baseCapacity = I2Config.cfg.getInt("Energy Values.hvBatteryStorage");
        baseReceive = I2Config.cfg.getInt("Energy Values.hvIO");
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int i, boolean flag) {
        if (!world.isClientSide) {
            if (getEnergy(stack) <= 0) active = false;

            if (active) {
                if (damageTimer++ >= 20 && getEnergy(stack) > 0) {
                    damageTimer = 0;
                    modifyEnergy(stack, -10);
                }
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        world.playSoundAtEntity(null, player, "industry.laser", 1.0f, 1.0f);
        if (!world.isClientSide) {
            active = !active;

            if (active) {
                stack.setMetadata(1);
                modifyEnergy(stack, -10);
            } else stack.setMetadata(0);
        }

        return stack;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        return getEnergy(stack) > 0 && active && block.hasTag(BlockTags.MINEABLE_BY_SWORD) ? 1.0F : 0.0F;
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        return block.hasTag(BlockTags.MINEABLE_BY_SWORD);
    }

    @Override
    public int getDamageVsEntity(Entity entity) {
        if (active) return 20;
        return 1;
    }
}

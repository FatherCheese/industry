package cookie.industry.item.toolelectric;

import cookie.industry.Industry2;
import cookie.industry.I2Config;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

public class ItemToolNanoSword extends ItemToolElectric {
    private int damageTimer = 0;
    private boolean active = false;

    int[][] toolTexture = new int[][]{
            TextureHelper.getOrCreateItemTexture(Industry2.MOD_ID, "tool_nanosword_inactive.png"),
            TextureHelper.getOrCreateItemTexture(Industry2.MOD_ID, "tool_nanosword.png")
    };

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

    @Override
    public int getIconFromDamage(int id) {
        return id == 1 ? iconCoordToIndex(toolTexture[1][0], toolTexture[1][1]) : iconCoordToIndex(toolTexture[0][0], toolTexture[0][1]);
    }
}

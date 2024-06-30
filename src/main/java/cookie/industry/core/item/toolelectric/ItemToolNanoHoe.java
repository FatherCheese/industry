package cookie.industry.core.item.toolelectric;

import cookie.industry.core.I2Config;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemToolNanoHoe extends ItemToolElectric {
    private int damageTimer = 0;
    private boolean active = false;

    // TODO - Fix on/off texture for NanoHoe.
    public ItemToolNanoHoe(String name, int id) {
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
    public ItemStack onUseItem(ItemStack stack, World world, EntityPlayer player) {
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
    public boolean onUseItemOnBlock(ItemStack stack, EntityPlayer player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
        Block block = world.getBlock(blockX, blockY, blockZ);
        Block blockAbove = world.getBlock(blockX, blockY + 1, blockZ);

        // Checks if the hoe is active and the block above doesn't exist.
        // If those pass then hoe the ground, have a chance to drop seeds, and turn the block into farmland
        // but also play a digging dirt sound just like normal and then take away 25 energy.
        if (active && blockAbove == null) {
            if (block == Block.grass || block == Block.dirt || block == Block.pathDirt || block == Block.grassRetro) {
                world.playBlockSoundEffect(player,
                        (float) blockX + 0.5F,
                        (float) blockY + 0.5F,
                        (float) blockZ + 0.5F,
                        Block.dirt,
                        EnumBlockSoundEffectType.DIG);

                if (!world.isClientSide) {
                    world.setBlockWithNotify(blockX, blockY, blockZ, Block.farmlandDirt.id);

                    if (itemRand.nextInt(5) == 0)
                        world.dropItem(blockX, blockY + 1, blockZ, ItemToolNanoHoe.seedsWheat.getDefaultStack());

                    modifyEnergy(stack, -25);
                }
            }
        }

        return true;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        return getEnergy(stack) > 0 && active && block.hasTag(BlockTags.MINEABLE_BY_HOE) ? 1.0F : 0.0F;
    }

    @Override
    public boolean canHarvestBlock(EntityLiving entityLiving, ItemStack itemStack, Block block) {
        return block.hasTag(BlockTags.MINEABLE_BY_HOE);
    }

    @Override
    public boolean onBlockDestroyed(World world, ItemStack stack, int id, int x, int y, int z, EntityLiving living) {
        Block block = world.getBlock(x, y, z);
        if (living != null && !world.isClientSide && (block == Block.tallgrass || block == Block.tallgrassFern)) {
            world.dropItem(x, y + 1, z, ItemToolNanoHoe.seedsWheat.getDefaultStack());
            modifyEnergy(stack, -25);
        }

        return super.onBlockDestroyed(world, stack, id, x, y, z, living);
    }
}

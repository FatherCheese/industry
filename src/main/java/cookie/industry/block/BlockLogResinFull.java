package cookie.industry.block;

import cookie.industry.I2Achievements;
import cookie.industry.item.I2Items;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogResinFull extends BlockLog {

    public BlockLogResinFull(String key, int id) {
        super(key, id);
        this.setTicking(true);
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        double slimeX = x + rand.nextDouble();
        double slimeY = y + rand.nextDouble();
        double slimeZ = z + rand.nextDouble();
        world.spawnParticle("slime", slimeX, slimeY + 0.22, slimeZ, 0.0, -0.2, 0.0);
    }

    @Override
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
        ItemStack itemStack = player.getHeldItem();

            if (itemStack != null && itemStack.getItem() == I2Items.TOOL_TREETAP) {
                world.playSoundAtEntity(player, null, "mob.slime", 1.0f, 1.0f);

                if (!world.isClientSide) {
                    int meta = world.getBlockMetadata(x, y, z);
                    player.addStat(I2Achievements.ROOT1, 1);
                    world.setBlockAndMetadataWithNotify(x, y, z, I2Blocks.RUBBERWOOD_RESIN_LOG.id, meta);
                    world.scheduleBlockUpdate(x, y, z, this.id, tickRate());

                    int randAmount = new Random().nextInt(4 - 1) + 1;
                    player.inventory.insertItem(new ItemStack(I2Items.RESIN, randAmount), false);
                    itemStack.damageItem(1, player);

                    return true;
            }
        }
        return super.blockActivated(world, x, y, z, player);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        if (dropCause == EnumDropCause.PICK_BLOCK) {
            return new ItemStack[]{new ItemStack(this)};
        }
        return new ItemStack[]{new ItemStack(I2Blocks.RUBBERWOOD_LOG)};
    }
}

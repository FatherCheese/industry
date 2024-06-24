package cookie.industry.core.block;

import cookie.industry.core.item.I2ItemsNew;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogResin extends BlockLog {

    public BlockLogResin(String key, int id) {
        super(key, id);
        this.setTicking(true);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        int meta = world.getBlockMetadata(x, y, z);
        world.setBlockAndMetadataWithNotify(x, y, z, I2BlocksNew.EMPTY_RUBBERWOOD_RESIN_LOG.id, meta);
    }

    @Override
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
        if (!world.isClientSide) {
            ItemStack itemStack = player.getHeldItem();
            if (itemStack != null && itemStack.getItem() == I2ItemsNew.TREETAP)
                world.playSoundAtEntity(player, player, "industry.tap", 0.4f, 1.0f);

            world.scheduleBlockUpdate(x, y, z, this.id, world.rand.nextInt(100) + 100);
        }

        return super.blockActivated(world, x, y, z, player);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tile) {
        if (dropCause == EnumDropCause.PICK_BLOCK) {
            return new ItemStack[]{new ItemStack(I2BlocksNew.EMPTY_RUBBERWOOD_RESIN_LOG)};
        }
        return new ItemStack[]{new ItemStack(I2BlocksNew.RUBBERWOOD_LOG)};
    }
}

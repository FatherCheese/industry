package cookie.industry.block;

import cookie.industry.item.I2Items;
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
        world.setBlockAndMetadataWithNotify(x, y, z, I2Blocks.EMPTY_RUBBERWOOD_RESIN_LOG.id, meta);
    }

    @Override
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
        ItemStack itemStack = player.getHeldItem();

        if (itemStack != null && itemStack.getItem() == I2Items.TOOL_TREETAP) {
            world.playSoundAtEntity(player, null, "industry.tap", 0.4f, 1.0f);
        }

        if (!world.isClientSide) {
            world.scheduleBlockUpdate(x, y, z, this.id, world.rand.nextInt(100) + 100);
        }

        return super.blockActivated(world, x, y, z, player);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        if (dropCause == EnumDropCause.PICK_BLOCK) {
            return new ItemStack[]{new ItemStack(I2Blocks.EMPTY_RUBBERWOOD_RESIN_LOG)};
        }
        return new ItemStack[]{new ItemStack(I2Blocks.RUBBERWOOD_LOG)};
    }
}

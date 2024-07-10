package cookie.industry.core.block.machines.lv.production;

import cookie.industry.Industry2;
import cookie.industry.core.I2BlocksNew;
import cookie.industry.core.block.machines.lv.BlockLVMachineBase;
import cookie.industry.core.block.machines.lv.production.entities.TileEntityLVExtractor;
import cookie.industry.core.item.ItemUpgrade;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.Catalyst;

public class BlockLVExtractor extends BlockLVMachineBase {
    public BlockLVExtractor(String key, int id) {
        super(key, id);
    }


    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityLVExtractor();
    }

    @Override
    public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xHit, double yHit) {
        super.onBlockRightClicked(world, x, y, z, player, side, xHit, yHit);
        TileEntityLVExtractor tileEntity = (TileEntityLVExtractor) world.getBlockTileEntity(x, y, z);

        if (tileEntity == null) return false;

        if (player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemUpgrade))
            Catalyst.displayGui(player, tileEntity, tileEntity.getInvName());
        return true;
    }

    protected void dropContents(World world, int x, int y, int z) {
        TileEntityLVExtractor tileEntity = (TileEntityLVExtractor) world.getBlockTileEntity(x, y, z);
        if (!(tileEntity instanceof TileEntityLVExtractor))
            Industry2.logger.error("Couldn't drop inventory at {}, {}, {}!", x, y, z);
        else {
            for (int i = 0; i < tileEntity.getSizeInventory(); ++i) {
                ItemStack itemStack = tileEntity.getStackInSlot(i);
                if (itemStack != null) {
                    EntityItem item = world.dropItem(x, y, z, itemStack);
                    item.xd *= 0.5;
                    item.yd *= 0.5;
                    item.zd *= 0.5;
                    item.delayBeforeCanPickup = 0;
                }
            }
        }
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
            case PROPER_TOOL:
                return new ItemStack[]{new ItemStack(I2BlocksNew.LV_EXTRACTOR)};
            case IMPROPER_TOOL:
            case WORLD:
                return new ItemStack[]{new ItemStack(I2BlocksNew.LV_MACHINE_CASING)};
            case EXPLOSION:
            default:
                return new ItemStack[]{null};
        }
    }
}

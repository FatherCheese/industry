package cookie.industry.core.block.energy.batteryboxes;

import cookie.industry.Industry2;
import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.block.energy.batteryboxes.entities.TileEntityLVBatterybox;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.util.helper.Side;
import sunsetsatellite.catalyst.Catalyst;

public class BlockLVBatterybox extends BlockTileEntity {
    public BlockLVBatterybox(String key, int id) {
        super(key, id, Material.wood);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityLVBatterybox();
    }

    @Override
    public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xPlaced, double yPlaced) {
        TileEntityLVBatterybox tileEntity = (TileEntityLVBatterybox) world.getBlockTileEntity(x, y, z);

        if (tileEntity == null) return false;

        Catalyst.displayGui(player, tileEntity, tileEntity.getInvName());
        return true;
    }

    private void dropContents(World world, int x, int y, int z) {
        if (!(world.getBlockTileEntity(x, y, z) instanceof TileEntityLVBatterybox))
            Industry2.logger.error("Couldn't drop inventory at {}, {}, {}!", x, y, z);
        else {
            TileEntityLVBatterybox tile = (TileEntityLVBatterybox) world.getBlockTileEntity(x, y, z);
            for (int i = 0; i < tile.getSizeInventory(); ++i) {
                ItemStack stack = tile.getStackInSlot(i);
                if (stack != null) {
                    EntityItem item = world.dropItem(x, y, z, stack);
                    item.xd *= 0.5;
                    item.yd *= 0.5;
                    item.zd *= 0.5;
                    item.delayBeforeCanPickup = 0;
                }
            }
        }
    }

    @Override
    public void onBlockRemoved(World world, int x, int y, int z, int data) {
        dropContents(world, x, y, z);
        super.onBlockRemoved(world, x, y, z, data);
    }

    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
            case PROPER_TOOL:
                return new ItemStack[]{new ItemStack(I2BlocksNew.LV_BATTERYBOX)};
            case IMPROPER_TOOL:
            case WORLD:
                return new ItemStack[]{new ItemStack(I2BlocksNew.LV_MACHINE_CASING)};
            case EXPLOSION:
            default:
                return new ItemStack[]{null};
        }
    }
}

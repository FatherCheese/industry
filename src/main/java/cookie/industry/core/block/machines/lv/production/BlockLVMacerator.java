package cookie.industry.core.block.machines.lv.production;

import cookie.industry.Industry2;
import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.block.machines.lv.production.entities.TileEntityLVMacerator;
import net.minecraft.core.block.BlockTileEntityRotatable;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.Catalyst;

public class BlockLVMacerator extends BlockTileEntityRotatable {
    public BlockLVMacerator(String key, int id) {
        super(key, id, Material.metal);
    }


    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityLVMacerator();
    }

    @Override
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
        TileEntityLVMacerator tileEntity = (TileEntityLVMacerator) world.getBlockTileEntity(x, y, z);

        if (tileEntity == null) return false;

        Catalyst.displayGui(player, tileEntity, tileEntity.getInvName());
        return true;
    }

    private void dropContents(World world, int x, int y, int z) {
        TileEntityLVMacerator tileEntity = (TileEntityLVMacerator) world.getBlockTileEntity(x, y, z);
        if (!(tileEntity instanceof TileEntityLVMacerator))
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
    public void onBlockRemoved(World world, int x, int y, int z, int data) {
        dropContents(world, x, y, z);
        super.onBlockRemoved(world, x, y, z, data);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
            case PROPER_TOOL:
                return new ItemStack[]{new ItemStack(I2BlocksNew.LV_MACERATOR)};
            case IMPROPER_TOOL:
            case WORLD:
                return new ItemStack[]{new ItemStack(I2BlocksNew.LV_MACHINE_CASING)};
            case EXPLOSION:
            default:
                return new ItemStack[]{null};
        }
    }
}

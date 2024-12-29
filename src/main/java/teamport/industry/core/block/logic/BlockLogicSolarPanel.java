package teamport.industry.core.block.logic;

import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.Catalyst;
import sunsetsatellite.catalyst.core.util.ICustomDescription;
import teamport.industry.Industry;
import teamport.industry.core.block.IndBlocks;
import teamport.industry.core.block.entity.TileEntitySolarPanel;
import teamport.industry.core.item.IndItems;

/*
 * ===========================================================================
 * File: BlockLogicSolarPanel.java
 * Brief: Block logic for the solar panel
 * Author: Cookie
 * Date: 2024-12-24
 * ===========================================================================
 */
public class BlockLogicSolarPanel extends BlockTileEntity implements ICustomDescription {
    public BlockLogicSolarPanel(String key, int id) {
        super(key, id, Material.metal);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntitySolarPanel();
    }

    @Override
    public void onBlockRemoved(World world, int x, int y, int z, int data) {
        if (data == 1) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

            if (tileEntity instanceof TileEntitySolarPanel) {
                for (ItemStack stack : ((TileEntitySolarPanel) tileEntity).invSlots) {
                    if (stack != null) {
                        float randX = world.rand.nextFloat() * 0.8F + 0.1F;
                        float randY = world.rand.nextFloat() * 0.8F + 0.1F;
                        float randZ = world.rand.nextFloat() * 0.8F + 0.1F;

                        while(stack.stackSize > 0) {
                            int randStackSize = world.rand.nextInt(21) + 10;
                            if (randStackSize > stack.stackSize) {
                                randStackSize = stack.stackSize;
                            }

                            stack.stackSize -= randStackSize;
                            EntityItem entityitem = new EntityItem(world,
                                    (float)x + randX,
                                    (float)y + randY,
                                    (float)z + randZ,
                                    new ItemStack(stack.itemID,
                                            randStackSize,
                                            stack.getMetadata()));
                            float mult = 0.05F;
                            entityitem.xd = (float)world.rand.nextGaussian() * mult;
                            entityitem.yd = (float)world.rand.nextGaussian() * mult + 0.2F;
                            entityitem.zd = (float)world.rand.nextGaussian() * mult;

                            world.entityJoinedWorld(entityitem);
                        }
                    }
                }
            }
        }

        super.onBlockRemoved(world, x, y, z, data);
    }

    @Override
    public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xHit, double yHit) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if (tileEntity == null || tileEntity.isInvalid()) {
            world.setBlockWithNotify(x, y, z, 0);
            Industry.LOGGER.error("Tile entity at {}, {}, {} was null or invalid and has been removed!", x, y, z);
        } else if (tileEntity instanceof TileEntitySolarPanel) {
            Catalyst.displayGui(player, tileEntity, ((TileEntitySolarPanel) tileEntity).getInvName());
        }

        return true;
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
            case PROPER_TOOL:
                return new ItemStack[]{new ItemStack(IndBlocks.SOLAR_PANEL)};
            default:
                return new ItemStack[]{new ItemStack(IndBlocks.MACHINE_BLOCK)};
        }
    }

    @Override
    public String getDescription(ItemStack itemStack) {
        return "Capacity: 1E\nOutput: 1E" ;
    }
}

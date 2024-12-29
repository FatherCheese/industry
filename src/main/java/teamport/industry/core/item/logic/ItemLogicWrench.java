package teamport.industry.core.item.logic;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import teamport.industry.core.block.IndBlockTags;
import teamport.industry.core.block.entity.TileEntityPipe;
import teamport.industry.core.block.interfaces.IPipe;
import teamport.industry.core.block.logic.BlockLogicPipe;

import java.util.Map;

/*
 * ===========================================================================
 * File: ItemLogicWrench.java
 * Brief: Item logic for the wrench
 * Author: Cookie
 * Date: 2024-12-24
 * ===========================================================================
 */
public class ItemLogicWrench extends Item {
    public ItemLogicWrench(String name, int id) {
        super(name, id);
        setMaxDamage(63);
        setMaxStackSize(1);
    }

    @Override
    public boolean onUseItemOnBlock(ItemStack itemstack, EntityPlayer player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
        Block block = world.getBlock(blockX, blockY, blockZ);
        int meta = world.getBlockMetadata(blockX, blockY, blockZ);

        if (block.hasTag(IndBlockTags.REQUIRES_WRENCH)) {
            itemstack.damageItem(1, player);

            block.dropBlockWithCause(world, EnumDropCause.PROPER_TOOL, blockX, blockY, blockZ, meta, null);
            world.setBlockWithNotify(blockX, blockY, blockZ, 0);

            return true;
        }

        if (block instanceof BlockLogicPipe) {
            TileEntity tileEntity = world.getBlockTileEntity(blockX, blockY, blockZ);
            if (tileEntity instanceof TileEntityPipe) {
                for (Map.Entry<Direction, Connection> entry : ((TileEntityPipe) tileEntity).connections.entrySet()) {
                    TileEntity facingTile = entry.getKey().getTileEntity(world, tileEntity);
                    if (facingTile != null) {
                        world.playSoundEffect(player,
                                SoundCategory.ENTITY_SOUNDS,
                                player.x,
                                player.y,
                                player.z,
                                "industry.wrench",
                                0.4f,
                                1.0f);

                        switch (entry.getValue()) {
                            case INPUT:
                                entry.setValue(Connection.OUTPUT);
                                player.sendMessage("Set to output");
                                return true;
                            case OUTPUT:
                                entry.setValue(Connection.BOTH);
                                player.sendMessage("Set to none");
                                return true;
                            case BOTH:
                                entry.setValue(Connection.INPUT);
                                player.sendMessage("Set to input");
                                return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}

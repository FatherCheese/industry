package cookie.industry.core.block.machines.lv;

import cookie.industry.core.block.machines.entities.TileEntityMachineBase;
import cookie.industry.core.item.ItemUpgrade;
import net.minecraft.core.block.BlockTileEntityRotatable;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.collection.Pair;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.Catalyst;
import sunsetsatellite.catalyst.core.util.BlockSection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.core.util.ISideInteractable;

public class BlockLVMachineBase extends BlockTileEntityRotatable implements ISideInteractable {
    public BlockLVMachineBase(String key, int id) {
        super(key, id, Material.metal);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return null;
    }

    protected void dropContents(World world, int x, int y, int z) {

    }

    @Override
    public void onBlockRemoved(World world, int x, int y, int z, int data) {
        TileEntity tile = world.getBlockTileEntity(x, y, z);
        if (tile instanceof TileEntityMachineBase) {
            Direction[] upgradeDirs = ((TileEntityMachineBase) tile).getUpgrades().keySet().toArray(new Direction[0]);
            for (Direction dir : upgradeDirs) {
                ((TileEntityMachineBase) tile).removeUpgrade(dir);
            }
        }

        dropContents(world, x, y, z);
        super.onBlockRemoved(world, x, y, z, data);
    }

    private boolean isPlayerHoldingUpgrade(EntityPlayer player) {
        return (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemUpgrade);
    }

    private boolean pairIsInvalid(Pair<Direction, BlockSection> pair) {
        return pair == null || pair.getLeft() == null || pair.getRight() == null;
    }

    private void handleUpgradeInstallation(World world, EntityPlayer player, int x, int y, int z, Side side, Pair<Direction, BlockSection> dirPair) {
        TileEntity tile = world.getBlockTileEntity(x, y, z);
        ItemUpgrade upgrade = (ItemUpgrade) player.getHeldItem().getItem();

        if (tile instanceof TileEntityMachineBase) {
            Direction dir = dirPair.getRight().toDirection(dirPair.getLeft(), side);

            if (dir == null) return;
            if (((TileEntityMachineBase) tile).installUpgrade(dir, upgrade.upgradeSupplier.get(), player)) {
                if (player.gamemode.consumeBlocks()) player.getCurrentEquippedItem().stackSize--;

                if (player.getCurrentEquippedItem().stackSize <= 0) player.inventory.setCurrentItem(null, false);
            }
        }
    }

    @Override
    public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xHit, double yHit) {
        Pair<Direction, BlockSection> dirPair = Catalyst.getBlockSurfaceClickPosition(world, player);
        Side playerFacing = Catalyst.calculatePlayerFacing(player.yRot);

        if (pairIsInvalid(dirPair)) return false;

        if (isPlayerHoldingUpgrade(player)) handleUpgradeInstallation(world, player, x, y, z, playerFacing, dirPair);

        return true;
    }
}

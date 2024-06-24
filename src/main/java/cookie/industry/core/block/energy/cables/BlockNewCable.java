package cookie.industry.core.block.energy.cables;

import cookie.industry.core.block.energy.cables.entity.TileEntityCable;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockNewCable extends BlockTileEntity {
    public int capacity;
    public int transfer;
    private final int dangerLevel;

    public BlockNewCable(String key, int id, Material material, int capacity, int transfer, int dangerLevel) {
        super(key, id, material);

        this.capacity = capacity;
        this.transfer = transfer;
        this.dangerLevel = dangerLevel;
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityCable(capacity, 0, transfer, dangerLevel);
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
        switch (side) {
            default:
            case 0:
                if (world.isBlockNormalCube(x, y + 1, z)) return true;
            case 1:
                if (world.canPlaceOnSurfaceOfBlock(x, y - 1, z)) return true;
            case 2:
                if (world.isBlockNormalCube(x, y, z + 1)) return true;
            case 3:
                if (world.isBlockNormalCube(x, y, z - 1)) return true;
            case 4:
                if (world.isBlockNormalCube(x + 1, y, z)) return true;
            case 5:
                if (world.isBlockNormalCube(x - 1, y, z)) return true;
        }
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        if (world.isBlockNormalCube(x - 1, y, z)) return true;
        if (world.isBlockNormalCube(x + 1, y, z)) return true;
        if (world.isBlockNormalCube(x, y, z - 1)) return true;
        if (world.isBlockNormalCube(x, y, z + 1)) return true;

        return world.isBlockNormalCube(x, y - 1, z) || world.isBlockNormalCube(x, y + 1, z);
    }

    @Override
    public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
        int meta = world.getBlockMetadata(x, y, z);
        int metaValues = meta & 15;
        meta = -1;
        meta = side.getId();

        if (meta == -1) {
            dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null);
            world.setBlockWithNotify(x, y, z, 0);
        } else {
            world.setBlockMetadataWithNotify(x, y, z, meta + metaValues);
        }
    }

    private boolean checkIfAttachedToBlock(World world, int x, int y, int z) {
        if (!canPlaceBlockAt(world, x, y, z)) {
            dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null);
            world.setBlockWithNotify(x, y, z, 0);
            return false;
        }
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
        if (checkIfAttachedToBlock(world, x, y, z)) {
            int meta = world.getBlockMetadata(x, y, z) & 15;
            boolean dropBlock = false;

            if (!world.isBlockNormalCube(x, y + 1, z) && meta == 0) dropBlock = true;
            if (!world.isBlockNormalCube(x, y - 1, z) && meta == 1) dropBlock = true;
            if (!world.isBlockNormalCube(x, y, z - 1) && meta == 3) dropBlock = true;
            if (!world.isBlockNormalCube(x, y, z + 1) && meta == 2) dropBlock = true;
            if (!world.isBlockNormalCube(x - 1, y, z) && meta == 5) dropBlock = true;
            if (!world.isBlockNormalCube(x + 1, y, z) && meta == 4) dropBlock = true;

            if (dropBlock) {
                dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null);
                world.setBlockWithNotify(x, y, z, 0);
            }
        }
    }

    @Override
    public boolean isSolidRender() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    private AABB cableBoundingBox(WorldSource world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        AABB defaultBox = new AABB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

        if (meta == 0)  defaultBox.setBounds(0.0, 0.8125, 0.0, 1.0, 1.0, 1.0);
        if (meta == 1)  defaultBox.setBounds(0.0, 0.0, 0.0, 1.0, 0.2975, 1.0);
        if (meta == 2) defaultBox.setBounds(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
        if (meta == 3) defaultBox.setBounds(0.0, 0.0, 0.0, 1.0, 1.0, 0.2975);
        if (meta == 4) defaultBox.setBounds(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
        if (meta == 5) defaultBox.setBounds(0.0, 0.0, 0.0, 0.2975, 1.0, 1.0);

        return AABB.getBoundingBoxFromPool(
                x + defaultBox.minX,
                y + defaultBox.minY,
                z + defaultBox.minZ,
                x + defaultBox.maxX,
                y + defaultBox.maxY,
                z + defaultBox.maxZ
        );
    }

    @Override
    public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
        return cableBoundingBox(world, x, y, z);
    }

    @Override
    public AABB getSelectedBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
        return cableBoundingBox(world, x, y, z);
    }
}

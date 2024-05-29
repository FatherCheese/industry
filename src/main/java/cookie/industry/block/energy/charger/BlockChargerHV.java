package cookie.industry.block.energy.charger;

import cookie.industry.block.energy.charger.entity.TileEntityChargerHV;
import cookie.industry.item.I2Items;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockChargerHV extends BlockTileEntity {
    public BlockChargerHV(String key, int id) {
        super(key, id, Material.metal);
        setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.1F, 0.9F);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityChargerHV();
    }

    @Override
    public boolean isSolidRender() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return dropCause != EnumDropCause.IMPROPER_TOOL ? new ItemStack[]{new ItemStack(I2Items.HV_CHARGER_BLOCK)} : null;
    }
}

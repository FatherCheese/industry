package cookie.industry.core.block.energy.charger;

import cookie.industry.core.block.energy.charger.entity.TileEntityChargerLV;
import cookie.industry.core.item.I2ItemsNew;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockChargerLV extends BlockTileEntity {
    public BlockChargerLV(String key, int id) {
        super(key, id, Material.metal);
        setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.1F, 0.9F);
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityChargerLV();
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
        return dropCause != EnumDropCause.IMPROPER_TOOL ? new ItemStack[]{new ItemStack(I2ItemsNew.LV_CHARGING_PAD)} : null;
    }
}

package cookie.industry.core.block;

import cookie.industry.core.I2ItemsNew;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockOreTin extends Block {

    public BlockOreTin(String key, int id) {
        super(key, id, Material.stone);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
                return new ItemStack[]{new ItemStack(this)};
            case PROPER_TOOL:
                return new ItemStack[]{new ItemStack(I2ItemsNew.RAW_TIN)};
            default:
                return null;
        }
    }
}

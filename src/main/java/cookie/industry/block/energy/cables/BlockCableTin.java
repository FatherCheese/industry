package cookie.industry.block.energy.cables;

import cookie.industry.I2Config;
import cookie.industry.item.I2Items;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockCableTin extends BlockCable {
    public BlockCableTin(String key, int id, Material material) {
        super(key,
                id,
                material,
                I2Config.cfg.getInt("Energy Values.lvIO"),
                I2Config.cfg.getInt("Energy Values.lvIO"),
                1);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(I2Items.TIN_CABLE)};
    }
}

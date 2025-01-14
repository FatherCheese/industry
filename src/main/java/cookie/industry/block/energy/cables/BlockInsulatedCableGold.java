package cookie.industry.block.energy.cables;

import cookie.industry.I2Config;
import cookie.industry.item.I2Items;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockInsulatedCableGold extends BlockCable {
    public BlockInsulatedCableGold(String key, int id, Material material) {
        super(key,
                id,
                material,
                I2Config.cfg.getInt("Energy Values.hvIO"),
                I2Config.cfg.getInt("Energy Values.hvIO"),
                0);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(I2Items.INSULATED_GOLD_CABLE)};
    }
}

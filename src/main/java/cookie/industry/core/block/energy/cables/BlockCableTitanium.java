package cookie.industry.core.block.energy.cables;

import cookie.industry.core.I2Config;
import cookie.industry.core.I2ItemsNew;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockCableTitanium extends BlockCable {
    public BlockCableTitanium(String key, int id) {
        super(key,
                id,
                Material.metal,
                I2Config.cfg.getInt("Energy Values.extraHighVoltage"),
                I2Config.cfg.getInt("Energy Values.extraHighVoltage"),
                8);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case SILK_TOUCH:
            case PICK_BLOCK:
            case PROPER_TOOL:
            case WORLD:
                return new ItemStack[]{I2ItemsNew.TITANIUM_CABLE.getDefaultStack()};
            case IMPROPER_TOOL:
            case EXPLOSION:
            default:
                return new ItemStack[]{null};
        }
    }
}

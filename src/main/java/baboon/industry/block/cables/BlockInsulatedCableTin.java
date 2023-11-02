package baboon.industry.block.cables;

import baboon.industry.IndustryConfig;
import baboon.industry.item.IndustryItems;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockInsulatedCableTin extends BlockCable {
    public BlockInsulatedCableTin(String key, int id, Material material) {
        super(key, id, material, IndustryConfig.cfg.getInt("Energy Values.lowVoltage"), IndustryConfig.cfg.getInt("Energy Values.lowVoltage"), 0);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(IndustryItems.itemInsulatedCableTin)};
    }
}
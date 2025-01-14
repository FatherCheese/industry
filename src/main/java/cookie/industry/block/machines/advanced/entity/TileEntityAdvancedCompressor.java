package cookie.industry.block.machines.advanced.entity;

import cookie.industry.block.I2Blocks;
import cookie.industry.block.machines.advanced.BlockAdvancedCompressor;
import cookie.industry.recipe.RecipesCompressor;
import net.minecraft.core.item.ItemStack;

public class TileEntityAdvancedCompressor extends TileEntityAdvancedBase {
    RecipesCompressor recipes = new RecipesCompressor();

    @Override
    public String getInvName() {
        return "IndustryAdvancedCompressor";
    }

    private boolean isProducible(ItemStack itemStack) {
        return recipes.getRecipeList().containsKey(itemStack.getItem().id);
    }

    private boolean canProduce(ItemStack input, ItemStack output) {
        if (input == null || input.getItem() == null)
            return false;

        if (isProducible(input)) {
            ItemStack resultStack = recipes.getRecipeResult(input.getItem().id);

            return output == null || output.getItem() == resultStack.getItem() &&
                    output.stackSize + resultStack.stackSize <= resultStack.getMaxStackSize();
        }
        return false;
    }

    private void produceFirstItem() {
        if (canProduce(contents[2], contents[4])) {
            ItemStack itemStack = recipes.getRecipeResult(contents[2].getItem().id);
            if (itemStack == null)
                return;

            if (contents[4] == null)
                contents[4] = itemStack.copy();
            else
                if (contents[4].getItem().id == itemStack.getItem().id)
                    contents[4].stackSize += itemStack.stackSize;

                --contents[2].stackSize;

                if (contents[2].stackSize <= 0)
                    contents[2] = null;
        }
    }

    private void produceSecondItem() {
        if (canProduce(contents[3], contents[5])) {
            ItemStack itemStack = recipes.getRecipeResult(contents[3].getItem().id);
            if (itemStack == null)
                return;

            if (contents[5] == null)
                contents[5] = itemStack.copy();
            else
            if (contents[5].getItem().id == itemStack.getItem().id)
                contents[5].stackSize += itemStack.stackSize;

            --contents[3].stackSize;

            if (contents[3].stackSize <= 0)
                contents[3] = null;
        }
    }

    @Override
    public void tick() {
        super.tick();
        boolean hasEnergy = energy > 0;

        if (!worldObj.isClientSide) {
            if (currentMachineTime == 0 || currentMachineTime > 0 && contents[2] != null || contents[3] != null) {
                BlockAdvancedCompressor.updateBlockState(true, worldObj, x, y, z);
                onInventoryChanged();

                if (hasEnergy && (canProduce(contents[2], contents[4]) || canProduce(contents[3], contents[5]))) {
                    ++currentMachineTime;
                    energy -= 6;
                    active = true;

                    if (currentSpeed > 0 && energy - 40 * currentSpeed >= -40)
                        energy -= 40 * currentSpeed;

                    if (redstone > 0) {
                        currentMachineTime *= (int) ((double) redstone / 2000);

                        if (canProduce(contents[2], contents[4])) {
                            redstone -= 9;
                            energy -= 6;
                        }

                        if (canProduce(contents[3], contents[5])) {
                            redstone -= 9;
                            energy -= 6;
                        }
                    }

                    if (currentMachineTime >= maxMachineTime) {
                        currentMachineTime = 0;
                        active = false;
                        onInventoryChanged();

                        if (contents[2] != null)
                            produceFirstItem();

                        if (contents[3] != null)
                            produceSecondItem();
                    }
                }
            } else {
                currentMachineTime = 0;
                active = false;
            }

            if (active)
                worldObj.notifyBlockChange(x, y, z, I2Blocks.MV_COMPRESSOR.id);
        }
    }
}

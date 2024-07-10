package cookie.industry.core.block.machines.lv.production.entities;

import cookie.industry.core.block.machines.lv.entities.TileEntityLVMachineBase;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryFurnace;
import net.minecraft.core.item.ItemStack;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.core.util.IItemIO;

import java.util.List;

public class TileEntityLVFurnace extends TileEntityLVMachineBase {
    private final List<RecipeEntryFurnace> recipeList = Registries.RECIPES.getAllFurnaceRecipes();

    public TileEntityLVFurnace() {
        slots = new ItemStack[4];

        for (Direction dir : Direction.values()) {
            setConnection(dir, Connection.INPUT);
        }
    }

    @Override
    public String getInvName() {
        return "IndustryLVFurnace";
    }

    /*
         This function checks if the machine can in-fact produce an item.
         First it checks if slot 2 (input) is empty, or if energy is 0. If either is true then return false.
         Then it sets a temporary null output item and checks if slot 2 is equal to a recipe.
         If it's true then set the temporary output to the recipe's output.
         Finally, at the bottom is bunch of boolean checks.
        */
    @Override
    public boolean canProduce() {
        boolean hasEnergy = energy > 0;
        if (slots[2] == null || !hasEnergy) return false;

        ItemStack output = null;

        for (RecipeEntryFurnace recipe : recipeList) {
            if (recipe != null && recipe.matches(slots[2])) output = recipe.getOutput();
        }

        if (output == null) return false;
        else if (slots[3] == null) return true;
        else if (!slots[3].isItemEqual(output)) return false;
        else return ((slots[3].stackSize + output.stackSize < slots[3].getMaxStackSize()) ||
                    (slots[3].stackSize + output.stackSize < output.getMaxStackSize()));
    }

    /*
     This function actually produces items! First it checks if it can, in-fact, produce via the...
     'canProduce() function above. If it's true then set the same temporary output item as the above function.
     Then it checks if slot 3 (output) is null or matches the output item.
     If it's null then it copies the recipe output stack, otherwise it adds onto the output stack.
     Finally, it decreases the input stacksize.
    */
    @Override
    public void produceItem() {
        if (canProduce()) {
            ItemStack output = null;

            for (RecipeEntryFurnace recipe : recipeList) {
                if (recipe != null && recipe.matches(slots[2])) output = recipe.getOutput();
            }

            if (slots[3] == null && output != null) slots[3] = output.copy();
            else if (slots[3] != null && output != null && slots[3].itemID == output.itemID)
                slots[3].stackSize += output.stackSize;

            --slots[2].stackSize;
            if (slots[2].stackSize <= 0) slots[2] = null;

        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!worldObj.isClientSide) {
            if (canProduce()) machineTick++;

            if (machineTick > 0) {
                energy -= 2;
                active = true;

                if (machineTick == 1) worldObj.markBlockNeedsUpdate(x, y, z);

                if (machineTick >= finalMachineTick) {
                    machineTick = 0;
                    active = false;

                    produceItem();
                    onInventoryChanged();
                    worldObj.markBlockNeedsUpdate(x, y, z);
                }

                if (active && !canProduce()) {
                    machineTick = 0;
                    active = false;
                    worldObj.markBlockNeedsUpdate(x, y, z);
                }
            }
        }
    }
}

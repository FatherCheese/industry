package cookie.industry.core.block.machines.lv.production.entities;

import cookie.industry.core.I2Config;
import cookie.industry.core.block.machines.lv.entities.TileEntityLVMachineBase;
import cookie.industry.core.recipe.registries.I2RecipeRegistries;
import cookie.industry.core.recipe.registries.entries.RecipeEntryCanningMachine;
import net.minecraft.core.item.ItemStack;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;
import sunsetsatellite.catalyst.core.util.IItemIO;

import java.util.List;

public class TileEntityLVCanningMachine extends TileEntityLVMachineBase implements IItemIO {
    private final List<RecipeEntryCanningMachine> recipeList = I2RecipeRegistries.CANNING_MACHINE.getAllRecipes();

    public TileEntityLVCanningMachine() {
        maxProvide = I2Config.cfg.getInt("Energy Values.lvIO");
        maxReceive = I2Config.cfg.getInt("Energy Values.lvIO");
        setCapacity(I2Config.cfg.getInt("Energy Values.lvMachineStorage"));

        slots = new ItemStack[5];

        for (Direction dir : Direction.values()) {
            setConnection(dir, Connection.INPUT);
        }
    }

    @Override
    public int getActiveItemSlotForSide(Direction dir) {
        if (dir == Direction.Y_POS) return 2;
        if (dir == Direction.Y_NEG) return 3;
        return 4;
    }

    @Override
    public int getActiveItemSlotForSide(Direction dir, ItemStack stack) {
        if (dir == Direction.Y_POS) return 2;
        if (dir == Direction.Y_NEG) return 3;
        return 4;
    }

    @Override
    public Connection getItemIOForSide(Direction dir) {
        return (dir == Direction.Y_POS || dir == Direction.Y_NEG) ? Connection.INPUT : Connection.OUTPUT;

    }

    @Override
    public String getInvName() {
        return "IndustryLVCanningMachine";
    }

    /*
         This function checks if the machine can in-fact produce an item.
         First it checks if slot 2 (input) is empty, or if energy is 0. If either is true then return false.
         Then it sets a temporary null output item and checks if slot 2 is equal to a recipe.
         If it's true then set the temporary output to the recipe's output.
         Finally, at the bottom is bunch of boolean checks.
        */
    private boolean canProduce() {
        boolean hasEnergy = energy > 0;
        if (slots[2] == null || !hasEnergy) return false;

        ItemStack output = null;

        for (RecipeEntryCanningMachine recipe : recipeList) {
            if (recipe.inputMatches(slots[2]) && recipe.canMatches(slots[3]) && slots[3].stackSize == recipe.getCanStack()) {
                output = recipe.getOutput();
            }
        }

        if (output == null) return false;
        else if (slots[4] == null) return true;
        else if (!slots[4].isItemEqual(output)) return false;
        else return ((slots[4].stackSize + output.stackSize < slots[4].getMaxStackSize()) ||
                    (slots[4].stackSize + output.stackSize < output.getMaxStackSize()));
    }

    /*
     This function actually produces items! First it checks if it can, in-fact, produce via the...
     'canProduce() function above. If it's true then set the same temporary output item as the above function.
     Then it checks if slot 3 (output) is null or matches the output item.
     If it's null then it copies the recipe output stack, otherwise it adds onto the output stack.
     Finally, it decreases the input stacksize.
    */
    private void produceItem() {
        if (canProduce()) {
            ItemStack output = null;

            for (RecipeEntryCanningMachine recipe : recipeList) {
                if (recipe != null && slots[3] != null)
                    if ((recipe.inputMatches(slots[2]) && recipe.canMatches(slots[3]))) output = recipe.getOutput();
            }

            if (slots[4] == null && output != null) slots[4] = output.copy();
            else if (slots[4] != null && output != null && slots[4].itemID == output.itemID)
                slots[4].stackSize += output.stackSize;

            --slots[2].stackSize;
            if (slots[2].stackSize <= 0) slots[2] = null;

            if (slots[3] != null) {
                slots[3].stackSize -= recipeList.get(1).getCanStack();
                if (slots[3].stackSize <= 0) slots[3] = null;
            }
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

                if ((slots[2] == null || energy < 0) && active) {
                    machineTick = 0;
                    active = false;
                    worldObj.markBlockNeedsUpdate(x, y, z);
                }
            }
        }
    }
}

package cookie.industry.core.block.machines.lv.production.entities;

import cookie.industry.core.block.machines.lv.entities.TileEntityLVMachineBase;
import cookie.industry.core.block.machines.upgrades.MachineUpgradePulling;
import cookie.industry.core.block.machines.upgrades.MachineUpgradePushing;
import cookie.industry.core.recipe.registries.I2RecipeRegistries;
import cookie.industry.core.recipe.registries.entries.RecipeEntryCanningMachine;
import net.minecraft.core.item.ItemStack;
import sunsetsatellite.catalyst.core.util.Connection;
import sunsetsatellite.catalyst.core.util.Direction;

import java.util.List;

public class TileEntityLVCanningMachine extends TileEntityLVMachineBase {
    private final List<RecipeEntryCanningMachine> recipeList = I2RecipeRegistries.CANNING_MACHINE.getAllRecipes();

    public TileEntityLVCanningMachine() {
        slots = new ItemStack[5];

        for (Direction dir : Direction.values()) {
            setConnection(dir, Connection.INPUT);

            if (dir == Direction.Y_POS) {
                itemConnections.put(dir, Connection.INPUT);
                activeItemSlots.put(dir, 0);
            }
        }
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
    @Override
    public boolean canProduce() {
        boolean hasEnergy = energy > 0;
        if (slots[2] == null || !hasEnergy) return false;

        ItemStack output = null;

        for (RecipeEntryCanningMachine recipe : recipeList) {
            if (recipe.inputMatches(slots[2]) && recipe.canMatches(slots[3]) && slots[3].stackSize >= recipe.getCanStack(slots[3])) {
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
    @Override
    public void produceItem() {
        if (canProduce()) {
            ItemStack output = null;

            for (RecipeEntryCanningMachine recipe : recipeList) {
                if (recipe != null && slots[3] != null)
                    if ((recipe.inputMatches(slots[2]) && recipe.canMatches(slots[3]))) output = recipe.getOutput();
            }

            if (slots[4] == null && output != null) slots[4] = output.copy();
            else if (slots[4] != null && output != null && slots[4].itemID == output.itemID)
                slots[4].stackSize += output.stackSize;

            if (slots[3] != null) {
                for (RecipeEntryCanningMachine recipe : recipeList) {
                    if (recipe.inputMatches(slots[2])) slots[3].stackSize -= recipe.getCanStack(slots[3]);
                }
                if (slots[3].stackSize <= 0) slots[3] = null;
            }

            // Had to move this down because of can stack weirdness
            --slots[2].stackSize;
            if (slots[2].stackSize <= 0) slots[2] = null;
        }
    }

    @Override
    public int getActiveItemSlotForSide(Direction dir) {
        return super.getActiveItemSlotForSide(dir);
    }

    @Override
    public int getActiveItemSlotForSide(Direction dir, ItemStack stack) {
        return super.getActiveItemSlotForSide(dir, stack);
    }

    @Override
    public void tick() {
        super.tick();

        for (Direction dir : Direction.values()) {
            if (upgrades.get(dir) instanceof MachineUpgradePushing) {
                itemConnections.put(dir, Connection.OUTPUT);
                activeItemSlots.put(dir, 4);
            }

            if (upgrades.get(dir) instanceof MachineUpgradePulling) {
                itemConnections.put(dir, Connection.INPUT);
                activeItemSlots.put(dir, dir != Direction.Y_NEG ? 2 : 3);
            }
        }

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

package cookie.industry.core.recipe.fuel;

import cookie.industry.core.item.I2ItemsNew;
import net.minecraft.core.item.Item;

import java.util.HashMap;

public class GeneratorGeothermalFuel {
    private static final HashMap<Integer, Integer> fuelList = new HashMap<>();

    public GeneratorGeothermalFuel() {
        addFuel(Item.bucketLava.id, 1000);
        addFuel(I2ItemsNew.LAVA_CELL.id, 1000);
        addFuel(Item.nethercoal.id, 250);
    }

    public static void addFuel(int inputItem, int outputYield) {
        fuelList.put(inputItem, outputYield);
    }

    public int getYield(int i) {
        return fuelList.get(i);
    }

    public HashMap<Integer, Integer> getFuelList() {
        return fuelList;
    }
}

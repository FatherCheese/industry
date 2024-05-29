package cookie.industry.recipe.fuel;

import cookie.industry.item.I2Items;
import net.minecraft.core.item.Item;

import java.util.HashMap;

public class WaterFuel {
    private static final HashMap<Integer, Integer> fuelList = new HashMap<>();

    public WaterFuel() {
        addFuel(Item.bucketWater.id, 1000);
        addFuel(I2Items.WATER_CELL.id, 1000);
        addFuel(I2Items.COOLANT_CELL.id, 4000);
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

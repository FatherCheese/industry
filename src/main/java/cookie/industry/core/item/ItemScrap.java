package cookie.industry.core.item;

import cookie.industry.core.I2ItemsNew;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.HashMap;

public class ItemScrap extends Item {
    public static HashMap<Integer, ItemStack> randomItem = new HashMap<>();
    public ItemScrap(String name, int id) {
        super(name, id);
    }

    @Override
    public ItemStack onUseItem(ItemStack stack, World world, EntityPlayer player) {
        // This will choose a random item to give the player, based on everything in the randomItem hashmap.
        // Only exception is if a random timer set to 200 is equal to 0, then the player will receive a golden apple.
        if (!world.isClientSide) {
            int randSelect = itemRand.nextInt(randomItem.size());

            stack.consumeItem(player);
            player.inventory.insertItem(itemRand.nextInt(200) != 0 ? randomItem.get(randSelect) : Item.foodAppleGold.getDefaultStack(), false);
        }
        return stack;
    }

    static {
        randomItem.put(0, Item.bone.getDefaultStack());
        randomItem.put(1, Item.foodBread.getDefaultStack());
        randomItem.put(2, Item.foodCake.getDefaultStack());
        randomItem.put(3, I2ItemsNew.FILLED_CAN.getDefaultStack());
        randomItem.put(4, Item.foodPorkchopCooked.getDefaultStack());
        randomItem.put(5, Item.coal.getDefaultStack());
        randomItem.put(6, I2ItemsNew.COAL_DUST.getDefaultStack());
        randomItem.put(7, I2ItemsNew.RAW_TIN.getDefaultStack());
        randomItem.put(8, I2ItemsNew.TIN_DUST.getDefaultStack());
        randomItem.put(9, I2ItemsNew.RAW_COPPER.getDefaultStack());
        randomItem.put(10, I2ItemsNew.COPPER_DUST.getDefaultStack());
        randomItem.put(11, Item.oreRawIron.getDefaultStack());
        randomItem.put(12, I2ItemsNew.IRON_DUST.getDefaultStack());
        randomItem.put(13, Item.oreRawGold.getDefaultStack());
        randomItem.put(14, I2ItemsNew.GOLD_DUST.getDefaultStack());
        randomItem.put(15, Item.diamond.getDefaultStack());
        randomItem.put(16, Item.cloth.getDefaultStack());
        randomItem.put(17, Item.chainlink.getDefaultStack());
        randomItem.put(18, Item.string.getDefaultStack());
        randomItem.put(19, Item.sulphur.getDefaultStack());
        randomItem.put(20, Item.foodApple.getDefaultStack());
    }
}

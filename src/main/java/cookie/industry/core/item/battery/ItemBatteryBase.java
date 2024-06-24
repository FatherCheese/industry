package cookie.industry.core.item.battery;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.command.TextFormatting;
import sunsetsatellite.catalyst.core.util.ICustomDescription;
import sunsetsatellite.catalyst.energy.api.IEnergyItem;

public class ItemBatteryBase extends Item implements ICustomDescription, IEnergyItem {
    public int baseCapacity;
    public int baseProvide;
    public int baseReceive;

    public ItemBatteryBase(String name, int i, int capacity, int provide, int receive, String emptyTexture, String midEmptyTexture, String midTexture, String midFullTexture, String fullTexture) {
        super(name, i);
        setMaxStackSize(1);

        baseCapacity = capacity;
        baseProvide = provide;
        baseReceive = receive;
    }

    @Override
    public String getDescription(ItemStack stack) {
        return TextFormatting.WHITE + "Max Transfer: " + TextFormatting.LIGHT_GRAY + "IN: " + baseReceive + TextFormatting.WHITE + " / " + TextFormatting.LIGHT_GRAY + "OUT: " + baseProvide + "\n"
                + TextFormatting.WHITE + "Energy: " + TextFormatting.LIGHT_GRAY + getEnergy(stack) + TextFormatting.WHITE + " / " + TextFormatting.LIGHT_GRAY + baseCapacity;
    }

    public int provide(ItemStack stack, int amount, boolean test) {
        int provided = Math.min(this.getEnergy(stack), Math.min(this.getMaxProvide(stack), amount));
        if (!test) {
            this.modifyEnergy(stack, -provided);
        }

        return provided;
    }

    public int receive(ItemStack stack, int amount, boolean test) {
        int received = Math.min(this.getCapacity(stack) - this.getEnergy(stack), Math.min(this.getMaxReceive(stack), amount));
        if (!test) {
            this.modifyEnergy(stack, received);
        }

        return received;
    }

    public int getEnergy(ItemStack stack) {
        return stack.getData().getInteger("energy");
    }

    public int getCapacity(ItemStack stack) {
        if (!stack.getData().containsKey("capacity")) {
            stack.getData().putInt("capacity", this.baseCapacity);
            return this.baseCapacity;
        } else {
            return stack.getData().getInteger("capacity");
        }
    }

    public int getMaxReceive(ItemStack stack) {
        if (!stack.getData().containsKey("maxReceive")) {
            stack.getData().putInt("maxReceive", this.baseReceive);
            return this.baseReceive;
        } else {
            return stack.getData().getInteger("maxReceive");
        }
    }

    public int getMaxProvide(ItemStack stack) {
        if (!stack.getData().containsKey("maxProvide")) {
            stack.getData().putInt("maxProvide", this.baseProvide);
            return this.baseProvide;
        } else {
            return stack.getData().getInteger("maxProvide");
        }
    }

    public void modifyEnergy(ItemStack stack, int amount) {
        if (stack.getData().getInteger("energy") + amount > this.getCapacity(stack)) {
            stack.getData().putInt("energy", this.getCapacity(stack));
        } else if (stack.getData().getInteger("energy") + amount < 0) {
            stack.getData().putInt("energy", 0);
        } else {
            stack.getData().putInt("energy", this.getEnergy(stack) + amount);
        }
    }
}

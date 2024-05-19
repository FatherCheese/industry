package cookie.industry.item.toolelectric;

import cookie.industry.I2Config;
import cookie.industry.IndustryTags;
import cookie.industry.item.ItemWrench;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.core.util.ICustomDescription;
import sunsetsatellite.catalyst.energy.api.IEnergyItem;

public class ItemToolElectricWrench extends ItemWrench implements IEnergyItem, ICustomDescription {
    public int baseCapacity;
    public int baseProvide = 0;
    public int baseReceive;

    public ItemToolElectricWrench(String name, int id) {
        super(name, id);

        baseCapacity = I2Config.cfg.getInt("Energy Values.lvBatteryStorage");
        baseReceive = I2Config.cfg.getInt("Energy Values.lvIO");
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        return getEnergy(stack) > 0 && block.hasTag(IndustryTags.REQUIRES_WRENCH) ? 10.0F : 0.0F;
    }

    @Override
    public boolean onBlockDestroyed(World world, ItemStack stack, int id, int x, int y, int z, EntityLiving living) {
        Block block = Block.blocksList[id];
        if (block != null && block.getHardness() > 0.0f && block.hasTag(IndustryTags.REQUIRES_WRENCH)) {
            modifyEnergy(stack, -25);
            return true;
        }
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLiving living, EntityLiving living2) {
        modifyEnergy(stack, -100);
        return true;
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

    @Override
    public String getDescription(ItemStack stack) {
        return TextFormatting.WHITE + "Energy: " + TextFormatting.LIGHT_GRAY + getEnergy(stack) + TextFormatting.WHITE + " / " + TextFormatting.LIGHT_GRAY + baseCapacity;
    }
}

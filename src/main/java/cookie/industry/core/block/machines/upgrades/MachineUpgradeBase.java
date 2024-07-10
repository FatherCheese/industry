package cookie.industry.core.block.machines.upgrades;

import com.mojang.nbt.CompoundTag;
import cookie.industry.core.item.ItemUpgrade;
import cookie.industry.extra.IAcceptsUpgrades;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.core.entity.player.EntityPlayer;
import sunsetsatellite.catalyst.core.util.Direction;

public abstract class MachineUpgradeBase {
    protected Direction direction;
    protected IAcceptsUpgrades machine;

    public Direction getDirection() {
        return direction;
    }

    public IAcceptsUpgrades getMachine() {
        return machine;
    }

    public void writeToNBT(CompoundTag tag) {
        tag.putString("Type", getClass().getCanonicalName());
        tag.putInt("Direction", direction.ordinal());
    }

    public void readFromNBT(CompoundTag tag) {
        direction = Direction.values()[tag.getInteger("Direction")];
    }

    public void setup(Direction dir, IAcceptsUpgrades machine) {
        this.direction = dir;
        this.machine = machine;
    }

    public void onInstall(Direction dir, IAcceptsUpgrades machine) {
        this.direction = dir;
        this.machine = machine;
    }

    public void onInstall(Direction dir, IAcceptsUpgrades machine, EntityPlayer player) {
        this.direction = dir;
        this.machine = machine;
    }

    public void onRemove() {
        direction = null;
        machine = null;
    }

    public void onRemove(EntityPlayer player) {
        direction = null;
        machine = null;
    }

    public boolean equals(Object obj) {
        return getClass() == obj.getClass();
    }

    public abstract void tick();

    public abstract IconCoordinate getTexture();

    public abstract ItemUpgrade getItem();
}

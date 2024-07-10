package cookie.industry.extra;

import cookie.industry.core.block.machines.upgrades.MachineUpgradeBase;
import net.minecraft.core.entity.player.EntityPlayer;
import sunsetsatellite.catalyst.core.util.Direction;

import java.util.HashMap;
import java.util.Map;

public interface IAcceptsUpgrades {
    boolean installUpgrade(Direction dir, MachineUpgradeBase upgradeBase);

    boolean installUpgrade(Direction dir, MachineUpgradeBase upgradeBase, EntityPlayer player);

    boolean removeUpgrade(Direction dir);

    boolean removeUpgrade(Direction dir, EntityPlayer player);

    boolean removeUpgrade(Direction dir, MachineUpgradeBase upgradeBase);

    boolean removeUpgrade(Direction dir, MachineUpgradeBase upgradeBase, EntityPlayer player);

    boolean hasUpgrade(Direction dir, Class<? extends MachineUpgradeBase> upgradeBase);

    boolean hasUpgrade(Class<? extends MachineUpgradeBase> upgradeBase);

    HashMap<Direction, MachineUpgradeBase> getUpgrades();
}

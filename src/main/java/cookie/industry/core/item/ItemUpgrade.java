package cookie.industry.core.item;

import cookie.industry.core.block.machines.upgrades.MachineUpgradeBase;
import net.minecraft.core.item.Item;
import sunsetsatellite.catalyst.core.util.ISideInteractable;

import java.util.function.Supplier;

public class ItemUpgrade extends Item implements ISideInteractable {

    public Supplier<MachineUpgradeBase> upgradeSupplier;

    public ItemUpgrade(String name, int id, Supplier<MachineUpgradeBase> upgradeSupplier) {
        super(name, id);
        this.upgradeSupplier = upgradeSupplier;
    }
}

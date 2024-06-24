package cookie.industry.core.item.battery.model;

import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.item.Item;
import sunsetsatellite.catalyst.CatalystEnergy;
import sunsetsatellite.catalyst.energy.api.IEnergyItem;

public class ItemModelBattery extends ItemModelStandard {
    public ItemModelBattery(Item item, String namespace) {
        super(item, namespace);
        if (namespace != null && item instanceof IEnergyItem) {
            int mapped = (int) CatalystEnergy.map(
                    ((double) ((IEnergyItem) item).getEnergy(item.getDefaultStack()) / ((IEnergyItem) item).getCapacity(item.getDefaultStack())),
                    0.0,
                    1.0,
                    0.0,
                    4.0);

            icon = TextureRegistry.getTexture(namespace + ":item/" + item.getKey().replaceFirst("item." + namespace + ".", "").replace(".", "_") + "_" + mapped);
        }
    }
}

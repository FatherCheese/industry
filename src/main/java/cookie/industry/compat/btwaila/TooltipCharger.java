package cookie.industry.compat.btwaila;

import cookie.industry.block.energy.charger.entity.*;
import toufoumaster.btwaila.gui.components.AdvancedInfoComponent;
import toufoumaster.btwaila.tooltips.TileTooltip;

public class TooltipCharger extends TileTooltip<TileEntityChargerBase> {
    @Override
    public void initTooltip() {
        addClass(TileEntityChargerLV.class);
        addClass(TileEntityChargerMV.class);
        addClass(TileEntityChargerHV.class);
        addClass(TileEntityChargerEHV.class);
    }

    @Override
    public void drawAdvancedTooltip(TileEntityChargerBase tileEntity, AdvancedInfoComponent advancedInfoComponent) {
        advancedInfoComponent.drawStringWithShadow("Current Health: " + tileEntity.machineHealth, 0);
        advancedInfoComponent.drawStringWithShadow("Stored Energy: " + tileEntity.energy + " / " + tileEntity.capacity, 0);
    }
}

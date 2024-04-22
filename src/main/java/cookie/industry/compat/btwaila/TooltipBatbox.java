package cookie.industry.compat.btwaila;

import cookie.industry.block.storage.entity.TileEntityBatboxBase;
import cookie.industry.block.storage.entity.TileEntityBatboxEHV;
import cookie.industry.block.storage.entity.TileEntityBatboxHV;
import cookie.industry.block.storage.entity.TileEntityBatboxLV;
import cookie.industry.block.storage.entity.TileEntityBatboxMV;
import toufoumaster.btwaila.gui.components.AdvancedInfoComponent;
import toufoumaster.btwaila.tooltips.TileTooltip;

public class TooltipBatbox extends TileTooltip<TileEntityBatboxBase> {
    @Override
    public void initTooltip() {
        addClass(TileEntityBatboxLV.class);
        addClass(TileEntityBatboxMV.class);
        addClass(TileEntityBatboxHV.class);
        addClass(TileEntityBatboxEHV.class);
    }

    @Override
    public void drawAdvancedTooltip(TileEntityBatboxBase batBox, AdvancedInfoComponent advancedInfoComponent) {
        advancedInfoComponent.drawStringWithShadow("Current Health: " + batBox.machineHealth, 0);
        advancedInfoComponent.drawStringWithShadow("Stored Energy: " + batBox.energy + " / " + batBox.capacity, 0);
        advancedInfoComponent.drawInventory(batBox, 0);
    }
}

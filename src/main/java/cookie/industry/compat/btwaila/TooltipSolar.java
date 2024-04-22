package cookie.industry.compat.btwaila;

import cookie.industry.block.energy.generator.entity.TileEntityArrayEHV;
import cookie.industry.block.energy.generator.entity.TileEntityArrayHV;
import cookie.industry.block.energy.generator.entity.TileEntityArrayLV;
import cookie.industry.block.energy.generator.entity.TileEntityArrayMV;
import cookie.industry.block.energy.generator.entity.TileEntityGeneratorSolar;
import cookie.industry.block.energy.generator.entity.TileEntitySolarBase;
import toufoumaster.btwaila.gui.components.AdvancedInfoComponent;
import toufoumaster.btwaila.tooltips.TileTooltip;

public class TooltipSolar extends TileTooltip<TileEntitySolarBase> {
    @Override
    public void initTooltip() {
        addClass(TileEntityGeneratorSolar.class);
        addClass(TileEntityArrayLV.class);
        addClass(TileEntityArrayMV.class);
        addClass(TileEntityArrayHV.class);
        addClass(TileEntityArrayEHV.class);
    }
    @Override
    public void drawAdvancedTooltip(TileEntitySolarBase tile, AdvancedInfoComponent advancedInfoComponent) {
        advancedInfoComponent.drawStringWithShadow("Stored Energy: " + tile.energy + " / " + tile.capacity, 0);
        advancedInfoComponent.drawStringWithShadow("Is sun visible? " + tile.getIsSkyVisible(), 0);

        advancedInfoComponent.drawInventory(tile, 0);
    }
}

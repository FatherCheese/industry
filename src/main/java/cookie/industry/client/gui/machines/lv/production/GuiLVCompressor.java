package cookie.industry.client.gui.machines.lv.production;

import cookie.industry.core.block.machines.lv.production.entities.TileEntityLVCompressor;
import net.minecraft.core.player.inventory.InventoryPlayer;

public class GuiLVCompressor extends GuiLVMachineBase {

    public GuiLVCompressor(InventoryPlayer inventory, TileEntityLVCompressor tileEntity) {
        super(new ContainerLVMachineBase(inventory, tileEntity), tileEntity);
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        super.drawGuiContainerForegroundLayer();
        int scrnX = xSize / 2;

        drawStringCenteredNoShadow(fontRenderer, i18n.translateKey("gui.industry.lv_compressor"), scrnX, 6, 4210752);
        fontRenderer.drawString(i18n.translateKey("gui.industry.inventory"), 8, (ySize - 96) + 2, 4210752);
    }
}

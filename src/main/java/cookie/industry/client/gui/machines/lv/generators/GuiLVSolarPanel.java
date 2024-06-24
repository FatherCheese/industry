package cookie.industry.client.gui.machines.lv.generators;

import cookie.industry.core.block.machines.lv.generators.entities.TileEntityLVSolarPanel;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiTooltip;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.core.player.inventory.InventoryPlayer;
import org.lwjgl.opengl.GL11;

public class GuiLVSolarPanel extends GuiContainer {
    private final TileEntityLVSolarPanel tileEntity;
    private final I18n i18n = I18n.getInstance();

    public GuiLVSolarPanel(InventoryPlayer player, TileEntityLVSolarPanel tileEntity) {
        super(new ContainerLVSolarPanel(player, tileEntity));
        this.tileEntity = tileEntity;

    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        int texture = mc.renderEngine.getTexture("/assets/industry/textures/gui/generator_solar.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mc.renderEngine.bindTexture(texture);

        int scrnX = (width - xSize) / 2;
        int scrnY = (height - ySize) / 2;
        drawTexturedModalRect(scrnX, scrnY, 0, 0, xSize, ySize);

        float power = (float) tileEntity.energy / tileEntity.capacity;
        drawTexturedModalRect(scrnX + 80, scrnY + 39, 176, 0, (int) (power * 16), 8);

        // This draws a sun or moon texture next to the power bar, based on the time of day, weather,
        // and whether the block can see the sky or not.
        boolean canSeeTheSky = tileEntity.canSeeTheSky;
        if (canSeeTheSky) drawTexturedModalRect(scrnX + 102, scrnY + 39, 176, 8, 8, 8);
        else drawTexturedModalRect(scrnX + 102, scrnY + 39, 184, 8, 8, 8);
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        super.drawGuiContainerForegroundLayer();
        int scrnX = xSize / 2;

        drawStringCenteredNoShadow(fontRenderer, i18n.translateKey("gui.industry.lv_solar_panel"), scrnX, 6, 4210752);
        fontRenderer.drawString(i18n.translateKey("gui.industry.inventory"), 8, (ySize - 96) + 2, 4210752);
    }

    @Override
    public void drawScreen(int x, int y, float renderPartialTicks) {
        super.drawScreen(x, y, renderPartialTicks);
        int scrnX = (width - xSize) / 2;
        int scrnY = (height - ySize) / 2;

        if (x > (scrnX + 80) && x < (scrnX + 96)) {
            if (y > (scrnY + 39) && y < (scrnY + 47)) {
                String text = TextFormatting.WHITE + i18n.translateKey("gui.industry.energy") + ": " + TextFormatting.LIGHT_GRAY + tileEntity.energy + TextFormatting.WHITE + " / " + TextFormatting.LIGHT_GRAY + tileEntity.capacity;

                GuiTooltip tooltip = new GuiTooltip(mc);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_CULL_FACE);
                tooltip.render(text, x, y, 8, -8);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_CULL_FACE);
            }
        }
    }
}

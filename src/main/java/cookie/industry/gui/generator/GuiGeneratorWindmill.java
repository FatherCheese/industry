package cookie.industry.gui.generator;

import cookie.industry.block.energy.generator.entity.TileEntityGeneratorWindmill;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiTooltip;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.net.command.TextFormatting;
import net.minecraft.core.player.inventory.InventoryPlayer;
import org.lwjgl.opengl.GL11;

public class GuiGeneratorWindmill extends GuiContainer {
    private final TileEntityGeneratorWindmill tileEntity;
    I18n i18n = I18n.getInstance();

    public GuiGeneratorWindmill(InventoryPlayer inventory, TileEntityGeneratorWindmill tileEntity) {
        super(new ContainerGeneratorWindmill(inventory, tileEntity));
        this.tileEntity = tileEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        int texture = mc.renderEngine.getTexture("/assets/industry/gui/generator_windmill.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mc.renderEngine.bindTexture(texture);

        int scrnX = (width - xSize) / 2;
        int scrnY = (height - ySize) / 2;
        drawTexturedModalRect(scrnX, scrnY, 0, 0, xSize, ySize);

        float power = (float) tileEntity.energy / tileEntity.capacity;
        drawTexturedModalRect(scrnX + 80, scrnY + 39, 176, 0, (int) (power * 16), 8);

        int height = tileEntity.currentHeight;
        drawTexturedModalRect(scrnX + 102, (scrnY + 27) + (32 - height), 176, 39 - height, 4, height);
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        int scrnX = xSize / 2;
        drawStringCenteredNoShadow(fontRenderer, i18n.translateKey("gui.industry.generator.windmill"), scrnX, 6, 4210752);
        fontRenderer.drawString(i18n.translateKey("gui.industry.inventory"), 8, (ySize - 96) + 2, 4210752);
    }

    @Override
    public void drawScreen(int x, int y, float renderPartialTicks) {
        super.drawScreen(x, y, renderPartialTicks);
        int scrnX = (width - xSize) / 2;
        int scrnY = (height - ySize) / 2;

        if (x > (scrnX + 80) && x < (scrnX + 96))
            if (y > (scrnY + 39) && y < (scrnY + 47)) {
                String text = TextFormatting.WHITE + i18n.translateKey("gui.industry.energy") + ": " + TextFormatting.LIGHT_GRAY + tileEntity.energy + TextFormatting.WHITE + " / " + TextFormatting.LIGHT_GRAY + tileEntity.capacity;

                GuiTooltip tooltip = new GuiTooltip(mc);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glCullFace(GL11.GL_CULL_FACE);
                tooltip.render(text, x, y, 8, -8);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_CULL_FACE);
            }

        if (x > (scrnX + 102) && x < (scrnX + 106))
            if (y > (scrnY + 27) && y < (scrnY + 59)) {
                String text = TextFormatting.WHITE + i18n.translateKey("gui.industry.height") + ": " + TextFormatting.LIGHT_GRAY + tileEntity.y + TextFormatting.WHITE + " / " + TextFormatting.LIGHT_GRAY + 255;

                GuiTooltip tooltip = new GuiTooltip(mc);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glCullFace(GL11.GL_CULL_FACE);
                tooltip.render(text, x, y, 8, -8);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_CULL_FACE);
            }
    }
}

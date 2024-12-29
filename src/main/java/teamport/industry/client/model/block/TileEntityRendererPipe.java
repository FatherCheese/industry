package teamport.industry.client.model.block;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.world.World;
import teamport.industry.core.block.entity.TileEntityPipe;



public class TileEntityRendererPipe extends TileEntityRenderer<TileEntityPipe> {
    private static final ItemEntityRenderer itemEntityRenderer = new ItemEntityRenderer();
    private EntityItem entityItem = null;

    @Override
    public void onWorldChanged(World world) {
        itemEntityRenderer.setRenderDispatcher(EntityRenderDispatcher.instance);
        super.onWorldChanged(world);
    }

    @Override
    public void doRender(Tessellator tessellator, TileEntityPipe tileEntity, double x, double y, double z, float partialTick) {
        if (tileEntity.getContents() != null) {
            entityItem = new EntityItem(tileEntity.worldObj, 0, 0, 0, tileEntity.getContents());
            entityItem.setRot(0, 0);
            entityItem.entityBrightness = 1;
            entityItem.age = 0;


        }
    }
}

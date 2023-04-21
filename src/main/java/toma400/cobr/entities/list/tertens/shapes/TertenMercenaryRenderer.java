package toma400.cobr.entities.list.tertens.shapes;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import toma400.cobr.Cobr;
import toma400.cobr.entities.list.tertens.TertenMercenary;

public class TertenMercenaryRenderer extends MobRenderer<TertenMercenary, TertenMercenaryType<TertenMercenary>> {

    public TertenMercenaryRenderer(EntityRendererProvider.Context renderManager) {
        // Third element sets entities' shadow
        super(renderManager, new TertenMercenaryType<>(renderManager.bakeLayer(TertenMercenaryType.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TertenMercenary pEntity) {
        return new ResourceLocation(Cobr.MOD_ID, "textures/entity/tertens/terten_desert.png");
    }
}

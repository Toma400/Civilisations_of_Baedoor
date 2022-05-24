package toma400.cobr.render.entities.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import toma400.cobr.Cobr;
import toma400.cobr.entities.list.tertens.TertenMercenary;
import toma400.cobr.render.entities.models.TertenMercenaryType;

public class TertenMercenaryRenderer extends MobRenderer<TertenMercenary, TertenMercenaryType<TertenMercenary>> {

    public TertenMercenaryRenderer(EntityRendererManager renderManagerIn, TertenMercenaryType<TertenMercenary> entityManagerIn) {
        // Third element sets entities' shadow
        super(renderManagerIn, entityManagerIn, 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TertenMercenary pEntity) {
        return new ResourceLocation(Cobr.MOD_ID, "textures/entity/tertens/terten_desert.png");
    }
}

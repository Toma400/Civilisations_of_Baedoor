package toma400.cobr.entities.list.tertens.shapes;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import toma400.cobr.Cobr;
import toma400.cobr.entities.list.tertens.TertenCaravanMercenary;

public class TertenCaravanMercenaryRenderer extends MobRenderer<TertenCaravanMercenary, TertenCaravanMercenaryType<TertenCaravanMercenary>> {

    public TertenCaravanMercenaryRenderer(EntityRendererManager renderManagerIn) {
        // Third element sets entities' shadow
        super(renderManagerIn, new TertenCaravanMercenaryType<>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TertenCaravanMercenary pEntity) {
        return new ResourceLocation(Cobr.MOD_ID, "textures/entity/tertens/terten_desert.png");
    }
}

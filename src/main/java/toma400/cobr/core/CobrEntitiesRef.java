package toma400.cobr.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import toma400.cobr.entities.list.tertens.TertenCaravanMercenary;
import toma400.cobr.entities.list.tertens.shapes.TertenCaravanMercenaryRenderer;

import java.util.HashMap;
import java.util.Map;

public class CobrEntitiesRef {

    // ---------------------------------------------------------------------------------
    // REFERENCE HELPER
    // -- Fill those:
    //    * entityRegistry
    //    * globalEntityRenderingRegistrar
    // -- Make:
    //    * spawn egg
    //    * translation key (entity + egg)
    // ---------------------------------------------------------------------------------
    public static final Map<EntityType<? extends LivingEntity>,
            AttributeModifierMap> entityRegistry = new HashMap<EntityType<? extends LivingEntity>,
            AttributeModifierMap>() {{
        put(CobrEntities.TERTEN_CARAVAN_MERCENARY.get(), TertenCaravanMercenary.setAttributes());
    }};

    public static void globalEntityRenderingRegistrar() {

        for (RegistryObject<EntityType<?>> entity : CobrEntities.ENTITIES.getEntries()) {
            // empty loop for later use
        }
        // all manual registrars are done below, though:
        RenderingRegistry.registerEntityRenderingHandler(CobrEntities.TERTEN_CARAVAN_MERCENARY.get(), TertenCaravanMercenaryRenderer::new);
    }

}

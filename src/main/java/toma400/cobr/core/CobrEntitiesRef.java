package toma400.cobr.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import toma400.cobr.entities.list.tertens.TertenMercenary;
import toma400.cobr.entities.list.tertens.shapes.TertenMercenaryRenderer;

import java.util.HashMap;
import java.util.Map;

public class CobrEntitiesRef {

    // ---------------------------------------------------------------------------------
    // REFERENCE HELPER
    // -- Fill those:
    //    * entityRegistry
    //    * globalEntityRenderingRegistrar
    // ---------------------------------------------------------------------------------
    public static final Map<EntityType<? extends LivingEntity>,
            AttributeModifierMap> entityRegistry = new HashMap<EntityType<? extends LivingEntity>,
            AttributeModifierMap>() {{
        put(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenary.setAttributes());
    }};

    public static void globalEntityRenderingRegistrar() {

        for (RegistryObject<EntityType<?>> entity : CobrEntities.ENTITIES.getEntries()) {
            // empty loop for later use
        }
        // all manual registrars are done below, though:
        RenderingRegistry.registerEntityRenderingHandler(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenaryRenderer::new);
    }

}

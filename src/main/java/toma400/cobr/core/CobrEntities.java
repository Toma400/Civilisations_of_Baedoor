package toma400.cobr.core;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import toma400.cobr.Cobr;
import toma400.cobr.entities.list.tertens.TertenMercenary;
import toma400.cobr.entities.list.tertens.shapes.TertenMercenaryRenderer;

import java.util.HashMap;
import java.util.Map;

public class CobrEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Cobr.MOD_ID);

    public static final RegistryObject<EntityType<TertenMercenary>> TERTEN_MERCENARY = ENTITIES.register("terten_mercenary",
            () -> EntityType.Builder.of(TertenMercenary::new, EntityClassification.AMBIENT)
                    .sized(0.6f, 2.5f).setTrackingRange(64)
                    .fireImmune()
                    .build(new ResourceLocation(Cobr.MOD_ID, "terten_mercenary").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    // ---------------------------------------------------------------------------------
    // TECHNICAL REGISTRARS
    // ---------------------------------------------------------------------------------
    public static final Map<EntityType<? extends LivingEntity>,
                                         AttributeModifierMap> entityRegistry = new HashMap<EntityType<? extends LivingEntity>,
                                                                                                         AttributeModifierMap>() {{
        put(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenary.setAttributes());
    }};

    public static void globalEntityRenderingRegistrar() {

        // Entities
        for (RegistryObject<EntityType<?>> entity : ENTITIES.getEntries()) {
            // empty loop for later use
        }
        // all manual registrars are done below, though:
        RenderingRegistry.registerEntityRenderingHandler(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenaryRenderer::new);
    }
}

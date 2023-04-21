package toma400.cobr.core;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.entities.list.tertens.TertenMercenary;
import toma400.cobr.entities.list.tertens.shapes.TertenMercenaryRenderer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Cobr.MOD_ID)
public class CobrEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Cobr.MOD_ID);

    public static final RegistryObject<EntityType<TertenMercenary>> TERTEN_MERCENARY = ENTITIES.register("terten_mercenary",
            () -> EntityType.Builder.of(TertenMercenary::new, MobCategory.AMBIENT)
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
                                            AttributeSupplier> entityRegistry = new HashMap<EntityType<? extends LivingEntity>,
                                                                                                            AttributeSupplier>() {{
        put(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenary.setAttributes());
    }};

    public static void globalEntityRenderingRegistrar(Collection<RegistryObject<EntityType<?>>> entities) {

        // Entities
        for (RegistryObject<EntityType<?>> entity : entities) {
            // empty loop for later use
        }
        // all manual registrars are done below, though:
        EntityRenderers.register(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenaryRenderer::new);
    }
}

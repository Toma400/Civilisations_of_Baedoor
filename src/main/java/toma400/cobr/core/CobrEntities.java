package toma400.cobr.core;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.entities.list.tertens.TertenCaravanMercenary;
import toma400.cobr.entities.list.tertens.shapes.TertenCaravanMercenaryRenderer;
import toma400.cobr.entities.list.tertens.shapes.TertenCaravanMercenaryType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Cobr.MOD_ID)
public class CobrEntities {

    public class Reg {

        public static final DeferredRegister<EntityType<?>> ENTITIES =
                DeferredRegister.create(ForgeRegistries.ENTITIES, Cobr.MOD_ID);

        public static final RegistryObject<EntityType<TertenCaravanMercenary>> TERTEN_CARAVAN_MERCENARY = ENTITIES.register(TertenCaravanMercenary.ID,
                () -> EntityType.Builder.of(TertenCaravanMercenary::new, MobCategory.AMBIENT)
                        .sized(0.6f, 2.5f).setTrackingRange(64)
                        .fireImmune()
                        .build(new ResourceLocation(Cobr.MOD_ID, TertenCaravanMercenary.ID).toString()));

        public static void register(IEventBus eventBus) {
            ENTITIES.register(eventBus);
        }

    }

    public class Helper {
        // ---------------------------------------------------------------------------------
        // TECHNICAL REGISTRARS
        // -- Fill those:
        //    * entityRegistry
        //    * layersRegistry
        //    * globalEntityRenderingRegistrar
        // -- Make:
        //    * spawn egg
        //    * translation key (entity + egg)
        // ---------------------------------------------------------------------------------

        public static final Map<EntityType<? extends LivingEntity>,
                                                AttributeSupplier> entityRegistry = new HashMap<EntityType<? extends LivingEntity>,
                                                                                                                AttributeSupplier>() {{
            put(Reg.TERTEN_CARAVAN_MERCENARY.get(), TertenCaravanMercenary.setAttributes());
        }};

        public static void layersRegistry (EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(TertenCaravanMercenaryType.LAYER_LOCATION, TertenCaravanMercenaryType::createBodyLayer);
        }

        public static void globalEntityRenderingRegistrar(Collection<RegistryObject<EntityType<?>>> entities) {

            // Entities
            for (RegistryObject<EntityType<?>> entity : entities) {
                // empty loop for later use
            }
            // all manual registrars are done below, though:
            EntityRenderers.register(Reg.TERTEN_CARAVAN_MERCENARY.get(), TertenCaravanMercenaryRenderer::new);
        }

    }
}

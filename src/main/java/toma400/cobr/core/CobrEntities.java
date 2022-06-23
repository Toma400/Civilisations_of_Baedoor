package toma400.cobr.core;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import toma400.cobr.Cobr;
import toma400.cobr.entities.list.tertens.TertenMercenary;

import java.util.Collection;

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
    public static void attributesRegistrar(EntityAttributeCreationEvent event, Collection<RegistryObject<EntityType<?>>> entities) {
        event.put(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenary.setAttributes());
    }
}

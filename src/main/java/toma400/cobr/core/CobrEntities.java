package toma400.cobr.core;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import toma400.cobr.Cobr;
import toma400.cobr.entities.list.tertens.TertenCaravanMercenary;

public class CobrEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Cobr.MOD_ID);

    public static final RegistryObject<EntityType<TertenCaravanMercenary>> TERTEN_CARAVAN_MERCENARY = ENTITIES.register(TertenCaravanMercenary.ID,
            () -> EntityType.Builder.of(TertenCaravanMercenary::new, EntityClassification.AMBIENT)
                    .sized(0.6f, 2.5f).setTrackingRange(64)
                    .fireImmune()
                    .build(new ResourceLocation(Cobr.MOD_ID, TertenCaravanMercenary.ID).toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

}

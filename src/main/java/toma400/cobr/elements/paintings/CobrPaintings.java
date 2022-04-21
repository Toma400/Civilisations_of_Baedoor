package toma400.cobr.elements.paintings;

import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;

public class CobrPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Cobr.MOD_ID);

    public static final RegistryObject<Motive> FIRE =
            PAINTING_MOTIVES.register("fire", () -> new Motive(32, 32));
    public static final RegistryObject<Motive> WIND =
            PAINTING_MOTIVES.register("wind", () -> new Motive(32, 32));
    public static final RegistryObject<Motive> EARTH =
            PAINTING_MOTIVES.register("earth", () -> new Motive(32, 32));
    public static final RegistryObject<Motive> WATER =
            PAINTING_MOTIVES.register("water", () -> new Motive(32, 32));

    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }
}

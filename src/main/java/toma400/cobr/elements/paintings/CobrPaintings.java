package toma400.cobr.elements.paintings;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import toma400.cobr.Cobr;

public class CobrPaintings {

    public static final DeferredRegister<PaintingType> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Cobr.MOD_ID);

    public static final RegistryObject<PaintingType> FIRE =
            PAINTING_MOTIVES.register("fire", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> WIND =
            PAINTING_MOTIVES.register("wind", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> EARTH =
            PAINTING_MOTIVES.register("earth", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> WATER =
            PAINTING_MOTIVES.register("water", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> WORLDS_COLLIDE =
            PAINTING_MOTIVES.register("worlds_collide", () -> new PaintingType(64, 64));

    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }
}

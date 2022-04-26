package toma400.cobr.world.biomes;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;

public class BiomeRegistrar {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, Cobr.MOD_ID);

    // public static final RegistryObject<Biome> DRY_LANDS = BIOMES.register("dry_lands", BiomeDictionary.addTypes(DRY_LANDS_CONTEXT, new BiomeDictionary.Type[] { BiomeDictionary.Type.WET, BiomeDictionary.Type.OCEAN }););

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }

}

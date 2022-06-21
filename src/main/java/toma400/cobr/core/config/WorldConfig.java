package toma400.cobr.core.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;

public class WorldConfig {

    public static final String WORLD_CONFIG_PATH = FMLPaths.GAMEDIR.get().resolve("cobr-server.toml").toString();
    // Categories for values
    public static final String TYPE_WORLDGEN = "World Generation";
    public static final String TYPE_STRUCTURES = "Structures";
    public static final String TYPE_MECHANICS = "Mechanics";
    public static final String TYPE_MOBS_CIV = "Entities: Civilisations";
    public static final String TYPE_MOBS_ANIMALS = "Entities: Animals";
    public static final String TYPE_OTHERS = "Other";
    private static final Double VERSION = VersionHandler.CURRENT_CONFIG_VERSION;
    public static ForgeConfigSpec WORLD_CONFIG;

    //----------------------------------------------------------------
    // VALUES
    //----------------------------------------------------------------
    // WORLDGEN
    public static ForgeConfigSpec.BooleanValue OVERWORLD_IMPACT;
    // STRUCTURES
    public static ForgeConfigSpec.IntValue TERTEN_CAMP_RARITY;
    public static ForgeConfigSpec.IntValue TERTEN_OUTPOST_RARITY;
    public static ForgeConfigSpec.IntValue TERTEN_CITY_RARITY;
    // MECHANICS
    public static ForgeConfigSpec.BooleanValue SLOWER_SAND_TRAVERSING;
    // MOBS: CIVILISATIONS
    public static ForgeConfigSpec.BooleanValue CAMEL_MAGE_SPAWN;
    public static ForgeConfigSpec.IntValue CAMEL_MAGE_SPAWN_CHANCE;
    public static ForgeConfigSpec.BooleanValue TERTEN_PATROLS_SPAWN;
    public static ForgeConfigSpec.IntValue TERTEN_PATROLS_SPAWN_CHANCE;
    // MOBS: ANIMALS
    public static ForgeConfigSpec.BooleanValue WHITE_LIZARD_SPAWN;
    public static ForgeConfigSpec.IntValue WHITE_LIZARD_SPAWN_RANGE;
    public static ForgeConfigSpec.IntValue WHITE_LIZARD_SPAWN_AMOUNT;
    // OTHER
    public static ForgeConfigSpec.BooleanValue DEVELOPERS_MODE;
    public static ForgeConfigSpec.DoubleValue CONFIG_VERSION;
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    // BUILDERS
    //----------------------------------------------------------------
    private static void configValuesBuilder(ForgeConfigSpec.Builder WORLD_CONFIG_BUILDER) {
        // CONFIG VERSIONING
        CONFIG_VERSION = WORLD_CONFIG_BUILDER
                .comment("Does not change this value. It is for internal code reference.")
                .defineInRange("config_version", VERSION, VERSION, VERSION);
        //---------------------------------------
        // WORLDGEN CATEGORY
        //---------------------------------------
        WORLD_CONFIG_BUILDER.push(TYPE_WORLDGEN);
        // WORLDGEN
        OVERWORLD_IMPACT = WORLD_CONFIG_BUILDER
                .comment("Should overworld generate civilisation structures? This does not affect dimension generation.")
                .define("overworld_impact", true);
        //---------------------------------------
        // STRUCTURES CATEGORY
        //---------------------------------------
        WORLD_CONFIG_BUILDER.pop();
        WORLD_CONFIG_BUILDER.push(TYPE_STRUCTURES);
        // STRUCTURES
        TERTEN_CAMP_RARITY = WORLD_CONFIG_BUILDER
                .defineInRange("terten_camp_rarity", 5, 0, 1000);
        TERTEN_OUTPOST_RARITY = WORLD_CONFIG_BUILDER
                .defineInRange("terten_outpost_rarity", 5, 0, 1000);
        TERTEN_CITY_RARITY = WORLD_CONFIG_BUILDER
                .defineInRange("terten_city_rarity", 5, 0, 1000);
        //---------------------------------------
        // MECHANICS CATEGORY
        //---------------------------------------
        WORLD_CONFIG_BUILDER.pop();
        WORLD_CONFIG_BUILDER.push(TYPE_MECHANICS);
        // MECHANICS
        SLOWER_SAND_TRAVERSING = WORLD_CONFIG_BUILDER
                .comment("Allows CoB to slow down player when traversing sand.")
                .define("slow_sand_traversing", true);
        //---------------------------------------
        // ENTITIES: CIVILISATIONS CATEGORY
        //---------------------------------------
        WORLD_CONFIG_BUILDER.pop();
        WORLD_CONFIG_BUILDER.push(TYPE_MOBS_CIV);
        // ENTITIES: CIVILISATIONS
        CAMEL_MAGE_SPAWN = WORLD_CONFIG_BUILDER
                .comment("Allows for spawning of camel mages. They are crucial for entering of Dunes dimension, so disable them with caution.")
                .define("camel_mage", true);
        CAMEL_MAGE_SPAWN_CHANCE = WORLD_CONFIG_BUILDER
                .defineInRange("camel_mage_chance", 2, 0, 100);
        TERTEN_PATROLS_SPAWN = WORLD_CONFIG_BUILDER
                .comment("Allows for spawning of terten patrols.")
                .define("terten_patrols", true);
        TERTEN_PATROLS_SPAWN_CHANCE = WORLD_CONFIG_BUILDER
                .defineInRange("terten_patrols_chance", 3, 0, 100);
        //---------------------------------------
        // ENTITIES: ANIMALS CATEGORY
        //---------------------------------------
        WORLD_CONFIG_BUILDER.pop();
        WORLD_CONFIG_BUILDER.comment("Animal values are a bit different because they use amount/versus/range values. In short, the bigger the amount, or the lower the range, the more entities will spawn.").push(TYPE_MOBS_ANIMALS);
        // ENTITIES: ANIMALS
        WHITE_LIZARD_SPAWN = WORLD_CONFIG_BUILDER
                .comment("Allows for spawning of white lizards")
                .define("white_lizard", true);
        WHITE_LIZARD_SPAWN_AMOUNT = WORLD_CONFIG_BUILDER
                .defineInRange("white_lizard_amount", 1, 0, 10); // Change "max" to mobcap limits once you introduce those
        WHITE_LIZARD_SPAWN_RANGE = WORLD_CONFIG_BUILDER
                .defineInRange("white_lizard_range", 7, 0, 160);
        //---------------------------------------
        // OTHERS CATEGORY
        //---------------------------------------
        WORLD_CONFIG_BUILDER.pop();
        WORLD_CONFIG_BUILDER.push(TYPE_OTHERS);
        // OTHERS
        DEVELOPERS_MODE = WORLD_CONFIG_BUILDER
                .comment("Adds unstable features being still tested by developers.")
                .define("developers_mode", false);
    }
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    // TECHNICALS
    //----------------------------------------------------------------
    static {
        ForgeConfigSpec.Builder WORLD_CONFIG_BUILDER = new ForgeConfigSpec.Builder();

        configValuesBuilder(WORLD_CONFIG_BUILDER);

        WORLD_CONFIG = WORLD_CONFIG_BUILDER.build();
    }
    public static void loadConfigFile (ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        VersionHandler.mainHandler(CONFIG_VERSION.get());
        config.setConfig(file);
    }

}
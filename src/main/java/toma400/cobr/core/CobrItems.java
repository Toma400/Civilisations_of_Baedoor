package toma400.cobr.core;

import net.minecraft.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import toma400.cobr.Cobr;
import toma400.cobr.elements.items.templated.FuelItems;
import toma400.cobr.elements.items.templated.SabreItems;
import toma400.cobr.entities.list.tertens.TertenCaravanMercenary;

// ------------------------------------------
// DISBANDMENT SCROLL TOOLTIP GOT OUTED TEMPORARILY
// ------------------------------------------

public class CobrItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cobr.MOD_ID);

    //RESOURCES (FOODS & SMALLER STUFF)
    public static final RegistryObject<Item> EOTIC_BAMBOO = ITEMS.register("eotic_bamboo",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> RAW_LIZARD_MEAT = ITEMS.register("raw_lizard_meat",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB).food(CobrFoods.RAW_LIZARD_MEAT)));
    public static final RegistryObject<Item> COOKED_LIZARD_MEAT = ITEMS.register("cooked_lizard_meat",
            () -> new CobrFoods.FoodItem(new Item.Properties().tab(CobrTab.COBR_TAB).food(CobrFoods.COOKED_LIZARD_MEAT)));
    public static final RegistryObject<Item> LIZARD_STEW = ITEMS.register("lizard_stew",
            () -> new CobrFoods.SoupItems(new Item.Properties().tab(CobrTab.COBR_TAB).food(CobrFoods.LIZARD_STEW)));

    //ORE RESOURCES
    public static final RegistryObject<Item> DUNE_COAL = ITEMS.register("dune_coal",
            () -> new FuelItems(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> CIRTAIN_NUGGET = ITEMS.register("cirtain_nugget",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> CIRTAIN_SCRAP = ITEMS.register("cirtain_scrap",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> RAW_DUNE_GOLD = ITEMS.register("raw_dune_gold",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> DUNE_GOLD_INGOT = ITEMS.register("dune_gold_ingot",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> DUNE_GOLD_NUGGET = ITEMS.register("dune_gold_nugget",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));

    //WEAPONS
    public static final RegistryObject<Item> BONE_SHORTSWORD = ITEMS.register("bone_shortsword",
            () -> new SwordItem(ItemTier.IRON, 6, 1.5f, new Item.Properties().tab(CobrTab.COBR_TAB).durability(240)));
    public static final RegistryObject<Item> BONE_SABRE = ITEMS.register("bone_sabre",
            () -> new SabreItems(ItemTier.IRON, 6, 2.4f, new Item.Properties().tab(CobrTab.COBR_TAB).durability(140)));

    //SPAWN EGGS
    public static final RegistryObject<Item> TERTEN_CARAVAN_MERCENARY_SPAWN_EGG = ITEMS.register(TertenCaravanMercenary.ID + "_spawn_egg",
            () -> new ForgeSpawnEggItem(CobrEntities.TERTEN_CARAVAN_MERCENARY, 0xe0c52d, 0xccc07c, new SpawnEggItem.Properties().tab(CobrTab.COBR_ENTITY_TAB)));


    //more complex items which I don't want to make separate class for (yet or ever)
    public static final RegistryObject<Item> DISBANDMENT_SCROLL = ITEMS.register("disbandment_scroll",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

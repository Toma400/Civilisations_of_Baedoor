package toma400.cobr.core;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import toma400.cobr.Cobr;
import toma400.cobr.elements.items.CustomCobrFoods;
import toma400.cobr.elements.items.SabreItems;

import java.util.List;

public class CobrItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cobr.MOD_ID);


    //RESOURCES (FOODS & SMALLER STUFF)
    public static final RegistryObject<Item> EOTIC_BAMBOO = ITEMS.register("eotic_bamboo",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> RAW_LIZARD_MEAT = ITEMS.register("raw_lizard_meat",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB).food(CobrFoods.RAW_LIZARD_MEAT)));
    public static final RegistryObject<Item> COOKED_LIZARD_MEAT = ITEMS.register("cooked_lizard_meat",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB).food(CustomCobrFoods.COOKED_LIZARD_MEAT)));
    public static final RegistryObject<Item> LIZARD_STEW = ITEMS.register("lizard_stew",
            () -> new BowlFoodItem(new BowlFoodItem.Properties().tab(CobrTab.COBR_TAB).food(CobrFoods.LIZARD_STEW)));

    //ORE RESOURCES
    public static final RegistryObject<Item> DUNE_COAL = ITEMS.register("dune_coal",
            () -> new CobrFuels(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> CIRTAIN_NUGGET = ITEMS.register("cirtain_nugget",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> CIRTAIN_SCRAP = ITEMS.register("cirtain_scrap",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));
    public static final RegistryObject<Item> DUNE_GOLD_INGOT = ITEMS.register("dune_gold_ingot",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)));

    //WEAPONS
    public static final RegistryObject<Item> BONE_SHORTSWORD = ITEMS.register("bone_shortsword",
            () -> new SwordItem(Tiers.IRON, 6, 1.5f, new Item.Properties().tab(CobrTab.COBR_TAB).durability(240)));
    public static final RegistryObject<Item> BONE_SABRE = ITEMS.register("bone_sabre",
            () -> new SabreItems(Tiers.IRON, 6, 2.4f, new Item.Properties().tab(CobrTab.COBR_TAB).durability(140)));


    //more complex items which I don't want to make separate class for (yet or ever)
    public static final RegistryObject<Item> DISBANDMENT_SCROLL = ITEMS.register("disbandment_scroll",
            () -> new Item(new Item.Properties().tab(CobrTab.COBR_TAB)) {
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.cobr.disbandment_scroll"));
                }
            });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
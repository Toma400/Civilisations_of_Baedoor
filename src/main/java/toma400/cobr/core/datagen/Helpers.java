package toma400.cobr.core.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrItems;

public class Helpers {

    //ITERATORS
    public static Item ItemRegistryIterator() {
        return CobrItems.ITEMS.getEntries().iterator().next().get().asItem();
    }

    //ITEM GENERATION
    public class ItemModelTypes {
        // Parent type should evoke ItemModelTypeRef here instead
        public static final ResourceLocation GENERATED = new ResourceLocation("item/generated");
        public static final ResourceLocation HANDHELD = new ResourceLocation("item/handheld");
    }

    public static final ResourceLocation ItemModelTypeRef(Item item, String nonStandardTypeSelector) {
        ResourceLocation Item = new ResourceLocation(Cobr.MOD_ID + ":" + "item/" + item.getRegistryName().getPath());
        ResourceLocation Block = new ResourceLocation(Cobr.MOD_ID + ":" + "block/" + item.getRegistryName().getPath());
        if (nonStandardTypeSelector != "block") {
            //default value returned
            return Item;
        } else {
            return Block;
        }
    }

    //BLOCK GENERATION
    public static final ResourceLocation BlockModelTypeRef(String item) {
        ResourceLocation Block = new ResourceLocation("byg:block/" + item);
        return Block;
    }
    public static final ResourceLocation MainBlockModelTypeRef(String item) {
        ResourceLocation Block = new ResourceLocation("wobyg:block/" + item);
        return Block;
    }

}

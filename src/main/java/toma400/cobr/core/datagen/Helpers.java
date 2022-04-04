package toma400.cobr.core.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;
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
        public static final ModelFile GENERATED_FILE = new ModelFile(new ResourceLocation("item/generated")) {
            @Override
            protected boolean exists() {
                return false;
            }
        };
        public static final ModelFile HANDHELD_FILE = new ModelFile(new ResourceLocation("item/handheld")) {
            @Override
            protected boolean exists() {
                return false;
            }
        };
    }

    public static final ResourceLocation ItemPathRef(Item item, String nonStandardTypeSelector) {
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
    public static final ResourceLocation BlockPathRef(String namespace, String item) {
        ResourceLocation Block = new ResourceLocation(Cobr.MOD_ID + ":block/" + item);
        if (namespace != "" && namespace != "mod") {
            Block = new ResourceLocation(namespace + ":block/" + item);
        }
        return Block;
    }

}

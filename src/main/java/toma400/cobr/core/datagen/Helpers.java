package toma400.cobr.core.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrItems;

public class Helpers {

    //ITERATORS
    @Deprecated
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

    //ITEM GENERATION
    public static final ResourceLocation ItemPathRef(String namespace, String item) {
        ResourceLocation Item = new ResourceLocation(Cobr.MOD_ID + ":item/" + item);
        if (namespace != "" && namespace != "mod") {
            Item = new ResourceLocation(namespace + ":item/" + item);
        }
        return Item;
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

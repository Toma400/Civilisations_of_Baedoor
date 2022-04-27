package toma400.cobr.core.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrItems;

import java.util.Collection;
import java.util.stream.Collectors;

public class Helpers {

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

    @Deprecated
    public void leafThingForTomi(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            for (Block output : ForgeRegistries.BLOCKS.getValues().stream().filter(b -> b.getRegistryName().getNamespace().equals(Cobr.MOD_ID)).collect(Collectors.toList())) {

                String regName = block.get().getRegistryName().getPath();
                String[] split = regName.split("_");
                if (split[split.length - 1].equals("leaves")) {
                    continue;
                }

                String outName = output.getRegistryName().getPath();
                String[] outSplit = outName.split("_");
                if (outSplit[outSplit.length - 1].equals("sapling")) {
                    if (outSplit[outSplit.length - 2].equals(split[split.length - 2])) {
                        //createLeavesDrops(block.get(), output);
                    }
                }
            }
        }
    }
}

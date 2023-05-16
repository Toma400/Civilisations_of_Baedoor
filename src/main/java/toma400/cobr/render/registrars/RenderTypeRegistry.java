package toma400.cobr.render.registrars;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.elements.blocks.templated.MatBlocks;

import java.util.Collection;

public class RenderTypeRegistry {

    public static void GlobalRenderingRegistrar(Collection<RegistryObject<Block>> blocks){
            for (RegistryObject<Block> block : blocks) {
                if (block.get() instanceof DoorBlock ||
                    block.get() instanceof TrapDoorBlock ||
                    block.get() instanceof FenceBlock ||
                    block.get() instanceof FenceGateBlock ||
                    block.get() instanceof LeavesBlock ||
                    block.get() instanceof SaplingBlock ||
                    block.get() instanceof MatBlocks) {
                        ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.cutout());
                }
            }
        }
}

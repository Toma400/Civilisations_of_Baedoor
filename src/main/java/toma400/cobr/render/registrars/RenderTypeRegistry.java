package toma400.cobr.render.registrars;

import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import toma400.cobr.core.CobrEntities;
import toma400.cobr.elements.blocks.templated.Base;
import toma400.cobr.elements.blocks.templated.MatBlocks;
import toma400.cobr.entities.list.tertens.shapes.TertenMercenaryRenderer;

import java.util.Collection;

public class RenderTypeRegistry {

    public static void globalBlockRenderingRegistrar(Collection<RegistryObject<Block>> blocks, Collection<RegistryObject<EntityType<?>>> entities){
        for (RegistryObject<Block> block : blocks) {
            if (block.get() instanceof DoorBlock ||
                block.get() instanceof TrapDoorBlock ||
                block.get() instanceof FenceBlock ||
                block.get() instanceof FenceGateBlock ||
                block.get() instanceof LeavesBlock ||
                block.get() instanceof Base.SaplingBlock ||
                block.get() instanceof MatBlocks) {
                RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
            }
        }
        for (RegistryObject<EntityType<?>> entity : entities) {
            RenderingRegistry.registerEntityRenderingHandler(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenaryRenderer::new);
        }
    }

}

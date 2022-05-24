package toma400.cobr.render.registrars;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrEntities;
import toma400.cobr.elements.blocks.templated.MatBlocks;
import toma400.cobr.render.entities.renderers.TertenMercenaryRenderer;

import java.util.Collection;

public class RenderTypeRegistry {

    public static void GlobalRenderingRegistrar(Collection<RegistryObject<Block>> blocks, Collection<RegistryObject<EntityType<?>>> entities){
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
            for (RegistryObject<EntityType<?>> entity : entities) {
                // pass
                //EntityRenderers.register(CobrEntities.TERTEN_MERCENARY.get(), TertenMercenaryRenderer::new);
            }
        }
}

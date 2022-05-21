package toma400.cobr.render.registrars;

import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.RegistryObject;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.Base;
import toma400.cobr.elements.blocks.templated.MatBlocks;

import java.util.ArrayList;
import java.util.Collection;

public class RenderTypeRegistry {

    public static void globalBlockRenderingRegistrar(Collection<RegistryObject<Block>> blocks){
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
    }

    @Deprecated
    public static void globalRenderingRegistrarDeprecated() {
        RenderTypeLookup.setRenderLayer(CobrBlocks.ESRAH_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.ESRAH_TRAPDOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.ESRAH_FENCE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.ESRAH_FENCE_GATE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.LAIS_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.LAIS_TRAPDOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.LAIS_FENCE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.LAIS_FENCE_GATE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.ESRAH_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.LAIS_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CobrBlocks.BLOOMING_LAIS_LEAVES.get(), RenderType.cutout());
        //RenderTypeLookup.setRenderLayer(CobrBlocks.ESRAH_SAPLING.get(), RenderType.cutout());
        //RenderTypeLookup.setRenderLayer(CobrBlocks.LAIS_SAPLING.get(), RenderType.cutout());
    }

}

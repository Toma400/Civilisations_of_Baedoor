package toma400.cobr.render.registrars;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import toma400.cobr.core.CobrBlocks;

public class RenderTypeRegistry {

    public static void GlobalRenderingRegistrar() {
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

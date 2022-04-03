package toma400.cobr.client.general;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import toma400.cobr.core.CobrBlocks;

public class RenderTypeRegistry {

    public static void GlobalRenderingRegistrar() {
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_FENCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_FENCE_GATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_FENCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_FENCE_GATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.BLOOMING_LAIS_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_SAPLING.get(), RenderType.cutout());
    }

}

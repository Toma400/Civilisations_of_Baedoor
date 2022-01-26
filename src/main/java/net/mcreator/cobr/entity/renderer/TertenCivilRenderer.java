package net.mcreator.cobr.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.cobr.entity.TertenCivilEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TertenCivilRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TertenCivilEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelterten(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("cobr:textures/terten_desert.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.1.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelterten extends EntityModel<Entity> {
		private final ModelRenderer all;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftArm;
		private final ModelRenderer leftItem;
		private final ModelRenderer RightArm;
		private final ModelRenderer head;
		private final ModelRenderer hat;
		private final ModelRenderer waist;
		private final ModelRenderer Body;
		public Modelterten() {
			textureWidth = 64;
			textureHeight = 64;
			all = new ModelRenderer(this);
			all.setRotationPoint(0.0F, 24.0F, 0.0F);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(2.0F, -12.0F, 0.0F);
			all.addChild(LeftLeg);
			LeftLeg.setTextureOffset(24, 16).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 17.0F, 2.0F, 0.0F, true);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-2.0F, -12.0F, 0.0F);
			all.addChild(RightLeg);
			RightLeg.setTextureOffset(24, 16).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(5.0F, -29.0F, 0.0F);
			all.addChild(LeftArm);
			LeftArm.setTextureOffset(32, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, true);
			leftItem = new ModelRenderer(this);
			leftItem.setRotationPoint(1.0F, 7.0F, 1.0F);
			LeftArm.addChild(leftItem);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-5.0F, -29.0F, 0.0F);
			all.addChild(RightArm);
			RightArm.setTextureOffset(32, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -31.0F, 0.0F);
			all.addChild(head);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			hat = new ModelRenderer(this);
			hat.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(hat);
			waist = new ModelRenderer(this);
			waist.setRotationPoint(0.0F, -12.0F, 0.0F);
			all.addChild(waist);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, -12.0F, 0.0F);
			waist.addChild(Body);
			Body.setTextureOffset(0, 16).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 14.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			all.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}

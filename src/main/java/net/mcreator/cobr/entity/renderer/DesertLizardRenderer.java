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

import net.mcreator.cobr.entity.DesertLizardEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DesertLizardRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DesertLizardEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelhorncrowanlizard(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("cobr:textures/entities_desert_lizard.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.1.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelhorncrowanlizard extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer neck;
		private final ModelRenderer head;
		private final ModelRenderer jaw;
		private final ModelRenderer left_arm;
		private final ModelRenderer left_hand;
		private final ModelRenderer cube_r1;
		private final ModelRenderer right_arm;
		private final ModelRenderer right_hand;
		private final ModelRenderer cube_r3;
		private final ModelRenderer right_leg;
		private final ModelRenderer right_foot;
		private final ModelRenderer cube_r4;
		private final ModelRenderer left_leg;
		private final ModelRenderer left_foot;
		private final ModelRenderer cube_r2;
		private final ModelRenderer tail1;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer tail2;
		public Modelhorncrowanlizard() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 25.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -4.0F, 6.0F, 5.0F, 13.0F, 0.0F, false);
			body.setTextureOffset(0, 48).addBox(-2.0F, -11.0F, -4.0F, 0.0F, 3.0F, 13.0F, 0.0F, false);
			body.setTextureOffset(0, 48).addBox(2.0F, -11.0F, -4.0F, 0.0F, 3.0F, 13.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, -8.5F, 2.5F);
			body.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, 0.5236F);
			cube_r5.setTextureOffset(0, 48).addBox(3.0F, -3.5F, -6.5F, 0.0F, 3.0F, 13.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-2.0F, -8.5F, 2.5F);
			body.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7418F);
			cube_r6.setTextureOffset(0, 48).addBox(-1.0F, -3.5F, -6.5F, 0.0F, 3.0F, 13.0F, 0.0F, false);
			neck = new ModelRenderer(this);
			neck.setRotationPoint(0.0F, -6.0F, -4.0F);
			body.addChild(neck);
			neck.setTextureOffset(20, 22).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
			neck.setTextureOffset(0, 55).addBox(2.0F, -5.0F, -6.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);
			neck.setTextureOffset(0, 55).addBox(-2.0F, -5.0F, -6.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -1.0F, -6.0F);
			neck.addChild(head);
			head.setTextureOffset(0, 18).addBox(-3.0F, -2.0F, -7.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);
			head.setTextureOffset(25, 0).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(3.1F, -4.0F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-3.1F, -4.0F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			jaw = new ModelRenderer(this);
			jaw.setRotationPoint(0.0F, 1.0F, -1.0F);
			head.addChild(jaw);
			jaw.setTextureOffset(0, 28).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(2.0F, 1.0F, -4.0F);
			neck.addChild(left_arm);
			setRotationAngle(left_arm, 0.0F, 0.0F, 0.7418F);
			left_arm.setTextureOffset(25, 7).addBox(0.0F, -1.0F, -2.0F, 5.0F, 2.0F, 3.0F, 0.0F, false);
			left_hand = new ModelRenderer(this);
			left_hand.setRotationPoint(4.7627F, 0.1756F, 0.0F);
			left_arm.addChild(left_hand);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(1.0F, 0.0F, -1.0F);
			left_hand.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -0.6109F, -0.7418F);
			cube_r1.setTextureOffset(16, 32).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-4.0F, 1.0F, -4.0F);
			neck.addChild(right_arm);
			setRotationAngle(right_arm, 0.0F, 0.0F, -0.7418F);
			right_arm.setTextureOffset(25, 7).addBox(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 3.0F, 0.0F, true);
			right_hand = new ModelRenderer(this);
			right_hand.setRotationPoint(-4.2373F, 0.1756F, 0.0F);
			right_arm.addChild(right_hand);
			setRotationAngle(right_hand, 0.0F, 0.0F, 1.4835F);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(1.0F, 0.0F, -1.0F);
			right_hand.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.349F, -0.7418F);
			cube_r3.setTextureOffset(16, 32).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, true);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-4.0F, 1.0F, 7.0F);
			neck.addChild(right_leg);
			setRotationAngle(right_leg, 0.0F, 0.0F, -0.7418F);
			right_leg.setTextureOffset(25, 7).addBox(-4.0F, 0.0F, -2.0F, 6.0F, 2.0F, 3.0F, 0.0F, true);
			right_foot = new ModelRenderer(this);
			right_foot.setRotationPoint(-4.2373F, 0.1756F, 0.0F);
			right_leg.addChild(right_foot);
			setRotationAngle(right_foot, 0.0F, 0.0F, 1.4835F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(1.0F, 0.0F, -1.0F);
			right_foot.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.349F, -0.7418F);
			cube_r4.setTextureOffset(16, 32).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, true);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.0F, -5.0F, 3.0F);
			body.addChild(left_leg);
			setRotationAngle(left_leg, 0.0F, 0.0F, 0.7418F);
			left_leg.setTextureOffset(25, 7).addBox(-1.0F, -1.0F, -2.0F, 7.0F, 2.0F, 3.0F, 0.0F, false);
			left_foot = new ModelRenderer(this);
			left_foot.setRotationPoint(4.7627F, 0.1756F, 0.0F);
			left_leg.addChild(left_foot);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(1.0F, 0.0F, -1.0F);
			left_foot.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, -0.6109F, -0.7418F);
			cube_r2.setTextureOffset(16, 32).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
			tail1 = new ModelRenderer(this);
			tail1.setRotationPoint(0.0F, -7.0F, 9.0F);
			body.addChild(tail1);
			tail1.setTextureOffset(38, 9).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 9.0F, 0.0F, false);
			tail1.setTextureOffset(17, 52).addBox(-2.0F, -4.0F, 0.0F, 0.0F, 3.0F, 9.0F, 0.0F, false);
			tail1.setTextureOffset(17, 52).addBox(2.0F, -4.0F, 0.0F, 0.0F, 3.0F, 9.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-2.0F, -1.5F, 6.5F);
			tail1.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 0.0F, -0.7418F);
			cube_r7.setTextureOffset(17, 52).addBox(-1.0F, -1.5F, -6.5F, 0.0F, 3.0F, 9.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, -1.5F, 6.5F);
			tail1.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.0F, 0.5236F);
			cube_r8.setTextureOffset(17, 52).addBox(2.5F, -1.75F, -6.5F, 0.0F, 3.0F, 9.0F, 0.0F, false);
			tail2 = new ModelRenderer(this);
			tail2.setRotationPoint(0.0F, 0.0F, 9.0F);
			tail1.addChild(tail2);
			tail2.setTextureOffset(42, 21).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.right_arm.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left_arm.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}

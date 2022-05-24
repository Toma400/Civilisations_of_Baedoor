package toma400.cobr.render.entities.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;

public class TertenMercenaryType <T extends CreatureEntity> extends EntityModel<T> {
		//extends EntityModel<Entity> {
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftItem;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightItem;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer chest;

	public TertenMercenaryType() {
		texWidth = 64;
		texHeight = 64;

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(2.0F, 12.0F, 0.0F);
		leftLeg.texOffs(24, 16).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 17.0F, 2.0F, 0.0F, true);

		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(-2.0F, 12.0F, 0.0F);
		rightLeg.texOffs(24, 16).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(5.0F, -5.0F, 0.0F);
		leftArm.texOffs(32, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, true);

		leftItem = new ModelRenderer(this);
		leftItem.setPos(1.0F, 7.0F, 1.0F);
		leftArm.addChild(leftItem);
		

		rightArm = new ModelRenderer(this);
		rightArm.setPos(-5.0F, -5.0F, 0.0F);
		rightArm.texOffs(32, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

		rightItem = new ModelRenderer(this);
		rightItem.setPos(-1.0F, 7.0F, 1.0F);
		rightArm.addChild(rightItem);
		

		head = new ModelRenderer(this);
		head.setPos(0.0F, -7.0F, 0.0F);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		

		chest = new ModelRenderer(this);
		chest.setPos(0.0F, 12.0F, 0.0F);
		chest.texOffs(0, 16).addBox(-4.0F, -19.0F, -2.0F, 8.0F, 14.0F, 4.0F, 0.0F, false);
	}

	//----------------------------------------------------------
	//  ANIMATIONS
	//----------------------------------------------------------
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		ItemStack itemstack = entity.getMainHandItem();
		if (entity.isAggressive() && (itemstack.isEmpty() || itemstack.getItem() != Items.BOW)) {
			float f = MathHelper.sin(this.attackTime * (float)Math.PI);
			float f1 = MathHelper.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float)Math.PI);
			this.rightArm.zRot = 0.0F;
			this.leftArm.zRot = 0.0F;
			this.rightArm.yRot = -(0.1F - f * 0.6F);
			this.leftArm.yRot = 0.1F - f * 0.6F;
			this.rightArm.xRot = (-(float)Math.PI / 2F);
			this.leftArm.xRot = (-(float)Math.PI / 2F);
			this.rightArm.xRot -= f * 1.2F - f1 * 0.4F;
			this.leftArm.xRot -= f * 1.2F - f1 * 0.4F;
			ModelHelper.bobArms(this.rightArm, this.leftArm, ageInTicks);
		}
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		chest.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
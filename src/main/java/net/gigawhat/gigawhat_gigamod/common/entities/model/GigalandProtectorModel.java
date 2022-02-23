// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.gigawhat.gigawhat_gigamod.common.entities.custom.GigalandProtectorEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 4.1.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

@OnlyIn(Dist.CLIENT)
public class GigalandProtectorModel <T extends GigalandProtectorEntity> extends EntityModel<T>
{
	private final ModelRenderer body;
	private final ModelRenderer hammer;
	private final ModelRenderer scanner;

	public GigalandProtectorModel() 
	{
		texWidth = 64;
		texHeight = 64;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 14.0F, 0.0F);
		body.texOffs(0, 0).addBox(-5.0F, 9.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		body.texOffs(0, 8).addBox(-5.0F, 9.0F, 3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		body.texOffs(17, 7).addBox(3.0F, 9.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		body.texOffs(16, 0).addBox(3.0F, 9.0F, 3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		body.texOffs(41, 8).addBox(-5.0F, -24.0F, -2.0F, 1.0F, 25.0F, 4.0F, 0.0F, false);
		body.texOffs(54, 13).addBox(4.0F, -24.0F, -2.0F, 1.0F, 25.0F, 4.0F, 0.0F, false);
		body.texOffs(0, 28).addBox(-6.0F, 1.0F, -6.0F, 12.0F, 6.0F, 12.0F, 0.0F, false);
		body.texOffs(0, 48).addBox(-7.0F, 7.0F, -7.0F, 14.0F, 2.0F, 14.0F, 0.0F, false);

		hammer = new ModelRenderer(this);
		hammer.setPos(0.0F, -22.0F, 0.0F);
		body.addChild(hammer);
		hammer.texOffs(30, 1).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		hammer.texOffs(8, 13).addBox(-2.0F, 8.0F, -5.0F, 4.0F, 3.0F, 10.0F, 0.0F, false);
		hammer.texOffs(44, 0).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		scanner = new ModelRenderer(this);
		scanner.setPos(0.0F, 1.0F, 0.0F);
		body.addChild(scanner);
		scanner.texOffs(0, 14).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.scanner.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void prepareMobModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) 
	{
   		int i = p_212843_1_.getAttackAnimationTick();

		if (i > 0) 
		{
	  		this.hammer.xRot = + (-1.0F + 1.5F * MathHelper.triangleWave((float) i - p_212843_4_, 15.0F));
   		}

		else
		{
			this.hammer.xRot = 0;
		}
    }
}

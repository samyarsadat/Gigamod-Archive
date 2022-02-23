// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.entities.render;

import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.gigawhat.gigawhat_gigamod.common.entities.custom.GigalandProtectorEntity;
import net.gigawhat.gigawhat_gigamod.common.entities.model.GigalandProtectorModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GigalandProtectorRenderer extends MobRenderer<GigalandProtectorEntity, GigalandProtectorModel<GigalandProtectorEntity>>
{
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Gigamod.MOD_ID, "textures/models/entities/gigaland_protector.png");

    public GigalandProtectorRenderer(EntityRendererManager renderManagerIn) 
    {
        super(renderManagerIn, new GigalandProtectorModel<>(), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(GigalandProtectorEntity entity) 
    {
        return TEXTURE;
    }
}
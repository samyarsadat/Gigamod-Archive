/*
 * Gigawhat Essentials, A mod based on the EssentialsX plugin suite.
 * Copyright (C) 2021-2022 Gigawhat Programming Team.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * 
 * For further inquiries you can contact the Gigawhat Programming Team via e-mail:
 * contact.gpt@gigawhat.net
 */

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
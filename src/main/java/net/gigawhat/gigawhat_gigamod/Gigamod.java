/*
 * Gigamod, A Minecraft mod by Gigawhat.
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

package net.gigawhat.gigawhat_gigamod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.gigawhat.gigawhat_gigamod.common.entities.EntityTypeInit;
import net.gigawhat.gigawhat_gigamod.common.entities.custom.GigalandProtectorEntity;
import net.gigawhat.gigawhat_gigamod.common.entities.render.GigalandProtectorRenderer;
import net.gigawhat.gigawhat_gigamod.core.init.BlockInit;
import net.gigawhat.gigawhat_gigamod.core.init.ItemInit;
import net.gigawhat.gigawhat_gigamod.core.util.SoundEventsInit;
import net.gigawhat.gigawhat_gigamod.world.carver.CarverInit;
import net.gigawhat.gigawhat_gigamod.world.gen.OreGeneration;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Gigamod.MOD_ID)
public class Gigamod 
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gigawhat_gigamod";

    public Gigamod() 
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        EntityTypeInit.register(bus);
        LOGGER.info("Registered entities");

        ItemInit.register(bus);
        LOGGER.info("Registered items");
    
        BlockInit.register(bus);
        LOGGER.info("Registered blocks");

        CarverInit.register(bus);
        LOGGER.info("Registered carvers");

        SoundEventsInit.register(bus);
        LOGGER.info("Registered sounds");

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        bus.addListener(this::doClientStuff);
        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) 
    {
        DeferredWorkQueue.runLater(() -> 
        {
            GlobalEntityTypeAttributes.put(EntityTypeInit.GIGALAND_PROTECTOR.get(), GigalandProtectorEntity.createAttributes().build());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        event.enqueueWork(() -> 
        {
            RenderTypeLookup.setRenderLayer(BlockInit.BLOCK_MODEL_TEST.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockInit.GIGALAND_TELEPORTER_BLOCK.get(), RenderType.cutout());
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.GIGALAND_PROTECTOR.get(), GigalandProtectorRenderer::new);
    }
}
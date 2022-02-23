// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.entities;

import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.gigawhat.gigawhat_gigamod.common.entities.custom.GigalandProtectorEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit 
{
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Gigamod.MOD_ID);

    public static final RegistryObject<EntityType<GigalandProtectorEntity>> GIGALAND_PROTECTOR = ENTITY_TYPES.register("gigaland_protector", () -> EntityType.Builder.of(GigalandProtectorEntity::new, EntityClassification.MONSTER).sized(0.8f, 2.1f).build(new ResourceLocation(Gigamod.MOD_ID, "gigaland_protector").toString()));

    public static void register(IEventBus bus)
    {
        ENTITY_TYPES.register(bus);
    }
}
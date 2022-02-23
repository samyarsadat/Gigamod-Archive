// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.world.carver;

import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CarverInit
{
    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, Gigamod.MOD_ID);

    public static final RegistryObject<WorldCarver<?>> GIGALAND_CAVE = CARVERS.register("gigaland_cave", () -> new GigalandCaveCarver(ProbabilityConfig.CODEC, 256));
    public static final RegistryObject<WorldCarver<?>> GIGALAND_CANYON = CARVERS.register("gigaland_canyon", () -> new GigalandCanyonCarver(ProbabilityConfig.CODEC));

    public static void register(IEventBus bus)
    {
        CARVERS.register(bus);
    }
}
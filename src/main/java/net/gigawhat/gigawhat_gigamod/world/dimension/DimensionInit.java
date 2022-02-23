// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.world.dimension;

import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DimensionInit 
{
    public static RegistryKey<World> GIGALAND = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Gigamod.MOD_ID, "gigaland"));
}
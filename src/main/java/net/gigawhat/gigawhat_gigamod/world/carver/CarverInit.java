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
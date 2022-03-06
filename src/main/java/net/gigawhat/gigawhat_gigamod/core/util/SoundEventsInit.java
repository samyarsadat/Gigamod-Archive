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

package net.gigawhat.gigawhat_gigamod.core.util;

import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundEventsInit 
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Gigamod.MOD_ID);

    // ------------------------- Mob Sounds ------------------------- :

    // public static final RegistryObject<SoundEvent> GIGALAND_PROTECTOR_DEATH = registerSoundEvent("gigaland_protector_death");
    // public static final RegistryObject<SoundEvent> GIGALAND_PROTECTOR_REPAIR = registerSoundEvent("gigaland_protector_repair");

    // ------------------------- Music ------------------------- :

    public static final RegistryObject<SoundEvent> DOCTOR_WHO_THEME_2005 = registerSoundEvent("doctor_who_theme_2005");
    public static final RegistryObject<SoundEvent> I_AM_THE_DOCTOR = registerSoundEvent("i_am_the_doctor");
    public static final RegistryObject<SoundEvent> THE_DARK_AND_ENDLESS_DALEK_NIGHT = registerSoundEvent("the_dark_and_endless_dalek_night");
    public static final RegistryObject<SoundEvent> IMPERIAL_MARCH = registerSoundEvent("imperial_march");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name)
    {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Gigamod.MOD_ID, name)));
    }

    public static void register(IEventBus bus)
    {
        SOUND_EVENTS.register(bus);
    }
}
// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.core.init;

import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.gigawhat.gigawhat_gigamod.common.entities.EntityTypeInit;
import net.gigawhat.gigawhat_gigamod.core.itemgroup.GigamodGroup;
import net.gigawhat.gigawhat_gigamod.core.util.SoundEventsInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit 
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Gigamod.MOD_ID);

    public static final RegistryObject<Item> ITEM_TEST = ITEMS.register("item_test", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    // ------------------------- Spawn Eggs ------------------------- :

    public static final RegistryObject<ForgeSpawnEggItem> GIGALAND_PROTECTOR_SPAWN_EGG = ITEMS.register("gigaland_protector_spawn_egg", () -> new ForgeSpawnEggItem(EntityTypeInit.GIGALAND_PROTECTOR, 1710618, 16776960, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP).rarity(Rarity.EPIC)));

    // ------------------------- Music Discs ------------------------- :

    public static final RegistryObject<Item> SERVER_WIDE_DOCTOR_WHO_MUSIC_DISC = ITEMS.register("server_wide_doctor_who_music_disc", () -> new MusicDiscItem(1, () -> SoundEventsInit.SERVER_WIDE_DOCTOR_WHO.get(), new Item.Properties().stacksTo(1).tab(GigamodGroup.GIGAMOD_GROUP).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DOCTOR_WHO_THEME_2005_MUSIC_DISC = ITEMS.register("doctor_who_theme_2005_music_disc", () -> new MusicDiscItem(9, () -> SoundEventsInit.DOCTOR_WHO_THEME_2005.get(), new Item.Properties().stacksTo(1).tab(GigamodGroup.GIGAMOD_GROUP).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> I_AM_THE_DOCTOR_MUSIC_DISC = ITEMS.register("i_am_the_doctor_music_disc", () -> new MusicDiscItem(11, () -> SoundEventsInit.I_AM_THE_DOCTOR.get(), new Item.Properties().stacksTo(1).tab(GigamodGroup.GIGAMOD_GROUP).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> THE_DARK_AND_ENDLESS_DALEK_NIGHT_MUSIC_DISC = ITEMS.register("the_dark_and_endless_dalek_night_music_disc", () -> new MusicDiscItem(10, () -> SoundEventsInit.THE_DARK_AND_ENDLESS_DALEK_NIGHT.get(), new Item.Properties().stacksTo(1).tab(GigamodGroup.GIGAMOD_GROUP).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GIGAWHAT_THEME_MUSIC_DISC = ITEMS.register("gigawhat_theme_music_disc", () -> new MusicDiscItem(2, () -> SoundEventsInit.GIGAWHAT_THEME.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> IMPERIAL_MARCH_MUSIC_DISC = ITEMS.register("imperial_march_music_disc", () -> new MusicDiscItem(15, () -> SoundEventsInit.IMPERIAL_MARCH.get(), new Item.Properties().stacksTo(1).tab(GigamodGroup.GIGAMOD_GROUP).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> EREN_SAHIN_ERONAT_THEME_MUSIC_DISC = ITEMS.register("eren_sahin_eronat_theme_music_disc", () -> new MusicDiscItem(14, () -> SoundEventsInit.EREN_SAHIN_ERONAT_THEME.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    // ------------------------- Tools & Combat ------------------------- :

    // Gigalium :
    public static final RegistryObject<Item> GIGALIUM_PICKAXE = ITEMS.register("gigalium_pickaxe", () -> new PickaxeItem(ItemTierInit.GIGALIUM, 1, -2.8f, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));
    public static final RegistryObject<Item> GIGALIUM_AXE = ITEMS.register("gigalium_axe", () -> new AxeItem(ItemTierInit.GIGALIUM, 6.0f, -3.0f, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));
    public static final RegistryObject<Item> GIGALIUM_HOE = ITEMS.register("gigalium_hoe", () -> new HoeItem(ItemTierInit.GIGALIUM, -3, 0.0f, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));
    public static final RegistryObject<Item> GIGALIUM_SHOVEL = ITEMS.register("gigalium_shovel", () -> new ShovelItem(ItemTierInit.GIGALIUM, 1.5f, -3.0f, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));
    public static final RegistryObject<Item> GIGALIUM_SWORD = ITEMS.register("gigalium_sword", () -> new SwordItem(ItemTierInit.GIGALIUM, 3, -2.4f, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));
    public static final RegistryObject<Item> GIGALIUM_HELMET = ITEMS.register("gigalium_helmet", () -> new ArmorItem(ArmorMaterialInit.GIGALIUM, EquipmentSlotType.HEAD, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));
    public static final RegistryObject<Item> GIGALIUM_CHESTPLATE = ITEMS.register("gigalium_chestplate", () -> new ArmorItem(ArmorMaterialInit.GIGALIUM, EquipmentSlotType.CHEST, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));
    public static final RegistryObject<Item> GIGALIUM_LEGGINGS = ITEMS.register("gigalium_leggings", () -> new ArmorItem(ArmorMaterialInit.GIGALIUM, EquipmentSlotType.LEGS, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));
    public static final RegistryObject<Item> GIGALIUM_BOOTS = ITEMS.register("gigalium_boots", () -> new ArmorItem(ArmorMaterialInit.GIGALIUM, EquipmentSlotType.FEET, new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));

    // ------------------------- Ingots ------------------------- :

    public static final RegistryObject<Item> GIGALIUM_INGOT = ITEMS.register("gigalium_ingot", () -> new Item(new Item.Properties().tab(GigamodGroup.GIGAMOD_GROUP)));

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
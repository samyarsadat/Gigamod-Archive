// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.core.init;

import java.util.function.Supplier;

import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.gigawhat.gigawhat_gigamod.common.blocks.Block_Model_Test_Properties;
import net.gigawhat.gigawhat_gigamod.common.blocks.Block_Test;
import net.gigawhat.gigawhat_gigamod.common.blocks.Gigaland_Teleporter_Block;
import net.gigawhat.gigawhat_gigamod.common.blocks.Gigalium_Block;
import net.gigawhat.gigawhat_gigamod.common.blocks.Gigalium_Gigaland_Ore;
import net.gigawhat.gigawhat_gigamod.common.blocks.Gigalium_Nether_Ore;
import net.gigawhat.gigawhat_gigamod.common.blocks.Gigalium_Ore;
import net.gigawhat.gigawhat_gigamod.common.blocks.Gigastone;
import net.gigawhat.gigawhat_gigamod.core.itemgroup.GigamodGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit 
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Gigamod.MOD_ID);

    // Test block :
    public static final RegistryObject<Block> BLOCK_TEST = registerBlock("block_test", Block_Test::new, null, Rarity.EPIC);
    public static final RegistryObject<Block> BLOCK_MODEL_TEST = registerBlock("block_model_test", Block_Model_Test_Properties::new, null, Rarity.EPIC);

    // Gigalium :
    public static final RegistryObject<Block> GIGALIUM_BLOCK = registerBlock("gigalium_block", Gigalium_Block::new, GigamodGroup.GIGAMOD_GROUP, null);

    // Ores :
    public static final RegistryObject<Block> GIGALIUM_ORE = registerBlock("gigalium_ore", Gigalium_Ore::new, GigamodGroup.GIGAMOD_GROUP, null);
    public static final RegistryObject<Block> GIGALIUM_NETHER_ORE = registerBlock("gigalium_nether_ore", Gigalium_Nether_Ore::new, GigamodGroup.GIGAMOD_GROUP, null);
    public static final RegistryObject<Block> GIGALIUM_GIGALAND_ORE = registerBlock("gigalium_gigaland_ore", Gigalium_Gigaland_Ore::new, GigamodGroup.GIGAMOD_GROUP, null);

    // Gigaland :
    public static final RegistryObject<Block> GIGASTONE = registerBlock("gigastone", Gigastone::new, GigamodGroup.GIGAMOD_GROUP, null);
    public static final RegistryObject<Block> GIGALAND_TELEPORTER_BLOCK = registerBlock("gigaland_teleporter_block", Gigaland_Teleporter_Block::new, GigamodGroup.GIGAMOD_GROUP, null);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, ItemGroup itemgroup, Rarity rarity)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemgroup, rarity);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, ItemGroup itemgroup, Rarity rarity)
    {
        if (!(itemgroup == null))
        {
            ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemgroup)));
        }

        else if (!(rarity == null))
        {
            ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
        }

        if (!(rarity == null) && !(itemgroup == null))
        {
            ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity).tab(itemgroup)));
        }

        else if (rarity == null && itemgroup == null)
        {
            ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
    }

    public static void register(IEventBus bus)
    {
        BLOCKS.register(bus);
    }
}
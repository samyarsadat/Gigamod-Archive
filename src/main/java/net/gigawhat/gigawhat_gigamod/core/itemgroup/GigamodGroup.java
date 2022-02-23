// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.core.itemgroup;

import net.gigawhat.gigawhat_gigamod.core.init.BlockInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GigamodGroup
{
    public static final ItemGroup GIGAMOD_GROUP = new ItemGroup("gigamodtab") 
    {
        @Override
        public ItemStack makeIcon() 
        {
            return new ItemStack(BlockInit.BLOCK_TEST.get());
        }
    };
}
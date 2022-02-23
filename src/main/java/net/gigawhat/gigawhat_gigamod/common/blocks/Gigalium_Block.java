// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Gigalium_Block extends Block 
{
    public Gigalium_Block()
    {
        super(AbstractBlock.Properties.of(Material.METAL)
        
            .strength(5.0f, 8.0f)
            .sound(SoundType.METAL)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
        
        );
    }
}

// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Gigastone extends Block 
{
    public Gigastone()
    {
        super(AbstractBlock.Properties.of(Material.STONE)
        
            .strength(2.0f, 4.0f)
            .sound(SoundType.STONE)
            .harvestLevel(1)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
        
        );
    }
}

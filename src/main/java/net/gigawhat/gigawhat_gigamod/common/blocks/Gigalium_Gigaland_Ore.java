// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import java.lang.Math;

public class Gigalium_Gigaland_Ore extends OreBlock 
{
    public Gigalium_Gigaland_Ore()
    {
        super(AbstractBlock.Properties.of(Material.DECORATION)
        
            .strength(3.0f, 4.0f)
            .sound(SoundType.STONE)
            .harvestLevel(3)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
        
        );
    }
    
    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) 
    {
        int min_xp = 1; 
        int max_xp = 3;

        return (int) ((Math.random() * (max_xp - min_xp)) + min_xp);
    }
}

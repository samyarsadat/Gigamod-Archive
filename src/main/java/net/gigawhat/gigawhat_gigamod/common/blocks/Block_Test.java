// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class Block_Test extends Block 
{
    public Block_Test()
    {
        super(AbstractBlock.Properties.of(Material.METAL)
        
            .strength(4.0f, 4.0f)
            .sound(SoundType.METAL)
            .harvestLevel(4)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
            .jumpFactor(2)
        
        );
    }
    
    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) 
    {
        return 10;
    }
}

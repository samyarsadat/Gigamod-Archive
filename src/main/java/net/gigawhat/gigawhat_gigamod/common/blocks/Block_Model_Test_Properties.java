// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.blocks;

import java.util.stream.Stream;

import net.gigawhat.gigawhat_gigamod.common.blocks.custom_blocks.HorizontalBaseBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class Block_Model_Test_Properties extends HorizontalBaseBlock
{
    private static final VoxelShape SHAPE = Stream.of(
        Block.box(1, 1, 1, 15, 2, 15),
        Block.box(0, 0, 0, 16, 1, 16),
        Block.box(5, 2, 5, 11, 4, 11),
        Block.box(5, 10, 5, 11, 16, 11),
        Block.box(6, 4, 6, 10, 10, 10)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
    {
        return SHAPE;
    }

    public Block_Model_Test_Properties()
    {
        super(AbstractBlock.Properties.of(Material.METAL)
        
            .strength(5.0f, 8.0f)
            .sound(SoundType.METAL)
            .harvestLevel(2)
            .harvestTool(ToolType.PICKAXE)
            .requiresCorrectToolForDrops()
            .noOcclusion()
        
        );
    }
}

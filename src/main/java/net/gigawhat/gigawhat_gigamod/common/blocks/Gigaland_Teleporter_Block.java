// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.common.blocks;

import java.util.stream.Stream;

import net.gigawhat.gigawhat_gigamod.common.blocks.custom_blocks.HorizontalBaseBlock;
import net.gigawhat.gigawhat_gigamod.world.dimension.DimensionInit;
import net.gigawhat.gigawhat_gigamod.world.dimension.GigalandTeleporter;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class Gigaland_Teleporter_Block extends HorizontalBaseBlock
{
    private static final VoxelShape SHAPE = Stream.of(
        Block.box(0, 0, 0, 16, 1, 16),
        Block.box(2, 1, 2, 14, 2, 14),
        Block.box(6, 2, 6, 10, 3, 10)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
    {
        return SHAPE;
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) 
    {
        if (!worldIn.isClientSide()) 
        {
            if (!player.isCrouching()) 
            {
                MinecraftServer server = worldIn.getServer();

                if (server != null) 
                {
                    if (worldIn.dimension() == DimensionInit.GIGALAND) 
                    {
                        ServerWorld overWorld = server.getLevel(World.OVERWORLD);
                        if (overWorld != null) 
                        {
                            player.changeDimension(overWorld, new GigalandTeleporter(pos, false));
                        }
                    } 
                    
                    else 
                    {
                        ServerWorld Gigaland = server.getLevel(DimensionInit.GIGALAND);
                        if (Gigaland != null) 
                        {
                            player.changeDimension(Gigaland, new GigalandTeleporter(pos, true));
                        }
                    }

                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    public Gigaland_Teleporter_Block()
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

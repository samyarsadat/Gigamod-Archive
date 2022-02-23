// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package net.gigawhat.gigawhat_gigamod.world.gen;

import net.gigawhat.gigawhat_gigamod.Gigamod;
import net.gigawhat.gigawhat_gigamod.core.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration 
{
    public static void generateOres(final BiomeLoadingEvent event)
    {
        if(!(event.getCategory().equals(Biome.Category.THEEND)))
        {
            // Nether :
            if(event.getCategory().equals(Biome.Category.NETHER))
            {
                generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.GIGALIUM_NETHER_ORE.get().defaultBlockState(), 6, 25, 50, 2);
                generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.GIGALIUM_NETHER_ORE.get().defaultBlockState(), 4, 51, 120, 2);
            }

            // Overworld :
            if(event.getCategory().equals(Biome.Category.SWAMP) || event.getCategory().equals(Biome.Category.TAIGA))
            {
                generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.GIGALIUM_ORE.get().defaultBlockState(), 5, 12, 15, 2);
                generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.GIGALIUM_ORE.get().defaultBlockState(), 4, 16, 20, 2);
            }

            if(!(event.getCategory().equals(Biome.Category.SWAMP) && event.getCategory().equals(Biome.Category.TAIGA)))
            {
                generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.GIGALIUM_ORE.get().defaultBlockState(), 4, 10, 13, 1);
                generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.GIGALIUM_ORE.get().defaultBlockState(), 3, 14, 18, 1);
            }

            // Gigaland :
            if(event.getName().toString().equals("gigawhat_gigamod:gigaland_main") || event.getName().toString().equals("gigawhat_gigamod:gigaland_plains") || event.getName().toString().equals("gigawhat_gigamod:gigaland_warm_ocean") || event.getName().toString().equals("gigawhat_gigamod:gigaland_cold_ocean"))
            {
                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), BlockInit.GIGALIUM_GIGALAND_ORE.get().defaultBlockState(), 4, 89, 230, 3);
                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), BlockInit.GIGALIUM_GIGALAND_ORE.get().defaultBlockState(), 4, 56, 88, 3);
                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), BlockInit.GIGALIUM_GIGALAND_ORE.get().defaultBlockState(), 5, 10, 55, 4);

                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), Blocks.IRON_ORE.defaultBlockState(), 4, 60, 125, 4);
                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), Blocks.IRON_ORE.defaultBlockState(), 4, 30, 59, 5);
                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), Blocks.IRON_ORE.defaultBlockState(), 5, 2, 29, 5);

                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), Blocks.REDSTONE_ORE.defaultBlockState(), 4, 19, 38, 3);
                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), Blocks.REDSTONE_ORE.defaultBlockState(), 5, 2, 18, 4);

                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), Blocks.DIAMOND_ORE.defaultBlockState(), 3, 12, 25, 2);
                generateOreCustomFiller(event.getGeneration(), BlockInit.GIGASTONE.get(), Blocks.DIAMOND_ORE.defaultBlockState(), 5, 2, 11, 2);
            }
        }
    }

    private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount)
    {
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight))).squared().count(amount));
    }

    private static void generateOreCustomFiller(BiomeGenerationSettingsBuilder settings, Block filler, BlockState state, int veinSize, int minHeight, int maxHeight, int amount)
    {
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(new OreFeatureConfig(new BlockMatchRuleTest(filler), state, veinSize)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight))).squared().count(amount));
    }
}
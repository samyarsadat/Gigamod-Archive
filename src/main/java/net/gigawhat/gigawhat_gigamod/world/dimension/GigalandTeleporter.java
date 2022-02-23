/*
 * Gigamod, A Minecraft mod by Gigawhat.
 * Copyright (C) 2021-2022 Gigawhat Programming Team.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * 
 * For further inquiries you can contact the Gigawhat Programming Team via e-mail:
 * contact.gpt@gigawhat.net
 */

package net.gigawhat.gigawhat_gigamod.world.dimension;

import java.util.function.Function;

import net.gigawhat.gigawhat_gigamod.common.blocks.Gigaland_Teleporter_Block;
import net.gigawhat.gigawhat_gigamod.core.init.BlockInit;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

public class GigalandTeleporter implements ITeleporter 
{
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public GigalandTeleporter(BlockPos pos, boolean insideDim) 
    {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destinationWorld, float yaw, Function<Boolean, Entity> repositionEntity) 
    {
        entity = repositionEntity.apply(false);
        double y = 255;

        boolean doSetBlock = true;

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        if ((destinationWorld.getBlockState(destinationPos).getMaterial() == Material.AIR) && !(destinationWorld.getBlockState(destinationPos).getBlock() == BlockInit.GIGALAND_TELEPORTER_BLOCK.get()))
        {
            int tries = 0;
            while (!(destinationWorld.getBlockState(destinationPos).getBlock() == BlockInit.GIGALAND_TELEPORTER_BLOCK.get()) && tries < 255)
            {
                destinationPos = destinationPos.below(1);
                tries++;
            }

            if (!(destinationWorld.getBlockState(destinationPos).getBlock() == BlockInit.GIGALAND_TELEPORTER_BLOCK.get()))
            {
                destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

                tries = 0;
                while ((destinationWorld.getBlockState(destinationPos).getMaterial() == Material.AIR) && tries < 255)
                {
                    destinationPos = destinationPos.below(1);
                    tries++;
                }

                doSetBlock = true;
            }

            else
            {
                doSetBlock = false;
            }
        }

        if (insideDimension || !insideDimension) 
        {
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(4).west(8), destinationPos.above(4).east(8))) 
            {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof Gigaland_Teleporter_Block) 
                {
                    doSetBlock = false;
                    break;
                }
            }

            if (doSetBlock) 
            {
                if (destinationWorld.getBlockState(destinationPos).getMaterial() == Material.WATER || destinationWorld.getBlockState(destinationPos).getMaterial() == Material.LAVA)
                {
                    destinationWorld.setBlockAndUpdate(destinationPos, BlockInit.GIGASTONE.get().defaultBlockState());
                    destinationWorld.setBlockAndUpdate(destinationPos.east(), BlockInit.GIGASTONE.get().defaultBlockState());
                    destinationWorld.setBlockAndUpdate(destinationPos.south(), BlockInit.GIGASTONE.get().defaultBlockState());
                    destinationWorld.setBlockAndUpdate(destinationPos.north(), BlockInit.GIGASTONE.get().defaultBlockState());
                    destinationWorld.setBlockAndUpdate(destinationPos.west(), BlockInit.GIGASTONE.get().defaultBlockState());
                    destinationWorld.setBlockAndUpdate(destinationPos.south().east(), BlockInit.GIGASTONE.get().defaultBlockState());
                    destinationWorld.setBlockAndUpdate(destinationPos.south().west(), BlockInit.GIGASTONE.get().defaultBlockState());
                    destinationWorld.setBlockAndUpdate(destinationPos.north().west(), BlockInit.GIGASTONE.get().defaultBlockState());
                    destinationWorld.setBlockAndUpdate(destinationPos.north().east(), BlockInit.GIGASTONE.get().defaultBlockState());
                }

                destinationWorld.setBlockAndUpdate(destinationPos.above(), BlockInit.GIGALAND_TELEPORTER_BLOCK.get().defaultBlockState());
            }
        }

        entity.teleportTo(destinationPos.getX(), destinationPos.getY() + 1, destinationPos.getZ());

        return entity;
    }    
}
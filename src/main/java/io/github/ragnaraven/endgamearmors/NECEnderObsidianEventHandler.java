package io.github.ragnaraven.endgamearmors;

import io.github.ragnaraven.endgamearmors.blocks.NECBlocks;
import io.github.ragnaraven.endgamearmors.particles.ParticleEffects;
import io.github.ragnaraven.endgamearmors.util.RangedInt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Andrew on 9/22/2017 at 12:37 PM.
 *
 * This class manages the spawning of EnderObsidian.
 */
@Mod.EventBusSubscriber
public class NECEnderObsidianEventHandler
{
	//public static final RangedInt CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD = new RangedInt(0, 1000,263, RangedInt.EMODES.ALWAYS);
	//public static final RangedInt CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT = new RangedInt(0, 1000,678, RangedInt.EMODES.ALWAYS);
	
	public static final RangedInt CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD = new RangedInt(0, 1000,678, RangedInt.EMODES.ALWAYS);
	public static final RangedInt CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT = new RangedInt(0, 1000,850, RangedInt.EMODES.ALWAYS);
	
	/**Handles when a water bucket is placed down over lava.**/
	@SubscribeEvent
	public static void enderObsidianSpawnWaterEventCheck(BlockEvent.NeighborNotifyEvent event)
	{
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		
		//Only in the end should any of this happen
		if (event.getWorld().provider.getDimensionType() == DimensionType.THE_END)
		{
			//Checking for the chance here because it will save some processing I.E. it wont check surrounding BLOCKS.
			if(shouldSpawnEnderObsidian())
			{
				//Only checking for lava and water events.
				if (block == Blocks.WATER || block == Blocks.FLOWING_WATER)
					trySpawnEnderObsidianWaterEvent(world, pos);
			}
		}
	}
	
	public static boolean shouldSpawnEnderObsidian ()
	{
		if((NotEnoughCombatMod.BUILDCRAFT || NotEnoughCombatMod.IC2) && CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.get() != 0)
			return NotEnoughCombatMod.RANDOM.nextInt(CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.max) < CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.get();
		
		return CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.get() != 0 && NotEnoughCombatMod.RANDOM.nextInt(CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.max) < CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.get();
	}
	
	public static void trySpawnEnderObsidianWaterEvent(World world, BlockPos pos)
	{
		if(isValidLavaSourceBlock(world, pos.down()) //Down
			|| isValidLavaSourceBlock(world, pos.north()) //North
			|| isValidLavaSourceBlock(world, pos.south()) //South
			|| isValidLavaSourceBlock(world, pos.east()) //East
			|| isValidLavaSourceBlock(world, pos.west())) //West
		{
			spawnEnderObsidian(world, pos.down());
		}
	}
	
	/*
	@Deprecated
	public static boolean trySpawnEnderObsidianLavaEvent(World world, BlockPos pos)
	{
		if(isValidWaterBlock(world, pos.up()) //Up
				|| isValidWaterBlock(world, pos.north()) //North
				|| isValidWaterBlock(world, pos.south()) //South
				|| isValidWaterBlock(world, pos.east()) //East
				|| isValidWaterBlock(world, pos.west())) //West
		{
			spawnEnderObsidian(world, pos);
			return true;
		}
		
		return false;
	}*/
	
	public static boolean isValidLavaSourceBlock (World world, BlockPos pos)
	{
		//If it is a lava source block.
		//Strangely, source BLOCKS are turned into flowing BLOCKS when there is a physics update. Therefore the LEVEL = 0 check
		//determines if the flowing block is equivalent to a source block. I imagine this means there will be some EO spawns
		//that should not have happened, but I am okay with that.
		return world.getBlockState(pos).getBlock() == Blocks.LAVA //Is lava
				|| (world.getBlockState(pos).getBlock() == Blocks.FLOWING_LAVA && world.getBlockState(pos).getValue(BlockDynamicLiquid.LEVEL) == 0); //Is lava flowing at level 0
	}
	
	/*
	@Deprecated
	public static boolean isValidWaterBlock (World world, BlockPos pos)
	{
		return world.getBlockState(pos).getBlock() == Blocks.WATER //Is water source
				|| world.getBlockState(pos).getBlock() == Blocks.FLOWING_WATER;  //Is water flowing
	}
	*/
	
	public static void spawnEnderObsidian(World world, BlockPos pos)
	{
		world.setBlockState(pos, NECBlocks.enderObsidian.getDefaultState());
		
		if(world.isRemote)
			for(int i = 0; i < 5; i++)
				ParticleEffects.spawnEnderObsidianSpawnParticles(world, pos.getX(), pos.getY(), pos.getZ());
	}
}

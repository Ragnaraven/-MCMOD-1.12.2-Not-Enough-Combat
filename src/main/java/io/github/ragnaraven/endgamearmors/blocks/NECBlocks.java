package io.github.ragnaraven.endgamearmors.blocks;

import io.github.ragnaraven.endgamearmors.NECCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;

/**
 * Created by Andrew on 7/15/2017 at 7:08 PM.
 */
public class NECBlocks
{
	public static ArrayList<Block> BLOCKS = new ArrayList<>();
	
	public static final EnderObsidian enderObsidian = new EnderObsidian("block_ender_obsidian", Material.ROCK, NECCreativeTabs.NECUniversalTab, 50f, 6000f, "pickaxe", 3);
}

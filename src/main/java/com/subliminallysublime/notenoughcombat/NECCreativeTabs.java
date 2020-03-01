package com.subliminallysublime.notenoughcombat;

import com.subliminallysublime.notenoughcombat.blocks.NECBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Andrew on 1/9/2017 at 5:15 PM.
 */
public class NECCreativeTabs
{
	public static final String NECUniversalTabName = "NECUniversalTab";
	
	public static CreativeTabs NECUniversalTab;
	
	public static void initializeTabs (Configuration config)
	{
		NECUniversalTab = new CreativeTabs(NECUniversalTabName)
		{
			@Override
			public ItemStack getTabIconItem()
			{
				return new ItemStack(Item.getItemFromBlock(NECBlocks.enderObsidian));
			}
		};
	}
}

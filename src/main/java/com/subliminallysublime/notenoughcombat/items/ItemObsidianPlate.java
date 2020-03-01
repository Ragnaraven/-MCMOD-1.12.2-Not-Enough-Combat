package com.subliminallysublime.notenoughcombat.items;

import com.subliminallysublime.notenoughcombat.NECCreativeTabs;

/**
 * Created by Andrew on 7/15/2017 at 4:31 AM.
 */
public class ItemObsidianPlate extends ItemBase
{
	public ItemObsidianPlate(String name)
	{
		super(name, NECCreativeTabs.NECUniversalTab);
	}
	
	/*public void registerRecipe()
	{
		RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
				"oo ",
				"oo ",
				"   ",
				'o', Blocks.OBSIDIAN);
		
		RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
				" oo",
				" oo",
				"   ",
				'o', Blocks.OBSIDIAN);
		
		RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
				"   ",
				"oo ",
				"oo ",
				'o', Blocks.OBSIDIAN);
		
		RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
				"   ",
				" oo",
				" oo",
				'o', Blocks.OBSIDIAN);
	}*/
}

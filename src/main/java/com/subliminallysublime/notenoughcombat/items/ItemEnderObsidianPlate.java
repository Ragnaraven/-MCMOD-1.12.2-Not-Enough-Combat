package com.subliminallysublime.notenoughcombat.items;

import com.subliminallysublime.notenoughcombat.NECCreativeTabs;

/**
 * Created by Andrew on 7/15/2017 at 6:43 PM.
 */
public class ItemEnderObsidianPlate extends ItemBase
{
	public ItemEnderObsidianPlate(String name)
	{
		super(name, NECCreativeTabs.NECUniversalTab);
	}
	
	/*public void registerRecipe(boolean advancedRecipe)
	{
		if(advancedRecipe)
			RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
					"oeo",
					"bsb",
					"oeo",
					'o',  NECItems.obsidianPlate, 'e', Items.ENDER_EYE, 'b', NECBlocks.enderObsidian, 's', Blocks.END_STONE);
		else
			RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
					"oeo",
					"bsb",
					"oeo",
					'o',  Blocks.OBSIDIAN, 'e', Items.ENDER_EYE, 'b', NECBlocks.enderObsidian, 's', Blocks.END_STONE);
	}*/
}
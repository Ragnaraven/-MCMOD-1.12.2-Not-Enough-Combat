package io.github.ragnaraven.endgamearmors.items.tools;

import io.github.ragnaraven.endgamearmors.IItemGivenName;
import io.github.ragnaraven.endgamearmors.NECCreativeTabs;
import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import io.github.ragnaraven.endgamearmors.items.NECItems;
import io.github.ragnaraven.endgamearmors.util.IHasModel;
import net.minecraft.item.ItemHoe;

/**
 * Created by Andrew on 1/9/2017 at 5:55 PM.
 */
public class NECHoe extends ItemHoe implements IItemGivenName, IHasModel
{
	private String name;
	
	public NECHoe(ToolMaterial toolMaterial, String name, boolean register)
	{
		super(toolMaterial);
		
		this.name = name;
		
		setCreativeTab(NECCreativeTabs.NECUniversalTab);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		if(register)
			NECItems.ITEMS.add(this);
	}
	
	@Override
	public String getGivenName()
	{
		return name;
	}
	
	@Override
	public void registerModels()
	{
		NotEnoughCombatMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	/*public void registerRepetitiveRecipe ()
	{
		registerRepetitiveRecipe(OreDictionary.getOres("ingot" + name.substring(4, 5).toUpperCase() + name.substring(5)).get(0));
	}
	
	public void registerRepetitiveRecipe (Object buildMaterial)
	{
		RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
			"mm ",
				" s ",
				" s ",
				'm', buildMaterial, 's', Items.STICK);
	}*/
	
}

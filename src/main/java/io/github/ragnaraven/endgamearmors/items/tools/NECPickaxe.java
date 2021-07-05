package io.github.ragnaraven.endgamearmors.items.tools;

import io.github.ragnaraven.endgamearmors.IItemGivenName;
import io.github.ragnaraven.endgamearmors.NECCreativeTabs;
import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import io.github.ragnaraven.endgamearmors.items.NECItems;
import io.github.ragnaraven.endgamearmors.util.IHasModel;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by Andrew on 1/9/2017 at 5:55 PM.
 */
public class NECPickaxe extends ItemPickaxe implements IItemGivenName, IHasModel
{
	private String name;
	
	public NECPickaxe(ToolMaterial toolMaterial, String name, boolean register)
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
		registerRepetitiveRecipe(OreDictionary.getOres("ingot" + name.substring(8, 9).toUpperCase() + name.substring(9)).get(0));
	}
	
	public void registerRepetitiveRecipe (Object buildMaterial)
	{
		char m = name.charAt(0); //Composition Material
		
		RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
				"mmm",
				" s ",
				" s ",
				'm', buildMaterial, 's', Items.STICK);
	}*/
}

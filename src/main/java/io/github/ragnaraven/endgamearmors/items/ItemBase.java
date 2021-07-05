package io.github.ragnaraven.endgamearmors.items;

import io.github.ragnaraven.endgamearmors.IItemGivenName;
import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import io.github.ragnaraven.endgamearmors.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Andrew on 7/14/2017 at 8:35 PM.
 */
public class ItemBase extends Item implements IItemGivenName, IHasModel
{
	private String name;
	
	public String getGivenName () { return name; }
	
	public ItemBase(String name, CreativeTabs tabs)
	{
		this(name, tabs, 64);
	}
	
	public ItemBase(String name, CreativeTabs tab, int maxSize)
	{
		this.name = name;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxStackSize(maxSize);
		
		NECItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		NotEnoughCombatMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}

package com.subliminallysublime.notenoughcombat.items.armor;

import com.subliminallysublime.notenoughcombat.IItemGivenName;
import com.subliminallysublime.notenoughcombat.NECCreativeTabs;
import com.subliminallysublime.notenoughcombat.NotEnoughCombatMod;
import com.subliminallysublime.notenoughcombat.items.NECItems;
import com.subliminallysublime.notenoughcombat.util.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

/**
 * Created by Andrew on 1/20/2017 at 6:02 PM.
 */
public class NECArmor extends ItemArmor implements IItemGivenName, IHasModel
{
	protected String name;
	
	public NECArmor(ItemArmor.ArmorMaterial armorMaterial, int renderIndex, EntityEquipmentSlot equipmentSlot, String name, boolean register)
	{
		super(armorMaterial, renderIndex, equipmentSlot);
		
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
}
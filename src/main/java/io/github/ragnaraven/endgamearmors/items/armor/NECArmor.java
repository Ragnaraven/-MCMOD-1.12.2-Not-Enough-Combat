package io.github.ragnaraven.endgamearmors.items.armor;

import io.github.ragnaraven.endgamearmors.IItemGivenName;
import io.github.ragnaraven.endgamearmors.NECCreativeTabs;
import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import io.github.ragnaraven.endgamearmors.items.NECItems;
import io.github.ragnaraven.endgamearmors.util.IHasModel;
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
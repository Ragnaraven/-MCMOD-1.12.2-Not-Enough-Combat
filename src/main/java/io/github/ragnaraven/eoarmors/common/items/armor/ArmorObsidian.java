package io.github.ragnaraven.eoarmors.common.items.armor;

import net.minecraft.item.ArmorMaterial;

/**
 * Created by Andrew on 1/21/2017 at 9:54 PM.
 */
public class ArmorObsidian extends EOAArmor
{
	public ArmorObsidian(String name, ArmorMaterial armorMaterial)
	{
		super(name, armorMaterial);
	}
}
	/*
	public ArmorObsidian(ArmorMaterial obsidianArmor, int renderIndex, EntityEquipmentSlot equipmentSlot, String name)
	{
		super(obsidianArmor, renderIndex, equipmentSlot, name, true);
		
		setNoRepair();
	}
	
	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if (stack.getItem() == NECArmorRegistry.helmetObsidian || stack.getItem() == NECArmorRegistry.chestplateObsidian || stack.getItem() == NECArmorRegistry.bootsObsidian)
			return EnderObsidianArmorsMod.MODID + ":textures/models/armor/armor_obsidian_layer_0.png";
		else if(stack.getItem() == NECArmorRegistry.leggingsObsidian)
			return EnderObsidianArmorsMod.MODID + ":textures/models/armor/armor_obsidian_layer_1.png";
		else
			return super.getArmorTexture(stack, entity, slot, type);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		super.onArmorTick(world, player, itemStack);
		
		int armor = checkArmor(player);
		
		if(armor != LEVEL_OBSIDIAN)
			return; //-1 means no match for set.
		
		//Fire res
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 0, 1)); //40 ticks will prevent the ability from failing
		
		//Strength
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(5), 0, 0)); //40 ticks will prevent the ability from failing
	}
}*/
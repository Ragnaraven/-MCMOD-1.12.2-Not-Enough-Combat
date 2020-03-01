package com.subliminallysublime.notenoughcombat.items.armor;

import com.subliminallysublime.notenoughcombat.NotEnoughCombatMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by Andrew on 1/21/2017 at 9:54 PM.
 */
public class ArmorTin extends NECArmor
{
	public ArmorTin(ItemArmor.ArmorMaterial tinArmor, int renderIndex, EntityEquipmentSlot equipmentSlot, String name)
	{
		super(tinArmor, renderIndex, equipmentSlot, name, NotEnoughCombatMod.TIN);
	}
	
	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if (stack.getItem() == NECArmorRegistry.helmetTin || stack.getItem() == NECArmorRegistry.chestplateTin || stack.getItem() == NECArmorRegistry.bootsTin)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_tin_layer_0.png";
		else if(stack.getItem() == NECArmorRegistry.leggingsTin)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_tin_layer_1.png";
		else
			return super.getArmorTexture(stack, entity, slot, type);
	}
}

package com.subliminallysublime.notenoughcombat.items.armor;

import com.subliminallysublime.notenoughcombat.NotEnoughCombatMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by Andrew on 1/21/2017 at 9:54 PM.
 */
public class ArmorSilver extends NECArmor
{
	public ArmorSilver(ArmorMaterial silverArmor, int renderIndex, EntityEquipmentSlot equipmentSlot, String name)
	{
		super(silverArmor, renderIndex, equipmentSlot, name, NotEnoughCombatMod.SILVER);
	}
	
	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if (stack.getItem() == NECArmorRegistry.helmetSilver || stack.getItem() == NECArmorRegistry.chestplateSilver || stack.getItem() == NECArmorRegistry.bootsSilver)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_silver_layer_0.png";
		else if(stack.getItem() == NECArmorRegistry.leggingsSilver)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_silver_layer_1.png";
		else
			return super.getArmorTexture(stack, entity, slot, type);
	}
}

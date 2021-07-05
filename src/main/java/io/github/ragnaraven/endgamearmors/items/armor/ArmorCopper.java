package io.github.ragnaraven.endgamearmors.items.armor;

import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by Andrew on 1/21/2017 at 9:54 PM.
 */
public class ArmorCopper extends NECArmor
{
	public ArmorCopper(ItemArmor.ArmorMaterial copperMaterial, int renderIndex, EntityEquipmentSlot equipmentSlot, String name)
	{
		super(copperMaterial, renderIndex, equipmentSlot, name, NotEnoughCombatMod.COPPER);
	}
	
	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if(stack.getItem() == NECArmorRegistry.helmetCopper || stack.getItem() == NECArmorRegistry.chestplateCopper || stack.getItem() == NECArmorRegistry.bootsCopper)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_copper_layer_0.png";
		else if(stack.getItem() == NECArmorRegistry.leggingsCopper)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_copper_layer_1.png";
		else
			return super.getArmorTexture(stack, entity, slot, type);
	}
}

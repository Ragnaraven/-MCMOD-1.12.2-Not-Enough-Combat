package io.github.ragnaraven.endgamearmors.items.armor;

import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by Andrew on 1/20/2017 at 6:01 PM.
 */
public class ArmorRefinedIron extends NECArmor
{
	public ArmorRefinedIron(ArmorMaterial refinedIronMaterial, int renderIndex, EntityEquipmentSlot equipmentSlot, String name)
	{
		super(refinedIronMaterial, renderIndex, equipmentSlot, name, NotEnoughCombatMod.REFINED_IRON);
	}
	
	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if (stack.getItem() == NECArmorRegistry.helmetRefinedIron || stack.getItem() == NECArmorRegistry.chestplateRefinedIron || stack.getItem() == NECArmorRegistry.bootsRefinedIron)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_refined_iron_layer_0.png";
		else if(stack.getItem() == NECArmorRegistry.leggingsRefinedIron)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_refined_iron_layer_1.png";
		else
			return super.getArmorTexture(stack, entity, slot, type);
	}
}

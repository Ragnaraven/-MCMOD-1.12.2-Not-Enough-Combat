package io.github.ragnaraven.endgamearmors.items.armor;

import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by Andrew on 1/21/2017 at 9:54 PM.
 */
public class ArmorEmerald extends NECArmor
{
	public ArmorEmerald(ArmorMaterial emeraldArmor, int renderIndex, EntityEquipmentSlot equipmentSlot, String name)
	{
		super(emeraldArmor, renderIndex, equipmentSlot, name, true);
	}
	
	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if (stack.getItem() == NECArmorRegistry.helmetEmerald || stack.getItem() == NECArmorRegistry.chestplateEmerald || stack.getItem() == NECArmorRegistry.bootsEmerald)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_emerald_layer_0.png";
		else if (stack.getItem() == NECArmorRegistry.leggingsEmerald)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_emerald_layer_1.png";
		else
			return super.getArmorTexture(stack, entity, slot, type);
	}
}

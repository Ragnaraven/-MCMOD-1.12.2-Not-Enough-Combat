package io.github.ragnaraven.eoarmors.common.items.armor;

import io.github.ragnaraven.eoarmors.EnderObsidianArmorsMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by Andrew on 1/21/2017 at 9:54 PM.
 */
public class ArmorEmerald extends EOAArmor
{
	public ArmorEmerald(String name, ArmorMaterial armorMaterial)
	{
		super(name, armorMaterial);
	}
	/*
	public ArmorEmerald(ArmorMaterial emeraldArmor, int renderIndex, EquipmentSlotType equipmentSlot, String name)
	{
		super(emeraldArmor, renderIndex, equipmentSlot, name, true);
	}

	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
	{
		if (stack.getItem() == NECArmorRegistry.helmetEmerald || stack.getItem() == NECArmorRegistry.chestplateEmerald || stack.getItem() == NECArmorRegistry.bootsEmerald)
			return EnderObsidianArmorsMod.MODID + ":textures/models/armor/armor_emerald_layer_0.png";
		else if (stack.getItem() == NECArmorRegistry.leggingsEmerald)
			return EnderObsidianArmorsMod.MODID + ":textures/models/armor/armor_emerald_layer_1.png";
		else
			return super.getArmorTexture(stack, entity, slot, type);
	}*/
}

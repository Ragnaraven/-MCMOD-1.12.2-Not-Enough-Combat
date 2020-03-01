package com.subliminallysublime.notenoughcombat.items.armor;

import com.subliminallysublime.notenoughcombat.NotEnoughCombatMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static com.subliminallysublime.notenoughcombat.NECEventHandler.LEVEL_OBSIDIAN;
import static com.subliminallysublime.notenoughcombat.NECEventHandler.checkArmor;

/**
 * Created by Andrew on 1/21/2017 at 9:54 PM.
 */
public class ArmorObsidian extends NECArmor
{
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
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_obsidian_layer_0.png";
		else if(stack.getItem() == NECArmorRegistry.leggingsObsidian)
			return NotEnoughCombatMod.MODID + ":textures/models/armor/armor_obsidian_layer_1.png";
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
}

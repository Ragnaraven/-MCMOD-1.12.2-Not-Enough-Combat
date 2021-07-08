package io.github.ragnaraven.eoarmors.common.items.armor;

import io.github.ragnaraven.eoarmors.EnderObsidianArmorsMod;
import io.github.ragnaraven.eoarmors.client.render.particles.ParticleEffects;
import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Andrew on 7/15/2017 at 8:16 PM.
 */
public class ArmorEnderObsidian extends EOAArmor
{
	public ArmorEnderObsidian(String name, ArmorMaterial armorMaterial)
	{
		super(name, armorMaterial);
	}
	/*
	public ArmorEnderObsidian(ArmorMaterial enderObsidianArmor, int armorSlot, EntityEquipmentSlot equipmentSlot, String name)
	{
		super(enderObsidianArmor, armorSlot, equipmentSlot, name, true);
		
		setNoRepair();
	}
	
	@Nullable
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if(stack.getItem() == NECArmorRegistry.helmetEnderObsidian || stack.getItem() == NECArmorRegistry.chestplateEnderObsidian || stack.getItem() == NECArmorRegistry.bootsEnderObsidian)
			return EnderObsidianArmorsMod.MODID + ":textures/models/armor/armor_ender_obsidian_layer_0.png";
		else if(stack.getItem() == NECArmorRegistry.leggingsEnderObsidian)
			return EnderObsidianArmorsMod.MODID + ":textures/models/armor/armor_ender_obsidian_layer_1.png";
		else
			return super.getArmorTexture(stack, entity, slot, type);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		super.onArmorTick(world, player, itemStack);
		
		int armor = checkArmor(player);
		
		if(armor != LEVEL_ENDER_OBSIDIAN)
			return; //-1 means no match for set.
		
		//Both sets get fire resistance
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 0, 1)); //40 ticks will prevent the ability from failing
		
		//Add haste if full set plus pick
		try
		{
			if(checkArmorSetAgainstHeldTool(armor, player))
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 0, 0));//40 ticks will prevent the ability from failing
		}
		catch (NullPointerException ignored) { }
		
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 220, 0)); //11s of ticks prevents annoying flickering.
		
		if(player.world.isRemote)
		{
			//Occasional Ender particles
			if(EnderObsidianArmorsMod.RANDOM.nextInt(5) == 0)
				ParticleEffects.spawnEnderObsidianParticles(player, 1);
		}
	}
	
	/*public static void addRecipes (Item helmet, Item chestplate, Item leggings, Item boots)
	{
		RecipeFixer.addShapedRecipe(new ItemStack(helmet, 1, 0),
				" o ",
				"oOo",
				" o ",
				'o', NECItems.enderObsidianPlate, 'O', NECArmorRegistry.helmetObsidian);
		
		RecipeFixer.addShapedRecipe(new ItemStack(chestplate, 1, 0),
				"ooo",
				"oOo",
				"ooo",
				'o', NECItems.enderObsidianPlate, 'O', NECArmorRegistry.chestplateObsidian);
		
		RecipeFixer.addShapedRecipe(new ItemStack(leggings, 1, 0),
				" o ",
				"oOo",
				" o ",
				'o', NECItems.enderObsidianPlate, 'O', NECArmorRegistry.leggingsObsidian);
		
		RecipeFixer.addShapedRecipe(new ItemStack(boots, 1, 0),
				" o ",
				"oOo",
				" o ",
				'o', NECItems.enderObsidianPlate, 'O', NECArmorRegistry.bootsObsidian);
	}*/
}
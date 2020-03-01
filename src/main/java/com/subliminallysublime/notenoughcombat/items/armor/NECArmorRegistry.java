package com.subliminallysublime.notenoughcombat.items.armor;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by Andrew on 1/9/2017 at 5:07 PM.
 */
public class NECArmorRegistry
{
	//Copper
	public static ArmorCopper helmetCopper;
	public static ArmorCopper chestplateCopper;
	public static ArmorCopper leggingsCopper;
	public static ArmorCopper bootsCopper;
	
	//Tin
	public static ArmorTin helmetTin;
	public static ArmorTin chestplateTin;
	public static ArmorTin leggingsTin;
	public static ArmorTin bootsTin;
	
	//Silver
	public static ArmorSilver helmetSilver;
	public static ArmorSilver chestplateSilver;
	public static ArmorSilver leggingsSilver;
	public static ArmorSilver bootsSilver;
	
	//Refined Iron
	public static ArmorRefinedIron helmetRefinedIron;
	public static ArmorRefinedIron chestplateRefinedIron;
	public static ArmorRefinedIron leggingsRefinedIron;
	public static ArmorRefinedIron bootsRefinedIron;
	
	//Emerald
	public static ArmorEmerald helmetEmerald;
	public static ArmorEmerald chestplateEmerald;
	public static ArmorEmerald leggingsEmerald;
	public static ArmorEmerald bootsEmerald;
	
	//Obsidian
	public static ArmorObsidian helmetObsidian;
	public static ArmorObsidian chestplateObsidian;
	public static ArmorObsidian leggingsObsidian;
	public static ArmorObsidian bootsObsidian;
	
	//EnderObsidian
	public static ArmorEnderObsidian helmetEnderObsidian;
	public static ArmorEnderObsidian chestplateEnderObsidian;
	public static ArmorEnderObsidian leggingsEnderObsidian;
	public static ArmorEnderObsidian bootsEnderObsidian;
	
	//Materials                                                                                                                                   iron                 15           2   6  5  2               9
	public static ItemArmor.ArmorMaterial copperMaterial =        EnumHelper.addArmorMaterial("Copper Armor NEC",      "armor_copper",        13, new int[]{2, 4, 3, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
	public static ItemArmor.ArmorMaterial tinMaterial =           EnumHelper.addArmorMaterial("Tin Armor NEC",         "armor_tin",           11, new int[]{1, 4, 3, 1}, 24, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
	public static ItemArmor.ArmorMaterial refinedIronMaterial =   EnumHelper.addArmorMaterial("Refined Iron Armor NEC","armor_refined_iron",  26, new int[]{3, 7, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f);
	public static ItemArmor.ArmorMaterial silverMaterial =        EnumHelper.addArmorMaterial("Silver Armor NEC",      "armor_silver",        45, new int[]{4, 8, 7, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.25f);
	public static ItemArmor.ArmorMaterial emeraldMaterial =       EnumHelper.addArmorMaterial("Emerald Armor NEC",     "armor_emerald",       56, new int[]{4, 9, 8, 4},  8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f);
	public static ItemArmor.ArmorMaterial obsidianMaterial =      EnumHelper.addArmorMaterial("Obsidian Armor NEC",    "armor_obsidian",       3, new int[]{1, 1, 1, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
	public static ItemArmor.ArmorMaterial enderObsidianMaterial = EnumHelper.addArmorMaterial("EnderObsidian Armor NEC","armor_ender_obsidian",3, new int[]{1, 2, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
	
	public static void commonPreInit()
	{
		helmetCopper = new ArmorCopper(copperMaterial, 0, EntityEquipmentSlot.HEAD, "helmet_copper");
		chestplateCopper = new ArmorCopper(copperMaterial, 0, EntityEquipmentSlot.CHEST, "chestplate_copper");
		leggingsCopper = new ArmorCopper(copperMaterial, 1, EntityEquipmentSlot.LEGS, "leggings_copper");
		bootsCopper = new ArmorCopper(copperMaterial, 0, EntityEquipmentSlot.FEET, "boots_copper");
		
		helmetTin = new ArmorTin(tinMaterial, 0, EntityEquipmentSlot.HEAD, "helmet_tin");
		chestplateTin = new ArmorTin(tinMaterial, 0, EntityEquipmentSlot.CHEST, "chestplate_tin");
		leggingsTin = new ArmorTin(tinMaterial, 1, EntityEquipmentSlot.LEGS, "leggings_tin");
		bootsTin = new ArmorTin(tinMaterial, 0, EntityEquipmentSlot.FEET, "boots_tin");
		
		helmetRefinedIron = new ArmorRefinedIron(refinedIronMaterial, 0, EntityEquipmentSlot.HEAD, "helmet_refined_iron");
		chestplateRefinedIron = new ArmorRefinedIron(refinedIronMaterial, 0, EntityEquipmentSlot.CHEST, "chestplate_refined_iron");
		leggingsRefinedIron = new ArmorRefinedIron(refinedIronMaterial, 1, EntityEquipmentSlot.LEGS, "leggings_refined_iron");
		bootsRefinedIron = new ArmorRefinedIron(refinedIronMaterial, 0, EntityEquipmentSlot.FEET, "boots_refined_iron");
		
		helmetSilver = new ArmorSilver(silverMaterial, 0, EntityEquipmentSlot.HEAD, "helmet_silver");
		chestplateSilver = new ArmorSilver(silverMaterial, 0, EntityEquipmentSlot.CHEST, "chestplate_silver");
		leggingsSilver = new ArmorSilver(silverMaterial, 1, EntityEquipmentSlot.LEGS, "leggings_silver");
		bootsSilver = new ArmorSilver(silverMaterial, 0, EntityEquipmentSlot.FEET, "boots_silver");
		
		//Obsidian
		helmetObsidian =     new ArmorObsidian(obsidianMaterial, 0, EntityEquipmentSlot.HEAD, "helmet_obsidian");
		chestplateObsidian = new ArmorObsidian(obsidianMaterial, 0, EntityEquipmentSlot.CHEST, "chestplate_obsidian");
		leggingsObsidian =   new ArmorObsidian(obsidianMaterial, 1, EntityEquipmentSlot.LEGS, "leggings_obsidian");
		bootsObsidian =      new ArmorObsidian(obsidianMaterial, 0, EntityEquipmentSlot.FEET,"boots_obsidian");
		
		//Emerald
		helmetEmerald =     new ArmorEmerald(emeraldMaterial, 0, EntityEquipmentSlot.HEAD, "helmet_emerald");
		chestplateEmerald = new ArmorEmerald(emeraldMaterial, 0, EntityEquipmentSlot.CHEST,"chestplate_emerald");
		leggingsEmerald =   new ArmorEmerald(emeraldMaterial, 1, EntityEquipmentSlot.LEGS, "leggings_emerald");
		bootsEmerald =      new ArmorEmerald(emeraldMaterial, 0, EntityEquipmentSlot.FEET,"boots_emerald");
		
		//EnderObsidian
		helmetEnderObsidian =     new ArmorEnderObsidian(enderObsidianMaterial, 0, EntityEquipmentSlot.HEAD, "helmet_ender_obsidian");
		chestplateEnderObsidian = new ArmorEnderObsidian(enderObsidianMaterial, 0, EntityEquipmentSlot.CHEST, "chestplate_ender_obsidian");
		leggingsEnderObsidian =   new ArmorEnderObsidian(enderObsidianMaterial, 1, EntityEquipmentSlot.LEGS, "leggings_ender_obsidian");
		bootsEnderObsidian =      new ArmorEnderObsidian(enderObsidianMaterial, 0, EntityEquipmentSlot.FEET,"boots_ender_obsidian");
		
	}
	
	public static void commonInit ()
	{
		//registerRecipes();
	}
	
	//https://www.youtube.com/watch?v=LKaUaOg4HCA
	
	/*public static void registerRecipes ()
	{
		//////////////////////////
		//Copper Armor////////////
		//////////////////////////
		if(NotEnoughCombatMod.COPPER)
		{
			addHelmetRecipe(helmetCopper, OreDictionary.getOres("ingotCopper").get(0));
			addChestplateRecipe(chestplateCopper, OreDictionary.getOres("ingotCopper").get(0));
			addLeggingsRecipe(leggingsCopper, OreDictionary.getOres("ingotCopper").get(0));
			addBootsRecipe(bootsCopper, OreDictionary.getOres("ingotCopper").get(0));
		}
		
		//////////////////////////
		//Tin/////////////////////
		//////////////////////////
		if(NotEnoughCombatMod.TIN)
		{
			addHelmetRecipe(helmetTin, OreDictionary.getOres("ingotTin").get(0));
			addChestplateRecipe(chestplateTin, OreDictionary.getOres("ingotTin").get(0));
			addLeggingsRecipe(leggingsTin, OreDictionary.getOres("ingotTin").get(0));
			addBootsRecipe(bootsTin, OreDictionary.getOres("ingotTin").get(0));
		}
		
		//////////////////////////
		//REFINED IRON ARMOR//////
		//////////////////////////
		if(NotEnoughCombatMod.REFINED_IRON)
		{
			addHelmetRecipe(helmetRefinedIron, OreDictionary.getOres("ingotSteel").get(0));
			addChestplateRecipe(helmetRefinedIron, OreDictionary.getOres("ingotSteel").get(0));
			addLeggingsRecipe(leggingsRefinedIron, OreDictionary.getOres("ingotSteel").get(0));
			addBootsRecipe(bootsRefinedIron, OreDictionary.getOres("ingotSteel").get(0));
		}
		
		//////////////////////////
		//Silver Armor////////////
		//////////////////////////
		if(NotEnoughCombatMod.SILVER)
		{
			addHelmetRecipe(helmetSilver, OreDictionary.getOres("ingotSilver").get(0));
			addChestplateRecipe(chestplateSilver, OreDictionary.getOres("ingotSilver").get(0));
			addLeggingsRecipe(leggingsSilver, OreDictionary.getOres("ingotSilver").get(0));
			addBootsRecipe(bootsSilver, OreDictionary.getOres("ingotSilver").get(0));
		}
		
		//////////////////////////
		//Obsidian Armor//////////
		//////////////////////////
		addHelmetRecipe(helmetObsidian, NECItems.obsidianPlate);
		addChestplateRecipe(chestplateObsidian, NECItems.obsidianPlate);
		addLeggingsRecipe(leggingsObsidian, NECItems.obsidianPlate);
		addBootsRecipe(bootsObsidian, NECItems.obsidianPlate);
		
		//////////////////////////
		//Emerald/////////////////
		//////////////////////////
		addHelmetRecipe(helmetEmerald, Items.EMERALD);
		addChestplateRecipe(chestplateEmerald, Items.EMERALD);
		addLeggingsRecipe(leggingsEmerald, Items.EMERALD);
		addBootsRecipe(bootsEmerald, Items.EMERALD);
		
		//////////////////////////
		//EnderObsidian///////////
		//////////////////////////
		ArmorEnderObsidian.addRecipes(helmetEnderObsidian, chestplateEnderObsidian, leggingsEnderObsidian, bootsEnderObsidian);
	}
	
	public static void addHelmetRecipe (Item output, Object input)
	{
		RecipeFixer.addShapedRecipe(new ItemStack(output, 1, 0),
				"ooo",
				"o o",
				"   ",
				'o', input);
		
		RecipeFixer.addShapedRecipe(new ItemStack(output, 1, 0),
				"   ",
				"ooo",
				"o o",
				'o', input);
	}
	
	public static void addChestplateRecipe (Item output, Object input)
	{
		RecipeFixer.addShapedRecipe(new ItemStack(output, 1, 0),
				"o o",
				"ooo",
				"ooo",
				'o', input);
	}
	
	public static void addLeggingsRecipe (Item output, Object input)
	{
		RecipeFixer.addShapedRecipe(new ItemStack(output, 1, 0),
				"ooo",
				"o o",
				"o o",
				'o', input);
	}
	
	public static void addBootsRecipe (Item output, Object input)
	{
		RecipeFixer.addShapedRecipe(new ItemStack(output, 1, 0),
				"   ",
				"o o",
				"o o",
				'o', input);
		
		RecipeFixer.addShapedRecipe(new ItemStack(output, 1, 0),
				"o o",
				"o o",
				"   ",
				'o', input);
	}*/
}

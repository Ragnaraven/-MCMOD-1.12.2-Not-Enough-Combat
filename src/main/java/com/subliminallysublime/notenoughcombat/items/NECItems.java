package com.subliminallysublime.notenoughcombat.items;

import com.subliminallysublime.notenoughcombat.NotEnoughCombatMod;
import com.subliminallysublime.notenoughcombat.items.tools.*;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

/**
 * Created by Andrew on 1/9/2017 at 5:07 PM.
 */

@Mod.EventBusSubscriber
public class NECItems
{
	public static final ArrayList<Item> ITEMS = new ArrayList<>();
	
	public static NECAxe axeCopper;
	public static NECHoe hoeCopper;
	public static NECPickaxe pickaxeCopper;
	public static NECShovel shovelCopper;
	public static NECSword swordCopper;
	
	public static NECAxe axeTin;
	public static NECHoe hoeTin;
	public static NECPickaxe pickaxeTin;
	public static NECShovel shovelTin;
	public static NECSword swordTin;
	
	public static NECAxe axeRefinedIron;
	public static NECHoe hoeRefinedIron;
	public static NECPickaxe pickaxeRefinedIron;
	public static NECShovel shovelRefinedIron;
	public static NECSword swordRefinedIron;
	
	public static NECAxe axeSilver;
	public static NECHoe hoeSilver;
	public static NECPickaxe pickaxeSilver;
	public static NECShovel shovelSilver;
	public static NECSword swordSilver;
	
	public static NECAxe axeObsidian;
	public static NECHoe hoeObsidian;
	public static NECPickaxe pickaxeObsidian;
	public static NECShovel shovelObsidian;
	public static NECSword swordObsidian;
	
	public static NECAxe axeEmerald;
	public static NECHoe hoeEmerald;
	public static NECPickaxe pickaxeEmerald;
	public static NECShovel shovelEmerald;
	public static NECSword swordEmerald;
	
	public static NECAxe axeEnderObsidian;
	public static NECHoe hoeEnderObsidian;
	public static NECPickaxe pickaxeEnderObsidian;
	public static NECShovel shovelEnderObsidian;
	public static EnderObsidianSword swordEnderObsidian;
	
	public static ItemObsidianPlate obsidianPlate;
	public static ItemEnderObsidianPlate enderObsidianPlate;
	                                                                                 //Diamond                             3,        1561,           8.0f,            3f,             10
	public static Item.ToolMaterial copperMaterial         = EnumHelper.addToolMaterial("Copper NEC",       1, 192,  6.5f,  1.15f, 22);
	public static Item.ToolMaterial tinMaterial            = EnumHelper.addToolMaterial("Tin NEC",          1, 260,  5.50f, 1.25f, 24);
	public static Item.ToolMaterial refinedIronMaterial    = EnumHelper.addToolMaterial("Refined Iron NEC", 2, 1013, 7.00f, 2.25f, 17);
	public static Item.ToolMaterial silverMaterial         = EnumHelper.addToolMaterial("Silver NEC",       3, 1927, 11.0f, 5.00f, 30);
	public static Item.ToolMaterial emeraldMaterial        = EnumHelper.addToolMaterial("Emerald NEC",      3, 5268, 9.5f,  5.50f, 12);
	public static Item.ToolMaterial obsidianMaterial       = EnumHelper.addToolMaterial("Obsidian NEC",     3, 200,  12.0f, 3.50f, 10);
	public static Item.ToolMaterial enderObisidianMaterial = EnumHelper.addToolMaterial("EnderObsidian NEC",3, 375,  14.5f, 4.25f, 15);
	
	public static void commonPreInit ()
	{
		obsidianPlate = new ItemObsidianPlate("obsidian_plate");
		enderObsidianPlate = new ItemEnderObsidianPlate("ender_obsidian_plate");
		
		axeCopper = new NECAxe(copperMaterial, "axe_copper", NotEnoughCombatMod.COPPER);
		hoeCopper = new NECHoe(copperMaterial, "hoe_copper", NotEnoughCombatMod.COPPER);
		shovelCopper = new NECShovel(copperMaterial, "shovel_copper", NotEnoughCombatMod.COPPER);
		pickaxeCopper = new NECPickaxe(copperMaterial, "pickaxe_copper", NotEnoughCombatMod.COPPER);
		swordCopper = new NECSword(copperMaterial, "sword_copper", NotEnoughCombatMod.COPPER);
		
		axeTin = new NECAxe(tinMaterial, "axe_tin", NotEnoughCombatMod.TIN);
		hoeTin = new NECHoe(tinMaterial, "hoe_tin", NotEnoughCombatMod.TIN);
		shovelTin = new NECShovel(tinMaterial, "shovel_tin", NotEnoughCombatMod.TIN);
		pickaxeTin = new NECPickaxe(tinMaterial, "pickaxe_tin", NotEnoughCombatMod.TIN);
		swordTin = new NECSword(tinMaterial, "sword_tin", NotEnoughCombatMod.TIN);
		
		axeRefinedIron = new NECAxe(refinedIronMaterial, "axe_refined_iron", NotEnoughCombatMod.REFINED_IRON);
		hoeRefinedIron = new NECHoe(refinedIronMaterial, "hoe_refined_iron", NotEnoughCombatMod.REFINED_IRON);
		shovelRefinedIron = new NECShovel(refinedIronMaterial, "shovel_refined_iron", NotEnoughCombatMod.REFINED_IRON);
		pickaxeRefinedIron = new NECPickaxe(refinedIronMaterial, "pickaxe_refined_iron", NotEnoughCombatMod.REFINED_IRON);
		swordRefinedIron = new NECSword(refinedIronMaterial, "sword_refined_iron", NotEnoughCombatMod.REFINED_IRON);
		
		axeSilver = new NECAxe(silverMaterial, "axe_silver", NotEnoughCombatMod.SILVER);
		hoeSilver = new NECHoe(silverMaterial, "hoe_silver", NotEnoughCombatMod.SILVER);
		shovelSilver = new NECShovel(silverMaterial, "shovel_silver", NotEnoughCombatMod.SILVER);
		pickaxeSilver = new NECPickaxe(silverMaterial, "pickaxe_silver", NotEnoughCombatMod.SILVER);
		swordSilver = new NECSword(silverMaterial, "sword_silver", NotEnoughCombatMod.SILVER);
		
		axeObsidian = new NECAxe(obsidianMaterial, "axe_obsidian", true);
		hoeObsidian = new NECHoe(obsidianMaterial, "hoe_obsidian", true);
		shovelObsidian = new NECShovel(obsidianMaterial, "shovel_obsidian", true);
		pickaxeObsidian = new NECPickaxe(obsidianMaterial, "pickaxe_obsidian", true);
		swordObsidian = new NECSword(obsidianMaterial, "sword_obsidian", true);
		
		axeEmerald = new NECAxe(emeraldMaterial, "axe_emerald", true);
		hoeEmerald = new NECHoe(emeraldMaterial, "hoe_emerald", true);
		shovelEmerald = new NECShovel(emeraldMaterial, "shovel_emerald", true);
		pickaxeEmerald = new NECPickaxe(emeraldMaterial, "pickaxe_emerald", true);
		swordEmerald = new NECSword(emeraldMaterial, "sword_emerald", true);
		
		axeEnderObsidian = new NECAxe(enderObisidianMaterial, "axe_ender_obsidian", true);
		hoeEnderObsidian = new NECHoe(enderObisidianMaterial, "hoe_ender_obsidian", true);
		shovelEnderObsidian = new NECShovel(enderObisidianMaterial, "shovel_ender_obsidian", true);
		pickaxeEnderObsidian = new NECPickaxe(enderObisidianMaterial, "pickaxe_ender_obsidian", true);
		swordEnderObsidian = new EnderObsidianSword(enderObisidianMaterial, "sword_ender_obsidian");
	}
	
	public static void commonInit()
	{
		
 	}
}

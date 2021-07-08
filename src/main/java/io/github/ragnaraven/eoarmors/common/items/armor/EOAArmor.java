package io.github.ragnaraven.eoarmors.common.items.armor;

import io.github.ragnaraven.eoarmors.EOATabs;
import io.github.ragnaraven.eoarmors.EnderObsidianArmorsMod;
import io.github.ragnaraven.eoarmors.common.items.EOAItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

/**
 * Created by Andrew on 1/20/2017 at 6:02 PM.
 */
public class EOAArmor
{
	protected String name;
	protected ArmorMaterial armorMaterial;

	public final ArmorItem head;
	public final ArmorItem chest;
	public final ArmorItem legs;
	public final ArmorItem feet;

	public static final String text_head= "head";
	public static final String text_chest = "chest";
	public static final String text_legs = "legs";
	public static final String text_feet = "feet";

	public EOAArmor(String name, ArmorMaterial armorMaterial)
	{
		this.name = "armor_" + name;

		head   = new ArmorItem(armorMaterial, EquipmentSlotType.HEAD,  new Item.Properties().tab(EOATabs.TAB_NECUNIVERSAL));
		chest  = new ArmorItem(armorMaterial, EquipmentSlotType.CHEST, new Item.Properties().tab(EOATabs.TAB_NECUNIVERSAL));
		legs   = new ArmorItem(armorMaterial, EquipmentSlotType.LEGS,  new Item.Properties().tab(EOATabs.TAB_NECUNIVERSAL));
		feet   = new ArmorItem(armorMaterial, EquipmentSlotType.FEET,  new Item.Properties().tab(EOATabs.TAB_NECUNIVERSAL));
	}

	public ArmorItem head () { return head; }
	public String name_head () { return name + "_" + text_head; }

	public ArmorItem chest () { return chest; }
	public String name_chest() { return name + "_" + text_chest; }

	public ArmorItem legs () { return legs; }
	public String name_legs() { return name + "_" + text_legs; }

	public ArmorItem feet () { return feet; }
	public String name_feet() { return name + "_" + text_feet; }
}
package com.subliminallysublime.notenoughcombat.zproxys;

import com.subliminallysublime.notenoughcombat.items.NECItems;
import com.subliminallysublime.notenoughcombat.items.armor.NECArmorRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Andrew on 1/9/2017 at 4:47 PM.
 */
public class ServerProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
		//NECBlocks.commonPreInit();
		NECItems.commonPreInit();
		NECArmorRegistry.commonPreInit();
	}
	
	public void init(FMLInitializationEvent event)
	{
		//NECBlocks.commonInit();
		NECItems.commonInit();
		NECArmorRegistry.commonInit();
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
	
	}
	
	public void registerItemRenderer(Item item, int meta, String id)
	{
	
	}
}

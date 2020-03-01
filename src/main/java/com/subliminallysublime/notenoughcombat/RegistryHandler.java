package com.subliminallysublime.notenoughcombat;

import com.subliminallysublime.notenoughcombat.blocks.NECBlocks;
import com.subliminallysublime.notenoughcombat.items.NECItems;
import com.subliminallysublime.notenoughcombat.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Andrew on 4/20/2019 at 6:18 PM.
 */
@Mod.EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(NECItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(NECBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : NECItems.ITEMS)
			if (item instanceof IHasModel)
				((IHasModel) item).registerModels();
		
		for(Block block : NECBlocks.BLOCKS)
			if (block instanceof IHasModel)
				((IHasModel) block).registerModels();
	}
}

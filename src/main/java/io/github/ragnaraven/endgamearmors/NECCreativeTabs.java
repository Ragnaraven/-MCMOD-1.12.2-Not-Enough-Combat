package io.github.ragnaraven.endgamearmors;

import io.github.ragnaraven.endgamearmors.blocks.NECBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Andrew on 1/9/2017 at 5:15 PM.
 */
public class NECCreativeTabs
{
	public static final ItemGroup TAB_NECUNIVERSAL = new Tab_NECUniversal();

	public static void initializeTabs ()
	{
	}

	public static class Tab_NECUniversal extends ItemGroup {
		public Tab_NECUniversal () {
			super("NECUniversalTab");
		}

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(NECBlocks.enderObsidian);
		}
	}
}

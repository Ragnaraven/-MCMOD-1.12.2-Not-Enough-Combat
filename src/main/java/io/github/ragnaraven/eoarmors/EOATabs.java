package io.github.ragnaraven.eoarmors;

import io.github.ragnaraven.eoarmors.common.blocks.EOABlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * Created by Andrew on 1/9/2017 at 5:15 PM.
 */
public class EOATabs
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
			return new ItemStack(EOABlocks.ENDER_OBSIDIAN.get());
		}
	}
}

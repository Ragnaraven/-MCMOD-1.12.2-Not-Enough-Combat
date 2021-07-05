package io.github.ragnaraven.endgamearmors;

import io.github.ragnaraven.endgamearmors.config.ConfigHolder;
import io.github.ragnaraven.endgamearmors.zproxies.ClientProxy;
import io.github.ragnaraven.endgamearmors.zproxies.ServerProxy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Random;

@Mod(NotEnoughCombatMod.MODID)
@Mod.EventBusSubscriber(modid = NotEnoughCombatMod.MODID)
public class NotEnoughCombatMod
{
	public static final String NAME = "Not Enough Combat";
    public static final String MODID = "notenoughcombat";
    public static final String VERSION = "1.16.5-v1.0";
	
    public static final String CLIENT_SIDE = "io.github.ragnaraven.notenoughcombat.zproxies.ClientProxy";
	public static final String SERVER_SIDE = "io.github.ragnaraven.notenoughcombat.zproxies.ServerProxy";
	
	public static final Random RANDOM = new Random();

	/*
	public static boolean BUILDCRAFT = false;
	public static boolean IC2 = false;
	public static boolean COPPER = false;
	public static boolean TIN = false;
	public static boolean SILVER = false;
	public static boolean REFINED_IRON = false;
	 */

	public NotEnoughCombatMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);

		ItemInit.ITEMS.register(bus);
		BlockInit.Blocks.register(bus);

		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
	}

	private void setup(final FMLCommonSetupEvent event)
	{

	}
}

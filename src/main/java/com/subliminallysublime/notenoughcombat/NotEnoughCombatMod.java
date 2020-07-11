package com.subliminallysublime.notenoughcombat;

import com.subliminallysublime.notenoughcombat.config.NECConfig;
import com.subliminallysublime.notenoughcombat.zproxies.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

@Mod(modid = NotEnoughCombatMod.MODID, name = NotEnoughCombatMod.NAME, version = NotEnoughCombatMod.VERSION)
public class NotEnoughCombatMod
{
	public static final String NAME = "Not Enough Combat";
    public static final String MODID = "notenoughcombat";
    public static final String VERSION = "1.12.2-1.0";
	
    public static final String CLIENT_SIDE = "com.subliminallysublime.notenoughcombat.zproxies.ClientProxy";
	public static final String SERVER_SIDE = "com.subliminallysublime.notenoughcombat.zproxies.ServerProxy";
	
	public static final Random RANDOM = new Random();
	
	public static boolean BUILDCRAFT = false;
	public static boolean IC2 = false;
	public static boolean COPPER = false;
	public static boolean TIN = false;
	public static boolean SILVER = false;
	public static boolean REFINED_IRON = false;
	
	@SidedProxy(clientSide = CLIENT_SIDE, serverSide = SERVER_SIDE)
	public static ServerProxy proxy;
	
	@Mod.Instance(MODID)
	public static NotEnoughCombatMod instance;
	
	//Todo: config
	public static Configuration config;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
	    config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
	
        if(BUILDCRAFT = Loader.isModLoaded("buildcraft|core"))
	        System.out.println("Buildcraft has been detected. Altering recipes.");
	
	    if(IC2 = Loader.isModLoaded("ic2"))
		    System.out.println("IC2 has been detected. Altering recipes.");
	
	    COPPER = IC2;
	    TIN = IC2;
	    SILVER = IC2;
	    REFINED_IRON = IC2;
	
	    //Creative tabs
	    NECCreativeTabs.initializeTabs(config);
	
	    NECConfig.SYNC_CONFIG(config);
	    
	    //Items, Blocks, Armor init
	    proxy.preInit(event);

        config.save();
    }
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(instance);
		
		NECEventHandler handler = new NECEventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
		
		proxy.init(event);
	}
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
	    /*COPPER = OreDictionary.getOres("ingotCopper").size() > 0;
	    TIN = OreDictionary.getOres("ingotTin").size() > 0;
	    REFINED_IRON = OreDictionary.getOres("ingotSteel").size() > 0;
	    SILVER = OreDictionary.getOres("ingotSilver").size() > 0;*/
	
	    System.out.println(OreDictionary.getOreNames());
	    
	    proxy.postInit(event);
    }
}

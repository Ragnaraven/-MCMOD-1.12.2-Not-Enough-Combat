package io.github.ragnaraven.eoarmors.config;


import io.github.ragnaraven.eoarmors.core.eventlisteners.EOAEnderObsidianEventHandler;
import io.github.ragnaraven.eoarmors.core.eventlisteners.EOAEventHandler;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

/**
 * Created by Andrew on 10/4/2017 at 12:28 AM.
 */
public class NECConfig
{
	/**NECEVENTHANDLER**/
	
	public static final String MINE_OBSIDIAN = "Obsidian Mining With (Ender) Obsidian Suit and Pick";
	public static final String ENDER_OBSIDIAN_SPAWN = "Ender Obsidian Spawning";

	public static void SYNC_CONFIG(Configuration config)
	{ // Gets called from preInit
		try
		{
			// Load config
			config.load();
			
			// Read props from config
			Property prop = config.get(MINE_OBSIDIAN, // What category will it be saved to, can be any string
					"lavaSpawnChance", // Property name
					EOAEventHandler.LAVA_SPAWN_CHANCE.defaultVal, // Default value
					"Chance for lava to spawn when mining obsidian with a full suit of either kind of obsidian. Chance is 1 in [value]", // Comment
					EOAEventHandler.LAVA_SPAWN_CHANCE.min,
					EOAEventHandler.LAVA_SPAWN_CHANCE.max);
			EOAEventHandler.LAVA_SPAWN_CHANCE.set(prop.getInt()); // Get the boolean value, also set the property value to boolean
			
			/**On mine EXP*/
			prop = config.get(MINE_OBSIDIAN,
					"experienceChance",
					EOAEventHandler.EXP_CHANCE.defaultVal,
					"Chance for obsidian to drop exp with armor and matching pick. Chance is 1 in [value]",
					EOAEventHandler.EXP_CHANCE.min,
					EOAEventHandler.EXP_CHANCE.max);
			EOAEventHandler.EXP_CHANCE.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"baseExperience",
					EOAEventHandler.BASE_EXP.defaultVal,
					"Base experience for obsidian to drop. Literal value.",
					EOAEventHandler.BASE_EXP.min,
					EOAEventHandler.BASE_EXP.max);
			EOAEventHandler.BASE_EXP.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"randomExp",
					EOAEventHandler.EXP_RANDOM.defaultVal,
					"Additonal random xp. Literal value.",
					EOAEventHandler.EXP_RANDOM.min,
					EOAEventHandler.EXP_RANDOM.max);
			EOAEventHandler.EXP_RANDOM.set(prop.getInt());
			
			/**On mine tool heal*/
			prop = config.get(MINE_OBSIDIAN,
					"obsidianToMineUntilFullPickHealth",
					EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.defaultVal,
					"Number of obsidian to mine to heal a pick to full health. Literal value.",
					EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.min,
					EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.max);
			EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"additionalObsidianToMineUntilOtherToolsFullHealth",
					EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.defaultVal,
					"Number of obsidian to mine to heal a non-armor tools that are not picks to full health while mining obsidian. Literal value added to obsidianToMineUntilFullPickHealth.",
					EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.min,
					EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.max);
			EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"additionalObsidianToMineUntilOtherToolsFullHealth",
					EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.defaultVal,
					"Number of obsidian to mine to heal a non-armor tools that are not picks to full health while mining obsidian. Literal value added to obsidianToMineUntilFullPickHealth.",
					EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.min,
					EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.max);
			EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.set(prop.getInt());
			
			/**On mine armor heal**/
			prop = config.get(MINE_OBSIDIAN,
					"armorHealChance",
					EOAEventHandler.HEAL_ARMOR_CHANCE.defaultVal,
					"Chance to heal armor when mining obsidian.",
					EOAEventHandler.HEAL_ARMOR_CHANCE.min,
					EOAEventHandler.HEAL_ARMOR_CHANCE.max);
			EOAEventHandler.HEAL_ARMOR_CHANCE.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"armorHealDurability",
					EOAEventHandler.HEAL_ARMOR_DURABILITY.defaultVal,
					"How much durability to heal armor when mining obsidian.",
					EOAEventHandler.HEAL_ARMOR_DURABILITY.min,
					EOAEventHandler.HEAL_ARMOR_DURABILITY.max);
			EOAEventHandler.HEAL_ARMOR_DURABILITY.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"armorHealExpDrop",
					EOAEventHandler.ARMOR_HEAL_EXP_DROP.defaultVal,
					"Chance to drop 1 xp when mining obsidian and armor is healed.",
					EOAEventHandler.ARMOR_HEAL_EXP_DROP.min,
					EOAEventHandler.ARMOR_HEAL_EXP_DROP.max);
			EOAEventHandler.ARMOR_HEAL_EXP_DROP.set(prop.getInt());
			
			/**On harvest**/
			prop = config.get(MINE_OBSIDIAN,
					"chanceToSilkTouchObsidian",
					EOAEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.defaultVal,
					"Chance to drop obsidian when wearing an O or EO armor set and using a matching pick with silk touch.",
					EOAEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.min,
					EOAEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.max);
			EOAEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"chanceToSilkTouchObsidian",
					EOAEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.defaultVal,
					"Chance to drop ender obsidian while in the end with an EO armor set and using a matching pick with silk touch.",
					EOAEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.min,
					EOAEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.max);
			EOAEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.set(prop.getInt());
			
			/**********************************
			 *
			 **********************************/
			prop = config.get(ENDER_OBSIDIAN_SPAWN,
					"chanceForEnderObsidianToSpawnWithMods",
					EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.defaultVal,
					"Chance to spawn ender obsidian with game changing mods detected.",
					EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.min,
					EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.max);
			EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.set(prop.getInt());
			
			prop = config.get(ENDER_OBSIDIAN_SPAWN,
					"chanceForEnderObsidianToSpawnWithoutMods",
					EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.defaultVal,
					"Chance to spawn ender obsidian without game changing mods detected.",
					EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.min,
					EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.max);
			EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.set(prop.getInt());
		}
		catch (Exception e)
		{
			// Failed reading/writing, just continue
		}
		finally
		{
			// Save props to config IF config changed
			if (config.hasChanged()) config.save();
		}
	}
}

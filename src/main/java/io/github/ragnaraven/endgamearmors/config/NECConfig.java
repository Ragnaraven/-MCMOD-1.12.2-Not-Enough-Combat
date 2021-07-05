package io.github.ragnaraven.endgamearmors.config;


import io.github.ragnaraven.endgamearmors.NECEnderObsidianEventHandler;
import io.github.ragnaraven.endgamearmors.NECEventHandler;
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
					NECEventHandler.LAVA_SPAWN_CHANCE.defaultVal, // Default value
					"Chance for lava to spawn when mining obsidian with a full suit of either kind of obsidian. Chance is 1 in [value]", // Comment
					NECEventHandler.LAVA_SPAWN_CHANCE.min,
					NECEventHandler.LAVA_SPAWN_CHANCE.max);
			NECEventHandler.LAVA_SPAWN_CHANCE.set(prop.getInt()); // Get the boolean value, also set the property value to boolean
			
			/**On mine EXP*/
			prop = config.get(MINE_OBSIDIAN,
					"experienceChance",
					NECEventHandler.EXP_CHANCE.defaultVal,
					"Chance for obsidian to drop exp with armor and matching pick. Chance is 1 in [value]",
					NECEventHandler.EXP_CHANCE.min,
					NECEventHandler.EXP_CHANCE.max);
			NECEventHandler.EXP_CHANCE.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"baseExperience",
					NECEventHandler.BASE_EXP.defaultVal,
					"Base experience for obsidian to drop. Literal value.",
					NECEventHandler.BASE_EXP.min,
					NECEventHandler.BASE_EXP.max);
			NECEventHandler.BASE_EXP.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"randomExp",
					NECEventHandler.EXP_RANDOM.defaultVal,
					"Additonal random xp. Literal value.",
					NECEventHandler.EXP_RANDOM.min,
					NECEventHandler.EXP_RANDOM.max);
			NECEventHandler.EXP_RANDOM.set(prop.getInt());
			
			/**On mine tool heal*/
			prop = config.get(MINE_OBSIDIAN,
					"obsidianToMineUntilFullPickHealth",
					NECEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.defaultVal,
					"Number of obsidian to mine to heal a pick to full health. Literal value.",
					NECEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.min,
					NECEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.max);
			NECEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"additionalObsidianToMineUntilOtherToolsFullHealth",
					NECEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.defaultVal,
					"Number of obsidian to mine to heal a non-armor tools that are not picks to full health while mining obsidian. Literal value added to obsidianToMineUntilFullPickHealth.",
					NECEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.min,
					NECEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.max);
			NECEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"additionalObsidianToMineUntilOtherToolsFullHealth",
					NECEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.defaultVal,
					"Number of obsidian to mine to heal a non-armor tools that are not picks to full health while mining obsidian. Literal value added to obsidianToMineUntilFullPickHealth.",
					NECEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.min,
					NECEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.max);
			NECEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.set(prop.getInt());
			
			/**On mine armor heal**/
			prop = config.get(MINE_OBSIDIAN,
					"armorHealChance",
					NECEventHandler.HEAL_ARMOR_CHANCE.defaultVal,
					"Chance to heal armor when mining obsidian.",
					NECEventHandler.HEAL_ARMOR_CHANCE.min,
					NECEventHandler.HEAL_ARMOR_CHANCE.max);
			NECEventHandler.HEAL_ARMOR_CHANCE.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"armorHealDurability",
					NECEventHandler.HEAL_ARMOR_DURABILITY.defaultVal,
					"How much durability to heal armor when mining obsidian.",
					NECEventHandler.HEAL_ARMOR_DURABILITY.min,
					NECEventHandler.HEAL_ARMOR_DURABILITY.max);
			NECEventHandler.HEAL_ARMOR_DURABILITY.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"armorHealExpDrop",
					NECEventHandler.ARMOR_HEAL_EXP_DROP.defaultVal,
					"Chance to drop 1 xp when mining obsidian and armor is healed.",
					NECEventHandler.ARMOR_HEAL_EXP_DROP.min,
					NECEventHandler.ARMOR_HEAL_EXP_DROP.max);
			NECEventHandler.ARMOR_HEAL_EXP_DROP.set(prop.getInt());
			
			/**On harvest**/
			prop = config.get(MINE_OBSIDIAN,
					"chanceToSilkTouchObsidian",
					NECEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.defaultVal,
					"Chance to drop obsidian when wearing an O or EO armor set and using a matching pick with silk touch.",
					NECEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.min,
					NECEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.max);
			NECEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.set(prop.getInt());
			
			prop = config.get(MINE_OBSIDIAN,
					"chanceToSilkTouchObsidian",
					NECEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.defaultVal,
					"Chance to drop ender obsidian while in the end with an EO armor set and using a matching pick with silk touch.",
					NECEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.min,
					NECEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.max);
			NECEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.set(prop.getInt());
			
			/**********************************
			 *
			 **********************************/
			prop = config.get(ENDER_OBSIDIAN_SPAWN,
					"chanceForEnderObsidianToSpawnWithMods",
					NECEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.defaultVal,
					"Chance to spawn ender obsidian with game changing mods detected.",
					NECEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.min,
					NECEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.max);
			NECEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.set(prop.getInt());
			
			prop = config.get(ENDER_OBSIDIAN_SPAWN,
					"chanceForEnderObsidianToSpawnWithoutMods",
					NECEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.defaultVal,
					"Chance to spawn ender obsidian without game changing mods detected.",
					NECEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.min,
					NECEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.max);
			NECEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.set(prop.getInt());
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

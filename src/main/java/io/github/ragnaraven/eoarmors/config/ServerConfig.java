package io.github.ragnaraven.eoarmors.config;

import com.google.common.collect.Lists;
import io.github.ragnaraven.eoarmors.core.eventlisteners.EOAEnderObsidianEventHandler;
import io.github.ragnaraven.eoarmors.core.eventlisteners.EOAEventHandler;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ServerConfig {

    //Mining
    public final ForgeConfigSpec.IntValue lavaSpawnChance;
    public final ForgeConfigSpec.IntValue expChance;
    public final ForgeConfigSpec.IntValue baseExp;
    public final ForgeConfigSpec.IntValue baseRandom;
    public final ForgeConfigSpec.IntValue obsidianToMineToFullHealthOfPick;
    public final ForgeConfigSpec.IntValue obsidianToMineToFullHealthOfInventoryAndOthers;
    public final ForgeConfigSpec.IntValue healArmorChance;
    public final ForgeConfigSpec.IntValue healArmorDurability;
    public final ForgeConfigSpec.IntValue healArmorExpDropDurability;
    public final ForgeConfigSpec.IntValue chanceToSilkTouchObsidian;
    public final ForgeConfigSpec.IntValue chanceToConvertObsidianToEnderObsidian;

    //EO
    public final ForgeConfigSpec.IntValue chanceSpawnEnderObsidianWithOtherMods;
    public final ForgeConfigSpec.IntValue chanceSpawnEnderObsidianStandard;

    public ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("Obsidian Mining With (Ender) Obsidian Suit and Pick");
        this.lavaSpawnChance = buildInt(builder, "Lava Spawn Chance", "all", EOAEventHandler.LAVA_SPAWN_CHANCE.defaultVal, EOAEventHandler.LAVA_SPAWN_CHANCE.min, EOAEventHandler.LAVA_SPAWN_CHANCE.max, "Chance for lava to spawn when mining obsidian with a full suit of either kind of obsidian. Chance is 1 in [value]");
        this.expChance = buildInt(builder, "Experience Chance", "all", EOAEventHandler.EXP_CHANCE.defaultVal, EOAEventHandler.EXP_CHANCE.min, EOAEventHandler.EXP_CHANCE.max, "Base experience for obsidian to drop. Literal value.");
        this.baseExp = buildInt(builder, "Base Exp", "all", EOAEventHandler.BASE_EXP.defaultVal, EOAEventHandler.BASE_EXP.min, EOAEventHandler.BASE_EXP.max, "Base experience for obsidian to drop. Literal value.");
        this.baseRandom = buildInt(builder, "Base Exp Deviation", "all", EOAEventHandler.EXP_RANDOM.defaultVal, EOAEventHandler.EXP_RANDOM.min, EOAEventHandler.EXP_RANDOM.max, "Additonal random xp. Literal value.");
        this.obsidianToMineToFullHealthOfPick = buildInt(builder, "Obsidian to mine to full Pick Health", "all", EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.defaultVal, EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.min, EOAEventHandler.OBSIDIAN_TO_MINE_TO_FULL_HEALTH.max, "Number of obsidian to mine to heal a pick to full health. Literal value.");
        this.obsidianToMineToFullHealthOfInventoryAndOthers = buildInt(builder, "Obsidian to mine to full inventory health", "all", EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.defaultVal, EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.min, EOAEventHandler.ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.max, "Number of obsidian to mine to heal a non-armor tools that are not picks to full health while mining obsidian. Literal value added to obsidianToMineUntilFullPickHealth.");
        this.healArmorChance = buildInt(builder, "Armor Heal Chance on mine", "all", EOAEventHandler.HEAL_ARMOR_CHANCE.defaultVal, EOAEventHandler.HEAL_ARMOR_CHANCE.min, EOAEventHandler.HEAL_ARMOR_CHANCE.max, "Chance to heal armor when mining obsidian.");
        this.healArmorDurability = buildInt(builder, "Armor Heal Amount", "all", EOAEventHandler.HEAL_ARMOR_DURABILITY.defaultVal, EOAEventHandler.HEAL_ARMOR_DURABILITY.min, EOAEventHandler.HEAL_ARMOR_DURABILITY.max, "How much durability to heal armor when mining obsidian.");
        this.healArmorExpDropDurability = buildInt(builder, "Armor Heal Exp Drop Chance (always 1xp)", "all", EOAEventHandler.ARMOR_HEAL_EXP_DROP.defaultVal, EOAEventHandler.ARMOR_HEAL_EXP_DROP.min, EOAEventHandler.ARMOR_HEAL_EXP_DROP.max, "Chance to drop 1 xp when mining obsidian and armor is healed.");
        this.chanceToSilkTouchObsidian = buildInt(builder, "Chance to Silk Touch Obsidian and Drop instead of Consuming", "all", EOAEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.defaultVal, EOAEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.min, EOAEventHandler.CHANCE_TO_SILK_TOUCH_OBSIDIAN.max, "Chance to drop obsidian when wearing an O or EO armor set and using a matching pick with silk touch.");
        this.chanceToConvertObsidianToEnderObsidian = buildInt(builder, "Chance to Convert Obsidian to Ender Obsidian while mining in End", "all", EOAEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.defaultVal, EOAEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.min, EOAEventHandler.CHANCE_CONVERT_OBSIDIAN_TO_ENDER.max, "Chance to drop ender obsidian while in the end with an EO armor set and using a matching pick with silk touch.");

        builder.pop();
        builder.push("Ender Obsidian Spawning");
        this.chanceSpawnEnderObsidianWithOtherMods = buildInt(builder, "Chance to Silk Touch Obsidian and Drop instead of Consuming", "all",      EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.defaultVal, EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.min,     EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT_MOD.max, "Chance to spawn ender obsidian with game changing mods detected.");
        this.chanceSpawnEnderObsidianStandard =      buildInt(builder, "Chance to Convert Obsidian to Ender Obsidian while mining in End", "all", EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.defaultVal,     EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.min,         EOAEnderObsidianEventHandler.CHANCE_SPAWN_ENDER_OBSIDIAN_EVENT.max,     "Chance to spawn ender obsidian without game changing mods detected.");
    }


    private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String comment){
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }

}

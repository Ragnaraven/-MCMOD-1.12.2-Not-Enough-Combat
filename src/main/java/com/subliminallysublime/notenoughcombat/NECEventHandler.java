package com.subliminallysublime.notenoughcombat;

import com.subliminallysublime.notenoughcombat.blocks.NECBlocks;
import com.subliminallysublime.notenoughcombat.items.NECItems;
import com.subliminallysublime.notenoughcombat.items.armor.ArmorEnderObsidian;
import com.subliminallysublime.notenoughcombat.items.armor.ArmorObsidian;
import com.subliminallysublime.notenoughcombat.particles.ParticleEffects;
import com.subliminallysublime.notenoughcombat.util.RangedInt;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DimensionType;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Andrew on 7/15/2017 at 2:48 AM.
 *
 * This class handles all tool healing events, as well as ender obsidian creation
 */
public class NECEventHandler
{
	//Armor level
	//Pick level
	//Block level
	public static final int LEVEL_OBSIDIAN = 0;
	public static final int LEVEL_ENDER_OBSIDIAN = 1;
	
	//On mine lava
	public static final RangedInt LAVA_SPAWN_CHANCE = new RangedInt(11, RangedInt.EMODES.ALWAYS);
	
	//On mine exp
	public static final RangedInt EXP_CHANCE = new RangedInt(5, RangedInt.EMODES.ALWAYS);
	public static final RangedInt BASE_EXP = new RangedInt(2, RangedInt.EMODES.ALWAYS);
	public static final RangedInt EXP_RANDOM = new RangedInt(3, RangedInt.EMODES.ALWAYS);
	
	//On mine tool heal
	public static final RangedInt OBSIDIAN_TO_MINE_TO_FULL_HEALTH = new RangedInt(25, RangedInt.EMODES.ALWAYS);
	public static final RangedInt ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH = new RangedInt(18, RangedInt.EMODES.ALWAYS); //Added to above
	//On mine armor heal
	public static final RangedInt HEAL_ARMOR_CHANCE = new RangedInt(0, 1000, 700, RangedInt.EMODES.ALWAYS); //Out 0f 1000
	public static final RangedInt HEAL_ARMOR_DURABILITY = new RangedInt(1, Integer.MAX_VALUE, 2, RangedInt.EMODES.ALWAYS);
	public static final RangedInt ARMOR_HEAL_EXP_DROP = new RangedInt(1, RangedInt.EMODES.ALWAYS);
	
	//On harvest
	public static final RangedInt CHANCE_TO_SILK_TOUCH_OBSIDIAN = new RangedInt(7, RangedInt.EMODES.ALWAYS);
	public static final RangedInt CHANCE_CONVERT_OBSIDIAN_TO_ENDER = new RangedInt(10, RangedInt.EMODES.ALWAYS);
	
	public static boolean ENABLE_FORTUNE = true;
	//Redo this to be smarter, maybe add config, if requested.
	private static final int CHANCE_BUILT_IN_FORTUNE_EFFECT = 350; //out 1000
	private static final int FORTUNE_EFFECT_MULTIPLIER_BASE = 2;
	private static final int FORTUNE_EFFECT_EXTRA_PICK_HURT = 5;
	private static final int FORTUNE_EFFECT_DROP_0 = 16;
	private static final int FORTUNE_EFFECT_MULTIPLIER_ADDITIONAL_RANDOM = 3; //Higher number = less chance to get the max
	private static final int FORTUNE_EFFECT_MAX_ADDITION_CHANCE = 64;

	private static final int FORTUNE_EFFECT_QUARTZ_MULTIPLIER = 3;
	
	/**Check for NULL before calling**/
	public static int checkArmor (EntityPlayer player)
	{
		int initArmor = -1;
		int armor = -1; //0 is obsidian, 1 is enderObsidian
		
		for (int i = 0; i < 4; i++)
		{
			if(initArmor != armor)
				return -1;
			else if (player.inventory.armorInventory.get(i) == ItemStack.EMPTY)
				return -1;
			else if (player.inventory.armorInventory.get(i).getItem() instanceof ArmorObsidian)
				armor = LEVEL_OBSIDIAN;
			else if (player.inventory.armorInventory.get(i).getItem() instanceof ArmorEnderObsidian)
				armor = LEVEL_ENDER_OBSIDIAN;
			else
				return -1;
			
			if(initArmor == -1) //Only is allowed to be set once. If it changes, the armor is not the same as the other, therefore not a full set.
				initArmor = armor;
		}
		
		return armor;
	}
	
	public static int checkPick (EntityPlayer player)
	{
		int pick = -1; //0 is obsidian, 1 is enderObsidian
		
		if(player.inventory.getCurrentItem() != ItemStack.EMPTY)
			if(player.inventory.getCurrentItem().getItem() == NECItems.pickaxeObsidian)
				pick = LEVEL_OBSIDIAN;
			else if(player.inventory.getCurrentItem().getItem() == NECItems.pickaxeEnderObsidian)
				pick = LEVEL_ENDER_OBSIDIAN;
		
		return pick;
	}
	
	/**BE SURE TO CHECK FOR NULL CURRENTITEM*/
	public static boolean checkPickAgainstArmorSet (int armor, EntityPlayer player)
	{
		if (armor == LEVEL_OBSIDIAN)
			return player.inventory.getCurrentItem().getItem() == NECItems.pickaxeObsidian;
		else if (armor == LEVEL_ENDER_OBSIDIAN)
			return player.inventory.getCurrentItem().getItem() == NECItems.pickaxeEnderObsidian;
		
		return false;
	}
	
	/**BE SURE TO CHECK FOR NULL CURRENTITEM*/
	public static boolean checkArmorSetAgainstHeldTool (int armor, EntityPlayer player)
	{
		if (armor == 0)
			return player.inventory.getCurrentItem().getItem() == NECItems.axeObsidian
					|| (player.inventory.getCurrentItem().getItem() == NECItems.pickaxeObsidian)
					|| (player.inventory.getCurrentItem().getItem() == NECItems.shovelObsidian);
		
		else if (armor == 1)
			return player.inventory.getCurrentItem().getItem() == NECItems.axeEnderObsidian
					|| (player.inventory.getCurrentItem().getItem() == NECItems.pickaxeEnderObsidian)
					|| (player.inventory.getCurrentItem().getItem() == NECItems.shovelEnderObsidian);
		
		return false;
		
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onBlockBreak(BlockEvent.BreakEvent e)
	{
		if (e.getPlayer() != null)
		{
			EntityPlayer player = e.getPlayer();
			
			int armor = checkArmor(player);
			
			if(armor == -1)
				return; //-1 means no match for set.
			
			//If here, player is wearing all of obsidian or enderObsidian armor. Can be checked by armor val
			try
			{
				//Either set
				if (checkPickAgainstArmorSet(armor, player))
				{
					if (e.getState().getBlock() == Blocks.OBSIDIAN)
					{
						doArmorHeal(e, player);
						doLavaDrop(e);
						//doExp(e);
					}
				}
			}
			catch (NullPointerException ignored) { }
		}
	}
	
	private void doLavaDrop (final BlockEvent.BreakEvent e)
	{
		if(LAVA_SPAWN_CHANCE.get() != 0)
		{
			if (!e.getWorld().isRemote)
			{
				if (e.getWorld().provider.getDimensionType() != DimensionType.THE_END) //If not in end
				{
					if (NotEnoughCombatMod.RANDOM.nextInt(LAVA_SPAWN_CHANCE.get()) == 0)
					{
						e.getWorld().setBlockState(e.getPos(), Blocks.LAVA.getDefaultState());
						e.setCanceled(true);
					}
				}
			}
		}
	}
	
	private void doExp (BlockEvent.BreakEvent e)
	{
		if (EXP_CHANCE.get() != 0)
		{
			if (NotEnoughCombatMod.RANDOM.nextInt(EXP_CHANCE.get()) == 0)
			{
				e.setExpToDrop(e.getExpToDrop() + BASE_EXP.get());
				
				if(EXP_RANDOM.get() != 0)
					e.setExpToDrop(e.getExpToDrop() + NotEnoughCombatMod.RANDOM.nextInt(EXP_RANDOM.get()));
			}
		}
	}
	
	/**Catch for nullPointer if calling this**/
	private void doToolHeal (EntityPlayer player)
	{
		try
		{
			if(OBSIDIAN_TO_MINE_TO_FULL_HEALTH.get() != 0)
			{
				int pickHeal = player.inventory.getCurrentItem().getMaxDamage() / OBSIDIAN_TO_MINE_TO_FULL_HEALTH.get();
				pickHeal = pickHeal <= 0 ? 1 : pickHeal; //I have no clue why I am setting it to 1 but it heals the pick fully so..
				player.inventory.getCurrentItem().setItemDamage(player.inventory.getCurrentItem().getItemDamage() - pickHeal);
			}
			
			//Doesnt matter if pick is 0 here.
			if(ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.get() != 0)
			{
				for (int i = 0; i < player.inventory.getSizeInventory(); i++)
					if (player.inventory.getStackInSlot(i) != ItemStack.EMPTY && player.inventory.getStackInSlot(i) != player.inventory.getCurrentItem()) //Current item already healed
					{
						//Only heals TOOLS. Not armor in inv. Must be wearing to heal.
						ItemStack stack = player.inventory.getStackInSlot(i);
						Item item = stack.getItem();
						if (item == NECItems.axeObsidian
								|| item == NECItems.axeEnderObsidian
								
								|| item == NECItems.pickaxeObsidian
								|| item == NECItems.pickaxeEnderObsidian
								
								|| item == NECItems.shovelObsidian
								|| item == NECItems.shovelEnderObsidian
								
								|| item == NECItems.hoeObsidian
								|| item == NECItems.hoeEnderObsidian
								
								|| item == NECItems.swordObsidian
								|| item == NECItems.swordEnderObsidian)
						{
							int otherHeal = stack.getMaxDamage() / (OBSIDIAN_TO_MINE_TO_FULL_HEALTH.get() + ADDITIONAL_OBSIDIAN_TO_MINE_NON_PICK_TO_FULL_HEALTH.get());
							otherHeal = otherHeal <= 0 ? 0 : otherHeal;
							
							//System.out.println("Healing tool by: " + otherHeal + " out of " + stack.getMaxDamage());
							
							stack.setItemDamage(stack.getItemDamage() - otherHeal);
						}
					}
			}
		}
		catch (Exception ignored) { }
	}
	
	/**Catch for nullPointer if calling this**/
	private void doArmorHeal(BlockEvent.BreakEvent e, EntityPlayer player)
	{
		if (HEAL_ARMOR_CHANCE.get() != 0)
		{
			if (NotEnoughCombatMod.RANDOM.nextInt(HEAL_ARMOR_CHANCE.max) < HEAL_ARMOR_CHANCE.get())
			{
				e.setExpToDrop(e.getExpToDrop() + ARMOR_HEAL_EXP_DROP.get());
				int armorHeal;
				
				for (int i = 0; i < 4; i++)
				{
					armorHeal = player.inventory.armorInventory.get(i).getItemDamage() - HEAL_ARMOR_DURABILITY.get();
					armorHeal = armorHeal < 0 ? 0 : armorHeal;
					
					player.inventory.armorInventory.get(i).setItemDamage(armorHeal);
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onHarvestDrop(BlockEvent.HarvestDropsEvent e)
	{
		Block block = e.getState().getBlock();

		int eblockState = -1;
		
		if(e.getState().getBlock() == Blocks.OBSIDIAN)
			eblockState = LEVEL_OBSIDIAN;
		
		if(e.getState().getBlock() == NECBlocks.enderObsidian)
			eblockState = LEVEL_ENDER_OBSIDIAN;
		
		if(e.getHarvester() != null)
		{
			EntityPlayer player = e.getHarvester();
			
			int pick = checkPick(player);
			
			if (pick == -1) //Nothing special if not o or eo pick
				return;
			
			//If here, using a pick
			try
			{
				int armor = checkArmor(player);
				//Pick and armor are the same, suit has modifiers
				if (pick == armor)
				{
					if(eblockState == -1) //Fortune effects are applied for non-obsidian BLOCKS.
					{
						if(armor != LEVEL_ENDER_OBSIDIAN)
							return; //This does not run unless the ender obsidian pick and armor set is active.
						
						//If here, is wearing eo armor and pick
						//Only ender obsidian set. Since check pick worked, we dont need to check again.
						//Add extra
						if (ENABLE_FORTUNE && NotEnoughCombatMod.RANDOM.nextInt(1000) < CHANCE_BUILT_IN_FORTUNE_EFFECT)
						{//If here, apply fortune effect.
							
							int multiplier = FORTUNE_EFFECT_MULTIPLIER_BASE;
							
							int extra = NotEnoughCombatMod.RANDOM.nextInt(FORTUNE_EFFECT_MAX_ADDITION_CHANCE);
							
							//Currently a 1 in 32 chance for 5x multiplier
							for (int i = FORTUNE_EFFECT_MAX_ADDITION_CHANCE / FORTUNE_EFFECT_MULTIPLIER_ADDITIONAL_RANDOM; i > 0; i /= FORTUNE_EFFECT_MULTIPLIER_ADDITIONAL_RANDOM)
								if (extra < i)
									multiplier++;
							
							//Apply extra
							for(ItemStack itemStack : e.getDrops())
							{
								if(checkOreRelationship(block, itemStack))
								{
									int count = itemStack.getCount() * multiplier;

									//Add extra quartz cause its SOOOOO annoying.
									if(block.getUnlocalizedName().toLowerCase().equals("tile.netherquartz") && itemStack.getItem().getUnlocalizedName().toLowerCase().equals("item.netherquartz"))
										count *= FORTUNE_EFFECT_QUARTZ_MULTIPLIER;

									itemStack.setCount(count > 64 ? 64 : count);
									
									player.inventory.getCurrentItem().damageItem(multiplier * FORTUNE_EFFECT_EXTRA_PICK_HURT, player);
									
									if (e.getWorld().isRemote)
										for (int i = 0; i < 15; i++)
											ParticleEffects.spawnEnderObsidianSpawnParticles(e.getWorld(), player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
								}
							}
						}
						else //If here, they were unlucky, lets see if they are even less lucky
						{
							if(NotEnoughCombatMod.RANDOM.nextInt(FORTUNE_EFFECT_DROP_0) == 0)
								e.getDrops().clear();
						}
						
						return; //Do not continue because the block was NOT obsidian or ender obsidian.
					}
					
					//If mining obisidian and wearing matching set with matching pick
					if (eblockState == LEVEL_OBSIDIAN)
					{
						doToolHeal(player);
						
						//If has silk touch
						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.inventory.getCurrentItem()) > 0)
						{
							//If in end and mining normal obsidian with suit, chance to drop ender
							if (player.world.provider.getDimensionType() == DimensionType.THE_END && NotEnoughCombatMod.RANDOM.nextInt(CHANCE_CONVERT_OBSIDIAN_TO_ENDER.get()) == 0)
							{
								//System.out.println("EO");
								
								e.getDrops().clear();
								e.getDrops().add(new ItemStack(NECBlocks.enderObsidian));
								return; //If we dropped ender, stop everything else
							}
							else if (NotEnoughCombatMod.RANDOM.nextInt(CHANCE_TO_SILK_TOUCH_OBSIDIAN.get()) == 0)
							{
								return; //Do not clear.
							}
						}
						
						//If here, didnt have silk touch... rip obsidian.
					}
				}
				
				//If here, mixed picks with armor sets, can be mining any block at all.
				if(eblockState == LEVEL_OBSIDIAN)
					e.getDrops().clear();
			}
			catch (NullPointerException ignored) { ignored.printStackTrace(); }
		}
	}

	private static boolean checkOreRelationship (Block block, ItemStack itemStack)
	{
		//WEIRD BUT SUPPORTED ORES

		//MC QUARTZ
		//GC DESH tile.mars item.raw_desh
		//GC SAPP tile.basic_block_moon item.lunar_sapphire
		//GC SILIC1 tile.basic_block_core item.basic_item.raw_silicon
		//GC SILIC2 tile.venus item.basic_item.raw_silicon
		//GC SOLARDUST tile.venus item.solar_dust
		//GC QUARTZ tile.venus item.netherquartz
		//GC CHEESE tile.basic_block_moon item.cheese_curd
		//GC ILLEMITE tile.asteroids_block item.shard_titanium

		String blockName = block.getUnlocalizedName().toLowerCase();
		String itemName = itemStack.getUnlocalizedName().toLowerCase();

		boolean isOre = blockName.contains("ore");

		boolean dropsNonOre = !blockName.equals(itemName) && !itemName.contains("ore");

		//System.out.println(blockName + " " + itemName + " " + isOre + " " + dropsNonOre);

		return (isOre && dropsNonOre)
			    || (blockName.equals("tile.netherquartz") 	  && itemName.equals("item.netherquartz")) //MC QUARTZ
				|| (blockName.equals("tile.mars") 			  && itemName.equals("item.raw_desh")) //GC DESH
				|| (blockName.equals("tile.basic_block_moon") && itemName.equals("item.lunar_sapphire")) //GC SAPPHIRE
				|| (blockName.equals("tile.basic_block_core") && itemName.equals("item.basic_item.raw_silicon")) //GC SILIC1
				|| (blockName.equals("tile.venus") 			  && itemName.equals("item.basic_item.raw_silicon")) //GC SILIC2
				|| (blockName.equals("tile.venus")            && itemName.equals("item.solar_dust")) //GC SOLARDUST
				|| (blockName.equals("tile.venus")            && itemName.equals("item.netherquartz")) //GC QUARTZ
				|| (blockName.equals("tile.basic_block_moon") && itemName.equals("item.cheese_curd")) //GC CHEESE
				|| (blockName.equals("tile.asteroids_block")  && itemName.equals("item.shard_titanium"))//GC ILLEMITE
		;
	}
}
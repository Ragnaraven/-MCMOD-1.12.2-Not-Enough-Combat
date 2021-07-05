package io.github.ragnaraven.endgamearmors.items.tools;

import com.google.common.collect.Sets;
import io.github.ragnaraven.endgamearmors.IItemGivenName;
import io.github.ragnaraven.endgamearmors.NECCreativeTabs;
import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import io.github.ragnaraven.endgamearmors.items.NECItems;
import io.github.ragnaraven.endgamearmors.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

import java.util.Set;

/**
 * Created by Andrew on 1/9/2017 at 5:55 PM.
 */
public class NECAxe extends ItemTool implements IItemGivenName, IHasModel
{
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);
	private static final float[] ATTACK_DAMAGES = new float[] {6.0F, 8.0F, 8.0F, 8.0F, 7.0F, 7.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f};
	private static final float[] ATTACK_SPEEDS = new float[] { -3.2F, -3.2F, -3.1F, -3.0F, -3.0F, -3.1F, -3.1F, -3.0F, -3.0F, -3.0F, -3.0F, -3.0F, -3.0F};
	
	private String name;
	
	public NECAxe(ToolMaterial toolMaterial, String name, boolean register)
	{
		super(toolMaterial, EFFECTIVE_ON);
		
		this.name = name;
		this.attackDamage = 8.0f; //ATTACK_DAMAGES[toolMaterial.ordinal()];
		this.attackSpeed = -3.0F; //ATTACK_SPEEDS[toolMaterial.ordinal()];
		
		setCreativeTab(NECCreativeTabs.NECUniversalTab);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		if(register)
			NECItems.ITEMS.add(this);
	}
	
	@Override
	public String getGivenName()
	{
		return name;
	}
	
	@Override
	public void registerModels()
	{
		NotEnoughCombatMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	/*
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state)
	{
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	}
	
	public void registerRepetitiveRecipe ()
	{
		registerRepetitiveRecipe(OreDictionary.getOres("ingot" + name.substring(4, 5).toUpperCase() + name.substring(5)).get(0));
	}
	
	public void registerRepetitiveRecipe (Object buildMaterial)
	{
		RecipeFixer.addShapedRecipe(new ItemStack(this, 1, 0),
				"mm ",
				"ms ",
				" s ",
				'm', buildMaterial, 's', Items.STICK);
	}*/
}

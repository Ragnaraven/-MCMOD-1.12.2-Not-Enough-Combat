package io.github.ragnaraven.endgamearmors.blocks;

import io.github.ragnaraven.endgamearmors.NotEnoughCombatMod;
import io.github.ragnaraven.endgamearmors.items.NECItems;
import io.github.ragnaraven.endgamearmors.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * Created by Andrew on 7/15/2017 at 6:49 PM.
 */
public class BlockBase extends Block implements IHasModel
{
	private String name;
	
	public String getGivenName() { return name; }
	
	public BlockBase(String name, Material material, CreativeTabs tab, float hardness, float resistance, String tool, int harvest)
	{
		this(name, material, tab, hardness, resistance);
		setHarvestLevel(tool, harvest);
	}
	
	public BlockBase(String name, Material material, CreativeTabs tab, float hardness, float resistance, float lightLevel)
	{
		this(name, material, tab, hardness, resistance);
		setLightLevel(lightLevel);
	}
	
	public BlockBase(String name, Material material, CreativeTabs tab, float hardness, float resistance)
	{
		super(material);
		
		this.name = name;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setHardness(hardness);
		setResistance(resistance);
		setCreativeTab(tab);
		
		ItemBlock thisItemBlock = new ItemBlock(this);
		thisItemBlock.setRegistryName(this.getRegistryName()); //Its not, look up 8 lines
		
		NECItems.ITEMS.add(thisItemBlock);
		NECBlocks.BLOCKS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		NotEnoughCombatMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
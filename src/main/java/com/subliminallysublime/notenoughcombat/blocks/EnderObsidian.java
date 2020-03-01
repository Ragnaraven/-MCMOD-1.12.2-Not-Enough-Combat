package com.subliminallysublime.notenoughcombat.blocks;

import com.subliminallysublime.notenoughcombat.particles.ParticleEffects;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by Andrew on 7/15/2017 at 7:09 PM.
 */
public class EnderObsidian extends BlockBase
{
	public static float LIGHT_LEVEL = .27f;
	
	public EnderObsidian(String name, Material material, CreativeTabs tab, float hardness, float resistance, String tool, int harvest)
	{
		super(name, material, tab, hardness, resistance, tool, harvest);
		
		setLightLevel(LIGHT_LEVEL);
		setTickRandomly(true);
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (random.nextInt(3) == 0)
			ParticleEffects.spawnEnderObsidianBlockParticles(world, x, y, z);
	}
}

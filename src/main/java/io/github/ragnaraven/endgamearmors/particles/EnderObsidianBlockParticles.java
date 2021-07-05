package io.github.ragnaraven.endgamearmors.particles;

import net.minecraft.client.particle.ParticleRedstone;
import net.minecraft.world.World;

/**
 * Created by Andrew on 7/17/2017 at 5:31 PM.
 */
public class EnderObsidianBlockParticles extends ParticleRedstone
{
	public EnderObsidianBlockParticles(World parWorld, double parX, double parY, double parZ)
	{
		super(parWorld, parX, parY, parZ, 0,0,0);
		
		float[] color = ParticleEffects.getRandomColor();
		setRBGColorF(color[0], color[1], color[2]);
	}
}
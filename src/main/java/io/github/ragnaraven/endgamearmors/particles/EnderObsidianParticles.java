package io.github.ragnaraven.endgamearmors.particles;

import net.minecraft.client.particle.ParticlePortal;
import net.minecraft.world.World;

/**
 * Created by Andrew on 7/17/2017 at 5:31 PM.
 */
public class EnderObsidianParticles extends ParticlePortal
{
	public EnderObsidianParticles(World parWorld,
	                                  double parX, double parY, double parZ,
	                                  double parMotionX, double parMotionY, double parMotionZ)
	{
		super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
		
		float[] color = ParticleEffects.getRandomColor();
		setRBGColorF(color[0], color[1], color[2]);
	}
}
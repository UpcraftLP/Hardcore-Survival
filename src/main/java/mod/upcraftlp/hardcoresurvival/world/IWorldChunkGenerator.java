package mod.upcraftlp.hardcoresurvival.world;

import java.util.Random;

import net.minecraft.world.World;

public interface IWorldChunkGenerator {

	public void generate(World world, Random random, int blockX, int blockZ);
	
}

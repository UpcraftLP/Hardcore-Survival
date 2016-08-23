package mod.upcraftlp.hardcoresurvival.world;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class HardcoreWorldGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		switch(world.provider.getDimension()) {
		case -1:
			break;
		
		case 0:
			generateOverworld(world, random, blockX, blockZ);
			break;
		
		case 1:
			break;
		
		default:
			break;
		
		}
	}
	
	private void generateOverworld(World world, Random random, int blockX, int blockZ) {
		if(WorldGenRegistry.getGeneratorsOverworld() != null) {
			Iterator<IWorldChunkGenerator> i = WorldGenRegistry.getGeneratorsOverworld().iterator();
			while(i.hasNext()) {
				IWorldChunkGenerator chunkGenerator = i.next();
				chunkGenerator.generate(world, random, blockX, blockZ);
			}
		}
		
	}

}

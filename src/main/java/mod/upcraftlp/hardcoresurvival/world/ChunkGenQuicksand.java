package mod.upcraftlp.hardcoresurvival.world;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ChunkGenQuicksand implements IWorldChunkGenerator {

	private List<Biome> sandBiomes = Arrays.asList(Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.MUTATED_FOREST, Biomes.MUTATED_ROOFED_FOREST, Biomes.ROOFED_FOREST, Biomes.PLAINS, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.DESERT, Biomes.MUTATED_DESERT);
	private int SAND_MIN = 0;
	private int SAND_MAX = 3;
	private WorldGenerator genQuicksand = new WorldGenQuicksand();
	
	@Override
	public void generate(World world, Random random, int blockX, int blockZ) {
		Biome biomeQuickSand = world.getBiomeGenForCoords(new BlockPos(blockX, 64, blockZ));
		if(sandBiomes.contains(biomeQuickSand)) {
			int numSandPits = SAND_MIN + random.nextInt(SAND_MAX - SAND_MIN);
			for(int i = 0; i < numSandPits; i++) {
				int randX = blockX + random.nextInt(16);
				int randZ = blockZ + random.nextInt(16);
				genQuicksand.generate(world, random, new BlockPos(randX, 50, randZ));
			}
		
		
		
		}
	}

}

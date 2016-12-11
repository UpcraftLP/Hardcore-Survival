package mod.upcraftlp.hardcoresurvival.world;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import core.upcraftlp.craftdev.API.world.IWorldChunkGenerator;
import core.upcraftlp.craftdev.API.world.WorldHelper;
import core.upcraftlp.craftdev.common.CoreInternalConfig;
import mod.upcraftlp.hardcoresurvival.Main;
import mod.upcraftlp.hardcoresurvival.init.HardcoreBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
		Biome currentBiome = world.getBiome(new BlockPos(blockX, 64, blockZ));
		if(sandBiomes.contains(currentBiome)) {
			int numSandPits = SAND_MIN + random.nextInt(SAND_MAX - SAND_MIN);
			for(int i = 0; i < numSandPits; i++) {
				int randX = blockX + random.nextInt(16);
				int randZ = blockZ + random.nextInt(16);
				genQuicksand.generate(world, random, new BlockPos(randX, 50, randZ));
			}
		
		
		
		}
	}

	@Override
	public String getName() {
		return "genQuicksand";
	}
	
	public static class WorldGenQuicksand extends WorldGenerator {
		
		private List<Block> sandSoil = Arrays.asList(Blocks.DIRT, Blocks.GRASS, Blocks.GRAVEL);

		@Override
		public boolean generate(World world, Random rand, BlockPos pos) {
			int y = WorldHelper.getGroundFromAbove(world, pos.getX(), pos.getZ(), sandSoil);
			if(y >= pos.getY() && rand.nextInt(100) == 0) {
				if(CoreInternalConfig.isDebugMode) Main.getLogger().println("generating Quicksand at:" + pos.getX() + ", " + y + ", " + pos.getZ());
				int xOffset = pos.getX();
				int zOffset = pos.getZ();
				for(int height = y - (1 + rand.nextInt(2)); height <= y; height++) {
					for(int i = -5; i < 5; i++) {
						int z1 = MathHelper.floor(MathHelper.sqrt(25 - i*i));
						int z2 = -z1;
						
						for(int z = z2; z <= z1; z++) world.setBlockState(new BlockPos(xOffset + i, height, zOffset - z), HardcoreBlocks.QUICKSAND.getDefaultState());
					}
				}
			}
			return false;
		}
	}

}

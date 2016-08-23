package mod.upcraftlp.hardcoresurvival.world;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import mod.upcraftlp.hardcoresurvival.init.HardcoreBlocks;
import mod.upcraftlp.hardcoresurvival.util.WorldHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;




public class WorldGenQuicksand extends WorldGenerator {
	
	private List<Block> sandSoil = Arrays.asList(Blocks.DIRT, Blocks.GRASS, Blocks.GRAVEL);

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int y = WorldHelper.getGroundFromAbove(world, pos.getX(), pos.getZ(), sandSoil);
		if(y >= pos.getY() && rand.nextInt(100) == 0) {
			//debug
			//SysUtils.println("generating at:" + pos.getX() + ", " + y + ", " + pos.getZ());
			int xOffset = pos.getX();
			int zOffset = pos.getZ();
			for(int height = y - (1 + rand.nextInt(2)); height <= y; height++) {
				for(int i = -5; i < 5; i++) {
					int z1 = MathHelper.floor_float(MathHelper.sqrt_float(25 - i*i));
					int z2 = -z1;
					
					for(int z = z2; z <= z1; z++) world.setBlockState(new BlockPos(xOffset + i, height, zOffset - z), HardcoreBlocks.QUICKSAND.getDefaultState());
				}
			}
		}
		return false;
	}
}

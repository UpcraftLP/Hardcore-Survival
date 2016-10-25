package mod.upcraftlp.hardcoresurvival.util;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ClientHandler {

	public static void spawnParticles(EnumParticleTypes particleType, World world, boolean forceSpawn, BlockPos pos, int count, double radius) {
		spawnParticles(particleType, world, forceSpawn, pos.getX(), pos.getY(), pos.getZ(), count, radius);
	}
	
	public static void spawnParticles(EnumParticleTypes particleType, World world, boolean forceSpawn, int x, int y, int z, int count, double radius) {
		FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(world.provider.getDimension()).spawnParticle(particleType, forceSpawn, x, y, z, count, radius, radius, radius, 0.005D);
	}
	
}

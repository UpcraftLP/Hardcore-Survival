package mod.upcraftlp.hardcoresurvival.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockQuicksand extends BasicBlockFalling {

	public BlockQuicksand() {
		super("quicksand");
		this.setHarvestLevel("shovel", 0);
		this.setHardness(0.7f);
		this.setResistance(1.5f);
	}
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}
	
	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}
	
	@Override
	public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return false;
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 1000;
	}
	
	//FIXME: Entities are being pushed out on the sides, so you can only enter it from above
	//see Issue Tracker.
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		entityIn.motionX = 0.0f;
		entityIn.motionZ = 0.0f;
		entityIn.motionY = -0.075f;
		entityIn.setInWeb();
	}

}

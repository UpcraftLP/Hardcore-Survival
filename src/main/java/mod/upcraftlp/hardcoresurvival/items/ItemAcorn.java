package mod.upcraftlp.hardcoresurvival.items;

import core.upcraftlp.craftdev.API.templates.ItemFood;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemAcorn extends ItemFood implements IPlantable {

	public ItemAcorn() {
		super("acorn", 1, 0.7f, false);
		this.setAlwaysEdible();
		this.setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20 * 5, 2), 0.35f);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		 ItemStack itemstack = player.getHeldItem(hand);
	        IBlockState state = worldIn.getBlockState(pos);
	        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
	        {
	            worldIn.setBlockState(pos.up(), Blocks.SAPLING.getDefaultState(), 11);
	            itemstack.shrink(1);
	            return EnumActionResult.SUCCESS;
	        }
	        else
	        {
	            return EnumActionResult.FAIL;
	        }
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return Blocks.SAPLING.getDefaultState();
	}

}

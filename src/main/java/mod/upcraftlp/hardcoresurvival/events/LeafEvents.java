package mod.upcraftlp.hardcoresurvival.events;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import mod.upcraftlp.hardcoresurvival.init.HardcoreItems;
import mod.upcraftlp.hardcoresurvival.init.ModConfig;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LeafEvents {

	public static final PropertyEnum<BlockPlanks.EnumType> VARIANT2 = PropertyEnum.<BlockPlanks.EnumType>create("variant", BlockPlanks.EnumType.class, new Predicate<BlockPlanks.EnumType>()
    {
        public boolean apply(@Nullable BlockPlanks.EnumType p_apply_1_)
        {
            return p_apply_1_.getMetadata() >= 4;
        }
    });
	
	public static final PropertyEnum<BlockPlanks.EnumType> VARIANT = PropertyEnum.<BlockPlanks.EnumType>create("variant", BlockPlanks.EnumType.class, new Predicate<BlockPlanks.EnumType>()
    {
        public boolean apply(@Nullable BlockPlanks.EnumType p_apply_1_)
        {
            return p_apply_1_.getMetadata() < 4;
        }
    });
	
	Random random = new Random();
	private static int stickChance;
	private static int saplingChance;
	private static boolean branches;
	private static boolean extraDrops;
	private static int extraChance;
	
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new LeafEvents());
		stickChance = ModConfig.stickChance;
		saplingChance = ModConfig.saplingChance;
		branches = ModConfig.enableBranches;
		extraDrops = ModConfig.extraDrops;
		extraChance = ModConfig.extraChance;
	}
	
	@SubscribeEvent
	public void onBlockBroken(HarvestDropsEvent event)
	{
		if(event.getHarvester() == null) return;
		event.setDropChance(1.0f);
		if(event.getState().getBlock() instanceof BlockLeaves)
		{
			if(event.getHarvester().getHeldItemMainhand() == null)
			{
				drop(event);				
			}
			else
			{
				if(!(event.getHarvester().getHeldItemMainhand().getItem() instanceof ItemAxe))
				{
					drop(event);
				}				
			}
		}
		
		
	}
	
	public void drop(HarvestDropsEvent event)
	{
		event.getDrops().clear();
		if(branches)
		{
			if(random.nextInt(stickChance) == 0) event.getDrops().add(new ItemStack(HardcoreItems.BRANCH, 1));
		}
		else
		{
			if(random.nextInt(stickChance) == 0) event.getDrops().add(new ItemStack(Items.STICK, 1));
		}
				
		if(random.nextInt(saplingChance) == 0)
		{
			int meta = 0;
			if(event.getState().getBlock() instanceof BlockOldLeaf)
			{
				meta = ((BlockPlanks.EnumType) event.getState().getValue(VARIANT)).getMetadata();
			}
			if(event.getState().getBlock() instanceof BlockNewLeaf)
			{
				meta = ((BlockPlanks.EnumType) event.getState().getValue(VARIANT2)).getMetadata();
			}
			event.getDrops().add(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, meta));
		}
		
		if(extraDrops)
		{
			if(event.getState().getBlock() instanceof BlockOldLeaf)
			{
				switch((BlockPlanks.EnumType) event.getState().getValue(VARIANT))
				{
				case OAK:
					if(random.nextInt(extraChance) == 0) event.getDrops().add(new ItemStack(HardcoreItems.ACORN, 1));
					break;
					
				case SPRUCE:
					if(random.nextInt(extraChance) == 0) event.getDrops().add(new ItemStack(HardcoreItems.PINE_CONE, 1, 0));
					break;
					
				case BIRCH:
					
					break;
					
				case JUNGLE:
					if(random.nextInt(extraChance) == 0) event.getDrops().add(new ItemStack(Items.DYE, 1, 3));
					break;
					
				default: break;
				}
			}
			if(event.getState().getBlock() instanceof BlockNewLeaf)
			{
				switch((BlockPlanks.EnumType) event.getState().getValue(VARIANT2))
				{
				case ACACIA:
					
					break;
					
				case DARK_OAK:
					
					break;
					
				default: break;
				}
			}			
		}
	}
	
	
	
	
	
}

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
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class LeafEvents {
	
	public static final PropertyEnum<BlockPlanks.EnumType> VARIANT2 = PropertyEnum.<BlockPlanks.EnumType>create("variant", BlockPlanks.EnumType.class, new Predicate<BlockPlanks.EnumType>()
    {
        public boolean apply(@Nullable BlockPlanks.EnumType leafType)
        {
            return leafType.getMetadata() >= 4;
        }
    });
	
	public static final PropertyEnum<BlockPlanks.EnumType> VARIANT = PropertyEnum.<BlockPlanks.EnumType>create("variant", BlockPlanks.EnumType.class, new Predicate<BlockPlanks.EnumType>()
    {
        public boolean apply(@Nullable BlockPlanks.EnumType leafType)
        {
            return leafType.getMetadata() < 4;
        }
    });
	
	private static Random random = new Random();
	
	@SubscribeEvent
	public static void onBlockBroken(HarvestDropsEvent event)
	{
		if(event.getHarvester() == null || !event.getWorld().getGameRules().getBoolean("doTileDrops")) return;
		event.setDropChance(1.0f);
		if(event.getState().getBlock() instanceof BlockLeaves)
		{
			if(event.getHarvester().getHeldItemMainhand().equals(ItemStack.EMPTY))
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
	
	public static void drop(HarvestDropsEvent event)
	{
		event.getDrops().clear();
		if(ModConfig.enableBranches)
		{
			if(random.nextInt(ModConfig.stickChance) == 0) event.getDrops().add(new ItemStack(HardcoreItems.BRANCH, 1));
		}
		else
		{
			if(random.nextInt(ModConfig.stickChance) == 0) event.getDrops().add(new ItemStack(Items.STICK, 1));
		}
				
		if(random.nextInt(ModConfig.saplingChance) == 0)
		{
			if(event.getState().getBlock() instanceof BlockOldLeaf)
			{
				int meta = ((BlockPlanks.EnumType) event.getState().getValue(VARIANT)).getMetadata();
				event.getDrops().add(new ItemStack(Blocks.SAPLING, 1, meta));
			}
			else if(event.getState().getBlock() instanceof BlockNewLeaf)
			{
				int meta = ((BlockPlanks.EnumType) event.getState().getValue(VARIANT2)).getMetadata();
				event.getDrops().add(new ItemStack(Blocks.SAPLING, 1, meta));
			}
			else
			event.getDrops().add(new ItemStack(event.getState().getBlock().getItemDropped(event.getState(), random, 0)));
		}
		
		if(ModConfig.extraDrops)
		{
			if(event.getState().getBlock() instanceof BlockOldLeaf)
			{
				switch((BlockPlanks.EnumType) event.getState().getValue(VARIANT))
				{
				case OAK:
					if(random.nextInt(ModConfig.extraChance) == 0) event.getDrops().add(new ItemStack(HardcoreItems.ACORN, 1));
					break;
					
				case SPRUCE:
					if(random.nextInt(ModConfig.extraChance) == 0) event.getDrops().add(new ItemStack(HardcoreItems.PINE_CONE, 1, 0));
					break;
					
				case BIRCH:
					
					break;
					
				case JUNGLE:
					if(random.nextInt(ModConfig.extraChance) == 0) event.getDrops().add(new ItemStack(Items.DYE, 1, 3));
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

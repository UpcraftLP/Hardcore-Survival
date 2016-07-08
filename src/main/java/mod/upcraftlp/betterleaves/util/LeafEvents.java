package mod.upcraftlp.betterleaves.util;

import java.util.Random;

import mod.upcraftlp.betterleaves.init.LeafConfig;
import mod.upcraftlp.betterleaves.init.LeafItems;
import net.minecraft.block.BlockLeaves;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LeafEvents {

	Random random = new Random();
	
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new LeafEvents());
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
		if(LeafConfig.enableBranches)
		{
			if(random.nextInt(LeafConfig.stickChance) == 0) event.getDrops().add(new ItemStack(LeafItems.BRANCH, 1));
		}
		else
		{
			if(random.nextInt(LeafConfig.stickChance) == 0) event.getDrops().add(new ItemStack(Items.STICK, 1));
		}
		if(random.nextInt(LeafConfig.saplingChance) == 0) event.getDrops().add(new ItemStack(event.getState().getBlock().getItemDropped(event.getState(), random, 1)));
	}
	
	
	
	
	
}

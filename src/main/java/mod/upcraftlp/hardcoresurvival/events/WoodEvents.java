package mod.upcraftlp.hardcoresurvival.events;

import mod.upcraftlp.hardcoresurvival.init.ModConfig;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class WoodEvents {

	@SubscribeEvent
	public static void onWoodBroken(HarvestDropsEvent event)
	{
		if(!ModConfig.woodRequiresAxe) return;
		if(event.getHarvester() == null) return;
		if(event.getState().getMaterial() != Material.WOOD) return;
		if(event.getHarvester().getHeldItemMainhand() == null)
		{
			event.setCanceled(true);;
			return;
		}
		
		if(event.getHarvester().getHeldItemMainhand().getItem() instanceof ItemTool)
		{
			ItemTool itemTool = (ItemTool) event.getHarvester().getHeldItemMainhand().getItem();
			if(itemTool.getToolClasses(event.getHarvester().getHeldItemMainhand()).contains("axe") || itemTool instanceof ItemAxe)
			{
				return;
			}
			else
			{
				event.getDrops().clear();
				event.setCanceled(true);
			}
		}
		event.getDrops().clear();
		event.setCanceled(true);
	}
	
	@SubscribeEvent
	public static void slowWoodBreaking(BreakSpeed event)
	{
		if(!ModConfig.woodRequiresAxe) return;
		if(event.getEntityPlayer() == null) return;
		if(event.getState().getMaterial() != Material.WOOD) return;
		if(event.getEntityPlayer().getHeldItemMainhand() == null)
		{
			event.setNewSpeed(event.getOriginalSpeed() * 0.3f);
			return;
		}
		
		if(event.getEntityPlayer().getHeldItemMainhand().getItem() instanceof ItemTool)
		{
			ItemTool itemTool = (ItemTool) event.getEntityPlayer().getHeldItemMainhand().getItem();
			if(itemTool.getToolClasses(event.getEntityPlayer().getHeldItemMainhand()).contains("axe") || itemTool instanceof ItemAxe)
			{
				return;
			}
			else
			{
				event.setNewSpeed(event.getOriginalSpeed() * 0.3f);
			}
		}
		event.setNewSpeed(event.getOriginalSpeed() * 0.3f);
	}

}

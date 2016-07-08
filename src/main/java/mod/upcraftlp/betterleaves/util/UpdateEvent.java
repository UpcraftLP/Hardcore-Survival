package mod.upcraftlp.betterleaves.util;

import com.mojang.realmsclient.gui.ChatFormatting;

import mod.upcraftlp.betterleaves.Reference;
import mod.upcraftlp.betterleaves.init.LeafConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class UpdateEvent {

	public static void init()
	{
		if(LeafConfig.enableUpdateChecker) MinecraftForge.EVENT_BUS.register(new UpdateEvent());
	}
	
private boolean hasShownUpdate = false;
	
	@SubscribeEvent
	public void UpdateCheck(TickEvent.ClientTickEvent event)
	{
		if(ModUpdate.isNewVersionAvailable() && !hasShownUpdate && Minecraft.getMinecraft().currentScreen == null)
		{
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new TextComponentString(ChatFormatting.AQUA + "Update Available to " + Reference.MOD_ID + "!"));
			
			ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, 
		              Reference.UPDATE_URL);
		        Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString("Downlaod version " + ChatFormatting.DARK_AQUA + ModUpdate.latestVersion + ChatFormatting.RESET + " from " + ChatFormatting.BLUE + "here" + ChatFormatting.RESET + ".").setStyle(new Style().setClickEvent(versionCheckChatClickEvent)));
			
			
			hasShownUpdate = true;
		}
	}
	
}

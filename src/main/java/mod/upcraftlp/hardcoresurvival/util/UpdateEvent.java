package mod.upcraftlp.hardcoresurvival.util;

import com.mojang.realmsclient.gui.ChatFormatting;

import mod.upcraftlp.hardcoresurvival.Reference;
import mod.upcraftlp.hardcoresurvival.init.ModConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UpdateEvent {

	public static void init()
	{
		if(ModConfig.enableUpdateChecker) MinecraftForge.EVENT_BUS.register(new UpdateEvent());
	}
	
	private boolean hasShownUpdate = false;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void UpdateCheck(TickEvent.ClientTickEvent event)
	{
		if(ModUpdate.isNewVersionAvailable() && !hasShownUpdate && Minecraft.getMinecraft().currentScreen == null)
		{
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new TextComponentString(ChatFormatting.GOLD + "Update Available for " + Reference.MOD_ID.substring(0, 1).toUpperCase() + Reference.MOD_ID.substring(1) + "!"));
			ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, Reference.UPDATE_URL);
		    Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString("Download version " + ChatFormatting.DARK_AQUA + ModUpdate.getLatest() + ChatFormatting.RESET + " from " + ChatFormatting.BLUE + "here" + ChatFormatting.RESET + ".").setStyle(new Style().setClickEvent(versionCheckChatClickEvent)));
			hasShownUpdate = true;
		}
	}
}

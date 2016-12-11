package mod.upcraftlp.hardcoresurvival.init;

import java.util.Set;

import mod.upcraftlp.hardcoresurvival.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

public class HardcoreConfigGuiFactory implements IModGuiFactory {
	

	@Override
	public void initialize(Minecraft minecraftInstance) { }

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return LuckyConfigGUI.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
		return null;
	}
	
	public static class LuckyConfigGUI extends GuiConfig {
		
		public LuckyConfigGUI(GuiScreen parent) {
		    super(parent, ModConfig.getEntries(),
		        Reference.MODID, false, false, I18n.format("config." + Reference.MODID + ".name"));
		  }
	}
	
}



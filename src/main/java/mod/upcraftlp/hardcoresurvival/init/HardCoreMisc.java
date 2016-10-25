package mod.upcraftlp.hardcoresurvival.init;

import mod.upcraftlp.hardcoresurvival.world.HardcoreWorldGenerator;
import mod.upcraftlp.hardcoresurvival.world.WorldGenRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class HardCoreMisc {

	public static void init() {
		WorldGenRegistry.init();
		GameRegistry.registerWorldGenerator(new HardcoreWorldGenerator(), Integer.MAX_VALUE - 5);
	}
}

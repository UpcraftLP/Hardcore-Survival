package mod.upcraftlp.hardcoresurvival.init;

import java.util.HashMap;
import java.util.Map;

import mod.upcraftlp.hardcoresurvival.blocks.BlockQuicksand;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class HardcoreBlocks {
	
	public static Map<Block, CreativeTabs> blockMap = new HashMap<Block, CreativeTabs>();

	public static Block QUICKSAND = new BlockQuicksand();
	
	public static void init() {
		blockMap.put(QUICKSAND, CreativeTabs.DECORATIONS);
	}
	
}

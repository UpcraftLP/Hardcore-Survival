package mod.upcraftlp.hardcoresurvival.init;

import mod.upcraftlp.hardcoresurvival.blocks.BlockQuicksand;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class HardcoreBlocks {

	public static Block QUICKSAND = new BlockQuicksand();
	
	public static void init() {
		if(ModConfig.enableQuicksand) register(QUICKSAND);
	}
	
	/**
	 * Registers a Block without registering an ItemBlock
	 * @param block
	 */
	private static void register2(Block block) {
		GameRegistry.register(block);
	}
	
	/**
	 * Registers a Block, also registers an ItemBlock
	 * @param block
	 */
	public static void register(Block block) {
		register2(block);
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		itemBlock.setUnlocalizedName(block.getUnlocalizedName().substring(5));
		GameRegistry.register(itemBlock);
	}
	
	public static void registerRenders() {
		if(ModConfig.enableQuicksand) registerBlockRender(QUICKSAND);
	}
	
	public static void registerBlockRender(Block block) {
		HardcoreItems.registerRender(Item.getItemFromBlock(block));
	}
	
}

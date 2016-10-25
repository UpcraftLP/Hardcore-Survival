package mod.upcraftlp.hardcoresurvival.util.templates;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {

	protected Random BLOCK_RANDOM = new Random();
	
	public BasicBlock(String name, Material material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}

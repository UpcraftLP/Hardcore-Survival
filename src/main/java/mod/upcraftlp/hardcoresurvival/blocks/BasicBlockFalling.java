package mod.upcraftlp.hardcoresurvival.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class BasicBlockFalling extends BlockFalling {

	public BasicBlockFalling(String name) {
		this(Material.SAND, name);
	}
	
	public BasicBlockFalling(Material material, String name) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
}

package mod.upcraftlp.hardcoresurvival.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlockFalling extends BlockFalling {

	public BasicBlockFalling(String name) {
		this(Material.SAND, name);
	}
	
	public BasicBlockFalling(Material material, String name) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setDefaultState(this.getDefaultState());
		this.setHardness(0.7f);
		this.setResistance(1.5f);
		this.setLightLevel(15.0f);
		this.setHarvestLevel("axe", 1);
	}
	
}

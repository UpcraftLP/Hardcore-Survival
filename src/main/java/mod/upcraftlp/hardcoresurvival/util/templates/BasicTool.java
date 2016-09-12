package mod.upcraftlp.hardcoresurvival.util.templates;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class BasicTool extends ItemTool {

	protected Set<String> TOOL_CLASSES = Sets.newHashSet(new String[]{});
	
	static Set<Block> effectiveBlocks = Sets.newHashSet(new Block[] {});
	
	public BasicTool(String name, float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn) {
		super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocks);
		this.setFull3D();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return this.TOOL_CLASSES;
	}

}

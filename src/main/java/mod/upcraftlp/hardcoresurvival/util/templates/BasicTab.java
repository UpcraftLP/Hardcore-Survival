package mod.upcraftlp.hardcoresurvival.util.templates;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicTab extends CreativeTabs {

	private Item icon;
	
	public BasicTab(String label, Item icon) {
		super(label + ".name");
		this.icon = icon;
	}
	
	public BasicTab(String label, Block icon) {
		super(label + ".name");
		this.icon = Item.getItemFromBlock(icon);
	}
	
	@Override
	public Item getTabIconItem() {
		return this.icon;
	}

}

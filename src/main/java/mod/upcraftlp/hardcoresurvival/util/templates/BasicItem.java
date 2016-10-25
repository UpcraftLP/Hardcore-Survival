package mod.upcraftlp.hardcoresurvival.util.templates;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BasicItem extends Item {

	private int subItemCount = 0;
	
	public BasicItem(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
	}
	
	public void setSubItems(int count) {
		this.subItemCount = count;
		this.setHasSubtypes(true);
	}
	
	public int getSubItemCount() {
		return this.subItemCount;
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		if(this.getSubItemCount() > 0)
		{
			for(int i = 0; i < this.getSubItemCount(); i++) subItems.add(new ItemStack(this, 1, i));
		}
		else
		{
			super.getSubItems(itemIn, tab, subItems);
		}
	}
}

package mod.upcraftlp.hardcoresurvival.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemPineCone extends ItemFood {

	private String name = "pine_cone";
	
	public ItemPineCone() {
		super(3, 0.3f, false);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String name = super.getUnlocalizedName();
		if(stack.getItemDamage() == 1) name = String.join(".", name, "cooked");
		return name;
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return !oldStack.isItemEqual(newStack);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if(stack.getMetadata() == 1) tooltip.add("Tasty!");
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		subItems.add(new ItemStack(this, 1, 0));
		subItems.add(new ItemStack(this, 1, 1));
	}
	
	
}


package net.mcreator.cobr.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.cobr.itemgroup.CivilisationsofBaedoorItemGroup;
import net.mcreator.cobr.CobrModElements;

@CobrModElements.ModElement.Tag
public class CookedLizardMeatItem extends CobrModElements.ModElement {
	@ObjectHolder("cobr:cooked_lizard_meat")
	public static final Item block = null;
	public CookedLizardMeatItem(CobrModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(CivilisationsofBaedoorItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.1f).meat().build()));
			setRegistryName("cooked_lizard_meat");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 24;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}

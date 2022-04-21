
package net.mcreator.cobr.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.cobr.itemgroup.CivilisationsofBaedoorItemGroup;
import net.mcreator.cobr.CobrModElements;

@CobrModElements.ModElement.Tag
public class CirtainScrapItem extends CobrModElements.ModElement {
	@ObjectHolder("cobr:cirtain_scrap")
	public static final Item block = null;
	public CirtainScrapItem(CobrModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CivilisationsofBaedoorItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE));
			setRegistryName("cirtain_scrap");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}

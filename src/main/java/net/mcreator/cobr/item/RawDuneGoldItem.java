
package net.mcreator.cobr.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.cobr.itemgroup.CivilisationsofBaedoorItemGroup;
import net.mcreator.cobr.CobrModElements;

@CobrModElements.ModElement.Tag
public class RawDuneGoldItem extends CobrModElements.ModElement {
	@ObjectHolder("cobr:raw_dune_gold")
	public static final Item block = null;
	public RawDuneGoldItem(CobrModElements instance) {
		super(instance, 68);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CivilisationsofBaedoorItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("raw_dune_gold");
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


package net.mcreator.cobr.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.cobr.block.DuneTravellerStoneBlock;
import net.mcreator.cobr.CobrModElements;

@CobrModElements.ModElement.Tag
public class CivilisationsofBaedoorItemGroup extends CobrModElements.ModElement {
	public CivilisationsofBaedoorItemGroup(CobrModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcivilisationsof_baedoor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DuneTravellerStoneBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}

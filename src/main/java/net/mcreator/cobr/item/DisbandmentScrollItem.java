
package net.mcreator.cobr.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.Minecraft;
import net.minecraft.block.BlockState;

import net.mcreator.cobr.procedures.DisbandmentSignedProcedure;
import net.mcreator.cobr.procedures.DisbandmentSignageProcedure;
import net.mcreator.cobr.itemgroup.CivilisationsofBaedoorItemGroup;
import net.mcreator.cobr.CobrModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

@CobrModElements.ModElement.Tag
public class DisbandmentScrollItem extends CobrModElements.ModElement {
	@ObjectHolder("cobr:disbandment_scroll")
	public static final Item block = null;
	public DisbandmentScrollItem(CobrModElements instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CivilisationsofBaedoorItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("disbandment_scroll");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (!(DisbandmentSignedProcedure.executeProcedure(ImmutableMap.of("itemstack", itemstack)))) {
				return false;
			}
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Serves as a way to disband the warrior from its leader"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DisbandmentSignageProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}

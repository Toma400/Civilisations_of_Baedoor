
package net.mcreator.cobr.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.state.EnumProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.cobr.itemgroup.CivilisationsofBaedoorItemGroup;
import net.mcreator.cobr.CobrModElements;

import java.util.List;
import java.util.Collections;

@CobrModElements.ModElement.Tag
public class StrippedEsrahLogBlock extends CobrModElements.ModElement {
	@ObjectHolder("cobr:stripped_esrah_log")
	public static final Block block = null;
	public StrippedEsrahLogBlock(CobrModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(CivilisationsofBaedoorItemGroup.tab))
				.setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 2f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.AXE).setRequiresTool());
			this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.Y));
			setRegistryName("stripped_esrah_log");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(AXIS);
		}

		@Override
		public BlockState rotate(BlockState state, Rotation rot) {
			if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
				if ((Direction.Axis) state.get(AXIS) == Direction.Axis.X) {
					return state.with(AXIS, Direction.Axis.Z);
				} else if ((Direction.Axis) state.get(AXIS) == Direction.Axis.Z) {
					return state.with(AXIS, Direction.Axis.X);
				}
			}
			return state;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			Direction.Axis axis = context.getFace().getAxis();;
			return this.getDefaultState().with(AXIS, axis);
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}

package net.mcreator.cobr.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.cobr.block.EoticBambooStemBlock;
import net.mcreator.cobr.block.EoticBambooGrowingBlock;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class EoticBambooVerticalBreakingDownProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure EoticBambooVerticalBreakingDown!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure EoticBambooVerticalBreakingDown!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure EoticBambooVerticalBreakingDown!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure EoticBambooVerticalBreakingDown!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == EoticBambooGrowingBlock.block)
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == EoticBambooStemBlock.block))
				|| ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))
						|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.WATER))))) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
		}
	}
}

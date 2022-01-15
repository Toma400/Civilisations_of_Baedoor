package net.mcreator.cobr.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.cobr.item.EoticBambooItem;
import net.mcreator.cobr.block.EoticBambooStemBlock;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class EoticBambooPlantageProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure EoticBambooPlantage!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure EoticBambooPlantage!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure EoticBambooPlantage!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure EoticBambooPlantage!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure EoticBambooPlantage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.AIR))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
				BlockState _bs = EoticBambooStemBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(EoticBambooItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		} else if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.WATER))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
				BlockState _bs = EoticBambooStemBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(EoticBambooItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (world instanceof World)
				((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) (y + 1), (int) z),
						((World) world).getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).getBlock());
		}
	}
}

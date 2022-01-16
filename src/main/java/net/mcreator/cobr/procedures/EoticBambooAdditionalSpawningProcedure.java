package net.mcreator.cobr.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.FlowingFluidBlock;

import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class EoticBambooAdditionalSpawningProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure EoticBambooAdditionalSpawning!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure EoticBambooAdditionalSpawning!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure EoticBambooAdditionalSpawning!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure EoticBambooAdditionalSpawning!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() instanceof FlowingFluidBlock)
				&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() instanceof FlowingFluidBlock)
						&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.AIR)))
				&& (((BlockTags.getCollection()
						.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
						|| (BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) z))).getBlock())))
						|| ((BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock()))
								|| (BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock())))))) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("cobr", "eotic_bamboo_height3"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + 1), (int) y, (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		if (((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() instanceof FlowingFluidBlock)
				&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() instanceof FlowingFluidBlock)
						&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.AIR)))
				&& (((BlockTags.getCollection()
						.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
						|| (BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) z))).getBlock())))
						|| ((BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock()))
								|| (BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock())))))) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("cobr", "eotic_bamboo_height3"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 1), (int) y, (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() instanceof FlowingFluidBlock)
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() instanceof FlowingFluidBlock)
						&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))))
								.getMaterial() == net.minecraft.block.material.Material.AIR)))
				&& (((BlockTags.getCollection()
						.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock()))
						|| (BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock())))
						|| ((BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
								|| (BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 2)))).getBlock())))))) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("cobr", "eotic_bamboo_height3"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) x, (int) y, (int) (z + 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() instanceof FlowingFluidBlock)
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() instanceof FlowingFluidBlock)
						&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))))
								.getMaterial() == net.minecraft.block.material.Material.AIR)))
				&& (((BlockTags.getCollection()
						.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock()))
						|| (BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock())))
						|| ((BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
								|| (BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:eotic_nearby_growable").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 2)))).getBlock())))))) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("cobr", "eotic_bamboo_height3"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) x, (int) y, (int) (z - 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		if (world instanceof World)
			((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
					((World) world).getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock());
	}
}

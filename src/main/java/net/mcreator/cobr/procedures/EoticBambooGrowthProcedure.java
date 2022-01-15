package net.mcreator.cobr.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.cobr.block.EoticBambooStemBlock;
import net.mcreator.cobr.block.EoticBambooGrowingBlock;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class EoticBambooGrowthProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure EoticBambooGrowth!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure EoticBambooGrowth!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure EoticBambooGrowth!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure EoticBambooGrowth!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
				&& (10 >= (new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "growth_stadium"))))) {
			if ((9 >= (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "growth_stadium")))) {
				if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.SAND)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = EoticBambooStemBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
						BlockState _bs = EoticBambooGrowingBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("growth_stadium", 1);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (world instanceof World)
						((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
								((World) world).getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock());
				} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == EoticBambooStemBlock.block)
						|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == EoticBambooGrowingBlock.block))) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
						BlockState _bs = EoticBambooGrowingBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("growth_stadium", ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "growth_stadium")) + 1));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = Blocks.REDSTONE_TORCH.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
	}
}

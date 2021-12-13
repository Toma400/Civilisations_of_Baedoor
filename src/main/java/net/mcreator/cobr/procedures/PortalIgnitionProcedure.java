package net.mcreator.cobr.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.cobr.block.EmptyTravellerStoneBlock;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class PortalIgnitionProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure PortalIgnition!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure PortalIgnition!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure PortalIgnition!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure PortalIgnition!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "is_portal_activated")) == (false))) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == EmptyTravellerStoneBlock.block)) {
				if ((((world.getBlockState(new BlockPos((int) (x - 4), (int) y, (int) z))).getBlock() == EmptyTravellerStoneBlock.block)
						&& (((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z - 2)))).getBlock() == EmptyTravellerStoneBlock.block)
								&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z + 2))))
										.getBlock() == EmptyTravellerStoneBlock.block)))) {
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;
						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							{
								BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) (z - 1));
								BlockState _bs = Blocks.LAVA.getDefaultState();
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
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;
								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									{
										BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) z);
										BlockState _bs = Blocks.LAVA.getDefaultState();
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
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;
										public void start(IWorld world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											{
												BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) (z + 1));
												BlockState _bs = Blocks.LAVA.getDefaultState();
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
											new Object() {
												private int ticks = 0;
												private float waitTicks;
												private IWorld world;
												public void start(IWorld world, int waitTicks) {
													this.waitTicks = waitTicks;
													MinecraftForge.EVENT_BUS.register(this);
													this.world = world;
												}

												@SubscribeEvent
												public void tick(TickEvent.ServerTickEvent event) {
													if (event.phase == TickEvent.Phase.END) {
														this.ticks += 1;
														if (this.ticks >= this.waitTicks)
															run();
													}
												}

												private void run() {
													{
														BlockPos _bp = new BlockPos((int) (x - 2), (int) y, (int) (z - 1));
														BlockState _bs = Blocks.LAVA.getDefaultState();
														BlockState _bso = world.getBlockState(_bp);
														for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
															Property _property = _bs.getBlock().getStateContainer()
																	.getProperty(entry.getKey().getName());
															if (_property != null && _bs.get(_property) != null)
																try {
																	_bs = _bs.with(_property, (Comparable) entry.getValue());
																} catch (Exception e) {
																}
														}
														world.setBlockState(_bp, _bs, 3);
													}
													new Object() {
														private int ticks = 0;
														private float waitTicks;
														private IWorld world;
														public void start(IWorld world, int waitTicks) {
															this.waitTicks = waitTicks;
															MinecraftForge.EVENT_BUS.register(this);
															this.world = world;
														}

														@SubscribeEvent
														public void tick(TickEvent.ServerTickEvent event) {
															if (event.phase == TickEvent.Phase.END) {
																this.ticks += 1;
																if (this.ticks >= this.waitTicks)
																	run();
															}
														}

														private void run() {
															{
																BlockPos _bp = new BlockPos((int) (x - 2), (int) y, (int) z);
																BlockState _bs = Blocks.LAVA.getDefaultState();
																BlockState _bso = world.getBlockState(_bp);
																for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																	Property _property = _bs.getBlock().getStateContainer()
																			.getProperty(entry.getKey().getName());
																	if (_property != null && _bs.get(_property) != null)
																		try {
																			_bs = _bs.with(_property, (Comparable) entry.getValue());
																		} catch (Exception e) {
																		}
																}
																world.setBlockState(_bp, _bs, 3);
															}
															new Object() {
																private int ticks = 0;
																private float waitTicks;
																private IWorld world;
																public void start(IWorld world, int waitTicks) {
																	this.waitTicks = waitTicks;
																	MinecraftForge.EVENT_BUS.register(this);
																	this.world = world;
																}

																@SubscribeEvent
																public void tick(TickEvent.ServerTickEvent event) {
																	if (event.phase == TickEvent.Phase.END) {
																		this.ticks += 1;
																		if (this.ticks >= this.waitTicks)
																			run();
																	}
																}

																private void run() {
																	{
																		BlockPos _bp = new BlockPos((int) (x - 2), (int) y, (int) (z + 1));
																		BlockState _bs = Blocks.LAVA.getDefaultState();
																		BlockState _bso = world.getBlockState(_bp);
																		for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues()
																				.entrySet()) {
																			Property _property = _bs.getBlock().getStateContainer()
																					.getProperty(entry.getKey().getName());
																			if (_property != null && _bs.get(_property) != null)
																				try {
																					_bs = _bs.with(_property, (Comparable) entry.getValue());
																				} catch (Exception e) {
																				}
																		}
																		world.setBlockState(_bp, _bs, 3);
																	}
																	new Object() {
																		private int ticks = 0;
																		private float waitTicks;
																		private IWorld world;
																		public void start(IWorld world, int waitTicks) {
																			this.waitTicks = waitTicks;
																			MinecraftForge.EVENT_BUS.register(this);
																			this.world = world;
																		}

																		@SubscribeEvent
																		public void tick(TickEvent.ServerTickEvent event) {
																			if (event.phase == TickEvent.Phase.END) {
																				this.ticks += 1;
																				if (this.ticks >= this.waitTicks)
																					run();
																			}
																		}

																		private void run() {
																			{
																				BlockPos _bp = new BlockPos((int) (x - 3), (int) y, (int) (z - 1));
																				BlockState _bs = Blocks.LAVA.getDefaultState();
																				BlockState _bso = world.getBlockState(_bp);
																				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues()
																						.entrySet()) {
																					Property _property = _bs.getBlock().getStateContainer()
																							.getProperty(entry.getKey().getName());
																					if (_property != null && _bs.get(_property) != null)
																						try {
																							_bs = _bs.with(_property, (Comparable) entry.getValue());
																						} catch (Exception e) {
																						}
																				}
																				world.setBlockState(_bp, _bs, 3);
																			}
																			new Object() {
																				private int ticks = 0;
																				private float waitTicks;
																				private IWorld world;
																				public void start(IWorld world, int waitTicks) {
																					this.waitTicks = waitTicks;
																					MinecraftForge.EVENT_BUS.register(this);
																					this.world = world;
																				}

																				@SubscribeEvent
																				public void tick(TickEvent.ServerTickEvent event) {
																					if (event.phase == TickEvent.Phase.END) {
																						this.ticks += 1;
																						if (this.ticks >= this.waitTicks)
																							run();
																					}
																				}

																				private void run() {
																					{
																						BlockPos _bp = new BlockPos((int) (x - 3), (int) y, (int) z);
																						BlockState _bs = Blocks.LAVA.getDefaultState();
																						BlockState _bso = world.getBlockState(_bp);
																						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso
																								.getValues().entrySet()) {
																							Property _property = _bs.getBlock().getStateContainer()
																									.getProperty(entry.getKey().getName());
																							if (_property != null && _bs.get(_property) != null)
																								try {
																									_bs = _bs.with(_property,
																											(Comparable) entry.getValue());
																								} catch (Exception e) {
																								}
																						}
																						world.setBlockState(_bp, _bs, 3);
																					}
																					new Object() {
																						private int ticks = 0;
																						private float waitTicks;
																						private IWorld world;
																						public void start(IWorld world, int waitTicks) {
																							this.waitTicks = waitTicks;
																							MinecraftForge.EVENT_BUS.register(this);
																							this.world = world;
																						}

																						@SubscribeEvent
																						public void tick(TickEvent.ServerTickEvent event) {
																							if (event.phase == TickEvent.Phase.END) {
																								this.ticks += 1;
																								if (this.ticks >= this.waitTicks)
																									run();
																							}
																						}

																						private void run() {
																							{
																								BlockPos _bp = new BlockPos((int) (x - 3), (int) y,
																										(int) (z + 1));
																								BlockState _bs = Blocks.LAVA.getDefaultState();
																								BlockState _bso = world.getBlockState(_bp);
																								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso
																										.getValues().entrySet()) {
																									Property _property = _bs.getBlock()
																											.getStateContainer()
																											.getProperty(entry.getKey().getName());
																									if (_property != null
																											&& _bs.get(_property) != null)
																										try {
																											_bs = _bs.with(_property,
																													(Comparable) entry.getValue());
																										} catch (Exception e) {
																										}
																								}
																								world.setBlockState(_bp, _bs, 3);
																							}
																							if (!world.isRemote()) {
																								BlockPos _bp = new BlockPos((int) x, (int) y,
																										(int) z);
																								TileEntity _tileEntity = world.getTileEntity(_bp);
																								BlockState _bs = world.getBlockState(_bp);
																								if (_tileEntity != null)
																									_tileEntity.getTileData().putBoolean(
																											"is_portal_activated", (true));
																								if (world instanceof World)
																									((World) world).notifyBlockUpdate(_bp, _bs, _bs,
																											3);
																							}
																							if (!world.isRemote()) {
																								BlockPos _bp = new BlockPos((int) (x - 4), (int) y,
																										(int) z);
																								TileEntity _tileEntity = world.getTileEntity(_bp);
																								BlockState _bs = world.getBlockState(_bp);
																								if (_tileEntity != null)
																									_tileEntity.getTileData().putBoolean(
																											"is_portal_activated", (true));
																								if (world instanceof World)
																									((World) world).notifyBlockUpdate(_bp, _bs, _bs,
																											3);
																							}
																							if (!world.isRemote()) {
																								BlockPos _bp = new BlockPos((int) (x - 2), (int) y,
																										(int) (z - 2));
																								TileEntity _tileEntity = world.getTileEntity(_bp);
																								BlockState _bs = world.getBlockState(_bp);
																								if (_tileEntity != null)
																									_tileEntity.getTileData().putBoolean(
																											"is_portal_activated", (true));
																								if (world instanceof World)
																									((World) world).notifyBlockUpdate(_bp, _bs, _bs,
																											3);
																							}
																							if (!world.isRemote()) {
																								BlockPos _bp = new BlockPos((int) (x - 2), (int) y,
																										(int) (z + 2));
																								TileEntity _tileEntity = world.getTileEntity(_bp);
																								BlockState _bs = world.getBlockState(_bp);
																								if (_tileEntity != null)
																									_tileEntity.getTileData().putBoolean(
																											"is_portal_activated", (true));
																								if (world instanceof World)
																									((World) world).notifyBlockUpdate(_bp, _bs, _bs,
																											3);
																							}
																							MinecraftForge.EVENT_BUS.unregister(this);
																						}
																					}.start(world, (int) 10);
																					MinecraftForge.EVENT_BUS.unregister(this);
																				}
																			}.start(world, (int) 10);
																			MinecraftForge.EVENT_BUS.unregister(this);
																		}
																	}.start(world, (int) 10);
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, (int) 10);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 10);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 10);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				}
			}
		}
	}
}

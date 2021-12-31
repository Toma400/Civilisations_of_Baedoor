
package net.mcreator.cobr.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.cobr.world.dimension.DunesDimension;
import net.mcreator.cobr.procedures.PortalIgnitionProcedure;
import net.mcreator.cobr.itemgroup.CivilisationsofBaedoorItemGroup;

import java.util.Map;
import java.util.HashMap;

public class DunesItem extends Item {
	@ObjectHolder("cobr:dunes")
	public static final Item block = null;
	public DunesItem() {
		super(new Item.Properties().group(CivilisationsofBaedoorItemGroup.tab).maxDamage(64));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			boolean success = false;
			if (world.isAirBlock(pos) && true) {
				DunesDimension.portal.portalSpawn(world, pos);
				itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
				success = true;
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				PortalIgnitionProcedure.executeProcedure($_dependencies);
			}
			return ActionResultType.SUCCESS;
		}
	}
}

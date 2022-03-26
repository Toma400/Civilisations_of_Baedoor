package toma400.cobr.elements.blocks.templated;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;

@Mod.EventBusSubscriber(modid = Cobr.MOD_ID)
public class LogBlocks extends RotatedPillarBlock {
    public LogBlocks(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Nullable
    @Override
    //stripping the wood
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player,
                                           ItemStack stack, ToolAction toolAction) {
        if(stack.getItem() instanceof AxeItem) {
            if(state.is(CobrBlocks.ESRAH_LOG.get())) {
                return CobrBlocks.STRIPPED_ESRAH_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(CobrBlocks.ESRAH_WOOD.get())) {
                return CobrBlocks.STRIPPED_ESRAH_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(CobrBlocks.LAIS_LOG.get())) {
                return CobrBlocks.STRIPPED_LAIS_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(CobrBlocks.LAIS_WOOD.get())) {
                return CobrBlocks.STRIPPED_LAIS_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, world, pos, player, stack, toolAction);
    }
}
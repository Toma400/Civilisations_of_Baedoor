package toma400.cobr.elements.blocks.templated;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class FlammableBlocks {

    /*
    Class used for bulk-managing of flammable blocks that have no special properties except for being flammable.
    This way it can be managed easier, since we don't need separate class file for each variant.
     */

    public static class LogBlocks extends RotatedPillarBlock {
        public LogBlocks(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class FlammableStone extends Block {
        public FlammableStone(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 1;
        }
    }
    public static class Planks extends Block {
        public Planks(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Door extends DoorBlock {
        public Door(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Fence extends FenceBlock {
        public Fence(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class FenceGate extends FenceGateBlock {
        public FenceGate(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Slab extends SlabBlock {
        public Slab(Properties p_56359_) {
            super(p_56359_);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Stairs extends StairsBlock {
        public Stairs(Supplier<BlockState> state, Properties properties) {
            super(state, properties);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Trapdoor extends TrapDoorBlock {
        public Trapdoor(Properties p_57526_) {
            super(p_57526_);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Leaves extends LeavesBlock {
        public Leaves(Properties p_54422_) {
            super(p_54422_);
        }
        @Override
        public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
            return 5;
        }
    }
}

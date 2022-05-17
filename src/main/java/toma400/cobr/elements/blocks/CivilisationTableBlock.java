package toma400.cobr.elements.blocks;

import net.minecraft.util.Direction;
import toma400.cobr.elements.blocks.templated.Base;

public class CivilisationTableBlock extends Base.EachSideHorizontalBlock {

    public CivilisationTableBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

}
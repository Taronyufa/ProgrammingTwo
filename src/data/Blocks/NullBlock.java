package data.Blocks;

import data.AbsBlock.AbstractSolidBlock;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public Block smelt(){
        return this;
    }
}

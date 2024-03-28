package data.Blocks;

import data.AbsBlock.AbstractBlock;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;


public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock(){
        this.blockname = "Sand";
        this.content = 'S';
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public Block smelt(){
        Block b = new GlassBlock();
        return b;
    }
}

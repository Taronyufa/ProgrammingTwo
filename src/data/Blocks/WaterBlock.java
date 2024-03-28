package data.Blocks;

import data.AbsBlock.AbstractBlock;


public class WaterBlock extends AbstractBlock {

    public WaterBlock(){
        this.blockname = "Water";
        this.content = 'W';
        this.falls_with_gravity = true;
        this.fall_through = true;
    }
}

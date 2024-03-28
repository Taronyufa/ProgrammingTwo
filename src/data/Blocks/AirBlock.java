package data.Blocks;

import data.AbsBlock.AbstractBlock;

public class AirBlock extends AbstractBlock{
//    private static final boolean DEFAULT_FALL_THROUGH = true;
    // important: only the default is fall_through

    // create a specific block given a random number, unless
    /* public AirBlock(int r){
        super();
        // expect r to be upperbounded at BlockFactory.RAND_UPPERBOUND (5)
        switch (r){
            case 0:
                content = 'X';
                this.falls_with_gravity = true;
                break;
            case 1:
                content = '+';
                this.falls_with_gravity = true;
                break;
            case 2:
                content = 'o';
                this.falls_with_gravity = true;
                break;
            default: // 3, 4, 5, and errors
                content = AirBlock.DEFAULT_CONTENT;
        }
        this.set_fall_through();
    }*/
    // create a specific block 'c' that is stackable and that other blocks do not fall through
    /* public AirBlock(char c){
        super();
        this.content = c;
        this.falls_with_gravity = true;
        this.set_fall_through();
    }*/
    // no parameter: create a default block '.' that does not fall with gravity,
    // but that other blocks fall through
    public AirBlock(){
        this.blockname = "Air";
        this.content = '.';
        this.falls_with_gravity = false;
        this.fall_through = true;
    }

    /* private void set_fall_through(){
        this.fall_through = this.isDefault();
    }

    public boolean isDefault(){
        return this.content == '.';
    }*/
}

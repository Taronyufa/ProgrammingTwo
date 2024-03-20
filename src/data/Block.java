package data;

public class Block {
    private char content;
    private boolean falls_with_gravity;
    private boolean fall_through;

    private static final char DEFAULT_CONTENT = '.';
    private static final boolean DEFAULT_FALLS_WITH_GRAVITY = false;
//    private static final boolean DEFAULT_FALL_THROUGH = true;
    // important: only the default is fall_through

    // create a specific block given a random number, unless
    public Block(int r){
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
                content = Block.DEFAULT_CONTENT;
        }
        this.set_fall_through();
    }
    // create a specific block 'c' that is stackable and that other blocks do not fall through
    public Block(char c){
        super();
        this.content = c;
        this.falls_with_gravity = true;
        this.set_fall_through();
    }
    // no parameter: create a default block '.' that does not fall with gravity,
    // but that other blocks fall through
    public Block(){
        this.content = Block.DEFAULT_CONTENT;
        this.falls_with_gravity = Block.DEFAULT_FALLS_WITH_GRAVITY;
        this.set_fall_through();
    }

    private void set_fall_through(){
        this.fall_through = this.isDefault();
    }
    public char display(){
        return this.content;
    }
    public boolean isFalls_with_gravity(){
        return this.falls_with_gravity;
    }
    public boolean isFall_through(){
        return this.fall_through;
    }
    public boolean isDefault(){
        return this.content == Block.DEFAULT_CONTENT;
    }
}

package data.AbsBlock;

import data.Interfaces.Block;

public abstract class AbstractBlock implements Block {

    protected String blockname;
    protected char content;
    protected boolean falls_with_gravity;
    protected boolean fall_through;



    public char display(){
        return this.content;
    }
    public boolean isFalls_with_gravity(){
        return this.falls_with_gravity;
    }
    public boolean isFall_through(){
        return this.fall_through;
    }

}

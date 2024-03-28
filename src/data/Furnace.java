package data;

import data.Blocks.NullBlock;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class Furnace {
    private SmeltableBlock input;
    private Block output;

    public Furnace(){
        input = new NullBlock();
        output = new NullBlock();
    }

    public void display_on_out(){
        System.out.println("|| "  + this.input.display() + " --> " + this.output.display() + " ||");
    }

    public void smelt(){
        output = input.smelt();
        input = new NullBlock();
    }

    public void setInput(SmeltableBlock b){
        input = b;
        output = b.smelt();
    }

}

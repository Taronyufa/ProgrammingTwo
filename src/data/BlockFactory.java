package data;

import java.util.Random;

public class BlockFactory {
    private static final int RAND_UPPERBOUND = 5;
    public BlockFactory(){}

    // create a random block
    public Block random_block(){
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        return new Block(r);
    }
    // create a default block
    public Block default_block(){
        return new Block();
    }
    // create a fixed block 'A'
    public Block block_to_A(){
        return new Block('A');
    }
    // TODO at some point make Block private and expose its interface
}

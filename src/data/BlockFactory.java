package data;

import data.Blocks.AirBlock;
import data.Blocks.SandBlock;
import data.Blocks.WaterBlock;
import data.Interfaces.Block;

import java.util.Random;

public class BlockFactory {
    private static final int RAND_UPPERBOUND = 3;
    public BlockFactory(){}

    // create a random block
    public Block random_block(){
        Block block;
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        switch (r){
            case 0:
                block = new SandBlock();
                break;
            case 1:
                block = new WaterBlock();
                break;
            default:
                block = new AirBlock();

        }
        return block;
    }
    // create a default block
    /* public AirBlock default_block(){
        return new AirBlock();
    }*/
    // create a fixed block 'A'
    public Block block_to_A(int block){
        switch (block){
            case 1:
                return new SandBlock();
            case 2:
                return new WaterBlock();
            default:
                return new AirBlock();
        }
    }
    // TODO at some point make Block private and expose its interface
}

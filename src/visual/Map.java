package visual;

import data.*;
import data.Blocks.AirBlock;
import data.Blocks.SandBlock;
import data.Blocks.WaterBlock;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

import java.util.Random;

public class Map {
    private static final int DIMENSION_COLUMNS = 10;
    private static final int DIMENSION_ROWS = 5;
    private static final int RANDOM_BLOCKS_TO_ADD = 7;
    private Block[][] content;
    private BlockFactory bf;

    // create a Map, and tell it whether it needs to be made of random blocks or not
    public Map(){
        bf = new BlockFactory();

        content = new Block[DIMENSION_ROWS][DIMENSION_COLUMNS];
        
        Block b;
        for (int i = 0 ; i < DIMENSION_ROWS; i++){
            for (int j = 0 ; j < DIMENSION_COLUMNS; j++){
                b = new AirBlock();
                this.insert_block_at_coords(b,i,j,false);
            }
        }

        addRowsOfWater();
        randCell();

    }

    // getter
    public SmeltableBlock getSmeltable(int row, int col){
        return (SmeltableBlock)this.content[row][col];
    }

    // methods
    public boolean isSmeltable(int row, int col){
        return (this.content[row][col] instanceof SmeltableBlock);
    }

    public void setAir(int row, int col){
        this.content[row][col] = new AirBlock();
        for(int i = 0; i < row; i++){
            if(this.content[i][col].isFalls_with_gravity()){
                this.move(i,col);
            }
        }
    }

    // this is a centralised insertion, to be done at allocation,
    // and in change cell, when we change the insertion policy with stackable
    private void insert_block_at_coords(Block b, int row, int col, boolean consider_stackeble){
        this.content[row][col] = b;
        if (consider_stackeble) {
            this.move(row, col);
        }
    }

    private void move(int row, int col){
        // move_rec(row, col);
        // move_iter_for(row,col);
        move_iter_while(row,col);
        // until row is less than row
        // if the row-col falls with gravity
        // and the row+1-col is fall through
        // swap row-col and row+1-col
    }

    private void move_rec(int row, int col){
        if (row == Map.DIMENSION_ROWS-1){
            return;
        }
        if (!this.content[row][col].isFalls_with_gravity()){
            return;
        }
        if (!this.content[row+1][col].isFall_through()){
            return;
        }
        this.swap(row,col);
        this.move_rec(row+1,col);
    }

    private void move_iter_for(int row, int col){
        if (!this.content[row][col].isFalls_with_gravity()){
            return;
        }
        for (int i = row; i < DIMENSION_ROWS-1 ; i++){
            if (!this.content[i+1][col].isFall_through()){
                break;
            }
            this.swap(i,col);
        }
    }

    private void move_iter_while(int row, int col){
        while (this.content[row][col].isFalls_with_gravity()
                && row+1 < DIMENSION_ROWS
                && this.content[row+1][col].isFall_through()){
            this.swap(row,col);
            row++;
        }
    }

    // precondition: row and col are valid, and so are for the next
    private void swap(int row, int col){
        Block b = this.content[row][col];
        this.content[row][col] = this.content[row+1][col];
        this.content[row+1][col] = b;
    }

    // display the map
    public void display_on_out(){
        System.out.println("______________");
        System.out.println("|============|");
        for (int i = 0 ; i < DIMENSION_ROWS; i++){
            System.out.print("||");
            for (int k = 0 ; k < DIMENSION_COLUMNS; k++){
                System.out.print(this.content[i][k].display());
            }
            System.out.print("||");
            System.out.println();
        }
        System.out.println("|============|");
    }

    // change a cell with a given block
    public void change_cell_with_A(int row, int col, int block){
        if (row >= DIMENSION_ROWS || col >= DIMENSION_COLUMNS){
            return;
        }
        Block b = bf.block_to_A(block);
        this.insert_block_at_coords(b,row,col,true);
    }

    // change a cell with a random block
    public void change_cell_with_random(int row, int col){
        if (row >= DIMENSION_ROWS || col >= DIMENSION_COLUMNS){
            return;
        }
        Block b = bf.random_block();
        this.insert_block_at_coords(b,row,col,true);
    }

    private void randCell(){
        Random rand = new Random();
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = new SandBlock();
            int row = rand.nextInt(DIMENSION_ROWS);
            int col = rand.nextInt(DIMENSION_COLUMNS);
            this.content[row][col] = b;
        }
    }

    public void addRiver(){
        addRowsOfWater();
    }

    public void addSea(){
        for(int i = 0; i < 3; i++){
            addRowsOfWater();
        }
    }

    private void addRowsOfWater(){
        Block water;
        for(int i = 0; i < this.DIMENSION_COLUMNS; i++){
            water = new WaterBlock();
            insert_block_at_coords(water, 0, i, true);
        }
    }
}


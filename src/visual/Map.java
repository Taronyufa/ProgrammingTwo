package visual;

import data.Block;
import data.BlockFactory;

public class Map {
    private static final int DIMENSION_COLUMNS = 10;
    private static final int DIMENSION_ROWS = 5;

    private Block[][] content;
    private BlockFactory bf;

    // the default map is a random one
    public Map(){
        this(true);
    }

    // create a Map, and tell it whether it needs to be made of random blocks or not
    public Map(boolean random){
        content = new Block[DIMENSION_ROWS][DIMENSION_COLUMNS];
        bf = new BlockFactory();
        for (int i = 0 ; i < DIMENSION_ROWS; i++){
            for (int k = 0 ; k < DIMENSION_COLUMNS; k++){
                Block b = null;
                if (random) {
                    b = bf.random_block();
                } else {
                    b = bf.default_block();
                }
                this.insert_block_at_coords(b,i,k,false);
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
//        move_rec(row, col);
//        move_iter_for(row,col);
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
        int indx = row;
        while (this.content[indx][col].isFalls_with_gravity()
                && indx+1 < DIMENSION_ROWS
                && this.content[indx+1][col].isFall_through()){
            this.swap(indx,col);
            indx++;
        }
    }

    // precondition: row and col are valid, and so are for the next
    private void swap(int row, int col){
        Block b = null;
        b = this.content[row][col];
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

    // change a cell with a fixed block 'A'
    public void change_cell_with_A(int row, int col){
        if (row >= DIMENSION_ROWS || col >= DIMENSION_COLUMNS){
            return;
        }
        Block b = bf.block_to_A();
        this.insert_block_at_coords(b,row,col,true);
    }
}
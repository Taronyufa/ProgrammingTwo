package Main;

import visual.Map;

import java.util.Scanner;

public class Main {
    //frico e frice
    private static final int INTERACTIONS = 6;
    private static Map m;

    public static void main(String[] args){
//        change_at_coords();
        test_gravity();
    }

    // ask for user input to change specific coordinates to a block 'A'
    private static void change_at_coords(){
        m = new Map();
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter row: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();

            System.out.print("Enter column: ");
            int col = myObj.nextInt();

            System.out.println("Setting default for: "+row+" - "+col);
            m.change_cell_with_A(row,col);

            m.display_on_out();
        }
    }

    private static void test_gravity(){
        m = new Map(false);
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter column where to drop a block: ");
            Scanner myObj = new Scanner(System.in);
            int col = myObj.nextInt();

            System.out.println("Dropping a new block in column: "+col);
            m.change_cell_with_A(0,col);

            m.display_on_out();
        }
    }
}

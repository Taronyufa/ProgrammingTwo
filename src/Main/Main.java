package Main;

import visual.MainView;

import java.util.Scanner;

public class Main {
    //frico e frice
    private static final int INTERACTIONS = 6;
    private static MainView m;

    public static void main(String[] args){
        // change_at_coords();
        // test_gravity();
        // test_water();
        test_smeltable();
    }

    // ask for user input to change specific coordinates to a block 'A'
    private static void change_at_coords(){
        m = new MainView();
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter row: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();

            System.out.print("Enter column: ");
            int col = myObj.nextInt();

            System.out.println("Setting default for: "+row+" - "+col);
            m.getMap().change_cell_with_random(row,col);


            m.display_on_out();
        }
    }

    private static void test_gravity(){
        m = new MainView();
        m.display_on_out();
        // for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter column where to drop a block: ");
            Scanner myObj = new Scanner(System.in);
            int col = myObj.nextInt();

            System.out.println("Dropping a new block in column: "+col);

            m.getMap().change_cell_with_A(0,col, 1);
            m.display_on_out();

            System.out.println(m.getMap().isSmeltable(4, 3));
        // }
    }

    private static void test_water(){
        m = new MainView();
        m.display_on_out();

    }

    private static void test_smeltable(){
        MainView m = new MainView();
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter row and then column, or enter '9' and then '9' for smelting: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 9 && col == 9){
                m.getFurnace().smelt();
            }else{
                m.move_into_furnace(row, col);
            }
            m.display_on_out();
        }
    }

}

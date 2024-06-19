package visual;

import data.Furnace;
import data.Interfaces.SmeltableBlock;

public class MainView {
    private Map map;
    private Furnace furnace;

    public MainView(){
        map = new Map();
        furnace = new Furnace();
    }

    // toString
    public void display_on_out(){

        System.out.println("Map:");
        map.display_on_out();
        System.out.println("\nFurnace:");
        furnace.display_on_out();
        System.out.println("\n");
    }

    // getter
    public Map getMap() {
        return map;
    }
    public Furnace getFurnace() {
        return furnace;
    }

    // methods
    public void move_into_furnace(int row, int col){
        if(map.isSmeltable(row, col)){
            furnace.setInput(map.getSmeltable(row, col));
            map.setAir(row, col);
        }
    }
}

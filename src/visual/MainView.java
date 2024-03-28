package visual;

import Main.Main;
import data.Furnace;

public class MainView {
    private Map map;
    private Furnace furnace;

    public MainView(){
        map = new Map();
        furnace = new Furnace();
    }

    public void display_on_out(){
        map.display_on_out();
        furnace.display_on_out();
    }

    // getter
    public Map getMap() {
        return map;
    }
    public Furnace getFurnace() {
        return furnace;
    }
}

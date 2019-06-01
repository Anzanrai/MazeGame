package mazegame.entity.utility;

import mazegame.entity.Shield;

import java.util.HashMap;

public class ShieldData {
    private static ShieldData instance;
    private HashMap<String, Shield> shields = new HashMap<String, Shield>();

    private ShieldData(HashMap<String, Shield> theTable){
        shields = theTable;
    }

//    public ShieldData(){
//        createShields();
//    }

    public static ShieldData getInstance(){
        if (instance == null)
            instance = new ShieldData(new HashMap<String, Shield>());
        return instance;
    }

    public void setShield(String label, Shield shield) {
        shields.put(label, shield);
    }

    public Shield getShield(String label) {
        if(shields.containsKey(label)){
            return shields.get(label);
        }
        return null;
    }

    public HashMap getShieldData(){
        return shields;
    }
}

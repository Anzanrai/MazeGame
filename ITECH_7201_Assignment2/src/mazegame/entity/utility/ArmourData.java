package mazegame.entity.utility;

import mazegame.entity.Armour;

import java.util.HashMap;

public class ArmourData {
    private static ArmourData instance;
    private HashMap<String, Armour> armourData = new HashMap<String, Armour>();

//    public ArmourData(){
//        setArmourData();
//    }

    private ArmourData(HashMap<String, Armour> theTable) {
        armourData = theTable;
    }

    public static ArmourData getInstance()   // Notice Singleton
    {
        if (instance == null)
            instance = new ArmourData(new HashMap<String, Armour>());
        return instance;
    }

    public void setArmour(String label, Armour armour) {
        armourData.put(label, armour);
    }

    public Armour getArmour(String label) {
        if(armourData.containsKey(label)){
            return armourData.get(label);
        }
        return null;
    }

    public HashMap getArmourData(){
        return armourData;
    }
}

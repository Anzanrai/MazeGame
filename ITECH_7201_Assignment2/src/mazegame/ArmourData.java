package mazegame;

import mazegame.entity.Armour;

import java.util.HashMap;

public class ArmourData {
    private HashMap<String, Armour> armourData;

    public ArmourData(){
        setArmourData();
    }

    private void setArmourData(){
        String[] labels = new String[]{"Padded", "Leather", "Studded Leather", "Chain Shirt", "Hide", "Scale mail",
                "Chainmail", "Breastplate", "Splint mail", "Banded mail", "Half plate", "Full plate"};
        int[] cost = new int[]{5,10,25,100,15,50,150,200,200,250,600,1500};
        int[] bonuses = new int[]{1,2,3,4,3,4,5,5,6,6,7,8};
        int[] weights = new int[]{10,15,20,25,25,30,40,30,45,35,50,50};

        for(int i=0; i < labels.length; i++){
            Armour armour = new Armour(labels[i], cost[i], weights[i], "", bonuses[i]);
            armourData.put(labels[i], armour);
        }
    }

    public HashMap getArmourData(){
        return armourData;
    }
}

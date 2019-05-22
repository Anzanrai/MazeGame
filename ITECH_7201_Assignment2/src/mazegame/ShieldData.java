package mazegame;

import mazegame.entity.Shield;

import java.util.HashMap;

public class ShieldData {
    private HashMap<String, Shield> shields;

    public ShieldData(){
        createShields();
    }

    private void createShields(){
        String[] labels = new String[]{"Buckler", "Shield Small Wooden", "Shield Small Steel", "Shield Large Wooden",
                "Shield Large Steel"};
        int[] costs = new int[]{15,3,9,7,20};
        int[] bonuses = new int[]{1, 1, 1, 2, 2};
        int[] weight = new int[]{5,5,6,10,15};
        for(int i =0; i< costs.length; i++){
            Shield shield = new Shield(labels[i], costs[i], weight[i], "", bonuses[i]);
            shields.put(labels[i], shield);
        }
    }

    public HashMap getShieldData(){
        return shields;
    }
}

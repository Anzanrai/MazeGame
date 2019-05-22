package mazegame;

import mazegame.entity.Weapon;

import java.util.ArrayList;
import java.util.HashMap;

public class WeaponData {
    private ArrayList<Weapon> weapons;
    private HashMap<String, Weapon> weaponData;

    public WeaponData(){
        createWeaponData();
    }

    public void setWeapons(){
        String[] labels = new String[]{"Dagger", "Nunchaku", "Greatclub", "Longspear", "Handaxe","Throwing axe",
                "Flail Light", "Glaive", "Guisarme", "Sword, short", "Battleaxe", "Halberd", "Ranseur", "Warhammer",
                "Long Sword", "Scimitar", "Trident", "Flail heavy", "Scythe", "Rapier", "Greataxe", "Waraxe, dwarven",
                "Sword Bastard", "Greatsword", "Falcion", "Sword, two bladed"};
        int[] goldPoints = new int[]{1,2,5,5,6,8,8,8,9,10,10,10,10,12,15,15,15,15,18,20,20,30,35,50,75,100};
        String[] damages = new String[]{"1d4", "1d6", "1d10", "1d8","1d6", "1d6","1d8", "1d10","2d4","1d6","1d8","1d10",
                "2d4","1d8","1d8","1d6","1d8","1d10","2d4","1d6","1d12","1d10","1d10","2d6","2d4","2d8"};
        int[] weights = new int[]{2,2,10,9,5,4,5,15,15,3,7,15,15,8,4,4,5,20,12,3,20,15,10,15,16,15};
        for(int i=0; i< labels.length; i++){
            weapons.add(new Weapon(labels[i], goldPoints[i], weights[i], "", damages[i]));
        }
    }

    public void createWeaponData(){
        for(Weapon weapon: weapons){
            weaponData.put(weapon.getLabel(), weapon);
        }
    }

    public HashMap getWeaponData(){
        return weaponData;
    }
}

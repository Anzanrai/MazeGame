package mazegame.entity.utility;

import mazegame.entity.Weapon;

import java.util.HashMap;

public class WeaponData {
    private static WeaponData instance;
//    private ArrayList<Weapon> weapons;
    private HashMap<String, Weapon> weaponData = new HashMap<String, Weapon>();

//    public WeaponData(){
//        createWeaponData();
//    }

    private WeaponData(HashMap<String, Weapon> theTable) {
        weaponData = theTable;
    }

    public static WeaponData getInstance()   // Notice Singleton
    {
        if (instance == null)
            instance = new WeaponData(new HashMap<String, Weapon>());
        return instance;
    }

    public void setWeapon(String label, int value, int weight, String description, String damage) {
        Weapon weapon = new Weapon(label, value, weight, description, damage);
        weaponData.put(label, weapon);
    }

    public Weapon getWeapon(String label) {
        if(weaponData.containsKey(label)){
            return weaponData.get(label);
        }
        return null;
    }

    public HashMap getWeaponData(){
        return weaponData;
    }
}

package mazegame.entity;

import mazegame.ArmourData;
import mazegame.ShieldData;
import mazegame.WeaponData;

import java.util.HashMap;

public class Blacksmith extends Location{
    private HashMap<String, Weapon> weapons;
    public HashMap<String, Armour> armors;
    public HashMap<String, Shield> shields;

    public Blacksmith(WeaponData weaponData, ArmourData armourData, ShieldData shieldData){
        weapons = weaponData.getWeaponData();
        armors = armourData.getArmourData();
        shields = shieldData.getShieldData();
    }
}

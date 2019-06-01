package mazegame.entity;

import mazegame.HardCodedData;
import mazegame.entity.utility.ArmourData;
import mazegame.entity.utility.ShieldData;
import mazegame.entity.utility.WeaponData;

import java.util.HashMap;
import java.util.Iterator;

public class Blacksmith extends Location{
    private WeaponData weaponData;
    private ArmourData armourData;
    private ShieldData shieldData;

    public Blacksmith(String description, String label, NonPlayerCharacter npc){
        super(description, label, npc);
        this.weaponData = WeaponData.getInstance();
        this.shieldData = ShieldData.getInstance();
        this.armourData = ArmourData.getInstance();
    }

    public Blacksmith(String description, String label, NonPlayerCharacter npc, WeaponData weaponData, ArmourData armourData, ShieldData shieldData){
        super(description, label, npc);
        this.weaponData = weaponData;
        this.armourData = armourData;
        this.shieldData = shieldData;
    }

    public WeaponData getWeaponData() {
        return weaponData;
    }

    public void setWeaponData(WeaponData weaponData) {
        this.weaponData = weaponData;
    }

    public ArmourData getArmourData() {
        return armourData;
    }

    public void setArmourData(ArmourData armourData) {
        this.armourData = armourData;
    }

    public ShieldData getShieldData() {
        return shieldData;
    }

    public void setShieldData(ShieldData shieldData) {
        this.shieldData = shieldData;
    }

    public String getItemsToDisplay(){
        String response = "";
        if(HardCodedData.weapons.size() != 0){
            response += "\n\n------Weapons------\n";
            response += String.format("%-25s\t%-10s\t%-10s\t%-10s\n","label", "Price", "Weight", "Damage");
            response += "---------------------------------------------------------\n";
            for(Weapon weapon: HardCodedData.weapons){
                response += weapon.toString()+"\n";
//                System.out.println(weapon.toString());
            }
        }
        if(HardCodedData.armours.size() != 0){
            response += "\n\n------Armours------\n";
            response += String.format("%-25s\t%-10s\t%-10s\t%-10s\n","label", "Price", "Weight", "Bonus");
            response += "---------------------------------------------------------\n";
            for(Armour armour: HardCodedData.armours){
                response += armour.toString()+"\n";
//                System.out.println(armour.toString());
            }
        }
        if(HardCodedData.shields.size() != 0){
            response += "\n\n------Shields------\n";
            response += String.format("%-25s\t%-10s\t%-10s\t%-10s\n","label", "Price", "Weight", "Bonus");
            response += "---------------------------------------------------------\n";
            for(Shield shield: HardCodedData.shields){
                response += shield.toString()+"\n";
//                System.out.println(shield.toString());
            }
        }
        return response;
    }

    public String toString(){
        String response = super.toString();
        response += "\nCare to buy or sell items?\n";
//        System.out.println(response);
//        this.getItemsToDisplay();
        response += this.getItemsToDisplay();
        return response;
    }

}

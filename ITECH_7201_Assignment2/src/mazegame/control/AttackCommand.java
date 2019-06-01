package mazegame.control;

import mazegame.entity.Location;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;
import mazegame.entity.Weapon;
import mazegame.entity.utility.DiceRoller;

public class AttackCommand implements Command {

    private int diceRoll(Player thePlayer){

        Weapon equippedweapon = thePlayer.getEquippedWeapon();
        int attackScore = 0;
        if(equippedweapon != null){
            String weaponDamage = equippedweapon.getDamage();
            String[] damageParts = weaponDamage.split("d");
            DiceRoller diceRoller = new DiceRoller(Integer.parseInt(damageParts[0]), Integer.parseInt(damageParts[1]));
            attackScore = diceRoller.generateAttackScore();
        } else {
            DiceRoller diceRoller = DiceRoller.GetInstance();
            attackScore = diceRoller.generateAttackScore();
        }
        return attackScore;
    }

    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        Location currentLocation = thePlayer.getCurrentLocation();
        NonPlayerCharacter currentNPC = currentLocation.getNpc();

        if(currentNPC.isHostile()){
            // perform attack roll
            int attackScore = diceRoll(thePlayer);
            currentNPC.lessenLifePoints(attackScore);
        }
        return new CommandResponse ("You entered the attack command");
    }
}
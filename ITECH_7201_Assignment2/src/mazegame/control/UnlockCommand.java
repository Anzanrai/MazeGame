package mazegame.control;

import mazegame.entity.*;

public class UnlockCommand implements Command {
    private CommandResponse response;
    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        response = new CommandResponse("");
        Item item = new Item();
//        int itemPrice = 0;
//        int sellingPrice = 0;
        if(input.getArguments().size() == 0){
            response.setMessage("What would you like to equip?");
            return response;
        }
        for(Object argument: input.getArguments()){
            String param = argument.toString();
            if(thePlayer.findItem(param) != null){
                item = thePlayer.findItem(param);
                if(item instanceof Weapon){
                    Weapon weapon = (Weapon) item;
                    thePlayer.equipWeapon(weapon);
                    response.setMessage(weapon.getLabel()+" equipped successfully.");
                }
                if(item instanceof Armour){
                    Armour armour = (Armour) item;
                    thePlayer.equipArmour(armour);
                    response.setMessage(armour.getLabel()+" equipped successfully.");
                }
                if(item instanceof Shield){
                    Shield shield = (Shield) item;
                    thePlayer.equipShield(shield);
                    response.setMessage(shield.getLabel()+" equipped successfully.");
                }
                return response;
            }
        }
        return new CommandResponse ("Cannot find the item to equip.");
    }
}
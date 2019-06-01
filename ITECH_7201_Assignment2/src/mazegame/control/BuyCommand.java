package mazegame.control;

import mazegame.HardCodedData;
import mazegame.entity.*;
import mazegame.entity.utility.ArmourData;
import mazegame.entity.utility.ShieldData;
import mazegame.entity.utility.WeaponData;

public class BuyCommand implements Command {
    private CommandResponse response;

    private CommandResponse buyItem(Item item, Player thePlayer, String itemLabel){
        if(item.getValue() <= thePlayer.getGold()){
            if(thePlayer.addItem(item)){
                response.setMessage(itemLabel+" bought successfully.");
                thePlayer.removeMoney(item.getValue());
            } else {
                response.setMessage(itemLabel+" cannot be bought. Weight limit reached.");
            }
            return response;
        } else{
            response.setMessage("Not enough money");
            return response;
        }
    }

    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        response = new CommandResponse("");
        WeaponData weaponData = HardCodedData.weaponData;
        ArmourData armourData = HardCodedData.armourData;
        ShieldData shieldData = HardCodedData.shieldData;
        Item item = new Item();
        if(input.getArguments().size() == 0){
            response.setMessage("What would you like to buy?");
            return response;
        }
        for(Object argument: input.getArguments()){
            if(weaponData.getWeaponData().containsKey(argument.toString())){
                response.setMessage(String.format("So you want to buy %s", argument.toString()));
                try{
                    item = (Weapon) weaponData.getWeaponData().get(argument.toString());
                    this.buyItem(item, thePlayer, argument.toString());
                } catch (ClassCastException e){
                    e.printStackTrace();
                }

                return response;
            }
            if(armourData.getArmourData().containsKey(argument.toString())){
                response.setMessage(String.format("So you want to buy %s", argument.toString()));
                try {
                    item = (Armour) armourData.getArmourData().get(argument.toString());
                    this.buyItem(item, thePlayer, argument.toString());
                } catch (ClassCastException e){
                    e.printStackTrace();
                }
                return response;
            }
            if(shieldData.getShieldData().containsKey(argument.toString())){
                response.setMessage(String.format("So you want to buy %s", argument.toString()));
                try {
                    item = (Shield) shieldData.getShieldData().get(argument.toString());
                    response = this.buyItem(item, thePlayer, argument.toString());
                } catch (ClassCastException e){
                    e.printStackTrace();
                }
                return response;
            }
        }
        response.setMessage("Item not found to buy");
        return response;
    }
}
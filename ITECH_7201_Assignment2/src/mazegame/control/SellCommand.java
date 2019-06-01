package mazegame.control;

import mazegame.HardCodedData;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.utility.ArmourData;
import mazegame.entity.utility.ShieldData;
import mazegame.entity.utility.WeaponData;

public class SellCommand implements Command {
    private CommandResponse response;
    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        response = new CommandResponse("");
        Item item = new Item();
        int itemPrice = 0;
        int sellingPrice = 0;
        if(input.getArguments().size() == 0){
            response.setMessage("What would you like to sell?");
            return response;
        }
        for(Object argument: input.getArguments()){
            String param = argument.toString();
            if(thePlayer.findItem(param) != null){
                item = thePlayer.findItem(param);
                itemPrice = item.getValue();
                String label = item.getLabel();
                sellingPrice = (int) (itemPrice*0.8);
                thePlayer.addMoney(sellingPrice);
                thePlayer.removeItem(param);
                this.response.setMessage(label+" sold successfully");
                return response;
            }
        }
        return new CommandResponse ("Cannot find the item to sell.");
    }
}
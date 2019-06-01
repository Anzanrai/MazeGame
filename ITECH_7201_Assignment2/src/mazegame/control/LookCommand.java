package mazegame.control;

import mazegame.entity.Exit;
import mazegame.entity.Player;

public class LookCommand implements Command {

    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't find that to look at here!");
        if(userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (Object argument: userInput.getArguments()) {
//            to parse arguments with direction where exit exists.
            if (thePlayer.getCurrentLocation().containsExit(argument.toString())) {
                Exit theExit = thePlayer.getCurrentLocation().getExit((String)argument);
                return new CommandResponse(theExit.getDescription());
            }

            if(argument.equals("items")){
                return new CommandResponse(thePlayer.getInventoryDescription());
            }

            if(argument.equals("status")){
                return new CommandResponse(thePlayer.getPlayerStatus());
            }

            if(argument.equals("npc")){
                if(thePlayer.getCurrentLocation().getNpc() != null){
                    return new CommandResponse(thePlayer.getCurrentLocation().getNpc().displayNPCStat());
                }
                else {
                    return new CommandResponse("No NPC here.");
                }
            }
        }
        return response;
    }
}
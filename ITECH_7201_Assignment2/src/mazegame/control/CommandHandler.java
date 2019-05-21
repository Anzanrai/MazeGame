package mazegame.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import mazegame.entity.Player;

public class CommandHandler {
//    private HashMap<String, Command> availableCommands;
    private CommandState availableCommands;
    private ArrayList<String> commands;
    private Parser theParser;

    public CommandHandler () {
        availableCommands = new MovementState();
//        availableCommands = new HashMap<String, Command>();
//        commands = new ArrayList<String>();
//        setupCommands();
//        theParser = new Parser(popArrayList());
    }

//    private void setupCommands () {
//        availableCommands.put("go", new MoveCommand());
//        availableCommands.put("quit", new QuitCommand());
//        availableCommands.put("move", new MoveCommand());
//        availableCommands.put("look",  new LookCommand());
//    }
//
//    private ArrayList<String> popArrayList () {
//        Set<String> set = availableCommands.keySet();
//        ArrayList <String> temp = new ArrayList<String> ();
//        for (String key : set) {
//            temp.add(key);
//        }
//        return temp;
//    }

    private ParsedInput parse(String userInput) {
        Parser theParser = new Parser(availableCommands.getLabels());
        return theParser.parse(userInput);
    }

    public CommandResponse processTurn (String userInput, Player thePlayer) {
        availableCommands = availableCommands.update(thePlayer);
        ParsedInput validInput = parse(userInput);
        Command theCommand = (Command) availableCommands.getCommand(validInput.getCommand());
        if (theCommand == null) {
            return new CommandResponse("Not a valid command");
        }
        else {
            return theCommand.execute(validInput, thePlayer);
        }
    }
}
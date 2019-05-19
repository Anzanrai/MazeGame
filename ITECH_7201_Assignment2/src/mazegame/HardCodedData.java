package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.Exit;
import mazegame.entity.Location;

public class HardCodedData implements IMazeData {
	private Location startUp;
	
	public HardCodedData()
	{
		createLocations();
	}
	
	public Location getStartingLocation()
	{
		return startUp;
	}
	
	public String getWelcomeMessage()
	{
		return "Welcome to the Mount Helanous";
	}
	
	private void createLocations () 
	{
		startUp = new Location ("A safe haven, but soon to be snatched by dangerous wild creatures",
				"Start Position");
		Location shop1 = new Location ("a shop selling and buying basic weapons and armour", "Shop 1");
		Location lizardBurrow = new Location ("a poisonous lizard burrows here. better avoid the lizard.",
				"Lizard Tail");
		Location pythonTree = new Location ("a open space with a tall tree. avoid the big python living " +
				"in that tree.", "Python's Nest");
		Location poodleMothHole = new Location("A nest for poodle Moth. You would not want to cuddle" +
				" it up. ", "Poodle Moth Hole");
		Location cyclopsDen = new Location("A den where a cyclops shark burrows. Though one eyed, " +
				"this monster has 270 view range. Try to avoid it.", "Cyclops Den");
		Location shop2 = new Location("You can see a shop that sells elixir and advanced weapons and armours",
				"Shop 2");
		Location tigerFishPuddle = new Location("A large puddle where you would not want to step on. " +
				"Venomous tigerfish rules the puddle.", "Tiger Fish Puddle");
		Location lesulaForest = new Location("Home for lesulas. They may attack you. Beware.",
				"Lesula Forest");
		Location hideout = new Location("A safe place to rest, and heal.", "Hideout");
		Location cliffEdge = new Location("A giant hard shelled turtle is in hiding. View is ecstatic, but " +
				"you should not hand around here for long", "Mountain Edge");

		// Connect Locations
		//exits from start location.
		startUp.addExit("north", new Exit("A den where a cyclops shark burrows. Though one eyed, " +
				"this monster has 270 degree view range. Try avoid it.", cyclopsDen));
		startUp.addExit("west", new Exit("you see an open area with small burrow.", lizardBurrow));
		startUp.addExit("east", new Exit("there is a small old hut, smoke is emitting, and metal clancking sound from the hut", shop1));
		startUp.addExit("northeast", new Exit("You see a small puddle", tigerFishPuddle));
//		startUp.addExit("south",  new Exit ("you see an open space to the south", lounge));
//		lounge.addExit("north", new Exit("you see a mound of paper to the north", startUp));

		//exits from lizandBurrow
		lizardBurrow.addExit("north", new Exit("You see a big tree at the centre of open yard. A " +
				"giant demonic python inhabitats the tree.", pythonTree));
		lizardBurrow.addExit("east", new Exit("A safe haven, but soon to be snatched by dangerous " +
				"demonic creatures.", startUp));
		// exits for shop1
		shop1.addExit("west", new Exit("A safe haven, but soon to be snatched by dangerous demonic " +
				"creatures.", startUp));
//
		//exits from pythonTree
		pythonTree.addExit("northwest", new Exit("You see a cute stuffed animal like creature on " +
				"top of rubbles.", poodleMothHole));
		pythonTree.addExit("northeast", new Exit("You see a den. Beware cyclops shark may dwell in." +
				"", cyclopsDen));
		pythonTree.addExit("south", new Exit("you see an open area with small burrow", lizardBurrow));


		//exits from poddleMothHole
		poodleMothHole.addExit("northeast", new Exit("A mountain top. Probably you can see a " +
				"beautiful scenery from there", cliffEdge));
		poodleMothHole.addExit("east", new Exit("You see a den. Beware cyclops shark may dwell in." +
				"", cyclopsDen));
		poodleMothHole.addExit("southeast", new Exit("You see a big tree at the centre of open " +
				"yard. A giant demonic python inhabitats the tree.", pythonTree));


		//exits from cyclopsDen
		cyclopsDen.addExit("west", new Exit("You see a cute stuffed animal like creature on top " +
				"of rubbles", poodleMothHole));
		cyclopsDen.addExit("southwest", new Exit("You see a big tree at the centre of open " +
				"yard. A giant demonic python inhabitats the tree.", pythonTree));
		cyclopsDen.addExit("south", new Exit("A safe haven, but soon to be snatched by dangerous " +
				"demonic creatures.", startUp));
		cyclopsDen.addExit("east", new Exit("Home for lesulas. They may attack you. Beware.",
				lesulaForest));
		cyclopsDen.addExit("northeast", new Exit("You see a safe looking hideout. " +
				"Take time to rest", hideout));
		cyclopsDen.addExit("north", new Exit("A mountain top. Probably you can see a " +
				"beautiful scenery from there", cliffEdge));
		cyclopsDen.addExit("northwest", new Exit("Another small hut emitting dense smoke. " +
				"Clanking sounds are coming from the hut", shop2));


		//exits from shop2
		shop2.addExit("southeast", new Exit("You see a den. Beware cyclops shark may dwell in." +
				"", cyclopsDen));

		//exits from cliffedge
		cliffEdge.addExit("southwest", new Exit("You see a cute stuffed animal like creature on top " +
				"of rubbles", poodleMothHole));
		cliffEdge.addExit("south", new Exit("You see a den. Beware cyclops shark may dwell in." +
				"", cyclopsDen));

		//exits from tigerFishPuddle
		tigerFishPuddle.addExit("southwest", new Exit("A safe haven, but soon to be snatched by dangerous demonic " +
				"creatures.", startUp));
		tigerFishPuddle.addExit("north", new Exit("A forest. Home for lesulas. They may attack you. Beware.",
				lesulaForest));

		// exits from lesulaforest
		lesulaForest.addExit("north", new Exit("You see a safe looking hideout. " +
				"Take time to rest", hideout));
		lesulaForest.addExit("south", new Exit("You see a small puddle", tigerFishPuddle));
		lesulaForest.addExit("west", new Exit("You see a den. Beware cyclops shark may dwell in." +
				"", cyclopsDen));

		//exits from hideout
		hideout.addExit("southwest", new Exit("You see a den. Beware cyclops shark may dwell in." +
				"", cyclopsDen));
		hideout.addExit("south", new Exit("A forest. Home for lesulas. They may attack you. Beware.",
				lesulaForest));
	}
}

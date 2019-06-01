package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.*;
import mazegame.entity.utility.*;

import java.util.ArrayList;

public class HardCodedData implements IMazeData {
    private Location startUp;
    private Location lounge;
    private Location gregsOffice;
    private Location t127;
    private NonPlayerCharacterCollection npcCollection = new NonPlayerCharacterCollection();
    private final String blackSmith = "Bob The BlackSmith";
    private final String lizard = "Lizard";
    private final String giantPython = "Giant Python";
    private final String poodleMoth = "Poodle Moth";
    private final String cyclopsShark = "Cyclops Shark";
    private final String alchemist = "Magnus";
    private final String tigerFish = "Tiger Fish";
    private final String giantLesula = "Giant Lesula";
    private final String giantTurtle = "Giant Turtle";
    public static ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    public static ArrayList<Armour> armours = new ArrayList<Armour>();
    public static ArrayList<Shield> shields = new ArrayList<Shield>();
    public static WeaponData weaponData = WeaponData.getInstance();
    public static ArmourData armourData = ArmourData.getInstance();
    public static ShieldData shieldData = ShieldData.getInstance();

    public HardCodedData()
    {
        populateNonPlayerCharacter();
        createLocations();
        populateWeightLimitTable();
        populateStrengthTable();
        populateAgilityTable();
        populateWeaponData();
        populateArmourData();
        populateShieldData();
    }

    public Location getStartingLocation()
    {
        return startUp;
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Mount Helanous";
    }

    public NonPlayerCharacterCollection getNpcCollection() {
        return this.npcCollection;
    }

    private void createLocations () {
        startUp = new Location ("A safe haven, but soon to be snatched by dangerous wild creatures",
                "Start Position");
        Location shop1 = new Blacksmith ("a shop selling and buying basic weapons and armour", "Shop 1",
                this.npcCollection.get(this.blackSmith), weaponData, armourData, shieldData);
        Location lizardBurrow = new Location ("a poisonous lizard burrows here. better avoid the lizard.",
                "Lizard Tail", this.npcCollection.get(this.lizard));
        Location pythonTree = new Location ("a open space with a tall tree. avoid the big python living " +
                "in that tree.", "Python's Nest", this.npcCollection.get(this.giantPython));
        Location poodleMothHole = new Location("A nest for poodle Moth. You would not want to cuddle" +
                " it up. ", "Poodle Moth Hole", this.npcCollection.get(this.poodleMoth));
        Location cyclopsDen = new Location("A den where a cyclops shark burrows. Though one eyed, " +
                "this monster has 270 view range. Try to avoid it.", "Cyclops Den", this.npcCollection.get(this.cyclopsShark));
        Location shop2 = new Location("You can see a shop that sells elixir and advanced weapons and armours",
                "Shop 2", this.npcCollection.get(this.alchemist));
        Location tigerFishPuddle = new Location("A large puddle where you would not want to step on. " +
                "Venomous tigerfish rules the puddle.", "Tiger Fish Puddle", this.npcCollection.get(this.tigerFish));
        Location lesulaForest = new Location("Home for lesulas. They may attack you. Beware.",
                "Lesula Forest", this.npcCollection.get(this.giantLesula));
        Location hideout = new Location("A safe place to rest, and heal.", "Hideout");
        Location cliffEdge = new Location("A giant hard shelled turtle is in hiding. View is ecstatic, but " +
                "you should not hang around here for long", "Mountain Edge", this.npcCollection.get(this.giantTurtle));

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


    private void populateStrengthTable()    {
        StrengthTable strengthModifiers = StrengthTable.getInstance();
        strengthModifiers.setModifier(1, -5);
        strengthModifiers.setModifier(2, -4);
        strengthModifiers.setModifier(3, -4);
        strengthModifiers.setModifier(4, -3);
        strengthModifiers.setModifier(5, -3);
        strengthModifiers.setModifier(6, -2);
        strengthModifiers.setModifier(7, -2);
        strengthModifiers.setModifier(8, -1);
        strengthModifiers.setModifier(9, -1);
        strengthModifiers.setModifier(10, 0);
        strengthModifiers.setModifier(11, 0);
        strengthModifiers.setModifier(12, 1);
        strengthModifiers.setModifier(13, 1);
        strengthModifiers.setModifier(14, 2);
        strengthModifiers.setModifier(15, 2);
        strengthModifiers.setModifier(16, 3);
        strengthModifiers.setModifier(17, 3);
        strengthModifiers.setModifier(18, 4);
        strengthModifiers.setModifier(19, 4);
        strengthModifiers.setModifier(20, 5);
        strengthModifiers.setModifier(21, 5);
        strengthModifiers.setModifier(22, 5);
        strengthModifiers.setModifier(23, 5);
        strengthModifiers.setModifier(24, 5);
        strengthModifiers.setModifier(25, 5);
        strengthModifiers.setModifier(26, 8);
        strengthModifiers.setModifier(27, 8);
        strengthModifiers.setModifier(28, 8);
        strengthModifiers.setModifier(29, 8);
        strengthModifiers.setModifier(30, 10);
        strengthModifiers.setModifier(31, 10);
        strengthModifiers.setModifier(32, 10);
        strengthModifiers.setModifier(33, 10);
        strengthModifiers.setModifier(34, 10);
        strengthModifiers.setModifier(35, 10);
        strengthModifiers.setModifier(36, 12);
        strengthModifiers.setModifier(37, 12);
        strengthModifiers.setModifier(38, 12);
        strengthModifiers.setModifier(39, 12);
        strengthModifiers.setModifier(40, 12);
        strengthModifiers.setModifier(41, 15);
        strengthModifiers.setModifier(42, 15);
        strengthModifiers.setModifier(43, 15);
        strengthModifiers.setModifier(44, 17);
        strengthModifiers.setModifier(45, 17);
        strengthModifiers.setModifier(46, 18);
    }

    private void populateWeaponData(){
//        WeaponData weaponData = WeaponData.getInstance();
        String[] labels = new String[]{"dagger", "nunchaku", "greatclub", "longspear", "handaxe","throwingaxe",
                "flaillight", "glaive", "guisarme", "swordshort", "battleaxe", "halberd", "ranseur", "warhammer",
                "longsword", "scimitar", "trident", "flailheavy", "scythe", "rapier", "greataxe", "waraxedwarven",
                "swordbastard", "greatsword", "falcion", "swordtwobladed"};
        int[] goldPoints = new int[]{1,2,5,5,6,8,8,8,9,10,10,10,10,12,15,15,15,15,18,20,20,30,35,50,75,100};
        String[] damages = new String[]{"1d4", "1d6", "1d10", "1d8","1d6", "1d6","1d8", "1d10","2d4","1d6","1d8","1d10",
                "2d4","1d8","1d8","1d6","1d8","1d10","2d4","1d6","1d12","1d10","1d10","2d6","2d4","2d8"};
        int[] weights = new int[]{2,2,10,9,5,4,5,15,15,3,7,15,15,8,4,4,5,20,12,3,20,15,10,15,16,15};
        for(int i = 0; i< labels.length; i++){
            Weapon weapon = new Weapon(labels[i], goldPoints[i], weights[i], "", damages[i]);
            weapons.add(weapon);
            weaponData.setWeapon(labels[i], goldPoints[i], weights[i], "", damages[i]);
        }
    }

    public static ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Armour> getArmours() {
        return armours;
    }

    public ArrayList<Shield> getShields() {
        return shields;
    }

    private void populateArmourData(){
        String[] labels = new String[]{"padded", "leather", "studdedleather", "chainshirt", "hide", "scalemail",
                "chainmail", "breastplate", "splintmail", "bandedmail", "halfplate", "fullplate"};
        int[] cost = new int[]{5,10,25,100,15,50,150,200,200,250,600,1500};
        int[] bonuses = new int[]{1,2,3,4,3,4,5,5,6,6,7,8};
        int[] weights = new int[]{10,15,20,25,25,30,40,30,45,35,50,50};

        for(int i=0; i < labels.length; i++){
            Armour armour = new Armour(labels[i], cost[i], weights[i], "", bonuses[i]);
            armours.add(armour);
            armourData.setArmour(labels[i], armour);
        }
    }

    private void populateShieldData(){
//        ShieldData shieldData = ShieldData.getInstance();
        String[] labels = new String[]{"buckler", "shieldsmallwooden", "shieldsmallsteel", "shieldlargewooden",
                "shieldlargesteel"};
        int[] costs = new int[]{15,3,9,7,20};
        int[] bonuses = new int[]{1, 1, 1, 2, 2};
        int[] weight = new int[]{5,5,6,10,15};
        for(int i =0; i< costs.length; i++){
            Shield shield = new Shield(labels[i], costs[i], weight[i], "", bonuses[i]);
            shields.add(shield);
            shieldData.setShield(labels[i], shield);
        }
    }

    private void populateAgilityTable(){
        AgilityTable agilityModifiers = AgilityTable.getInstance();
        agilityModifiers.setModifier(1, -5);
        agilityModifiers.setModifier(2, -5);
        agilityModifiers.setModifier(3, -5);
        agilityModifiers.setModifier(4, -3);
        agilityModifiers.setModifier(5, -3);
        agilityModifiers.setModifier(6, -2);
        agilityModifiers.setModifier(7, -2);
        agilityModifiers.setModifier(8, -1);
        agilityModifiers.setModifier(9, -1);
        agilityModifiers.setModifier(10, 0);
        agilityModifiers.setModifier(11, 0);
        agilityModifiers.setModifier(12, 1);
        agilityModifiers.setModifier(13, 1);
        agilityModifiers.setModifier(14, 2);
        agilityModifiers.setModifier(15, 2);
        agilityModifiers.setModifier(16, 3);
        agilityModifiers.setModifier(17, 3);
        agilityModifiers.setModifier(18, 4);
        agilityModifiers.setModifier(19, 4);
        agilityModifiers.setModifier(20, 6);
        agilityModifiers.setModifier(21, 6);
        agilityModifiers.setModifier(22, 6);
        agilityModifiers.setModifier(23, 6);
        agilityModifiers.setModifier(24, 6);
        agilityModifiers.setModifier(25, 6);
        agilityModifiers.setModifier(26, 8);
        agilityModifiers.setModifier(27, 8);
        agilityModifiers.setModifier(28, 8);
        agilityModifiers.setModifier(29, 8);
        agilityModifiers.setModifier(30, 8);
        agilityModifiers.setModifier(31, 8);
        agilityModifiers.setModifier(32, 11);
        agilityModifiers.setModifier(33, 11);
        agilityModifiers.setModifier(34, 11);
        agilityModifiers.setModifier(35, 11);
        agilityModifiers.setModifier(36, 11);
        agilityModifiers.setModifier(37, 11);
        agilityModifiers.setModifier(38, 13);
        agilityModifiers.setModifier(39, 13);
        agilityModifiers.setModifier(40, 13);
        agilityModifiers.setModifier(41, 13);
        agilityModifiers.setModifier(42, 13);
        agilityModifiers.setModifier(43, 13);
        agilityModifiers.setModifier(44, 15);
        agilityModifiers.setModifier(45, 15);
        agilityModifiers.setModifier(46, 15);
    }

    private void populateWeightLimitTable(){
        WeightLimit weightModifier = WeightLimit.getInstance();
        weightModifier.setModifier(1, 6);
        weightModifier.setModifier(2, 13);
        weightModifier.setModifier(3, 20);
        weightModifier.setModifier(4, 26);
        weightModifier.setModifier(5, 33);
        weightModifier.setModifier(6, 40);
        weightModifier.setModifier(7, 46);
        weightModifier.setModifier(8, 53);
        weightModifier.setModifier(9, 60);
        weightModifier.setModifier(10, 66);
        weightModifier.setModifier(11, 76);
        weightModifier.setModifier(12, 86);
        weightModifier.setModifier(13, 100);
        weightModifier.setModifier(14, 116);
        weightModifier.setModifier(15, 133);
        weightModifier.setModifier(16, 153);
        weightModifier.setModifier(17, 173);
        weightModifier.setModifier(18, 200);
        weightModifier.setModifier(19, 233);
        weightModifier.setModifier(20, 266);
        weightModifier.setModifier(21, 306);
        weightModifier.setModifier(22, 346);
        weightModifier.setModifier(23, 400);
        weightModifier.setModifier(24, 466);
        weightModifier.setModifier(25, 533);
        weightModifier.setModifier(26, 613);
        weightModifier.setModifier(27, 693);
        weightModifier.setModifier(28, 800);
        weightModifier.setModifier(29, 933);
        weightModifier.setModifier(30, 1013);
        weightModifier.setModifier(31, 1093);
        weightModifier.setModifier(32, 1300);
        weightModifier.setModifier(33, 1433);
        weightModifier.setModifier(34, 1513);
        weightModifier.setModifier(35, 1593);
        weightModifier.setModifier(36, 1700);
        weightModifier.setModifier(37, 1833);
        weightModifier.setModifier(38, 1913);
        weightModifier.setModifier(39, 1993);
        weightModifier.setModifier(40, 2100);
        weightModifier.setModifier(41, 2233);
        weightModifier.setModifier(42, 2313);
        weightModifier.setModifier(43, 2393);
        weightModifier.setModifier(44, 2500);
        weightModifier.setModifier(45, 2633);
        weightModifier.setModifier(46, 2713);
    }

    private void populateNonPlayerCharacter(){
        NonPlayerCharacter cyclopsWhale = new NonPlayerCharacter("Cyclops Shark", 5, 100,
                5, true,"whrrrrp whrrrrp");
        NonPlayerCharacter lesulaGiant = new NonPlayerCharacter("Giant Lesula", 10, 150, 5, true, "....  ....");
        NonPlayerCharacter blackSmithOne = new NonPlayerCharacter("Bob The BlackSmith", false, "Want to Buy items or Sell items?");
        NonPlayerCharacter alchemist = new NonPlayerCharacter("Magnus", false, "Buy\nSell");
        NonPlayerCharacter lizard = new NonPlayerCharacter("Lizard", 15, 100, 5, true, ".... ....");
        NonPlayerCharacter python = new NonPlayerCharacter("Giant Python", 5, 500, 20, true, "hissssss....");
        NonPlayerCharacter tigerFish = new NonPlayerCharacter("Tiger Fish", 20, 250, 10, true, "roarrrr...");
        NonPlayerCharacter poodleMoth = new NonPlayerCharacter("Poodle Moth", 15, 200, 10, true, "....");
        NonPlayerCharacter giantTurtle = new NonPlayerCharacter("Giant Turtle", 5, 3000, 50, true, "zzz...");
//        NonPlayerCharacterCollection npcCollection = new NonPlayerCharacterCollection();
        npcCollection.addToCollection(this.cyclopsShark, cyclopsWhale);
        npcCollection.addToCollection(this.giantLesula, lesulaGiant);
        npcCollection.put(this.blackSmith, blackSmithOne);
        npcCollection.put(this.alchemist, alchemist);
        npcCollection.put(this.lizard, lizard);
        npcCollection.put(this.giantPython, python);
        npcCollection.put(this.tigerFish, tigerFish);
        npcCollection.put(this.poodleMoth, poodleMoth);
        npcCollection.put(this.giantTurtle, giantTurtle);

    }
}
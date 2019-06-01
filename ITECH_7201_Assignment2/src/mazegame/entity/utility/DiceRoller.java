package mazegame.entity.utility;

import java.util.ArrayList;
import java.util.Collections;

import mazegame.entity.Dice;

public class DiceRoller {
	private static DiceRoller instance  = new DiceRoller();
	private Dice dice;
	private int diceNum;
	
	private DiceRoller () {
		dice = new Dice (6);
		this.diceNum = 1;
	}

	public DiceRoller (int faces, int diceNum) {
		dice = new Dice (faces);
		this.diceNum = diceNum;
	}

	public static DiceRoller GetInstance () {
		return instance;
	}
	
	public int generateAbilityScore () {
		ArrayList<Integer> results = new ArrayList<Integer> ();
		for (int i = 0; i < 5; i++) {
			results.add(dice.roll());
		}
		
		Collections.sort(results);
		int sum = 0;
		for (int i = 0; i < 2; i++) {
			sum += results.get(i);
		}
		return sum;
	}

	public int getDiceNum(){
		return diceNum;
	}

	public int generateAttackScore(){
		int attackScore = 0;
		for(int i =0; i < this.getDiceNum(); i++){
			attackScore += dice.roll();
		}
		return attackScore;
	}

}

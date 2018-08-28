/**
* A class that represents the 4 dice
* @author Zhonghui(Bill)Liang 3449176
*/

public class Dice {
	
	public int die1;
	public int die2;
	public int die3;
	public int die4;
	
	public Dice(){
		roll();
	}
	
	public int[] roll(){
		die1 = (int)(Math.random()*6 + 1);
		die2 = (int)(Math.random()*6 + 1);
		die3 = (int)(Math.random()*6 + 1);
		die4 = (int)(Math.random()*6 + 1);
		int[]a = {die1,die2,die3,die4};
		return a;
	}
		
}
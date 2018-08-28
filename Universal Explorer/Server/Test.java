import java.util.Scanner;
public class Test{
	public static void main (String []args){
	Board gameBoard = new Board();
	
	System.out.println(gameBoard.getConquered(1));

	gameBoard.setConquered(2);

	System.out.println(gameBoard.getConquered(2));

	PMarker PM1 = new PMarker(2,3,0);

	TMarker TM1 = new TMarker(0,0,0);

	System.out.println(PM1.getColumn());
	
	System.out.println(PM1.getHeight());
	
	System.out.println(PM1.getPosition());

	PM1.setPosition(2);
	
	System.out.println(PM1.getPosition());

	System.out.println("TM1" + TM1.getColumn());

	System.out.println(TM1.getHeight());
	
	System.out.println(TM1.getPosition());
	
	TM1.setColumn(2);
	TM1.setHeight(3);
	TM1.setPosition(1);
	
	System.out.println(TM1.getColumn());

	System.out.println(TM1.getHeight());
	
	System.out.println(TM1.getPosition());




	}


	
}

/*this class represent a Board */
public class Board{
	
	private boolean [] board;

	public Board (){
		board = new boolean [11];
	}
	
	public boolean getConquered(int num){
	if(num < 2 || num > 12){
		throw new IllegalArgumentException("there is no such column");
		}return board[num-2];
	}

	
	public void setConquered(int num){
		board[num-2] = true;
	}
	
	
}

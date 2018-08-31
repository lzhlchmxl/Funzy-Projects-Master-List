
/*this class represents a player */
public class Player{
	/** The name of the player **/
	private String name;
	/** The ID of the player **/		
	private int playerNum;
	/** The number of columns that the player has conquered  **/
	private int conNum;
	/** The numer of the temporary marker that the player has used **/	
	private int tempNum;
	/** The array of the permanent marker of the player  **/
	protected PMarker [] pMA;
	/** The array of the temporary marker of the player  **/
	private TMarker [] tMA;
	/** The boolean indicates whether the player is conquering a column**/		
	private boolean isConquring;
	/** The array of integer to show which column is conquered before stop or crap in this run **/
	private int [] conquer;
	
	private static int playerID = 0;

	private int won;
	private int lost;
	private int pts;

	private String password;

	/** Constructs a new instance by using the parameters for the 
   	 name, playerNum,conNum and tempNumand  of the player.
	@param nameIn The name of the player 
	@param playerNumIn The ID of the player 
	@param conNumIn the conNum of the player 
	@param tempNum the tempNum of the player  **/

	public Player( String nameIn, String passwordIn,int wonIn, int lostIn, int ptsIn, int conNumIn, int tempNumIn){

		name = nameIn;
		
		conNum = conNumIn;
		tempNum = tempNumIn;
	
		password = passwordIn;

		pMA = new PMarker[11];
		tMA = new TMarker[3];
		 conquer = new int [2];

		playerID++;

		playerNum = playerID;

		won = wonIn;
		lost = lostIn;
		pts = ptsIn;
		
		
	}
	/** Method to assgin the player 11 permanent markers and 3 temprary markers **/
	public void assMarker(){
		//for test ,set the height to be small number
		/*pMA[0] = new PMarker(2,2,0);
		pMA[1] = new PMarker(3,3,0);
		pMA[2] = new PMarker(4,3,0);
		pMA[3] = new PMarker(5,4,0);
		pMA[4] = new PMarker(6,4,0);
		pMA[5] = new PMarker(7,4,0);
		pMA[6] = new PMarker(8,3,0);
		pMA[7] = new PMarker(9,3,0);
		pMA[8] = new PMarker(10,2,0);
		pMA[9] = new PMarker(11,2,0);
		pMA[10] = new PMarker(12,2,0); */

		pMA[0] = new PMarker(2,2,0);
		pMA[1] = new PMarker(3,2,0);
		pMA[2] = new PMarker(4,2,0);
		pMA[3] = new PMarker(5,2,0);
		pMA[4] = new PMarker(6,2,0);
		pMA[5] = new PMarker(7,2,0);
		pMA[6] = new PMarker(8,2,0);
		pMA[7] = new PMarker(9,2,0);
		pMA[8] = new PMarker(10,2,0);
		pMA[9] = new PMarker(11,2,0);
		pMA[10] = new PMarker(12,2,0);

		tMA[0]  = new TMarker(0,0,0);
		tMA[1]  = new TMarker(0,0,0);
		tMA[2]  = new TMarker(0,0,0);



		
	
		conquer[0] = 0;
		conquer[1] = 0;
	}
	/** Accessor method for conNum of the player
	@return theconNum of the player **/
	public int getConNum(){

		return conNum;

	}
	/**Method to Check set the conquered columns to be marked in the conquer array. 
	@param num the number of the conquered column**/
	
	public void setCon(int num){
		
		if(conquer[0]==0){
		
			conquer[0]= num;
		}
		else if (conquer[1]==0 ){
			conquer[1]= num;
		}
		conNum ++;
	}
	/**Method to Check set the the conquer array to two 0s. **/
	public void clearCon(){
		
			conquer[0]= 0;
			conquer[1]= 0;
				
	}

	/**Method to Check set the the conquer array to two 0s and set the related PMarkers's top boolean to be false and decrease the conNum when the player is craped **/
	public void crapCon(){

		if (conquer[0]!=0){
			pMA[conquer[0]-2].clearTop();			
			conquer[0]= 0;
			
			conNum--;
		}
		if (conquer[1]!=0){
			pMA[conquer[1]-2].clearTop();	
			conquer[1]= 0;
			conNum--;
		}
	}
	/** Accessor method for the conquer Array 
	@return conquer the conquer array of the player **/	
	public int [] getCon(){

		return conquer;
	
	}
	/**Method to Check whether any two of the four numbers of the dices can form a number that can move 
	@param die the array of four integers of dice
	@return move the boolean that indicates whether the four numbers can form at leat one number that the player can use to move **/
	public boolean checkPossibleMove(int [] die){
		boolean move =false;
		if ((this.checkLegalMove(die[0]+die[1]) == true) ||(this.checkLegalMove(die[0]+die[2]) == true)||(this.checkLegalMove(die[0]+die[3]) == true)||(this.checkLegalMove(die[1]+die[2]) == true)||(	    	this.checkLegalMove(die[1]+die[3]) == true)||(this.checkLegalMove(die[2]+die[3]) == true)){
			move =true;
		}
		return move;
	}
	/**Method to Check whether the two number can be formed from the array of the four numebrs 
	@param num1, the first number the player offers
	@param num2, the second number the player offers
	@param die the array of four integers of dice
	@return legal the boolean that indicates whether the two numbers passed can be formed by the array of the four numbers **/
	public boolean checkLegalNum(int num1,int num2,int [] die){
		boolean legal =false;

		if ((num1 == die[0]+die[1])&& (num2 == die[2]+die[3]) || ((num1 == die[0]+die[2])&& (num2 == die[1]+die[3]) )|| ((num1 == die[0]+die[3]) &&( num2 == die[1]+die[2]))||((num2 == die[0]+die[1])&& (num1 == die[2]+die[3])) || ((num2 == die[0]+die[2])&&( num1 == die[1]+die[3]) )|| ((num2 == die[0]+die[3]) && (num1 == die[1]+die[2]))){

			legal =true;
		}

		return legal;
	}		 

	/**Method to Check whether the number can make a move
	@param num, the number needs to be check whether can move
	@return move the boolean that indicates whether this number can move**/
	public boolean checkLegalMove(int num){
			boolean move = false;
		if ( ((tempNum <3)||(this.checkTM(num)))&& !pMA[num-2].getTop()){
				move = true;
		}
		return move;

		//(tMA[this.findTM(num)].getPosition()!= tMA[this.findTM(num)].getHeight())
	}
	
	/**Method to set the boolean isConquering to false **/
	public void setIsConquring(){
			isConquring = false;
	}
	/**Accessor Method to get the boolean isConquering 
	@return isConquring, boolean isConquering indicates whether a move make a conquer **/
	public boolean getIsConquring(){
			return isConquring;
	}
	
	/**Method to make a move and return whether move successfully 
	@param num, the number of the column to be moved
	@return move the boolean that indicates whether move successfully **/
	public boolean move (int num){
		boolean move = false;
		if (!this.checkLegalMove(num)){
			
		}
	
		else if(this.checkTM(num) && !pMA[num-2].getTop() ) {
			int index = this.findTM(num);
			if(tMA[index].move()){
				isConquring = true;
				this.setCon(num);
				tMA[index].setTop();
				pMA[num-2].setTop();
			}
			move = true;

		}
			
		else{
			 tMA[tempNum].setColumn(num);
		 	tMA[tempNum].setHeight(pMA[num-2].getHeight());
		 	tMA[tempNum].setPosition(pMA[num-2].getPosition()+1);
			 if(tMA[tempNum].getPosition() == tMA[tempNum].getHeight()){
				isConquring = true;
				this.setCon(num);
				tMA[tempNum].setTop();
				pMA[num-2].setTop();
			}
			 tempNum++;
			move = true;
		}
			return move; 
	}
	/**method to check whether there is a temporary marker on the column indicated by the number passed in. 
	@param num, the number of the column to be checked	
	@return check the boolean that indicates there is a temporary marker on the column indicated by the number passed in.  **/
	public boolean checkTM(int num){
		boolean check = false;
		int i = 0;
		while (!check && i<3){
			if(tMA[i].getColumn() == num){
				check = true;
			}
		i++;
		}

		return check;
	}
	/**method to check which temporary marker is on the column indicated by the number passed in. 
	@param num, the number of the column to checked to find the temporary marker
	@return check the boolean that indicates there is a temporary marker on the column indicated by the number passed in.  **/
	public int findTM(int num){
		int column = 0;
		boolean find = false;
		int i = 0;
		while (!find && i<3){
			if(tMA[i].getColumn() == num){
				column = i;
			}
			i++;
		}
		return column;
	}

	/**method to clear all the temporary markers to the initial status after crap or stop.  **/
	public void clear(){
		for(int i= 0;i<3;i++){
			tMA[i].setColumn(0);
			 tMA[i].setHeight(0);
			 tMA[i].setPosition(0);
			 tMA[i].clearTop();

		}
		tempNum = 0;

	}

	/**method to place or move the permanent markers to the new palce advanced by this run of the player.  **/
	public void stop(){

		for(int i= 0;i<3;i++){
			if(tMA[i].getColumn()!=0){
 
				pMA[tMA[i].getColumn()-2].setPosition(tMA[i].getPosition()); 

			}
		}
	}
	/**method to show a list of status of all the permanent markers and temporary markers
	@return status the String shows a list of status of all the permanent markers and temporary markers  **/
	public String getStatus(){
		String status = "\n";
		for(int i=0;i<11;i++){
		  status = status + pMA[i].toString() + "\n";
		}
		status = status +"TM: \n";
		for(int i=0;i<3;i++){
		   status = status + 	tMA[i].toString() +"\n";
		}		
		return status;
	}

	public void setPoints(){
		pts = pts + 100;
	}

	public int getPoints(){
		return pts;
	}

	public String getName(){
		return name;
	}

	public String getPassword(){
		return password;
	}

	public String won(){
		won++;
		pts = pts + 10;
		String stats = "you won\n" + won + ", " + lost + ", " + pts;
		return stats;		
	}
	
	public String lost(){
		lost++;
		pts = pts - 10;
		String stats = "you lost\n" + won + ", " + lost + ", " + pts;
		return stats;		
	}


	public String toString(){
		String string = name + "," + password + "\n" + won + "," + lost+ "," + pts ;
		return string;
	}

	public String leaderString(){
		String string = name +  "," + won + "," + lost+ "," + pts ;
		return string;
	}
}


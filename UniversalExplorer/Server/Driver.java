import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Collections;


//player num has bug
//leaderboard
//test return user

public class Driver {  
   public static void main(String[] args ) throws IOException {  
	
	ArrayList<Player> playerList = new ArrayList<Player>();
	/** The array of integers two store the four numbers of the dice **/
	int[] ints = new int[4]; 
	/** The number of the players **/
	int playerNum = 0;
	/** the index to show which player **/
	int index = 0;
	Player currentPlayer = null;
	/** the nunmber to indicates the state  **/
	int state = -999;
	ServerSocket s = null;
	String msg = "";
	String sss = "";
	String userName = "";
	String password = "";
	
	Dice dice = new Dice();

	//Board board = new Board();

	Player player1 = null;
	Player player2 = null;
	//Player player3 = new Player();
	//Player player4 = new Player();
	/** The array of integers to show which columns are conquered **/
	int [] currentCon;	
	
	



	//read saved file
	BufferedReader br = new BufferedReader(new FileReader("PlayerList.txt"));
	try {
	    	StringBuilder sb = new StringBuilder();
	    	String line ;
		
	    	while ((line = br.readLine()) != null) {
			//sb.append(line);
			//sb.append(System.lineSeparator());
			System.out.println(line);
			//System.out.println(line);
			String[] statsList = line.split(",");
			userName = statsList[0];
			password = statsList[1];
			//scan in the three stats of a player's record
			line = br.readLine();
			System.out.println(line);
			List<Integer> integer=new ArrayList<Integer>();
			String numbers[]=line.split(",");



			// convert three string numbers as integers
			
			for(int i=0; i<numbers.length; i++){
			int num = Integer.parseInt(numbers[i]);
			integer.add(num);			
			}


			int won = integer.get(0);
			int lost = integer.get(1);
			int pts = integer.get(2);
			System.out.println("won: "+won);
			System.out.println("lost: "+lost);
			System.out.println("pts: "+pts);
			//adding the player
			Player player = new Player(userName,password, won, lost, pts,0 ,0);
			playerList.add(player);

			
	    	}
	    	//String everything = sb.toString();
		//System.out.println(everything);
		
		
	} finally {
	   	br.close();
	}








	try{
		s = new ServerSocket(2333);
	}catch (IOException e) {
         	System.err.println("Could not listen on port: 2333. " + e.getMessage());
         	System.exit(-1);
      	}

      	
	
	Socket incoming = null;
	Socket incoming2 = null;
	   
	try {
		incoming = s.accept( );//accept method allow single user to connect thru this port;
			        	 
		incoming2 = s.accept();
		
	
	}catch (IOException e) {
		 	 System.err.println("Accept failed: " + e.getMessage());
			 System.exit(-1);
	}
	      
	
	BufferedReader player1In = null;
	PrintWriter player1Out = null;
	BufferedReader player2In = null;
	PrintWriter player2Out = null;

	while(state != 0){	
	      	try {
			 player1In = new BufferedReader
		         	(new InputStreamReader(incoming.getInputStream()));
	  	  	 player1Out = new PrintWriter
		         	(incoming.getOutputStream(), true );
	 		 player2In = new BufferedReader
		         	(new InputStreamReader(incoming2.getInputStream()));
	  	  	 player2Out = new PrintWriter
		         	(incoming2.getOutputStream(), true );
				
	
			String logState = "";
			String line1 = "";
			String login = "";
			String command = "";
			int validCounter = 3; 
			boolean lostP1 = false;
			boolean lostP2 = false;
			
			//check new/return user
			//state -2 = ready to check password for return user
			//state -3 = new user password store
			//state -1 = game not ready

			//player1 login
			while(state != -2 && state != -3){

				line1 = player1In.readLine();
				if(line1.substring(0,1).equals("N")){
					while(!newUser(line1,playerList)){				
						player1Out.println("err, Duplicate User Name");
						line1 = player1In.readLine();	
					}
					player1Out.println("ack");
					userName = line1.substring(2,line1.length());	
					state = -3;
					
				}else if(line1.substring(0,1).equals("R")){
					while(!returnUser(line1,playerList)){						
						System.out.println(line1);
						player1Out.println("err, Unknown User");
						line1 = player1In.readLine();	
					}
					userName = line1.substring(2,line1.length());	
					player1Out.println("ack");
						System.out.println("lol");
					state = -2;
				}
	
			}
			//enter password
			line1 = player1In.readLine();
			if(state == -3){
				password = line1;
				state = -1;
				player1 = new Player(userName, password,0,0,0, 0, 0);
				playerList.add(player1);
				player1Out.println("ack");		
						
			}
		
			while(state == -2 && validCounter != 0){
				if(validPassword(line1, playerList)){
					password = line1;
					player1Out.println("ack");
					state = -1;
					player1 = assignPlayer(userName, playerList);
					break;
				}else{
					player1Out.println("err, Invalid Password");
					validCounter--;
				}
				if(validCounter == 0){
					player1Out.close();
         				player1In.close();
         				incoming.close();
					lostP1 = true;
					player1In = null;
					player1Out = null;
				}
				line1 = player1In.readLine();			
			}


			//player2 login
			while(state != -2 && state != -3){
				line1 = player2In.readLine();
				if(line1.substring(0,1).equals("N")){
					while(!newUser(line1,playerList)){				
						player2Out.println("err, Duplicate User Name");
						line1 = player2In.readLine();	
					}
					player2Out.println("ack");
					userName = line1.substring(2,line1.length());
					state = -3;
				}else if(line1.substring(0,1).equals("R")){
					while(!returnUser(line1,playerList)){				
						player2Out.println("err, Unknown User");
						line1 = player2In.readLine();	
					}
					userName = line1.substring(2,line1.length());	
					player2Out.println("ack");
					state = -2;
				}
			}
			line1 = player2In.readLine();
		
			if(state == -3){
				password = line1;
				state = -1;
				player2 = new Player(userName, password,0,0,0, 0, 0);	
				playerList.add(player2);
				player2Out.println("ack");
			
			}
		
			while(state == -2 && validCounter != 0){
				if(validPassword(line1, playerList)){
					password = line1;
					System.out.println(password);
					state = -1;
					player2Out.println("ack");
					player2 = assignPlayer(userName, playerList);
					break;
				}else{
					player2Out.println("err, Invalid Password");
					validCounter--;
				}
				if(validCounter == 0){
					player2Out.close();
         				player2In.close();
         				incoming2.close();
					lostP2 = true;
					player2In = null;
					player2Out = null;
				}
				line1 = player2In.readLine();			
			}
		

			if(!lostP1 && !lostP2){
				state = 0;
			}else if (lostP1){
				incoming = null;
			      	try {
					incoming = s.accept( );//accept method allow single user to connect thru this port;
					
			     	}catch (IOException e) {
				 	 System.err.println("Accept failed: " + e.getMessage());
					 System.exit(-1);
			     	}


			}else{
				incoming2 = null;
				try {
					incoming2 = s.accept();
					
	
			     	}catch (IOException e) {
				 	 System.err.println("Accept failed: " + e.getMessage());
					 System.exit(-1);
			     	}


			}


				//exit and leaderboard
				/*}else if(line1.trim().equals("exit")){
					player1Out.close();
				 	player1In.close();
				 	incoming.close();
					//s.close();
					break;
				}else if(line1.trim().equals("lead")){
					player1Out.println(Arrays.toString(showLeaders()));
				}*/
			

		
			

		}catch (IOException e) {
		 	System.err.println("Unable to read from or write to the client: "
			                    + e.getMessage());
	      	}		
	}




	try {
		//game starting
		state = 0;

		player1.assMarker();
		player2.assMarker();

		boolean done = false;
		boolean player1Active = true;
		boolean player2Active = false;		
		boolean areInts = false;
		boolean canRoll = true;	
		boolean canRoll1 = true;
		boolean canRoll2 = true;
		boolean again = true;	
		boolean skip = false;

		player1Out.println("1");
		player2Out.println("2");
	
				
		//break when the game is completed
		while (!done){
			//incase if P2 has won the game, the server skips P1's input request and jump to the end.
			if(!skip){
				//break when the user can't roll anymore
				while (canRoll){
					again = true;
					//check if user can roll. If so, roll the dice and return the numbers as an array.
					msg = player1In.readLine();
					System.out.println(msg);
					if(msg.trim().equals("roll") && (state == 0 || state == 2 || state == 3 || state == 4) && player1Active && canRoll){
						int[] a = dice.roll();
						player1Out.println( Arrays.toString(a));
						player2Out.println( Arrays.toString(a));
						state = 1;
						ints = a;
						System.out.println(Arrays.toString(ints));

				
				
					
					//try{	
						while(again){
							//read in user input, if it is crap, jump to crap function. Other wise check if they are 2 integers and copy them in an array
							 sss = player1In.readLine();
							if(!sss.trim().equals("crap")){
								List<Integer> integer=new ArrayList<Integer>();
								String numbers[]=sss.split(",");
								for(String part:numbers){
			    						if(part.contains("-")){
			       							int aa=Integer.parseInt(part.split("-")[0]);
										int b=Integer.parseInt(part.split("-")[1]);
										while(aa<=b){
				     							integer.add(aa++);
										}
			    						}else{
										integer.add(Integer.parseInt(part));
			    						}
								}

								areInts = true;
							
				
						//can move?	//check if the inputs are legal 
								if(areInts && state ==1 && player1Active && (player1.checkLegalNum(integer.get(0),integer.get(1), a ))){
									again = false;	
									if(player1.move(integer.get(0))){
										if(player1.getIsConquring()){
											//board.setConquered(integer.get(0));
											player1.setIsConquring();
											if(player1.getConNum() == 3){
												state = 5;
												player1Out.println(player1.won());
												player2Out.println(player2.lost());
												player1Out.println(showLeaders(playerList));
												player2Out.println(showLeaders(playerList));
												done = true;
												canRoll1 = false;
												canRoll2 = false;
												canRoll = false;
												skip = true;
												again = false;
											}
										}
									}else {
										state = 2;
										canRoll1 = false;	
									}
									if(!(integer.get(0)==integer.get(1))){
								 		if(player1.move(integer.get(1))){
											if(player1.getIsConquring()){
												//board.setConquered(integer.get(1));
												player1.setIsConquring();
												if(player1.getConNum() == 3){
													state = 5;
													player1Out.println(player1.won());
													player2Out.println(player2.lost());
													player1Out.println(showLeaders(playerList));
													player2Out.println(showLeaders(playerList));
													done = true;
													canRoll1 = false;
													canRoll2 = false;
													canRoll = false;
													skip = true;
													again = false;
												}
											}
						
										}else{
											canRoll2 = false;
										}
									}					
									if(canRoll1 || canRoll2){
										canRoll = true;
										state = 2;	
										player1Out.println("ack");
										player2Out.println(integer.get(0)+ "," +integer.get(1));
										again = false;
									}else{
										canRoll = false; 
										
									}
								}else if(areInts && state ==1 && player1Active && (!player1.checkLegalNum(integer.get(0),integer.get(1), a ))){
									player1Out.println("err");	
									again = true;	
									
								}
	


					
								System.out.println(player1.getStatus());
								System.out.println(player1.getConNum());	

						//can crap?
							}else if(sss.trim().equals("crap") && state == 1 && player1Active && !player1.checkPossibleMove(ints)){				
								player1.clear(); //!!!
								player1.crapCon();	//!!!				
								player1Active = false;
								player2Active = true;
								player1Out.println("ack" );
								player2Out.println("go" );
								state = 4;
								canRoll = false;
								again = false;	
							}
						}
					
					}else if(msg.trim().equals("stop") && state == 2 && player1Active){
						player1.stop();
						// get which columns are conquered in one turn of the player
						currentCon = player1.getCon();
						// if the first number is not 0, that column is conqured. 
						if (currentCon[0]!= 0){
							//board.setConquered(currentCon[0]-2);
							//set the related column of the other player to be caonquered status
							player2.pMA[currentCon[0]-2].setTop();
						}
						if (currentCon[1]!= 0){
			 				//board.setConquered(currentCon[1]-2);
							player2.pMA[currentCon[1]-2].setTop();
						}
						
						player1.clearCon();
						player1.clear();					
						player1Active = false;
						player2Active = true;
						player1Out.println("ack" );
						player2Out.println("go" );
						state = 3;
						canRoll = false;
					}

				}

			}

				//can stop?
			
				
			if(!skip){
				canRoll = true;	
		
				while (canRoll){
			
					again = true;

					msg = player2In.readLine();
			
					if(msg.trim().equals("roll") && (state == 0 || state == 2 || state == 3 || state == 4) && player2Active && canRoll){
				
						int[] a = dice.roll();
						player1Out.println( Arrays.toString(a));
						player2Out.println( Arrays.toString(a));
						state = 1;
						ints = a;

				
				
					//input 2 numbers?
					//try{	
						while(again){
							 sss = player2In.readLine();
							if(!sss.trim().equals("crap")){
								List<Integer> integer=new ArrayList<Integer>();
								String numbers[]=sss.split(",");
								for(String part:numbers){
			    						if(part.contains("-")){
			       							int aa=Integer.parseInt(part.split("-")[0]);
										int b=Integer.parseInt(part.split("-")[1]);
										while(aa<=b){
				     							integer.add(aa++);
										}
			    						}else{
										integer.add(Integer.parseInt(part));
			    						}
								}

							areInts = true;
							//player1Out.println(integer.get(0)+","+integer.get(1)+","+ a );
						//}
						//catch(InputMismatchException exception){
		  					//System.out.println("This is not an integer");
						//}
				
						//can move?
								if(areInts && state ==1 && player2Active && (player2.checkLegalNum(integer.get(0),integer.get(1), a ))){	
									if(player2.move(integer.get(0))){
										if(player2.getIsConquring()){
											//board.setConquered(integer.get(0));
											player2.setIsConquring();
											if(player2.getConNum() == 3){
												state = 5;
												player2Out.println(player2.won());
												player1Out.println(player1.lost());
												player1Out.println(showLeaders(playerList));
												player2Out.println(showLeaders(playerList));
												done = true;
												canRoll1 = false;
												canRoll2 = false;
												canRoll = false;
												skip = true;
												again = false;
											}
										}
									}else {
										state = 2;
										canRoll1 = false;	
									}
									if(!(integer.get(0)==integer.get(1))){
								 		if(player2.move(integer.get(1))){
											if(player2.getIsConquring()){
												//board.setConquered(integer.get(1));
												player2.setIsConquring();
												if(player2.getConNum() == 3){
													state = 5;
													player2Out.println(player2.won());
													player1Out.println(player1.lost());
													player1Out.println(showLeaders(playerList));
													player2Out.println(showLeaders(playerList));
													done = true;
													canRoll1 = false;
													canRoll2 = false;
													canRoll = false;
													skip = true;
													again = false;
												}
											}
						
										}else{
											canRoll2 = false;
										}
									}					
									if(canRoll1 || canRoll2){
										canRoll = true;
										state = 2;	
										player2Out.println("ack");
										player1Out.println(integer.get(0)+ "," +integer.get(1));
										again = false;
									}else{
										canRoll = false;
										
									}
								}else if(areInts && state ==1 && player2Active && (!player2.checkLegalNum(integer.get(0),integer.get(1), a ))){
										player2Out.println("err");	
										again = true;	
									
								}
					
								System.out.println(player2.getStatus());
								System.out.println(player2.getConNum());	
	

						//can crap?
							}else if(sss.trim().equals("crap") && state == 1 && player2Active && !player2.checkPossibleMove(ints)){			
								player2.clear();
								player2.crapCon();										
								player2Active = false;
								player1Active = true;
								player2Out.println("ack" );
								player1Out.println("go" );
								state = 4;
								canRoll = false;
								again = false;
							}

						}
					
					}else if(msg.trim().equals("stop") && state == 2 && player2Active){
					
						player2.stop();
						// get which columns are conquered in one turn of the player
						currentCon = player2.getCon();
						// if the first number is not 0, that column is conqured. 
						if (currentCon[0]!= 0){
							//board.setConquered(currentCon[0]-2);
							//set the related column of the other player to be caonquered status
							player1.pMA[currentCon[0]-2].setTop();
						}
						if (currentCon[1]!= 0){
			 				//board.setConquered(currentCon[1]-2);
							player1.pMA[currentCon[1]-2].setTop();
						}
						player2.clearCon();
						player2.clear();
						player2Active = false;
						player1Active = true;
						player2Out.println("ack" );
						player1Out.println("go" );
						state = 3;
						canRoll = false;
					
					}
				}	
			}
      		}
	}
      	catch (IOException e) {
         	System.err.println("Unable to read from or write to the client: "
        	                    + e.getMessage());
      	}


	try{
		PrintWriter writer = new PrintWriter("PlayerList.txt", "UTF-8");
		for(int i = 0; i < playerList.size();i++){
			writer.println(playerList.get(i).toString());
		}	
		writer.close();
	}catch(IOException e){
		System.err.println("Unable to output data file: " + e.getMessage());
	}	


      	try {
		
         	player1Out.close();
         	player1In.close();
		player2Out.close();
         	player2In.close();
         	incoming.close();
		incoming2.close();
         	s.close();
		
      	}
      	catch (IOException e) {
         	System.err.println("Unable to close writer, reader, or socket: "
                           	 + e.getMessage());
      	}
   }


	static boolean newUser(String line1,ArrayList<Player> playerList) {
		boolean boo = false;		
		if(line1.substring(0,1).equals("N") && (playerList == null || !duplicate(line1.substring(2,line1.length()),playerList))){
			boo = true;			
		}
		return boo;
	}

	static boolean returnUser(String line1,ArrayList<Player> playerList){
		boolean boo = false;		
		if(line1.substring(0,1).equals("R") &&  duplicate(line1.substring(2,line1.length()),playerList)){
			boo = true;			
		}
		return boo;
	}




	static boolean duplicate(String name, ArrayList<Player> list){
		boolean boo = false;	
		for(int i = 0; i < list.size();i++){
			if(name.equals(list.get(i).getName())){
				boo = true;
			}
		}
		return boo;	
	}

	static boolean validPassword(String password, ArrayList<Player> list){
		boolean boo = false;
		for(int i = 0; i < list.size();i++){
			if(password.equals(list.get(i).getPassword())){
				boo = true;
			}
		}
		return boo;	

	}
	
	static Player assignPlayer(String name, ArrayList<Player> list){
		Player player=null;
		for(int i= 0; i< list.size();i++){
			if(name.equals(list.get(i).getName())){
				player = list.get(i);
				break;		
			}
		}
		return player;
	}

	static String showLeaders(ArrayList<Player> list){
		
		String string = "";
		ArrayList<Integer> pts = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {
  			pts.add(list.get(i).getPoints());
		}
	
		Collections.sort(pts);
    		Collections.reverse(pts);
    		
		ArrayList<Player> player = new ArrayList<Player>();

		
		if(pts.size() == 2){
			for (int i = 0; i < 2 ;i++){
				for(int j = 0; j<list.size();j++){			
					if(pts.get(i)==list.get(j).getPoints()){
						player.add(list.get(j));
					}	
				}
			}
			string = player.get(0).leaderString() + "," + player.get(1).leaderString() ;
		}
		else{
			for (int i = 0; i < 3 ;i++){
				for(int j = 0; j<list.size();j++){			
					if(pts.get(i)==list.get(j).getPoints()){
						player.add(list.get(j));
					}	
				}
			}
			string = player.get(0).leaderString() + "," + player.get(1).leaderString() + ","  + player.get(2).leaderString();
		}	
		
		return string;
		
	}

}






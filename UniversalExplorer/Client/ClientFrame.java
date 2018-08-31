import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;




public class ClientFrame extends JFrame implements ActionListener{

	private static JTextArea comLabel;

	//background
	private static Image bgImg = Toolkit.getDefaultToolkit().createImage("../Img/bg1.jpg");
	private static ImageIcon bgIcon = new ImageIcon(bgImg);
	private static JLabel bgJLabel = new JLabel(bgIcon);
	
	
	private static JLabel headLable,headLable2,titleLable,nameLable,pWLable,rePWlable,emptyLable1,emptyLable2,emptyLable3,introLabel,logBGLabel,testLabel,testLabel2,inforLabel,inforLabel2,numLabel1,numLabel2;
	private static JButton newPButton, oldPButton,leaderButton,exitButton,backButton,startButton,skipButton,skipStartButton,rollButton,goButton,stopButton,crapButton,diceButton1,diceButton2,diceButton3,diceButton4;
	private static JTextField nameField,pWField,rePWField;

	private static JPanel logBGPanel,logPanel,boardPanel,conPanel,gamePanel,c2Panel,c3Panel,c4Panel,c5Panel,c6Panel,c7Panel,c8Panel,c9Panel,c10Panel,c11Panel,c12Panel, headPanel,headPanel2,topPanel,centerPanel1,centerPanel2,centerPanel3,bottomPanel,bodyPanel2,bodyPanel,bodyPanel3,fakePanel1,fakePanel2,fakePanel3,fakePanel4,fakePanel5,fakePanel6,mainPanel,
loginPanel,contentPane,comPanel,actPanel,mathPanel,numPanel,dicePanel;
	private static Font font1,font2;
	private static OverlayLayout logLayout;
	private static  ImageIcon roll,go,crap,stop;
	private static int [][] crapBoard;
	private static int [][] board  ={{-1	,	-1	,	-1	,	-1	,	-1	,	150	,	-1	,	-1	,	-1	,	-1	,	-1},
					{-1	,	-1	,	-1	,	-1	,	-1	,	0	,	-1	,	-1	,	-1	,	-1	,	-1},
					{-1	,	-1	,	-1	,	-1	,	140	,	0	,	160	,	-1	,	-1	,	-1	,	-1},
					{-1	,	-1	,	-1	,	-1	,	0	,	0	,	0	,	-1	,	-1	,	-1	,	-1},
					{-1	,	-1	,	-1	,	130	,	0	,	0	,	0	,	170	,	-1	,	-1	,	-1},
					{-1	,	-1	,	-1	,	0	,	0	,	0	,	0	,	0	,	-1	,	-1	,	-1},
					{-1	,	-1	,	120	,	0	,	0	,	0	,	0	,	0	,	180	,	-1	,	-1},
					{-1	,	-1	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	-1	,	-1},
					{-1	,	110	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	190	,	-1},
					{-1	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	-1},
					{100	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,        200},
					{0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0},
					{0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0	,	0}};

	
	private static JLabel [][] box ;
	private static ImageIcon [][] pic;	
	private static ArrayList cell;
	private static ImageIcon [] picture;

	private static String userName;
	private static String password;
	private static String rePassword;
	private static String serverLine;
	private static String userLine;
	private static boolean newPlayer = false;
	private static boolean ready = false;
	private static boolean proceed = true;
	private static boolean start = false;
	private static boolean done  = true;
	

	private static BufferedReader serverIn = null;
	private static BufferedReader userIn = null;
	private static PrintWriter serverOut = null;


	private static int  dice1=0;
	private static int  dice2=0;
	private static int  dice3=0;
	private static int  dice4=0;

		
	

	private static boolean first=false;
	private static boolean second=false;
	private static boolean third=false;
	private static boolean fourth=false;
	private static boolean num1First = false;
	private static boolean num2First = false;



	private static String diceOne="";
	private static String diceTwo="";
	private static String diceThree="";
	private static String diceFour="";

	private static int numPlayer;
	private static boolean playing;

	private static int conNum = 0;
	private static int num1;
	private static int num2;
	private static ArrayList<Integer> numList = new ArrayList<Integer>();
	private static int counter = 0;






	public ClientFrame(){
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setSize(1600, 860);
		//setUndecorated(true);
		setVisible(true);
		setTitle("UNIVERSAL EXPLORER");
		
		//adding background img
		//bgJLabel.setBounds(0, 0, 800, 600);
		//add(bgJLabel);
		
		
		//over = new JDialog();

		font1 = new Font ("Arial", Font.PLAIN, 100);
		font2 = new Font ("Arial", Font.PLAIN, 20);
		headLable = new JLabel("UNIVERSAL EXPLORER");
		headLable.setSize(600,50);
		headLable.setForeground(Color.RED);
		headLable.setPreferredSize(new Dimension(1200, 300));
		headLable.setFont(font1);
		headLable.setHorizontalAlignment(SwingConstants.CENTER); 

		introLabel= new JLabel("The year is 2853. You are the commander of the universal exploring team. Your mission is to find 3 planets for human immigration before your opponent does. You have  3 Pioneers to travel through the wormhole to explore the space, and once the Pioneers reach a planet, you can conquer the planet with one of the 11 Civilization carrier under your command. However, the wormholes are the most dangerous places in the universe...You have to calculate your jumps carefully and make decisions wisely... ");
		introLabel.setPreferredSize(new Dimension(500, 300));
		testLabel = new JLabel("The year is 2853. You are the commander of the universal exploring team. Your mission is to find 3 planets for human immigration before your opponent does. You have  3 Pioneers to travel through the wormhole to explore the space, and once the Pioneers reach a planet, you can conquer the planet with one of the 11 Civilization carrier under your command. However, the wormholes are the most dangerous places in the universe...You have to calculate your jumps carefully and make decisions wisely...");
		testLabel.setPreferredSize(new Dimension(1600, 100));
		testLabel2 = new JLabel("In the future ...");
		testLabel2.setPreferredSize(new Dimension(150, 60));

		inforLabel = new JLabel("WELCOME");
		// use for display server information
		inforLabel2 = new JLabel("Input your name and password");
		nameLable = new JLabel("Player Name");
		nameLable.setFont(font2);
		pWLable = new JLabel("Enter Password");
		pWLable.setFont(font2);
		rePWlable = new JLabel("Enter Password Again");
		rePWlable.setFont(font2);
		emptyLable1 = new JLabel(""); 
		emptyLable2 = new JLabel(""); 
		emptyLable3 = new JLabel(""); 
		
		

		pic= new ImageIcon [3][11];
		// 8 cases for cells
		cell = new ArrayList<ImageIcon>();
		picture = new ImageIcon [9];
		picture[0]= new ImageIcon(new ImageIcon("../Img/c.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));
 		picture[1]= new ImageIcon(new ImageIcon("../Img/hole-pioneer1.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));
		picture[2]= new ImageIcon(new ImageIcon("../Img/hole-pioneer2.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));	

		 picture[3] = new ImageIcon(new ImageIcon("../Img/hole-carrier1.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));
		 picture[4] = new ImageIcon(new ImageIcon("../Img/hole-carrier2.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));
		
		 picture[5] = new ImageIcon(new ImageIcon("../Img/hole-both-carriers.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));
		 picture[6] = new ImageIcon(new ImageIcon("../Img/hole-both-pioneers.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));
		 picture[7] = new ImageIcon(new ImageIcon("../Img/hole-carrier2-pioneer1.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));
		 picture[8] = new ImageIcon(new ImageIcon("../Img/hole-carrier1-pioneer2.png").getImage().getScaledInstance(140, 61, Image.SCALE_DEFAULT));
		 

		 pic[0][0] = new ImageIcon(new ImageIcon("../Img/planet1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][1] = new ImageIcon(new ImageIcon("../Img/planet2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][2] = new ImageIcon(new ImageIcon("../Img/planet3.png").getImage().getScaledInstance(140, 130, Image.SCALE_DEFAULT));
		 pic[0][3] = new ImageIcon(new ImageIcon("../Img/planet4.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][4] = new ImageIcon(new ImageIcon("../Img/planet5.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][5] = new ImageIcon(new ImageIcon("../Img/planet6.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][6] = new ImageIcon(new ImageIcon("../Img/planet7.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][7] = new ImageIcon(new ImageIcon("../Img/planet8.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][8] = new ImageIcon(new ImageIcon("../Img/planet9.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][9]= new ImageIcon(new ImageIcon("../Img/planet10.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[0][10]= new ImageIcon(new ImageIcon("../Img/planet11.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));

		//player 1 conqured
		 pic[1][0] = new ImageIcon(new ImageIcon("../Img/planet1-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][1] = new ImageIcon(new ImageIcon("../Img/planet2-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][2] = new ImageIcon(new ImageIcon("../Img/planet3-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][3] = new ImageIcon(new ImageIcon("../Img/planet4-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][4] = new ImageIcon(new ImageIcon("../Img/planet5-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][5] = new ImageIcon(new ImageIcon("../Img/planet6-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][6] = new ImageIcon(new ImageIcon("../Img/planet7-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][7] = new ImageIcon(new ImageIcon("../Img/planet8-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][8] = new ImageIcon(new ImageIcon("../Img/planet9-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][9] = new ImageIcon(new ImageIcon("../Img/planet10-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[1][10] = new ImageIcon(new ImageIcon("../Img/planet11-player1.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		//player 2 conqured
		 pic[2][0] = new ImageIcon(new ImageIcon("../Img/planet1-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][1] = new ImageIcon(new ImageIcon("../Img/planet2-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][2] = new ImageIcon(new ImageIcon("../Img/planet3-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][3] = new ImageIcon(new ImageIcon("../Img/planet4-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][4] = new ImageIcon(new ImageIcon("../Img/planet5-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][5] = new ImageIcon(new ImageIcon("../Img/planet6-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][6] = new ImageIcon(new ImageIcon("../Img/planet7-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][7] = new ImageIcon(new ImageIcon("../Img/planet8-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][8] = new ImageIcon(new ImageIcon("../Img/planet9-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][9] = new ImageIcon(new ImageIcon("../Img/planet10-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		 pic[2][10] = new ImageIcon(new ImageIcon("../Img/planet11-player2.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));

		
		box = new JLabel[13][11];
		box[12][0] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][0] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][0] = new JLabel("",pic[0][0],JLabel.CENTER);

		box[12][1] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][1] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][1] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][1] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][1] = new JLabel("",pic[0][1],JLabel.CENTER);

		box[12][2] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][2] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][2] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][2] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][2] = new JLabel("",picture[0],JLabel.CENTER);
		box[7][2] = new JLabel("",picture[0],JLabel.CENTER);
		box[6][2] = new JLabel("",pic[0][2],JLabel.CENTER);
		
		box[12][3] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][3] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][3] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][3] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][3] = new JLabel("",picture[0],JLabel.CENTER);
		box[7][3] = new JLabel("",picture[0],JLabel.CENTER);
		box[6][3] = new JLabel("",picture[0],JLabel.CENTER);
		box[5][3] = new JLabel("",picture[0],JLabel.CENTER);
		box[4][3] = new JLabel("",pic[0][3],JLabel.CENTER);

		box[12][4] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][4] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][4] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][4] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][4]  = new JLabel("",picture[0],JLabel.CENTER);
		box[7][4]  = new JLabel("",picture[0],JLabel.CENTER);
		box[6][4]  = new JLabel("",picture[0],JLabel.CENTER);
		box[5][4]  = new JLabel("",picture[0],JLabel.CENTER);
		box[4][4]  = new JLabel("",picture[0],JLabel.CENTER);
		box[3][4]  = new JLabel("",picture[0],JLabel.CENTER);
		box[2][4]  = new JLabel("",pic[0][4],JLabel.CENTER);


		box[12][5] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][5] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][5] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][5] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][5]  = new JLabel("",picture[0],JLabel.CENTER);
		box[7][5]  = new JLabel("",picture[0],JLabel.CENTER);
		box[6][5]  = new JLabel("",picture[0],JLabel.CENTER);
		box[5][5]  = new JLabel("",picture[0],JLabel.CENTER);
		box[4][5]  = new JLabel("",picture[0],JLabel.CENTER);
		box[3][5]  = new JLabel("",picture[0],JLabel.CENTER);
		box[2][5]  = new JLabel("",picture[0],JLabel.CENTER);
		box[1][5]  = new JLabel("",picture[0],JLabel.CENTER);
		box[0][5]  = new JLabel("",pic[0][5],JLabel.CENTER);

		box[12][6] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][6] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][6] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][6] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][6]  = new JLabel("",picture[0],JLabel.CENTER);
		box[7][6]  = new JLabel("",picture[0],JLabel.CENTER);
		box[6][6]  = new JLabel("",picture[0],JLabel.CENTER);
		box[5][6]  = new JLabel("",picture[0],JLabel.CENTER);
		box[4][6]  = new JLabel("",picture[0],JLabel.CENTER);
		box[3][6]  = new JLabel("",picture[0],JLabel.CENTER);
		box[2][6] = new JLabel("",pic[0][6],JLabel.CENTER);

		box[12][7] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][7] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][7] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][7] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][7]  = new JLabel("",picture[0],JLabel.CENTER);
		box[7][7]  = new JLabel("",picture[0],JLabel.CENTER);
		box[6][7]  = new JLabel("",picture[0],JLabel.CENTER);
		box[5][7]  = new JLabel("",picture[0],JLabel.CENTER);
		box[4][7]  = new JLabel("",pic[0][7],JLabel.CENTER);

		box[12][8] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][8] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][8] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][8] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][8]  = new JLabel("",picture[0],JLabel.CENTER);
		box[7][8]  = new JLabel("",picture[0],JLabel.CENTER);
		box[6][8]  = new JLabel("",pic[0][8],JLabel.CENTER);

		box[12][9] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][9] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][9] = new JLabel("",picture[0],JLabel.CENTER);
		box[9][9] = new JLabel("",picture[0],JLabel.CENTER);
		box[8][9] = new JLabel("",pic[0][9],JLabel.CENTER);

			
		box[12][10] = new JLabel("",picture[0],JLabel.CENTER);
		box[11][10] = new JLabel("",picture[0],JLabel.CENTER);
		box[10][10]= new JLabel("",pic[0][10],JLabel.CENTER);



		nameField = new JTextField (15);
		pWField = new JTextField (15);
		rePWField = new JTextField (15);
		
		newPButton = new JButton("New Player");
		newPButton.setPreferredSize(new Dimension(40, 400));
		
		oldPButton = new JButton("Old Player");		
		
		exitButton = new JButton("Exit Game");

		backButton = new JButton("Back to menu");

		backButton.setPreferredSize(new Dimension(40,60));
		startButton = new JButton("Start Game");
		skipButton = new JButton("Skip");
		skipStartButton = new JButton("Skip to Start");

		newPButton.addActionListener(this);
		oldPButton.addActionListener(this);
		//leaderButton.addActionListener(this);
		exitButton.addActionListener(this);
		exitButton.addActionListener(this);
                backButton.addActionListener(this);
		startButton.addActionListener(this);
                skipButton.addActionListener(this);
		skipStartButton.addActionListener(this);
		
		//leaderButton.addActionListener(this);

		headPanel = new JPanel();
		headPanel.add(headLable);
		headPanel.setPreferredSize(new Dimension(40, 400));

		
		bodyPanel = new JPanel();
		fakePanel1 = new JPanel();
		fakePanel2 = new JPanel();
		fakePanel3 = new JPanel();
		fakePanel4 = new JPanel();
		fakePanel5 = new JPanel();
		fakePanel6 = new JPanel();
		bodyPanel2 = new JPanel();
		bodyPanel3 = new JPanel();

		centerPanel1 = new JPanel();
	
		// centerPanel1.setLayout(new BoxLayout(centerPanel1,BoxLayout.Y_AXIS)); 
		centerPanel1.setLayout(new GridLayout(4,1,10,30)); 		
		centerPanel1.add(newPButton);
		centerPanel1.add(oldPButton);
		//centerPanel1.add(leaderButton);
		//centerPanel1.add(exitButton);

		bodyPanel.setLayout(new GridLayout(1,3,400,400)); 		
		bodyPanel.add(fakePanel1);			
		bodyPanel.add(centerPanel1);	
		bodyPanel.add(fakePanel2);	
		
		centerPanel2 = new JPanel();
		centerPanel2.setLayout(new GridLayout(4,2,30,30)); 
		centerPanel2.add(inforLabel);	
		centerPanel2.add(inforLabel2);	
		centerPanel2.add(nameLable);
		centerPanel2.add(nameField);
		centerPanel2.add(pWLable);
		centerPanel2.add(pWField);
		centerPanel2.add(rePWlable);
		centerPanel2.add(rePWField);
		

		bodyPanel2.setLayout(new GridLayout(1,3,1,100)); 		
		bodyPanel2.add(fakePanel3);			
		bodyPanel2.add(centerPanel2);	
		bodyPanel2.add(fakePanel4);


		centerPanel3 = new JPanel();
		bodyPanel3.setLayout(new GridLayout(1,3,1,100)); 		
		bodyPanel3.add(fakePanel5);			
		bodyPanel3.add(introLabel);	
		bodyPanel3.add(fakePanel6);


		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,6,100,100)); 
		bottomPanel.setPreferredSize(new Dimension(40, 100));
		bottomPanel.add(emptyLable1);	
		bottomPanel.add(emptyLable2);
		bottomPanel.add(backButton);
		bottomPanel.add(startButton);
		bottomPanel.add(skipButton);
		bottomPanel.add(skipStartButton);


		//contentPane = getContentPane();
		contentPane = new JPanel();
		//contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
		contentPane.setLayout(new BorderLayout());
		//contentPane.setLayout(new FlowLayout());
		contentPane.add(headPanel,BorderLayout.PAGE_START);
		//setVgap(100);

		contentPane.add(bodyPanel,BorderLayout.CENTER);
		contentPane.add(bottomPanel,BorderLayout.PAGE_END);
		bottomPanel.setVisible(false);
		skipStartButton.setVisible(false);

		BackgroundPanel welcomePanel = new BackgroundPanel();
		add(welcomePanel);
		//BackgroundPanel.paint(img);
		
		
		/*BackgroundPanel loginPanel = new BackgroundPanel();
		
		add(loginPanel);
		loginPanel.add(contentPane);
		add(loginPanel);
		//contentPane.revalidate();
       		//contentPane.repaint();
		
		contentPane.setBackground(new Color(0,0,0,5));
		headPanel.setBackground(new Color(0,0,0,5));
		bottomPanel.setBackground(new Color(0,0,0,5));
		bodyPanel.setBackground(new Color(0,0,0,5));
		setContentPane(loginPanel);
		contentPane.setOpaque(true);*/

		//c23.setPreferredSize(new Dimension(140, 61));
		//c22.setPreferredSize(new Dimension(140, 61));
		//c21.setPreferredSize(new Dimension(140, 61));
		
	
		c2Panel = new JPanel(); 
		c3Panel = new JPanel(); 
		c4Panel = new JPanel(); 
		c5Panel = new JPanel(); 
		c6Panel = new JPanel(); 
		c7Panel = new JPanel(); 
		c8Panel = new JPanel(); 
		c9Panel = new JPanel(); 
		c10Panel = new JPanel(); 
		c11Panel = new JPanel(); 
		c12Panel = new JPanel(); 
	
		c2Panel.setPreferredSize(new Dimension(140, 800));
		c3Panel.setPreferredSize(new Dimension(140, 800));
		c4Panel.setPreferredSize(new Dimension(140, 800));
		c5Panel.setPreferredSize(new Dimension(140, 800));
		c6Panel.setPreferredSize(new Dimension(140, 800));
		c7Panel.setPreferredSize(new Dimension(140, 800));
		c8Panel.setPreferredSize(new Dimension(140, 800));
		c9Panel.setPreferredSize(new Dimension(140, 800));
		c10Panel.setPreferredSize(new Dimension(140, 800));
		c11Panel.setPreferredSize(new Dimension(140, 800));
		c12Panel.setPreferredSize(new Dimension(140, 800));
	

		c2Panel.setLayout(new BoxLayout(c2Panel, BoxLayout.PAGE_AXIS));
		c3Panel.setLayout(new BoxLayout(c3Panel, BoxLayout.PAGE_AXIS));
		c4Panel.setLayout(new BoxLayout(c4Panel, BoxLayout.PAGE_AXIS));
		c5Panel.setLayout(new BoxLayout(c5Panel, BoxLayout.PAGE_AXIS));
		c6Panel.setLayout(new BoxLayout(c6Panel, BoxLayout.PAGE_AXIS));
		c7Panel.setLayout(new BoxLayout(c7Panel, BoxLayout.PAGE_AXIS));
		c8Panel.setLayout(new BoxLayout(c8Panel, BoxLayout.PAGE_AXIS));
		c9Panel.setLayout(new BoxLayout(c9Panel, BoxLayout.PAGE_AXIS));
		c10Panel.setLayout(new BoxLayout(c10Panel, BoxLayout.PAGE_AXIS));
		c11Panel.setLayout(new BoxLayout(c11Panel, BoxLayout.PAGE_AXIS));
		c12Panel.setLayout(new BoxLayout(c12Panel, BoxLayout.PAGE_AXIS));

		
		c2Panel.setBackground(new Color(0,0,0,255));
		c3Panel.setBackground(new Color(0,0,0,255));
		c4Panel.setBackground(new Color(0,0,0,255));
		c5Panel.setBackground(new Color(0,0,0,255));
		c6Panel.setBackground(new Color(0,0,0,255));
		c7Panel.setBackground(new Color(0,0,0,255));
		c8Panel.setBackground(new Color(0,0,0,255));
		c9Panel.setBackground(new Color(0,0,0,255));
		c10Panel.setBackground(new Color(0,0,0,255));
		c11Panel.setBackground(new Color(0,0,0,255));
		c12Panel.setBackground(new Color(0,0,0,255));

		c2Panel.add(box[10][0] );
		c2Panel.add(Box.createRigidArea(new Dimension(0,30)));
		for (int i= 11;i<13;i++){
			c2Panel.add(box[i][0]);
			c2Panel.add(Box.createRigidArea(new Dimension(0,20)));
		}		
		
		c3Panel.add(box[8][1]);
		c3Panel.add(Box.createRigidArea(new Dimension(0,30)));
		for (int i= 9;i<13;i++){
			c3Panel.add(box[i][1]);
			c3Panel.add(Box.createRigidArea(new Dimension(0,20)));
		}	

		c4Panel.add(box[6][2]);
		c4Panel.add(Box.createRigidArea(new Dimension(0,20)));
		for (int i= 7;i<13;i++){
			c4Panel.add(box[i][2]);
			c4Panel.add(Box.createRigidArea(new Dimension(0,10)));
		}		

		c5Panel.add(box[4][3]);
		c5Panel.add(Box.createRigidArea(new Dimension(0,10)));
		for (int i= 5;i<13;i++){
			c5Panel.add(box[i][3]);
			c5Panel.add(Box.createRigidArea(new Dimension(0,10)));
		}

		c6Panel.add(box[2][4]);
		c6Panel.add(Box.createRigidArea(new Dimension(0,20)));
		for (int i= 3;i<13;i++){
			c6Panel.add(box[i][4]);
			c6Panel.add(Box.createRigidArea(new Dimension(0,3)));
		}

		c7Panel.add(box[0][5]);
		c7Panel.add(Box.createRigidArea(new Dimension(0,10)));
		for (int i= 1;i<13;i++){
			c7Panel.add(box[i][5]);
			c7Panel.add(Box.createRigidArea(new Dimension(0,10)));
		}

		c8Panel.add(box[2][6]);
		c8Panel.add(Box.createRigidArea(new Dimension(0,20)));
		for (int i= 3;i<13;i++){
			c8Panel.add(box[i][6]);
			c8Panel.add(Box.createRigidArea(new Dimension(0,3)));
		}

		c9Panel.add(box[4][7]);
		c9Panel.add(Box.createRigidArea(new Dimension(0,10)));
		for (int i= 5;i<13;i++){
			c9Panel.add(box[i][7]);
			c9Panel.add(Box.createRigidArea(new Dimension(0,10)));
		}

		for (int i= 6;i<13;i++){
			c10Panel.add(box[i][8]);
			c10Panel.add(Box.createRigidArea(new Dimension(0,10)));
		}

		c11Panel.add(box[8][9]);
		c11Panel.add(Box.createRigidArea(new Dimension(0,30)));
		for (int i= 9;i<13;i++){
			c11Panel.add(box[i][9]);
			c11Panel.add(Box.createRigidArea(new Dimension(0,20)));
		}

		c12Panel.add(box[10][10]);
		c12Panel.add(Box.createRigidArea(new Dimension(0,30)));
		for (int i= 11;i<13;i++){
			c12Panel.add(box[i][10]);
			c12Panel.add(Box.createRigidArea(new Dimension(0,20)));
		}
	
		boardPanel = new JPanel();
		boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.LINE_AXIS));
		boardPanel.add(c2Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c3Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c4Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c5Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c6Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c7Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c8Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c9Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c10Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c11Panel);
		boardPanel.add(Box.createRigidArea(new Dimension(6,0)));
		boardPanel.add(c12Panel);
		boardPanel.setBackground(new Color(0,0,0,255));
		boardPanel.setPreferredSize(new Dimension(1600, 860));

		//ImageIcon com = new ImageIcon(new ImageIcon("../Img/con1.png").getImage().getScaledInstance(530,100, Image.SCALE_DEFAULT));
		//comLabel = new JLabel("",com,JLabel.CENTER);
		//comLabel = new JLabel("welcome");
		comPanel = new JPanel();
		
		comPanel.setBackground(new Color(0,0,128,255));
		
		comLabel = new JTextArea("Welcome",5, 30);
		comLabel.setLineWrap(true);
		comPanel.add(comLabel);
		comLabel.setForeground(Color.WHITE);
		comLabel.setBackground(new Color(0,0,128,255));
		comLabel.setFont(new Font("Serif", Font.BOLD, 15));	
		//JScrollPane scrollPane = new JScrollPane(comLabel);
		//scrollPane.getViewport().setBackground(Color.BLUE); 
		//scrollPane.setBackground(new Color(0,0,128,255));
		//comPanel.add(scrollPane);
		comLabel.setEditable(false);

		ImageIcon roll= new ImageIcon(new ImageIcon("../Img/b1.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH));
		ImageIcon go= new ImageIcon(new ImageIcon("../Img/b4.png").getImage().getScaledInstance(150,100, Image.SCALE_DEFAULT));
		ImageIcon crap= new ImageIcon(new ImageIcon("../Img/b3.png").getImage().getScaledInstance(150,100, Image.SCALE_DEFAULT));
		ImageIcon stop= new ImageIcon(new ImageIcon("../Img/b2.png").getImage().getScaledInstance(150,100, Image.SCALE_DEFAULT));

		rollButton = new JButton();
		//rollButton.setPreferredSize(new Dimension(100, 80));
		rollButton.setBackground(new Color(0,0,0,0));
		rollButton.setIcon(roll);

		//rollButton.setBorderPainted(false);
		//rollButton.setBorder(null);
		//rollButton.setFocusable(false);
		//rollButton.setMargin(new Insets(0, 0, 0, 0));
		//rollButton.setContentAreaFilled(false);

		



		goButton = new JButton();
		goButton.setBackground(new Color(0,0,0,0));
		goButton.setIcon(go);

		stopButton = new JButton();
		stopButton.setBackground(new Color(0,0,0,0));
		stopButton.setIcon(stop);

		crapButton = new JButton();
		crapButton.setBackground(new Color(0,0,0,0));
		crapButton.setIcon(crap);
		//crapButton.setPreferredSize(new Dimension(120, 30));
		
		actPanel = new JPanel();
		//actPanel.setLayout(new BoxLayout(actPanel,BoxLayout.LINE_AXIS));
		actPanel.setLayout(new GridLayout(1,4));
		actPanel.add(rollButton);
		//actPanel.add(Box.createHorizontalGlue());
		
		actPanel.add(stopButton);
		//actPanel.add(Box.createHorizontalGlue());
		actPanel.add(crapButton);
		actPanel.add(goButton);
		//actPanel.add(Box.createHorizontalGlue());
		actPanel.setPreferredSize(new Dimension(400, 100));
		actPanel.setBackground(new Color(123,123,123,255));

		goButton.addActionListener(this);
		crapButton.addActionListener(this);
		stopButton.addActionListener(this);
		rollButton.addActionListener(this);



		numLabel1 = new JLabel("",SwingConstants.CENTER);
		numLabel2 = new JLabel("",SwingConstants.CENTER);
		numLabel1.setForeground(Color.WHITE);
		numLabel2.setForeground(Color.WHITE);
		numLabel1.setFont(new Font("Serif", Font.BOLD, 40));
		numLabel2.setFont(new Font("Serif", Font.BOLD, 40));
		numPanel = new JPanel();
		//numPanel.setLayout(new BoxLayout(numPanel, BoxLayout.LINE_AXIS));
		numPanel.setLayout(new GridLayout(1,2));
		numPanel.add(numLabel1);
		numPanel.add(numLabel2);
		numPanel.setBackground(new Color(0,0,128,255));



		diceButton1 = new JButton("0");
		diceButton2 = new JButton("0");
		diceButton3 = new JButton("0");
		diceButton4 = new JButton("0");

		diceButton1.addActionListener(this);
		diceButton2.addActionListener(this);
		diceButton3.addActionListener(this);
		diceButton4.addActionListener(this);

    		dicePanel = new JPanel();
		//dicePanel.setLayout(new BoxLayout(dicePanel, BoxLayout.LINE_AXIS));
		dicePanel.setLayout(new GridLayout(1,4));
		dicePanel.add(diceButton1);
		dicePanel.add(diceButton2);
		dicePanel.add(diceButton3);
		dicePanel.add(diceButton4);
		dicePanel.setBackground(new Color(0,0,128,255));

	        mathPanel = new JPanel();
		//mathPanel.setLayout(new BoxLayout(mathPanel, BoxLayout.PAGE_AXIS));
		mathPanel.setLayout(new GridLayout(2,1));
		mathPanel.add(numPanel);
		mathPanel.add(dicePanel);
		mathPanel.setBackground(new Color(0,0,128,255));


		conPanel = new JPanel();
		conPanel.setLayout(new GridLayout(1,3));
		//conPanel.setLayout(new BoxLayout(conPanel, BoxLayout.LINE_AXIS));
      		conPanel.add(comPanel);
		conPanel.add(actPanel);
		conPanel.add(mathPanel);
		conPanel.setBackground(new Color(123,123,123,255));
		



		gamePanel = new JPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.PAGE_AXIS));
		gamePanel.setBackground(new Color(0,0,0,255));
		gamePanel.add(boardPanel);
		gamePanel.add(conPanel);



		setContentPane(contentPane);
		gamePanel.setBackground(new Color(0,0,0,65));				

	 addWindowListener(new WindowAdapter(){
    			  public void windowClosing(WindowEvent e){
      			  System.exit(0);}});
	}

		
		
	public void actionPerformed(ActionEvent event){
	
		try{
	    	JButton buttonEvent =  (JButton)event.getSource();

		if (buttonEvent == newPButton){
			 contentPane.remove(0);
			 contentPane.remove(0);
      			contentPane.revalidate();
       			contentPane.repaint();
			
			contentPane.add(headPanel,BorderLayout.PAGE_START);

			contentPane.add(bodyPanel2,BorderLayout.CENTER);
			contentPane.add(bottomPanel,BorderLayout.PAGE_END);
		
			rePWlable.setVisible(true);
			rePWField.setVisible(true);
			bottomPanel.setVisible(true);
			skipButton.setVisible(false);

			startButton.setVisible(true);
			backButton.setVisible(true);

			headLable.setText("Register");
	
			newPlayer = true;
		} 

		if (buttonEvent == oldPButton){
			
			contentPane.remove(0);
			contentPane.remove(0);

      			contentPane.revalidate();
       			contentPane.repaint();
						
			contentPane.add(headPanel,BorderLayout.PAGE_START);

			contentPane.add(bodyPanel2,BorderLayout.CENTER);
			rePWlable.setVisible(false);
			rePWField.setVisible(false);
			bottomPanel.setVisible(true);
			skipButton.setVisible(false);

			startButton.setVisible(true);
			backButton.setVisible(true);

			headLable.setText("Login");
					
		} 


		if (buttonEvent == startButton && newPlayer){
				userName = nameField.getText();
				password = pWField.getText();
				rePassword = rePWField.getText();

			if(!ready){	
				
				
				serverOut.println("N," + userName);
				serverLine = serverIn.readLine();	
			}
			
			//not done yet			
			
				
			
			if(serverLine.equals("err, Duplicate User Name")){					
				inforLabel2.setText("Duplicate user name.");
			}else if(serverLine.equals("ack")){
				ready = true;
				if(password.equals(rePassword)){
					serverOut.println(password);
					start = true;			
				}else{
					inforLabel2.setText("Passwords don't match");	
				}
					
				
			}

			if(start){
				contentPane.remove(0);
				contentPane.remove(0);
				contentPane.remove(0);

      				contentPane.revalidate();
       				contentPane.repaint();
						
				contentPane.add(headPanel,BorderLayout.PAGE_START);

				contentPane.add(bodyPanel3,BorderLayout.CENTER);
				contentPane.add(bottomPanel,BorderLayout.PAGE_END);

				startButton.setVisible(false);
				backButton.setVisible(false);
	
				bottomPanel.setVisible(true);
				skipButton.setVisible(true);
				introLabel.setText("in the future..");
				headLable.setText("introduction");
								
			}
		
			
		}else if(buttonEvent == startButton && !newPlayer){
			userName = nameField.getText();
			password = pWField.getText();
			serverOut.println("R," + userName);
			
			serverLine = serverIn.readLine();
			while(!start){

				if(serverLine.equals("err, Unknown User")){
					inforLabel2.setText("User does not exist.");
				}else if(serverLine.equals("ack")){
					serverOut.println(password);
					boolean valid = false;
					while(!valid){
						int validCounter = 3;
						String line = serverIn.readLine();
						if(line.equals("ack")){
							start = true;
							valid = true;
						}else if(line.equals("err, Invalid Password")){
							validCounter--;
							inforLabel2.setText("Invalid password. Attepts: "+ validCounter);
						}
					}		
				}
			}
			


			if(start){
				contentPane.remove(0);
				contentPane.remove(0);
				contentPane.remove(0);

      				contentPane.revalidate();
       				contentPane.repaint();
						
				contentPane.add(headPanel,BorderLayout.PAGE_START);

				contentPane.add(bodyPanel3,BorderLayout.CENTER);
				contentPane.add(bottomPanel,BorderLayout.PAGE_END);

				startButton.setVisible(false);
				backButton.setVisible(false);
	
				bottomPanel.setVisible(true);
				skipButton.setVisible(true);
				introLabel.setText("in the futre...");
				headLable.setText("introduction");
							
			}
			


		} 


		if (buttonEvent == skipButton){
			
			contentPane.remove(0);
			contentPane.remove(0);
			contentPane.remove(0);

      			contentPane.revalidate();
       			contentPane.repaint();
						
			contentPane.add(headPanel,BorderLayout.PAGE_START);

			contentPane.add(bodyPanel3,BorderLayout.CENTER);
			contentPane.add(bottomPanel,BorderLayout.PAGE_END);
			//bottomPanel.remove(skipButton);
			//bottomPanel.add(skipStartButton);

			startButton.setVisible(false);
			skipStartButton.setVisible(true);
	
			bottomPanel.setVisible(true);
			skipButton.setVisible(false);
			introLabel.setText("Refer to ReadMe");
			//introLabel.setText("The top section is the game board, which presents users' choices and effects in real time. -The 11 planets are initially dim to indicate that they have not yet been explored. -Each user has two types of ships, 3 Exploration Pioneers and 11 Civilization Carriers.-Between the 11 Civilization Carriers and the 11 unexplored planets is the Wormhole roadmap.The bottom section is the control panel, which allows users to give command to their entire fleet.-The green button 'CALC' calculates the current stable wormhole indexes. The four indexes are displayed on the bottom right of the screen. Based on the indexes, the player will have to click on the indexes to group them into 2 numbers to indicate which wormholes the Pioneers should jump through and further explore the unknown space. -After the user picked the two numbers, he/she can then confirm the jump by clicking on the purple button 'EXPL'(Explore). The server will make sure whether they are valid commands. -After the jump, the user may chose to calculate new indexes and prepare for the jump again or they can send out Carriers to stabilize the wormhole by clicking the 'STAB'(stabilize) button. -At last, if none of the wormholes are stable based on the indexes, then the user will have to click 'ABAN' to abandon the mission and recall all Pioneers.-Bottom right is a display zone which shows the calculated indexes. If the input numbers cannot make the jump, the display zone will glow red, otherwise light blue.");
		
			headLable.setText("Tutorial");
				
		} 

		if (buttonEvent == skipStartButton){
			
			setContentPane(gamePanel);
			//setContentPane(logPanel);
			pack();
			//logPanel.setOpaque(false);
			serverLine = serverIn.readLine();
			if(serverLine.equals("1")){
				playing = true;
				crapBoard = board;
				numPlayer = 1;
			}else if(serverLine.equals("2")){				
				numPlayer = 2;
				//done = false;
				playing = false;
				processing();	
						
			}
			comLabel.setText("Welcome to the Fleet Control System, Commander " + userName +". \nExplorer Fleet "+ numPlayer+" awaits your order(Press the green button to begin calculation). \n");
			
					
			
			
			
					
		} 

		if (buttonEvent == backButton){

			contentPane.remove(0);
			contentPane.remove(0);
			contentPane.remove(0);

			contentPane.revalidate();
       			contentPane.repaint();
			
			contentPane.add(headPanel,BorderLayout.PAGE_START);
			contentPane.add(bodyPanel,BorderLayout.CENTER);
			contentPane.add(bottomPanel,BorderLayout.PAGE_END);
			bottomPanel.setVisible(false);
			skipButton.setVisible(false);
			
			headLable.setText("UNIVERSAL EXPLORER");
			//contentPane.setLayout(new GridLayout(2,1));
		}



		
		if (buttonEvent == rollButton ){
					
			serverOut.println("roll");
			
			serverLine = serverIn.readLine();
			
			
			diceOne= serverLine.substring(1,2);
			diceTwo= serverLine.substring(4,5);
			diceThree= serverLine.substring(7,8);
			diceFour= serverLine.substring(10,11);

			diceButton1.setText( diceOne);
			diceButton2.setText(diceTwo);
			diceButton3.setText(diceThree);
			diceButton4.setText(diceFour);

			dice1=Integer.parseInt(diceOne);
			dice2=Integer.parseInt(diceTwo);
			dice3=Integer.parseInt(diceThree);
			dice4=Integer.parseInt(diceFour);
			
			comLabel.setText( "\nData calculated, select data combinations and press the purple button to confirm\n");

			for (int i =0; i<13; i++){			
				for(int j=0;j<11;j++){				
					System.out.print(board[i][j]+",");
					if (j == 10){
						System.out.println(board[i][j]);
					}
				}
           		}

			
			
		}

		if (buttonEvent == crapButton){
			serverOut.println("crap");
           		serverLine = serverIn.readLine();
			if(serverLine.equals("ack")){
				comLabel.setText("Emergency FTL Engine initiated, all Pioneers are back to the Carrier.\n");
				clearDice();
			}else{System.out.println("crap function incorrect");}
			board = crapBoard;
			setImage();
			numList.clear();
			processing();
			
		}
		//check if the player can confirm the explorer action
		if (buttonEvent == goButton && !numLabel1.getText().equals("")){
			
			num1 = Integer.parseInt(numLabel1.getText());
			num2 = Integer.parseInt(numLabel2.getText());
		


			if(counter == 0){
			
				counter++;
				
				if(num1 == num2){
					pushOneNum();
					
				}else if(num1 != num2){
					pushTwoNums();
				}else{
					pushZeroNum();
				}
				clearDice();
					
			}else if(counter == 1){
				counter++;
				if(num1 == num2 &&  !dupNumOne()){
					pushOneNum();
				}else if(num1 != num2 && numList.size()==1 && !dupNumOne() && !dupNumTwo()){
					pushTwoNums();
				}else if(num1 != num2 && numList.size()==1 &&!dupNumOne() && dupNumTwo()){
					pushOneNum();
				}else if(num1 != num2 && numList.size()==1 &&dupNumOne() && !dupNumTwo()){
					pushOneNum2();
				}else if(num1 != num2 && numList.size()==2 &&!dupNumOne() && dupNumTwo()){
					pushOneNum();						
				}else if(num1 != num2 && numList.size()==2 &&dupNumOne() && !dupNumTwo()){
					pushOneNum2();	
				}else if(num1 != num2 && numList.size()==2 &&!dupNumOne() && !dupNumTwo()){
					pushOneNum();						
				}else{
					pushZeroNum();
				}
				clearDice();

			}else if(counter ==2 && numList.size() ==2){	
				counter++;
				if(!dupNumOne() && dupNumTwo())
					pushOneNum();
				else if(dupNumOne() && !dupNumTwo()){
					pushOneNum2();
				}else{
					pushZeroNum();
				}
				clearDice();					
				
			
			}else{
				num1First = false;
				num2First = false;

				for(int i = 0; i < 2; i++){
					if(numList.get(i) == num1 /*&& !checkConquer(i)*/){
						num1First = true;
						System.out.println("num1First is true");
						break;
					}
				}
				for(int i = 0; i < 2; i++){
					if(numList.get(i) == num2 /*&& !checkConquer(i)*/){
						num2First = true;
						System.out.println("num2First is true");
						break;
					}
				}
				

				if(num1First){
					String num = numLabel1.getText() + "," + numLabel2.getText();
					serverOut.println(num);	
					serverLine = serverIn.readLine();
					if(serverLine.equals("ack")){
						if(numPlayer == 1){
							setBoard(num1);
							setImage();
						}else if(numPlayer == 2){
							setBoard(num1);
							setImage();
						}

						comLabel.setText("\nPioneer worm hole jump successful.\n");				
					}else if(serverLine.substring(4,5).equals("w")){
						comLabel.setText("\nThe last planet has been found! Universal Explorer Fleet " + numPlayer +" is heading to our new home. Commander " +userName+", it has been an honor.\n");
						System.out.println(serverIn.readLine());
						

					}
					clearDice();
				}else if(num2First){
					String num = numLabel2.getText() + "," + numLabel1.getText();
					serverOut.println(num);	
					serverLine = serverIn.readLine();
					if(serverLine.equals("ack")){
				
						if(numPlayer == 1){
							setBoard(num2);
							setImage();
						}else if(numPlayer == 2){
							setBoard(num2);
							setImage();
						}

						comLabel.setText("\nPioneer worm hole jump successful.\n");				
					}else if(serverLine.substring(4,5).equals("w")){
						comLabel.setText("\nThe last planet has been found! Universal Explorer Fleet " + numPlayer +" is heading to our new home. Commander " +userName+", it has been an honor.\n");
						System.out.println(serverIn.readLine());
						

					}
					clearDice();
				}else{
					comLabel.setText("\nWarning! Worm hole unstable, FTL escape imminent.\n");
				}
				num1First = false;
				num2First = false;
			}
				//test comment						
				if(numList.size()==1){System.out.println(numList.get(0));}
				if(numList.size()==2){System.out.println(numList.get(0)+" "+numList.get(1));}
				if(numList.size()==3){System.out.println(numList.get(0)+" "+numList.get(1)+" "+numList.get(2));}
			


				           			
		}
		if (buttonEvent == stopButton){
			serverOut.println("stop");
			serverLine = serverIn.readLine();
			if(serverLine.equals("ack")){
				comLabel.setText("\nCivilization Carrier on root to targeted coordination.\nCommander, the worm hole has been stablized. \n");			
				clearDice();
				numList.clear();
				stopRun();
				setImage();	

			}
			processing();
			
				
		} 
	

		if (buttonEvent == diceButton1 ){
			first = true; 			
           		if(first && second  && !third && !fourth){
				numLabel1.setText( Integer.toString(dice1+dice2));
				numLabel2.setText( Integer.toString(dice3+dice4));
				first = false; 
				second = false;
				
			
			}else if(first && !second  && third && !fourth){
				numLabel1.setText( Integer.toString(dice1+dice3));
				numLabel2.setText( Integer.toString(dice2+dice4));
				first = false; 
				third=false;
			}else if (first && !second  && !third && fourth){
				numLabel1.setText( Integer.toString(dice1+dice4));
				numLabel2.setText( Integer.toString(dice2+dice3));
				first = false; 
				fourth=false;
			}
	
		}

		if (buttonEvent == diceButton2){
			second = true;
			if(first && second  && !third && !fourth){
				numLabel1.setText( Integer.toString(dice1+dice2));
				numLabel2.setText( Integer.toString(dice3+dice4));
				second = false;
				first=false;
			}else if(!first && second  &&  third && !fourth){
				numLabel1.setText( Integer.toString(dice2+dice3));
				numLabel2.setText( Integer.toString(dice1+dice4));
				second = false;
				third=false;
			}else if(!first && second  && !third && fourth){
				numLabel1.setText( Integer.toString(dice2+dice4));
				numLabel2.setText( Integer.toString(dice1+dice3));
				second = false;
				fourth = false;
			}
           			
		}

		if (buttonEvent == diceButton3){
			third = true; 

			if(first && !second  && third && !fourth){
				numLabel1.setText( Integer.toString(dice1+dice3));
				numLabel2.setText( Integer.toString(dice2+dice4));
				third = false; 
				first = false; 

			}else if(!first && second  && third && !fourth){
				numLabel1.setText( Integer.toString(dice2+dice3));
				numLabel2.setText( Integer.toString(dice1+dice4));
				third = false; 
				second = false;


			}else if (!first && !second  && third && fourth){
				numLabel1.setText( Integer.toString(dice3+dice4));
				numLabel2.setText( Integer.toString(dice2+dice1));
				third = false; 
				fourth = false;
			}	
		}
           			
		
		if (buttonEvent == diceButton4){
			fourth = true;
			if(first && !second  && !third && fourth){
				numLabel1.setText( Integer.toString(dice1+dice4));
				numLabel2.setText( Integer.toString(dice3+dice2));
				fourth = false;
				first = false; 

			}else if(!first && second  &&  !third && fourth){
				numLabel1.setText( Integer.toString(dice2+dice4));
				numLabel2.setText( Integer.toString(dice1+dice3));
				fourth = false;
				second = false;

			}else if(!first && !second  &&  third && fourth){
				numLabel1.setText( Integer.toString(dice3+dice4));
				numLabel2.setText( Integer.toString(dice1+dice2));
				second = false;
				fourth = false;
			}
		}
		
	

	
			
           	


		}catch(IOException e) {
         			System.err.println("Unable to read from or write to the client: " + e.getMessage());
      		}
	
	}




	public static void main (String[] args) {
		new ClientFrame().setVisible(true);
		String host = args[0];
	      	int port = Integer.parseInt(args[1]);

	      	Socket s = null;
	      	try {
		 	s = new Socket(host, port);
	      	}
	      	catch (UnknownHostException e) {
		 	System.err.println("Unknown host: " + host);
		 	System.exit(-1);
	      	}
	      	catch (IOException e) {
		 	System.err.println("Unable to get I/O connection to: " + host + " on port: " + port);
		 	System.exit(-1);
	      	}

	     
	      	try {         
		 	serverIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		 	userIn = new BufferedReader(new InputStreamReader(System.in));
		 	serverOut = new PrintWriter(s.getOutputStream(), true /* autoFlush */);
			
	

		}
	      	catch (IOException e) {
		 	System.out.println("Problem reading or writing:" + e.getMessage());
	      	}

	      	//try {
		 	//userIn.close();
		 	//serverOut.close();
		 	//serverIn.close();
		 	//s.close();
	      	//}
	      	//catch (IOException e) {
		 	//System.out.println("Problem closing reader, writer, or socket:" + e.getMessage());
	      	//} 
		
	}




	static void processing(){
			
			new Thread(new Runnable(){
				public void run(){
					crapBoard = board;
					ArrayList<JButton> buttonList= new ArrayList<JButton>();
					buttonList.add(diceButton1);
					buttonList.add(diceButton2);
					buttonList.add(diceButton3);
					buttonList.add(diceButton4);
					buttonList.add(rollButton);
					buttonList.add(goButton);
					buttonList.add(stopButton);
					buttonList.add(crapButton);

					for (JButton b : buttonList) {
					    b.setEnabled(false);
					}

					while (true) {
						try{
							serverLine = serverIn.readLine();
							if (serverLine.equals("go")){
								comLabel.setText("\nPioneers are ready for exploration. Please initiate a wormhole stableness calculation.\n");
								clearDice();
								boolean bobo = false;							
								for (JButton b : buttonList) {
						    			b.setEnabled(true);
									bobo = true;
								}
								if(bobo){
									break;
								}
							}else if(serverLine.length()>8 && serverLine.substring(4,5).equals("l")){
								comLabel.setText("\nCommander...we have ran out of fuels completely... Universal Explorer Fleet " + numPlayer +" is now entering stasis mode. Maybe one day we will drift to a new home. Commander " +userName+", it has been an honor...");
								System.out.println(serverIn.readLine());
								boolean bobo = false;							
								if(bobo){
									break;
								}
							}
						}catch(IOException e){
							System.out.println("Problem reading or writing:" + e.getMessage());
						}
						try{
							SwingUtilities.invokeAndWait(new Runnable(){
						
								public void run() {
									
									if(!serverLine.substring(0,1).equals("[")){
																				
										boolean c2 = false;
										boolean c3 = false;		
										int length = serverLine.length();
										if(serverLine.substring(1,2).equals(",")){
											c2 = true;
										}else if(serverLine.substring(2,3).equals(",")){
											c3 = true;
										}
										if(numPlayer == 1){
											if(length == 3){
												numLabel1.setText( serverLine.substring(0,1));
												numLabel2.setText( serverLine.substring(2,3));
												comLabel.setText("\nUnkown fleet transmission detacted.\n");
												setBoard(Integer.parseInt(serverLine.substring(0,1)));
												setBoard(Integer.parseInt(serverLine.substring(2,3)));
												setImage();
											}else if(length == 4 && c3){
												numLabel1.setText( serverLine.substring(0,2));
												numLabel2.setText( serverLine.substring(3,4));
												comLabel.setText("\nUnkown fleet transmission detacted.\n");
												setBoard(Integer.parseInt(serverLine.substring(0,2)));
												setBoard(Integer.parseInt(serverLine.substring(3,4)));
												setImage();

											}else if(length == 4 && c2){
												numLabel1.setText( serverLine.substring(0,1));
												numLabel2.setText( serverLine.substring(2,4));
												comLabel.setText("\nUnkown fleet transmission detacted.\n");
												setBoard(Integer.parseInt(serverLine.substring(0,1)));
												setBoard(Integer.parseInt(serverLine.substring(2,4)));
												setImage();

											}else{
												numLabel1.setText( serverLine.substring(0,2));
												numLabel2.setText( serverLine.substring(3,5));
												comLabel.setText("\nUnkown fleet transmission detacted.\n");
												setBoard(Integer.parseInt(serverLine.substring(0,2)));
												setBoard(Integer.parseInt(serverLine.substring(3,5)));
												setImage();
											}
										}else if(numPlayer ==2){
											if(length == 3){
												numLabel1.setText( serverLine.substring(0,1));
												numLabel2.setText( serverLine.substring(2,3));
												comLabel.setText("\nUnkown fleet transmission detacted.\n");
												setBoard2(Integer.parseInt(serverLine.substring(0,1)));
												setBoard2(Integer.parseInt(serverLine.substring(2,3)));
												setImage();
											}else if(length == 4 && c3){
												numLabel1.setText( serverLine.substring(0,2));
												numLabel2.setText( serverLine.substring(3,4));
												comLabel.setText("\nUnkown fleet transmission detacted.\n");
												setBoard2(Integer.parseInt(serverLine.substring(0,2)));
												setBoard2(Integer.parseInt(serverLine.substring(3,4)));
												setImage();

											}else if(length == 4 && c2){
												numLabel1.setText( serverLine.substring(0,1));
												numLabel2.setText( serverLine.substring(2,4));
												comLabel.setText("\nUnkown fleet transmission detacted.\n");
												setBoard2(Integer.parseInt(serverLine.substring(0,1)));
												setBoard2(Integer.parseInt(serverLine.substring(2,4)));
												setImage();

											}else{
												numLabel1.setText( serverLine.substring(0,2));
												numLabel2.setText( serverLine.substring(3,5));
												comLabel.setText("\nUnkown fleet transmission detacted.\n");
												setBoard2(Integer.parseInt(serverLine.substring(0,2)));
												setBoard2(Integer.parseInt(serverLine.substring(3,5)));
												setImage();
											}

										}
							


									}else { 
										clearDice();
										diceOne= serverLine.substring(1,2);
										diceTwo= serverLine.substring(4,5);
										diceThree= serverLine.substring(7,8);
										diceFour= serverLine.substring(10,11);

										diceButton1.setText( diceOne);
										diceButton2.setText(diceTwo);
										diceButton3.setText(diceThree);
										diceButton4.setText(diceFour);
									}
							
								}
							});
						}catch(InterruptedException e){
							System.out.println("Interrupted:" + e.getMessage());
						}catch(InvocationTargetException e){
							System.out.println("invocation:" + e.getMessage());
						}
					}
				}
			}).start();
	

	}




	static void clearDice(){
		numLabel1.setText( "");
		numLabel2.setText( "");
		diceButton1.setText("0");
		diceButton2.setText("0");
		diceButton3.setText("0");
		diceButton4.setText("0");
	}

	static void pushOneNum(){
		try{		
			String num = numLabel1.getText() + "," + numLabel2.getText();
			serverOut.println(num);	
			serverLine = serverIn.readLine();
			if(serverLine.equals("ack")){
				
				if(numPlayer ==1){
					setBoard(num1);
					setImage();
				}else if(numPlayer ==2){
					setBoard2(num1);
					setImage();
				}




				comLabel.setText("\nPioneer worm hole jump successful.\n");
				numList.add(num1);
			}
		}catch(IOException e){
			System.err.println("Unable to read from or write to the client: " + e.getMessage());
		}
	}

	static void pushTwoNums(){
		try{		
			String num = numLabel1.getText() + "," + numLabel2.getText();
			serverOut.println(num);	
			serverLine = serverIn.readLine();
			if(serverLine.equals("ack")){
				if(numPlayer ==1){
					setBoard(num1);
					setBoard(num2);
					setImage();
				}else if(numPlayer ==2){
					setBoard2(num1);
					setBoard2(num1);
					setImage();
				}
				comLabel.setText("\nPioneer worm hole jump successful.\n");
				numList.add(num1);				
				numList.add(num2);
			}
		}catch(IOException e){
			System.err.println("Unable to read from or write to the client: " + e.getMessage());
		}
	}

	static void pushOneNum2(){
		try{		
			String num = numLabel1.getText() + "," + numLabel2.getText();
			serverOut.println(num);	
			serverLine = serverIn.readLine();
			if(serverLine.equals("ack")){
				
				if(numPlayer ==1){
					setBoard(num2);
					setImage();
				}else if(numPlayer ==2){
					setBoard2(num2);
					setImage();
				}

				comLabel.setText("\nPioneer worm hole jump successful.\n");
				numList.add(num2);
			}
		}catch(IOException e){
			System.err.println("Unable to read from or write to the client: " + e.getMessage());
		}
	}

	static void pushZeroNum(){
		try{		
			String num = numLabel1.getText() + "," + numLabel2.getText();
			serverOut.println(num);	
			serverLine = serverIn.readLine();
			if(serverLine.equals("ack")){
				if(numPlayer ==1){
					setBoard(num1);
					setBoard(num2);
					setImage();
				}else if(numPlayer ==2){
					setBoard2(num1);
					setBoard2(num1);
					setImage();
				}
				comLabel.setText("\nPioneer worm hole jump successful.\n");
			
			}
		}catch(IOException e){
			System.err.println("Unable to read from or write to the client: " + e.getMessage());
		}
	}

	static boolean dupNumOne(){
		boolean bobo = false;		
		if(numList.size()==1 && (num1==numList.get(0))){
			bobo = true;
		}
		if(numList.size()==2 && (num1==numList.get(0)||num1==numList.get(1))){
			bobo = true;	
		}
		if(numList.size()==3 && (num1==numList.get(0)||num1==numList.get(1)||num1==numList.get(2))){
			bobo = true;	
		}

		return bobo;
	}

	static boolean dupNumTwo(){
		boolean bobo = false;		
		if(numList.size()==1 && (num2==numList.get(0))){
			bobo = true;
		}
		if(numList.size()==2 && (num2==numList.get(0)||num2==numList.get(1))){
			bobo = true;	
		}
		if(numList.size()==3 && (num2==numList.get(0)||num2==numList.get(1)||num2==numList.get(2))){
			bobo = true;	
		}

		return bobo;
	}

	//for PLAHYER 1 set the status of the board by passing one of the pair numbers
        static void setBoard(int column){
		column =column-2;
		int i=12;
		boolean check = false; 
		System.out.println("setboard");
		while (i>=1 && !check){	

			// nothing in column
			System.out.println("start");
			if(empty(column)){
				board[12][column]= 1;  
				check = true; 
			System.out.println("first");
			}
			//find a tmarker 
			else if(board[i][column]== 1) {
				if (board[i-1][column] == 0){
					board[i-1][column] = 1;
					board[i][column]= 0;
					check = true; 
				}
				else if (board[i-1][column] == 4){
					board[i-1][column] = 7;
					board[i][column]= 0;
					check = true; 				
				}  // conquer and there is no  pmarker below
				else if ((board[i-1][column] > 8) &&(!checkP1(column))){
										
					board[i-1][column] = board[i-1][column] + 1;
					board[i][column]= 0;	
					check = true; 			
				}
				// conquerand there is a pmarker below 
				else if((board[i-1][column] > 8) && (checkP1(column))){
					board[i-1][column] = board[i-1][column] + 1;
					board[i][column]= 0;
					int findP1 = findP1(column);
						if ( board[findP1][column] == 3){
							board[findP1][column] = 0;
						}

						else if ( board[findP1][column] == 6){
							board[findP1][column] = 4;
						}

					check = true; 			
				}	

			}
	
			//find a pmarker there is no tmarker
			else if(board[i][column]== 3 && !checkT1(column)) {	
				// there is a p2				
				if (board[i-1][column] == 4){
					board[i-1][column] = 7;
					check = true; 
					//board[i][column]= 3;
				}// conquer
				else if (board[i-1][column] > 8){
					board[i-1][column] = board[i-1][column] + 1;
					//change pmarker to 0;
					
					
					board[i][column]= 0;
					check = true; 
				}

			}
			// find p1p2
			else if(board[i][column]== 6 && !checkT1(column)) {	
				//if (board[i+1][column] = 4){
				// next is top
				if(board[i-1][column] > 8){
					board[i-1][column] = board[i-1][column] + 1;
					//change pmarker to 0;


					board[i][column]= 4;
					check = true; 
				}
				//next is empty
				else if(board[i-1][column]== 0){
					board[i-1][column] = 1;
					//board[i][column]= 4;
					check =true;
				}
					//board[i-1][column] = 7;
					//check = true; 
					//board[i][column]= 6;
			}
			 //no pmarker or tmarker in this column, find p2
			else if(board[i][column]== 4 && !checkT1(column)) {	
			
				board[i][column] = 7;
				check = true; 
			}
			// find t1p2
			else if(board[i][column] == 7 && !checkT1(column)) {	
				System.out.println("check7");
				if(board[i-1][column] > 8){
					board[i-1][column] = board[i-1][column] + 1;
					board[i][column]= 4;
					if (checkP1(column) ){

						board[findP1(column)][column]= 0;
					}
					check = true; 
				}
				else if (board[i-1][column]==0){
					
					board[i-1][column] = 1;
					board[i][column]= 4;
					check =true;
				}
			}			
			i --;
		
		}

	}

	//for PLAHYER2 set the status of the board by passing one of the pair numbers
        static void setBoard2(int column){
		column =column-2;
		int i=12;
		boolean check = false; 
		System.out.println("setboard");
		while (i>=1 && !check){	

			// nothing in column
			System.out.println("start");
			if(empty(column)){
				board[12][column]= 2;  
				check = true; 
			System.out.println("first");
			}
			//find a tmarker 
			else if(board[i][column]== 2) {
				if (board[i-1][column] == 0){
					board[i-1][column] = 2;
					board[i][column]= 0;
					check = true; 
				}
				// THERE IS A P1
				else if (board[i-1][column] == 3){
					board[i-1][column] = 8;
					board[i][column]= 0;
					check = true; 				
				}  // conquer and there is no  pmarker below
				else if ((board[i-1][column] > 8) &&(!checkP2(column))){
										
					board[i-1][column] = board[i-1][column] + 2;
					board[i][column]= 0;	
					check = true; 			
				}
				// conquerand there is a pmarker below 
				else if((board[i-1][column] > 8) && (checkP2(column))){
					board[i-1][column] = board[i-1][column] + 2;
					board[i][column]= 0;
					int findP2 = findP2(column);
						if ( board[findP2][column] == 4){
							board[findP2][column] = 0;
						}

						else if ( board[findP2][column] == 6){
							board[findP2][column] = 3;
						}

					check = true; 			
				}	

			}
	
			//find a pmarker there is no tmarker
			else if(board[i][column]== 4 && !checkT2(column)) {	
				// there is a p1				
				if (board[i-1][column] == 3){
					board[i-1][column] = 8;
					check = true; 
					//board[i][column]= 3;
				}// conquer
				else if (board[i-1][column] > 8){
					board[i-1][column] = board[i-1][column] + 2;
					//change pmarker to 0;

					
					board[i][column]= 0;
					check = true; 
				}

			}
			// find p1p2
			else if(board[i][column]== 6 && !checkT2(column)) {	
				//if (board[i+1][column] = 4){
				// next is top
				if(board[i-1][column] > 8){
					board[i-1][column] = board[i-1][column] + 2;
					//change pmarker to 0;

					board[i][column]= 3;
					check = true; 
				}
				//next is empty
				else if(board[i-1][column]== 0){
					board[i-1][column] = 2;
					//board[i][column]= 4;
					check =true;
				}
					//board[i-1][column] = 7;
					//check = true; 
					//board[i][column]= 6;
			}
			 //no pmarker or tmarker in this column, find p1
			else if(board[i][column]== 3 && !checkT2(column)) {	
			
				board[i][column] = 8;
				check = true; 
			}
			// find t1p2
			else if(board[i][column] == 8 && !checkT2(column)) {	
				System.out.println("check8");
				if(board[i-1][column] > 8){
					board[i-1][column] = board[i-1][column] + 2;
					board[i][column]= 3;

					if (checkP2(column) ){

						board[findP2(column)][column]= 0;
					}
					check = true; 

	
					check = true; 
				}
				else if (board[i-1][column]==0){
					
					board[i-1][column] = 2;
					board[i][column]= 3;
					check =true;
				}
			}			
			i --;
		
		}

	}
	// set the image according to the board satus

		
	static void stopRun(){

		for(int i = 0; i<13;i++){
			for (int j = 0; j <11;j++){
				if (board[i][j]== 1 ){
					 box[i][j].setIcon(picture[3]);
				}

				else if (board[i][j]== 2 ){
					 box[i][j].setIcon(picture[4]);
				}

				else if (board[i][j]== 7 ){
					 box[i][j].setIcon(picture[6]);
				}
		
				else if (board[i][j]== 8 ){
					 box[i][j].setIcon(picture[6]);
				}
			}
		}

	}

		// check conquered.
	static boolean checkConquer(int column){
		boolean checkConquer = false;
		int i =0;
		while(!checkConquer && i<13){
			//board[i][column-2] 
			if (board[i][column-2]>100 &&board[i][column-2]%10 >0){
				checkConquer = true;
			}
			i ++;
		}
		return checkConquer;

	}
		// there is pmarker, return true 
	 static boolean checkP1(int column){
		
		boolean checkP1 = false;
		int i = 12;
		boolean top = false;
		while (i>=1 && !checkP1 && !top){
			if(board[i][column] >8){
				top = true;
			}
			else if (board[i][column]==3 ||board[i][column]==6){
				checkP1 = true;
			}	
			i--;
		}
		System.out.println("checkP");
		return checkP1;

	}

	// there is pmarker, return true 
	 static boolean checkP2(int column){
		
		boolean checkP2 = false;
		int i = 12;
		boolean top = false;
		while (i>=1 && !checkP2 && !top){
			if(board[i][column] >8){
				top = true;
			}
			else if (board[i][column]==4 ||board[i][column]==6){
				checkP2 = true;
			}	
			i--;
		}
		System.out.println("checkP");
		return checkP2;

	}
		//find p1
		static int findP1(int column){
		
		int findP1 = -2;
		int i = 12;
		boolean top = false;
		while (i>=1 && !top){
			if(board[i][column] >8){
				top = true;
			}
			
			else if ((board[i][column]==3)||(board[i][column]==6)){ 
				findP1 = i;
			}
			
			i--;
		}
		System.out.println("findP");
		return findP1;

	}

		//find p1
		static int findP2(int column){
		
		int findP2 = -2;
		int i = 12;
		boolean top = false;
		while (i>=1 && !top){
			if(board[i][column] >8){
				top = true;
			}
			
			else if ((board[i][column]==4)||(board[i][column]==6)){ 
				findP2 = i;
			}
			
			i--;
		}
		System.out.println("findP");
		return findP2;

	}


		// there is  tmarker, return true 
	 static boolean checkT1(int column){
		
		boolean checkT1 = false;
		int i = 12;
		boolean top = false;
		while (i>=1 && !checkT1 && !top){
			if(board[i][column] >8){
				top = true;
			}
			else if (board[i][column]==1){
				checkT1 = true;
			}
			i--;
		}
		System.out.println("checkT");
		return checkT1;

	}

		// there is  tmarker, return true 
	 static boolean checkT2(int column){
		
		boolean checkT2 = false;
		int i = 12;
		boolean top = false;
		while (i>=1 && !checkT2 && !top){
			if(board[i][column] >8){
				top = true;
			}
			else if (board[i][column]==2){
				checkT2 = true;
			}
			i--;
		}
		System.out.println("checkT");
		return checkT2;

	}

	static boolean empty(int column){
		
		boolean empty = true;
		int i = 12;
		boolean top = false;
		while (i>=1 && empty && !top){
			if(board[i][column] >8){
				top = true;
			}
			else if (board[i][column]>0){
				empty = false;
			}
		i--;

		}
		System.out.println("done");
		return empty;

	}
	

	static void setImage(){
		for(int i = 0; i<13;i++){
			for (int j = 0; j <11;j++){
				if (board[i][j]< 9 && board[i][j]> -1 ){
					 int p = board[i][j];
					 box[i][j].setIcon(picture[p]);
				}
				
				else if (board[i][j]>10 && (board[i][j]<200)){
					int k = board[i][j];
					box[i][j].setIcon(pic[k%10][(k/10)-10]);	
				}
				else if((board[i][j]>=200)){
					int k = board[i][j];
					box[i][j].setIcon(pic[k-200][(k/10)-10]);
				}
			}
		}
	}
	
	
	
	
	/*public void paint(Graphics g) {
		super.paint(g);
		if(bgImg != null) g.drawImage(bgImg, 0,0,getWidth(),getHeight(),this);
		else g.drawString("No Image",100,100);
   }*/
}

/*class BackgroundPanel extends Panel
{
  Image img;
  public BackgroundPanel()
  {
    try
    {
      img = Toolkit.getDefaultToolkit().createImage("../Img/bg1.jpg");

	  
    }
    catch(Exception e){}
  }
  public void paint(Graphics g)
  {
    super.paint(g);
	System.out.println("asad");
    if(img != null) g.drawImage(img, 0,0,getWidth(),getHeight(),this);
    else g.drawString("No Image",100,100);
  }
}*/

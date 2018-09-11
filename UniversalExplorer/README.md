# Universal Explorer

## Introduction
   - Universal Explorer is a Java remake of the classic board game [Can't Stop](https://en.wikipedia.org/wiki/Can%27t_Stop_(board_game)).
   - The project is Co-design and created with **Ping Zhang**.
   - The project was an ambitious attempt in my **first year** into coding, thus the code is very **complex and messy**.
   - Noticible skils involved: *Core Java, JSwing/AWT, Socket Server/Client Connection, Photoshop, Project Design and Management.*
   
## Installation (Running locally)
   - Download or clone the repo
   - Navigate to Server folder and compile all files, then navigate to Client folder and compile all files
   - Start a local server by running **Driver.java** in the server folder.
   - Start the client by running **ClientFrame.java** and with parameter **"localhost 2333"**. (Java ClientFrame localhost 2333)
   - Start another client as player two by repeating the above process.
   - The game starts.
   
## Story
You are the commander of the universal exploring team. Your mission is to find 3 planets for human immigration before your opponent does. You have  3 Pioneers to travel through the wormhole to explore the space, and once the Pioneers reach a planet, you can conquer the planet with one of the 11 Civilization carrier under your command. However, the wormholes are the most dangerous places in the universe...You have to calculate your jumps carefully and make decisions wisely... 


## Tutorial
The top section is the game board, which presents users’ choices and effects in real time. 
- The 11 planets are initially dim to indicate that they have not yet been explored. 
- Each user has two types of ships, 3 Exploration Pioneers, and 11 Civilization Carriers.
- Between the 11 Civilization Carriers and the 11 unexplored planets is the Wormhole roadmap.

![Tutorial Image](https://github.com/lzhlchmxl/Funzy-Projects-Master-List/blob/master/UniversalExplorer/UE_tutorial.png)

The bottom section is the control panel, which allows users to give commands to their entire fleet.
- The green button ‘CALC’ calculates the current stable wormhole indexes. The four indexes are displayed on the bottom right of the screen. Based on the indexes, the player will have to click on the indexes to group them into 2 numbers to indicate which wormholes the Pioneers should jump through and further explore the unknown space. 
- After the user picked the two numbers, he/she can then confirm the jump by clicking on the purple button ‘EXPL’. The server will make sure whether they are valid commands. 
- After the jump, the user may choose to calculate new indexes and prepare for the jump again or they can send out Carriers to stabilize the wormhole by clicking the ‘STAB’ button. 
- At last, if none of the wormholes are stable based on the indexes, then the user will have to click ‘ABAN’ to abandon the mission and recall all Pioneers.
- Bottom right is a display zone which shows the calculated indexes. If the input numbers cannot make the jump, the display zone will glow red, otherwise light blue.

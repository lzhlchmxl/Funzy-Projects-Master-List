//import java.awt.event.*;
import java.awt.*;
Robot rbt;
float X = 100;
float Y = 100;
float W = 48;
float H = 48;

float targetDistance = 0;

float coe=2;
float b = 0.3;

boolean change = false;
boolean oneTime = false;
boolean skipAFrame = false;
boolean lock = false;
CustomCursor cursor = new CustomCursor(mouseX, mouseY);
Targets myRect = new Targets(X, Y, W, H, 300);

boolean overShoot = false;

float mouseInitXPos;
float mouseInitYPos;

PFont f;
PrintWriter output;

float consoleX;
float coneoleY;

Console c;

int timer; // define the timer to measure user performance
int timeTracker = 0; //Tracks time differences.
int falseClick; //define falseClick, used to measure number of falseClicks user had before hitting the target

String msg = "Type in your user number on the keyboard now: ";
String buttonMsg = "Click to Continue";
float buttonMsgX;
float buttonMsgY;
float buttonX;
float buttonY;
float messageX;
float messageY;


// Printing Data
int userID = 0;
int blockNum = 1;
int trialNum = 1;
int targetWidth;
int elapsedTime;
int numberOfErrors;
int mousePosition = 0;

int counter = 0;

// Stage control
int stage = 0;
boolean practicing = false;
boolean conditionLock = false;
boolean began = false;
boolean onBreak = true;

boolean skip = true;

void setup(){
  noCursor();
  fullScreen();
  
  // Create a new file in the sketch directory
    output = createWriter("data.txt");     
    
  // Can be cleaned up
  consoleX = width * 0.45;
  coneoleY = height/2 + 50;
  buttonX = width * 0.42;
  buttonY = height*0.60;
  messageX = width/2-400;
  messageY = height/2-50;
  buttonMsgX = buttonX + 100;
  buttonMsgY = buttonY + 55;
  
  f = createFont("Arial",16,true); // Create font
  c = new Console(consoleX,coneoleY,30);
  c.activate();
  
  try {
    rbt = new Robot();
  } 
  catch (Exception e) {
    e.printStackTrace();
  }
  
  myRect.changeState(myRect.getState());

}

void draw(){
  background(204, 153, 0);
  fill(255);
  rect(buttonX, buttonY, 400, 100); // draw the confirmation button
  timer = millis();
  if (!onBreak) {
    
    if (myRect.overRect()) {
      fill(color(255,0,255));
    } else {
      fill(255);
    }
    myRect.display();
     
  
   if (mouseX == 0 || mouseX == displayWidth-1 || mouseY == 0 || mouseY == displayHeight-1) {
  
     change = true;
  
   }
   
   if (change) {
      change = false;
      lock = true;
      rbt.mouseMove(500,500);
   }
  }
  
  
  fill(0);
  cursor.adjustPosition();
  cursor.display();
  textFont(f,40);  // Specify font to be used
  text(msg, messageX, messageY);  
  c.display(); // display userinput
  text(buttonMsg, buttonMsgX, buttonMsgY); // draw the confirmation message
  
   
  
  

  
  
  

}

//stickey
void mouseMoved(){
  float deltaX = mouseX-pmouseX;
  float deltaY = mouseY-pmouseY;
  
  if (stage == 0 && !lock) {
    cursor.move(deltaX, deltaY);
  }
  
  if (stage == 1 && !lock) {
    cursor.move(deltaX, deltaY);
  }
  
  if (stage == 2 && !lock) {
    sticky( deltaX,  deltaY);
  }
  
  if (stage == 3) {
    
    if ((mouseInitXPos - myRect.getCenterX() < 0 && cursor.mouseX() - myRect.getCenterX() > 200) ||
        (mouseInitXPos - myRect.getCenterX() > 0 && cursor.mouseX() - myRect.getCenterX() < -200)||
        (mouseInitYPos - myRect.getCenterY() < 0 && cursor.mouseY() - myRect.getCenterY() > 200) ||
        (mouseInitYPos - myRect.getCenterY() > 0 && cursor.mouseY() - myRect.getCenterY() < -200)) {
          overShoot = true;    
    }
   
   
    if(myRect.overField() && !lock && !overShoot){
      float vx;
      float vy;
      vx=coe*abs(cursor.mouseX()-myRect.getCenterX())/myRect.getFieldLength();
      vy=coe*abs(cursor.mouseY()-myRect.getCenterY())/myRect.getFieldLength();
      //vx = 1;
      //vy = 1;
      //println(myRect.getCenterX());
      //println(cursor.mouseX());
      //println(abs(cursor.mouseX()-myRect.getCenterX())/myRect.getFieldLength());
      if (deltaX > 0 && deltaY > 0) {
        cursor.move(deltaX*vx+b, deltaY*vy+b);
      } else if (deltaY > 0) {
        cursor.move(deltaX*vx-b, deltaY*vy+b);
      } else if (deltaX > 0) {
        cursor.move(deltaX*vx+b, deltaY*vy-b);
      } else {
        cursor.move(deltaX*vx-b, deltaY*vy-b);
      }
      // println(vx);
      //println("lol");
    }
    else if (!lock && !overShoot){
      cursor.move(deltaX*3, deltaY*3);
      //println("haha");
    } else if (!lock) {
      sticky( deltaX,  deltaY);
      
      //println("bubu");
    } 
    
  }
  if (mouseX == 500 || mouseY == 500) {
    lock = false;
  }
}


void mousePressed() {
  
  
  if (stage == 1) {    
    if (myRect.overRect()) {
      counter++;     
      
      if (counter < 6) {
        createTarget();
      }
      
      if (counter == 6) {
        practicing = false;
        setMessage();
        addDialog();
        onBreak = true; 
        skip = true;
      }
      
      if (6 < counter && counter < 27) {
        if (skip) {
          skip = false;
          timeTracker = timer;
          createTarget();           
          falseClick = 0;
        } else {
          printLine();
          timeTracker = timer;
          createTarget();
          falseClick = 0; // reset falseClick counter;
          trialNum++; // increment trial number; 
        
        }
      }
      
      if (counter == 27) {
        printLine();
        conditionLock = false;
        myRect.hide();
        initiateMessage();      
      }
    } else {
      falseClick++;
    }
   
  }
  
  if (stage == 2) {    
    if (myRect.overRect()) {
      counter++;     
      
      if (counter < 6) {
        createTarget();
      }
      
      if (counter == 6) {
        practicing = false;
        setMessage();
        addDialog();
        onBreak = true;
        skip = true;
      }
      
      if (6 < counter && counter < 27) {
        if (skip) {
          skip = false;
          timeTracker = timer;
          createTarget();           
          falseClick = 0;
        } else {
          printLine();
          timeTracker = timer;
          createTarget();
          falseClick = 0; // reset falseClick counter;
          trialNum++; // increment trial number; 
        
        }
      }
      
      if (counter == 27) {
        printLine();
        conditionLock = false;
        myRect.hide();
        initiateMessage();      
      }
    } else {
      // number of error
      falseClick++;
    }
   
  }
  
  if (stage == 3) {
    mouseInitXPos = cursor.mouseX();
    mouseInitYPos = cursor.mouseY();
    
    if (myRect.overRect()) {
       counter++;     
      
      if (counter < 6) {
        createTarget();
      }
      
      if (counter == 6) {
        practicing = false;
        setMessage();
        addDialog();
        onBreak = true;
        skip = true;
      }
      
      if (6 < counter && counter < 27) {
        if (skip) {
          skip = false;
          timeTracker = timer;
          createTarget();           
          falseClick = 0;
        } else {
          printLine();
          timeTracker = timer;
          createTarget();
          falseClick = 0; // reset falseClick counter;
          trialNum++; // increment trial number; 
        
        }
      }
      
      if (counter == 27) {
        printLine();
        conditionLock = false;
        myRect.hide();
        initiateMessage();      
      }
      
    } else {
      // number of error
      falseClick++;
    }
    overShoot = false;
    setField();
  }
}

void initiateMessage() {
  messageX = width * 0.33;
  messageY = height * 0.45;
  buttonX = -100;
  buttonY = -100;
  consoleX = -100;
  c.changeLocation();
  msg = "Press 1, 2 or 3 on the keyboard to initiate";
  buttonMsg = "";
}

void sticky(float deltaX, float deltaY) {
  if (myRect.overRect()){
    cursor.move(deltaX*0.2, deltaY*0.2);
  } else {
    cursor.move(deltaX, deltaY);
  }
}

void createTarget() {
  int state;
  do {
     state = Math.round(random(1, 4));
  } while (state == myRect.getState());
  myRect.changeState(state);
}


// mouseClick() won't trigger when user click left button, then move, then release; That's why I used mouseReleased() instead
void mouseReleased(){

    // if the continue button is clicked while the exprienment hasn't began
    if (cursor.mouseX()>buttonX && cursor.mouseX()< buttonX+400 && cursor.mouseY() > buttonY && cursor.mouseY() < buttonY+100 && !began) { 
      // Clear the screen by pushing things out of view and set string blank;
      initiateMessage();
      began = true;
      timeTracker = timer; // Initialize the difference between the two timers;
      falseClick = 0; // Initializa falseClick; 
      println("UserID\tTrial#\tCondition\t\tElapsedTime\tnumberOfErrors");  
      output.println("UserID\tTrial#\tCondition\tElapsedTime\tnumberOfErrors");
        
           
    } else if (cursor.mouseX()>buttonX && cursor.mouseX()< buttonX+400 && cursor.mouseY() > buttonY && cursor.mouseY() < buttonY+100 && (stage == 1 || stage == 2 || stage == 3)) {
      removeDialog();
      createTarget();
      onBreak = false;
    }
}


// detect if a key is pressed, calls keyAnalyzer to determine what type of input it is
void keyPressed()
{
    if (!began) {
       if (keyAnalyzer(key).compareTo("NUMBER") == 0) {
         c.addChar(key);
       } if (keyCode == BACKSPACE) {
          c.deleteChar();
     /*  } if (key == 'X' || key == 'x') {
          output.flush(); // Writes the remaining data to the file
          output.close(); // Finishes the file
          exit(); // Stops the program */
       }
    } else if (key == '1' && !conditionLock) {
     
      stage = 1; // I choose to name condition '1' and '2' instead of '0' and '1', because users were asked to press '1' or '2', so it is easy for us to remember 1 is normal, 2 is sticky.
      conditionLock = true;
      
      practicing = true;
      setMessage();
      addDialog();
      practicing = true;
      counter = 0;
      
    } else if (key == '2' && !conditionLock) {
      stage = 2;
      conditionLock = true;
      
      practicing = true;
      setMessage();
      addDialog();
      practicing = true;
      counter = 0;
          
    } else if (key == '3' && !conditionLock) {
      stage = 3;
      conditionLock = true;
      
      practicing = true;
      setMessage();
      addDialog();
      practicing = true;
      counter = 0;
    } else if (key == 'x' && !conditionLock) {
      output.flush(); // Writes the remaining data to the file
      output.close(); // Finishes the file
      exit(); // Stops the program
    }
}

void printLine() {
    String conditionStr = "";
    if (stage == 1) {
      conditionStr = "normal targeting";
    } else if (stage == 2) {
      conditionStr = "sticky targeting";
    } else if (stage == 3) {
      conditionStr = "enhanced targeting";
    }
    println(c.readString() + "\t" + trialNum + "\t" + conditionStr + "\t" + (timer - timeTracker) + "\t\t" + falseClick );  
    output.println(c.readString() + "\t" + trialNum + "\t" + conditionStr + "\t" + (timer - timeTracker) + "\t\t" + falseClick );  
 }


void setMessage() {
   if (stage == 1) {
     if (practicing) {
       msg = "Please select each bar as quickly and accurately as possible. Normal targeting 1 of 2";
       buttonMsg = "Click to begin PRACTICE";
     } else {
       msg = "Please select each bar as quickly and accurately as possible. Normal targeting 2 of 2";
       buttonMsg = "Click to begin EVALUATION";
     }
   } else if (stage == 2) {
     if (practicing) {
       msg = "Please select each bar as quickly and accurately as possible. Sticky targeting 1 of 2";
       buttonMsg = "Click to begin PRACTICE";
     } else {
       msg = "Please select each bar as quickly and accurately as possible. Sticky targeting 2 of 2";
       buttonMsg = "Click to begin EVALUATION";
     } 
   } else if (stage == 3) {
     if (practicing) {
       msg = "Please select each bar as quickly and accurately as possible. Enhance targeting 1 of 2";
       buttonMsg = "Click to begin PRACTICE";
     } else {
       msg = "Please select each bar as quickly and accurately as possible. Enhance targeting 2 of 2";
       buttonMsg = "Click to begin EVALUATION";
     }
   } else if (stage == 4) {
     msg = "Thank you! The experiement has been completed.";
     buttonMsg = "Click to exit program";
   }
 }
 
 
 void removeDialog() {
     buttonX = -100; 
     buttonY = -100;
     messageX = -100;
     messageY = -100;
     msg = "";
     buttonMsg = "";
  }
  
  void addDialog() {
     buttonX = width * 0.42;
     buttonY = height*0.60;
     buttonMsgX = buttonX + 20;
     messageX = width * 0.15;
     messageY = height * 0.45;
     
     if (stage == 4) {
       messageX = width * 0.30;
       buttonMsgX = buttonX + 50;
     }
  }



void setField() {
  // Get the targetDistance from fake cursor to New target in 2D
  targetDistance = sqrt(pow(cursor.mouseX() - myRect.getCenterX(), 2) + pow(cursor.mouseY() - myRect.getCenterY(), 2));
  
  //Generate and set new Field based on the target distance
  float newField;
  if (targetDistance - myRect.rectWidth/2 > 1000) {
    newField = targetDistance * 0.5 - myRect.rectWidth/2;
  } else if (targetDistance - myRect.rectWidth/2 > 500){
    newField = targetDistance * 0.7 -150 - myRect.rectWidth/2; 
  } else if (targetDistance - myRect.rectWidth/2 > 300) {
    newField = targetDistance -300;
  } else {
    newField = 0; 
  }
  
  
  myRect.setField(newField);

  //println(newField);
}


//draw cursor
class CustomCursor{
  float xPos;
  float yPos;

  CustomCursor(float tempX, float tempY) {
    xPos = tempX;
    yPos = tempY;
  }
  
  void display() {
    noStroke();
    fill(color(0,0,0));
    triangle(xPos, yPos, xPos, yPos+18, xPos+8,yPos+12);
  }
  void move(float deltaX, float deltaY){
        
    if ((xPos >= 0 && deltaX < 0) || (xPos <= displayWidth - 7 && deltaX > 0)) { 
      xPos+=deltaX;      
    }
   
    if ((yPos >= 0 && deltaY < 0) || (yPos <= displayHeight - 10 && deltaY > 0)) {
      yPos+=deltaY;
    }

  }
  
  void adjustPosition() {
    if (xPos < 0) {
      xPos = 0;
    } else if (xPos > displayWidth-7) {
      xPos = displayWidth - 7;
    } else if (yPos < 0) {
      yPos = 0;
    } else if (yPos > displayHeight-10) {
      yPos = displayHeight - 10;
    }
  }
  
  float mouseX(){
    return xPos;
  }
  float mouseY(){
    return yPos;
  }  
  
}

//four targets
class Targets{
  int state = Math.round(random(1, 4));
  float rectX;
  float rectY;
  float rectWidth;
  float rectHeight;
  boolean rectOver;
  boolean fieldOver;
  float field;
  float rectCenterX;
  float rectCenterY;
  float fieldLength;
  Targets(float xIn, float yIn, float wIn, float hIn, float fieldIn){
    rectX = xIn;
    rectY = yIn;
    rectWidth = wIn;
    rectHeight = hIn;
    field=fieldIn;
    rectCenterX=rectX+rectWidth/2;
    rectCenterY=rectY+rectHeight/2;
    fieldLength=field+rectWidth/2;

  }
  
  int getState() {
    return state;
  }
  
  float getCenterX() {
    return rectCenterX;    
  }
  
  float getCenterY() {
    return rectCenterY;    
  }
  float getFieldLength(){
    return fieldLength;
  }
  
  void setField(float newField) {
    field = newField;
  }
  
  void hide() {
    rectX = 999999;
  }
  
  void display() {
    noStroke();
    //rectMode(CENTER)
    rect(rectX, rectY, rectWidth, rectHeight);
  }
 //Check if the drwan cursor is in the target
  boolean overRect()  {
    if (cursor.mouseX() >= rectX && cursor.mouseX() <= rectX+rectWidth && 
      cursor.mouseY() >= rectY && cursor.mouseY() <= rectY+rectHeight) {
      rectOver = true;
    } 
    else {
      rectOver = false;
    }
    return rectOver;
  } 
   boolean overField()  {
    if (cursor.mouseX() >= rectX-field && cursor.mouseX() <= rectX+rectWidth+field && 
      cursor.mouseY() >= rectY-field&& cursor.mouseY() <= rectY+rectHeight+field) {
      fieldOver = true;
    } 
    else {
      fieldOver = false;
    }
    return fieldOver;
  }
  
  void changeState(int index) {
    if (index == 1) {
      rectX = 200;
      rectY = 200;
      rectCenterX=rectX+rectWidth/2;
      rectCenterY=rectY+rectHeight/2;
      fieldLength=field+rectWidth/2;
      state = 1;
    
    } else if (index == 2) {
      rectX = displayWidth - 200;
      rectY = 200;
      rectCenterX=rectX+rectWidth/2;
      rectCenterY=rectY+rectHeight/2;
      fieldLength=field+rectWidth/2;
      state = 2;
    
    } else if (index == 3) {
      rectX = 200;
      rectY = displayHeight - 200;
      rectCenterX=rectX+rectWidth/2;
      rectCenterY=rectY+rectHeight/2;
      fieldLength=field+rectWidth/2;
      state = 3;
    
    } else {
      rectX = displayWidth - 200;
      rectY = displayHeight - 200;
      rectCenterX=rectX+rectWidth/2;
      rectCenterY=rectY+rectHeight/2;
      fieldLength=field+rectWidth/2;
      state = 4;
    
    } 
  }
}

String keyAnalyzer(char c)
{
    if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
    {
        return "NUMBER";
    }
    else if (c == 'A' || c == 'a' || c == 'B' || c == 'b' || c == 'C' || c == 'c' || c == 'D' || c == 'd' || c == 'E' || c == 'e' ||
             c == 'F' || c == 'f' || c == 'G' || c == 'g' || c == 'H' || c == 'h' || c == 'I' || c == 'i' || c == 'J' || c == 'j' ||
             c == 'K' || c == 'k' || c == 'L' || c == 'l' || c == 'M' || c == 'm' || c == 'N' || c == 'n' || c == 'O' || c == 'o' ||
             c == 'P' || c == 'p' || c == 'Q' || c == 'q' || c == 'R' || c == 'r' || c == 'S' || c == 's' || c == 'T' || c == 't' ||
             c == 'U' || c == 'u' || c == 'V' || c == 'v' || c == 'W' || c == 'w' || c == 'X' || c == 'x' || c == 'Y' || c == 'y' ||
             c == 'Z' || c == 'z')
    {
        return "LETTER";
    }
    else
    {
        return "OTHER";
    }
}

// Console class that controls the user input
class Console
{
    float x;
    float y;
    String chars;
    int numChars;
    boolean active;
    int font;
    
    Console(float x, float y, int font)
    {
        this.x = x;
        this.y = y;
        active = false;
        this.font = font;
        chars = "";
        numChars = 0;
    }
    
    void changeLocation() {
        x = -1000;    
    }
    
    void display()
    {
        line(x,y,x,y+font);
        textSize(font);
        text(chars,x,y);
    }
    
    void addChar(char c)
    {
        chars += c;
        numChars++;
    }
    
    String readString()
    {
        return chars;
    }
    
    boolean isActive()
    {
        return active;
    }
    
    void activate()
    {
        active = true;
    }
    
    void deactivate()
    {
        active = false;
    }
    
    void reset()
    {
        chars = "";
    }
    
    void deleteChar()
    {
            if (numChars > 0)
            {        
                  chars = chars.substring(0,chars.length()-1);
                  numChars -= 1;
            }
    }
}
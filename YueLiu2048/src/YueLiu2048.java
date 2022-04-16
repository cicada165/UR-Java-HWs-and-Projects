/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: 
 * TA: 
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.*;

public class YueLiu2048 extends JFrame{
	 // move
    final public static int MOVE_UP = 0xf37;
    final public static int MOVE_DOWN = 0xf36;
    final public static int MOVE_LEFT = 0xf35;
    final public static int MOVE_RIGHT = 0xf34;
    // game status
    final public static int GAME_OVER = 0xf33;
    final public static int GAME_CONTINUE = 0xf32;
    final public static int GAME_WIN = 0xf31;
    // button event
    final public static int BUTTON_NEW_GAME = 0xf30;
    final public static int BUTTON_ABOUT = 0xf28;
    final public static int BUTTON_EXIT = 0xf27;
    //key event
    final public static int KEY_Q = 0xf81;
    final public static int KEY_R = 0xf82;
    
    public  int max = 0;
	private int column;
	private static int row;
	
	private JMenuItem stepCounter;
	
	//The HashMap that is actually shown
	private HashMap<Point, Cube> viewList;
	/*A copy of the the viewList but is not shown. This is used to determine if there is any possible move that can be done. 
	 * It is used to determine if the game is over. If no possible moves exist, player loses the game.
	 */
	private HashMap<Point, Cube> testList;
	
	//Keep track the game state
	private int gameState;
	//Valid movies counter object
	public int count;
	
	//Main class
	public static void main(String[] args) {
		//Standard 4*4 2048, you can make it any value you want
		YueLiu2048 game = new YueLiu2048(400,400);
		game.setTitle("2048");
		game.setLocationRelativeTo(null);
		game.setVisible(true);
		game.newGame();
	}
	
	public YueLiu2048() {
		this(400,500);
		
	}
	
	public YueLiu2048(int width, int height) {
		//Each square is 100*100 pixels on the HashMap
		column = width / 100;
		row = height / 100;
		
		viewList = new HashMap<>();
		testList = new HashMap<>();
		this.addKeyListener(new MyKeyListener(this));
		
		 this.setLayout(new GridLayout(row,column));
		 //Enabling window event
	     enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	     this.setSize(width,height);
	     //Extra features: JMenu
	     JMenuBar jmb = new JMenuBar();
	     JMenu jm = new JMenu("Game");
	     //Extra feature: Button NEW GAME
	     JMenuItem item1 = new JMenuItem("NEW GAME");
	     item1.addMouseListener(new MyMouseListener(this, YueLiu2048.BUTTON_NEW_GAME));
	     //Extra feature: Button EXIT GAME
	     JMenuItem item2 = new JMenuItem("Exit GAME");
	     item2.addMouseListener(new MyMouseListener(this, YueLiu2048.BUTTON_EXIT));
	     
	     jm.add(item1);
	     jm.add(item2);
	     //Extra feature BUTTON ABOUT
	     JMenu jm2 = new JMenu("ABOUT");
	     JMenuItem item3 = new JMenuItem("ABOUT");
	     
	     item3.addMouseListener(new MyMouseListener(this, YueLiu2048.BUTTON_ABOUT));
	     jm2.add(item3);
	     
	     stepCounter = new JMenuItem();
	     
	     jmb.add(jm);
	     jmb.add(jm2);
	     jmb.add(stepCounter);
	     setJMenuBar(jmb);
	     //Build viewList
	     for (int i = 0; i < row; i++) {
	            for (int j = 0; j < column; j++) {
	                viewList.put(new Point(i, j), new Cube());
	                this.add(getView(i, j).getView());
	            }
	        }
	     //Build testList, which is the copy of viewList
	     for (int i = 0; i < row; i++) {
	            for (int j = 0; j < column; j++) {
	                testList.put(new Point(i, j), new Cube());
	            }
	        }

	}
	//Initialize, set all cubes to zero
	public void initialise() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                getView(i, j).setText(0);
            }
        }
       
        createCube();
        createCube();
        copyList();
        count = 0;
        stepCounter.setText("Valid Move Counter：" + count);
       gameState = YueLiu2048.GAME_CONTINUE;
        this.setTitle("2048");
    }
	
	//Press R to call or you can use the tool Bar
	public void newGame() {
        if (gameState == YueLiu2048.GAME_CONTINUE) {
            int jop = JOptionPane.showConfirmDialog(null, "Do you want to start a new game?", "Tips",
                    JOptionPane.YES_NO_OPTION);

            if (jop == JOptionPane.YES_OPTION) {
                initialise();
            }
        } else {
            initialise();
        }
    }

	//Workflow: KeyListener --> move --> swap
	private void move(int move_dir, int x, int y, boolean isAdd) {
   	 switch(move_dir) {
     case YueLiu2048.MOVE_DOWN: {
    	 //Swap down for each row for all columns
         for (; x < row - 1; x++) {
             swap(getView(x + 1, y), getView(x, y), isAdd);
         }
         
        
     }
         break;

     case YueLiu2048.MOVE_LEFT: {
    	 //Swap left for each columns for all rows
         for (; y > 0; y--) {
             swap(getView(x, y - 1), getView(x, y), isAdd);
         }
     }
         break;

     case YueLiu2048.MOVE_RIGHT: {
    	 //Swap right for each columns for all rows
         for (; y < column - 1; y++) {
             swap(getView(x, y + 1), getView(x, y), isAdd);
         }
     }
         break;

     case YueLiu2048.MOVE_UP: {
    	 //Swap up for each rows for all columns
         for (; x > 0; x--) {
             swap(getView(x - 1, y), getView(x, y), isAdd);
         }
     }
         break;
   	 }
    }
	
	//This is used for copying viewList to testList so testList can be used to determine if any valid moves can be made
	public void copyList() {
		
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
            	Integer number = new Integer(getView(i,j).getNum());
                gettestList(i,j).setText(number);
            }
        }
	}
	//Used to located a certain cube on viewList
	  private Cube getView(int x, int y) {
	        return viewList.get(new Point(x, y));
	    }
	//Used to located a certain cube on testList, the copy of viewList
	    private Cube gettestList(int x, int y) {
	        return testList.get(new Point(x, y));
	    }
	    
	//Workflow: KeyListener --> move --> swap
	//Swap does the actual operation of combining boxes, it is categorized into 3 cases.
    public void swap(Cube next, Cube now, boolean isAdd) {
    		//If the boxes are first moved, there are two cases
	    	if (isAdd) {
	    		//Case 1: Combining none zero with zero
	            if (now.getNum() != 0 && next.getNum() == 0) {
	                next.setText(now.getNum());
	                //*Moved
	                now.setText(0);
	                next.setisAdded(now.getisAdded());
	                now.setisAdded(false);
	            } 
	            //Case 2: Combining same numbers
	            else if (!now.getisAdded() && !next.getisAdded()
	                    && next.getNum() == now.getNum() && now.getNum() != 0) {
	            
	                next.setText(now.getNum() * 2);
	                if (now.getNum()>=max) {
	                	max = next.getNum();
	                }
	                
	                //*Added
	                now.setText(0);
	                next.setisAdded(true);
	                now.setisAdded(false);
	            }
	        } 
	    	
	    	//Case 3: just moving the numbers in the direction
	    	else {
	            if (next.getNum() == 0) {
	                next.setText(now.getNum());
	                now.setText(0);
	                
	            }
	            now.setisAdded(false);
	            next.setisAdded(false);   
	        }
    }
 
   
    //This is the method to generate one box after each valid step and also used to generate two boxes when initializing
    public void createCube() {
        int x;
        int y;
        //Check if there is still boxes available
        if(checkFull()) {
            do {
                x = (int) (Math.random() * 1000 % row);
                y = (int) (Math.random() * 1000 % column);
            } while (getView(x, y).getNum() != 0);
            //The probabilities of 2 and 4 are 0.8 and 0.2 respectively
            getView(x, y).setText(Math.random() > 0.2 ? 2 : 4);
        }

    }
    
  //Check if there is still boxes available
    public boolean checkFull() {
  	   for (int i = 0; i < row; i++) {
           for (int j = 0; j < column; j++) {
        	   if(getView(i,j).getNum()==0) {
        		   return true;
        	   }
           }
       }
  	   return false;
    }
    //Change game state to GAME OVER
    public void gameOver() {
            gameState = YueLiu2048.GAME_OVER;
    }
    //Add valid step
    public void addCount() {
    	count++;
    	stepCounter.setText("Valid Steps: " + count);
    }
    //Get current gameState
    public int getGameState() {
    	return gameState;
    }
    //As required, ask for use confirmation when quit
    public void processWindowEvent(WindowEvent e) {
    	if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            if (getGameState() == YueLiu2048.GAME_CONTINUE) {
                int jop = JOptionPane.showConfirmDialog(null, "Quit?",
                        "Tips", JOptionPane.YES_NO_OPTION);

                if (jop == JOptionPane.YES_OPTION) {
                    super.processWindowEvent(e);
                }
            } else {
                super.processWindowEvent(e);
            }
        }
    }
 
    //Extra feature: the ABOUT button displays the README.txt
    public void about() {
    	JOptionPane.showMessageDialog(null, "/*Contact info:\r\n" + 
    			"Name: Yue Liu\r\n" + 
    			"Email: yliu165@u.rochester.edu\r\n" + 
    			"I did not collaborate with anyone on this assignment.\r\n" + 
    			"*/\r\n" + 
    			"\r\n" + 
    			"//This is the source code for Project 1. It contains FOUR java files.\r\n" + 
    			"\r\n" + 
    			"//The program asks for user confirmation through text boxes instead of printing the confirmation message in\r\n" + 
    			"the console.\r\n" + 
    			"//One important desgin choice is there is two Hashmap being used. One called viewList and the other call testList.\r\n" + 
    			"testList is the copy of viewList. After each move and prior to the next move, testList will be used to determine if \r\n" + 
    			"there is any possible valid steps exist and therefore determine if the game is over. testList will be synced with viewList\r\n" + 
    			"after each test cycle so it is ready for the next test.\r\n" + 
    			"//MyMouseListener.java is used for the JMenu buttons, it is not necessary for achieving the functionality of this project.\r\n" + 
    			"//For all the keyevent, I stored them as integers in hexadecimal format.\r\n" + 
    			"//isAdd determines if the boxes is moved the first time. The first move does all the combining. The rest moves are transfering\r\n" + 
    			"the number. Because of this, when combining in a direction. Say going from left to right. I do not need to worry about \r\n" + 
    			"say 2,2,2,2 in a row. The first 2 twos will become 4 and will not conflict with the 3rd and 4th one. 3rd and 4th will \r\n" + 
    			"combine.\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"/*Extra features:\r\n" + 
    			"Both WASD and arrowkeys will work\r\n" + 
    			"In addition to the requirements. I have added a tool bar where you can quit or restart the game using the \r\n" + 
    			"buttons. But of course you can still do that with key \"Q\" and \"R\" respectively, as required.\r\n" + 
    			"I also added a Valid move counter on the top to improve the user experience. The valid moves are also printed\r\n" + 
    			"in the console, as required.\r\n" + 
    			"The tool bar has a ABOUT button which displays README.txt so you do not have to switch through windows.\r\n" + 
    			"The program ask if the user want to continue playing after a \"WIN\" or \"LOSE”\r\n" + 
    			"*/");
    }
    
    
  //moving up (“W”/""UP key)
    public void up() {
        for (int x = 1; x < row; x++) {
            for (int i = 0; i < column; i++) {
                move(YueLiu2048.MOVE_UP, x, i, true);
            }
        }
        for (int x = 1; x < row; x++) {
            for (int i = 0; i < column; i++) {
                move(YueLiu2048.MOVE_UP, x, i, false);
            }
        }
    }

   //moving down ("S"/"DOWN" key)
    public void down() {
        for (int x = row - 2; x >= 0; x--) {
            for (int y = 0; y < column; y++) {
                move(YueLiu2048.MOVE_DOWN, x, y, true);
            }
        }
        for (int x = row - 2; x >= 0; x--) {
            for (int y = 0; y < column; y++) {
                move(YueLiu2048.MOVE_DOWN, x, y, false);
            }
        }    
    }

    //moving left ("A"/"LEFT" key)
    public void left() {
        for (int y = 1; y < column; y++) {
            for (int x = 0; x < row; x++) {
                move(YueLiu2048.MOVE_LEFT, x, y, true);
            }
        } 
        for (int y = 1; y < column; y++) {
            for (int x = 0; x < row; x++) {
                move(YueLiu2048.MOVE_LEFT, x, y, false);
            }
        }  
    }

   //moving right ("D"/"RIGHT" key)
    public void right() {
        for (int y = column - 2; y >= 0; y--) {
            for (int x = 0; x < row; x++) {
                move(YueLiu2048.MOVE_RIGHT, x, y, true);
                
            }
        }
        for (int y = column - 2; y >= 0; y--) {
            for (int x = 0; x < row; x++) {
                move(YueLiu2048.MOVE_RIGHT, x, y, false);
            }            
        }    
    }
    

 

   //This is the method that uses testList (The copy of viewList) and test if there is any possible valid moves
   public boolean judge() {
	   uptest();
	   boolean res =checker();
	   if(res) {
		   downtest();
		   res =checker();
		   if(res) {
			   lefttest();
			   res = checker();
			   if(res) {
				   righttest();
				   res = checker();
				   if(res) {
					   return false;
				   }
				   return true;
			   }
		   }
		   return true;
	   }
	   return true;
	   
    }
   
   public boolean checker() {
	   for (int i = 0; i < row; i++) {
           for (int j = 0; j < column; j++) {
               if (gettestList(i,j).getNum()!=getView(i,j).getNum())
            	   return false;
               
           }
       }
	   return true;
	   
   }
   /*The test for testList
    * There is a move for viewList. this movetest is for testList, the copy of viewList
    * 
    */
   	private void movetest(int move_dir, int x, int y, boolean isAdd) {
   	   	 switch(move_dir) {
   	     case YueLiu2048.MOVE_DOWN: {
   	         for (; x < row - 1; x++) {
   	             swap(gettestList(x + 1, y), gettestList(x, y), isAdd);
   	         }
   	        
   	     }
   	         break;

   	     case YueLiu2048.MOVE_LEFT: {
   	         for (; y > 0; y--) {
   	             swap(gettestList(x, y - 1), gettestList(x, y), isAdd);
   	         }
   	     }
   	         break;

   	     case YueLiu2048.MOVE_RIGHT: {
   	         for (; y < column - 1; y++) {
   	             swap(gettestList(x, y + 1), gettestList(x, y), isAdd);
   	         }
   	     }
   	         break;

   	     case YueLiu2048.MOVE_UP: {
   	         for (; x > 0; x--) {
   	             swap(gettestList(x - 1, y), gettestList(x, y), isAdd);
   	         }
   	     }
   	         break;
   	   	 }
   	    }
   	
   		//Test up, the up() method for testList
   	   public void uptest() {
   	        for (int x = 1; x < row; x++) {
   	            for (int i = 0; i < column; i++) {
   	                movetest(YueLiu2048.MOVE_UP, x, i, true);
   	            }
   	        }

   	        
   	        for (int x = 1; x < row; x++) {
   	            for (int i = 0; i < column; i++) {
   	                movetest(YueLiu2048.MOVE_UP, x, i, false);
   	            }
   	        }
   	    }

   	   //Test down, the down() method for testList
   	    public void downtest() {
   	        for (int x = row - 2; x >= 0; x--) {
   	            for (int y = 0; y < column; y++) {
   	                movetest(YueLiu2048.MOVE_DOWN, x, y, true);
   	            }
   	        }

   	       
   	        for (int x = row - 2; x >= 0; x--) {
   	            for (int y = 0; y < column; y++) {
   	                movetest(YueLiu2048.MOVE_DOWN, x, y, false);
   	            }
   	        }
   	    }

   	    //Test left, the left() method for testList
   	    public void lefttest() {
   	        for (int y = 1; y < column; y++) {
   	            for (int x = 0; x < row; x++) {
   	                movetest(YueLiu2048.MOVE_LEFT, x, y, true);
   	            }
   	        }

   	        
   	        for (int y = 1; y < column; y++) {
   	            for (int x = 0; x < row; x++) {
   	                movetest(YueLiu2048.MOVE_LEFT, x, y, false);
   	            }
   	        }   
   	    }
   	   //Test right, the right() method for testList
   	    public void righttest() {
   	        for (int y = column - 2; y >= 0; y--) {
   	            for (int x = 0; x < row; x++) {
   	                movetest(YueLiu2048.MOVE_RIGHT, x, y, true);
   	                
   	            }
   	        }
   	        
   	        for (int y = column - 2; y >= 0; y--) {
   	            for (int x = 0; x < row; x++) {
   	                movetest(YueLiu2048.MOVE_RIGHT, x, y, false);
   	            }
   	            
   	        }
   	    }
}

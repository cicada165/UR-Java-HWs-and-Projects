/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: 
 * TA: 
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class MyKeyListener implements KeyListener{
	
	    //w/87 s/83 a/65 d/68 up/38 down/40 left/37 right/39 Q/81 R/82 in hexadecimal format
	
	    //Movement Keys
	    final public static int KEY_W = 0xf57;
	    final public static int KEY_S = 0xf53;
	    final public static int KEY_A = 0xf41;
	    final public static int KEY_D = 0xf44;
	    
	    final public static int KEY_UP = 0xf26;
	    final public static int KEY_DOWN = 0xf28;
	    final public static int KEY_LEFT = 0xf25;
	    final public static int KEY_RIGHT = 0xf27;

	    //R to restart, Q to quit, as required
	    final public static int KEY_Q = 0xf51;
	    final public static int KEY_R = 0xf52;
	    
	 
	    
	    private YueLiu2048 game;
	    public MyKeyListener(YueLiu2048 game) {
	    	this.game = game;
	    }

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode() + 0xf00;
			/*w/87 s/83 a/65 d/68 up/38 down/40 left/37 right/39 Q/81 R/82 
			 * in hexadecimal format
			 */
			game.copyList();
			boolean res = game.judge();
			if(!res){
				game.gameOver();
			}
			game.copyList();
		
			switch(game.getGameState()) {
			case YueLiu2048.GAME_CONTINUE: {
				//Key Events and Print out Key presses
	            switch (keyCode) {
	            case MyKeyListener.KEY_W:
	            {
	                game.up();
	                System.out.println("'W' pressed!");
	            }
	                break;
	            case MyKeyListener.KEY_UP:
	            {
	                game.up();
	                System.out.println("'UP' pressed!");
	            }
	                break;


	            case MyKeyListener.KEY_S:
	            {
	                game.down();
	                System.out.println("'S' pressed!");
	            }
	                break;
	            case MyKeyListener.KEY_DOWN:
	            {
	                game.down();
	                System.out.println("'DOWN' pressed!");
	            }
	                break;


	            case MyKeyListener.KEY_A: 
	            {
	                game.left();
	                System.out.println("'A' pressed!");
	            }
	                break;
	            case MyKeyListener.KEY_LEFT:
	            {
	                game.left();
	                System.out.println("'LEFT' pressed!");
	            }
	                break;


	            case MyKeyListener.KEY_D: 
	            {
	                game.right();
	                System.out.println("'D' pressed!");
	            }
	                break;
	            case MyKeyListener.KEY_RIGHT:
	            {
	                game.right();
	                System.out.println("'RIGHT' pressed!");
	            }
	                break;
	            //Keyboard Q to quit the game
	            case MyKeyListener.KEY_Q:{
	            	System.out.println("'Q' pressed!");
	            //Ask for user confirmation
	            	 if (game.getGameState() == YueLiu2048.GAME_CONTINUE) {
	                     int jop = JOptionPane.showConfirmDialog(null, "Quit?",
	                             "Tips", JOptionPane.YES_NO_OPTION);

	                     if (jop == JOptionPane.YES_OPTION) {
	                    	 game.dispose();
	                     }
	                 } else {
	                     game.dispose();
	                 }
	            }
	            	break;
	            //Keyboard R to restart the game
	            case MyKeyListener.KEY_R:{
	            	System.out.println("'R' pressed!");
	            	game.newGame();
	            }
	            	break;
	            }
	               
	        }
	            break;
	        case YueLiu2048.GAME_OVER: {
	        //Game LOSE Display and ask for user confirmation if they wanna continue playing or not
	            int jop = JOptionPane
	                    .showConfirmDialog(null, "Game Over! \nYou've made " + game.count 
	                    		+ " valid moves. \nThe maximum number you managed is " + game.max + "."
	                    		+ "\nDo you want to try again?", "GAME OVER :(. ",
	                            JOptionPane.YES_NO_OPTION);
	            
	            if (jop == JOptionPane.YES_OPTION) {
	            	//Reset the maxium number.
	            	game.max = 0;
	                game.newGame();
	            }
	        }
	            break;
	            
	        case YueLiu2048.GAME_WIN: {
	        //Game WIN Display
	            int jop = JOptionPane.showConfirmDialog(null,
	                    "Game WIN!\nYou've made " + game.count 
	                   + " valid moves. \nThe maximum number you managed is "  + game.max +"." );
	        }
	            break;
			}
			//If game is not over, and is a valid step, add one new box and add one to valid step.
			if(!game.checker()) {
				game.addCount();
				game.createCube();
			}
			/*Used in the console for valid move, if checker is false means there is change (viewList and testList are different),
			*which means it is a valid move. I did this because if use '!checker()' directly in println it returns a compile error :/
			*/
			boolean result =!game.checker();
	        System.out.print("This is a " + result + " valid move!\n" 
	        		+ "Valid Move Count：" + game.count 
	        		+ "\nMaximum number on the board is: " + game.max +"\n\n" 
	        		);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub			
		}    
}

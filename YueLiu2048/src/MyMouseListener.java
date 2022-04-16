/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: 
 * TA: 
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
//This class is created for the buttons.
public class MyMouseListener implements MouseListener{
	private YueLiu2048 game;
	private int btwevn;
	
	public MyMouseListener(YueLiu2048 game, int btwevn) {
		this.game = game;
		this.btwevn = btwevn;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(btwevn) {
		//Button NEW GAME
		case YueLiu2048.BUTTON_NEW_GAME:{
			game.newGame();
		}
			break;
		//Button ABOUT
		case YueLiu2048.BUTTON_ABOUT: {
            game.about();
        }
            break;	
        //Button EXIT
		case YueLiu2048.BUTTON_EXIT:{
			game.processWindowEvent(new WindowEvent(game,
                    WindowEvent.WINDOW_CLOSING));
		}
		    break;	
	}

	}
}

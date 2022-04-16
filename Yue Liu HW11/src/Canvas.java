/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
public class Canvas extends JComponent implements MouseListener, MouseMotionListener{
	//This programme contains P1, P4
	   private static final long serialVersionUID = 1L;
	   public int x , y, x1, y1, x2, y2;
	   //Constructor
	   public Canvas(){
	       addMouseMotionListener(this);
	       addMouseListener(this);
	   }
	   public static void main(String[] args) {
			Canvas canvas = new Canvas();
			JFrame frame = new JFrame("Canvas");
			frame.add(canvas);
			frame.setSize(720, 720);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	@Override
	public void mouseClicked(MouseEvent e){
		Graphics g = getGraphics(); 
		System.out.println("Mouse clicked! " + e);
		//Clear
		g.clearRect(0,0,1000,1000);
		g.fillOval(x, y, 20, 20);	
		
	}
	@Override
	public void mousePressed(MouseEvent e){
		System.out.println("Mouse Pressed!" + e);
		Graphics g = getGraphics(); 
		//Clear
		g.clearRect(0,0,1000,1000);
		this.x = e.getX(); 
		this.y = e.getY();
		g.fillOval(x, y, 20, 20);
	}
	@Override
	public void mouseReleased(MouseEvent e){
		Graphics g = getGraphics(); 
		//Clear
		g.clearRect(0,0,1000,1000);
		System.out.println("Mouse Released!" + e);
		x2 = e.getX();
		y2 = e.getY();
		//Leave the last line
		//+10 to compensate for the radius
		g.drawLine(x+10, y+10, x2+10 , y2+10);
	}
	
	@Override
	public void mouseEntered(MouseEvent e){
		System.out.println("Mouse Entered!" + e);
	}
	@Override
	public void mouseExited(MouseEvent e){
		System.out.println("Mouse Exited!" + e);
	}
	
	public void mouseMoved(MouseEvent e) { 
		System.out.println("Mouse Moved!" + e);

	}
	public void mouseDragged(MouseEvent e) { 
		 Graphics g = getGraphics(); 
		//Clear
		 g.clearRect(0,0,1000,1000);
		 System.out.println("Mouse Dragged!" + e); 
		 x1 = e.getX(); 
		 y1 = e.getY();
		 System.out.println(x);
		 System.out.println(y);
		 System.out.println(x1);
		 System.out.println(y1);
		 g.fillOval(x1, y1, 20, 20);
		 //Connecting the current position to the original point
		 //+10 to compensate for the radius
		 g.drawLine(x+10, y+10, x1+10 , y1+10);
		 
		 
		 
		 
	}
}
/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
//This programme contains P1,P2,P3,P5,P6
public class Canvas_for_key extends JComponent implements MouseListener, MouseMotionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private int x, y, n;
	private Color color;
	//Array for storing colors
	private Color[] c = { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK,
			Color.YELLOW, Color.DARK_GRAY, Color.CYAN };

	public static void main(String[] args) {
		JFrame frame = new JFrame("Canvas_for_key");
		Canvas_for_key canvas2 = new Canvas_for_key();
		frame.add(canvas2);
		frame.setSize(720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	//Constructor
	public Canvas_for_key() {
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked " + e);
		x = e.getX();
		y = e.getY();
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x, y, 20, 20);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed " + e);
		x = e.getX();
		y = e.getY();
		Graphics g = getGraphics();
		//Change Color
		g.setColor(color);
		g.fillOval(x, y, 20, 20);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse released " + e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered " + e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse exited " + e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//No clearing thus the circles will remain, like MacPaint
		System.out.println("Mouse dragged " + e);
		x = e.getX();
		y = e.getY();
		Graphics g = getGraphics();
		//change color
		g.setColor(color);
		//-10 to compensate for the radius
		g.fillOval(x-10, y-10, 20, 20);
	}
	//KeyListener 
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved " + e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key pressed " + e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Key released " + e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Key typed " + e);
		n += 1;
		//Create a new array for each character entered
		char[] a = new char[n];
		char key = e.getKeyChar();
		//Each character is approximately 10 pixels
		x += 10;
		for (int i = 0; i < a.length; i++) {
			a[i] = key;
		}
		Graphics g = getGraphics();
		g.drawChars(a, 0, 1, x, y);
		//Change number base on keyboard input
		if (e.getKeyChar() == KeyEvent.VK_0) {
			color = c[0];
		} else if (e.getKeyChar() == KeyEvent.VK_1) {
			color = c[1];
		} else if (e.getKeyChar() == KeyEvent.VK_2) {
			color = c[2];
		} else if (e.getKeyChar() == KeyEvent.VK_3) {
			color = c[3];
		} else if (e.getKeyChar() == KeyEvent.VK_4) {
			color = c[4];
		} else if (e.getKeyChar() == KeyEvent.VK_5) {
			color = c[5];
		} else if (e.getKeyChar() == KeyEvent.VK_6) {
			color = c[6];
		} else if (e.getKeyChar() == KeyEvent.VK_7) {
			color = c[7];
		} else if (e.getKeyChar() == KeyEvent.VK_8) {
			color = c[8];
		} else if (e.getKeyChar() == KeyEvent.VK_9) {
			color = c[9];
		}
	}
}
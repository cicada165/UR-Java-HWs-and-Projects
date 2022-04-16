/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class P2 extends JPanel{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		JFrame frame = new JFrame("P2");
		P2 canvas = new P2();
		frame.add(canvas);
		frame.setSize(720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g){
		for (int i = 0; i<=getWidth(); i+=10){
			g.drawLine(0 , 0 , i, getHeight()-i);
			
			}
			
		}
	}

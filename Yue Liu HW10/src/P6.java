/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
public class P6 extends JPanel{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		JFrame frame = new JFrame("P6");
		P6 canvas = new P6();
		frame.add(canvas);
		frame.setSize(720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g){
		for(int i = 30; i < 350; i+=10){
			//Generate alternate color
			g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));  
			g.drawOval(i, i, getWidth()-1-2*i, getWidth()-1-2*i);
		}
	}

}

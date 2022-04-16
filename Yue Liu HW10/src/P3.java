/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class P3 extends JPanel{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		JFrame frame = new JFrame("P3");
		P3 canvas = new P3();
		frame.add(canvas);
		frame.setSize(720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g){
		for (int i = 0; i<=getWidth()-1; i+=10){
			g.drawLine(0 , 0 , i, getHeight()-1-i);
			g.drawLine(0 , getHeight()-1 , i, i);
			g.drawLine(getWidth()-1 , 0 , i, i);
			g.drawLine(getWidth()-1 , getHeight()-1 , i, getHeight()-1-i);
			}
	}

}

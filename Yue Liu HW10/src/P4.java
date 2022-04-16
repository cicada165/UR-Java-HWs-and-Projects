/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class P4 extends JPanel{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		JFrame frame = new JFrame("P4");
		P4 canvas = new P4();
		frame.add(canvas);
		frame.setSize(720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g){
		for (int i = 0; i<=getHeight()-1; i+=10){
			g.drawLine(0 , i , 10+i, getHeight()-1);
		}
	}

}

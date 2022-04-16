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

public class P1 extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Zigzag");
		Zigzag canvas = new Zigzag();
		frame.add(canvas);
		frame.setSize(720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
@Override
public void paintComponent(Graphics g){
	
	int a = getWidth()-1;
	int b = getHeight()-1;
	
	g.setColor(Color.RED);
	g.drawRect(0,0,a,b);
	
	g.setColor(Color.BLUE);
	g.drawLine(a/2,0,a/2,b);
	g.drawLine(0,b/2,a,b/2);
	
	g.setColor(Color.GREEN);
	g.drawLine(0,0,a, b);
	g.drawLine(0,b,a,0);
	
	
	
}
}

/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class P1andP2 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	//Timer
		Timer t = new Timer(10,this);
		protected double x = 0;
		protected double y = 0;
		protected double ratio = 1;
		protected int recSize = 10;
		protected int width = 500;
		protected int height = 500;
	

	public P1andP2() {
		t.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect((int) x, (int) y, recSize, recSize);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Moves Diagonally
		x++;
		y++;
		width = getWidth();
		height = getHeight();
		ratio = (double) width / height;
		//Keep it moving diagonally
		if (x != y * ratio) {
			x = y * ratio;
		}

		repaint();
		//Keep it going
		if (y== getHeight()) {
			x = 0;
			y = 0;
		}
	}
	//Test
		public static void main(String[] args) {
			JFrame frame = new JFrame();
			P1andP2 canvas = new P1andP2();
			frame.add(canvas);
			frame.setTitle("The Moving Square");
			Dimension dimension = new Dimension(500, 500);
			
			frame.setPreferredSize(dimension);
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}

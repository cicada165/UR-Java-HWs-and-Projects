/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.Shape;

public class P3 extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	Timer t = new Timer(50, this);
	protected double x = 250 / 3;
	protected double y = 250 / 3;
	protected double theta = 0;
	protected int width = 500;
	protected int height = 500;
	protected double rotate = 0;

	public P3() {
		t.start();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g);
		width = getWidth();
		height = getHeight();
	
		g.drawLine(0, height / 2, width, height / 2);
		g.drawLine(width / 2, 0, width / 2, height);
		g.drawOval(width / 2 - width / 6, height / 2 - width / 6, width / 3, height / 3);
		
		AffineTransform t = new AffineTransform();
		t.rotate(rotate);
		//
		
		
		Rectangle rec = new Rectangle(width / 2 + (int) x - width / 100, height / 2 - (int) y - height / 100, width / 50, height / 50);
		//Shape newShape = t.createTransformedShape(rec);
		//g2.draw(newShape);
		//g2.fill(newShape);
		g.fillRect(width / 2 + (int) x - width / 100, height / 2 - (int) y - height / 100, width / 50, height / 50);
		g.drawLine(width / 2, height / 2, width / 2 + (int) x, height / 2 - (int) y);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		width = getWidth();
		height = getHeight();
		theta += 0.01;
		//Math
		x = (width / 6) * Math.cos(theta);
		y = (height / 6) * Math.sin(theta);
		rotate = theta;
		repaint();
		if (theta >= 2 * Math.PI) {
			t.stop();
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		P3 canvas = new P3();
		frame.add(canvas);
		frame.setTitle("Circular Moving Square");
		Dimension dimension = new Dimension(500, 500);
		frame.setPreferredSize(dimension);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

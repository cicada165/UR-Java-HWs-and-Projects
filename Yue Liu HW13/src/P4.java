/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Random;

public class P4 extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	//Every five seconds
	Timer t = new Timer(5000, this);
	Random myRandom = new Random();
	protected int width = 500;
	protected int height = 500;
	protected int line = 100;
	protected int x1, x2, y1, y2;
	protected JSlider slider;

	public P4() {
		slider = new JSlider(JSlider.HORIZONTAL, 0, 200, line);
		//Scales
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		add(slider);
		t.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		width = getWidth();
		height = getHeight();
		for (int i = 0; i < line; i++) {
			x1 = myRandom.nextInt(width);
			x2 = myRandom.nextInt(width);
			y1 = myRandom.nextInt(height);
			y2 = myRandom.nextInt(height);
			//Make sure it does not cover the slider
			if (y1 > 40 && y2 > 40) {
				g.drawLine(x1, y1, x2, y2);
			} 
			//Ensure the indicated number of lines are drawn
			else {
				i--;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				line = slider.getValue();
			}
		});

		repaint();
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		P4 canvas = new P4();
		frame.add(canvas);
		frame.setTitle("My Random Line");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

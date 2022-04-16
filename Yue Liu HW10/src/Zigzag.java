import java.awt.Graphics;

import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
public class Zigzag extends JPanel{
	private static final long serialVersionUID = 1L;
	public static void main(String[]args){
		JFrame frame = new JFrame("P1");
		P1 canvas = new P1();
		frame.add(canvas);
		frame.setSize(720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.RED);
		int quater = (getHeight()-1)/4;
		g.drawLine(0,0,getWidth(),quater);
		g.drawLine(getWidth(),quater,0,2*quater);
	}

}

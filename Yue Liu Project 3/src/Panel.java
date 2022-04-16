/*
 * Member1
Name: Yue Liu
NetID: yliu165
Assignment Number: Project 1
Lab Section: T/r 9:40-10:55
TA: Sereen Assi

Member2
Name: Senqi Zhang
NetID: szhang71
Assignment Number: Project 1
Lab Section: T/R 11:05-12:20
TA:Mustafa Ali

Member3
Name: Mingqing Sun
NetID: msun13
Assignment Number: HW13
Lab 
Section: M/W 14:00-15:15
TA:Yahan Yang
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Panel extends JComponent implements ActionListener, ChangeListener {
	//Initialization
	Random rand = new Random();
	
	//Variables
	JPanel gadget;
	JPanel gadget2;
	JMenuItem Shape1;
	JMenuItem Shape2;
	JMenuItem Shape3;
	JMenuItem Shape4;
	JMenuItem Shape5;
    
	JLabel m;
	JLabel c;
	
	JMenuItem Red;
	JMenuItem Green;
	JMenuItem Blue;
	JMenuItem Pink;
	JMenuItem Random;

	JSlider velocity;
	JSlider angel;
	JSlider delay;

	JLabel Lvelocity;
	JLabel Langel;
	JLabel Ldelay;
	JLabel i;
	JLabel j;
	JLabel k;

	JMenu Shape;
	JMenu color;
	JMenuBar Shapebar;
	JMenuBar Colorbar;

	JButton fire;
	JButton clear;
	String judge = "black";
	
	double angle;
	double t;
	int v;
	int choice;

	int midHeight = (int) (getHeight() * 0.5);
	int midWidth = (int) (getWidth() * 0.5);
	int endx;
	int endy;

	
	//GUI Section
	public Panel() {
		setLayout(new BorderLayout());

		Shapebar = new JMenuBar();
		Colorbar = new JMenuBar();
		gadget = new JPanel();
		gadget2 = new JPanel();
		clear = new JButton("Clear");
		clear.addActionListener(this);
		i = new JLabel("Velocity");
		j = new JLabel("Angle");
		k = new JLabel("Delay(ms)");
		
		fire = new JButton("Fire");
		fire.addActionListener(this);
		
		// build the Shape menu
		Shape = new JMenu("Shapes:");
		color = new JMenu("Color:");

		Shape1 = new JMenuItem("Shape1");
		Shape1.addActionListener(this);
		Shape2 = new JMenuItem("Shape2");
		Shape2.addActionListener(this);
		Shape3 = new JMenuItem("Shape3");
		Shape3.addActionListener(this);
		Shape4 = new JMenuItem("Shape4");
		Shape4.addActionListener(this);
		Shape5 = new JMenuItem("Shape5");
		Shape5.addActionListener(this);
		Shape.add(Shape1);
		Shape.add(Shape2);
		Shape.add(Shape3);
		Shape.add(Shape4);
		Shape.add(Shape5);
		
		// build the Color menu
        
		m = new JLabel("Please Select A Shape");
	    c = new JLabel("Please Select A Color");
		
	    // Parameters
		velocity = new JSlider(0, 1000);
		velocity.addChangeListener(this);
		Lvelocity = new JLabel("-");
		angel = new JSlider(0, 90);
		angel.addChangeListener(this);
		Langel = new JLabel("-");
		delay = new JSlider(0, 250);
		delay.addChangeListener(this);
		Ldelay = new JLabel("-");

		gadget.add(Shapebar);
		gadget.add(Colorbar);
		gadget.setLayout(new FlowLayout());
		
		//add menus to bar
		Shapebar.add(Shape);
		Shapebar.add(m);
		Colorbar.add(color);
		Colorbar.add(c);
        
		Red = new JMenuItem("Red");
		Red.addActionListener(this);
		Green = new JMenuItem("Green");
		Green.addActionListener(this);
		Blue = new JMenuItem("Blue");
		Blue.addActionListener(this);
		Pink = new JMenuItem("Pink");
		Pink.addActionListener(this);
		Random = new JMenuItem("Random");
		Random.addActionListener(this);
		color.add(Red);
		color.add(Green);
		color.add(Blue);
		color.add(Pink);
		color.add(Random);
	
		gadget.add(fire);
		gadget.add(clear);
		gadget2.add(i);
		gadget2.add(Lvelocity);
		gadget2.add(velocity);
		gadget2.add(j);
		gadget2.add(Langel);
		gadget2.add(angel);
		gadget2.add(k);
		gadget2.add(Ldelay);
		gadget2.add(delay);
        
		add(gadget,BorderLayout.NORTH);
		add(gadget2, BorderLayout.SOUTH);

	}
	 
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//Generate random Color
		float r = rand.nextFloat();
        float g1 = rand.nextFloat();
        float b = rand.nextFloat();
		Color randomColor = new Color(r,g1,b);
		Graphics g = getGraphics();
       
		//Clear the canvas
        if(e.getSource().equals(clear)) {
			repaint();
		}
		
        //Set Color
		if (e.getSource().equals(fire)) {
			if(judge.equals("blue")) {
				g.setColor(Color.BLUE);
			}else if (judge.equals("red")) {
				g.setColor(Color.RED);
			}else if (judge.equals("green")) {
				g.setColor(Color.GREEN);
			}else if (judge.equals("pink")) {
				g.setColor(Color.PINK);
			}else if (judge.equals("random")) {
				g.setColor(randomColor);
			}
		    
			//Call the method to paint
			drawpath(g);
			drawFireWork(g);
		}
		
		//Set Shape and set Color
		if(e.getSource().equals(Shape1)){
			m.setText("Shape1");
			choice = 1;
		}
		else if (e.getSource().equals(Shape2)){
			m.setText("Shape2");
			choice = 2;
		}
		else if (e.getSource().equals(Shape3)){
			m.setText("Shape3");
			choice = 3;
		}
		else if (e.getSource().equals(Shape4)){
			m.setText("Shape4");
			choice = 4;
		}
		else if (e.getSource().equals(Shape5)){
			m.setText("Shape5");
			choice = 5;
		}
		else if (e.getSource().equals(Red)){
			c.setText("Red");
			judge = "red";
		}
		else if (e.getSource().equals(Green)){
			c.setText("Green");
			judge = "green";
		}
		else if (e.getSource().equals(Blue)){
			c.setText("Blue");
			judge = "blue";
		}
		else if (e.getSource().equals(Pink)){
			c.setText("Pink");
			judge = "pink";
		}
		else if (e.getSource().equals(Random)){
			c.setText("Random");
			judge = "random";
		}

	}
    
	//Method that detects the change of velocity/angel/time delay
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider) e.getSource();

		if (e.getSource().equals(velocity)) {
			Lvelocity.setText(Integer.toString(src.getValue()));
			v = src.getValue();
		} else if (e.getSource().equals(angel)) {
			Langel.setText(Integer.toString(src.getValue()));
			angle = src.getValue();
		} else if (e.getSource().equals(delay)) {
			Ldelay.setText(Integer.toString(src.getValue()));
			t = src.getValue();
		}
	}
    
	//Method to draw the trajectory
	public void drawpath(Graphics g) {

		for (double i = 0; i < t /100; i += 0.0001) {
			int drawx = (int) (v * (Math.cos(Math.toRadians(angle))) * i);
			int drawy = (int) ((-v) * (Math.sin(Math.toRadians(angle) * i )) + 0.5 * 9.8 * Math.pow(i, 2)) + getHeight();
			g.fillOval(drawx, drawy, 4, 4);
			endx = drawx;
			endy = drawy;
		}
	}
    
	//Method to draw 5 different types of firework
	public void drawFireWork(Graphics g2) {
		if(choice == 1) {
			  g2.fillOval(endx-50,endy-50,100,100);
			  g2.drawOval(endx-60,endy-50,100,100);
			  g2.setColor(Color.WHITE);
			  g2.drawLine(endx-50, endy, endx+50, endy);
			  g2.drawLine(endx-50, endy-10, endx+50, endy-10);
			  g2.drawLine(endx-50, endy+10, endx+50, endy+10);
			 }else if(choice == 2) {
				 g2.drawOval(endx - 50, endy - 50, 100, 100);
				 g2.fillOval(endx - 30, endy - 20, 10, 10);
				 g2.fillOval(endx + 20, endy - 20, 10, 10);
				 g2.drawLine(endx, endy + 10, endx - 10, endy + 20);
				 g2.drawLine(endx, endy + 10, endx + 10, endy + 20);
				 g2.fillOval(endx - 40, endy - 100, 20, 60);
				 g2.fillOval(endx + 20, endy - 100, 20, 60);
				 g2.drawOval(endx - 45, endy - 150, 30, 110);
				 g2.drawOval(endx + 15, endy - 150, 30, 110);
			 	 }else if (choice==3) {
			 		 int youxiax=(int) (endx+50* Math.sqrt(3));
			 		 int zuoxiax=(int) (endx-50* Math.sqrt(3));
			 		 g2.drawLine(endx,endy-100,youxiax,endy+50);
			 		 g2.drawLine(endx,endy-100,zuoxiax,endy+50); 
			 		 g2.drawLine(zuoxiax,endy+50,youxiax,endy+50);
			 		 int zuoshangx=(int) (endx-50* Math.sqrt(3));
			 		 int youshangx=(int) (endx+50* Math.sqrt(3));
			 		    g2.drawLine(zuoshangx, endy-50, youshangx, endy-50);
			 		    g2.drawLine(zuoshangx, endy-50,endx,endy+100);
			 		    g2.drawLine(youshangx, endy-50,endx, endy+100);
			 		    } else if (choice==4) {
			 		    	g2.fillOval(endx-20,endy-20,40,40);
			 		    	double ang=Math.PI/12.0;
			 		    	for(int i=0;i<24;i++) {
			 		        int linex=endx+(int)(80*Math.cos(ang*i));
			 		        int liney=endy+(int)(80*Math.sin(ang*i));
			 		        g2.drawLine(endx,endy,linex,liney);
			 		    	}
			 		        }else if(choice==5) {
			 		        	g2.fillOval(endx-150,endy-30,60,60);
			 		        	g2.fillOval(endx+150,endy-30,60,60);
			 		        	g2.setColor(Color.black);
			 		        	g2.drawOval(endx-240, endy-30, 200, 60);
			 		        	g2.drawLine(endx-170, endy-30, endx-160, endy-50);
			 		        	g2.drawLine(endx-190, endy-25, endx-180, endy-45);
			 		        	g2.drawLine(endx-210, endy-20, endx-200, endy-40);
			 		        	g2.drawOval(endx+60, endy-30, 200, 60);
			 		        	g2.drawLine(endx+240, endy-20, endx+250, endy-40);
			 		        	g2.drawLine(endx+220, endy-25, endx+230, endy-45);
			 		        	g2.drawLine(endx+200, endy-30, endx+210, endy-50);
			 		        	g2.setColor(Color.white);
			 		        	g2.fillOval(endx-110,endy-20,20,20);
			 		        	g2.fillOval(endx+190,endy-20,20,20);
			 					}
			 		        		
	}    
			 		  
			 		    
		
		

	public static void main(String[] args) {
		JFrame frame = new JFrame("Firework Show");
		Panel canvas = new Panel();
		frame.setSize(1920, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas);
		frame.setVisible(true);

	}

}

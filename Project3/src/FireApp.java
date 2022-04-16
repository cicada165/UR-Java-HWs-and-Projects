import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class FireApp extends JFrame implements ActionListener,MouseMotionListener,MouseListener{

	JPanel bar;
	JButton focus;
	JButton fire;

	JPanel Modes;
	static Color c;
	JLabel dmode,dcolor,dspeed;
	JTextField sinput;
	static Drawings d;

	boolean cRand;
	JButton Mode0,Mode1,Mode2,Mode3,Mode4,Mode5,rcolor,color1,color2,color3;
	static boolean flying;
	static Timer timerg,timer,timer0;
	static JLabel angled;
	static boolean focused;
	JSlider speed;
	public FireApp() {
		super("The Great Firework");
		setPreferredSize(new Dimension(950,950));
		setLayout(new BorderLayout());
		addMouseListener(this);
		addMouseMotionListener(this);
		Modes=new JPanel();
		Mode0=new JButton("Mode 0");
		Mode1=new JButton("Mode 1");
		Mode2=new JButton("Mode 2");
		Mode3=new JButton("Mode 3");
		Mode4=new JButton("Mode 4");
		Mode5=new JButton("Mode 5");
		cRand=true;
		dcolor=new JLabel("The current color is random");
		rcolor=new JButton("Random Color");
		color1=new JButton("Red");
		color2=new JButton("Blue");
		color3=new JButton("Green");
		dmode=new JLabel("The mode is now mode 0.  ");
		dspeed=new JLabel("Your speed is medium");

		timer=new Timer(15,this);
		timer0=new Timer(5,this);
		timerg=timer0;
		bar=new JPanel();
		focus=new JButton("Unfocus");
		focus.addActionListener(new F());
		fire=new JButton("Fire");
		speed=new JSlider(JSlider.HORIZONTAL,1,3,2);
		speed.setPaintTicks(true);
		speed.setMajorTickSpacing(1);
		speed.addChangeListener(new CL());


		angled=new JLabel("Your current angle is 50 degree, and you are not focused");
		focused=false;

		bar.setLayout(new GridLayout(2,3,2,2));
		bar.add(focus);
		bar.add(angled);

		bar.add(fire);
		bar.add(dspeed);
		bar.add(speed);
		Modes.setLayout(new BoxLayout(Modes,BoxLayout.Y_AXIS));
		Modes.add(dmode);
		Modes.add(Mode0);
		Modes.add(Mode1);
		Modes.add(Mode2);
		Modes.add(Mode3);
		Modes.add(Mode4);
		Modes.add(Mode5);
		Modes.add(dcolor);
		Modes.add(rcolor);
		Modes.add(color1);
		Modes.add(color2);
		Modes.add(color3);
		rcolor.addActionListener(new CS());
		color1.addActionListener(new CS());
		color2.addActionListener(new CS());
		color3.addActionListener(new CS());
		Mode0.addActionListener(new MS());
		Mode1.addActionListener(new MS());
		Mode2.addActionListener(new MS());
		Mode3.addActionListener(new MS());
		Mode4.addActionListener(new MS());
		Mode5.addActionListener(new MS());
		fire.addActionListener(this);

		flying=true;
	   
		d=new Drawings();
	
		bar.setBackground(Color.WHITE);
		Modes.setBackground(Color.WHITE);
		add(bar,BorderLayout.NORTH);
		add(d,BorderLayout.CENTER);
		add(Modes,BorderLayout.EAST);
		pack();
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(focused==true) {
		if(flying==true) {
		if(e.getSource()==fire) {
			d.reset();
			timerg=timer0;
			timerg.start();
		}else if(e.getSource()==timerg) {
		if(d.xl>=getWidth()/2||d.yl<=getHeight()*1.0/3.0) {
	       flying=false;
	       Random rand = new Random();
		   float x = rand.nextFloat();
		   float y = rand.nextFloat();
		   float z = rand.nextFloat();
		   Color c0 = new Color(x,y,z);
		   if(cRand==true) {
		   c=c0;
		   }
		   timerg.stop();
		   timerg=timer;
		   timerg.start();
			repaint();
		}		
		else {
		    d.xl+=2;
	    	d.setyl(d.xl);
	    	d.setyl(d.xl);
	     	repaint();
		
	    }
	}
} else if(flying==false) {
		repaint();
	}
		}
	}

protected class CL implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(speed.getValue()==1) {
			timer0.setDelay(15);
			dspeed.setText("Your current speed is slow.");
		}else if(speed.getValue()==2) {
			timer0.setDelay(7);
			dspeed.setText("Your current speed is medium.");
		}else if(speed.getValue()==3) {
			timer0.setDelay(2);
			dspeed.setText("Your current speed is fast.");
		}
		
	}
	
}
	
	
protected class CS implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rcolor) {
			cRand=true;
			dcolor.setText("The current color is random.");
		}else if(e.getSource()==color1) {
			cRand=false;
			c=Color.RED;
			dcolor.setText("The current color is Red.  ");
		}else if(e.getSource()==color2) {
			cRand=false;
			c=Color.BLUE;
			dcolor.setText("The current color is Blue.  ");
		}else if(e.getSource()==color3) {
			cRand=false;
			c=Color.GREEN;
			dcolor.setText("The current color is Green.  ");
		}
		
	}
}
	
	
protected class F implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		focused=false;
		angled.setText("Your current angle is "+(int)d.angle+" degree, you are not focused.");
	}
	
}

protected class MS implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(timerg.isRunning()) {
			
		}else {
			if(e.getSource()==Mode0) {
				d.mode=0;
				dmode.setText("The mode is now mode 0.  ");
			}else if(e.getSource()==Mode1) {
				d.mode=1;
				dmode.setText("The mode is now mode 1.  ");
			}else if(e.getSource()==Mode2) {
				d.mode=2;
				dmode.setText("The mode is now mode 2.  ");
			}else if(e.getSource()==Mode3) {
				d.mode=3;
				dmode.setText("The mode is now mode 3.  ");
			}else if(e.getSource()==Mode4) {
				d.mode=4;
				dmode.setText("The mode is now mode 4.  ");
			}else if(e.getSource()==Mode5) {
				d.mode=5;
				dmode.setText("The mode is now mode 5.  ");
			}
		}
	}
	
	
}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	focused=true;
	double cangle=0;
	cangle=Math.toDegrees(Math.atan((double)(getHeight()-e.getY())/(double)e.getX()));
	d.angle=cangle;
	angled.setText("Your current angle is "+(int)cangle+" degree, and you are focused.");
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(focused==false) {
		double cangle=0;
		cangle=Math.toDegrees(Math.atan((double)(getHeight()-e.getY())/(double)e.getX()));
		angled.setText("Your current angle is "+(int)cangle+" degree, you are not focused.");
		}
	}
}
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HashPlot extends JPanel{
	public static int a = 1;
	public static int b = 1;
	public static int m = 40;
	public static String input;
	
	public static int load;
	
	
	static int[] values = new int[1000];
	static int[] arr = new int[1000];
	
	public static void main(String[] args) throws Exception {
		
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		m = Integer.parseInt(args[2]);
		input = args[3];
		
		
		BufferedReader br = new BufferedReader(new FileReader(input));
				
		String line = null;		
		while((line = br.readLine()) != null){
			  String[] values = line.split(", ");
			  
			  for(int i = 0; i <values.length; i ++) {		  
				  arr[i] = Integer.parseInt(values[i]);
			  }	  
	}
		
		compute(arr, a , b, m);
		//Rehashing	
		for ( int i = 0; i < getMax(values); i++) {
	
			if(Arrays.asList(values).contains(values[i])) {
				load ++;
			}
			
			while (load/m >= 0.75&&m<=130) {
				m = m *2;
			}
			
			load = 0;			
	  }
		compute(arr, a , b, m);
		
		JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new HashPlot());
        f.setSize(720,460);
        f.setLocation(200,200);
        f.setVisible(true);
        //Generate PNG
        getSaveSnapShot(f, "Output.png");
        
		
	}
	
	public static void compute (int[] arr, int a, int b, int m) throws FileNotFoundException {
		int value;
		for (int i = 0; i < arr.length; i++) {
			value = (a*arr[i]+b)%m;
			values[i] = value;									
		}
		System.out.println(values);
		//Generate output sequence
		PrintWriter printWriter1;	
		printWriter1 = new PrintWriter("output_sequence");

		for (int i = 0; i < values.length; i++) {
			printWriter1.println(values[i]);
		}
		printWriter1.close();					
	}	
	
	//Plot
	@SuppressWarnings("serial")	
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        
      //Computing scale
        double xscale = (double)(w - 80)/1200;
        double yscale = (double)(h - 80)/m;
        
        // Draw x-axis
        g2.draw(new Line2D.Double(30, h-30, w-30, h-30));
        // Draw x legends
        for (int i = 0; i <= 6; i ++) {
        	double interval = (w-80)/6;
        	g2.draw(new Line2D.Double(40+i*interval, h-30, 40+i*interval, h-35));
        	g2.drawString(Integer.toString(200*i), Math.round(30+i*interval), h-10);
        }
        
        // Draw y-axis
        g2.draw(new Line2D.Double(30, h-30, 30, 30));
        for (int i = 0; i <= 5; i ++) {
        	double interval = (h-80)/5;
        	g2.draw(new Line2D.Double(30, h-(40+i*interval), 35, h-(40+i*interval)));
        	g2.drawString(Integer.toString(i*(m/5)), 2, Math.round(h-(35+i*interval)));
        }
        
        g.drawString("h(k)", w/2 - 10, h);
        g.drawString("k", 0, h/2+7);
       
        // Plot data points.
        g2.setPaint(Color.black);
        for(int i = 0; i < arr.length; i++) {
            double x = 40 + arr[i]*xscale;
            double y = h - 40 - values[i]*yscale;
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
	public static BufferedImage getScreenShot(Component component) {

        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        // paints into image's Graphics
        component.paint(image.getGraphics());
        return image;
    }
	 public static void getSaveSnapShot(Component component, String fileName) throws Exception {
	        BufferedImage img = getScreenShot(component);
	        // write the image as a PNG
	        ImageIO.write(img, "png", new File(fileName));
	    }
	 private static int getMax(int[] arr) {
	        int max = arr[0];
	        for(int i = 0; i < arr.length; i++) {
	            if(arr[i] > max)
	                max = arr[i];
	        }
	        return max;
	    }
    	
}

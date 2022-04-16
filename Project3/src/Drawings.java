import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Drawings extends JPanel{
	
	int xl;
	int yl;
	int mode;
	double angle;
	double v0=180;
	double g=9.8;
	int i1,i2,i3,i4;
	
	int x1,x2,x3,x4;
	int y1,y2,y3,y4;
	
	  double r;
	   double l;
double length;
	
	public Drawings() {
		mode=0;
		xl=0;
		angle=50;
		r=5;
		l=5;
		length=50;
		i1=0;
		i2=0;
		i3=0;
		i4=0;
	}
	
	public void setyl(int xl) {
		this.yl=getHeight()-(int) (-0.5*g*Math.pow(xl,2)/Math.pow(v0*Math.cos(Math.toRadians(angle)), 2)+Math.tan(Math.toRadians(angle))*xl);
	}
	public void reset() {
		xl=0;
		yl=getHeight();
		FireApp.angled.setText("You are not focused");
	}
	
	public int getxl() {
		return xl;
	}
	public int getyl() {
		return yl;
	}
	
//	public void setrheart(double angle) {
//		r=Math.sin(Math.toRadians(angle))*Math.sqrt(Math.abs(Math.cos(Math.toRadians(angle))))/(Math.sin(Math.toRadians(angle)+1.4))-2*Math.sin(Math.toRadians(angle))+2;
//	}
	
	
	@Override
	public void paintComponent(Graphics g) {
       if(xl==0) {
		yl=getHeight();
		g.setColor(Color.RED);
		g.fillOval(xl-10, yl-10, 20, 20);
		}else if(FireApp.flying==true) {
		g.setColor(Color.RED);
		g.fillOval(xl-10, yl-10, 20, 20);
		}else {
		   if(mode==0) {
			   if(i1==60) {
				   FireApp.timerg.stop();
				   reset();
				   FireApp.flying=true;
				   i1=0;
				   FireApp.focused=false;
			   }else {
				   Graphics2D g2=(Graphics2D) g;
				   g2.setColor(FireApp.c);
				   g2.setStroke(new BasicStroke(20));
				  g2.drawOval(xl-10-2*i1-1, yl-10-2*i1-1, 4*i1+2,4*i1+2);
			      i1+=1;  
			      g2.setStroke(new BasicStroke(1));
			   }  
		   }else if(mode==1) {
			 
			   if(r>=60) {
				   FireApp.timerg.stop();
				   reset();
				   FireApp.flying=true;
				   r=5;
				   l=5;
				   FireApp.focused=false;
			   }else {
				 
				   Graphics2D g2=(Graphics2D) g;
				   g.setColor(FireApp.c);

				   g2.setStroke(new BasicStroke(5));
			   for(double angle=0;angle<=360;angle+=10) {
				   g2.drawLine((int)(xl+r*Math.cos(Math.toRadians(angle))),(int)(yl-r*Math.sin(Math.toRadians(angle))),(int)(xl+(r+l)*Math.cos(Math.toRadians(angle))),(int)(yl-(r+l)*Math.sin(Math.toRadians(angle))));
				  
			   }
			   r+=1;
			   l+=3;

			   g2.setStroke(new BasicStroke(1));
			   }
			   
			   
		   }else if(mode==2) {
		if(i1<=100) {
			 x1=xl+i1;
			 x2=xl-i1; 
			 x3=xl;  
			 x4=xl;
			 y1=yl;
			 y2=yl;
			 y3=yl+i1;
			 y4=yl-i1;
			 g.setColor(FireApp.c);
	      g.fillOval(x1-5, y1-5, 15, 15);
	    g.fillOval(x2-5, y2-5, 15, 15);
		   g.fillOval(x3-5, y3-5, 15, 15);
		   g.fillOval(x4-5, y4-5, 15, 15);
			   i1+=2;
		}else {
			if(i4>=50) {
				   FireApp.timerg.stop();
				   reset();
				   FireApp.flying=true;
				   r=5;
				   FireApp.focused=false;
				   i4=0;
				   i1=0;
				   l=5;
			}else {
			
			if(r>=55) {
				   Graphics2D g2=(Graphics2D) g;
				   g.setColor(FireApp.c);

				   g2.setStroke(new BasicStroke(5));
			   for(double angle=0;angle<=360;angle+=10) {
				   g2.drawLine((int)(x1+r*Math.cos(Math.toRadians(angle))),(int)(y1-r*Math.sin(Math.toRadians(angle))),(int)(x1+(r+l)*Math.cos(Math.toRadians(angle))),(int)(y1-(r+l)*Math.sin(Math.toRadians(angle))));
				   g2.drawLine((int)(x2+r*Math.cos(Math.toRadians(angle))),(int)(y2-r*Math.sin(Math.toRadians(angle))),(int)(x2+(r+l)*Math.cos(Math.toRadians(angle))),(int)(y2-(r+l)*Math.sin(Math.toRadians(angle))));
				   g2.drawLine((int)(x3+r*Math.cos(Math.toRadians(angle))),(int)(y3-r*Math.sin(Math.toRadians(angle))),(int)(x3+(r+l)*Math.cos(Math.toRadians(angle))),(int)(y3-(r+l)*Math.sin(Math.toRadians(angle))));
				   g2.drawLine((int)(x4+r*Math.cos(Math.toRadians(angle))),(int)(y4-r*Math.sin(Math.toRadians(angle))),(int)(x4+(r+l)*Math.cos(Math.toRadians(angle))),(int)(y4-(r+l)*Math.sin(Math.toRadians(angle))));
			   }
				i4++;
				

			   }else {
				 
				   Graphics2D g2=(Graphics2D) g;
				   g.setColor(FireApp.c);

				   g2.setStroke(new BasicStroke(5));
			   for(double angle=0;angle<=360;angle+=10) {
				   g2.drawLine((int)(x1+r*Math.cos(Math.toRadians(angle))),(int)(y1-r*Math.sin(Math.toRadians(angle))),(int)(x1+(r+l)*Math.cos(Math.toRadians(angle))),(int)(y1-(r+l)*Math.sin(Math.toRadians(angle))));
				   g2.drawLine((int)(x2+r*Math.cos(Math.toRadians(angle))),(int)(y2-r*Math.sin(Math.toRadians(angle))),(int)(x2+(r+l)*Math.cos(Math.toRadians(angle))),(int)(y2-(r+l)*Math.sin(Math.toRadians(angle))));
				   g2.drawLine((int)(x3+r*Math.cos(Math.toRadians(angle))),(int)(y3-r*Math.sin(Math.toRadians(angle))),(int)(x3+(r+l)*Math.cos(Math.toRadians(angle))),(int)(y3-(r+l)*Math.sin(Math.toRadians(angle))));
				   g2.drawLine((int)(x4+r*Math.cos(Math.toRadians(angle))),(int)(y4-r*Math.sin(Math.toRadians(angle))),(int)(x4+(r+l)*Math.cos(Math.toRadians(angle))),(int)(y4-(r+l)*Math.sin(Math.toRadians(angle))));
			   }
			   r+=0.5;
			   l+=2;

			   g2.setStroke(new BasicStroke(1));
			   }
			
			
		}
		}
			   }else if(mode==3) {
			if(i2>=30) {
				   FireApp.timerg.stop();
				   reset();
				   FireApp.flying=true;
				   i1=0;
				   i2=0;
				   FireApp.focused=false;
			}else {
				   if(i1>=150) {
					   g.setColor(FireApp.c);
			           for(double angle=0;angle<=360;angle+=15) {
				            g.fillOval((int)(xl-5+i1*Math.cos(Math.toRadians(angle))), (int)(yl-5-i1*Math.sin(Math.toRadians(angle))), 10, 10);
			              }
					   i2++;
				   }else {
				   g.setColor(FireApp.c);
	           for(double angle=0;angle<=360;angle+=15) {
		            g.fillOval((int)(xl-5+i1*Math.cos(Math.toRadians(angle))), (int)(yl-5-i1*Math.sin(Math.toRadians(angle))), 10, 10);
	              }
				   i1+=2;	  
				   } 
			}  
			   }else if(mode==4) {
				   g.setColor(FireApp.c);
				   
				   if(i3>=60) {
					   FireApp.timerg.stop();
					   reset();
					   FireApp.flying=true;
					   i1=0;
					   i2=0;
					   i3=0;
					   FireApp.focused=false;
				   }else {
				   if(i2>=250) {
					   for(double angle=0;angle<=360;angle+=20) {
						   for(double angle1=0;angle1<=360;angle1+=30) {
							   g.fillOval((int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))),10,10);
						   }
					   }
					   i3++;
				   }else {
					   
				   if(i1>=150) {
					   for(double angle=0;angle<=360;angle+=20) {
						   for(double angle1=0;angle1<=360;angle1+=30) {
							   g.fillOval((int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))),10,10);
						   }
					   }
					   i2+=2;
				   }else {
				   for(double angle=0;angle<=360;angle+=30) {
			            g.fillOval((int)(xl-9+i1*Math.cos(Math.toRadians(angle))), (int)(yl-9-i1*Math.sin(Math.toRadians(angle))), 18, 18);
		              }
					   i1+=2;	  
				   }   
				   } 
				   }
			   }else if(mode==5) {
                         g.setColor(FireApp.c);
				  
               if(i4>=100) {
            	   FireApp.timerg.stop();
				   reset();
				   FireApp.flying=true;
				   i1=0;
				   i2=0;
				   i3=0;
				   i4=0;
				   FireApp.focused=false;
               }else {
				   if(i3>=1) {
					  Random r=new Random();
					     Random rand = new Random();
						   float x = rand.nextFloat();
						   float y = rand.nextFloat();
						   float z = rand.nextFloat();
						   Color c1 = new Color(x,y,z);
						   g.setColor(c1);
					  for(double angle=0;angle<=360;angle+=20) {
						   for(double angle1=0;angle1<=360;angle1+=30) {
							   for(int i=0;i<=2;i++) {
								    g.drawLine((int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))+r.nextInt(10)),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))+r.nextInt(10)),(int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))-r.nextInt(10)),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))-r.nextInt(10)));
								    g.drawLine((int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))-r.nextInt(10)),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))-r.nextInt(10)),(int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))+r.nextInt(10)),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))+r.nextInt(10)));
								    g.drawLine((int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))+r.nextInt(10)),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))-r.nextInt(10)),(int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))-r.nextInt(10)),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))+r.nextInt(10)));
								    g.drawLine((int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))-r.nextInt(10)),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))+r.nextInt(10)),(int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))+r.nextInt(10)),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))-r.nextInt(10)));
							   }
						   }
					  }
						   i4++;
				   }else {
				   if(i2>=200) {
					   for(double angle=0;angle<=360;angle+=20) {
						   for(double angle1=0;angle1<=360;angle1+=30) {
							   g.fillOval((int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))),10,10);
						   }
					   }
					   i3++;
				   }else {
					   
				   if(i1>=150) {
					   for(double angle=0;angle<=360;angle+=20) {
						   for(double angle1=0;angle1<=360;angle1+=30) {
							   g.fillOval((int)(xl-5+i1*Math.cos(Math.toRadians(angle))+i2*Math.cos(Math.toRadians(angle1))),(int)(yl-5-i1*Math.sin(Math.toRadians(angle))+i2*Math.sin(Math.toRadians(angle1))),10,10);
						   }
					   }
					   i2+=2;
				   }else {
				   for(double angle=0;angle<=360;angle+=30) {
			            g.fillOval((int)(xl-9+i1*Math.cos(Math.toRadians(angle))), (int)(yl-9-i1*Math.sin(Math.toRadians(angle))), 18, 18);
		              }
					   i1+=2;	  
				   }   
				   } 
				   }
				   
				   
               }
			   }
			   
		   }
			
			
		}


		
	}




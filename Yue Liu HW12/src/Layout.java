/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class Layout extends JFrame implements ActionListener,ChangeListener,ItemListener{
	private static final long serialVersionUID = 1L;
	TextField text2 = new TextField(39);
	JSlider s1 = new JSlider(0,100);
	JCheckBox cb1 = new JCheckBox("A");
	JCheckBox cb2 = new JCheckBox("B");
    JButton b;
    JLabel L;
    JLabel L1;
    JLabel L2;
    JLabel L3;
    JLabel L4;
    
    JButton c;
    private int numClicks = 0;
    
	public static void main(String[]args){
		new Layout().setVisible(true);
	}
	
	public Layout(){
		 setTitle("HW12");
		 setSize(500, 150);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 setLayout(new FlowLayout());
		 //Adding Components
		 L = new JLabel("Click me to count>>");
		 add(L);
		 
		 b = new JButton("Click me!");
		 b.addActionListener(this);
		 add(b);
		 
		 L1 = new JLabel("Click to Count!");
		 L1.setForeground(Color.RED);
		 add(L1);
         
         c = new JButton("off");
		 c.addActionListener(this);
         add(c);
         
         L2 = new JLabel("Enter text and press 'ENTER'>>");
         add(L2);
         
         add(text2);
         text2.addActionListener(this);      
         
         L3 = new JLabel("Use the Slider&Checkbox>>");
         add(L3);
         
         add(s1);
         s1.addChangeListener(this);
 
         
         add(cb1);
         cb1.addItemListener(this);
         add(cb2);
         cb2.addItemListener(this);
	}
	//Action Listener
	public void actionPerformed(ActionEvent e) { 
		//Assigning handlers
		if(e.getSource()==b){
			System.out.println("Action Performed!"+e);
			numClicks++;
	        L1.setText("Button Clicked " + Integer.toString(numClicks) + " times");
		}
		
		else if(e.getSource()==c){
			if (c.getText()=="off")
			{
			System.out.println("From off to on");
			c.setText("on");

			}
			else if (c.getText()=="on")
			{
			System.out.println("From on to off");
			c.setText("off");
			}
		}
		else if (e.getSource()==text2){
			System.out.println("Return/Enter Pressed!");
			L1.setText(e.getActionCommand());
		}
	}
	//ChangeListener
	public void stateChanged(ChangeEvent e) {
		System.out.println("Slider State Changed!" + e);
		int value = s1.getValue();
		L1.setText(Integer.toString(value));
        }    
	
	//ItemListener
	public void itemStateChanged(ItemEvent ie) {
	    if(ie.getSource()==cb1){
	    System.out.println("Checkbox A is changed."+" It is now " + ie.getStateChange());
	    L1.setText("Checkbox A changed."+" Value: " + ie.getStateChange());
	    }
	    else if(ie.getSource()==cb2){
	    System.out.println("Checkbox B is changed."+" It is now " + ie.getStateChange());
	    L1.setText("Checkbox B changed."+" Value: " + ie.getStateChange());
	    }
	}
}

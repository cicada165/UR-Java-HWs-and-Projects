/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public class Square extends Rectangle {
	
	 //Constructor
     public Square(String color, boolean filled, double width) {
    	 super(color,filled,width,width);
    	 height = width;
     }
     
     //Setter 
     @Override
     public void setWidth(double width) {
    	 this.width = width;
    	 height = width;
     }
     
}

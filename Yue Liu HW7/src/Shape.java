/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public abstract class Shape {
   private String color;
   private boolean filled;
   
   public Shape(String color, boolean filled) {
	   this.color = color;
	   this.filled = filled;
   }
   
   //Getters
   public String getColor() {
	   return color;
   }
   
   public boolean getfilled() {
	   return filled;
   }
   
   //Setters
   public void setColor(String color) {
	   this.color = color;
   }
   
   public void setFilled(boolean filled) {
	   this.filled = filled;
   }
}

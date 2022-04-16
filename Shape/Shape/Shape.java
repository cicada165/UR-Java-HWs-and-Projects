/*Name: Senqi Zhang
 * NetID: Szhang71
 * Assignment Number: Homework 3
 * Lab Section: T/R 11:05-12:20
 * ¡°I did not collaborate with anyone on this assignment.¡±
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

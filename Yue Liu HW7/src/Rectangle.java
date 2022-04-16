/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public class Rectangle extends Shape2D{
    public double height;
    public double width;
    
    //Constructor
    public Rectangle(String color, boolean filled, double height, double width) {
    	super(color,filled);
    	this.height = height;
    	this.width = width;
    }
    
    //Setters
    public void setHeight(double height) {
    	this.height = height;
    }
    
    public void setWidth(double width) {
    	this.width = width;
    }
    
    //Getters
    public double getHegiht() {
    	return height;
    }
    
    public double getWidth() {
    	return width;
    }
    
    
    @Override
    public double getArea() {
    	return height * width;
    }
}

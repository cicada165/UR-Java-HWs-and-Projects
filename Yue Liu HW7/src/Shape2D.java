/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
 
public abstract class Shape2D extends Shape{
	//Constructor
	public Shape2D(String color, boolean filled) {
		super(color, filled);
	}
    
	public abstract double getArea();
}

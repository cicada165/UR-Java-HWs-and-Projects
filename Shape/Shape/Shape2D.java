
 
public abstract class Shape2D extends Shape{
	//Constructor
	public Shape2D(String color, boolean filled) {
		super(color, filled);
	}
    
	public abstract double getArea();
}

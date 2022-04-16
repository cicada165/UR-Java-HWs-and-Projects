
public class Circle extends Eclipse{  
    
    public Circle (String color, boolean filled, double a) {
    	super(color,filled,a,a);
    	this.a = a;
    	b = a;
    }
    
    
    @Override
    public void setA(double a) {
    	this.a = a;
    	b = a;
    }
}

/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public class Circle extends Ecllipse{  
    
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

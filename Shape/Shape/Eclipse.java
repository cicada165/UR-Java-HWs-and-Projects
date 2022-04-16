
public class Eclipse extends Shape2D{
       public double a;
       public double b;
       
       //Constructor
       public Eclipse(String color,boolean filled, double a, double b) {
    	   super(color,filled);
    	   this.a = a;
    	   this.b = b;
       }
       
       //Setters
       public void setA(double a) {
    	   this.a = a;
       }
       
       public void setB(double b) {
    	   this.b = b;
       }
       
       //Getters
       public double getA(){
    	   return a;
       }
       
       public double getB() {
    	   return b;
       }
       
       
       //getArea
       @Override
       public double getArea() {
    	   return Math.PI * a * b;
       }
}

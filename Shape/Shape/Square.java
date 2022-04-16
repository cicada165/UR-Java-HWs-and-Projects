
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

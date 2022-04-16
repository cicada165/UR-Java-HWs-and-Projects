/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

import java.time.LocalDate;
public class Test {
	public static void main(String[]args){
		
		 //Following is for P1
		   System.out.println("The following is for P1:");
		 //Rectangle
		   Shape2D rectangle = new Rectangle("red",true,3,5);
		   System.out.println("The area of the rectangle is: " + rectangle.getArea());
		   //Square
		   Rectangle square = new Square("green",false,5);
		   square.setWidth(8.5);
		   System.out.println("The area of the square is: " + square.getArea());
		   //Ecllipse
		   Shape2D eclipse = new Ecllipse("blue", false, 2.5, 2.5);
		   System.out.println("The area of the eclipse is: " + eclipse.getArea());
		   //Circle
		   Ecllipse circle = new Circle("yellow", true, 1);
		   System.out.println("The area of the circle is: " + circle.getArea());
		  
		   //Following is for P2
		   System.out.println("\nThe following is for P2:");
		  //A student who majors in computer science
		   Person billy = new Student("Billy", 19 , 5854619701L , 30615786, new School ("UR"),  "Computer Science");	
	       System.out.println(billy.greeting());	
	       //A student in some other majors
	       Person joyce = new Student ("Joyce", 20 , 1234567890L, 12345678, new School ("UR"),  "Physics");
	       System.out.println(joyce.greeting());
	       
	       //Following is for P3
	       System.out.println("\nThe following is for P3:");
	       //Test for Class License
	       License a = new License(123456,LocalDate.of(1999, 02, 15));
	       License b = new License(1234567,LocalDate.of(1999, 02, 15));
	       System.out.println(a.toString());
	       //Test for method equals()
	       System.out.println(a.equals(b));
	       //Test for expiration() method
	       System.out.println(a.expiration());
	       //Test for class DriversLicense
	       License c = new DriversLicense(123,LocalDate.of(1999, 02, 15), "New York" );
	       License d = new DriversLicense(123,LocalDate.of(1999, 02, 15), "Indiana" );
	       System.out.println(c.equals(d));
	       //Test for class FishingLicense
	       License e = new FishingLicense(2333333,LocalDate.of(1999, 02, 15), "Whales");
	       System.out.println(e.toString());
	       //Test for class TrucksDriversLicense
	       License f = new TruckDriversLicense(666666,LocalDate.of(1999,8, 28), "Texas" );
	       System.out.println(f.toString());
	       
	       
		   
	}
}

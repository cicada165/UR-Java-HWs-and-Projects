/*Name: Senqi Zhang
 * NetID: Szhang71
 * Assignment Number: Homework 3
 * Lab Section: T/R 11:05-12:20
 * ¡°I did not collaborate with anyone on this assignment.¡±
 */

import java.time.LocalDate;

public class test {
   public static void main(String[]args) {
	   System.out.println("Test Section for Q1");
	   //Create a rectangle
	   Shape2D rectangle = new Rectangle("blue",true,3,5);
	   System.out.println("The area of the rectangle is: " + rectangle.getArea());
	   
	   //Create a square
	   Rectangle square = new Square("red",false,5);
	   square.setWidth(8.5);
	   System.out.println("The area of the square is: " + square.getArea());
	   
	   //Create a eclipse
	   Shape2D eclipse = new Eclipse("green", false, 2.5, 2.5);
	   System.out.println("The area of the eclipse is: " + eclipse.getArea());
	   
	   //Create a circle
	   Eclipse circle = new Circle("yellow", true, 1);
	   System.out.println("The area of the circle is: " + circle.getArea());
	   
	   
	   
	   System.out.println("\n" + "Test Section for Q2");
	   
	   //A student who majors in computer science
	   Person jason = new Student("Jason", 19 , 5855034035L , 30697201, new School ("University of Rochester"),  "computer science");	
       System.out.println(jason.greeting());	
       
       //A student who does not major in computer science
       Person sam = new Student ("Sam", 19 , 5851234567L, 12345678, new School ("University of Rochester"),  "business");
       System.out.println(sam.greeting());
	   
       
       System.out.println("\n" + "Test Section for Q3");
       
       //Test for class License
       License a = new License(123456,LocalDate.of(2020, 12, 25));
       License b = new License(1234567,LocalDate.of(2020, 12, 25));
       System.out.println(a.toString());
       //Test if the two license number equals
       System.out.println(a.equals(b));
       //Test if it expires
       System.out.println(a.expired());
       
       //Test for class DriversLicense
       License c = new DriversLicense(98765,LocalDate.of(2020, 12, 25), "New York" );
       License d = new DriversLicense(98765,LocalDate.of(2020, 11, 25), "Arizona" );
       System.out.println(c.equals(d));
       
       //Test for class FishingLicense
       License e = new FishingLicense(99999,LocalDate.of(2020, 10, 25), "goldfish");
       System.out.println(e.toString());
       
       //Test for class TrucksDriversLicense
       License f = new TrucksDriversLicense(11111,LocalDate.of(2020, 8, 25), "Arizona" );
       System.out.println(f.toString());
	}
}



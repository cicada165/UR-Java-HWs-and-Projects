import java.util.Scanner;


public class P3 {
	public static void main (String[]args){
		Scanner sc = new Scanner(System.in);
		double num1; 
        double num2; 
         
        System.out.print("Enter the first number:"); 
        num1 = sc.nextDouble (); 
         
        System.out.print("Enter the second number:"); 
        num2 = sc.nextDouble (); 
         
        System.out.println(); 
        System.out.println("Addition: " + num1 + " + " + num2 + " = " + (num1 + num2)); 
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + (num1 - num2)); 
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + (num1 * num2)); 
        System.out.println("Division: " + num1 + " / " + num2 + " = " + (num1 / num2)); 
        sc.close();
	}

}

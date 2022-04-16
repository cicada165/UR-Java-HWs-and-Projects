
import java.util.Scanner;
public class P5{
	public static void main (String[]args){
		double c = 300000000;
		double e;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter The Mass: ");
		double g = input.nextDouble();
		
		e = g*c*c;
		
		System.out.println("The Energy Equivalent in Joules is "+ e + ".");
		input.close();
	}
}
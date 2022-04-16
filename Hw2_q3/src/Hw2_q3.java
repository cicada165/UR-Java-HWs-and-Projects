//Yue Liu NetID:30615786 HW2
//I did not collaborate with anyone on this assignment.
import java.util.Scanner;
public class Hw2_q3 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		double entered = sc.nextInt();
		
		if (entered>0)
			System.out.println("The number is positive.");
		else if (entered < 0)
			System.out.println("The number is negative.");
		else
			System.out.println("The number is zero.");
	}

}

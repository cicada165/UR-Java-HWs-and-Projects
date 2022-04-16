//Yue Liu NetID:30615786 HW2
//I did not collaborate with anyone on this assignment.
import java.util.Scanner;

public class Hw2_q4 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter your age: ");
		int age = sc.nextInt();
		
		if (age <=13)
			System.out.println("You're just a kid");
		else if (age <=20)
			System.out.println("You're a teenager!");
		else if (age<=30)
			System.out.println("You're getting older...");
		else
			System.out.println("You're over the hill");
		
	}

}

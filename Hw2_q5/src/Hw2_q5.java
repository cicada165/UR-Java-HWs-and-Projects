//Yue Liu NetID:30615786 HW2
//I did not collaborate with anyone on this assignment.
import java.util.Scanner;
public class Hw2_q5 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" Enter 1 if you want to discuss sports or 2 to discuss food: ");
		int entered = sc.nextInt();
		
		if (entered ==1)
		{
			System.out.print("Do you play ice Hockey? (true/false): ");
			
			boolean a = sc.nextBoolean();
			if (a==true)
				System.out.println("Awesome!");
			if (a==false)
				System.out.println("You should try it some day.");
			
		}
		
		if (entered ==2)
		{
			System.out.print("How many times did you eat pizza last week (Enter a number): ");
			
			int num = sc.nextInt();
			if (num>5)
				System.out.println("You need to eat better.");
			else
				System.out.println("OK");
		}
		
	}

}

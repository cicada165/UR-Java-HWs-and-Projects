//Yue Liu NetID:30615786 HW2
//I did not collaborate with anyone on this assignment.
import java.util.Scanner;
public class Hw2_q1 {
	public static void main(String[]args){
		int secret = 7;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter your guess: ");
		int guess = sc.nextInt();
		
		if (guess == secret)
			System.out.println("You're a winner!");
		
		
	}

}

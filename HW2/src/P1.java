/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class P1 {
	public static void main(String[]args){
		int secret = 7;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter your guess: ");
		int guess = sc.nextInt();
		
		if (guess == secret)
			System.out.println("You're a winner!");
		
		else
			System.out.println("You guessed wrong!");
			
		sc.close();
		
	}

}

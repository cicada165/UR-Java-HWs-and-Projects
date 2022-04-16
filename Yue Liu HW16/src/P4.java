/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class P4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the nth Fibonacci word: ");
		int n = sc.nextInt();
		System.out.println("The " + n + "th Fibonacci word is " + Fibonacci(n) + "!");
		sc.close();
	}

	public static String Fibonacci(int n) {
		//Base cases
		if (n == 0) {
			return "0";
		}
		else if (n == 1) {
			return "01";
		}
		//Recursion step
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}
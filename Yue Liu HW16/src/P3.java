/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class P3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the nth Lucas Number: ");
		int n = sc.nextInt();
		System.out.println("The " + n + "th Lucas Number is " + Lucas(n) + "!");
		sc.close();
	}

	public static int Lucas(int n) {
		//Base Case
		if (n == 0) {
			return 2;
		}
		if (n == 1) {
			return 1;
		}
		//Recursive Step
		return Lucas(n - 1) + Lucas(n - 2);
	}
}
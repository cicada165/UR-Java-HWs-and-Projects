/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class P2 {
	static boolean Palindrome(int num)
	{	//Single digit numbers are automatically numerical palindrome.
		if (num < 10) return true;
		//Maths
		int size = (int)Math.log10(num);
		int tail = num%10;
		int pow = (int)Math.pow(10, size);
		int head = (int)num/pow;
		
		//Base case
		if(head!=tail) return false;
		
		//Recursive step
		//Remove first digit
		num = num-(head*pow);
		//Remove last digit
		num/=10;
		return Palindrome(num);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int num = sc.nextInt();
		System.out.println("It is " + Palindrome(num)+ " that " + num +" is numerical palindrome.");
	}
}

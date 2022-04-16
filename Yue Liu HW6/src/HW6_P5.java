/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Scanner;
public class HW6_P5 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter an integer: ");
		int intnum = sc.nextInt();
		System.out.print("Please enter an double: ");
		double doublenum = sc.nextDouble();
		System.out.print("Please enter an astronimical number: ");
		double bignumber = sc.nextDouble();
		
		System.out.printf("%d %.3f%n%n", intnum, doublenum);
		System.out.printf("%.3f" , Math.PI);
		System.out.println();
		System.out.printf("%,.3f%n",bignumber);
		
	}
}

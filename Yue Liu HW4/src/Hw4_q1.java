/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class Hw4_q1 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter an number: ");
		double num = sc.nextDouble();
		double square;
		
		do{
			square = Math.pow(num,2);
			System.out.println("The square of the number you enterer is: " + square);
			System.out.print("\nPlease enter another number: ");
			num = sc.nextDouble();
		}while(num!=0);
	
		sc.close();
		
		
	}

}

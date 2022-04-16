/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class Hw3_q2 {
	public static void main (String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter an number: ");
		int num = sc.nextInt();
		
		for (int x=1 ; x <= 10 ; x++){
			System.out.println(num*x);
			
		}
		sc.close();
	}

}

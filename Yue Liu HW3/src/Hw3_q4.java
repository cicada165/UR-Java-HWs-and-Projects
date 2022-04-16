/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class Hw3_q4 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		int num=sc.nextInt();
		
		while(num>=0){
			System.out.println(num--);
			
		}
		sc.close();
		
	}

}

/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class Hw4_q2 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int num = sc.nextInt();
		
		for (int x=1; x<=num; x++ ){
			for (int y=1; y<=num; y++){
				System.out.print(x*y);
				if (y<num){
					System.out.print(", ");
				}
				}
			System.out.println();
			}
		sc.close();
		}
		
	}


/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public abstract class Hw4_q3 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter three numbers: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
	
		
		while(num1!=0||num2!=0||num3!=0){
			for(int i = num1; i< num2; i = i + num3){
	
				System.out.println(i);
				
			}
			System.out.println("Please enter three other numbers: ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			num3 = sc.nextInt();
		
	}

		sc.close();
	}
}

/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class Hw4_q4 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		double n = sc.nextDouble();
		//int num;
		double sum = 0;
		//int sign;
		for (double x=1; x<=n; x=x+1){
			//sign = x;
			double item = 1/x;
			if (x%2==0)
				item = item*-1;
			//System.out.println(1/x);
			sum = sum + item;
			
		}
		System.out.println(sum);
		sc.close();
			
		
		
		
	}

}

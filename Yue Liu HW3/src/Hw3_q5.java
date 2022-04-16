/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class Hw3_q5 {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int num=0;
		int sum=0;;
		
		System.out.println("Please enter an number: ");
		num=sc.nextInt();
		while (num !=0){
			sum = sum + num;
			System.out.println("Please enter another number: ");
			num = sc.nextInt();
		}
		System.out.println("The sum of the numbers you entered is: " + sum);
		sc.close();
	}
}

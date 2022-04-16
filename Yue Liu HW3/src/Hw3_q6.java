/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class Hw3_q6 {
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);
		String s;
		String sum = "" ;
		System.out.print("Please enter a word: ");
		s = sc.nextLine();
		
		while (s.equals("stop")==false){
			sum =sum + s + " ";
			System.out.print("Please enter another word: ");
			s = sc.nextLine();
		}
		System.out.println("The strings you entered are: " + sum);
		sc.close();
		
	}

}

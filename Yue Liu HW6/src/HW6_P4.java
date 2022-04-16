/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.lang.String;
import java.util.Scanner;
public class HW6_P4 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the first String (String a): ");
		String a = sc.nextLine();
		System.out.println("Please enter the second String (String b): ");
		String b = sc.nextLine();
		
		if (a.equals(b)){
			System.out.println("These two Strings are equal.");
		}
		else if (a.startsWith(b)){
			System.out.println("String a starts with String b.");
		}
		else if (a.endsWith(b)){
			System.out.println("String a ends with String b.");
		}
		else if(a.contains(b)){
			System.out.println("String a contains String b.");
		}
		else{
			System.out.println("String a does not start/end/contain/ String b.");
		}
	}
	
}

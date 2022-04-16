/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class P3 {
	private static boolean walk = true;
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		System.out.println("The number you entered is: " + receiver(sc));
		
	}
	//static method
	public static int receiver(Scanner sc){
		do{
			try{
				System.out.print("Please enter a integer: ");
				int num = sc.nextInt();
				return num;
			}
			//Handle Exception
			catch (InputMismatchException e ){
				System.err.print("Exception: " +e);
				System.out.println("You must enter a number. Please try again.");
				//re-prompt
				sc.next();
			}
		  }while(walk = true);
		return 0;
	}
}

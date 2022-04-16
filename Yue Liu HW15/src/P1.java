/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class P1 {
	public static void main(String[]args){
		int num;
		int sum = 0;
		String s = null;
		Scanner sc = new Scanner(System.in);
		boolean walk = true;
		do{
			try{
		System.out.println("Please Enter an number: ");
		s = sc.nextLine();
		if(s.equals("stop")){
			walk = false;
		}
		num = Integer.parseInt(s);
		//incrementaion
		sum = sum + num;
		System.out.println("The sum is :" + sum);
			}
			//Handle Exception
			catch (NumberFormatException e ){
				System.err.println("Exception: " +e);
				System.out.println("You must enter decimal representation of a number. Please try again.");
			}
		  }while(walk == true);
	}
	

}

	


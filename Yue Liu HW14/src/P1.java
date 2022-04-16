/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class P1 {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Start your list by typing integers:");
		int n = myScanner.nextInt();

		while (n != 0){
			System.out.println("Add an integer to your list(enter 0 to stop):");
			ints.add(n);
			n = myScanner.nextInt();
		} 

		System.out.println("List built!");
		System.out.println();
		System.out.print("Enter a number to check if it's in the list already: ");
		n = myScanner.nextInt();
		//Check Presence of Element
		if (ints.contains(n)) {
			System.out.println(n + " is contained in your list.");
		} else {
			System.out.println(n + " isn't in your list.");
		}
		
		
		myScanner.close();
	}


}


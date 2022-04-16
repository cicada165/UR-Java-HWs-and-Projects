/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class P3 {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Start your list by typing strings:");
		String s = myScanner.next();
		boolean a = false;
		int check = 0;

		while (!s.equals("stop")) {
			System.out.println("Add an string to your list (enter 'stop' to stop):");
			strings.add(s);
			s = myScanner.next();
		} 

		System.out.println("List built!");
		System.out.println();
		System.out.print("Enter a string to check if it's in the list already: ");
		s = myScanner.next();

		for (String string : strings) {
			//Check Entire List
			//Check Presence of Element
			if (string.equals(s)) {
				System.out.println("Index " + check + " in the string list is equal to the target string.");
				a = true;
			}
			check++;
		}

		if (a == false) {
			System.out.println(s + " isn't in your list.");
		}

	
		myScanner.close();
	}

}

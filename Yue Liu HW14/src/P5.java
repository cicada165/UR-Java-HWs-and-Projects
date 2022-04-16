/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class P5 {
	public static void main(String[] args) {
		Set<String> strings = new HashSet<>();
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Start your name set by typing strings:");
		String s = myScanner.next();

		boolean a = false;
		while (!s.equals("stop")) {
			strings.add(s);
			System.out.println("Add a name to your set(enter 'stop' to stop):");
			s = myScanner.next();
		} 

		System.out.println("Set built!");
		System.out.println();
		System.out.print("Enter a string to check for the same name: ");
		s = myScanner.next();

		for (String string : strings) {
			if (string.equals(s)) {
				System.out.println(s + " is a name that was read in.");
				a = true;
			}
		}

		if (a == false) {
			System.out.println(s + " isn't a name that was read in.");
		}
		//Print to see if duplicates are eliminated
		printSet(strings);
		myScanner.close();
	}

	public static void printSet(Set<String> list) {
		System.out.println();
		System.out.print("Your set is: " + list.toString());
	}
}

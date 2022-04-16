/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class P4 {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Start your list by typing strings:");
		String s = myScanner.next();
		int index1;
		int index2;

		while (!s.equals("stop")) {
			System.out.println("Add an string to your list(enter 'stop' to stop):");
			strings.add(s);
			s = myScanner.next();
		} 
		System.out.println("List built");
		System.out.println();
		System.out.print("Enter the first integer index to check for equal string: ");
		index1 = myScanner.nextInt();
		System.out.print("Enter the second integer index to check for equal string: ");
		index2 = myScanner.nextInt();
		System.out.println();
		//Checking
		System.out.println("It is " + checkList(index1, index2, strings)
				+ " that the elements at the two indexes in the List are equal.");
		

		myScanner.close();
	}

	public static boolean checkList(int index1, int index2, List<String> strings) {
		int i = 0;
		String check1 = "";
		String check2 = "";
		for (String string : strings) {
			if (index1 == i) {
				check1 = string;
			}
			if (index2 == i) {
				check2 = string;
			}
			i++;
		}
		if (check1.equals(check2)) {
			return true;
		} else {
			return false;
		}
	}
}

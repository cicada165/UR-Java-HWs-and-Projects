/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class P6 {
	public static void main(String[] args) {
		
		Map<String, String> phonebook = new HashMap<>();
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Typing the first person's name and phone number separated by space:");
		String name = myScanner.next();
		String phoneNumber = myScanner.next();
		while (!name.equals("stop")) {
			phonebook.put(name, phoneNumber);
			System.out.println("Add another name and phone number separated by space(enter 'stop' to stop):");
			name = myScanner.next();
			if(!name.equals("stop")){
			phoneNumber = myScanner.next();
			}
			
		} 

		System.out.println("Map built!");
		System.out.println();
		System.out.print("Enter a person's name to find his/her phone number: ");
		name = myScanner.next();
		//Check Condition
		if (phonebook.containsKey(name)) {
			System.out.println("His/Her phone number is " + phonebook.get(name) + ".");
		} else {
			System.out.println("The name wasn't found.");
		}

		myScanner.close();
	}
}

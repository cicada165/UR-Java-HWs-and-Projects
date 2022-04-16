/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Lab3Task3 {
	public static void printArrayListBasicLoop(ArrayList<Integer> al){
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}

	public static void printArrayListEnhancedLoop (ArrayList<Integer> al){
		for (int element : al) {
			System.out.println(element);
		}
	}

	public static void printArrayListForLoopListIterator (ArrayList<Integer> al){
		for (Iterator<Integer> it = al.iterator(); it.hasNext(); ) {
			int output = it.next();
			System.out.println(output);
		}
	}

	public static void printArrayListLambda (ArrayList<Integer> al){
		Iterator<Integer> it = al.iterator();

		while (it.hasNext()) {
			int output = it.next();
			System.out.println(output);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//input integers with white space between them
		ArrayList<Integer> list = new ArrayList<Integer>();
		String[] tempB = scanner.nextLine().split("\\s");
		for(String s : tempB) {
			list.add(Integer.parseInt(s));
		}
		
		printArrayListBasicLoop(list);
		printArrayListEnhancedLoop(list);
		printArrayListForLoopListIterator(list);
		printArrayListLambda(list);
		
		scanner.close();
		

	}

}

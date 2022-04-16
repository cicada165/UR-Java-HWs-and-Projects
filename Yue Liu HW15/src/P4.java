/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class P4 {
	private static boolean walk = true;
	private static int index;
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		//Create array
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(7);
		list.add(8);
		System.out.print("Please enter an index: ");
		index = sc.nextInt();
		System.out.println("The element at the index you entered is: " + inputArray(index,list));
	}
		//static method
		public static int inputArray(int index, List<Integer> list ){
			  do{
			    	try{
						System.out.print("Please enter an index: ");
						return  list.get(index);
			    	}
			    	//Handle Exception
			    	catch ( IndexOutOfBoundsException e ){
			    		System.err.println("Exception: " +e);
			    		System.out.println("null");
			    		break;
			    	}
			    }while(walk = true);
			  return 0;
		}
	  
	

}

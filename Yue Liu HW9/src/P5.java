/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class P5 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Print enter the size of the Triangle Table you want: ");
		int size = sc.nextInt();
		//Controlling rows
		for (int i = 0; i < size; i++){
			//Controlling columns
			for (int j = i; j >= 0; j--){
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}

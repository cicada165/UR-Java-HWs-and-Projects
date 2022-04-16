/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class P1 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your desired value for x: ");
		int x = sc.nextInt();
		System.out.print("Please enter your desired value for y: ");
		int y = sc.nextInt();
		String xString = Integer.toString(x);
		String yString = Integer.toString(y);
		System.out.println(xString + " * " + yString + " = " + (mult(x,y)));
	}
	public static int mult(int x, int y){
		//Base Case
		if(x==0||y==0){
			return 0;
		}
		//Recursion step
		else{
			return x + mult(x,y-1);
			}	
			
		}
	
}


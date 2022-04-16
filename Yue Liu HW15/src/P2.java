/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class P2 {
	protected static int num1;
	protected static int num2;
	protected static String operation;
	protected static double result;
	protected static boolean walk = false;
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		do{
			try{
				System.out.print("Please enter a number, the operation symbol, and another number: ");
				operation = sc.nextLine();
				String[] inputSplit = operation.split(" ");
				//Split input
				int num1 = Integer.parseInt(inputSplit[0]);
				String symbol = inputSplit[1];
				int num2 = Integer.parseInt(inputSplit[2]);
				//Conditioning
				if(symbol.equals("+")){
					result = num1 + num2;
					System.out.println("The answer is: " + result);
			    }
				else if(symbol.equals("-")){
					result = num1 - num2;
					System.out.println("The answer is: " + result);
			    }
				else if(symbol.equals("*")){
					result = num1 * num2;
					System.out.println("The answer is: " + result);
				}
				else if(symbol.equals("/")){
					result = num1 / num2;
					System.out.println("The answer is: " + result);
					}
				else if(symbol.equals("%")){
					result = num1 % num2;
					System.out.println("The answer is: " + result);
					}
				else{
					System.out.println("Please enter a valid operation.");
				}
			}
			//Handle Exception
			catch(ArithmeticException e){
				System.err.println("Exception: " + e);
				System.out.println("You cannot devide by zero!");
			}
			catch(NumberFormatException f){
				System.err.println("Exception: " +f);
				System.out.println("You must enter decimal representation of a number.");
			}
			catch(InputMismatchException g){
				System.err.println("Exception: " +g);
				System.out.println("You must enter decimal representation of a number.");
			}
		}while(walk = true);
										}
}


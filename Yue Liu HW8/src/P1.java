/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;
public class P1 {
	public static void main(String[]args){
		//P1
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter the length of the array as you wish: ");
		int length = sc.nextInt();
		//Created the array as user requested
		int[] num = new int [length];
		int[] copy = new int [num.length];

		System.out.println("Please enter elements in the array: ");
		//Fill in the array
		for (int i=0; i <length;i++)
		{
	
			num[i]=sc.nextInt();
		}
		System.out.println("Output for Problem 2: ");
		printArray(num);
		System.out.println("\n\nOutput for Problem 3: ");
		mid(num);
		System.out.println("\nOutput for Problem 4: ");
		minimum(num);
		System.out.println("\nOutput for Problem 5: ");
		add_element(num,sc);
		System.out.println("\n\nOutput for Problem 6: ");
		copy(num,copy);
		System.out.println("\nOutput for Problem 7: ");
		add_array(num, copy);
	}
	//P2
	public static void printArray(int num[]){
		int i;
		System.out.print("Here is the Array you entered: " );
		for (i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
	}
	//P3
	public static void mid(int num[]){
		int mid_position = ((num.length)/2);
		double avg = 0;
		//If there are odd number of elements, then the middle number will just be the median
		if ((num.length)%2!=0){
		System.out.println("Index of Middle element of array is "+mid_position);
		System.out.println("Value stored in that position is "+num[mid_position] + "");
		}
		//If there are even number of elements, the median will be the average of two numbers in the middle
		else if ((num.length)%2==0){
			avg = ((double)(num[mid_position]+num[mid_position-1])/(2));
			System.out.println("Middle element of array is between index " + (mid_position-1) + " and " + "index " + mid_position);
			System.out.println("Value stored in that position is " + avg + "");
		}
	}
	//P4
	public static void minimum(int num[]){
		int min = num[0];
		for (int j = 1; j < num.length; j++){
			if (num[j] < min){
				min = num[j];
			}
		}
		System.out.println("The minimum number in the list is " + min + "");
	}
	//P5
	public static void add_element(int num[], Scanner sc){
		System.out.print("Please enter an integer that you want to add to each elements in the array: ");
		int add = sc.nextInt();
		for (int i = 0; i < num.length; i++){
			num[i] = num[i] + add;
		}
		//Array after addition from user's input
		System.out.print("Array after addition: ");
		for (int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
	}
	//P6
	public static void copy(int num[],int copy[]){
		for(int i = 0; i < copy.length; i++){
			//copying array
			copy[i]=num[i];
		}
		System.out.println("First element of shallow copy given array is: " + copy[0]);
		System.out.println("Last element of shallow copy given array is: " + copy[copy.length-1]);
	}
	//P7
	public static void add_array(int num[], int copy[]){
		for(int i = 0; i<num.length; i++){
			//combining array
			num[i] = num[i] + copy[i];
		}
		System.out.print("The original array: ");
		for(int i = 0; i<num.length; i++){
			 System.out.print(num[i]+ " ");
		}
		System.out.print("\nThe copy of the original array: ");
		for(int i = 0; i<copy.length; i++){
			 System.out.print(copy[i]+ " ");
		}
		}

	
}

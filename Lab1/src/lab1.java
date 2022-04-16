/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Arrays;
import java.util.Scanner;

public class lab1 {
	private static String a = new String();
	private static String b = new String();
	private static String c = new String();
	private static String d = new String();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Problem 1
		System.out.println("Let's check if two Strings are anagram of each other!");
		System.out.print("Please enter a String: ");
		a = sc.nextLine();
		System.out.print("Please enter another String: ");
		b = sc.nextLine();
		//Using method
		isAnagram(a,b);
		
		//Problem 2
		System.out.println("Let's check if two Strings are rotation of each other!");
		System.out.print("Please enter a String: ");
		c = sc.nextLine();
		System.out.print("Please enter another String: ");
		d = sc.nextLine();
		//Using method
		isROtation(c,d);
		sc.close();
		
	}
	public static void isAnagram(String a, String b) {
		char [] phrase1 = a.toCharArray();
		char [] phrase2 = b.toCharArray();
		//Sort Array in lexicographic order 
		Arrays.sort(phrase1);
		Arrays.sort(phrase2);
		
		if (Arrays.equals(phrase1, phrase2)==true)
			System.out.println("There is anagram present!"); 
		else
			System.out.println("There is no anagram present!"); 
			
		
		
	}
	public static void isROtation (String c, String d) {
		
		
		if (c.length()!=d.length()) {
			System.out.println("There is no rotation present!"); 
		}
		//Creating a new String that is twice as long so it contains all the possible rotation
		String temp = c + c;
		if (temp.contains(d)==true)
			System.out.println("There is rotation present!"); 
		
		else
			System.out.println("There is no rotation present!"); 	
	}
	
}


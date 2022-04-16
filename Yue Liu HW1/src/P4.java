import java.util.Scanner;
public class P4{
	public static void main (String[]args){
		
		
		int k;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please Enter Degrees Fahrenheit: ");
		int f = sc.nextInt();
		
		k =(5*(f-32)/9)+273;
		System.out.println("212 degrees Fahrenheit is " + k + " Kelvin." );
				
		sc.close();
	}
}

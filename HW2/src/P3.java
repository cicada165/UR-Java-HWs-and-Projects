import java.util.Scanner;
public class P3 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		double entered = sc.nextInt();
		
		if (entered>0)
			System.out.println("The number is positive.");
		else if (entered < 0)
			System.out.println("The number is negative.");
		else if (entered == 0)
			System.out.println("The number is zero.");
		
		sc.close();

	}

}

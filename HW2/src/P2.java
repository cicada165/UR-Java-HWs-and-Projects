import java.util.Scanner;
public class P2 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter an integer: ");
		int entered = sc.nextInt();
		
		if (entered%5==0)
			System.out.println(entered + " is a multiple of 5!");
		else
			System.out.println(entered + " is not a multiple of 5!");
		
		sc.close();
	}

}
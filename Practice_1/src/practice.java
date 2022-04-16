import java.util.Scanner;
public class practice {
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
		
		System.out.println(s);
		int a = Integer.parseInt(s);
		int b = a + 1;
		
		System.out.println(b);
		
		
		sc.close();
	}

}

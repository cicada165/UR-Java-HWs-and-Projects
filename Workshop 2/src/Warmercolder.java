import java.util.Scanner;
public class Warmercolder {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		//int check = 1;
		int num;
		System.out.print("Please enter your guess: ");
		int guess =sc.nextInt();
		System.out.print("Enter 'quit' if you want to quit: ");
		String quit = sc.nextLine();
		
		while(quit.equals("quit")==false){
			num = (int)(10*Math.random());//Math.random: 0-0.99
			while(guess!=num){
				int difference = (int)Math.abs(guess-num);
				if (difference==0)
					System.out.println("You got it!");
				else if (difference <=1)
					System.out.println("Smokin");
				else if (difference<=5)
					System.out.println("Warm");
				else
					System.out.println("frezzing cold");
				
				System.out.print("Please guess again: ");
				guess =sc.nextInt();
				System.out.print("Enter 'quit' if you want to quit: ");
				quit = sc.nextLine();
					
				
				
			}
		}
		sc.close();
	}

}

/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * In collaboration with Senqi Zhang; NetID: szhang71
 */
import java.util.Scanner;
import java.util.Random;

public class project1 {
	
	
	public static int score = 0;
	
	public static void main(String[] args) {
		 
		 //Introduction to the game
         System.out.println("This is a TTY game. You have a catapult that can launch projectiles.");
         System.out.println("Your goal is to let your projectile fly pass the wall.");
         System.out.println("At the start of each round, you will be informed of the height of the wall and the distance from it.");
         System.out.println("You will then be asked to input an angle and an intial speed.");
         System.out.println("The program will compute whether you make it over the wall.");
         System.out.println("You have 0 point at the start and each round cost you 1 point");
         System.out.println("You earn points each time clearing the wall and lose point hitting the wall");
         System.out.println("Points earned or lost  vary slightly based on the distance from the top of the wall");
         System.out.println("You will be informed of you score at the end of a round");
         System.out.println("Now, enter 'go' to start the game!");
		
        Scanner sc = new Scanner(System.in);
		Random ran = new Random();
	
		int h;
		int x;
		double thetaD;
		double speed;
		boolean round = true;
		String game = sc.next();
	   
		
		while (game.equals("go")) {
			//generate random numbers from 1 to 20
			round = true;
			h = 1 + ran.nextInt(20);
			x = 1 + ran.nextInt(20);
			
			
			//Loop for one round
			while (round == true) {
				System.out.printf("Height of the wall is %d%n", h);
			    System.out.printf("Distance of the wall is %d%n", x);
				
			    //Prompt for an angle and a speed
				System.out.print("Please set a launch angle in degree: ");
				thetaD = sc.nextDouble();
				System.out.print("Please set a launch speed: ");
				speed = sc.nextDouble();	
				
				
				boolean win = launch(h, x, thetaD, speed);
				
				//The scenario which the projectile doesn't make it over
				//Players have three options:
				//1.Try again with the same distance and height
				//2.Skip this round and start with new distance and height
				//3.Quit the game
				
				if (win == false) {
					System.out.print("Do you want to try again? (yes/skip/no): ");
					String answer = sc.next();
					if (answer.equals("no")){
						System.out.println("Your final score is " + score);
						System.out.println("Game ends");
						round = false;
						game = "stop";
						}else if (answer.equals("skip")){
							round = false;
						}
				    }else {
				    	//The scenario which the projectile makes it over
				    	//Players can choose continue the game or quit
				    	System.out.print("Do you wish to continue? (yes/no): ");
				          String loop = sc.next();
				             if (loop.equals("no")){
				            	System.out.println("Your final score is " + score);
				            	System.out.println("Game ends");
				            	round = false;
				                game = "stop";
				                }else if (loop.equals("yes")) {
				    	           round = false;
				                   }
				    
				}
				    
				    
			}
		} 
		sc.close();
	}
	
	//declare a static method that performs one launch
	public static boolean launch(int h, int x, double thetaD, double speed) {
		
		//Arrays that contain expressions
		String[] g1 = {"Bravo", "You made it", "Nice work"};
		String[] g2 = {"Too high", "Plenty of room", "Up to the sky"};
		String[] g3 = {"Not quite over", "just a little off"};
		String[] g4 = {"Not even close", "Try harder"}; 
		
		Random ran = new Random();
		boolean win = true;
		
		//Each round costs 1 point
		score -= 1;	
		
		//Calculate whether the projectile makes it over the wall
		double thetaR = thetaD * Math.PI / 180;
		double y = x*Math.tan(thetaR) - (9.8*x*x) / (2* Math.pow(speed * Math.cos(thetaR), 2));
		//We choose to use percent difference to determine the performance of user. The specific reason is explained in README.txt
		double pd = Math.abs(h-y) / h;
		
		//Different output for different circumstances with random generated feedback stored in the array
		if ((y > h) && (pd >= 0.1))
		{	int index = ran.nextInt(g2.length);
			System.out.println(g2[index]);
			score += 3;
			System.out.printf("Your current score is %d%n", score);
			
		}	
		else if ((y > h) && (pd <= 0.1))
		{   int index = ran.nextInt(g1.length);
			System.out.println(g1[index]);
			score += 5;
			System.out.printf("Your current score is %d%n", score);
			
		}	
		else if ((y < h) && (pd <= 0.1))
		{	
			int index = ran.nextInt(g3.length);
			System.out.println(g3[index]);
			win = false;
			System.out.printf("Your current score is %d%n", score);
			
		}	
		else if ((y < h) && ( pd >= 0.1))
		{	
			int index = ran.nextInt(g4.length);
			System.out.println(g4[index]);
			score -=2; 
			win = false;
			System.out.printf("Your current score is %d%n", score);
			
		}
		return win;
	}
}

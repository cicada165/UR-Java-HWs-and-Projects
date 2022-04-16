/*Yue Liu
 *NetID: yliu165
 *TR 940-1055
 *TA Rahaf AlQarni
 *In collaboration with Daiwei Zhang; NetID: dzhang28
 */

//Necessary comments are included to explain
//Design Decisions are explained in readme.txt
//To quit a round, you can input to power or clubNo

import java.util.Scanner;

public class TTYGolfTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean round = true;
				
		System.out.printf("Welcome to TTY Golf!%n%n");
		
		while (round == true) {
			
			int totalScore = 0;
					
			System.out.printf("Please select a course:%n1. Genesee Valley Park North Course%n"
					+ "2. The Old Course at St. Andrews%nYour choice [1-2]: ");
			int courseChoice = sc.nextInt();
			
			Course yourCourse = null;
			
			//Based on user's choice, create different objects
			//Casting Objects
			if (courseChoice == 1) {			
				yourCourse = new GeneseeCourse();
				System.out.printf("%nYou are playing Genesee Valley Park North Courses.%n%n");
			}	
			
			else if (courseChoice == 2) {				
				yourCourse = new OldCourse();
				System.out.printf("%nYou are playing The Old Course at St. Andrews.%n%n");
			}
			
			
			//This loop allows user to go through all 18 holes in turn
			holeLoop:
			for (int holeNo = 1; holeNo <= 18; holeNo++) {
				
				int shotCount = 0;
				int yardsToHole = yourCourse.getYards(holeNo);
				
				while (Math.abs(yardsToHole) > 20) {
					
					//if the ball is at the tee
					if (yardsToHole == yourCourse.getYards(holeNo))
						System.out.printf("%n[You are at No.%d tee. %d yards, par %d]%n", 
								holeNo, yourCourse.getYards(holeNo), yourCourse.getPar(holeNo));
					
					else {
						System.out.println("You are in the fairway");
						
						System.out.printf("No.%d shot. %d yards to the hole.%n", 
								shotCount + 1, yardsToHole);					
					}
									
					System.out.print("Choose your club [1-10]: ");
					int clubNo = sc.nextInt();
					
					System.out.print("Choose your power [1-10]: ");
					int power = sc.nextInt();
					
					//EXTRA CREDIT
					//If the user input a zero to clubNo or power
					//Then this round is considered as abandoned
					if (clubNo == 0 || power == 0) {
						System.out.println("You have abandoned this round");
						break holeLoop;
					}
						
					
					Club yourClub = new Club(clubNo);					
					int hitDist = yourClub.nextDist(power);
					
					
					if (yardsToHole >= 0)
						yardsToHole -= hitDist;
					//If the shot makes ball go over the green (so is the hole)
					//game allows the user make a shot in opposite direction
					else
						yardsToHole += hitDist;
					
					System.out.printf("You hit the ball %d yards.%n%n", hitDist);
					
					shotCount++;
				}
				
				
				//Unit Convert
				int feetToHole = yardsToHole * 3;
								
				while (Math.abs(feetToHole) > 1) {
					
					System.out.println("You are on the green.");
					System.out.printf("No.%d shot. %d feet to the hole.%n", 
							shotCount + 1, feetToHole);
					
					System.out.print("Power [1-10]: ");				
					int power = sc.nextInt();
					
					//EXTRA CREDIT
					//If the user input a zero to power
					//Then this round is considered as abandoned
					if (power == 0) {
						System.out.println("You have abandoned this round");
						break holeLoop;
					}
						
					
					Putting yourPutt = new Putting(power);
					int puttDist = yourPutt.nextPuttDist();
					
					System.out.printf("Your putt went %d feet.%n%n", puttDist);
					
					if (feetToHole > 0)
						feetToHole -= puttDist;
					//If the putt makes ball go over the hole
					//game allows the user make a putt in opposite direction
					else
						feetToHole += puttDist;
					
					shotCount++;
				}
							
				System.out.println("It's in the hole!");
								
				//Method scoreThisHole prints score after each hole
				//and returns an integer to change value of totalScore
				//EXTRA CREDIT in this method
				totalScore = totalScore + yourCourse.scoreThisHole(holeNo, shotCount);
				
				//Print the current string format toal score 
				//with static method scoreToString
				System.out.printf("Your score after No.%d hole is: %s%n%n", 
					holeNo, scoreToString(totalScore));
				
				System.out.print("Type RETURN to continue to next hole,"
						+ "or ABANDON to abandon the round: ");
				String typeReturn = sc.next();
				
				//If user doesn't input RETURN
				//the holeloop breaks
				if (!("RETURN".equals(typeReturn)))
					break;
			}
			
			System.out.printf("%nYour final score is: %s%n%n", scoreToString(totalScore));
					
			System.out.print("Would you like play another round [Y/N]? ");
			String answer = sc.next();
			
			if (answer.equals("Y"))
				round = true;
			//If user input N, the outer while loop breaks
			else if (answer.equals("N"))
				round = false;
			else
				throw new IllegalArgumentException("Please enter Y/N");
			
			System.out.printf("%n");
		}
		
		System.out.println("GAME OVER!");
		
		sc.close();		
	}
	
	//Declare a static method to convert integer totalScore
	//to a string form score
	public static String scoreToString(int totalScore) {
		if (totalScore > 0)
			return String.format("%d Over", totalScore);
		else if (totalScore < 0)
			return String.format("%d Under", -totalScore);
		else
			return String.format("Par");		
	}	
}


public class Course {
	
	int[][] specifications;
	
	public int getYards(int holeNo) {
		return specifications[holeNo-1][0];
	}
	
	public int getPar(int holeNo) {
		return specifications[holeNo-1][1];
	}
		
	//This method prints score after each hole
	//and returns an integer to change value of totalScore in main method
	
	public int scoreThisHole(int holeNo, int shotCount) {
		
		//EXTRA CREDIT
		//using terms Bogey
		if (shotCount > this.getPar(holeNo)) {
			if (shotCount - this.getPar(holeNo) == 1)
				System.out.println("You made a Bogey");
			else
				System.out.printf("You made %d Over on this hole%n", 
					shotCount - this.getPar(holeNo));
		}
		
		//EXTRA CREDIT
		//using terms Birdie
		else if (shotCount < this.getPar(holeNo)) {
			if (this.getPar(holeNo) - shotCount == 1)
				System.out.println("You made a Birdie!");			
			else
				System.out.printf("You made %d Under on this hole%n", 
					this.getPar(holeNo) - shotCount);
		}
		
		else
			System.out.printf("You made Par on this hole.%n");
		
		return (shotCount - this.getPar(holeNo));			
	}
}

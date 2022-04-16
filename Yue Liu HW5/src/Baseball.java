/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public class Baseball {
	//This is the class for HW5 Problem 4
	public int bat;
	public int hit;
	public int run;
	public int game;
	public double batting_avg;
	public double runs_per_game;
	
	public Baseball(int a, int b, int c, int d){
		bat = a;
		hit = b;
		run = c;
		game = d;
	}
	public double ba(int a, int b){
		bat = a;
		hit = b;
		batting_avg = b/a;
		System.out.print("His batting average is ");
		return batting_avg;
	}
	public double rpg(int c, int d){
		run = c;
		game = d;
		runs_per_game = c/d;
		System.out.print("His runs per game is ");
		return runs_per_game;
	}
	public int getBat(){
		return bat;
	}
	public void setBat(int bat){
		this.bat = bat;
	}
	public int getHit(){
		return hit;
	}
	public void setHit(int hit){
		this.hit = hit;
	}
	public int getRun(){
		return run;
	}
	public void setRun(int run){
		this.run = run;
	}
	public int getGame(){
		return game;
	}
	public void setGame(int game){
		this.game = game;
	}
	public double getBa(){
		return batting_avg;
	}
	public void setBa(double batting_avg){
		this.batting_avg = batting_avg;
	}
	public double getRpg(){
		return batting_avg;
	}
	public void setRpg(double runs_per_game){
		this.runs_per_game = runs_per_game;
	}
	

	
}

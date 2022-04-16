import java.util.Random;

public class Club {
	
	Random random = new Random();
	
	//MultiDimArray that stores specifications for different clubs
	int[][] allClubs = {
		{230, 30}, {215, 20}, {180, 20}, {170, 17}, {155, 15},
		{145, 15}, {135, 15}, {125, 15}, {110, 10}, {50, 10}};
	int mean;
	int std;
	
	public Club(int clubNo) {
		mean = allClubs[clubNo - 1][0];
		std = allClubs[clubNo -1][1];
	}
	
	//Calculate how far the ball travels for each shot
	public int nextDist(int power) {		
		double mean_adj = mean * power / 10.0;
		double std_adj = std * power / 10.0;
		double val = Math.abs(random.nextGaussian() * std_adj + mean_adj);
		return (int)val;
	}
}

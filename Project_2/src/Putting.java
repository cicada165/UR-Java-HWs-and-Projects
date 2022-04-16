import java.util.Random;

public class Putting {
	Random random = new Random();
	
	//MultiDimArray that stores specifications for putting
	int[][] put = {
		{1, 1}, {2, 1}, {4, 2}, {8, 2}, {12, 3},
		{16, 3}, {20, 4}, {25, 4}, {30, 5}, {40, 5}};
	int mean;
	int std;
	
	public Putting(int power) {
		mean = put[power - 1][0];
		std = put[power - 1][1];
	}
	
	//Calculate how far the ball travels for each putt
	public int nextPuttDist() {
		double val = Math.abs(random.nextGaussian() * std + mean);
		return (int)val;
	}
	
}

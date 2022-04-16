/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Random;
public class HW6_P3 {
	public static void main(String[]args){
		Random r = new Random();
		int num = r.nextInt(99)+1;
		System.out.println("The random int number is : " + num);
		
		double mu = r.nextDouble();
		double sigma = r.nextDouble();
		double nextGaussian = r.nextGaussian();
		
		double gaussianDistributedValue = mu +sigma * nextGaussian;
		
		System.out.println(mu);
		System.out.println(sigma);
		System.out.println(gaussianDistributedValue);
		
	}
	
	
	
}

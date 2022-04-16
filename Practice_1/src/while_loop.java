import java.time.Year;
import java.util.Scanner;
public class while_loop {
	public static void main(String[]args){
		//double age;
		long year=0;
		long dogYears;
		
		Scanner sc = new Scanner(System.in);
		long age = (long) sc.nextDouble();
		//age = Integer.parseInt(s);
		
		for (int x=0 ; x <= age ; x++){
			
			dogYears = year * 7;
			System.out.println(year + " human year" + " is " + dogYears + " in dog years. ");
		}
	}

}

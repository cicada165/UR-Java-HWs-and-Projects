/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.time.LocalDate;
//This is the main method that tests all the classes defined in this HW6.
public class Test {
	public static void main (String[]args){
		//Following is for Problem 1
		Article a1 = new Article("Mark", LocalDate.of(2017,12,15));
		Article a2 = new Article("Frank");
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.print("The review of the article (likes minus dislikes) is: ");
		System.out.println(a2.review(5, 1));//Method review
		//Following is for Problem 2
		Employee e1 = new Employee("Yue", "Liu", 123456, 6666, 0);
		Employee e2 = new Employee("Tachanka", "Senaviev");
		
		e1.raise(8888,1.1);//Method raise
		System.out.println(e1.toString());
		System.out.println(e2.toString());
	}
}

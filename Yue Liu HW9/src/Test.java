/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import my.players.*;
import bankaccount.Account;
public class Test {
	public static void main(String[]args){
		//Following is for P3
		System.out.println("Following output is for P3.");
		//Constructing objects
		SoccerPlayer a = new SoccerPlayer();
		SaxophonePlayer b = new SaxophonePlayer();
		Mp3Player c = new Mp3Player();
		//Printing instances
		a.printMsg();
		b.printMsg();
		c.printMsg();
		
		//Following is for P4
		System.out.println("\nFollowing output is for P4.");
		//Creating an object for bank account using “fully qualified name
		bankaccount.Account ba = new bankaccount.Account();
		//Prints instance
		System.out.println(ba.toString());
		//Creating an object for computer user account using “fully qualified name
		computeruseraccount.Account ca = new computeruseraccount.Account();
		//Prints instance
		System.out.println(ca.toString());
	}
}

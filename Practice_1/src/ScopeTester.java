public class ScopeTester {
protected int num; 
protected String str; 
static final String[] labels = { "Hello", "Goodbye", "Whatever" };
public ScopeTester(int num, String str) { 
	this.num = num; 
	this.str = str; }

public void printout() { 
	System.out.println(num + " " + str); 
	}
public void doubleMe() {
	num *= 2; str += " " + str; 
	}
public int twoTimes(int num) { 
	num *= 2; return num; 
	}
public static void main(String[] args) { 
	for (int num=0; num < 3; num++) {
		ScopeTester tester = new ScopeTester(num, labels[num]); 
		int num2 = tester.twoTimes(num); 
		tester.doubleMe(); 
		tester.printout(); 
		}
 }
}
	


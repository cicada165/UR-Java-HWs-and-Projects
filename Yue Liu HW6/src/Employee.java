/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
public class Employee {
	//This is the class for HW6 Problem 2
	String fname;
	String Lname;
	long id;
	double salary;
	double raise = 0;
	
	public Employee(String a, String b, long c, int d, double e){
		fname = a;
		Lname = b;
		id = c;
		salary = d;
		raise = e;
	}
	public Employee (String a, String b){
		fname = a;
		Lname = b;
	}
	public double raise(double a, double b){
		raise = b;
		salary = a*b;
		return salary;
	}
	public String toString(){
		return "\nFirst Name: "+fname+"\nLast name: "+Lname+"\nID: "+id+"\nSalary: "+salary+"";
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public double getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}

/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public class Student extends Person {
	public long id;
	public String major;

	//Constructor
	public Student(String a, int b, long c, long d, School sc, String e) {
		super(a, b, c);
		id = d;
		major = e;
	}
	
	  //Setters
    public void setId(long id) {
  	  this.id = id;
    }
    
    public void setMajor(String major) {
  	  this.major = major;
    }
    
    //Getters
    public long getId() {
  	  return id;
    }
    
    public String getMajor() {
  	  return major;
    }
    
    
    @Override
	public String greeting(){
		if (major == "Computer Science"){
			return "Greetings Earthling!";
		}
		else{
			return "Hey.";
		}
	}
	
	
	
}

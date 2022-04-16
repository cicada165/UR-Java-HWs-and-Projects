/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

import java.time.LocalDate;


public class FishingLicense extends License{
	String type;
    //Constructor
	public FishingLicense(long a, LocalDate b, String c) {
		super(a, b);
		type = c;
		
	}
	@Override
    public String toString() {
   	 return "The Fishing Lisence is: " + Lnum + "\nExpiration Date: " + Ldate + "\nYou are perimitted to catch: " + type;
    }
	
	
	
	//Getter
	public String getType() {
		return type;
	}
	//Setter
	public void setType(String type) {
		this.type = type;
	}

}

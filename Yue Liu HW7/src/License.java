/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

import java.time.LocalDate;
public class License {
	public long Lnum;
	public LocalDate Ldate;
	
	
	//Constructor
	public License(long a, LocalDate b){
		Lnum = a;
		Ldate = b;
	}
	//Compare the first boolean with a second one
	public boolean equals(License license2){
		if (Lnum == license2.getLnum()){
			return true;
		}
		else{
			return false;
		}
	}
	//If the difference between current date and local date is positive, it is not expired yet.
	public boolean expiration(){
		if (LocalDate.now().compareTo(Ldate) > 0){
		return true;
		}
		else{
		return false;
		}
	}
	public String toString(){
		return "License Number: "+Lnum+"\nExpiration Date: "+Ldate+"";
	}
	//Setters
	public void setL_num(long Lnum) {
		this.Lnum = Lnum;
	}
	public void setLdate(LocalDate ldate) {
		Ldate = ldate;
	}
	//Getters
	public LocalDate getLdate() {
		return Ldate;
	}
	public long getLnum() {
		return Lnum;
	}
}

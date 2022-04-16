/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.time.LocalDate;


public class DriversLicense extends License {
	public String issued_state;
	//Constructor
	public DriversLicense(long a, LocalDate b, String c) {
		super(a, b);
		issued_state = c;
	
	}
	
	   @Override
	   public boolean equals(License license2) {
			DriversLicense b = (DriversLicense) license2;
			//First compares whether they are within the same state
			if (issued_state.equals(b.getIssued_state())) {
				if(Lnum == license2.getLnum()) {
		    		return true;
		    	}else {
		    		return false;
		    	}
			} else {
				return false;
			}
		}
	
	//Getter
	public String getIssued_state() {
		return issued_state;
	}
    //Setter
	public void setIssued_state(String issued_state) {
		this.issued_state = issued_state;
	}
	
}

import java.time.LocalDate;

public class DriversLicense extends License{
	public String state;
	
	//Constructor
    public DriversLicense(long lnumber, LocalDate edate, String state) {
		super(lnumber, edate);
		this.state = state;
	}
    
    //Setter
    public void setState(String state) {
    	this.state = state;
    }
    
    //Getter
    public String getState() {
    	return state;
    }
    
	@Override
	
	//Equals method that determine if it's the same state first, then the license number.
	public boolean equals(License license2) {
		DriversLicense b = (DriversLicense) license2;
		if (state.equals(b.getState())) {
			if(lnumber == license2.getLnumber()) {
	    		return true;
	    	}else {
	    		return false;
	    	}
		} else {
			return false;
		}
	}
    	  
    
}

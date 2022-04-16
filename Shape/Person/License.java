import java.time.LocalDate;

public class License {
    public long lnumber;
    public LocalDate edate;
    
    public License(long lnumber, LocalDate edate) {
    	this.lnumber = lnumber;
    	this.edate = edate;
    }
    
    public String toString() {
    	return "The License number is: " + lnumber + " and it expires at: " + edate;
    }
    
    //Setters
    public void setLnumber(long lnumber) {
    	this.lnumber = lnumber;
    }
    
    public void setEdate(LocalDate edate) {
    	this.edate = edate;
    }
    
    //Getters
    public long getLnumber() {
    	return lnumber;
    }
    
    public LocalDate getEdate() {
    	return edate;
    }
    
    //The method takes another license number and determine they are equal to each other
    public boolean equals(License license2) {
    	if(lnumber == license2.getLnumber()) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    //If the expiration date is after the current date, it will return false, which means it hasn't expired.
    public boolean expired() {
    	if(edate.isAfter(LocalDate.now())) {
    		return false;
    	}else{
    		return true;
    	}
    }

}

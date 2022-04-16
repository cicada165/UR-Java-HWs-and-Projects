import java.time.LocalDate;

public class FishingLicense extends License {
     String ctype;
     
     public FishingLicense(long lnumber, LocalDate edate, String ctype) {
    	 super(lnumber,edate);
    	 this.ctype = ctype;
     }
     
     public void setCtype(String ctype) {
    	 this.ctype = ctype;
     }
     
     public String getCtype() {
    	 return ctype;
     }
     
     @Override
     public String toString() {
    	 return "The License number is: " + lnumber + " ,it expires at: " + edate + " and you are permitted to catch: " + ctype;
     }
}

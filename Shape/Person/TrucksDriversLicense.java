import java.time.LocalDate;

public class TrucksDriversLicense extends DriversLicense {
	 
	public TrucksDriversLicense(long lnumber, LocalDate edate, String state) {
			super(lnumber, edate, state);
		}
	
	@Override
	public String toString() {
		return "The License number for the turck driver is: " + lnumber + " and it expires at: " + edate;
	}
}

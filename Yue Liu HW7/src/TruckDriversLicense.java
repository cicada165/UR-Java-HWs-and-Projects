/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

import java.time.LocalDate;


public class TruckDriversLicense extends DriversLicense {
	//Constructor
	public TruckDriversLicense(long a, LocalDate b, String c) {
		super(a, b, c);
	}
		@Override
	public String toString(){
		return "This truck driver's License number is: " + Lnum + "\nExpiration Date: " + Ldate;
	}


}

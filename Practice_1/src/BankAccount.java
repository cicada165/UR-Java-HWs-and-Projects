
public class BankAccount {
	private int accountNumber;
	private double balance;
	
	private static int numAccounts = 0;
	
	public static int getNumAccounts(){
		return numAccounts;
	}
	
	private int id;
	public int getId(){
		return this.id;
	}
	private static int nextId = 1;
}

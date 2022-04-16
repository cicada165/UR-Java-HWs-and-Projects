
public class BankAccountTest {
	public static void main(String[]args){
		System.out.println("numAccounts="+BankAccount.getNumAccounts());
		BankAccount account = new BankAccount(12345);
		System.out.println("numAccounts="+BankAccount.getNumAccounts());
		System.out.println("id="+account.gettNumAccounts());
		
		BankAccount a2 = new BankAccount(98765);
		
		System.out.println("numAccounts="+BankAccount.getNumAccounts());
		BankAccount a3 = new BankAccount(98765);
		System.out.println("numAccounts="+account.gettNumAccounts());
		
	}
}

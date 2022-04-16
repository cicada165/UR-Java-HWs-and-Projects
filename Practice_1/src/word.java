public class word { 
	private int i = 99; 
	public void doSomething(int i) { 
		for (i = 0; i < 10; i++) { 
			System.out.println(i); 
			} 
		} 
	public static void main(String[] args) { 
		word i = new word(); 
		i.doSomething(99); 
		System.out.println(i.i); }
	}
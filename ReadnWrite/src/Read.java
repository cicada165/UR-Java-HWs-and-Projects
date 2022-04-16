import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Read {
	 public static void main(String[] args) throws IOException {
		 try {
	         Scanner sc = new Scanner(System.in);
	         System.out.print("Enter file name: ");
	         String fileName = sc.nextLine();
	         
	         Scanner input = new Scanner(new File(fileName));
	        
	         while (input.hasNext()) {
	             String line = input.nextLine();
	             System.out.println(line);
	         }
	     } 
		//Handle Exception
		 catch (FileNotFoundException e) {
	         System.out.println("Exception: " + e);
	     }
		}
}

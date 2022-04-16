/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class P5 {
	 public static void main(String[] args){
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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class WriteTest {
	public static void main(String[]args){
		String inFilename = "README.txt";
		String outFilename = "output.txt";
		try{
			Scanner input = new Scanner(new File(inFilename));
			PrintWriter out = new PrintWriter(new File(outFilename));
			while(input.hasNext()){
				String line = input.nextLine();
				out.println(line);
			}
			input.close();
			out.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Couldn't write file: " + e.getMessage());
		}
	}
}

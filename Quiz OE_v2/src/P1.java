import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class P1 {
    static final int INF = 99999; 
      
    public static void main (String[] args) throws IOException 
    { 
    	BufferedReader reader;
    	
    	reader = new BufferedReader(new FileReader(args[0]));
        String line = reader.readLine(); 
        int v = Integer.parseInt(line.split(" ")[0]); // # of Vertices
        int e = Integer.parseInt(line.split(" ")[1]); //# of Edges
        int graph[][] = new int[e][v];
        for (int i = 0; i < e; i++) {
        	for (int j = 0; j < v; j++) {
        		graph[i][j]=INF;
        	}
        }

        
    	try {
            line = reader.readLine();
            int row = 0;
            while (line != null) {

                int start = Integer.parseInt(line.split(" ")[0]);
                int dist = Integer.parseInt(line.split(" ")[1]);
                int weight = Integer.parseInt(line.split(" ")[2]);
                graph[row][start-1]= 0;
                graph[row][dist-1]= weight;
                line = reader.readLine();
                row++;
            }
            
//            for (int i = 0; i < e; i++) {
//                for (int j = 0; j < v; j++) {
//                    System.out.println("graph[" + i + "][" + j + "] = "
//                                       + graph[i][j]);
//            }
//    		}   
            
            int dist[][] = new int[e][v], i, j, k; 
            

            for (i = 0; i < e; i++) {
                for (j = 0; j < v; j++) {
                    dist[i][j] = graph[i][j]; 
                }
            }
          
            for (k = 0; k < v; k++) { 
                for (i = 0; i < e; i++) { 
                    for (j = 0; j < v; j++) { 
                        if (dist[i][k] + dist[k][j] < dist[i][j]) 
                                dist[i][j] = dist[i][k] + dist[k][j]; 
                    } 
                } 
            } 

            String[] result = new String[v];
            for (i = 0; i < v; i++) {
                if (dist[i][i] < 0) {
                	result[i]="YES";
                }else if (dist[i][i]>=0){
                	result[i]="NO";
                }
            }
            
            if (Arrays.asList(result).contains("YES")) {
            	System.out.println("YES");            	
            }else {
            	System.out.println("NO");  
            }
                
            
        } catch (IOException ioexception) {
    }        
    } 

}

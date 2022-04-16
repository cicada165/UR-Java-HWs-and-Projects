/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.io.*;

public class P1 {
    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            //Read inputs
            String line = reader.readLine();
            int numV = Integer.parseInt(line.split(" ")[0]); // Number of Vertices
            int numE = Integer.parseInt(line.split(" ")[1]); // Number of Edges

            int[] V1 = new int[numE];//Array for u
            int[] V2 = new int[numE];//Array for v
            int[] weight = new int[numE];//Array for Weight

            int targetV1 = 1;//Initialize target

            line = reader.readLine();
            for (int i = 0; i < numE; i++) {
                int v1 = Integer.parseInt(line.split(" ")[0]);//Read in u
                int v2 = Integer.parseInt(line.split(" ")[1]);//Read in V
                int w = Integer.parseInt(line.split(" ")[2]);//Read in Weight
                V1[i] = v1;//Save u in V1
                V2[i] = v2;//Save v in V2
                weight[i] = w;
                if (w < 0) {
                    targetV1 = v1;
                } //Mark the target to be calculated
                line = reader.readLine();
            }
            boolean result = containNegCyc(V1, V2, weight, targetV1, numV);//Calculating result

            // write the output
    
            if (result == true) {
                System.out.println("YES");//Negative-cycle detected
            }
            else if (result == false) {         
                System.out.println("NO");//No negative-cycle detected
            }
        } catch (IOException e) {

        }
    }
    //Method for calculating result
    public static boolean containNegCyc(int[] V1, int[] V2, int[] weight,int target, int numV) {

   
        int[] dist = new int[numV+1]; 
        for (int i = 0; i < numV; i++) {
            dist[i] = Integer.MAX_VALUE;//Intitialize all values to Infinity MAX_VALUE =  2,147,483,647
        }
        dist[target] = 0;//This will be used as the beginning for the loop below

        for (int i = 0; i <= numV; i++) {
            for (int j = 0; j < V1.length; j++) {
                int u = V1[j]; //Read u from V1
                int v = V2[j]; //Read v from V2
                int w = weight[j];//Read w from weight
       ////This is going to go through the entire cycle containing the target and come back to the target
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
      //Now after the cycle is complete
      //If there is any negative cycle exist, the target should have a negative value. 
      //If it has a positive value, that means there is no negative loop exist

        if (dist[target] < 0) {
            return true;//Negative-cycle detected
        }
        else {
            return false;//No negative-cycle detected
        }
    }


}


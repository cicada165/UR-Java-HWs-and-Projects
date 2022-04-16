import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class P4 {
	@SuppressWarnings("unchecked")
    public static void main(String[] args) {

        BufferedReader reader;
        try {
        	//Read input file
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine(); 
            int cities = Integer.parseInt(line.split(" ")[0]); // # of Cities V
            int road = Integer.parseInt(line.split(" ")[1]); // # of Roads E
            int time = Integer.parseInt(line.split(" ")[2]); // Time T
            //Initiate adjacency matrix
            int[][] adjMat = new int[cities][cities]; 

            line = reader.readLine();
            while (line != null) {
                int x = Integer.parseInt(line.split(" ")[0]);
                int y = Integer.parseInt(line.split(" ")[1]);
                int w = Integer.parseInt(line.split(" ")[2]);
                adjMat[x][y] = w; adjMat[y][x] = w;
                line = reader.readLine();
            }

            // shortest distance from capital to each city
            int[] dist = Dijkstra(adjMat, 0, cities);
            Integer numOfP = 0;
            for (int i = 0; i < dist.length; i++) {
                if (dist[i] <= time)
                    numOfP ++;
            }
            System.out.println(numOfP);

            //Create output file
            File out = new File("p2_out");
            FileOutputStream fos = new FileOutputStream(out);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(numOfP.toString());
            bw.close();
        } catch (IOException e) {
        }
    }

	//Dijkstra's method
    static int[] Dijkstra(int[][] graph, int src, int n) {

        // shortest distance from source
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        boolean[] visited = new boolean[n];

        //Loop through all vertices
        for (int x = 0; x < n; x++) {

            int u = getMin(dist, visited);
            visited[u] = true;

            // "RELAX" method 
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist;
    }
    static int getMin(int[] dist, boolean[] visited) {
        int minValue = Integer.MAX_VALUE;
        int minVertex = -1;

        for (int x = 0; x < dist.length; x++) {
            if (visited[x] == false && dist[x] < minValue) {
                minVertex = x;
                minValue = dist[x];
            }
        }
        return minVertex;
    } 
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class P2 {
	 @SuppressWarnings("unchecked")
	    public static void main(String[] args) {

	        BufferedReader reader;

	        try {
	        	//Read input
	            reader = new BufferedReader(new FileReader(args[0]));
	            String line = reader.readLine(); 
	            int v = Integer.parseInt(line.split(" ")[0]); // # of Vertices
	            int e = Integer.parseInt(line.split(" ")[1]); //# of Edges

	            //Adjacency list
	            ArrayList<Integer>[] adj = new ArrayList[v+1];

	            for (int i = 0; i < v+1; i++) {
	                adj[i] = new ArrayList<>();
	            }

	            line = reader.readLine();
	            int src = Integer.parseInt(line.split(" ")[0]); // source
	            int dest = Integer.parseInt(line.split(" ")[1]); // destination

	            line = reader.readLine();
	            while (line != null) {
	            	//Add edges
	                int x = Integer.parseInt(line.split(" ")[0]);
	                int y = Integer.parseInt(line.split(" ")[1]);
	                addEdge(adj, x, y);
	                line = reader.readLine();
	            }

	            Integer numberofPath = BFS(adj, src, dest, v+1); 
	            System.out.println(numberofPath);

	            //Create output file
	            File out = new File("p2_out");
	            FileOutputStream fos = new FileOutputStream(out);
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	            bw.write(numberofPath.toString());
	            bw.close();

	        } catch (IOException e) {
	        }
	    }

    @SuppressWarnings("unchecked")
    //Using BFS
    static int BFS(ArrayList<Integer>[] adj, int src, int dest, int n) {

        // dist is the shortest distance from source
        int[] dist = new int[n];
        // # of dist from source
        int[] paths = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            paths[i] = 0;
        }

        
        //All booleans are initially set to false
        //used to check if each vertex is visited
        boolean[] visited = new boolean[n]; 

        dist[src] = 0;
        paths[src] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Integer x : adj[curr]) {

                if (visited[x] == false) {
                    q.add(x);
                    visited[x] = true;
                }

                // Search for shorter path
                if (dist[x] > dist[curr] + 1) {
                    dist[x] = dist[curr] + 1;
                    paths[x] = paths[curr];
                }
                // find additional shortest path
                else if (dist[x] == dist[curr] + 1) {
                    paths[x] += paths[curr];
                }
            }
        }
        //print output
        return paths[dest];
    }

   
    static void addEdge(ArrayList<Integer>[] adj, int x, int y) {
        adj[x].add(y);
        adj[y].add(x);
    }
}

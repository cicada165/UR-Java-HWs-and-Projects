// Java Program to check if there is a negative weight 
// cycle using Floyd Warshall Algorithm 
class array 
{ 

	// Number of vertices in the graph 
	static final int V = 20; 
	
	/* Define Infinite as a large enough value. This 
	value will be used for vertices not connected 
	to each other */
	static final int INF = 99999; 
	
	// Returns true if graph has negative weight cycle 
	// else false. 
	static boolean negCyclefloydWarshall(int graph[][]) 
	{ 
		
		/* dist[][] will be the output matrix that will 
		finally have the shortest 
		distances between every pair of vertices */
		int dist[][] = new int[V][10], i, j, k; 
	
		/* Initialize the solution matrix same as input 
		graph matrix. Or we can say the initial values 
		of shortest distances are based on shortest 
		paths considering no intermediate vertex. */
		for (i = 0; i < V; i++) 
			for (j = 0; j < 10; j++) 
				dist[i][j] = graph[i][j]; 
	
		/* Add all vertices one by one to the set of 
		intermediate vertices. 
		---> Before start of a iteration, we have shortest 
			distances between all pairs of vertices such 
			that the shortest distances consider only the 
			vertices in set {0, 1, 2, .. k-1} as intermediate 
			vertices. 
		----> After the end of a iteration, vertex no. k is 
			added to the set of intermediate vertices and 
			the set becomes {0, 1, 2, .. k} */
		for (k = 0; k < 9; k++) 
		{ 
			
			// Pick all vertices as source one by one 
			for (i = 0; i < 9; i++) 
			{ 
				
				// Pick all vertices as destination for the 
				// above picked source 
				for (j = 0; j < 9; j++) 
				{ 
					
					// If vertex k is on the shortest path from 
					// i to j, then update the value of dist[i][j] 
					if (dist[i][k] + dist[k][j] < dist[i][j]) 
							dist[i][j] = dist[i][k] + dist[k][j]; 
				} 
			} 
		} 
	
		// If distance of any verex from itself 
		// becomes negative, then there is a negative 
		// weight cycle. 
		for (i = 0; i < V; i++) 
			if (dist[i][i] < 0) 
				return true; 

		return false; 
	} 
		
	// Driver code 
	public static void main (String[] args) 
	{ 
	
	/* Let us create the following weighted graph 
				1 
		(0)----------->(1) 
		/|\			 | 
		|			 | 
	-1 |			 | -1 
		|			 \|/ 
		(3)<-----------(2) 
			-1	 */
			
		int graph[][] = { {0, 112, INF, INF,INF,INF,INF,INF,INF,INF},
						  {0, INF, INF, INF,INF,17,INF,INF,INF,INF},
						  {0, INF, INF, INF,INF,INF,INF,INF,INF,301},
						  {INF, 0, 293, INF,INF,INF,INF,INF,INF,INF},
					   	  {INF, 0, INF, INF,INF,INF,INF,INF,INF,583},
						  {INF, 242, 0, INF,INF,INF,INF,INF,INF,INF},
						  {INF, INF, 0, INF,INF,INF,INF,208,INF,INF},
						  {INF, 272, INF, 0,INF,INF,INF,INF,INF,INF},
						  {INF, INF, INF, 0,INF,-522,INF,INF,INF,INF},
						  {INF, 455, INF, INF,0,INF,INF,INF,INF,INF},
						  {INF, INF, INF, INF,0,INF,662,INF,INF,INF},
						  {568, INF, INF, INF,INF,0,INF,INF,INF,INF},
						  {INF, INF, 508, INF,INF,0,INF,INF,INF,INF},
						  {INF, INF, 564, INF,INF,INF,0,INF,INF,INF},
						  {INF, INF, INF, INF,INF,INF,0,612,INF,INF},
						  {INF, INF, INF, INF,INF,INF,0,INF,INF,793},
						  {INF, INF, 664, INF,INF,INF,INF,0,INF,INF},
						  {INF, INF, INF, INF,INF,231,INF,0,INF,INF},
						  {333, INF, INF, INF,INF,INF,INF,INF,INF,0},
						  {INF, 683, INF, INF,INF,INF,INF,INF,INF,0},}; 
		
		if (negCyclefloydWarshall(graph)) 
			System.out.print("Yes"); 
		else
			System.out.print("No"); 
	} 
} 

// This code is contributed by Anant Agarwal. 

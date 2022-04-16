/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StreetMap extends JPanel { 
	protected static Map<String, Node> map = new TreeMap<String, Node>(); // map
	protected static Map<Integer, Node> map2 = new TreeMap<Integer, Node>(); // map
	
	protected static LinkedList<Node> nodelist = new LinkedList<Node>(); // linked list
	protected static LinkedList<Edge> list = new LinkedList<Edge>(); // linked list
	protected static Graph graph; // declare graph to connect node and edge
	protected static Node parent, child; // declare predecessor subgraph to computer path
	protected static String start, dest; // declare start and end points
	
	protected static boolean showGraph, showPath, check; // decide content shown based on input
	protected static Music BGM=null;//BGM

	public static void main(String args[]) { 
		Scanner myScanner = new Scanner(System.in); 
		DecimalFormat df = new DecimalFormat("#.####"); 
		try { 
			if (args.length == 5) { // Case for --show --direction
				if ((args[1].equals("--show") && args[2].equals("--directions"))||(args[1].equals("--directions") && args[2].equals("--show"))){ 
					showPath = true; 
					showGraph = true; 
					start = args[3]; 
					dest = args[4]; 
				} 
			} else if (args[1].equals("--show")) { //Case for --show only
				showGraph = true; 
			} else if (args[1].equals("--directions")) { //case for --directions only
				showPath = true; 
				start = args[2]; 
				dest = args[3]; 
			} else { // unknown inputs
				System.out.println("Invalid input, please follow the instructions and try again."); 
			} 
			getGraphInformation(args[0]); /** get graph information**/
			if (showPath == true) { // if show path is true
				Dijkstra(start); /** find shortest distance**/
				if (map.get(dest).getDis() != Double.POSITIVE_INFINITY) { // check path
					String distance = df.format(map.get(dest).getDis()); // format distance
					System.out.println("The shortest distance is " 
							+ distance + " miles!"); 
				} else { // if the point cannot be reached
					showPath = false; // do not show the path
					System.out.println("This starting point is disconnected to the ending point."); 
				} 
			} 
			showGraph(args[0]); /** display the graph**/
		} catch (Exception e) { // If the input is not valid
			System.out.println("Invalid input, please follow the instructions and try again.");
		} 
		myScanner.close(); 
		BGM= new Music();
		BGM.play();
	} 

	// Haversine Formula:
	// CREDIT : https://www.movable-type.co.uk/scripts/latlong.html
	protected static double haversine(double lat1, double lon1, double lat2, double lon2) {
		double r = 6372.8; // get earth distance
		double dLat = Math.toRadians(lat2 - lat1); 
		double dLon = Math.toRadians(lon2 - lon1); 
		lat1 = Math.toRadians(lat1); 
		lat2 = Math.toRadians(lat2); 
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) 
				+ Math.sin(dLon / 2) * Math.sin(dLon / 2) * 
						Math.cos(lat1) * Math.cos(lat2); 
		double c = 2 * Math.asin(Math.sqrt(a)); 
		return r * c; 
	} 

	// Buffered reader to get graph information
	protected static void getGraphInformation(String document) { // method begins
		BufferedReader file; // buffered reader for better running time
		Node node; // initialize node
		String line; // initialize each line
		double lati1, lati2, long1, long2, weight; // initialize other variables
		int countNode = 0, countEdge = 0; // count number of nodes and edges

		try {
			file = new BufferedReader(new FileReader(document)); // input document
			while ((line = file.readLine()) != null) { // read all lines
				String[] array = line.split("\\s+"); // split each lines with white spaces
				if (array[0].equals("i")) { // intersection (node)
					ArrayList<Edge> l = new ArrayList<Edge>(); // declare a neighbor list
					node = new Node(array[1], // store each split String to the array
							Double.parseDouble(array[2]), // store each split String
							Double.parseDouble(array[3]), // store each split String
							countNode, null, // store each split String
							Double.POSITIVE_INFINITY, 3, l); // store each split String
					map.put(array[1], node); // map the node name with node
					map2.put(countNode, node); // label each node and map it with node
					nodelist.add(node); // add node in the node list
					countNode++; // increment the number of node
				} else { // if it is an edge
					countEdge++; // increment the number of edge
					lati1 = map.get(array[2]).getLati(); 
					long1 = map.get(array[2]).getLongti(); 
					lati2 = map.get(array[3]).getLati(); 
					long2 = map.get(array[3]).getLongti(); 
					weight = haversine(lati1, long1, lati2, long2); // Haversine
					Edge edge = new Edge(array[1], array[2], array[3], weight); // add edge
					Node r = map.get(array[2]); // call the 1st node
					Node c = map.get(array[3]); // call the 2nd node
					r.getLl().add(edge); // store the neighbor edge in its linked list
					c.getLl().add(edge);
					map.replace(array[2], r); // update
					map.replace(array[3], c); // update
					list.add(edge); // add edges to the list for drawing
				} 
			} 
		} catch (FileNotFoundException e) { // catch exceptions
			System.out.println("File does not exist."); // prompt
		} catch (IOException e) { // catch exceptions
			System.out.println(e); 
		} 
		graph = new Graph(nodelist, list, countNode, countEdge); // put info in graph
	} // method ends

	// Dijkstra Algorithm to find shortest distance
	protected static void Dijkstra(String start) { 
		int count = 0, k1, k2; 
		double distance, mini; 
		String n1, n2; // initialize variable
		Node u = map.get(start); // get the node of starting point
		map.get(start).setDis(0); // set distance of starting point to zero
		Set<Node> set = new HashSet<Node>(); // create a Set of Node as checking nodes
		set.add(u); // set the initialize Set containing ONLT the starting point
		u.setCheck(2); // set the starting point check = 2
		/** Check = 1 means the node already checked
		 * Check = 2 means the node is checking
		 * Check = 3 means the node is not yet checked*/
		while (count < graph.nodelist.size()) { 
			mini = Double.POSITIVE_INFINITY; // initialize distance to infinity
			for (Node element : set) { 
				if (element.getDis() < mini) { // if the distance is the shortest
					mini = element.getDis(); // set checking variable to shortest
					u = element; // set target element to this one
				}
			} 
			set.remove(u); // remove the target element
			for (Edge element : u.getLl()) {
				n1 = element.getN1(); // get the first node
				n2 = element.getN2(); // get the second node
				k1 = map.get(n1).getCheck(); // check the state of the first node
				k2 = map.get(n2).getCheck(); // check the state of the second node
				distance = element.getWeight(); // check the edge weight
				if (k1 == 2 && k2 == 3) { // if one is checking another unchecked
					map.get(n2).setDis(map.get(n1).getDis() + distance); // add distance
					map.get(n2).setCheck(2); // set the node to checking
					map.get(n2).setParent(map.get(n1)); // set its parent to n1
					set.add(map.get(n2)); // put it in Set
				} else if (k2 == 2 && k1 == 3) { // if one is checking another unchecked
					map.get(n1).setDis(map.get(n2).getDis() + distance); // add distance
					map.get(n1).setCheck(2); // set the node to checking
					map.get(n1).setParent(map.get(n2)); // set its parent to n2
					set.add(map.get(n1)); // put it in Set
				} else if (k2 == 2 && k1 == 2) { // if both nodes are checking
					if (n1.equals(u.getName())) { // if n1 is the target node
						if (map.get(n2).getDis() > // Dijkstra RELAX
						map.get(n1).getDis() + distance) { // RELAX
							map.get(n2).setDis( // RELAX
									map.get(n1).getDis() + distance); // RELAX
							map.get(n2).setParent(map.get(n1)); // RELAX
						} // RELAX
					} else { // if n2 is the target node
						if (map.get(n1).getDis() > //RELAX
						map.get(n2).getDis() + distance) { // RELAX
							map.get(n1).setDis( // RELAX
									map.get(n2).getDis() + distance); // RELAX
							map.get(n1).setParent(map.get(n2)); // RELAX
						} 
					} 
				} 
			} 
			u.setCheck(1); // set checking variable such that it is already checked
			count++; 
		} 
	} 

	//show graph
	protected static void showGraph(String document) { 
		JFrame frame = new JFrame(document); 
		StreetMap canvas = new StreetMap(); 
		frame.add(canvas); 
		frame.setSize(800, 800); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true); 
	} 

	//paint component
	protected void paintComponent(Graphics g) { // method begins
		final Color myRed = new Color(88,9,41);
		final Color myPink = new Color(255,156,149);
		Graphics2D g2 = (Graphics2D) g; // in order to draw to red line, get 2D graph
		g2.setColor(myRed);
		g2.fillRect(0,0,getWidth(), getHeight());
		g2.setColor(myPink);
		int width = getWidth(); 
		int height = getHeight(); 
		double lati1, long1, lati2, long2; 
		double min1 = 180, min2 = 180; 
		double max1 = -180, max2 = -180; 
		double shrink1, shrink2, shrink3, shrink4; // initialize scaling factor

		for (String key : map.keySet()) { // for all keys in map
			lati1 = map.get(key).getLati(); 
			long1 = map.get(key).getLongti(); 
			if (lati1 < min1) { 
				min1 = lati1; 
			} // find minimum latitude
			if (long1 < min2) { 
				min2 = long1; 
			} // find minimum longitude
			if (lati1 > max1) { 
				max1 = lati1; 
			} // find maximum latitude
			if (long1 > max2) {
				max2 = long1; 
			} // find maximum longitude
		} 
		
		if (showGraph == true) { // if the reader asks to show graph
			for (Edge element : list) { // for all element in lists
				lati1 = map.get(element.getN1()).getLati(); // get latitude 1
				lati2 = map.get(element.getN2()).getLati(); // get latitude 2
				long1 = map.get(element.getN1()).getLongti(); // get longitude 1
				long2 = map.get(element.getN2()).getLongti(); // get longitude 2
				shrink1 = (lati1 - min1) / (max1 - min1); // calculate scaling factor 1
				shrink2 = (lati2 - min1) / (max1 - min1); // calculate scaling factor 2
				shrink3 = (long1 - min2) / (max2 - min2); // calculate scaling factor 3
				shrink4 = (long2 - min2) / (max2 - min2); // calculate scaling factor 4
				g2.drawLine((int) (shrink3 * width), // Draw
						(int) (height - height * shrink1), 
						(int) (width * shrink4), 
						(int) (height - height * shrink2)); 
			} 
		} 

		if (showPath == true) { // if the reader asks to show graph
			ArrayList<String> arraylist = new ArrayList<String>(); // declare array list
			g2.setColor(Color.WHITE); // set color to red to draw strike in white
			g2.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND, 0, new float[]{3}, 0));//White Dash Lines
			parent = map.get(dest); // starting from end point, keep back track the line
			child = map.get(dest); // starting from end point, keep back track the line
			while (parent.getNumber() != map.get(start).getNumber()) { // if not initial
				arraylist.add(child.getName()); // add child to array list
				parent = child.getParent(); // back tracking one more node
				lati1 = child.getLati(); // get latitude of child node
				lati2 = parent.getLati(); // get latitude of parent node
				long1 = child.getLongti(); // get longitude of child node
				long2 = parent.getLongti(); // get longitude of parent node
				shrink1 = (lati1 - min1) / (max1 - min1); // calculate scaling factor
				shrink2 = (lati2 - min1) / (max1 - min1); // calculate scaling factor
				shrink3 = (long1 - min2) / (max2 - min2); // calculate scaling factor
				shrink4 = (long2 - min2) / (max2 - min2); // calculate scaling factor
				g2.draw(new Line2D.Float((int) (shrink3 * width), // strike 2D line
						(int) (height - height * shrink1), // strike 2D line
						(int) (width * shrink4), // strike 2D line
						(int) (height - height * shrink2))); // strike 2D line
				child = parent; // keep pace for both child and parent
			} 
			arraylist.add(child.getName()); // add the last
			System.out.println("PATH TAKEN:");
			int count = 0; // initialize counting variable to separate nodes in command
			for (int i = arraylist.size() - 1; i >= 0; i--) { // for all nodes in list
				System.out.print(arraylist.get(i) + " "); // reversely loop it
				count++; // every 12 nodes next line
				if (count % 12 == 0) { 
					System.out.println(); 
				} 
			} 
		} 
		BufferedImage img=null;
		try {
			img = ImageIO.read(new File("Compass.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(img, getWidth()-120, 0, 120,120, this);
	} 
	
	
} 
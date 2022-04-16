import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Map {
	ArrayList<String> mapdata = new ArrayList<String>(); 
	HashMap<String, Node> nodeSet = new HashMap<String, Node>();
	HashMap<String, Road> edges = new HashMap<String, Road>(); 
	String[] nodeArray;
	
	public Map(String mapFileName) throws FileNotFoundException {
		File mapname = new File(mapFileName); 
		Scanner  scan = new Scanner(mapname); 
		int i=0;
		while(scan.hasNextLine()) {
			String[] mapdatatemp = scan.nextLine().split("\\s+");
			if(mapdatatemp[0].equals("i")) {
				Node temp = new Node(mapdatatemp[1],Double.parseDouble(mapdatatemp[2]),Double.parseDouble(mapdatatemp[3]));
				nodeSet.put(temp.name, temp);
				System.out.println(nodeSet.get(temp.name).getName()+" "+nodeSet.get(temp.name).getLat()+" "+nodeSet.get(temp.name).getLon());
				edges.put(temp.name, new Road(temp,null));
				i++;
			}
			else if(mapdatatemp[0].equals("r")) {
				edges.put(mapdatatemp[2], new Road(nodeSet.get(mapdatatemp[3]),edges.get(mapdatatemp[2])));
				edges.put(mapdatatemp[3], new Road(nodeSet.get(mapdatatemp[2]),edges.get(mapdatatemp[3])));
				System.out.println(mapdatatemp[2]+" "+mapdatatemp[3]);
				Road temptemptemp = edges.get(mapdatatemp[2]);
				System.out.print(mapdatatemp[2]+": ");
				while(temptemptemp!=null) {
					System.out.print(temptemptemp.current.name+" ");
					temptemptemp=temptemptemp.from;
					if(temptemptemp==null) {
						System.out.println();
						break;
					}
				}
				i++;
			}
			else {
				break;
			}
		}
		Set<String> lala = nodeSet.keySet();
		this.nodeArray = new String[lala.size()];
		this.nodeArray=nodeSet.keySet().toArray(nodeArray);
	}
	
	Road findShortestRoad(Node start, Node end) {
		
		Node temp = start;
		
		PriorityQueue<Road> check = new PriorityQueue<Road>(new Comparator<Road>() {
			@Override
			public int compare(Road o1, Road o2) {
				if(o1.ttdt-o2.ttdt>0) {
					return 1; 
				}
				if(o1.ttdt-o2.ttdt<0) {
					return -1; 
				}
				return 0;
			}			
		}); 		
		ArrayList<Node> visited = new ArrayList<Node>();
		Road prior = null; 
		
		while(!temp.equals(end)) {
			if(!visited.contains(temp)) {
				visited.add(temp); 
				
			}
			if(prior!=null) {
				prior=check.poll();
			}
			else {
				prior=new Road(start, null);
			}
			
			if(edges.get(temp.name).from==null&&temp==start) {
				System.out.println("This starting node is disconncected to all the other nodes. ");
				return new Road(start,null);
			}
			Road temptemp = edges.get(temp.name);
			while(temptemp!=null) {
				if(!visited.contains(temptemp.current)) {
					check.add(new Road(temptemp.current,prior));
				}
				temptemp=temptemp.from;
			}
			
			try {
				temp=check.peek().current;	
			}
			catch(NullPointerException e) {
				if(check.size()==0) {
					System.out.println("This starting point is disconnected to the ending point.");
					System.out.println("Now returning all the nodes you can visit from this starting point. ");
					return new Road(start,prior); 
				}
			}
			
		}
		if(check.peek()!=null) {
			return check.peek();
		}
		else {
			System.out.println("You are staying at the same spot you silly.  ");
			return new Road(start,null);
		}
		
	}
	
	

}

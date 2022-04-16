import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

//import com.sun.org.apache.xpath.internal.NodeSet;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		String input=args[0];
		Map map = new Map(input);	
		
		
		JFrame frame = new JFrame(input); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		String secondcommand=args[1];
		int i=1;
		if(secondcommand.equals("--show")) {
			i++;
			try {
				secondcommand=args[i];
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
			}
			if(secondcommand.equals("--directions")) {
				String startplace = args[i+1];
				String endplace = args[i+2];
				Node start=new Node(null, -1, -1);
				Node end=new Node(null, -1,-1); 
				
				for(int j=0;j<map.nodeSet.size();j++) {
					if(startplace.equals(map.nodeArray[j])) {
						start=map.nodeSet.get(map.nodeArray[j]);
					}
					if(endplace.equals(map.nodeArray[j])) {
						end=map.nodeSet.get(map.nodeArray[j]);
					}
				}
				
				Road output = map.findShortestRoad(start, end);
				Road temp = output; 
				Road temp1 = output; 
				while(temp1.from!=null) {
					System.out.println(temp1.current.name);
					temp1=temp1.from;
				}		
				//TODO maybe cause bugs
				frame.getContentPane().add(new GUI(map.mapdata, map.nodeSet, map.edges,output));				
			}
			else {
				frame.getContentPane().add(new GUI(map.mapdata, map.nodeSet, map.edges));				
			}
		}
		else {
			i++;
			try {
				secondcommand=args[i];
			}
			catch(ArrayIndexOutOfBoundsException e) {				
			}
			if(secondcommand.equals("--directions")) {
				String startplace = args[i+1];
				String endplace = args[i+2];
				Node start=new Node(null, -1, -1);
				Node end=new Node(null, -1,-1); 
				for(int j=0;j<map.nodeSet.size();j++) {
					if(startplace.equals(map.nodeSet.get(j).name)) {
						start=map.nodeSet.get(j);
					}
					if(endplace.equals(map.nodeSet.get(j).name)) {
						end=map.nodeSet.get(j);
					}				
				}
				Road output = map.findShortestRoad(start, end);
				Road temp = output; 
				while(temp.from!=null) {
					System.out.println(temp.current.name);
				}	
				frame.getContentPane().add(new GUI(map.mapdata, map.nodeSet, map.edges,output));				
			}
		}
		frame.pack();
		frame.setSize(1200, 1080);		
		frame.setVisible(true);
		
	}

}

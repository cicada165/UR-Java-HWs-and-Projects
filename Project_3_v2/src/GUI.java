import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GUI extends JPanel{
	ArrayList<String> mapdata = new ArrayList<String>(); 
	HashMap<String, Node> nodeSet = new HashMap<String, Node>();
	HashMap<String, Road> edges = new HashMap<String, Road>(); 
	Road road; 
	final static DecimalFormat df2 = new DecimalFormat(".##");
	
	
	public GUI(ArrayList<String> mapdata, HashMap<String, Node> nodeSet, HashMap<String, Road> edges) {
		this.mapdata = mapdata;
		this.nodeSet = nodeSet;
		this.edges = edges;
	}
	
	public GUI(ArrayList<String> mapdata, HashMap<String, Node> nodeSet, HashMap<String, Road> edges , Road road) {
		this.mapdata = mapdata;
		this.nodeSet = nodeSet;
		this.edges = edges;
		this.road=road; 
	}
	
	public GUI(Road road) {
		this.road=road;  
	}


	@Override
	protected void paintComponent(Graphics g) {
		final Color KinjazRed = new Color(88,9,41);
		final Color KinjazPink = new Color(255,156,149);
		final Color Beigh = new Color(239,237,167);
		Graphics2D g2 = (Graphics2D) g; 
		super.paintComponent(g2);
		
		g2.setColor(KinjazRed);
		g2.fillRect(0,0,getWidth(), getHeight());
		

		double maxA=0; 
		double minA=90;
		double maxO=-90; 
		double minO=0; 
		Set lala = nodeSet.keySet();
		String[] nodeArray = new String[lala.size()];
		nodeArray=nodeSet.keySet().toArray(nodeArray);
		for(int i=0;i<nodeSet.size();i++) {
			if(nodeSet.get(nodeArray[i]).getLat()>maxA) maxA=nodeSet.get(nodeArray[i]).getLat();
			if(nodeSet.get(nodeArray[i]).getLat()<minA) minA=nodeSet.get(nodeArray[i]).getLat();
			if(nodeSet.get(nodeArray[i]).getLon()>maxO) maxO=nodeSet.get(nodeArray[i]).getLon();
			if(nodeSet.get(nodeArray[i]).getLon()<minO) minO=nodeSet.get(nodeArray[i]).getLon();			
		}
		double yScale = this.getHeight() / (maxO - minO);
		double xScale = this.getWidth() / (maxA - minA);
		
		if(edges!=null) {	
			g2.setColor(KinjazPink);			
			for(int i=0;i<edges.size();i++) {
				Road temp = edges.get(nodeArray[i]); 
				Node temptemp = nodeSet.get(nodeArray[i]);
				while(temp.from!=null) {
					g2.draw(new Line2D.Double((temp.current.getLat()-minA)*xScale, (temp.current.getLon()-minO)*yScale,
							(temptemp.getLat()-minA)*xScale, (temptemp.getLon()-minO)*yScale));
					temp=temp.from;
				}
			}
		}
		if(road!=null) {			
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
			Road temp = road; 
			while(temp.from!=null) {
				g2.draw(new Line2D.Double((temp.current.getLat()-minA)*xScale, (temp.current.getLon()-minO)*yScale,
						(temp.from.current.getLat()-minA)*xScale, (temp.from.current.getLon()-minO)*yScale));
				if(!temp.current.getName().startsWith("i")) {
					g2.setColor(Beigh);
					g2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
					g2.drawString(temp.current.getName(), (int)((temp.current.getLat()-minA)*xScale-10),
							(int)((temp.current.getLon()-minO)*yScale-15));
					g2.setColor(Color.WHITE);
				}
				temp=temp.from;
			}
			if(!temp.current.getName().startsWith("i")) {
				g2.setColor(Beigh);
				g2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
				g2.drawString(temp.current.getName(), (int)((temp.current.getLat()-minA)*xScale-10),
						(int)((temp.current.getLon()-minO)*yScale-15));
				g2.setColor(KinjazPink);
			}
			double distance=road.ttdt;
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Comic Sans MS",Font.BOLD,20));
			g2.drawString("Total distance: "+ df2.format(distance)+" km", 200, 20);
			System.out.println("Total distance: "+ df2.format(distance) +" km.");
			
		}
		BufferedImage img=null;
		try {
			img = ImageIO.read(new File("Compass.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g2.drawImage(img, 0, 0, 150,150, this);
	}




	public ArrayList<String> getMapdata() {
		return mapdata;
	}


	public void setMapdata(ArrayList<String> mapdata) {
		this.mapdata = mapdata;
	}

	public HashMap<String, Node> getNodeSet() {
		return nodeSet;
	}

	public void setNodeSet(HashMap<String, Node> nodeSet) {
		this.nodeSet = nodeSet;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}
	
	public HashMap<String, Road> getEdges() {
		return edges;
	}

	public void setEdges(HashMap<String, Road> edges) {
		this.edges = edges;
	}


	
}

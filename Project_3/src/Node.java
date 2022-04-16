
public class Node {
	String name; 
	double lon;
	double lat;
	
	public Node(String name, double lat, double lon) {
		this.name=name; 
		this.lon=lon; 
		this.lat=lat; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

}

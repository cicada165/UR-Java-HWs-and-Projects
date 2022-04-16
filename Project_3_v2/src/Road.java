
public class Road {
	Node current; 
	Road from; 
	double ttdt; 
	
	public Road(Node current, Road from) {
		this.current = current; 
		this.from=from; 
		if(from!=null) {
			this.ttdt=from.ttdt+distance(current.lat,current.lon,from.current.lat,from.current.lon);
		}
		else {
			this.ttdt=0;
		}
	}
	
	//Refered a website: https://www.movable-type.co.uk/scripts/latlong.html
	public double distance(double lat1, double lon1, double lat2, double lon2) {
		double R = 6371e3; // metres
		double Lat1 = Math.toRadians(lat1);
		double Lat2 = Math.toRadians(lat2);
		double dLat = Math.toRadians((lat2-lat1));
		double dLon = Math.toRadians((lon2-lon1));

		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		        Math.cos(Lat1) * Math.cos(Lat2) *
		        Math.sin(dLon/2) * Math.sin(dLon/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		double d = R * c/1000;		
        return d;
    }
	

	public Node getCurrent() {
		return current;
	}

	public void setCurrent(Node current) {
		this.current = current;
	}

	public Road getFrom() {
		return from;
	}

	public void setFrom(Road from) {
		this.from = from;
	}

	public double getTtdt() {
		return ttdt;
	}

	public void setTtdt(double ttdt) {
		this.ttdt = ttdt;
	}

}

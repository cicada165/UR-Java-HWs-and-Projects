/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.util.ArrayList;

public class Node {
	ArrayList<Edge> ll;
	Node parent;
	String name;
	double lati, longti, dis;
	int number, check;

	public Node(String n, double la, double lo, int nu, Node p, double d, int c, ArrayList<Edge> lc) {
		name = n;
		lati = la;
		longti = lo;
		number = nu;
		parent = p;
		dis = d;
		check = c;
		ll = lc;
	}

	public ArrayList<Edge> getLl() {
		return ll;
	}

	public void setLl(ArrayList<Edge> ll) {
		this.ll = ll;
	}

	public String getName() {
		return name;
	}

	public double getLati() {
		return lati;
	}

	public void setLati(int lati) {
		this.lati = lati;
	}

	public double getLongti() {
		return longti;
	}

	public void setLongti(int longti) {
		this.longti = longti;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public double getDis() {
		return dis;
	}

	public void setDis(double dis) {
		this.dis = dis;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
} // node class ends
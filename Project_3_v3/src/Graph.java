/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.util.LinkedList;

public class Graph {
	protected LinkedList<Node> nodelist;
	protected LinkedList<Edge> edgelist;
	protected int E, V;

	public Graph(LinkedList<Node> nl, LinkedList<Edge> ed, int v, int e) {
		nodelist = nl;
		edgelist = ed;
		E = e;
		V = v;
	}

	public LinkedList<Node> getNodelist() {
		return nodelist;
	}

	public void setNodelist(LinkedList<Node> nodelist) {
		this.nodelist = nodelist;
	}

	public LinkedList<Edge> getEdgelist() {
		return edgelist;
	}

	public void setEdgelist(LinkedList<Edge> edgelist) {
		this.edgelist = edgelist;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}
} // graph class ends
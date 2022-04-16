/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
public class Edge {
	protected String name, n1, n2;
	protected double weight;

	public Edge(String n, String node1, String node2, double w) {
		n1 = node1;
		n2 = node2;
		weight = w;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getN1() {
		return n1;
	}

	public void setN1(String n1) {
		this.n1 = n1;
	}

	public String getN2() {
		return n2;
	}

	public void setN2(String n2) {
		this.n2 = n2;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
} // edge class ends
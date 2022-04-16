/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
public class LinkedList<E> {
	protected class Node {
		public Object data;
		public Node next;
		//Constructor
		public Node(E data) {
			this.data = data;
			}
		}
		protected Node first = null;
		protected Node last = null;
		//Append to the tail
		public void append(E e) {
			Node newnode = new Node(e);
			if (first == null) {
				first = newnode;
				last = newnode;
			} else {
				last.next = newnode;
				last = newnode;
			}
		}
		//Append to the head
		public void prepend(E e) {
			Node newnode = new Node(e);
			if (first == null) {
				first = last = newnode;
			}
			newnode.next = first;
			first = newnode;
		}
		//toStrin method
		public String toString() {
			String result = "[";
			for (Node node=first; node != null;
					node = node.next) {
				result += node.data;
				if (node.next != null) {
					result += ",";
				}
		}
			result += "]";
			return result;
		}
		public static void main(String[] args) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.append(new Integer(3));// Exercise 8
			list.append(new Integer(2));// Exercise 8
			list.append(new Integer(1));// Exercise 8
			list.prepend(new Integer(11));// Exercise 5
			list.prepend(new Integer(22));// Exercise 5
			list.prepend(new Integer(33));// Exercise 5
			System.out.println(list.toString());
			System.out.println(list.indexOf(11)); // Exercise 6
			System.out.println(list.indexOf(22)); // Exercise 6
			System.out.println(list.indexOf(666)); // Exercise 6
			System.out.println(list.get(0)); // Exercise 7
			System.out.println(list.get(2)); // Exercise 7
			System.out.println(list.get(4)); // Exercise 7
			
		}
		//return the index of given integer
		public int indexOf(E e) {
			int count = 0;
			for (Node node = first; node != null; node = node.next) {
				if (node.data.equals(e)) {
					return count;
				} else {
					count++;
				}
			}
			return -1;
		}
		//return integer correspond to the index
		public Object get(int i) {
			int count = 0;
			for (Node node = first; node != null; node = node.next) {
				if (count == i) {
					return node.data;
				} else {
					count++;
				}
			}
			throw new IndexOutOfBoundsException();
		}
		
}

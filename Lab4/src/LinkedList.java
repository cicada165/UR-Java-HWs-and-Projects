
/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * 
 * Collaborator:
 * Name:Senqi Zhang
 * NetID: szhang71
 * Lab Section: T/R 06:15-07:30 p.mx'
 */


public class LinkedList<T> {

	public class Node {
		public T data;
		public Node next;
		public Node(T data, Node next ) {
			this.data = data;
			this.next = next;
		}
		}
		
	    int length = 0;
	    int index = 0;
	    Node first = null;
	    Node last = null;
	
	//Method to add an element in the front
	public void prepend(T e) {
		if(first == null) {
		   first = new Node(e,first);
		   last = first;
		   length++;
		}else {
		   first = new Node(e,first);
		   length++;
		}
		
         }
    
	//Method to add an element in the end 
	public void append(T e) {
		 if(first == null) {
			 prepend(e);
		 }else {
			 last.next = new Node(e,null);
			 last = last.next;
			 length++;
		     }
	     }
	
	//To return an element of a certain index
    public Object get(int i) {
    	index = 0;
    	for(Node temp = first; temp != null; temp = temp.next) {
    		
    		if(index == i) {
    			return temp.data;
    		}else {
    			index++;
    		}
    	}
    	
			return "Index out of bounds!";
    	
	}
	
	//Return an element of an index
	public int indexOf(T e) {
		index = 0;
		for(Node temp = first; temp != null; temp = temp.next) {
			if(temp.data == e) {
				return index;
			}else {
				index++;
			}
			
		}
		return -1;
	}
	
	//Return the length of the list
	public int getLength() {
		return length;
	}
	
	//Tostring
	public String toString() {
		String result = "";
		for (Node node = first; node != null; node = node.next) {
		    result += node.data;
		    }
		return result;
		}
    
}
/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
public class List<E> {

    private Object[] myList;
    private int size = 0;
   //Constructor
    public List(){
        myList = new Object[10];
    }
   //type Object
    public Object get(int index){
        if(index < size){
            return myList[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
   //Append method
    public void append(E obj){
        myList[size++] = obj;
    }
   
   
    public int size(){
        return size;
    }
    
    //toString method
    public String toString() {
        String s = "";
        s = "" + myList[0];
        for(int i = 1; i < myList.length; i++)
            if(myList[i] != null)
                s += " " + myList[i];
        return s;
    }
  
    //Add element in the head
    public void prepend(E obj) {
    	Object[] newArray = new Object[myList.length + 1];
		newArray[0] = obj;
		for (int i = 1; i < myList.length + 1; i++) {
			newArray[i] = myList[i - 1];
		}
		myList = newArray;
    }
   
    public static void main(String a[]){
        List<Integer> ArrayList = new List<Integer>();
        //Using append method
        ArrayList.append(new Integer(1));
        ArrayList.append(new Integer(2));
        ArrayList.append(new Integer(3));
        ArrayList.append(new Integer(4));
        ArrayList.prepend(new Integer(11));
        ArrayList.prepend(new Integer(22));
        ArrayList.prepend(new Integer(33));
        ArrayList.prepend(new Integer(44));
        System.out.println(ArrayList.toString());
   
        System.out.println(ArrayList.toString());
    }
}
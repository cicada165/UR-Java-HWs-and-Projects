/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public class Elements {
	//This is the class for HW5 Problem 2
	public String name;
	public int atomic_num;
	public double atomic_weight;
	
	public Elements(String a, int b, double c){
		name = a;
		atomic_num = b;
		atomic_weight = c;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public int getAtomic_num(){
		return atomic_num;
	}
	
	public void setAtomic_num(int atomic_num){
		this.atomic_num = atomic_num;
	}
	
	public double getAtomic_Weight(){
		return atomic_weight;
	}
	
	public void setAweight(double atomic_weight){
		this.atomic_weight=atomic_weight;
	}
	
	public String toString(){
		return "This element has the following properties: \nName:"+name+" , Atomic Number:"+atomic_num+" , Atomic Weight"+atomic_weight+" ";
	}
}

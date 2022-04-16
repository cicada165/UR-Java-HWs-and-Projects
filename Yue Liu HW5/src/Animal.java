/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public class Animal {
	//This is the class for HW5 Problem 3
	public String name;
	public String food;
	public String type;
	
	public Animal(String a, String b){
		name =a;
		food = b;
	}
	public String toString(){
		return ""+name+" likes to eat "+food+".";
	}
	public String Rabbits(String a,String b){
		type = a;
		name = b;
		return ""+name+" are "+type+".";
	}
	public String Parrots(String a,String b){
		type = a;
		name = b;
		return ""+name+" are "+type+".";
	}
	
	
	public String getName(){
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
	public String getFood(){
		return food;
	}
	public void setFood(String food){
		this.food = food;
	}
}

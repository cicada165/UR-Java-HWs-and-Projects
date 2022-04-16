/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */

public class Test {
	public static void main(String[]args){
		//This is the main method that tests all the classes defined in this HW5.
		//Following is for Problem 1
		Person p1 = new Person("Yue Liu", 20, 1000000000);
		p1.setAge(29);
		Person p2 = new Person("Joyce", 19, 22222222);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		//Following is for Problem 2
		Elements e1 = new Elements("Hydrogen", 1 , 1);
		Elements e2 = new Elements("Helium", 2 , 3);
		e2.setAweight(4);
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		//Following is for Problem 3
		Animal a1 = new Animal("Rabbits","carrots");
		Animal a2 = new Animal("Parrots","apple");
		
		System.out.println(a1.Rabbits("Mammal","Rabbits"));
		a2.setFood("corn");
		System.out.println(a2.Parrots("Psittaciformes","Parrots"));
	
	
		
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		//Following is for Problem 4
		Baseball b1 = new Baseball(1,2,3,1);
		Baseball b2 = new Baseball(1,3,2,1);
		b2.setRun(3);
		
		System.out.println(b1.ba(1,2));
		System.out.println(b1.rpg(3,1));
		System.out.println(b2.ba(1,3));
		System.out.println(b2.rpg(2,1));
	}
}

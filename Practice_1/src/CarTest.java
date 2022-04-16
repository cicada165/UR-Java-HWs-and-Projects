
public class CarTest {
	public static void main(String[]args){
		CarEngine e1 = new CarEngine(6,3.5);
		
		Car c1 = new Car("Camry",e1);
		Car c2 = new Car("Evora",e1);
		
		System.out.println(c1);
		System.out.println(c2);
	}
}

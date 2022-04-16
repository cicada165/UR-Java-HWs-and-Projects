
public class CarEngine {
		int cylinders;
	 double displacement;
	 
	 public CarEngine(int cylinders, double displacement){
		 this.cylinders = cylinders;
		 this.displacement = displacement;
	 }
	 public String toString(){
		 return cylinders + "CYL" + displacement + "L" ;
	 }
}


public class Point_Test {
	public static void main (String[]args){
		Point p1, p2;
		
		p1 = new Point(21,34);
	//	p1.x = 7;
	//	p1. y = 9;
		
		p2 = new Point(47,99);
	//	p2.x = 13;
	//	p2.y = 17;
		p3 = p1;
		
		if (p1 == p3){
		System.out.println(p1.toString());
		System.out.println(p1.toString1());
		
		System.out.println();
		System.out.println(p2);
		//compiler is smart enough to use toString automatically
	}

}

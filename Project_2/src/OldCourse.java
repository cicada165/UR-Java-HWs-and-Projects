//Create a subclass of Course
//with its own constructor

public class OldCourse extends Course {
	
	public OldCourse() {
		super.specifications = new int[][] {
			{376, 4}, {453, 4}, {397, 4}, {480, 4}, {568, 5}, {412, 4},
			{371, 4}, {175, 3}, {352, 4}, {386, 4}, {174, 3}, {348, 4},
			{465, 4}, {618, 5}, {455, 4}, {423, 4}, {495, 4}, {357, 4}};
		
	}
}

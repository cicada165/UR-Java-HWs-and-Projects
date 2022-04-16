//Create a subclass of Course
//with its own constructor

public class GeneseeCourse extends Course {
	
	public GeneseeCourse() {
		super.specifications = new int[][] {
			{530, 5}, {305, 4}, {331, 4}, {201, 3}, {500, 5}, {226, 3},
			{409, 4}, {410, 4}, {229, 3}, {433, 4}, {363, 4}, {174, 3},
			{545, 5}, {419, 4}, {512, 5}, {410, 4}, {320, 4}, {170, 3}};
	
	}
}

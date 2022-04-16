Project2

Collaboration:


Member1
Name: Yue Liu
NetID yliu165
TR 940-1055
TA Mustafa Ali

Member2
Name: Daiwei Zhang
NetID dzhang28
TR 940-1055
TA Rahaf Alqarni


The main method is included in TTYGolfTest.java

Extra Credit1:
We use terms ‘Birdie’ and ‘Bogey’ in method scoreThisHole in class Course.

Extra Credit2:
We allow user to abandon a round by
1. Input a zero to power or club
2. Input ABANDON instead of RETURN after each hole
We allow user to quit the game entirely by
1. Input N after each round


In this project, OldCourse and GeneseeCourse are two subclasses of the class Course
They represent two different courses and can use methods in class Course

We use an outer while loop to allow user to go through one or more rounds
Then we let user go through all 18 holes in turn in the course in a for loop

For each shot in a while loop, user can choose power and club to generate different values of distance
The information of ball will be printed after each shot
(We allow ball to go over the green (so is the hole). If the ball goes over the green
	we allow user to take another shot in opposite direction)

Once the ball reaches green (20 yards from hole), the user leaves while loop for Clubs breaks,
And then enters another while loop for Putting
Again, we allow ball to go over the hole.

Once the ball is 1 foot +- within the hole, the user leaves while loop for Putting.
The score is calculated.






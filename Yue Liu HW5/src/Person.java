

/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
	class Person{
		//This is the class for HW5 Problem 1
		public String name;
		public int age;
		public long phone_number;
		
		public Person(String a, int b, long c){
			name = a;
			age = b;
			phone_number = c;
		}
		public String toString(){
			return "Here are the informations for this person: Name:"+name+" , Age:"+age+" , Phone Number:"+phone_number+"";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public long getPhone_number() {
			return phone_number;
		}
		public void setPhone_number(long phone_number) {
			this.phone_number = phone_number;
		}

	}

	

	




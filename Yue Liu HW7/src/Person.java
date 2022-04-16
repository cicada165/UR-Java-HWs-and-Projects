
/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
	class Person{
		public String name;
		public int age;
		public long phone_number;
		//Constructor
		public Person(String a, int b, long c){
			name = a;
			age = b;
			phone_number = c;
		}
		
		public String toString(){
			return "Here are the informations for this person: Name:"+name+" , Age:"+age+" , Phone Number:"+phone_number+"";
		}
		
		public String greeting(){
			return "Sup!";
		}
		
		//getters
		public String getName() {
			return name;
		}
		public long getPhone_number() {
			return phone_number;
		}
	
		public int getAge() {
			return age;
		}
		//setters
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public void setPhone_number(long phone_number) {
			this.phone_number = phone_number;
		}

	}

	

	

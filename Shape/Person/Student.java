
public class Student extends Person {
      long id;
      String major;
      
      //Constructor
      public Student(String name, int age, long phone, long id, School sn, String major) {
    	  super(name,age,phone);
    	  this.id = id;
    	  this.major = major;
    	  }
      
      //Setters
      public void setId(long id) {
    	  this.id = id;
      }
      
      public void setMajor(String major) {
    	  this.major = major;
      }
      
      //Getters
      public long getId() {
    	  return id;
      }
      
      public String getMajor() {
    	  return major;
      }
      
      
      @Override  
      public String greeting() {
    	 if(major.equals("computer science")) {
    		 return "Greetings Earthling!";
    	 }else {
    		 return "Hey.";
    	 }
    	 
      }
}



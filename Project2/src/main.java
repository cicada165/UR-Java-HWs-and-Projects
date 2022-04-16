import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
 
public class main {
   public static void main(String[]args) {
	  
	  //Initialization 
	  Scanner scan = new Scanner(System.in);
	  int score = 0;
	  int count = 0;
	
	  Genesee g1= new Genesee(1,530,5);
	  Genesee g2 = new Genesee(2,305,4);
	  Genesee g3 = new Genesee(3,331,4);
	  Genesee g4 = new Genesee(4,201,3);
	  Genesee g5 = new Genesee(5,500,5);
	  Genesee g6 = new Genesee(6,226,3);
	  Genesee g7 = new Genesee(7,409,4);
	  Genesee g8 = new Genesee(8,410,4);
	  Genesee g9 = new Genesee(9,229,3);
	  Genesee g10 = new Genesee(10,433,4);
	  Genesee g11 = new Genesee(11,363,4);
	  Genesee g12 = new Genesee(12,174,3);
	  Genesee g13 = new Genesee(13,545,5);
	  Genesee g14 = new Genesee(14,419,4);
	  Genesee g15 = new Genesee(15,512,5);
	  Genesee g16 = new Genesee(16,410,4);
	  Genesee g17 = new Genesee(17,320,3);
	  Genesee g18 = new Genesee(18,170,3);
	  
	  ArrayList<Genesee> G = new ArrayList<Genesee>();
	  G.add(g1);
	  G.add(g2);
	  G.add(g3);
	  G.add(g4);
	  G.add(g5);
	  G.add(g6);
	  G.add(g7);
	  G.add(g8);
	  G.add(g9);
	  G.add(g10);
	  G.add(g11);
	  G.add(g12);
	  G.add(g13);
	  G.add(g14);
	  G.add(g15);
	  G.add(g16);
	  G.add(g17);
	  G.add(g18);
	  
	  Clubs c1 = new Clubs(1,230,30);
	  Clubs c2 = new Clubs(2,215,20);
	  Clubs c3 = new Clubs(3,180,20);
	  Clubs c4 = new Clubs(4,170,17);
	  Clubs c5 = new Clubs(5,155,15);
	  Clubs c6 = new Clubs(6,145,15);
	  Clubs c7 = new Clubs(7,135,15);
	  Clubs c8 = new Clubs(8,125,15);
	  Clubs c9 = new Clubs(9,110,10);
	  Clubs c10 = new Clubs(10,50,10);
	  
	  ArrayList<Clubs> C = new ArrayList<Clubs>();
	  C.add(c1);
	  C.add(c2);
	  C.add(c3);
	  C.add(c4);
	  C.add(c5);
	  C.add(c6);
	  C.add(c7);
	  C.add(c8);
	  C.add(c9);
	  C.add(c10);
	  
	  
	  Putting p10 = new Putting(10,40,5);
	  Putting p9 = new Putting(9,30,5);
	  Putting p8 = new Putting(8,25,4);
	  Putting p7 = new Putting(7,20,4);
	  Putting p6 = new Putting(6,16,3);
	  Putting p5 = new Putting(5,12,3);
	  Putting p4 = new Putting(4,8,2);
	  Putting p3 = new Putting(3,4,2);
	  Putting p2 = new Putting(2,2,1);
	  Putting p1 = new Putting(1,1,1);
	  
	  ArrayList<Putting> P = new ArrayList<Putting>();
	  P.add(p1);
	  P.add(p2);
	  P.add(p3);
	  P.add(p4);
	  P.add(p5);
	  P.add(p6);
	  P.add(p7);
	  P.add(p8);
	  P.add(p9);
	  P.add(p10);
	  
	  
	  Andrews a1 = new Andrews("Burn",1,376,4);
	  Andrews a2 = new Andrews("Dyke",2,453,4);
	  Andrews a3 = new Andrews("Cartgate (Out)",3,397,4);
	  Andrews a4 = new Andrews("Ginger Beer",4,480,4);
	  Andrews a5 = new Andrews("Hole O¡¯Cross (Out)",5,568,5);
	  Andrews a6 = new Andrews("Heathery (Out)",6,412,4);
	  Andrews a7 = new Andrews("High (Out)",7,371,4);
	  Andrews a8 = new Andrews("Short",8,175,3);
	  Andrews a9 = new Andrews("End",9,352,4);
	  Andrews a10 = new Andrews("Bobby Jones",10,386,4);
	  Andrews a11 = new Andrews("High (In)",11,174,3);
	  Andrews a12 = new Andrews("Heathery (In)",12,348,4);
	  Andrews a13 = new Andrews("Hole O¡¯Cross (In) ",13,465,4);
	  Andrews a14 = new Andrews("Long ",14,618,5);
	  Andrews a15 = new Andrews("Cartgate (In) ",15,455,4);
	  Andrews a16 = new Andrews("Corner of the Dyke ",16,423,4);
	  Andrews a17 = new Andrews("Road",17,495,4);
	  Andrews a18 = new Andrews("Tom Morris ",18,357,4);
	  
	  ArrayList<Andrews> A = new ArrayList<Andrews>();
	  A.add(a1);
	  A.add(a2);
	  A.add(a3);
	  A.add(a4);
	  A.add(a5);
	  A.add(a6); 
	  A.add(a7);
	  A.add(a8);
	  A.add(a9);
	  A.add(a10);
	  A.add(a11);
	  A.add(a12);
	  A.add(a13);
	  A.add(a14);
	  A.add(a15);
	  A.add(a16);
	  A.add(a17);
	  A.add(a18);
	  
	  
	  
	  
	 
	  
	  System.out.println("Welcome to the TTY Golf Game" + "\n"); 
	  System.out.println("Please select a course:");
	  System.out.println("1.Genesee Valley Park North Course");
	  System.out.println("2.The Old Course at St.Andrews");
	  System.out.print("Your choice [1 - 2]: ");
	  int choose = scan.nextInt();
	  
	  if(choose == 1) {
	  System.out.println("\n" + "You have chosen the Genesee Valley Park North Course" + "\n");
	  
	  //The loop that controls the full round
	  for(int progress = 0; progress < 18; progress++) {
	  
		  int temp1 = G.get(progress).getHole();
	      int temp2 = G.get(progress).getYards();
	      int temp3 = G.get(progress).getPar();
	      System.out.println("You are at the tee of hole " + temp1 +". " + temp2 + " yards" + ", " + "par " + temp3 + ".");
	 
	      double d = temp2;
	      count = 0;
	      
	      
	      //The loop that controls each hole
	      for (int progress2 = 1;;progress2++) { 
	  	  
	      if (d > 20) {
		    count++;
	        
		    System.out.print("Choose your club [1 - 10]: ");
	        int choose2 = scan.nextInt();
	        System.out.print("Power [1 - 10]: ");
	        int choose3 = scan.nextInt();
	  
	        int temp4 = C.get(choose2-1).getMean();
	        int temp5 = C.get(choose2-1).getStddev();
	        int temp6 = nextDistance(temp4,temp5,choose3);
	     
	        d = Math.abs(d - temp6);
	        System.out.println("You hit " + (int)temp6 + " yards." + "\n");	  
	        } else if (d <= 20) {
		        count++;
		        System.out.println("You are on the green");
		   
		        System.out.print("Putt Power [1 - 10]: ");
		        int choose4 = scan.nextInt();
		        int temp7 = P.get(choose4-1).getMean();
		        int temp8 = P.get(choose4-1).getStddev();
		        double temp9 = nextDistance(temp7,temp8,choose4);
		        d = Math.abs(d - temp9 / 3);
		        System.out.println("You hit " + (int)temp9 + " feet." + "\n");
		   
		        if(d*3 <= 1) {
			       System.out.println("It's in the hole!");
			       if(progress2 <= temp3) {
				   System.out.println("You made par on this hole");
			     }else {
				   System.out.println("You failed to make par on this hole");
			   }
			
			     score = score + count;   
			     System.out.println("Your score after the round is: " + score);
		   
		   
		         System.out.println("Type 'next' to continue to the next hole: ");
                 String fw = scan.next();
                 System.out.println("\n");
                 if(fw.equals("next")) {
            	     
            	     break;
                 }
             
		        }
		   
		   
		  }
	  
	  
	        if(d >= 20) {
		       System.out.println("[Shot " + (progress2 + 1)+ "]. " +  (int)d + " yards to the hole." );
	        }else if (d < 20) {
		       System.out.println("Shot " + (progress2 + 1)+ ". " +  (int)(d*3) + " feet to the hole.");
	        }
	  
	   } 
	  
	  
	 }
	     
	  
	  
	}  
	 
	 
	 if(choose == 2) {
		 System.out.println("\n" + "You have chosen the Old Course at St.Andrews " + "\n");
		 for(int progress = 0; progress < 18; progress++) {
			  
			  String temp1 = A.get(progress).getName();
		      int temp2 = A.get(progress).getYards();
		      int temp3 = A.get(progress).getPar();
		      System.out.println("You are at the tee of hole " + temp1 +". " + temp2 + " yards" + ", " + "par " + temp3 + ".");
		 
		      double d = temp2;
		      count = 0;
		      
		      //The loop that controls each hole
		      for (int progress2 = 1;;progress2++) { 
		  	  
		      if (d > 20) {
			    count++;
		        
			    System.out.print("Choose your club [1 - 10]: ");
		        int choose2 = scan.nextInt();
		        System.out.print("Power [1 - 10]: ");
		        int choose3 = scan.nextInt();
		  
		        int temp4 = C.get(choose2-1).getMean();
		        int temp5 = C.get(choose2-1).getStddev();
		        int temp6 = nextDistance(temp4,temp5,choose3);
		     
		        d = Math.abs(d - temp6);
		        System.out.println("You hit " + (int)temp6 + " yards." + "\n");	  
		        } else if (d <= 20) {
			        count++;
			        System.out.println("You are on the green");
			   
			        System.out.print("Putt Power [1 - 10]: ");
			        int choose4 = scan.nextInt();
			        int temp7 = P.get(choose4-1).getMean();
			        int temp8 = P.get(choose4-1).getStddev();
			        double temp9 = nextDistance(temp7,temp8,choose4);
			        d = Math.abs(d - temp9 / 3);
			        System.out.println("You hit " + (int)temp9 + " feet." + "\n");
			   
			        if(d*3 <= 1) {
				       System.out.println("It's in the hole!");
				       if(progress2 <= temp3) {
					   System.out.println("You made par on this hole");
				     }else {
					   System.out.println("You failed to make par on this hole");
				   }
				
				     score = score + count;   
				     System.out.println("Your score after the round is: " + score);
			   
			   
			         System.out.println("Type 'next' to continue to the next hole: ");
	                 String fw = scan.next();
	                 System.out.println("\n");
	                 if(fw.equals("next")) {
	            	     break;
	            	     
	                 }
	             
			        }
			   
			   
			  }
		  
		  
		        if(d >= 20) {
			       System.out.println("[Shot " + (progress2 + 1)+ "]. " +  (int)d + " yards to the hole." );
		        }else if (d < 20) {
			       System.out.println("Shot " + (progress2 + 1)+ ". " +  (int)(d*3) + " feet to the hole.");
		        }
		  
		   } 
		  
		  
		 }
	   }
	 
 
}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
static Random random = new Random();
   
public static int nextDistance(int mean, int stddev, int power) {
		double fmean = mean * power / 10.0;
		double fstddev = stddev * power / 10.0;
		double val = Math.abs(random.nextGaussian() * fstddev + fmean);
		return (int)val;
		}
}

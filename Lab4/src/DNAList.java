
/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * 
 * Collaborator:
 * Name:Senqi Zhang
 * NetID: szhang71
 * Lab Section: T/R 06:15-07:30 p.mx'
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DNAList<T> extends LinkedList<T>{
    //Declare Type
	enum Type{
	    	DNA, RNA, EMPTY;
	    }
	
	protected static Type type1 = Type.DNA;
	protected static Type type2 = Type.RNA;
	protected static Type type3 = Type.EMPTY;
	
	
	public static class Sequence{
		Type type;
		LinkedList list;
		
		//Constructor
		public Sequence(Type type, LinkedList list) {
			this.type = type;
			this.list = list;
		}

		public Type getType() {
			return type;
		}

		public void setType(Type type) {
			this.type = type;
		}

		public LinkedList getList() {
			return list;
		}

		public void setList(LinkedList list) {
			this.list = list;
		}
		
		
	}
	
public static void main(String[]args) throws IOException {
		Scanner scan = new Scanner(System.in);
	
		Sequence[] seq = new Sequence[20];
		//Clear, initializing
	    Sequence start = new Sequence(type3,null);
	    for(int i = 0; i < 20; i++) {
	    	seq[i] = start;
	    }
		
		String line;
		
		
		
		File command = new File("Lab4Test1.txt");
		BufferedReader br = new BufferedReader(new FileReader(command));
		while((line = br.readLine()) != null){
		      
			  String[] cl = line.split(" ");
			  
			  
			  //Method Insert
			  if(cl[0].equals("insert")) {
				  
				  //Location of the insert
				  int loc = Integer.parseInt(cl[1]);
                  
				  //Identify between DNA and RNA type
				  if(cl[2].equals("DNA")) {
					  LinkedList a = new LinkedList();
				      char[] charseq = cl[3].toCharArray();
				      
				      for(int i = 0;i < charseq.length; i++) {
				    	  if(charseq[i] != 'A' && charseq[i] != 'C' && charseq[i] != 'G' && charseq[i] != 'T') {
				    		  System.out.println("Error occurred while inserting");
				    		  seq[loc] = start;
				    		  break;
				    	      }else {
				    	         a.append(charseq[i]);
				    	         Sequence temp = new Sequence(type1, a);
				    	         seq[loc] = temp;}
				                 }
				          
				    	     
				  }else if(cl[2].equals("RNA")) {
				      LinkedList a = new LinkedList();
					  char[] charseq = cl[3].toCharArray();
					  
					  for(int i = 0;i < charseq.length; i++) {
					      if(charseq[i] != 'A' && charseq[i] != 'C' && charseq[i] != 'G' && charseq[i] != 'U') {
						      System.out.println("Error occurred while inserting");
						      seq[loc] = start;
						      break;
					          }else {
					        	 a.append(charseq[i]);
							     Sequence temp = new Sequence(type2, a);
							     seq[loc] = temp;
				                 }
					  }       
				    }  
			  }	    
			  				
		      //Method print              
			  if(cl[0].equals("print")) {
				  
				  if(cl.length >= 2) {
					  int loc = Integer.parseInt(cl[1]);
					  if(seq[loc].getList() == null) {
						  System.out.println("No sequence to print at specified position");
					  }else {
					      System.out.println(seq[loc].getType() + "\t" + seq[loc].getList());
					      }
				  }else {
				  
				     for(int i = 0; i < seq.length;i++) {
					     if(seq[i].getType() != type3) {
						     System.out.println(i + "\t" + seq[i].getType() + "\t" + seq[i].getList());
					     }
					  
				     }
				  }
			  } 
			  
			  //Method remove
			  if(cl[0].equals("remove")) {
				  
				  int loc = Integer.parseInt(cl[1]);
				  if(seq[loc].getList() == null) {
					  System.out.println("No sequence to remove at specified position");
				  }else {
				      seq[loc] = start;
				  }
			  }
			  
			  //Method clip
			  if(cl[0].equals("clip")) {
				  //Getting all the parameter
				  int loc = Integer.parseInt(cl[1]);
				  int begin = Integer.parseInt(cl[2]);
				  int end = Integer.parseInt(cl[3]);
				  String temp3 = "";
				  
				  //Create a new linkedList and set it to be the target list
				  LinkedList temp1 = new LinkedList();
				  temp1 = seq[loc].getList();
				  
				  if(seq[loc].getList() == null){
					  System.out.println("No sequence to clip at specified position");
					 
				  }else if(begin > end) {
					  LinkedList empty = new LinkedList();
					  Sequence hard = new Sequence(seq[loc].getType(), empty);
					  seq[loc] = hard;
				  }else if(begin < 0) {
					  System.out.println("Invalid start index");
				  }else if (end > temp1.getLength()) {
					  System.out.println("End index is out of bounds");
				  }else {
				       for(;begin <= end; begin++) {
					       String temp2 = temp1.get(begin).toString();
					       temp3 = temp3 + temp2;
					    
					 	  //Transform into a char array
							  char[] charseq = temp3.toCharArray();
							  LinkedList temp4 = new LinkedList();
							  
							  for(int i = 0;i < charseq.length; i++) {
								  temp4.append(charseq[i]);
							  }
							  
							  
							  Sequence temp5 = new Sequence(seq[loc].getType(),temp4);
							  seq[loc] = temp5;
				       }
				  }
			   }  
			   
			   //Method copy
			   if(cl[0].equals("copy")) {
				   int pos1 = Integer.parseInt(cl[1]);
				   int pos2 = Integer.parseInt(cl[2]);
				   
				   if(seq[pos1].getType() == type3) {
					   System.out.println("No sequence to copy at specified position");
				   }else {
					   LinkedList temp1 = new LinkedList();
					   temp1 = seq[pos1].getList();
					   Sequence hard = new Sequence(seq[pos1].getType(), temp1);
					   seq[pos2] = hard;
				   }
			   }
			   
			   //Method transcribe
			   if(cl[0].equals("transcribe")) {
				   int pos = Integer.parseInt(cl[1]);
				   String temp3 = "";
				   
				   
				   if(seq[pos].getType() == type2) {
					   System.out.println("Cannot transcribe RNA");
				   }else if(seq[pos].getType() == type3) {
					   System.out.println("No sequence to transcribe at specified position");
				   }else {
					   LinkedList temp = new LinkedList();
					   temp = seq[pos].getList();
					   for(int i = 0; i < temp.getLength(); i++) {
						   String temp2 = temp.get(i).toString();
					       temp3 = temp3 + temp2;
					   }
					   
					   char[] charseq = temp3.toCharArray();
					   int l = charseq.length;
					   
					   //Change T into U and complement
					   for(int i = 0; i < charseq.length; i++) {
						   
						   if(charseq[i] == 'T') {
							   charseq[i] = 'U';
						   }
						   
						   char[] charseq2 = charseq;
						   if(charseq2[i] == 'A') {
							   charseq[i] = 'U';
						   }else if(charseq2[i] == 'U') {
							   charseq[i] = 'A';
						   }else if(charseq2[i] == 'C') {
							   charseq[i] = 'G';
						   }else if(charseq2[i] == 'G') {
							   charseq[i] = 'C';
						   }
					}   
					   
					   
					   for(int i = 0; i < (charseq.length / 2)  ; i++ ) {
					
					       l--;
					       char sohard = charseq[i];
					       charseq[i] = charseq[l];
					       charseq[l] = sohard;
					       
					   }
					   
					   
					   LinkedList temp4 = new LinkedList();
					   for(int i = 0;i < charseq.length; i++) {
							  temp4.append(charseq[i]);
						  }
						  
					   Sequence sohard = new Sequence(type2, temp4);
					   seq[pos] = sohard;
				   }
			   }
			    
			  } 
		
	}

		
	}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Lab5 {
	public static TrieNode root;
	//size of the tree
	public static int size = 0;
	public static ArrayList<String> list = new ArrayList<String>();
	public static int inputs = 0;
	//TrideNode class
		public static class TrieNode{
			char path;
			String str;
			boolean isleaf;
			TrieNode left, right;
			
		    public TrieNode(String str) {
		    	this.str = str;
		    	left = right = null;
		    };
		    
		    public TrieNode(char path) {
		    	this.path = path;
		    	left = right = null;
		    }
		}
		
		//Constructor
		public Lab5() {
			root = null;
		}
		
		//insert() method
		public static void insert(String str) {
			
			TrieNode cur = root;
	        
			//Check empty
			if(size == 0) {
				root = new TrieNode(str);
				root.isleaf = true;
				size++;
				inputs = str.length();
			}else if(size > 0) {
				if(cur.str != null) {
					
					//Check dulpicates
					if(list.contains(str)) {
						System.out.println("Duplicate str inserted");
					//Check length
					}else if(str.length() != inputs){
						System.out.println("Invalid String: " + str);
					}else {
					
					String x = cur.str.toString();
					root.str = null;
					root.isleaf = false;
					
					for(int i = 0; i < str.length(); i++) {
						
						//If two Strings are different, create two leafs
						if(x.charAt(i) != str.charAt(i)) {
							if(x.charAt(i) == '0') {
								cur.left = new TrieNode(x);
								cur.left.isleaf = true;
								//0 go to left
								cur.right = new TrieNode(str);
								cur.right.isleaf = true;
								size++;
								break;
							}else if(x.charAt(i) == '1') {
								cur.right = new TrieNode(x);
								cur.right.isleaf = true;
								//1 go to right
								cur.left = new TrieNode(str);
								cur.left.isleaf = true;
								size++;
								break;
								}
						}else{
							if(str.charAt(i) == '0') {
								//Same String
								cur.left = new TrieNode('0');
								cur = cur.left;
							}else if(str.charAt(i) == '1') {
								cur.right = new TrieNode('1');
								cur = cur.right;
								}
						}
					}
					}
				}else if(cur.str == null) {
					//When the node is null
					//Check duplicates
					if(list.contains(str)) {
						System.out.println("Duplicate str inserted");
						//Check Length
					}else if(str.length() != inputs){
						System.out.println("Invalid String: " + str);
					}else {
					
					for(int i = 0; i < str.length(); i++) {
						
						if(str.charAt(i) == '0') {
							if(cur.left == null) {
								cur.left = new TrieNode(str);
								cur.left.isleaf = true;
								size++;
								break;}	
							
							if(cur.left.str != null) {
								//y
								String y = cur.left.str.toString();
								cur.left.str = null;
								cur.left.path = '0';
								cur.left.isleaf = false;
								cur = cur.left;
							
							for(int k = i + 1; k < str.length(); k++) {
								if(y.charAt(k) != str.charAt(k)) {
									if(y.charAt(k) == '0') {
										cur.left = new TrieNode(y);
										cur.left.isleaf = true;
										cur.right = new TrieNode(str);
										cur.right.isleaf = true;
										size++;
										break;
									}else if(y.charAt(k) == '1') {
										cur.left = new TrieNode(str);
										cur.left.isleaf = true;
										cur.right = new TrieNode(y);
										cur.right.isleaf = true;
										size++;
										break;
										}
								}else{
									if(str.charAt(k) == '0') {
										cur.left = new TrieNode('0');
										cur = cur.left;
									}else if(str.charAt(k) == '1') {
										cur.right = new TrieNode('1');
										cur = cur.right;
										}
								}
							}
								break;
							}else {
								cur = cur.left;
							}
								
						}else if(str.charAt(i) == '1') {
							
							if(cur.right == null) {
								cur.right = new TrieNode(str);
								cur.right.isleaf = true;
								size++;
								break;
							}
							
							
							if(cur.right.str != null) {
								String y = cur.right.str.toString();
								cur.right.str = null;
								cur.right.path = '1';
								cur.right.isleaf = false;
								cur = cur.right;
							
							for(int k = i + 1; k < str.length(); k++) {
								if(y.charAt(k) != str.charAt(k)) {
									if(y.charAt(i+1) == '0') {
										cur.left = new TrieNode(y);
										cur.left.isleaf = true;
										cur.right = new TrieNode(str);
										cur.right.isleaf = true;
										size++;
										break;
									}else if(y.charAt(k) == '1') {
										cur.left = new TrieNode(str);
										cur.left.isleaf = true;
										cur.right = new TrieNode(y);
										cur.right.isleaf = true;
										size++;
										break;
										}
								}else{
									if(str.charAt(k) == '0') {
										cur.left = new TrieNode('0');
										cur = cur.left;
									}else if(str.charAt(k) == '1') {
										cur.right = new TrieNode('1');
										cur = cur.right;
										}
								}
							}
							  	break;
							}else {
									cur = cur.right;
									}
							}
						}
				}
				}
			}
			list = new ArrayList<String>();
			trieToList(root);
		}	
		
		//Method size()
		public static int size() {
			return size;
		}
		
		//<ethod trieToList()
		public static ArrayList<String> trieToList(TrieNode root) {	
			if(root == null) {
				return list;
			}
			
			trieToList(root.left);
			trieToList(root.right);
			
			if(root.str != null) {
				list.add(root.str.toString());
			}
			return list;
		}
		
		//Method largest()
		public static String largest() {
			int a = list.size();
			String max = list.get(a - 1);
			return max;
		}
		
		//Method smallest()
		public static String smallest() {
			String min = list.get(0);
			return min;
		}
		
		//Method search()
		public static String search(String target) {
			
			TrieNode cur = root; 
			
			for(int i = 0; i < target.length(); i++) {
				
				if(target.charAt(i) == '0') {
					
					if(cur.left != null) {
						cur = cur.left;
						
						if(cur.str != null) {
							return cur.str.toString();
						}
					}else if(cur.left == null){
						
						//Left is the priority
						while(cur.left != null || cur.right != null) {
							if(cur.left != null) {
								cur = cur.right;
							}else {
								cur = cur.left;
							}
							break;
						}
							
					}
				}
				
				if(target.charAt(i) == '1') {
						
						if(cur.right != null) {
							cur = cur.right;
							
							if(cur.str != null) {
								return cur.str.toString();
							}
						}else if(cur.right == null){
						
						
						//Right is the priority
					    while(cur.left != null || cur.right != null) {
					    	if(cur.right != null) {
					    		cur = cur.right;
					    	}else {
					    		cur = cur.left;
					    	}
					    }
					    break;
						}			
				}
				}	
			
			return cur.str.toString();	
		
			}
		//Method to compute height()
		public static int maxHeight(TrieNode root) {
			if(root == null) {
				return 0;
			}
			else {
				int lHeight = maxHeight(root.left);
				int rHeight = maxHeight(root.right);
			
			if(lHeight > rHeight) {
				return (lHeight +1);
			}
			else {
				return (rHeight +1);
			}	
			}
		}
		//Method that actually returns height
		public static int height() {
			return maxHeight(root);
		}
	public static void main (String[]args) throws IOException {
		TrieNode trie = new TrieNode(null);
		File file = new File(args[0]);//Command Line reading file
		//File command = new File("commands");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		
			while((line = br.readLine()) != null){			      
				  String[] cl = line.split(" ");				  
				  //Method Insert
				  if(cl[0].equals("insert")) {
					  insert(cl[1]);
				  }
				  else if(cl[0].equals("print")) {
					  trieToList(trie);
					  for (String s : list) {    
						    System.out.print(s + " ");
						}  
					  System.out.println();
				  }
				  else if (cl[0].equals("height")) {
					  maxHeight(trie);
					  System.out.println(+height());
				  }
				  else if (cl[0].equals("size")) {
					  System.out.println(size());
				  }
				  else if (cl[0].equals("smallest")) {
					  System.out.println(smallest());				  }
				  else if (cl[0].equals("largest")) {
					  System.out.println(largest());
				  }
				  else if (cl[0].equals("search")) {
					  System.out.println(search(cl[1]));
				  }
		
			}
	}
}
	

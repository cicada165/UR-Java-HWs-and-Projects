/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: 
 * TA: 
 * I did not collaborate with anyone on this assignment.
 */
package edu.princeton.cs.algs4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanSubmit implements Huffman {	
	public static void main(String[] args) {
    //Testing
    Huffman huffman = new HuffmanSubmit();
    //Encode/decode for txt file
    huffman.encode("alice30.txt", "alice30.enc", "freq.txt");
	huffman.decode("alice30.enc", "alice30dec.txt", "freq.txt");
	//Encode/decode for jpg file
	huffman.encode("ur.jpg", "urenc.txt", "freq.txt");
	huffman.decode("urenc.txt", "urdec.jpg", "freq.txt");
	/* Output from commandline:
	 * >FC Alice30.txt Alice30dec.txt
     * Comparing files alice30.txt and ALICE30DEC.TXT
     * FC: no differences encountered
     * 
     * >FC ur.jpg urdec.jpg
     * Comparing files ur.jpg and URDEC.JPG
     * FC: no differences encountered 
	 */
  }
 /*
  * @param inputFile 
  * @param outputFile 
  * @param freqFile  
  */
  @Override
    public void encode(String inputFile, String outputFile, String freqFile) {
    String[] codes = new String[256];
 
    getCharCode(constructTree(writeFrequency(inputFile, freqFile)), codes, "");
    writeOutputFile(inputFile, outputFile, codes);
    //print to indicate encode is complete
    System.out.println("Huffman encoding complete!");
  }
 /*
  * @param inputFile 
  * @param outputFile 
  * @param freqFile  
  */
  @Override
    public void decode(String inputFile, String outputFile, String freqFile) {
    BinaryIn in = new BinaryIn(inputFile);
    BinaryOut out = new BinaryOut(outputFile);

    Node root = constructTree(getFrequencyFromFile(freqFile));
    Node node = root;
    while (!in.isEmpty()) {
      boolean b = in.readBoolean();
      if (node.left == null && node.right == null) {
        out.write(node.character);
        //Go back to root
        node = root;
      }
      //0 go to left
      if (!b) {
        node = node.left;
      }
      //1 go to right
      else {
        node = node.right;
      }
    }
    out.flush();
    out.close();
    //Print to indicate decode is complete
    System.out.println("Successfully decode " + inputFile + " into " + outputFile + "!");
    System.out.println("Huffman decoding complete!");
  }
  /*
   * Get the frequency of characters in the input file and write them into the frequency file
   * @param inputFile 
   * @param freqFile
   * @return an array contains frequency of each ASCII characters
   */
    private static int[] writeFrequency(String inputFile, String freqFile) {
    //Hash map for Storing character and corresponding frequency
    HashMap<Character, Integer> map = new HashMap<>(256);

    //Get characters from input file and put them into a HashMap
    BinaryIn in = new BinaryIn(inputFile);
    while (!in.isEmpty()) {
      char c = in.readChar();
      //If contains key, Integer ++
      map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
    }

    //ASCII has 256 kinds of codes
    int[] asciiFreq = new int[256];

    /*
     * Write the frequency into the freqFile
     * Record the frequency in array
     * 
     */
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(freqFile));
      for (char c : map.keySet()) {
        asciiFreq[c] = map.get(c);
        writer.write(toEightDigit(toBinary((int) c)) + ":" + map.get(c));
        writer.newLine();
      }
      writer.flush();
      writer.close();
    } catch (IOException e) {
      System.out.println(e);
    }
    //Print to indicate the frequency file is complete
    System.out.println("Successfully write frequency data into " + freqFile + "!");
    return asciiFreq;
  }
    /*
     * Change the binary representation to a eight digit form
     * @param bin the binary representation of the code
     * @return code in eight digit
     */
    private static String toEightDigit(String bin) {
      while (bin.length() < 8) {
        bin = 0 + bin;
      }
      return bin;
    }

  /*
   * Generate an array that contains frequency information from frequency file
   * @param freqFile the name of the frequency file
   * @return the array that contains frequency information
   */
    private static int[] getFrequencyFromFile(String freqFile) {
    int[] frequency = new int[256];
    try {
      BufferedReader bReader = new BufferedReader(new FileReader(freqFile));
      String currentLine;
      String[] temp;
      while ((currentLine = bReader.readLine()) != null) {
        temp = currentLine.split(":");
        //Convert to binary
        Integer decimal = Integer.parseInt(temp[0], 2);
        frequency[decimal] = Integer.parseInt(temp[1]);
      }
    } catch(IOException e) {
      System.out.println(e);
    }
    return frequency;
  }

  /*
   * Get the codes for each node in the tree
   * @param root the root of the tree
   * @param codes the String array that stores the codes for each character
   * @param path the path (essentially the code) from the root to a node
   */
  private static void getCharCode(Node root, String[] codes, String path) {
	//If no Child is present, means have reached the destination
    if (root.left == null && root.right == null) {
      codes[root.character] = path;
      return;
    }
    getCharCode(root.left, codes, path + "0");
    getCharCode(root.right, codes, path + "1");
  }

  /*
   * Write the output codes into the output file
   * @param inputFile name of the input file
   * @param outputFile name of the output file
   * @param codes the array that contains the codes for each character
   */
  private static void writeOutputFile(String inputFile, String outputFile, String[] codes) {
    BinaryIn in = new BinaryIn(inputFile);
    BinaryOut out = new BinaryOut(outputFile);
    
    while (!in.isEmpty()) {
      char c = in.readChar();
      for (int i = 0; i < codes[c].length(); i++) {
    	//Boolean
        out.write(codes[c].charAt(i) == '1');
      }
    }
    //clear upon exit
    out.flush();
    out.close();
    //Print to indicated that the outputFile is complete
    System.out.println("Successfully write output data into " + outputFile + "!");
  }

  /*
   * Change the input from decimal form to binary form
   * @param num the input number
   * @return binary form of the number
   */
  private static String toBinary(int num) {
    if (num == 0) {
      return "0";
    }
    if (num == 1) {
      return "1";
    }
    return toBinary(num / 2) + num % 2;
  }
  
  /* From the frequency array returned from getFrenquencyFromFile
   * Constuct the tree for Huffman Compression
   * @param frequency an array contains the frequencies of all the ASCII characters
   * @return the root node of the tree constructed
   */
  private Node constructTree(int[] frequency) {
    PriorityQueue<Node> pQueue = new PriorityQueue<>();

    //Create nodes for characters that show up and put them into a priority queue
    for (char c = 0; c < frequency.length; c++) {
      if (frequency[c] > 0) {
        pQueue.offer(new Node(c, frequency[c]));
      }
    }

    //Construct the tree
    while (pQueue.size() > 1) {
      
      Node child1 = pQueue.poll();
      Node child2 = pQueue.poll();
      Node parent = new Node(child1, child2, '\0', child1.frequency + child2.frequency);
      pQueue.offer(parent);
    }
    return pQueue.poll();
  }
  /*
   *  Create the node class for the nodes in the tree
   */
  private static class Node implements Comparable<Node> {

    Node left;
    Node right;
    char character;
    int frequency;
    public Node(Node left, Node right, char character, int frequency) {
      this.left = left;
      this.right = right;
      this.character = character;
      this.frequency = frequency;
    }
    public Node(char character, int frequency) {
      this.left = null;
      this.right = null;
      this.character = character;
      this.frequency = frequency;
    }
    public Node() {
      this.left = null;
      this.right = null;
      //"\n" : Ascii null
      this.character = '\0';
      this.frequency = 0;
    }
    //Allow compare by frequency
    @Override
    public int compareTo(Node o) {
      return this.frequency - o.frequency;
    }
  }
}
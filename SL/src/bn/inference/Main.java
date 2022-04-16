
/* HAOQI ZHANG
 * hzhang84
 * 30823815
 * 
 * LI SUN
 * lsun12
 * 30602632
 * 
 * XINYU HU
 * xhu18
 * 30753297
 * 
 * CSC 242 Project 3
 * We did not copy code from anyone on this assignment
 */

package bn.inference;

import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import bn.core.RandomVariable;
import bn.base.Assignment;
import bn.base.BayesianNetwork;
import bn.base.Distribution;
import bn.base.Value;
import bn.parser.BIFParser;
import bn.parser.XMLBIFParser;

public class Main { // main class begins execution of Java Application
	public static void main(String[] args) // main method begins execution of Java Application
			throws IOException, ParserConfigurationException, SAXException { // throw exception
		
		if (args[0].equals("EnumerationInferencer")) { // if user chooses exact inference
			String name = "src/bn/examples/" + args[1]; // read details
			bn.core.BayesianNetwork bn = new BayesianNetwork(); // build the network
			if (name.contains(".xml")) { // if the file ends with XML
				XMLBIFParser parser = new XMLBIFParser(); // use XML parser
				bn = parser.readNetworkFromFile(name); // use XML parser
			} else { // if the file ends with BIF
				BIFParser parser = new BIFParser(new FileInputStream(name)); // use BIF parser
				bn = parser.parseNetwork(); // use BIF parser
			} // end if conditional
			String rv = args[2]; // create the query variable
			RandomVariable X = bn.getVariableByName(rv); // create the query variable
			Assignment a = new Assignment(); // initialize new assignment
			for (int i = 3; i < args.length; i += 2) { // fill the assignment
				String varName = args[i]; // fill the assignment
				String varValue = args[i + 1]; // fill the assignment
				RandomVariable var = bn.getVariableByName(varName); // fill the assignment
				Value<String> value = new Value<String>(varValue); // fill the assignment
				a.put(var, value); // fill the assignment
			} // end iteration
			EnumerationInferencer inferencer = new EnumerationInferencer(); // initialize method 1
			double t1 = System.currentTimeMillis(); // start counting time
			// ******ENUMERATION INFERENCER******
			Distribution d = inferencer.query(X, a, bn); 
			double t2 = System.currentTimeMillis(); // end counting time
			System.out.println("Inferencer by Enumeration Algorithm Completed!"); // prompt
			System.out.println(); // prompt
			System.out.println("Elasped Time: " + (t2-t1)/1000 + " sec."); // prompt
			System.out.println(); // prompt
			System.out.println("P(" + X + "|" + a + ") = " + d); // prompt
		} // end if conditional
		
		else { // if user chooses approximate inference
			bn.core.BayesianNetwork bn = new BayesianNetwork(); // build the network
			int size = Integer.parseInt(args[1]); // convert sample size from string to integer
			String name = "src/bn/examples/" + args[2]; // read details
			if (name.contains(".xml")) { // if the file ends with XML
				XMLBIFParser parser = new XMLBIFParser(); // use XML parser
				bn = parser.readNetworkFromFile(name); // use XML parser
			} else { // if the file ends with BIF
				BIFParser parser = new BIFParser(new FileInputStream(name)); // use BIF parser
				bn = parser.parseNetwork(); // use BIF parser
			} // end if conditional
			String rv = args[3]; // create the query variable
			RandomVariable X = bn.getVariableByName(rv); // create the query variable
			Assignment a = new Assignment(); // initialize new assignment
			for (int i = 4; i < args.length; i += 2) { // fill the assignment
				String varName = args[i]; // fill the assignment
				String varValue = args[i + 1]; // fill the assignment
				RandomVariable var = bn.getVariableByName(varName); // fill the assignment
				Value<String> value = new Value<String>(varValue); // fill the assignment
				a.put(var, value); // fill the assignment
			} // end iteration
			if (args[0].equals("RejectionSampling")) { // initialize method 2
				RejectionSampling inferencer = new RejectionSampling(); // initialize method 2
				double t1 = System.currentTimeMillis(); // start counting time
				// ******REJECTION SAMPLING******
				Distribution d = inferencer.Rejection_Sampling(X, a, bn, size); 
				double t2 = System.currentTimeMillis(); // end counting time
				System.out.println("Rejection Sampling Algorithm Completed!"); // prompt
				System.out.println(); // prompt
				System.out.println("Elasped Time: " + (t2-t1)/1000 + " sec."); // prompt
				System.out.println(); // prompt
				System.out.println("P(" + X + "|" + a + ") = " + d);	// prompt
			} else if (args[0].equals("LikelihoodWeighting")) { // initialize method 3
				LikelihoodWeighting inferencer = new LikelihoodWeighting(); // initialize method 3
				double t1 = System.currentTimeMillis(); // start counting time
				// ******LIKELIHOOD WEIGHTING******
				Distribution d = inferencer.Likelihood_Weighting(X, a, bn, size);
				double t2 = System.currentTimeMillis(); // end counting time
				System.out.println("Likelihood Weighting Algorithm Completed!"); // prompt
				System.out.println(); // prompt
				System.out.println("Elasped Time: " + (t2-t1)/1000 + " sec."); // prompt
				System.out.println(); // prompt
				System.out.println("P(" + X + "|" + a + ") = " + d); // prompt
			} else if (args[0].equals("GibbsSampling")) { // initialize method 4
				GibbsSampling inferencer=new GibbsSampling(); // initialize method 4
				double t1 = System.currentTimeMillis(); // start counting time
				// ******GIBBS SAMPLING******
				Distribution d=inferencer.Gibbs_Sampling(X, a, bn, size);
				double t2 = System.currentTimeMillis(); // start counting time
				System.out.println("Gibbs Sampling Algorithm Completed!"); // prompt
				System.out.println(); // prompt
				System.out.println("Elasped Time: " + (t2-t1)/1000 + " sec."); // prompt
				System.out.println(); // prompt
				System.out.println("P(" + X + "|" + a + ") = " + d); // prompt
			} else { // if the reader input stuff randomly
				System.out.println("Illegal Input"); // prompt
			} // end if conditional
		} // end enumeration inference
	} // end method main
} // end Project 3
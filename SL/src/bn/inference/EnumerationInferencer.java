
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
 * We did not copy code from anyone on this project.
 */

package bn.inference;

import java.util.ArrayList;
import java.util.List;
import bn.base.Distribution;
import bn.core.Assignment;
import bn.core.BayesianNetwork;
import bn.core.Inferencer;
import bn.core.RandomVariable;
import bn.core.Value;

public class EnumerationInferencer implements Inferencer {

	@Override
	public Distribution query // this method means to solve exact inference problem
	(RandomVariable X, Assignment e, BayesianNetwork bn) { // for X given e
		Distribution d = new Distribution(X); // generate a vector representation of new distribution
		for (Value Xi : X.getDomain()) { // try every variable's value
			Assignment eCopy = e.copy(); // duplicate the assignment
			eCopy.put(X, Xi); // change the value of the query variable
			// use the formula to calculate the probability of X given e
			double probability = EnumerationAll(bn.getVariablesSortedTopologically(), eCopy, bn);
			d.put(Xi, probability); // put this probability into the distribution table
		} // end iteration
		d.normalize(); // normalize the distribution vector
		return d; // return the distribution vector
	} // end method enumeration inferencer

	public double EnumerationAll // this method is the helper function of exact inference problem
	(List<RandomVariable> vars, Assignment e, BayesianNetwork bn) { // for X given e
		if (vars.isEmpty()) { // if the network is empty
			return 1.0; // return default value
		} // end if conditional
		List<RandomVariable> varsCopy = new ArrayList<>(); // copy all the variables
		for (RandomVariable rv : vars) { // to avoid direct modification
			varsCopy.add(rv); // of a non-static variable
		} // end iteration
		RandomVariable Y = varsCopy.remove(0); // since array list is ordered, check variable one by one

		if (e.containsKey(Y)) { // if the variable is not hidden
			// recursively find product
			return bn.getProbability(Y, e) * EnumerationAll(varsCopy, e, bn); 
		} else { // if the variable is hidden
			double marginalization = 0.0; // sum all possible values for the variable
			for (Value var : Y.getDomain()) { // for every domain of a given value
				Assignment eCopy = e.copy(); // duplicate the assignment
				eCopy.put(Y, var); // sum all possible values for the variable 
				// recursively find product
				marginalization += bn.getProbability(Y, eCopy) * EnumerationAll(varsCopy, eCopy, bn);
			} // end iteration
			return marginalization; // return the product of every conditional probability
		} // end if conditional
	} // end methods for the helper function
} // end method enumeration inferencer

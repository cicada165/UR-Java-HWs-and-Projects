
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

import java.util.Random;
import bn.base.Distribution;
import bn.core.Assignment;
import bn.core.BayesianNetwork;
import bn.core.Inferencer;
import bn.core.RandomVariable;
import bn.core.Value;

public class RejectionSampling implements Inferencer { // Rejection Sampling class begins
	public Distribution Rejection_Sampling // Rejection Sampling method begins
	(RandomVariable X, Assignment e, BayesianNetwork bn, int N) { // input parameters

		int count = 0; // initialize the number of non-rejected sample as 0
		boolean pass = false; // check if all samples are rejected
		boolean consistent = false; // check if the given sample is consistent
		Distribution d = new Distribution(X); // initialize new distribution to put sample in
		for (Value Xi : X.getDomain()) { // initialize new distribution to put sample in
			d.put(Xi, 0.0); // initialize new distribution to put sample in
		} // end iteration

		for (int j = 1; j <= N; j++) { // for all samples
			Assignment a = PriorSample(bn, e); // randomly assign a series of values
			consistent = true; // start checking by assuming the sample is consistent
			for (RandomVariable rv : e.variableSet()) { // for each random variable
				if (!(e.get(rv).equals(a.get(rv)))) { // if value of evidence variable
					consistent = false; // does not match the randomly generated value
					break; // the sample is then rejected
				} // end if conditional
			} // end iteration
			if (consistent == true) { // if the sample is consistent
				count++; // increment the number of consistent samples
				double value = d.get(a.get(X)) + 1; // add this sample to the distribution
				d.put(a.get(X), value); // add this sample to the distribution
				pass = true; // admit that not all samples are rejected
			} // end if conditional
		} // end sample enumeration loop

		if (pass == false) { // if all samples are rejected
			System.out.println("All samples are rejected!"); // prompt
			System.out.println("Rejection Sampling Failed!"); // prompt
			return null; // does not return anything
		} // end if conditional
		for (Value Xi : X.getDomain()) { // this for loop is used to order the distribution
			double value = d.get(Xi); // this for loop is used to order the distribution
			d.put(Xi, value); // this for loop is used to order the distribution
		} // end iteration
		System.out.println("Consistent Trials are " + count + " out of " + N + "!"); // prompt
		System.out.println(); // prompt a new line
		d.normalize(); // normalize the distribution after sampling
		return d; // return the distribution after sampling
	} // end method Rejection Sampling

	public Assignment PriorSample // this method randomly gives each random variable a value
	(BayesianNetwork bn, Assignment e) { // based on the distribution in the network
		Random myRandom = new Random(); // create a method to enable randomization
		Assignment a = e.copy(); // generate a new assignment to randomly generate values
		double randomNumber = 0.0; // initialize the random number waiting to be generated
		double lowerBound = 0.0; // initialize lower bound
		double upperBound = 0.0; // initialize upper bound
		
		for (RandomVariable X : bn.getVariablesSortedTopologically()) { // for each variable
			randomNumber = myRandom.nextDouble(); // randomly select a number between 0-1
			lowerBound = 0.0; upperBound = 0.0; // set bounds back to original
			for (Value value : X.getDomain()) { // for each value in the query variable
				a.put(X, value); // try to match a value with this random variable
				Double var = bn.getProbability(X, a); // get the probability of this value
				upperBound = var + lowerBound; // specify the probability of getting this value
				if (lowerBound <= randomNumber && randomNumber < upperBound) { // set range
					break; // then the range accurate match the probability
				} // if the value is actually in the range, then it is selected and loop breaks
				lowerBound += var; // otherwise, it moves to the next range and selection continued
			} // end iteration for value
		} // end iteration for random variable
		return a; // return the final assignment randomly selected based on probability
	} // end method Prior Sample

	@Override
	public Distribution query // this dummy method is used to support implementation
	(RandomVariable X, bn.core.Assignment e, BayesianNetwork bn) { // it has no other use
		return null; // it keeps the integrity of the project
	} // end dummy method
} // end class Rejection Sampling

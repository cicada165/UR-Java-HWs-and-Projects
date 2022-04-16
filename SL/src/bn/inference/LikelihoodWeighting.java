
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
import bn.base.Assignment;
import bn.base.Distribution;
import bn.core.BayesianNetwork;
import bn.core.Inferencer;
import bn.core.RandomVariable;
import bn.core.Value;

public class LikelihoodWeighting implements Inferencer { // Likelihood Weighting class begins
	double weight = 1.0; // set weight globally

	public Distribution Likelihood_Weighting // Likelihood Weighting method begins
	(RandomVariable X, Assignment e, BayesianNetwork bn, int N) { // input methods
		Distribution d = new Distribution(X); // initialize new distribution to put sample in
		Assignment a = new Assignment(); // initialize new assignment to be empty
		for (Value Xi : X.getDomain()) { // initialize new assignment to be empty
			d.put(Xi, 0.0); // initialize new assignment to be empty
		} // initialize new assignment to be empty
		for (int j = 1; j <= N; j++) {
			weight = 1.0; // *THIS METHOD ACCEPTS EVIDENCE VARIABLE TO BE TRUE*
			a = WeightedSample(e, bn); // *THEN MULTIPLY BY THE WEIGHT*
			double value = d.get(a.get(X)) + weight; // *THEN INCREMENT THE WEIGHT*
			d.put(a.get(X), value); // add this sample to the distribution
		} // end iteration
		for (Value Xi : X.getDomain()) { // this for loop is used to order the distribution
			double value = d.get(Xi); // this for loop is used to order the distribution
			d.put(Xi, value); // this for loop is used to order the distribution
		} // end iteration
		d.normalize(); // normalize the distribution after sampling
		return d; // return the distribution after sampling
	} // end method Likelihood Weighting

	// THIS METHOD IS SIMILAR TO THE PRIOR SAMPLE METHOD
	public Assignment WeightedSample(Assignment e, BayesianNetwork bn) {
		Random myRandom = new Random();
		Assignment a = new Assignment();
		double randomNumber = 0.0;
		double lowerBound = 0.0;
		double upperBound = 0.0;

		for (RandomVariable X : bn.getVariablesSortedTopologically()) {
			if (e.containsKey(X)) {
				a.put(X, e.get(X));
				weight = weight * (bn.getProbability(X, a));
				
			} else {
				randomNumber = myRandom.nextDouble();
				lowerBound = 0.0;
				upperBound = 0.0;
				for (Value value : X.getDomain()) {
					a.put(X, value);
					Double var = bn.getProbability(X, a);
					upperBound = var + lowerBound;
					if (lowerBound <= randomNumber && randomNumber < upperBound) {
						break;
					}
					lowerBound += var;
				}
			}
		}
		return a;
	} // end weighted sample method

	@Override
	public Distribution query // this dummy method is used to support implementation
	(RandomVariable X, bn.core.Assignment e, BayesianNetwork bn) { // it has no other use
		return null; // it keeps the integrity of the project
	} // end dummy method
} // end class Likelihood Weighting

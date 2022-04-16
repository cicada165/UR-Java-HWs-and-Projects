
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

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import bn.core.Assignment;
import bn.core.BayesianNetwork;
import bn.base.Distribution;
import bn.core.Inferencer;
import bn.core.RandomVariable;
import bn.core.Value;

public class GibbsSampling implements Inferencer { // class begins Gibbs-Sampling
	public Distribution Gibbs_Sampling // method begins Gibbs-Sampling
	(RandomVariable X, Assignment e, BayesianNetwork bn, int N) {
		int selectedValue = 0, determination = 0;
		Random myRandom = new Random();
		Assignment a = e.copy();
		Distribution d = new Distribution(X);
		for (Value Xi : X.getDomain()) {
			d.put(Xi, 0.0);
		}
		for (RandomVariable rv : bn.getVariablesSortedTopologically()) {
			if (e.get(rv) == null) {
				// Select a number randomly from 0 to # of Values in Domain - 1
				selectedValue = myRandom.nextInt(rv.getDomain().size());
				determination = 0;
				for (Value value : rv.getDomain()) { // loop through the ordered domain
					// If the place of the value match the number
					if (determination == selectedValue) { 
						a.put(rv, value); // match this value with the designated random variable
						break;
					}
					determination++;
				}
			}
		} // end randomly generating the initial state

		for (int j = 1; j <= N; j++) {
			for (RandomVariable rv : bn.getVariablesSortedTopologically()) {
				if (e.get(rv) == null) {
					Value v = MarkovBlanket(bn, rv, a); // ***Select a Variable, Assign a Value***
					a.put(rv, v);
					double value = d.get(a.get(X)) + 1.0;
					d.put(a.get(X), value);
				}
			}
		} // end sampling

		for (Value Xi : X.getDomain()) { // this for loop is used to order the distribution
			double value = d.get(Xi); // this for loop is used to order the distribution
			d.put(Xi, value); // this for loop is used to order the distribution
		} // end iteration
		
		d.normalize();
		return d;
	} // end method Gibbs-Sampling

	public Value MarkovBlanket // this method is the helper function of Gibbs-Sampling
	(BayesianNetwork bn, RandomVariable rv, Assignment a) {
		Set<RandomVariable> markovBlanket = new HashSet<>(); // Markov Blanket
		for (RandomVariable children : bn.getChildren(rv)) {
			markovBlanket.add(children); // Markov Blanket: (1) ADD CHILDREN
			for (RandomVariable childrenParent : bn.getParents(children)) {
				markovBlanket.add(childrenParent); 
			} // Markov Blanket: (2) ADD CHILDREN'S PARENT
		}
		for (RandomVariable parents : bn.getParents(rv)) {
			markovBlanket.add(parents); // Markov Blanket: (3) ADD PARENT
		}
		markovBlanket.remove(rv); // Markov Blanket: (4) REMOVE ITSELF
		Assignment b = a.copy();
		for (RandomVariable variable : a.keySet()) {
			if (!(markovBlanket.contains(variable))) {
				b.remove(variable); // Markov Blanket: (5) CONNECT VARIABLE WITH VALUE
			}
		}
		EnumerationInferencer inferencer = new EnumerationInferencer();
		Random myRandom = new Random();
		double randomNumber = 0.0;
		double lowerBound = 0.0;
		double upperBound = 0.0;
		
		randomNumber = myRandom.nextDouble();
		lowerBound = 0.0;
		// *** Call Back the Enumeration Inferencer to Calculate the Distribution ***
		Distribution K = inferencer.query(rv, b, bn);
	
		for (Value value : rv.getDomain()) {
			Double var = K.get(value);
			upperBound = var + lowerBound;
			if (lowerBound <= randomNumber && randomNumber < upperBound) {
				return value;
			}
			lowerBound += var;
		}
		return null;
	} // end the helper function of Markov Blanket

	@Override
	public Distribution query(RandomVariable X, Assignment e, BayesianNetwork bn) {
		return null;
	}
} // end class Gibbs-Sampling
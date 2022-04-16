
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
 * Copyright of this file belongs to @GeorgeFerguson
 */

package bn.core;

/**
 * An Inferencer for Bayesian networks computes the posterior (conditional)
 * distribution of a query variable given evidence (values for all, some, or
 * none of the variables in the network).
 *
 */
public interface Inferencer {

	/**
	 * Compute and return the Distribution of RandomVariable X given evidence e
	 * using the distribution encoded by the given BayesianNetwork.
	 */
	public Distribution query(RandomVariable X, Assignment e, BayesianNetwork bn);

}

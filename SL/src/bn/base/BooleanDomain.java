
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

package bn.base;

/**
 * A BooleanDomain is a Domain containing the two BooleanValues TRUE and FALSE.
 */
public class BooleanDomain extends Domain {

	public BooleanDomain() {
		super(2);
		this.add(BooleanValue.TRUE);
		this.add(BooleanValue.FALSE);
	}
}
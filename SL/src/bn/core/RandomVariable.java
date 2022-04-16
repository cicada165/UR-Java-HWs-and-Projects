
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
 * A RandomVariable can be assigned a Value from its Domain. Note that
 * RandomVariables may be used as keys in a hashtable, so they should have
 * appropriate hashCode() methods.
 */
public interface RandomVariable {

	public Domain getDomain();

}

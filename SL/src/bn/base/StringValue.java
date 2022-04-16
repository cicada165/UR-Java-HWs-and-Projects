
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
 * A StringValue is a String that can be used as a Value.
 */
public class StringValue extends Value<String> {

	/**
	 * Construct and return a new StringValue using the given String.
	 */
	public StringValue(String s) {
		super(s);
	}

	/**
	 * Return the String value of this StringValue, if you follow me.
	 */
	public String stringValue() {
		return this.value;
	}

	/**
	 * Test StringValues.
	 */
	public static void main(String[] argv) {
		StringValue red = new StringValue("red");
		System.out.println(red);
	}
}
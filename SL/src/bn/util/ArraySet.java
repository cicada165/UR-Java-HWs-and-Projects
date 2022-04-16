
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

package bn.util;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * A Set implementation backed by an ArrayList. This is good for small, more or
 * less immutable sets, but isn't part of standard Java.
 */
public class ArraySet<E> extends AbstractSet<E> {

	protected ArrayList<E> elements;

	/**
	 * Construct and return a new ArraySet with initial size 0.
	 */
	public ArraySet() {
		this(0);
	}

	/**
	 * Construct and return a new ArraySet with the given initial capacity.
	 */
	public ArraySet(int initialCapacity) {
		super();
		elements = new ArrayList<E>(initialCapacity);
	}

	/**
	 * Construct and return a new ArraySet containing the elements of the given
	 * collection and with capacity as needed to whole them all. Per the contract of
	 * the Set interface in the Collections Framework, duplicate elements (according
	 * to equals()) are not added multiple times.
	 */
	public ArraySet(Collection<? extends E> c) {
		this(c.size());
		for (E e : c) {
			add(e);
		}
	}

	/**
	 * Returns an iterator over the elements in this ArraySet. Required by
	 * subclasses of AbstractSet.
	 */
	@Override
	public Iterator<E> iterator() {
		return elements.iterator();
	}

	/**
	 * Returns the number of elements in this ArraySet (its cardinality). Hopefully
	 * this is faster than letting AbstractSet compute it using the iterator.
	 */
	@Override
	public int size() {
		return elements.size();
	}

	/**
	 * Adds the specified element to this ArraySet if it is not already present.
	 * Returns true if the element was added, else false. Required by AbstractSet
	 * for a mutable set. It could perhaps be implemented more efficiently...
	 */
	@Override
	public boolean add(E e) {
		if (contains(e)) {
			return false;
		} else {
			return elements.add(e);
		}
	}

}

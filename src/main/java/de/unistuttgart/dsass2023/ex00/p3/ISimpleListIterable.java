package de.unistuttgart.dsass2023.ex00.p3;

import java.util.Iterator;

/**
 * An iterator over a collection
 * 
 * @param <T> The type of elements returned by this iterator
 */
public interface ISimpleListIterable<T extends Comparable<T>> extends ISimpleList<T> {
	
	/**
	* Returns an iterator that enumerates every
	* element in the collection, starting with the
	* first element.
	*
	* @return the iterator.
	*/
	public Iterator<T> iterator();
	
	/**
	* Returns an iterator that enumerates every n-th
	* element in the collection, starting with the
	* first element.
	*
	* @return the iterator.
	* @throws IllegalArgumentException if numberSkippedElements is less than 1.
	*/
	public Iterator<T> skippingIterator(int numberSkippedElements);
}

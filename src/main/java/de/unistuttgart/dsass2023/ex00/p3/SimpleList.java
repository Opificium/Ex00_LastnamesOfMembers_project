package de.unistuttgart.dsass2023.ex00.p3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleList<T extends Comparable<T>> implements ISimpleListIterable<T> {

	/** Do not modify the existing methods and signatures */
	private final List<T> list;

	/**
	 * Implementation of the Simple Iterator
	 */
	private final SimpleListIterator simpleListIterator;

	/**
	 * Implementation of the skipping Iterator
	 */
	private final SimpleListSkippingIterator simpleListSkippingIterator;

	public SimpleList() {
		list = new ArrayList<T>();
		this.simpleListIterator = new SimpleListIterator(list);
		this.simpleListSkippingIterator = new SimpleListSkippingIterator(list);
	}

	@Override
	public void append(T element) {
		list.add(element);
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public T getElement(int index) {
		return list.get(index);
	}

	/**
	 * The default Iterator that returns every element of the list, starting with the first.
	 * @return the default iterator
	 */
	@Override
	public Iterator<T> iterator() {
		return simpleListIterator;
	}

	/**
	 * The skipping Iterator that returns every n-th element of the list, starting with the first, then skipping along
	 * @param numberSkippedElements the number of skipped elements+1.
	 * @return the skipping Iterator
	 */
	@Override
	public Iterator<T> skippingIterator(int numberSkippedElements) {
		return simpleListSkippingIterator;
	}
}

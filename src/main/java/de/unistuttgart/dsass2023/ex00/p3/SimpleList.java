package de.unistuttgart.dsass2023.ex00.p3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleList<T extends Comparable<T>> implements ISimpleListIterable<T> {

	/** Do not modify the existing methods and signatures */
	private final List<T> list;
	private final SimpleListIterator simpleListIt;

	public SimpleList() {
		list = new ArrayList<T>();
		simpleListIt = new SimpleListIterator();
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

	@Override
	public Iterator<T> iterator() {
		return simpleListIt;
	}

	@Override
	public Iterator<T> skippingIterator(int numberSkippedElements) {
		return null;
	}
}

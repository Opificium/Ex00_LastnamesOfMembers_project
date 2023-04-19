package de.unistuttgart.dsass2023.ex00.p3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SimpleListIterator implements Iterator {

    /**
     * The List the Iterator is applied upon
     */
    private final List iteratedList;

    /**
     * The index of the element currently processed by the Iterator
     */
    public int currentElementIndex = -1;

    /**
     * The Constructor of the {@link SimpleListIterator class, providing the parameter of the list to be iterated upon}
     * @param iteratedList The list to be operated on
     */
    public SimpleListIterator(final List iteratedList) {
        this.iteratedList = iteratedList;
    }

    /**
     * Checks whether the Iterator has a following element to process
     * @return if iterator has another element after current one to process
     */
    @Override
    public boolean hasNext() {
        return iteratedList.size() >= currentElementIndex;
    }

    /**
     * The Iterator processes all elements of the list and returns them, while counting them to ensure hasNext method is working properly
     * @return elements of list
     */
    @Override
    public Object next() {
        currentElementIndex++;
        for (Object o : iteratedList) {
            if (o.equals(iteratedList.get(currentElementIndex)))
                return o;
        }

        return Optional.empty();
    }

    /**
     * This method removes the currently processed element of the iterator from the list
     * Method is currently not supported, therefore throws an exception
     * @throws UnsupportedOperationException when method is tried to use
     */
    @Override
    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Cannot remove Element with Iterator, this method is not supported.");
    }
}

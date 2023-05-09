package de.unistuttgart.dsass2023.ex00.p3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SimpleListSkippingIterator implements Iterator {

    /**
     * The List the Iterator is applied upon
     */
    private final List iteratedList;

    /**
     * The index of the element currently processed by the Iterator
     */
    private int currentElementIndex = -1;
    private final int numberSkippedElements;

    /**
     * The Constructor of the {@link SimpleListIterator class, providing the parameter of the list to be iterated upon}
     * @param iteratedList The list to be operated on
     * @param numberSkippedElements The elements one wants to skip while iterating on the list
     */
    public SimpleListSkippingIterator(final List iteratedList, final int numberSkippedElements) {
        this.iteratedList = iteratedList;
        this.numberSkippedElements = numberSkippedElements;
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
     * @throws NoSuchElementException when there are no more elements on the list to be iterated
     */
    @Override
    public Object next() throws NoSuchElementException{
        currentElementIndex++;
        for (Object o : iteratedList) {
            if (o.equals(iteratedList.get(currentElementIndex)))
                return o;
        }

        throw new NoSuchElementException("There are no more elements to be iterated!");
    }

    /**
     * The Iterator only returns the n-th element of the provided list, starting with the first, n to be specified in {@param numberSkippedElements}.
     * if {@param numberOfSkippedElements = 0}, function will behave like next()( method
     * The Iterator counts all the elements of the list  to ensure hasNext method is working properly
     * @return all elements of the list not to be skipped
     * @throws IllegalArgumentException when elements to be skipped are less than 0
     * @throws NoSuchElementException when there are no more elements on the list to be iterated
     */

    public Object skipToNext() throws IllegalArgumentException, NoSuchElementException{
        if (numberSkippedElements < 0)
            throw new IllegalArgumentException("The Elements to be skipped cannot be less than 0!");

        if (numberSkippedElements == 0)
            return next();


        currentElementIndex += numberSkippedElements;

        for (Object o : iteratedList)
            if (currentElementIndex % numberSkippedElements == 1)
                return o;

        throw new NoSuchElementException("There are no more elements to be iterated!");
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

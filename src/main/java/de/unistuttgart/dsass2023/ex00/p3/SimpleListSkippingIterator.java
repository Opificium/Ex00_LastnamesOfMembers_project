package de.unistuttgart.dsass2023.ex00.p3;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class SimpleListSkippingIterator implements Iterator {

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
    public SimpleListSkippingIterator(final List iteratedList) {
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
     * The Iterator only returns the n-th element of the provided list, starting with the first, n to be specified in {@param numberSkippedElements}.
     * if {@param numberOfSkippedElements = 0}, function will behave like next()( method
     * The Iterator counts all the elements of the list  to ensure hasNext method is working properly
     * @param numberSkippedElements The number of elements one wants to skip in a go, so for example if provided with {@param numberSkippedElements = 3} the iterator will only return every 3rd element
     * @return all elements of the list not to be skipped
     * @throws IllegalArgumentException when elements to be skipped are less than 0
     */
    public Object skipToNext(final int numberSkippedElements) throws IllegalArgumentException{
        if (numberSkippedElements < 0)
            throw new IllegalArgumentException("The Elements to be skipped cannot be less than 0!");

        if (numberSkippedElements == 0)
            return next();

        currentElementIndex =+ currentElementIndex + numberSkippedElements + 1;
        //TODO see if implementation of skip feature works, momentarily doubted
        for (Object o : iteratedList){
            if (currentElementIndex % numberSkippedElements == 0)
                return o;
        }
        return Optional.empty();
    }
}

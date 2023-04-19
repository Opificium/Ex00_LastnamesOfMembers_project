package de.unistuttgart.dsass2023.ex00.p3;

import java.util.Iterator;

public class SimpleListIterator implements Iterator {


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}

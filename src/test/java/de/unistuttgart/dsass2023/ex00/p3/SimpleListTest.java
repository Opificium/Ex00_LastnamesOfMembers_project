package de.unistuttgart.dsass2023.ex00.p3;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import de.unistuttgart.dsass2023.ex00.p3.ISimpleListIterable;
import de.unistuttgart.dsass2023.ex00.p3.SimpleList;

public class SimpleListTest {
    private SimpleList list;
    private Object[] compareListToIterator;

    @Before
    public void setUp() throws Exception {
        list = new SimpleList();
        list.append("A");
        list.append("B");
        list.append("C");
        list.append("D");
        list.append("E");
        compareListToIterator = new Object[]{"A", "B", "C", "D", "E"};
    }

    @Test
    public void testDefaultIteratorhasNext(){
        assertEquals("Iterator hasNext() before Iterator next()", true, list.iterator().hasNext());
    }
    @Test
    public void testDefaultIteratorNext() {
        Object[] iteratorArray = new Object[5];
        for (int i = 0; i < list.getSize(); i++){
            iteratorArray[i] = list.iterator().next();
        }
        assertArrayEquals("Check first use of Iterator next()", compareListToIterator, iteratorArray);
    }
    @Test
    public void testDefaultIteratorException() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            list.iterator().remove();
        });
    }

    @Test
    public void testSkippingIteratorHasNext(){
        assertTrue("Iterator hasNext() before Iterator next()", list.skippingIterator(2).hasNext());
    }

    @Test
    public void testSkippingIteratorNext(){
        Object[] iteratorArray = new Object[5];
        for (int i = 0; i < list.getSize(); i++){
            iteratorArray[i] = list.skippingIterator(2).next();
        }
        assertArrayEquals("Check first use of Iterator next()", compareListToIterator, iteratorArray);
    }

    @Test
    @Description("")
    public void testSkippingIteratorException() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            list.skippingIterator(2).remove();
        });
    }

    @Test
    public void testSkippingIteratorSkipTo(){
        //TODO implement test for that, see skiptonext cases for {0, 1}, think if method works like you wrote it
    }
}

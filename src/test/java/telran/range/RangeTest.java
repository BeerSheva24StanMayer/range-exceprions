package telran.range;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;


import org.junit.jupiter.api.Test;

import telran.range.exceptions.OutOfRangeMaxValueException;
import telran.range.exceptions.OutOfRangeMinValueException;

public class RangeTest {
    private static final int MIN = 50;
    private static final int MAX = 100;
    Range range = Range.getRange(MIN, MAX);

    @Test
    void wrongRangeCtreatingTest() {
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MAX, MIN));
    }

    @Test
    void rightNumberTest() throws Exception {
        range.checkNumber(55);
    }

    void wrongNumberTest() throws Exception {
        assertThrowsExactly(OutOfRangeMaxValueException.class,
                () -> range.checkNumber(MAX + 1));
        assertThrowsExactly(OutOfRangeMinValueException.class, () -> range.checkNumber(MIN - 1));
    }

    @Test
    void iteratorTest() {
        Range rangeIt = Range.getRange(0, 2);
        Iterator<Integer> it = rangeIt.iterator();
        Integer[] expected = { 0, 1, 2 };
        Integer[] actual = new Integer[expected.length];
        int index = 0;
        while (it.hasNext()) {
            actual[index++] = it.next();
        }
        assertArrayEquals(expected, actual);
        assertThrowsExactly(NoSuchElementException.class, it::next);
    }

    @Test
    void predicateTest() {

        //With predicator on
        Range range = Range.getRange(0, 10);
        range.setPredicate(i -> i % 2 == 0);
        Iterator<Integer> it = range.iterator();
        Integer[] expected = {0, 2, 4, 6, 8, 10};
        Integer[] actual = new Integer[expected.length];
        int index = 0;

        while (it.hasNext()) {
            actual[index] = it.next();
            System.out.println(actual[index]);
            index++;
        }

    assertArrayEquals(expected, actual);
    assertThrowsExactly(NoSuchElementException.class, it::next);


        //With predicator off
        Range range1 = Range.getRange(0, 10);
        Iterator<Integer> it1 = range1.iterator();
        Integer[] expected1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] actual1 = new Integer[expected1.length];
        int index1 = 0;

        while (it1.hasNext()) {
            actual1[index1] = it1.next();
            index1++;
        }
        assertArrayEquals(expected, actual);
    assertThrowsExactly(NoSuchElementException.class, it::next);
}
}
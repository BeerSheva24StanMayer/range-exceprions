package telran.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import telran.range.exceptions.OutOfRangeMaxValueException;
import telran.range.exceptions.OutOfRangeMinValueException;

public class Range implements Iterable<Integer> {
    private int min;
    private int max;
    private Predicate<Integer> predicate;

    private Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Range getRange(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException("max not greater than min");
        }
        return new Range(min, max);
    }

    void setPredicate(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    public void checkNumber(int number)
            throws OutOfRangeMaxValueException, OutOfRangeMinValueException {
        if (number > max) {
            throw new OutOfRangeMaxValueException(max, number);
        }
        if (number < min) {
            throw new OutOfRangeMinValueException(min, number);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {
        Integer current = getNextElement(min);

        private Integer getNextElement(Integer number) {
            Integer result = null;
            while ((number <= max && result == null) &&
                    !(predicate == null || predicate.test(number))) {
                number++;
            }
            result = number;
            return number;
        }

        @Override
        public boolean hasNext() {
            return current <= max;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Integer result = current;
            current = getNextElement(current + 1);

            return result;
        }

    }
}
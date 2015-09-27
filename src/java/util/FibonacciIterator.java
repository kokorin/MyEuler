package util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FibonacciIterator implements Iterator<BigInteger> {
    private int index = 0;

    private static final List<BigInteger> numbers = new ArrayList<>();

    static {
        numbers.add(BigInteger.ONE);
        numbers.add(BigInteger.ONE);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public BigInteger next() {
        BigInteger result;

        if (numbers.size() == index) {
            result = numbers.get(index-2).add(numbers.get(index-1));
            numbers.add(result);
        } else {
            result = numbers.get(index);
        }

        index++;
        return result;
    }
}

/*19.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask14;

import java.util.Comparator;
import java.util.HashSet;

public class TestableTask14 implements ITestableTask14 {

    @Override
    public <T extends Number> INumberCollection<T> createCollection(Class<T> required) {
        return new NumberCollection<>();
    }

    class NumberCollection<T extends Number>
            extends HashSet<T>
            implements ITestableTask14.INumberCollection<T> {

        @Override
        public T nearest(T value) {
            return stream().min(Comparator.comparingDouble(o -> Math.abs(o.doubleValue() - value.doubleValue()))).get();
        }
    }
}


/*19.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.Comparator;
import java.util.List;

public class TestableTask12 implements ITestableTask12 {

    @Override
    public List<Integer> transform(List<Integer> integers, int value) {
        integers.sort(Comparator.naturalOrder());
        return integers;
    }
}


/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestableTask7 implements ITestableTask7 {
    @Override
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {
        int degFirst = first.size();
        int degSecond = second.size();
        List<Integer> result = Stream.generate(() -> 0).limit(degFirst+degSecond).collect(Collectors.toList());
        for (int i = 0; i < degFirst; i++) {
            for (int j = 0; j < degSecond; j++) {
                result.set(i+j, result.get(i+j)+first.get(i)*second.get(j));
            }
        }
        return result;
    }
}

/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.util.HashSet;
import java.util.Set;

public class TestableTask4 implements ITestableTask4 {

    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>();
        for (Integer a : first){
            if (second.contains(a))
                result.add(a);
        }
        return result;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>();
        result.addAll(first);
        result.addAll(second);
        return result;
    }
}

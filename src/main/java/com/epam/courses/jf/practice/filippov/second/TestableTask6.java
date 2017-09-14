/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;
import java.util.Map;

public class TestableTask6 implements ITestableTask6{

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, 
                                                    HashMap<Integer, Integer> second) {

        HashMap<Integer, Integer> result;
        if (first.entrySet().size() < second.entrySet().size()) {
            result = new HashMap<>(second);
            for (Map.Entry<Integer, Integer> firstEntry : first.entrySet()) {
                result.put(firstEntry.getKey(), result.get(firstEntry.getKey()) + firstEntry.getValue());
            }
        } else {
            result = new HashMap<>(first);
            for (Map.Entry<Integer, Integer> secondEntry : second.entrySet()) {
                result.put(secondEntry.getKey(), result.get(secondEntry.getKey()) + secondEntry.getValue());
            }
        }
        return result;
    }
}

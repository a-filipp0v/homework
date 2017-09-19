/*19.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.Comparator;
import java.util.List;

public class TestableTask12 implements ITestableTask12 {
    @Override
    public List<Integer> transform(List<Integer> integers, int value) {
        integers.sort(Comparator.naturalOrder());
        for (Integer integer : integers) {
            if (value < integer) {
                integers.add(integers.indexOf(integer), value);
                break;
            }
        }
        return integers;
    }
}
//class Test{
//    public static void main(String[] args) {
//        TestableTask12 ts = new TestableTask12();
//        List<Integer> ls = new ArrayList<>(Arrays.asList(1, 9, 2, 4, 2, 0, 8, 11, 12, 8, 7));
//        ts.transform(ls, 5);
//        for (Integer l : ls) {
//            System.out.print(l + " ");
//        }
//    }
//}

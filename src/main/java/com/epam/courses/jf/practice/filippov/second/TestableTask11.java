/*18.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TestableTask11 implements ITestableTask11 {

    @Override
    public String emulate(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() > 1) {
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            iterator.remove();
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
        }
        return peoples.get(0);
    }

    @Override
    public String emulate(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() > 1) {
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            iterator.remove();
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
        }
        return peoples.get(0);
    }
}

/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.*;

public class TestableTask3 implements ITestableTask3 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> sortedPoems = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                String[] temp = poem.getLines().toArray(new String[0]);
                Arrays.sort(temp, Comparator.comparingInt(String::length).thenComparing(String::compareTo));
                sortedPoems.addAll(Arrays.asList(temp));
            }
        }
        return sortedPoems;
    }

    class Poem implements IPoem{
        List<String> lines;
        String author;

        public Poem(List<String> lines, String author) {
            this.lines = lines;
            this.author = author;
        }

        @Override
        public List<String> getLines() {
            return lines;
        }

        @Override
        public String getAuthor() {
            return author;
        }
    }
}

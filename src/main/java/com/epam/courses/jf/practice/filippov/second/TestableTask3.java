/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.*;
import java.util.stream.Collectors;

public class TestableTask3 implements ITestableTask3 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> sortedPoems = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                sortedPoems.addAll(poem.getLines());
            }
        }

        return sortedPoems.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
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

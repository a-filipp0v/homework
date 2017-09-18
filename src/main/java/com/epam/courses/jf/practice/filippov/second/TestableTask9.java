/*18.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask9;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class TestableTask9 implements ITestableTask9 {
    @Override
    public HashSet<String> getUniqueWords(File input) {
        HashSet<String> set = new HashSet<>();
        try (Scanner sc = new Scanner(input)) {
            while (sc.hasNext()) {
                set.add(sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}


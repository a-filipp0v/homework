/*18.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask10;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TestableTask10 implements ITestableTask10 {

    @Override
    public HashMap<String, Integer> countNumberWords(File input) {
        HashMap<String, Integer> map = new HashMap<>();
        try (Scanner sc = new Scanner(input)) {
            while(sc.hasNext()) {
                String temp = sc.next();
                map.put(temp, map.get(temp) == null ? 1 : map.get(temp)+1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}

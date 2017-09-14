/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class TestableTask1 implements ITestableTask1 {

    @Override
    public List<String> reverseFile(File input, File output) {
        List<String> result = null;
        try {
            result = Files.readAllLines(input.toPath());
            List<String> out = new ArrayList<>(result);
            Collections.reverse(out);
            Files.write(output.toPath(), out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

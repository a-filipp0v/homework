/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestableTask1 implements ITestableTask1 {

    @Override
    public List<String> reverseFile(File input, File output) {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(String.valueOf(input)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bw;
        FileWriter fw;

        try {
            fw = new FileWriter(output);
            bw = new BufferedWriter(fw);
            for (int i = lines.size() - 1; i >= 0; i--) {
                bw.write(lines.get(i) + "\n");
            }
            bw.close();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

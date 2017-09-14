/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class TestableTask2 implements ITestableTask2 {

    @Override
    public Set<File> getFiles(File directory) {
        Set<File> fileSet = new HashSet<>();
        for (File file : directory.listFiles()) {
            fileSet.add(file);
            if (file.isDirectory()) {
                fileSet.addAll(getFiles(file));
            }
        }
        return fileSet;
    }
}
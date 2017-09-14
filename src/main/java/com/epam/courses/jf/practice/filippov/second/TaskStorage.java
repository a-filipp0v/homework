/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskStorage implements ITaskStorage{

    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        String number = taskInterface.toString();
        Pattern pattern = Pattern.compile(".*Task(\\d+)$");
        Matcher matcher = pattern.matcher(number);
        StringBuilder result = new StringBuilder().append("Task").append(matcher.group(1));
        TestableTask res = null;
        try {
            res = (TestableTask) Class.forName(result.toString()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return (T) res;
    }

    interface TestableTask extends ITestableTask {
    }
}

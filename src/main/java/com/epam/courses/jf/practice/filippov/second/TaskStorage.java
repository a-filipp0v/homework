/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskStorage implements ITaskStorage{

    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        String number = taskInterface.toString();
        Pattern pattern = Pattern.compile(".*(TestableTask\\d+)$");
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            String result = "com.epam.courses.jf.practice.filippov.second." + matcher.group(1);
            ITestableTask res = null;
            try {
                res = (ITestableTask) Class.forName(result).newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
            return (T) res;
        } else {
            System.out.println("err");
            return null;
        }
    }
}

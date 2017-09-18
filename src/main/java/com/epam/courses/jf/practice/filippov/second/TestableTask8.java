/*18.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;
import java.util.Stack;

public class TestableTask8 implements ITestableTask8 {

    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Character> stack = new Stack<>();
        char[] array = string.toCharArray();
        for (char c : array) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.size() > 0 && stack.pop() == '(') break;
                    else return false;
                case '}':
                    if (stack.size() > 0 && stack.pop() == '{') break;
                    else return false;
                case ']':
                    if (stack.size() > 0 && stack.pop() == '[') break;
                    else return false;
                default:
                    return false;
            }
        }
        return stack.size()==0;
    }
}

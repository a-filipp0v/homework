/*29.08.2017*/
package com.epam.courses.jf.practice.filippov.collections;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Parser parser = new Parser();
        parser.parseDataAndWriteToFile(args);
    }
}

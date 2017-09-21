/*22.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestableTask16 implements ITestableTask16 {

    private double getDistance(I2DPoint cur, I2DPoint center) {
        return Math.sqrt((cur.getX() - center.getX()) * (cur.getX() - center.getX())
                + (cur.getY() - center.getY()) * (cur.getY() - center.getY()));
    }

    @Override
    public IFileWithPoints analyze(I2DPoint center, int radius, File output) {
        TreeMap<I2DPoint, Double> result = new TreeMap<>((o1, o2) -> {
            if (Double.compare(getDistance(o1, center), getDistance(o2, center)) != -1)
                return 1;
            else
                return -1;
        });
        PriorityQueue<I2DPoint> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> getDistance(o, center)));

        for (int i = (int) center.getX() - radius; i < center.getX() + radius; i++) {
            for (int j = (int) center.getY() - radius; j < center.getY() + radius; j++) {
                I2DPoint current = new a2DPoint(i, j);
                if (getDistance(current, center) - radius < -Double.MIN_VALUE) {
                    queue.offer(current);
                }
            }
        }

        try (FileWriter fw = new FileWriter(output)) {
            while (queue.size() != 0) {
                I2DPoint current = queue.poll();
                result.put(current, getDistance(current, center));
                System.out.println(current.toString());
                fw.write(current.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new IFileWithPoints() {

            @Override
            public File getFile() {
                return output;
            }

            @Override
            public SortedMap<I2DPoint, Double> getPoints() {
                return result;
            }
        };
    }

    public static void main(String[] args) {
        I2DPoint center = new I2DPoint() {
            @Override
            public double getX() {
                return 0.5;
            }

            @Override
            public double getY() {
                return 0.5;
            }
        };
        int radius = 1;
        File output = new File("123.txt");
        TestableTask16 test = new TestableTask16();
        test.analyze(center, radius, output);
    }
}

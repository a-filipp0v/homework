/*19.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask15;
import lombok.Data;

import java.io.File;
import java.util.*;

public class TestableTask15 implements ITestableTask15 {

    @Override
    public IFileWithLines analyze(Set<I2DPoint> points, File output) {
        List<Line> allLines = new ArrayList<>();
        Set<Line> lines = new HashSet<>();
        for (I2DPoint point : points) {
            for (I2DPoint anotherPoint : points) {
                if(point != anotherPoint)
                    allLines.add(new Line(point,anotherPoint));
            }
        }
        for (Line line : allLines) {
            for (Line anotherLine : allLines) {
                if(line.equals(anotherLine)){
                    line.getPoints().addAll(anotherLine.getPoints());
                    anotherLine.getPoints().addAll(line.getPoints());
                }
            }
        }
        lines.addAll(allLines);

        return new IFileWithLines() {

            @Override
            public File getFile() {
                return output;
            }

            @Override
            public Set<ILine> getLines() {
                return new HashSet<>(lines);
            }
        };
    }
    @Data
    class Line implements ILine {

        private Set<I2DPoint> points;
        private double angle;
        private double shift;
        Line(I2DPoint first, I2DPoint second) {
            if (points == null)
                points = new HashSet<>();
            points.add(first);
            points.add(second);
            angle = (first.getY() - second.getY())/(first.getX() - second.getX());
            shift = first.getY() - angle * first.getX();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Double.compare(line.angle, angle) == 0 && Double.compare(line.shift, shift) == 0;
        }
    }
}

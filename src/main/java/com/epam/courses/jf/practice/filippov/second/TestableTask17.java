/*22.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;

import java.util.*;

public class TestableTask17 implements ITestableTask17 {

    private double crossFb(I2DPoint center, I2DPoint first, I2DPoint second) {
        return (first.getX() - center.getX()) * (second.getY() - center.getY()) -
                (first.getY() - center.getY()) * (second.getX() - center.getX());
    }

    private boolean crossingCheck(ISegment first, ISegment second) {
        return (Math.signum(crossFb(first.first(), second.first(), first.second())) !=
                Math.signum(crossFb(first.first(), second.second(), first.second()))) &&
                (Math.signum(crossFb(second.first(), first.first(), second.second())) !=
                        Math.signum(crossFb(second.first(), first.second(), second.second())));
    }

    private a2DPoint collisionPoint(ISegment first, ISegment second) {
        if (crossingCheck(first, second)) {
            double coeff = Math.abs(crossFb(first.first(), first.second(), second.first())) /
                    Math.abs(crossFb(first.first(), first.second(), second.second()) -
                            crossFb(first.first(), first.second(), second.first()));
            double xPos = second.first().getX() + (second.second().getX() - second.first().getX()) * coeff;
            double yPos = second.first().getY() + (second.second().getY() - second.first().getY()) * coeff;
            return new a2DPoint(xPos, yPos);
        }
        return null;
    }

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        SortedMap<Double, I2DPoint> pointsMap = new TreeMap<>((o1, o2) -> {
            if (Double.compare(o1, o2) != -1)
                return 1;
            else
                return -1;
        });
        for (ISegment segment : segments) {
            for (ISegment anotherSegment : segments) {
                if (segment != anotherSegment && crossingCheck(segment, anotherSegment)) {
                    I2DPoint current = collisionPoint(segment, anotherSegment);
                    pointsMap.put(current.getX(), current);
                }
            }
        }

        double min = pointsMap.firstKey();
        Set<I2DPoint> result = new HashSet<>();
        for (Map.Entry<Double, I2DPoint> entry : pointsMap.entrySet()) {
            if (entry.getKey() == min)
                result.add(entry.getValue());
        }
        return result;
    }
}

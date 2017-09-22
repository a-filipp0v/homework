/*22.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask19;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class TestableTask19 implements ITestableTask19 {

    @Override
    public int getNumberOvertaking(Set<ICar> cars, long lengthLap, int numberLaps) {
        int counter = 0;
        int nextLapCounter = 0;
        ArrayList<Car> lapPosition = cars.stream().map(car -> new Car(car.getStartPosition(), car.getSpeed())).collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(lapPosition);
        for (int i = 0; i < lapPosition.size(); i++) {
            lapPosition.get(i).setRacePosition(i);
        }

        while (lapPosition.size() > 1) {
            System.out.println(lapPosition);
            for (Car car : lapPosition) {
                car.setCurrentPosition(car.getCurrentPosition() + car.getSpeed());
                if (car.getCurrentPosition() >= lengthLap) {
                    car.setLaps((int) (car.getLaps() + car.getCurrentPosition() / lengthLap));
                    car.setCurrentPosition(car.getCurrentPosition() % lengthLap);
                    if (car.getLaps() != numberLaps)
                        nextLapCounter++;
                }
            }
            counter -= nextLapCounter * (lapPosition.size() - nextLapCounter);
            nextLapCounter = 0;
            Iterator<Car> iter = lapPosition.iterator();
            while (iter.hasNext())
                if (iter.next().getLaps() >= numberLaps) {
                    iter.remove();
                }

            Collections.sort(lapPosition);
            for (int i = 0; i < lapPosition.size(); i++) {
                for (int j = i + 1; j < lapPosition.size(); j++) {
                    if (lapPosition.get(i).getRacePosition() > lapPosition.get(j).getRacePosition())
                        counter++;
                }
            }
            for (int i = 0; i < lapPosition.size(); i++) {
                lapPosition.get(i).setRacePosition(i);
            }
        }

        return counter;
    }

    @Data
    static class Car implements ICar, Comparable<Car> {

        private int racePosition;
        private final int startPosition;
        private final int speed;
        private int laps;
        private long currentPosition;

        Car(int startPosition, int speed) {
            this.startPosition = startPosition;
            this.speed = speed;
            this.laps = 0;
            this.racePosition = 0;
            this.currentPosition = startPosition;
        }

        @Override
        public int compareTo(Car o) {
            if (currentPosition != o.currentPosition)
                return Long.compare(this.currentPosition, o.currentPosition);
            else return Integer.compare(racePosition, o.racePosition);
        }

        @Override
        public String toString() {
            return laps + ", " + currentPosition;
        }
    }
}

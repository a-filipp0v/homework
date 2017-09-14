/*15.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.util.List;

public class TestableTask5 implements ITestableTask5 {

    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal voltageSum = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_HALF_UP);
        BigDecimal currSumm = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_HALF_UP);

        for (IMeasurement measurement : measurements) {
            voltageSum = voltageSum.add(new BigDecimal(measurement.getVoltage())
                    .setScale(6, BigDecimal.ROUND_HALF_UP)
                    .multiply(new BigDecimal(measurement.getCurrent())
                    .setScale(6, BigDecimal.ROUND_HALF_UP)));
            currSumm = currSumm.add(new BigDecimal(measurement.getCurrent())
                    .setScale(6, BigDecimal.ROUND_HALF_UP)
                    .multiply(new BigDecimal(measurement.getCurrent())
                    .setScale(6, BigDecimal.ROUND_HALF_UP)));
        }

        return voltageSum.divide(currSumm, 6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}

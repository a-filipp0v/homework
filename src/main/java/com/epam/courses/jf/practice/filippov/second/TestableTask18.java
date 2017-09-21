/*22.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask18;
import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;

public class TestableTask18 implements ITestableTask18 {

    private IRectangularIntegerMatrix matrix;
    private LinkedList<IRectangularIntegerMatrix> stack = new LinkedList<>();

    @Override
    public IRectangularIntegerMatrix getMaxSubMatrix(IRectangularIntegerMatrix matrix) {
        this.matrix = matrix;
        if (countElements(matrix) == 1) {
            return matrix;
        }
        for (int row = 0; row < matrix.getHeight(); ++row) {
            for (int col = 0; col < matrix.getWidth(); ++col) {
                construct(col, row);
            }
        }
        return stack.pop();
    }

    private int countElements(IRectangularIntegerMatrix matrix) {
        return (matrix.getWidth() == 0) ? matrix.getHeight() : ((matrix.getHeight() == 0) ? matrix.getWidth() : matrix.getWidth() * matrix.getHeight());
    }

    private void construct(int indexWidthTo, int indexHeightTo) {
        int element = matrix.getValue(indexWidthTo, indexHeightTo);
        int height = matrix.getHeight() - indexHeightTo;
        int width;
        RectangularIntegerMatrix newMatrix = null;
        while (height >= 1) {
            width = matrix.getWidth() - indexWidthTo;
            while (width >= 1) {
                newMatrix = new TestableTask18.RectangularIntegerMatrix(width, height);
                for (int i = 0; i < height; ++i) {
                    for (int j = 0; j < width; ++j) {
                        newMatrix.setValue(j, i, matrix.getValue(indexWidthTo + j, indexHeightTo + i));
                    }
                }
                if (newMatrix.containsOnly(element)) {
                    push(newMatrix);
                }
                width--;
            }
            height--;
        }
        if (newMatrix.containsOnly(element)) {
            push(newMatrix);
        }
    }

    private void push(IRectangularIntegerMatrix matrix) {
        if (stack.isEmpty()) {
            stack.push(matrix);
        }
        if (countElements(matrix) > countElements(stack.peek())) {
            stack.push(matrix);
        }
    }
    @Data
    static class RectangularIntegerMatrix implements IRectangularIntegerMatrix {

        int[][] matrix;
        private int width;
        private int height;

        RectangularIntegerMatrix(int width, int height) {
            this.width = width;
            this.height = height;
            matrix = new int[height][width];
        }

        void setValue(int indexWidth, int indexHeight, int value) {
            matrix[indexHeight][indexWidth] = value;
        }

        @Override
        public int getValue(int indexWidth, int indexHeight) {
            return matrix[indexHeight][indexWidth];
        }

        boolean containsOnly(int element) {
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    if (getValue(j, i) != element) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RectangularIntegerMatrix that = (RectangularIntegerMatrix) o;
            return width == that.width && height == that.height && Arrays.deepEquals(matrix, that.matrix);
        }
    }
}

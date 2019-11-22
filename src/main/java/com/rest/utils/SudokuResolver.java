package com.rest.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Georgi Trendafilov
 */
public class SudokuResolver {

    public static void main(String[] args) {
        Box[][] matrix = readMatrix();
        System.out.println(countEmptyBoxes(matrix));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Box box = matrix[i][j];
                if (box.getValue() == null) {
                    // check horizontal
                    lineCheck(matrix[i], box);
                    // check vertical
                    lineCheck(getVerticalLine(matrix, box.getVerticalPos(), 0, 9), box);
                    // check square
                    checkSquare(matrix, box);
                    if (box.getValidNumbers().size() > 1) {
                        System.out.println(box.getHorizontalPos() + " " + box.getVerticalPos() + " " + box.getValidNumbers());
                    }
                }
                //System.out.print(box);
            }
            //System.out.println();
        }
        System.out.println(countEmptyBoxes(matrix));
    }

    private static void checkSquare(Box[][] matrix, Box currentBox) {
        Square square = currentBox.getSquare();
        // check horizontal
        for (int i = square.getVerticalStartPos(); i < square.getVerticalEndPos(); i++) {
            lineCheck(matrix[i], currentBox);
        }

        // check vertical
        for (int i = square.getHorizontalStartPos(); i < square.getVerticalEndPos(); i++) {
            lineCheck(getVerticalLine(matrix, currentBox.getHorizontalPos(), square.getVerticalStartPos(), square.getVerticalEndPos() + 1), currentBox);
        }
    }

    private static Box[] getVerticalLine(Box[][] matrix, int horizontalPos, int start, int end) {
        Box[] verticalLine = new Box[end - start];
        int boxPosition = 0;
        for (int i = start; i < end; i++) {
            verticalLine[boxPosition] = matrix[i][horizontalPos];
            boxPosition++;
        }
        return verticalLine;
    }

    private static Box[][] readMatrix() {
        Scanner in = new Scanner(System.in);
        Box[][] matrix = new Box[9][9];

        for (int i = 0; i < 9; i++) {
            matrix[i] = splitLineAtBoxes(in.nextLine(), i);
        }
        return matrix;
    }

    private static Box[] splitLineAtBoxes(String line, int horizontalPos) {
        char[] chars = line.toCharArray();
        if (chars.length != 27) {
            throw new RuntimeException("Bad line: " + line);
        }
        List<Box> boxes = new ArrayList<>();
        int verticalPos = 0;
        for (int i = 0; i < chars.length; i += 3) {
            boxes.add(new Box(horizontalPos, verticalPos, line.substring(i, i + 3)));
            verticalPos++;
        }
        Box[] toReturn = new Box[9];
        return boxes.toArray(toReturn);
    }

    public static void lineCheck(Box[] boxes, Box currentBox) {
        if (currentBox.getValue() == null) {
            leftCheck(boxes, currentBox);
            rightCheck(boxes, currentBox);
        }
        if (currentBox.getValidNumbers().size() == 1) {
            currentBox.setValue(currentBox.getValidNumbers().get(0));
        }
    }

    private static void leftCheck(Box[] boxes, Box currentBox) {

        for (Box box : boxes) {
            for (Integer num : box.getValidNumbers()) {
                if (num.equals(box.getValue())) {
                    currentBox.getValidNumbers().remove(num);
                    break;
                }
            }
        }

    }

    private static void rightCheck(Box[] boxes, Box currentBox) {
        for (Box box : boxes) {
            for (Integer num : box.getValidNumbers()) {
                if (num.equals(box.getValue())) {
                    currentBox.getValidNumbers().remove(num);
                    break;
                }
            }
        }
    }

    private static int countEmptyBoxes(Box[][] matrix) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j].getValue() == null) {
                    count ++;
                }
            }
        }
        return count;
    }
}

class Box {

    private Integer value;

    private int horizontalPos;

    private int verticalPos;

    private Square square;

    private List<Integer> validNumbers;

    public Box(int horizontalPos, int verticalPos, String boxString) {
        this.horizontalPos = horizontalPos;
        this.verticalPos = verticalPos;
        this.value = parseValue(boxString);
        this.square = getSquare(horizontalPos, verticalPos);
        this.validNumbers = new CopyOnWriteArrayList() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
        }};
    }

    private Integer parseValue(String boxString) {
        if (!" ".equalsIgnoreCase(boxString.substring(1, 2))) {
            return (Integer.parseInt(boxString.substring(1, 2)));
        }
        return null;
    }

    private Square getSquare(int horizontalPos, int verticalPos) {
        if (horizontalPos <= 2 && verticalPos <= 2) {
            return new Square(1, 0, 2, 0, 2);
        }
        if (horizontalPos <= 5 && verticalPos <= 2) {
            return new Square(2, 3, 5, 0, 2);
        }
        if (horizontalPos <= 8 && verticalPos <= 2) {
            return new Square(3, 6, 8, 0, 2);
        }
        if (horizontalPos <= 2 && verticalPos <= 5) {
            return new Square(4, 0, 2, 3, 5);
        }
        if (horizontalPos <= 5 && verticalPos <= 5) {
            return new Square(5, 3, 5, 3, 5);
        }
        if (horizontalPos <= 8 && verticalPos <= 5) {
            return new Square(6, 6, 8, 3, 5);
        }
        if (horizontalPos <= 2 && verticalPos <= 8) {
            return new Square(7, 0, 2, 6, 8);
        }
        if (horizontalPos <= 5 && verticalPos <= 8) {
            return new Square(8, 3, 5, 6, 8);
        }
        if (horizontalPos <= 8 && verticalPos <= 8) {
            return new Square(9, 6, 8, 6, 8);
        }
        throw new RuntimeException("Bad positions: " + horizontalPos + " " + verticalPos);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int getHorizontalPos() {
        return horizontalPos;
    }

    public void setHorizontalPos(int horizontalPos) {
        this.horizontalPos = horizontalPos;
    }

    public int getVerticalPos() {
        return verticalPos;
    }

    public void setVerticalPos(int verticalPos) {
        this.verticalPos = verticalPos;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public List<Integer> getValidNumbers() {
        return validNumbers;
    }

    public void setValidNumbers(List<Integer> validNumbers) {
        this.validNumbers = validNumbers;
    }

    @Override
    public String toString() {

        String valueString;

        if (value == null) {
            valueString = " ";
        } else {
            valueString = String.valueOf(value);
        }

        return '[' + valueString + ']';
    }
}

class Square {

    private int number;

    private int horizontalStartPos;

    private int horizontalEndPos;

    private int verticalStartPos;

    private int verticalEndPos;

    public Square(int number, int horizontalStartPos, int horizontalEndPos, int verticalStartPos, int verticalEndPos) {
        this.number = number;
        this.horizontalStartPos = horizontalStartPos;
        this.horizontalEndPos = horizontalEndPos;
        this.verticalStartPos = verticalStartPos;
        this.verticalEndPos = verticalEndPos;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getHorizontalStartPos() {
        return horizontalStartPos;
    }

    public void setHorizontalStartPos(int horizontalStartPos) {
        this.horizontalStartPos = horizontalStartPos;
    }

    public int getHorizontalEndPos() {
        return horizontalEndPos;
    }

    public void setHorizontalEndPos(int horizontalEndPos) {
        this.horizontalEndPos = horizontalEndPos;
    }

    public int getVerticalStartPos() {
        return verticalStartPos;
    }

    public void setVerticalStartPos(int verticalStartPos) {
        this.verticalStartPos = verticalStartPos;
    }

    public int getVerticalEndPos() {
        return verticalEndPos;
    }

    public void setVerticalEndPos(int verticalEndPos) {
        this.verticalEndPos = verticalEndPos;
    }
}

package com.rest.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Georgi Trendafilov
 */
public class SudokuResolver {


    public static void main(String[] args) {
        Box[][] matrix = readMatrix();
        int start = countEmptyBoxes(matrix);
        int emptyBoxes;
        int count = 0;
        do {
            printMatrix(matrix);
            emptyBoxes = countEmptyBoxes(matrix);
            checkMatrix(matrix);
            count++;
        }
        while (haveProgress(matrix, emptyBoxes));

        System.out.println("From " + start + " to " + countEmptyBoxes(matrix) + " with " + count + " rows.");
        printMatrix(matrix);
    }

    private static boolean isValid(Box[][] matrix) {
        boolean result = true;
        for (int i = 0; i < 9; i++) {
            // horizontal check
            result = containsOnlyUnique(matrix[i]);
            if (!result) {
                return result;
            }

            // vertical check
            for (int j = i + 1; j < 9; j++) {
                result = containsOnlyUnique(getVerticalLine(matrix, j, 0, 9));
                if (!result) {
                    return result;
                }
            }
        }

        for (Square square : Box.SQUARES) {
            for (int i = square.getHorizontalStartPos(); i < square.getHorizontalEndPos(); i++) {
                // horizontal check
                result = containsOnlyUnique(matrix[i]);
                if (!result) {
                    return result;
                }

                // vertical check
                for (int j = square.getVerticalStartPos(); j < square.getVerticalEndPos(); j++) {
                    result = containsOnlyUnique(getVerticalLine(matrix, j, square.getHorizontalStartPos(), square.getHorizontalEndPos()));
                    if (!result) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    private static boolean containsOnlyUnique(Box[] line) {
        for (int i = 0; i < line.length; i++) {
            Box currentBox = line[i];
            for (int j = i + 1; j < line.length; j++) {
                if (currentBox.getValue() != null && currentBox.getValue().equals(line[j].getValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void checkMatrix(Box[][] matrix) {
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
                    if (box.getValidNumbers().size() == 1) {
                        box.setValue(box.getValidNumbers().get(0));
                    }
                }
            }
        }
    }

    private static boolean haveProgress(Box[][] matrix, int emptyBoxes) {
        return emptyBoxes > countEmptyBoxes(matrix);
    }

    private static void bruteForce(Box[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Box box = matrix[i][j];
                if (box.getValue() == null) {
                    box.setValue(box.getValidNumbers().get(new Random().nextInt(box.getValidNumbers().size())));
                }
            }
        }
    }

    private static Box[][] cloneMatrix(Box[][] matrix) {
        Box[][] clone = new Box[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                clone[i][j] = new Box(matrix[i][j]);
            }
        }
        return clone;
    }

    private static boolean isCompleted(Box[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j].getValue() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printMatrix(Box[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void checkSquare(Box[][] matrix, Box currentBox) {
        Square square = currentBox.getSquare();
        // collect boxes to be checked
        List<Box> boxesToCheck = new ArrayList<>();
        for (int i = square.getHorizontalStartPos(); i <= square.getHorizontalEndPos(); i++) {
            for (int j = square.getVerticalStartPos(); j <= square.getVerticalEndPos(); j++) {
                boxesToCheck.add(matrix[i][j]);
            }
        }
        Box[] boxes = new Box[boxesToCheck.size()];
        lineCheck(boxesToCheck.toArray(boxes), currentBox);
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
                    count++;
                }
            }
        }
        return count;
    }
}

class Box {

    public static final Square SQUARE_1 = new Square(1, 0, 2, 0, 2);

    public static final Square SQUARE_2 = new Square(2, 0, 2, 3, 5);

    public static final Square SQUARE_3 = new Square(3, 0, 2, 6, 8);

    public static final Square SQUARE_4 = new Square(4, 3, 5, 0, 2);

    public static final Square SQUARE_5 = new Square(5, 3, 5, 3, 5);

    public static final Square SQUARE_6 = new Square(6, 3, 5, 6, 8);

    public static final Square SQUARE_7 = new Square(7, 6, 8, 0, 2);

    public static final Square SQUARE_8 = new Square(8, 6, 8, 3, 5);

    public static final Square SQUARE_9 = new Square(9, 6, 8, 6, 8);

    public static final List<Square> SQUARES = new ArrayList() {{
        add(SQUARE_1);
        add(SQUARE_2);
        add(SQUARE_3);
        add(SQUARE_4);
        add(SQUARE_5);
        add(SQUARE_6);
        add(SQUARE_7);
        add(SQUARE_8);
        add(SQUARE_9);
    }};

    private Integer value;

    private int horizontalPos;

    private int verticalPos;

    private Square square;

    private List<Integer> validNumbers;

    public Box(Box currentBox) {
        this.horizontalPos = currentBox.getHorizontalPos();
        this.verticalPos = currentBox.getVerticalPos();
        this.value = currentBox.getValue() == null ? null : new Integer(currentBox.getValue());
        this.square = currentBox.getSquare();
        this.validNumbers = new ArrayList<>(currentBox.getValidNumbers());
    }

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
        if (horizontalPos < 3 && verticalPos < 3) {
            return SQUARE_1;
        } else if (horizontalPos < 3 && verticalPos < 6) {
            return SQUARE_2;
        } else if (horizontalPos < 3 && verticalPos < 9) {
            return SQUARE_3;
        } else if (horizontalPos < 6 && verticalPos < 3) {
            return SQUARE_4;
        } else if (horizontalPos < 6 && verticalPos < 6) {
            return SQUARE_5;
        } else if (horizontalPos < 6 && verticalPos < 9) {
            return SQUARE_6;
        } else if (horizontalPos < 9 && verticalPos < 3) {
            return SQUARE_7;
        } else if (horizontalPos < 9 && verticalPos < 6) {
            return SQUARE_8;
        } else if (horizontalPos < 9 && verticalPos < 9) {
            return SQUARE_9;
        } else {
            throw new RuntimeException("Bad positions: " + horizontalPos + " " + verticalPos);
        }
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

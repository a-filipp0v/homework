package com.epam.courses.jf.practice.filippov.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализация первого блока заданий.
 */
public class Solver implements ISolver {

    // TODO выполнение задания

    private String[] createArrayOfLines() {
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = sc.nextLine();
        }
        return lines;
    }
    private String[] createArrayOfWords() {
        Scanner sc = new Scanner(System.in);
        Integer.parseInt(sc.nextLine());
        return sc.nextLine().split(" ");
    }

    @Override
    public void task1() {
        String[] lines = createArrayOfLines();
        String minString = lines[0];
        String maxString = lines[0];
        for (String s : lines) {
            if (s.length() >= maxString.length()) {
                maxString = s;
            }
            if (s.length() <= minString.length()) {
                minString = s;
            }
        }
        System.out.printf("MIN (%d): \"%s\"%n", minString.length(), minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxString.length(), maxString);
    }

    @Override
    public void task2() {
        String[] lines = createArrayOfLines();
        Arrays.sort(lines, Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        for (String st : lines) {
            System.out.printf("(%d): \"%s\"%n", st.length(), st);
        }
    }

    @Override
    public void task3() {
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[Integer.parseInt(sc.nextLine())];
        int sumOfLenghts = 0;
        for (int i = 0; i < lines.length; i++) {
            lines[i] = sc.nextLine();
            sumOfLenghts += lines[i].length();
        }
        int averageLength = sumOfLenghts / lines.length;
        System.out.printf("AVERAGE (%d)%n", averageLength);
        for (String s : lines) {
            if (s.length() < averageLength) {
                System.out.printf("(%d): \"%s\"%n", s.length(), s);
            }
        }
    }

    @Override
    public void task4() {
        String[] lines = createArrayOfWords();
        String foundWord = lines[0];
        long amountOfUniqueSymbols = lines[0].chars().distinct().count();
        for (String s : lines) {
            if (s.chars().distinct().count() < amountOfUniqueSymbols) {
                amountOfUniqueSymbols = s.chars().distinct().count();
                foundWord = s;
            }
        }
        System.out.println(foundWord);
    }

    @Override
    public void task5() {
        String[] inputLines = createArrayOfWords();
        String vowels = "aeiouyAEIOUY";
        int numOfFoundWords = 0;
        for (String s : inputLines) {
            int numOfVowels = 0;
            int numOfConsonants = 0;
            if (s.matches("[a-zA-Z]+")) {
                for (int i = 0; i < s.length(); i++) {
                    if (vowels.indexOf(s.charAt(i)) >= 0) {
                        numOfVowels++;
                    } else if (Character.isLetter(s.charAt(i))) {
                        numOfConsonants++;
                    }
                }
                if (numOfConsonants == numOfVowels) {
                    numOfFoundWords++;
                }
            }
        }
        System.out.println(numOfFoundWords);
    }

    @Override
    public void task6() {
        Scanner sc = new Scanner(System.in);
        Integer.parseInt(sc.nextLine());
        String[] inputLines = sc.nextLine().split(" ");
        String foundWord = inputLines[0];
        int counter = 0;
        for (String s : inputLines) {
            if (counter == 0) {
                for (int i = 0; i < s.length() - 1; ) {
                    if (s.charAt(i) < s.charAt(i + 1)) {
                        i++;
                        if (i == s.length() - 1) {
                            counter = 1;
                            foundWord = s;
                        }
                    } else break;
                }
            }  else break;
        }
        System.out.println(counter==0 ? "NOT FOUND" : foundWord);
    }

    @Override
    public void task7() {
        Scanner sc = new Scanner(System.in);
        Integer.parseInt(sc.nextLine());
        String[] inputLines = sc.nextLine().split(" ");
        String foundWord = Arrays.stream(inputLines)
                                 .filter(string -> string.chars().distinct().count() == string.length())
                                 .distinct()
                                 .collect(Collectors.joining(" "));
        System.out.println(foundWord.isEmpty() ? "NOT FOUND" : foundWord);
    }

    @Override
    public void task8() {
        Scanner sc = new Scanner(System.in);
        Integer.parseInt(sc.nextLine());
        String[] inputLines = sc.nextLine().split(" ");
        String palindrome = "";
        for (String s : inputLines) {
            if (s.matches("^[0-9+]*$") && new StringBuilder(s).reverse().toString().equals(s)) {
                    palindrome = s;
            }
        }
        System.out.println(palindrome.equals("") ? "NOT FOUND" : palindrome);
    }

    @Override
    public void task9() {
        int size = Integer.parseInt(new Scanner(System.in).nextLine());
        for (int i = 1; i <= size*size; i++) {
            System.out.print(i + (i%size==0 ? "\n" : "\t"));
        }
    }

    @Override
    public void task10() {
        String[] st = new Scanner(System.in).nextLine().split(" ");
        double a = Double.parseDouble(st[0]);
        double b = Double.parseDouble(st[1]);
        double c = Double.parseDouble(st[2]);
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            BigDecimal x1 = BigDecimal.valueOf((-b - Math.sqrt(discriminant)) / (2 * a)).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal x2 = BigDecimal.valueOf((-b + Math.sqrt(discriminant)) / (2 * a)).setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println("Two solutions: " + x1 + ", " + x2);
        }
        else if (discriminant == 0) {
            BigDecimal x = BigDecimal.valueOf(-b / (2 * a)).setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println("One solution: " + x);
        }
        else {
            System.out.println("No solution");
        }
    }

    @Override
    public void task11() {
        try {
            int val = Integer.parseInt(new Scanner(System.in).nextLine());
            if (val>0 && val<=12) {
                switch(val) {
                    case 1: System.out.println(Month.of(val).name());
                        break;
                    case 2: System.out.println(Month.of(val).name());
                        break;
                    case 3: System.out.println(Month.of(val).name());
                        break;
                    case 4: System.out.println(Month.of(val).name());
                        break;
                    case 5: System.out.println(Month.of(val).name());
                        break;
                    case 6: System.out.println(Month.of(val).name());
                        break;
                    case 7: System.out.println(Month.of(val).name());
                        break;
                    case 8: System.out.println(Month.of(val).name());
                        break;
                    case 9: System.out.println(Month.of(val).name());
                        break;
                    case 10: System.out.println(Month.of(val).name());
                        break;
                    case 11: System.out.println(Month.of(val).name());
                        break;
                    case 12: System.out.println(Month.of(val).name());
                }
            } else System.out.println("INCORRECT INPUT DATA");
        } catch (NumberFormatException e) {
            System.out.println("INCORRECT INPUT DATA");
        }
    }

    private List<List<String>> createAndFillListMatrix(Scanner sc, int size) {
        List<List<String>> list = new ArrayList<>();
        for (int rows = 0; rows < size; rows++) {
            list.add(new ArrayList<>());
            for (int cols = 0; cols < size; cols++) {
                list.get(rows).add(cols, sc.next());
            }
        }
        return list;
    }
    private void printListMatrix(List<List<String>> list) {
        for (List<String> strings : list) {
            System.out.print(strings.stream()
                    .collect(Collectors.joining(" ")));
            System.out.print("\n");
        }
    }

    @Override
    public void task12() {
        Scanner sc = new Scanner(System.in);
        int index = Integer.parseInt(sc.nextLine());
        List<List<String>> list = createAndFillListMatrix(sc, Integer.parseInt(sc.nextLine()));
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-1-i; j++) {
                if (Integer.parseInt(list.get(j).get(index)) > Integer.parseInt(list.get(j+1).get(index))) {
                    List<String> tempList = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, tempList);
                }
            }
        }
        System.out.println(list.size());
        printListMatrix(list);
    }

    private List<List<String>> moveMatrixDown(List<List<String>> list, int step) {
        List<List<String >> newList = new ArrayList<>();
        for (int i = list.size()-step; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        for (int i = 0; i < list.size() - step; i++) {
            newList.add(list.get(i));
        }
        return newList;
    }
    private List<List<String>> moveMatrixUp(List<List<String>> list, int step) {
        List<List<String>> newList = new ArrayList<>();
        for (int i = Math.abs(step); i < list.size(); i++) {
            newList.add(list.get(i));
        }
        for (int i = 0; i < Math.abs(step); i++) {
            newList.add(list.get(i));
        }
        return newList;
    }

    @Override
    public void task13() {
        Scanner sc = new Scanner(System.in);
        int index = Integer.parseInt(sc.nextLine());
        List<List<String>> list = createAndFillListMatrix(sc, Integer.parseInt(sc.nextLine()));

        System.out.println(list.size());
        if (Math.abs(index%list.size()) == 0 || index == 0) {
            printListMatrix(list);
        } else {
            int step = Math.abs(index) < list.size() ? index : index%list.size();
            if (step > 0) {
                list = moveMatrixDown(list, step);
            } if (step < 0) {
                list = moveMatrixUp(list, step);
            }
            printListMatrix(list);
        }
    }

    private void findIncreasingSeq(int[] arr) {
        int length = 0;
        int tempLenght = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i+1]) {
                tempLenght++;
                length = tempLenght;
            } else tempLenght = 0;
        }
        if (length>1) {
            System.out.println(length + 1);
        } else System.out.println(0);
    }

    @Override
    public void task14() {
        String[] lines = createArrayOfWords();
        int[] ints = Arrays.stream(lines).mapToInt(Integer::parseInt).toArray();
        findIncreasingSeq(ints);
    }

    @Override
    public void task15() {
        Scanner sc = new Scanner(System.in);
        List<List<String>> list = createAndFillListMatrix(sc, Integer.parseInt(sc.nextLine()));
        int sumOfElements = 0;
        for (List<String> strings : list) {
            int firstPositiveIndex = -1;
            int secondPositiveIndex = -1;
            for (int i = 0; i < strings.size(); i++) {
                if (Integer.parseInt(strings.get(i)) > 0 && firstPositiveIndex >-1) {
                    secondPositiveIndex = i;
                    break;
                }
                if (Integer.parseInt(strings.get(i)) > 0) {
                    firstPositiveIndex = i;
                }
            }
            for (int j = firstPositiveIndex+1; j < secondPositiveIndex; j++) {
                sumOfElements+=Integer.parseInt(strings.get(j));
            }
        }
        System.out.println(sumOfElements);

    }

    private List<List<String>> rotateMatrix(List<List<String>> list) {
        List<List<String>> rotatedList = new ArrayList<>();
        for (int rows = 0; rows < list.size(); rows++) {
            rotatedList.add(new ArrayList<>());
            for (int cols = 0; cols < list.size(); cols++) {
                rotatedList.get(rows).add(cols, "0");
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                rotatedList.get(i).set(j, list.get(j).get(list.size()-1-i));
            }
        }
        return rotatedList;
    }

    @Override
    public void task16() {
        Scanner sc = new Scanner(System.in);
        List<List<String>> list = createAndFillListMatrix(sc, Integer.parseInt(sc.nextLine()));
        System.out.println(list.size());
        printListMatrix(rotateMatrix(list));
    }

    private int findDet(List<List<String>> list) {
        int det = 0;
        int sign;
        if (list.size() == 1) {
            return Integer.parseInt(list.get(0).get(0));
        }
        for (int i = 0; i < list.size(); i++) {
            List<List<String>> tempList = new ArrayList<>();
            for (int rows = 0; rows < list.size()-1; rows++) {
                tempList.add(new ArrayList<>());
                for (int cols = 0; cols < list.size()-1; cols++) {
                    tempList.get(rows).add(cols, "0");
                }
            }
            for (int a = 1; a < list.size(); a++) {
                for (int b = 0; b < list.size(); b++) {
                    if (b < i) {
                        tempList.get(a-1).set(b, list.get(a).get(b));
                    } else if (b > i) {
                        tempList.get(a-1).set(b-1, list.get(a).get(b));
                    }
                }
            }
            if (i%2==0) {
                sign=1;
            } else sign =-1;
            det+=sign*Integer.parseInt(list.get(0).get(i)) * (findDet(tempList));
        }
        return det;
    }

    @Override
    public void task17() {
        Scanner sc = new Scanner(System.in);
        List<List<String>> list = createAndFillListMatrix(sc, Integer.parseInt(sc.nextLine()));
        System.out.println(findDet(list));
    }

    @Override
    public void task18() {
        Scanner sc = new Scanner(System.in);
        int matrixSize = Integer.parseInt(sc.next());
        List<List<Integer>> matrix = new ArrayList<>();
        Integer maxVal = null;
        for (int i = 0; i < matrixSize; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < matrixSize; j++) {
                int temp = Integer.parseInt(sc.next());
                matrix.get(i).add(temp);
                if (maxVal==null || maxVal < temp)
                    maxVal = temp;
            }
        }

        ArrayList<Integer> deleteColumns = new ArrayList<>();
        ArrayList<Integer> deleteRows = new ArrayList<>();
        for (List<Integer> list : matrix) {
            if (list.contains(maxVal))
            {
                if (!deleteRows.contains(maxVal))
                    deleteRows.add(matrix.indexOf(list));
            }
            for (int i = 0; i < list.size(); i++) {
                if (maxVal.equals(list.get(i))) {
                    if (!deleteColumns.contains(i))
                    deleteColumns.add(i);
                }
            }
        }

        deleteColumns.sort(Comparator.reverseOrder());
        deleteRows.sort(Comparator.reverseOrder());
        for (int index : deleteRows) {
            matrix.remove(index);
        }
        for (List<Integer> list : matrix) {
            for (int index : deleteColumns) {
                list.remove(index);
            }
        }

        System.out.println(
                (matrixSize - deleteRows.size()) + "\n"
                + (matrixSize - deleteColumns.size())
                );
        for (List<Integer> list : matrix) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void task19() {
        Scanner sc = new Scanner(System.in);
        List<List<String>> list = createAndFillListMatrix(sc, Integer.parseInt(sc.nextLine()));
        int initialListSize = list.size();
        List<Integer> deletionRows = new ArrayList<>();
        List<Integer> deletionCols = new ArrayList<>();
        for (List<String> strs : list) {
            int temp = 0;
            for (String s : strs) {
                if (Integer.parseInt(s) == 0) {
                    temp++;
                }
            }
            if (strs.size() == temp) {
                deletionRows.add(list.indexOf(strs));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = 0;
            for (List<String> ls : list) {
                if (Integer.parseInt(ls.get(i)) == 0) {
                    temp++;
                }
            }
            if (list.size() == temp) {
                deletionCols.add(i);
            }
        }
        deletionCols.sort(Comparator.reverseOrder());
        deletionRows.sort(Comparator.reverseOrder());
        for (int index : deletionRows) {
            list.remove(index);
        }
        for (List<String> strs : list) {
            for (int index : deletionCols) {
                strs.remove(index);
            }
        }

        System.out.println(
                (initialListSize - deletionRows.size()) + "\n"
                        + (initialListSize - deletionCols.size())
        );
        printListMatrix(list);
    }

    public static void main(String[] args) {
        Solver sv = new Solver();
        sv.task19();
    }
}

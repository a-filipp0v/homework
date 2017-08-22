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

    private String[] createArrayOfStringLines() {
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = sc.nextLine();
        }
        return lines;
    }

    @Override
    public void task1() {
        String[] lines = createArrayOfStringLines();
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
        String[] lines = createArrayOfStringLines();
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
        Scanner sc = new Scanner(System.in);
        Integer.parseInt(sc.nextLine());
        String[] lines = sc.nextLine().split(" ");
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
        Scanner sc = new Scanner(System.in);
        Integer.parseInt(sc.nextLine());
        String[] inputLines = sc.nextLine().split(" ");
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
            System.out.println(strings.stream()
                    .collect(Collectors.joining("\t")));
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

        if (Math.abs(index%list.size()) == 0 || index == 0) {
            System.out.println(list.size());
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

    public static void main(String[] args) {
        Solver sv = new Solver();
        sv.task13();

    }
}

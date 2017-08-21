package com.epam.courses.jf.practice.filippov.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализация первого блока заданий.
 */
public class Solver implements ISolver {

    // TODO выполнение задания

    @Override
    public void task1() {
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = sc.nextLine();
        }
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
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = sc.nextLine();
        }
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
        System.out.println(Arrays.stream(inputLines)
                                 .filter(string -> string.chars().distinct().count() == string.length())
                                 .collect(Collectors.joining(" ")));
    }

    @Override
    public void task8() {
        Scanner sc = new Scanner(System.in);
        Integer.parseInt(sc.nextLine());
        String[] inputLines = sc.nextLine().split(" ");
        String palindrome = "";
        for (String s : inputLines) {
            if (s.matches("^[0-9+]*$")) {
                if (new StringBuilder(s).reverse().toString().equals(s)) {
                    palindrome = s;
                }
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
    }
}

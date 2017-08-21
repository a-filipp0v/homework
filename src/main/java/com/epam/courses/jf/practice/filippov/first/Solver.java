package com.epam.courses.jf.practice.filippov.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

        int minLength = lines[0].length();
        int maxLength = lines[0].length();
        String minString = lines[0];
        String maxString = lines[0];
        for (String s : lines) {
            if (s.length() >= maxLength) {
                maxLength = s.length();
                maxString = s;
            }
            if (s.length() <= minLength) {
                minLength = s.length();
                minString = s;
            }
        }
        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }

    @Override
    public void task2() {
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = sc.nextLine();
        }
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines.length - 1; j++) {
                if (lines[j].length() > lines[j + 1].length()) {
                    String temp = lines[j];
                    lines[j] = lines[j + 1];
                    lines[j + 1] = temp;
                } else if (lines[j].length() == lines[j + 1].length()) {
                    if (lines[j].compareTo(lines[j + 1]) >= 0) {
                        String temp = lines[j];
                        lines[j] = lines[j + 1];
                        lines[j + 1] = temp;
                    }
                }
            }
        }
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
        int averageLength = (int) Math.floor(sumOfLenghts / lines.length);
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
        int numOfWords = Integer.parseInt(sc.nextLine());
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
        int numOfWords = Integer.parseInt(sc.nextLine());
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

    }

    @Override
    public void task9() {
        final int N = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println(IntStream.range(1, N * N + 1)
                .mapToObj(i -> i + (i % N == 0 ? "\n" : "\t"))
                .collect(Collectors.joining())
        );
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
        sv.task18();

    }
}

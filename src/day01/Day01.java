package day01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static utils.FileManager.parseFile;

public class Day01 {

    public static void main(String[] args) throws IOException {

        List<String> records = parseFile("01" , false);

        part1(records);
        part2(records);

    }



    private static void part1(List<String> records) {
        int previousDepth = 0;
        int counterDepth = 0;

        for (String record : records) {
            int currentDepth = Integer.parseInt(record);
            if (currentDepth > previousDepth) {
                counterDepth++;
            }
            previousDepth = currentDepth;
        }

        System.out.println(counterDepth -1);
    }

    private static void part2(List<String> records) {

        int previousWindowSum = 0;
        int counterDepth = 0;

        List<Integer> depthWindow = new ArrayList<>();

        for (String record : records) {

            int currentDepth = Integer.parseInt(record);

            if (depthWindow.size() < 3) {
                depthWindow.add(currentDepth);
            }

            if (depthWindow.size() == 3) {

                int currentWindowSum = depthWindow.stream().reduce(0, Integer::sum);
                if (currentWindowSum > previousWindowSum) {
                    counterDepth++;
                }
                depthWindow.remove(0);
                previousWindowSum = currentWindowSum;
            }
        }

        System.out.println(counterDepth -1 );
    }

}




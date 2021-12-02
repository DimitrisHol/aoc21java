package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public static List<String> parseFile(String day, boolean isTestInput) throws FileNotFoundException {
        List<String> records = new ArrayList<>();

        String fileName = calculateFileName(day, isTestInput);
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                records.add(scanner.next());
            }
        }
        return records;
    }

    public static String calculateFileName(String day, boolean isTestInput) {

        String baseString = "src/day";
        String testString = "test-";
        String inputString = "input";
        String txtString = ".txt";

        String testOrNoTest = isTestInput ? testString + inputString : inputString;
        return baseString + day + "/" +  testOrNoTest + day + txtString;
    }
}

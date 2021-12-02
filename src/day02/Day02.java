package day02;

import utils.FileManager;

import java.io.FileNotFoundException;
import java.util.List;

public class Day02 {

    public static void main(String[] args) throws FileNotFoundException {

        List<String> movements = FileManager.parseFile("02", false);

        part1(movements);
        part2(movements);
    }

    private static void part1(List<String> movements) {


        int horizontalMovement = 0;
        int verticalMovement = 0;

        for (String movement : movements) {

            String[] data = movement.split(" ");
            int movementValue = Integer.parseInt(data[1]);

            switch(data[0]) {
                case "forward" :
                    horizontalMovement += movementValue;
                    break;
                case "down" :
                    verticalMovement += movementValue;
                    break;
                default :
                    verticalMovement -= movementValue;
            }
        }
        System.out.println(horizontalMovement * verticalMovement);
    }

    private static void part2(List<String> movements) {

        int horizontalMovement = 0;
        int verticalMovement = 0;
        int aim = 0;

        for (String movement : movements) {

            String[] data = movement.split(" ");
            int movementValue = Integer.parseInt(data[1]);

            switch(data[0]) {
                case "forward" :
                    horizontalMovement += movementValue;
                    verticalMovement += movementValue * aim;
                    break;
                case "down" :
                    aim += movementValue;
                    break;
                default :
                    aim -= movementValue;
            }
        }
        System.out.println(horizontalMovement * verticalMovement);
    }
}

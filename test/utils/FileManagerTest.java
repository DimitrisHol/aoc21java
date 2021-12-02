package utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileManagerTest {

    @Test
    public void calculateFileNameTest(){

        assertEquals("src/day01/test-input01.txt", FileManager.calculateFileName("01", true));
        assertEquals("src/day01/input01.txt", FileManager.calculateFileName("01", false));
    }

}
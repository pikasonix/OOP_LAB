package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
    	String filename = "src/hust/soict/dsai/garbage/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        inputBytes = Files.readAllBytes(Paths.get(filename));
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
    }
}
/**
 * “I acknowledge that I am aware of the academic integrity guidelines of this course, and that I worked
 * on this assignment independently without any unauthorized help”
 */

import Classes.Activity;
import Solver.Solver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = args[0];
        int extensionIndex = inputPath.lastIndexOf('.');
        String extension = inputPath.substring(extensionIndex);
        int lastIndex = inputPath.substring(0, extensionIndex).lastIndexOf('.');
        String outputPath = inputPath.substring(0, lastIndex) + "_19015550.out" + extension;
        Scanner scanner = new Scanner(new File(inputPath));
        int n = scanner.nextInt();
        Activity[] A = new Activity[n];
        for (int i = 0; i < n; ++i) {
            A[i] = new Activity(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        // Answer is Long to avoid overflow
        long maximumWeight = new Solver().solve(A);
        try {
            FileWriter fileWriter = new FileWriter(outputPath);
            fileWriter.write(maximumWeight + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

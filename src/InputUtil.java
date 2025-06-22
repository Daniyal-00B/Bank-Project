import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class InputUtil {
    private static Scanner scanner;
    private static boolean usingFile = true;

    static {
        try {
            File inputFile = new File("TestCase.txt");
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            scanner = new Scanner(System.in);
            usingFile = false;
        }
    }

    private static void switchToConsoleIfNeeded() {
        if (usingFile) {
            try {
                if (!scanner.hasNext()) { // Check if file has more input
                    scanner.close();
                    scanner = new Scanner(System.in);
                    usingFile = false;
                }
            } catch (IllegalStateException e) {
                scanner.close();
                scanner = new Scanner(System.in);
                usingFile = false;
            }
        }
    }

    public static int nextInt() {
        switchToConsoleIfNeeded();
        try {
            int result = scanner.nextInt();
            scanner.nextLine(); // Clear buffer after reading int
            return result;
        } catch (NoSuchElementException | IllegalStateException e) {
            if (usingFile) {
                switchToConsoleIfNeeded();
                return scanner.nextInt(); // Retry once after switching
            }
            throw new RuntimeException("Failed to read integer input", e);
        }
    }

    public static double nextDouble() {
        switchToConsoleIfNeeded();
        try {
            double result = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer after reading int
            return result;
        } catch (NoSuchElementException | IllegalStateException e) {
            if (usingFile) {
                switchToConsoleIfNeeded();
                return scanner.nextDouble(); // Retry once after switching
            }
            throw new RuntimeException("Failed to read integer input", e);
        }
    }

    public static String next() {
        switchToConsoleIfNeeded();
        try {
            String result = scanner.next();
            scanner.nextLine(); // Clear buffer after reading token
            return result;
        } catch (NoSuchElementException | IllegalStateException e) {
            if (usingFile) {
                switchToConsoleIfNeeded();
                return scanner.next(); // Retry once after switching
            }
            throw new RuntimeException("Failed to read token input", e);
        }
    }

    public static String nextLine() {
        switchToConsoleIfNeeded();
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            if (usingFile) {
                switchToConsoleIfNeeded();
                return scanner.nextLine(); // Retry once after switching
            }
            throw new RuntimeException("Failed to read line input", e);
        }
    }

    public static boolean hasNext() {
        switchToConsoleIfNeeded();
        try {
            return scanner.hasNext();
        } catch (IllegalStateException e) {
            if (usingFile) {
                switchToConsoleIfNeeded();
                return scanner.hasNext();
            }
            return false;
        }
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
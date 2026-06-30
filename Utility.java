import java.util.Scanner;

public class Utility {

    // Scanner object used throughout the project
    public static Scanner sc = new Scanner(System.in);

    // Print a line
    public static void printLine() {
        System.out.println("==========================================");
    }

    // Print a heading
    public static void printHeading(String title) {

        printLine();

        System.out.println(title);

        printLine();
    }

    // Pause the program
    public static void pressEnter() {

        System.out.println("\nPress Enter to Continue...");

        sc.nextLine();
    }
}
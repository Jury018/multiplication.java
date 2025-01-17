import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplicationTable {

    // Method for coloring numbers based on their values
    public static String colorNumber(int number, int maxValue) {
        if (number <= maxValue / 10) {
            return "\033[38;5;33m" + String.format("%3d", number) + "\033[0m"; // Light Blue  
        } else if (number <= maxValue / 5) {
return "\033[38;5;82m" + String.format("%3d", number) + "\033[0m"; // Light Green  
        } else if (number <= maxValue / 2) {
            return "\033[38;5;40m" + String.format("%3d", number) + "\033[0m"; // Green   
        } else if (number <= maxValue) {
            return "\033[38;5;226m" + String.format("%3d", number) + "\033[0m"; // Yellow  
        } else {
            return "\033[38;5;196m" + String.format("%3d", number) + "\033[0m"; // Red 
        }
    }

    // Method to print the game title
    public static void printGameTitle() {
        System.out.println("\033[38;5;46m"); // Green color for the title
        System.out.println("=================================================");
        System.out.println("              MULTIPLICATION TABLE GAME         ");
        System.out.println("=================================================");
        System.out.println("\033[0m");
        System.out.println("Get ready to test your skills with multiplication!");
        System.out.println("Enter a size (odd number) to generate a custom table.");
        System.out.println();
    }

    // Method to simulate a glowing prompt
    public static void glowingPrompt(String message) {
        System.out.print("\033[38;5;214;1m\033[5m" + message + "\033[0m"); 
    }

    // Method to print the top and bottom borders
    public static void printBorder(int size) {
        String border = "+-----";
        for (int i = 0; i < size; i++) {
            border += "-----";
        }
        border += "+";
        System.out.println(border);
    }

    // Method to print the header row
    public static void printHeader(int size) {
        System.out.print("|     |");
        for (int i = 1; i <= size; i++) {
            System.out.print("  " + String.format("%2d", i) + "  |");
        }
        System.out.println();
    }

    // Main method to drive the program and handle the game flow
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        // Display the game title
        printGameTitle();

        while (continuePlaying) {
            int size = 0;
            int attempts = 0;

            // Input validation for size (only odd numbers are allowed)
            while (attempts < 3) {
                glowingPrompt("Enter the size of the multiplication table: ");
                try {
                    size = scanner.nextInt(); // Try to read the integer input
                    if (size % 2 != 0 && size > 0) {
                        break;  // Valid input
                    } else {
                        System.out.println("Invalid input. Please enter a positive odd number.");
                    }
                } catch (InputMismatchException e) {
                    // Handle invalid input (e.g., a string input instead of an integer)
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next(); // Consume the invalid input to avoid infinite loop
                }
                attempts++;
                if (attempts < 3) {
                    System.out.println("You have " + (3 - attempts) + " attempt(s) left.");
                }
            }

            // If too many invalid attempts, stop the game
            if (attempts == 3) {
                System.out.println("Too many invalid attempts.");
                continuePlaying = false;  // Exit the game if there are too many invalid attempts
            } else {
                // Generate the creative multiplication table
                generateDetailedMultiplicationTable(size);

                // Ask if the user wants to try again (only string input here)
                String response = "";
                while (true) {
                    glowingPrompt("Would you like to try again? (y/n): ");
                    response = scanner.next();
                    if (response.equalsIgnoreCase("y")) {
                        break; // Continue the game
                    } else if (response.equalsIgnoreCase("n")) {
                        continuePlaying = false;
                        System.out.println("Thank you for playing!");
                        break; // Exit the game
                    } else {
                        System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    }
                }
            }
        }
    }

    // Method to generate and display the detailed multiplication table
    public static void generateDetailedMultiplicationTable(int size) {
        printBorder(size);
        printHeader(size);
        printBorder(size);

       
        for (int i = 1; i <= size; i++) {
            System.out.print("|  " + String.format("%2d", i) + " |"); 

            for (int j = 1; j <= size; j++) {
                System.out.print(" " + colorNumber(i * j, size * size) + " |");
            }
            System.out.println();
            printBorder(size);
        }
    }
}
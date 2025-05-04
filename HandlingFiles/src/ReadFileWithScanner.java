import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileWithScanner {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Infinite loop to keep asking for file names
        while(true) {
            // Prompt the user to enter the name of the file or type "exit" to quit
            System.out.println("Enter the name of the file you want to read " +
                    "(or type 'exit' to quit): ");
            String userInput = scanner.nextLine();
            //Check if the user wants to quit
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break; //Exit the loop
            }
            try {
                Scanner fileScanner = new Scanner(new FileReader(userInput));
                //Loop through the file line by line
                while (fileScanner.hasNext()) {
                    //Read the next line from the file
                    String fileLine = fileScanner.nextLine();
                    //Print the line to the console
                    System.out.println(fileLine);
                }
                //Close the file scanner to free up resources (optional, but recommended)
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
        //Close the scanner to release resources
        scanner.close();
    }
}
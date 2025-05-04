import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Define the main class
public class ReadFileExampleWithScanner {
    public static void main(String[] args) {
        //Specify the file path
        try{
            //Create a scanner to read user input from the console
            Scanner scanner = new Scanner(System.in);
            //Prompt the user to enter the name of the file they want to read
            System.out.println("Enter the name of the file you want to read: ");
            //Create a new Scanner object to read from the file specified by the user
            //FileReader is used to read the file, and the file name is obtained from the user
            Scanner fileScanner = new Scanner(new FileReader(scanner.nextLine()));
            //Loop through the file line by line
            while(fileScanner.hasNext()) {
                //Read next line from the file
                String fileLine = fileScanner.nextLine();
                System.out.println(fileLine);
            }
            //Close the file scanner to free up resources
            fileScanner.close();
        } catch (FileNotFoundException e) {
            //Handle the case where the file is not found
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

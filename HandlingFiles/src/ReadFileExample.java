import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to read: ");
        Path filePath = Paths.get(scanner.nextLine());

        try {
            //Read the entire content of the file as a single string
            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            //Handle the case where and I/O error occurs (e.g. file not found or cannot be read)
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
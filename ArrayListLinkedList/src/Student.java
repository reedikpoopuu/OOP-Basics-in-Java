import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private String major;

    public static String BIOLOGY = "Biology";
    public static String ARCHITECTURE = "Architecture";
    public static String COMPUTER_SCIENCE = "Computer Science";

    public Student(String name,
                   int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nMajor: " + major;
    }

    public static void main(String[] args) {
        try {
            //Create a scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            //Create an ArrayList to store Task objects (to-do list)
            ArrayList<Student> studentList = new ArrayList<Student>();

            //Create an infinite loop to keep the program running
            //until the user chooses to exit
            while(true) {
                //Display menu options to the user
                System.out.println(
                        "Press 1 to add a student," +
                                "\n2 to view all the tasks," +
                                "\n3 to update student's information," +
                                "\n4 to delete a student," +
                                "\n5 to sort the list based on age," +
                                "\nany other key to exit"
                );
                //Read user's choice
                String userAction = scanner.nextLine();
                //Option 1: Add a task to the to-do list
                if (userAction.equals("1")) {
                    System.out.println("Enter the student's name: ");
                    String stName = scanner.nextLine();
                    System.out.println("Enter the student's age: ");
                    int stAge = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the student's major: ");
                    String stMajor = scanner.nextLine();
                    //Create a Task object and add it to the to-do list
                    studentList.add(new Student(stName, stAge, stMajor));
                    System.out.println("The student has been added to the list.");
                }
                else if (userAction.equals("2")) {
                    studentList.forEach(student -> System.out.println(student));
                }
                //Option 3: Change status of a task
                else if (userAction.equals("3")) {
                    System.out.println(
                            "Enter the index of the student to update the information for: "
                    );
                    int updateIdx = Integer.parseInt(scanner.nextLine());
                    //Check if the index is valid
                    if (updateIdx > (studentList.size() - 1)) {
                        System.out.println(
                                "There is no such index position in the list"
                        );
                    } else {
                        // Prompt the user to enter the new status for the task
                        System.out.println(
                                "Enter the new major for the student (" +
                                        "A for Architecture," +
                                        "B for Biology," +
                                        "C for Computer Science): "
                        );
                        String updatedStatus = scanner.nextLine();
                        //Update the task status based on the user's input
                        if (updatedStatus.equalsIgnoreCase("A")) {
                            studentList.get(updateIdx).setMajor(Student.ARCHITECTURE);
                        } else if (updatedStatus.equalsIgnoreCase("B")) {
                            studentList.get(updateIdx).setMajor(Student.BIOLOGY);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            studentList.get(updateIdx).setMajor(Student.COMPUTER_SCIENCE);
                        }
                    }
                    System.out.println(
                            "The task has been changed in the list."
                    );
                }
                //Option 4: Delete a task
                else if (userAction.equals("4")) {
                    //Prompt the user to enter the index of the task to be deleted
                    System.out.println(
                            "Enter the index of the task you want to delete: "
                    );
                    int rmvIdx = Integer.parseInt(scanner.nextLine());
                    //Check if the index is valid
                    if (rmvIdx > (studentList.size() - 1)) {
                        System.out.println(
                                "There is no such index position in the list"
                        );
                    } else {
                        studentList.remove(rmvIdx);
                        System.out.println(
                                "The task has been removed."
                        );
                    }
                } else if (userAction.equals("5")) {
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return Integer.compare(o2.getAge(), o1.getAge());
                        }
                    });
                    System.out.println(
                            "Tasks sorted by priority (High to Low): "
                    );
                    studentList.forEach(student -> System.out.println(student));
                }
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            //Handle invalid number input (e.g. non-integer input for age or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}

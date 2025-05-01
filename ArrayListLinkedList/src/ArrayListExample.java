import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        try {
            //Create a scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            //Create an ArrayList to store Task objects (to-do list)
            ArrayList<Task> todoList = new ArrayList<Task>();

            //Create an infinite loop to keep the program running
            //until the user chooses to exit
            while(true) {
                //Display menu options to the user
                System.out.println(
                        "Press 1 to add a task," +
                                "\n2 to view all the tasks," +
                                "\n3 to change status of tasks," +
                                "\n4 to delete a task," +
                                "\n5 to sort the list based on priority," +
                                "\nany other key to exit"
                );
                //Read user's choice
                String userAction = scanner.nextLine();
                //Option 1: Add a task to the to-do list
                if (userAction.equals("1")) {
                    System.out.println("Enter the task: ");
                    String taskStr = scanner.nextLine();
                    //Prompt the user to enter the priority of the task
                    System.out.println(
                            "Enter the Priority (1 for Low, 2 for Medium, 3 for High): "
                    );
                    int priority = Integer.parseInt(scanner.nextLine());
                    //Validate the priority input (default to 1 if invalid input)
                    priority = priority > 3? 1: priority;
                    //Create a Task object and add it to the to-do list
                    todoList.add(new Task(taskStr, priority));
                    System.out.println("The task has been added to the list.");
                }
                //Option 2: View all the tasks in the to-do list
                else if (userAction.equals("2")) {
                    //User forEach to print each task in the to-do list
                    todoList.forEach(task -> System.out.println(task));
                }
                //Option 3: Change status of a task
                else if (userAction.equals("3")) {
                    //Prompt the user to enter the index of the task to update
                    System.out.println(
                            "Enter the index of the task to change status for: "
                    );
                    int chgIdx = Integer.parseInt(scanner.nextLine());
                    //Check if the index is valid
                    if (chgIdx > (todoList.size() - 1)) {
                        System.out.println(
                                "There is no such index position in the list"
                        );
                    } else {
                        // Prompt the user to enter the new status for the task
                        System.out.println(
                                "Enter the new status for the task (" +
                                        "P for In progress," +
                                        "C for Completed): "
                        );
                        String updatedStatus = scanner.nextLine();
                        //Update the task status based on the user's input
                        if (updatedStatus.equalsIgnoreCase("P")) {
                            todoList.get(chgIdx).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            todoList.get(chgIdx).setStatus(Task.COMPLETED);
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
                    if (rmvIdx > (todoList.size() - 1)) {
                        System.out.println(
                                "There is no such index position in the list"
                        );
                    } else {
                        todoList.remove(rmvIdx);
                        System.out.println(
                                "The task has been removed."
                        );
                    }
                } else if (userAction.equals("5")) {
                    //Sort the ArrayList by priority using Comparator
                    Collections.sort(todoList, new Comparator<Task>() {
                        @Override
                        public int compare(Task o1, Task o2) {
                            return Integer.compare(o2.getPriority(), o1.getPriority());
                        }
                    });
                    System.out.println(
                            "Tasks sorted by priority (High to Low): "
                    );
                    todoList.forEach(task -> System.out.println(task));
                }
                //Exit the program if the user enters any other key
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            //Handle invalid number input (e.g. non-integer input for priority or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
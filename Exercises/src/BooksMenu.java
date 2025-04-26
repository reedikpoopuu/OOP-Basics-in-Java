import java.util.Scanner;

public class BooksMenu {
    private static void compareEquality (Book book1, Book book2) {
        if (book1.equals(book2)) {
            System.out.println("The two books are the same!");
        } else {
            System.out.println("These two are totally different books!");
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        while(true) {
            System.out.println("Press 1 to view books, " +
                    "\n2 to add books, " +
                    "\n3 to compare prices," +
                    "\n4 to change the price," +
                    "\n5 to compare the books," +
                    "\nand any other key to exit");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                for (int i = 0; i < books.length; i++) {
                    if (books[i] != null) {
                        System.out.println(books[i]);
                    }
                }
            } else if (userAction.equals("2")) {
                if (bkIdx == 10) {
                    System.out.println("10 books added already. " +
                            "Cannot add any more books!");
                    continue;
                }
                System.out.println("How do you wish to create the new book object?" +
                        "\n Press 1 for default constructor," +
                        "\n Press 2 for creating a clone of an existing book," +
                        "\n and any other key for overloaded constructor");
                String userInput = scanner.nextLine();
                if (userInput.equals("1")) {
                    System.out.println("Enter book title: ");
                    String tmpTitle = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String tmpAuthor = scanner.nextLine();
                    System.out.println("Enter book price: ");
                    float tmpPrice = Float.parseFloat(scanner.nextLine());
                    Book bkTmp = new Book();
                    bkTmp.setTitle(tmpTitle);
                    bkTmp.setAuthor(tmpAuthor);
                    bkTmp.setPrice(tmpPrice);
                    books[bkIdx++] = bkTmp;
                } else if (userInput.equals("2")) {
                    System.out.println("What book object do you wish to clone (index)?");
                    int cloneIdx = Integer.parseInt(scanner.nextLine());
                    if (books[cloneIdx] != null) {
                        books[bkIdx++] = (Book) books[cloneIdx].clone();
                    }
                } else {
                    System.out.println("Enter book title");
                    String tmpTitle = scanner.nextLine();
                    System.out.println("Enter book author");
                    String tmpAuthor = scanner.nextLine();
                    System.out.println("Enter book price");
                    float tmpPrice = Float.parseFloat(scanner.nextLine());
                    books[bkIdx++] = new Book(tmpTitle, tmpAuthor, tmpPrice);
                }
            } else if (userAction.equals("3")) {
                System.out.println("Enter the number of the first book to compare: ");
                int book1num =Integer.parseInt(scanner.nextLine());
                Book book1 = books[book1num];
                System.out.println("You chose: " + book1.getTitle());
                System.out.println("Enter the number of the second book to compare: ");
                int book2num = Integer.parseInt(scanner.nextLine());
                Book book2 = books[book2num];
                System.out.println("You chose: " + book2.getTitle());
                if (book1 != null && book2 != null) {
                    BookAccess.comparePrices(book1, book2);
                }  else {
                    System.out.println("One of the books is null!");
                }
            } else if (userAction.equals("4")) {
                System.out.println("Please enter the index of the book: ");
                int bookNum = Integer.parseInt(scanner.nextLine());
                System.out.println("You chose: " + books[bookNum].getTitle());
                System.out.println("Please enter the new price: ");
                books[bookNum].setPrice(Float.parseFloat(scanner.nextLine()));
            } else if (userAction.equals("5")) {
                System.out.println("Enter the index of the first book to compare: ");
                Book tmpBook1 = books[Integer.parseInt(scanner.nextLine())];
                System.out.println("You chose: " + tmpBook1.getTitle());
                System.out.println("Enter the index of the second book to compare: ");
                Book tmpBook2 = books[Integer.parseInt(scanner.nextLine())];
                System.out.println("You chose: " + tmpBook2.getTitle());
                compareEquality(tmpBook1, tmpBook2);
            } else {
                break;
            }
        }
    }
}

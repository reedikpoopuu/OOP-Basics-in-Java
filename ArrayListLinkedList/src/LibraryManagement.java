import java.util.*;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("1984", "George Orwell", 1949));

        boolean running = true;

        while(running) {
            System.out.println("Press 1 to add a book," +
                    "\n2 to view all books," +
                    "\n3 to search for a book by title," +
                    "\n4 to check out a book," +
                    "\n5 to return a book," +
                    "\n6 to sort books (by title, author, or publication year)," +
                    "\n7 to view available books only," +
                    "\n8 to exit." +
                    "\nEnter your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch(choice) {
                case 1:
                    addBook(scanner, books);
                    break;
                case 2:
                    viewAllBooks(books);
                    break;
                case 3:
                    searchBooks(scanner, books);
                    break;
                case 4:
                    checkOutBook(scanner, books);
                    break;
                case 5:
                    returnBook(scanner, books);
                    break;
                case 6:
                    sortBooks(scanner, books);
                    break;
                case 7:
                    viewAvailableBooks(books);
                    break;
                case 8:
                    System.out.println("Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addBook(Scanner scanner, ArrayList<Book> books) {
        System.out.println("Enter the book title: ");
        String tmpTitle = scanner.nextLine();
        System.out.println("Enter the book author: ");
        String tmpAuthor = scanner.nextLine();

        int tmpYear = 0;
        boolean validYear = false;

        while(!validYear) {
            System.out.println("Enter the year of publication: ");
            try {
                tmpYear = Integer.parseInt(scanner.nextLine());
                validYear = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a number.");
            }
        }
        Book tmpBook = new Book(tmpTitle, tmpAuthor, tmpYear);
        books.add(tmpBook);
        System.out.println("New book added successfully: " + tmpBook);
    }

    private static void viewAllBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        books.forEach(book -> System.out.println((books.indexOf(book) +1) + ". " +  book));
    }

    private static void searchBooks(Scanner scanner, ArrayList<Book> books) {
        System.out.println("Enter the search term (title or author): ");
        String searchTerm = scanner.nextLine().toLowerCase();
        System.out.println("Search result(s): ");
        boolean found = false;

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getBookTitle().toLowerCase().contains(searchTerm) ||
                    book.getAuthor().toLowerCase().contains(searchTerm)) {
                System.out.println((i + 1) + ". " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found matching \"" + searchTerm +
                    "\"");
        }
    }

    private static void checkOutBook (Scanner scanner, ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("Available books: ");
        boolean hasAvailable = false;

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getIsAvailable()) {
                System.out.println((i + 1) + ". " + book);
                hasAvailable = true;
            }
        }

        if (!hasAvailable) {
            System.out.println("No books are currently available.");
        }

        System.out.println("Enter the number of the book to check out: ");
        try {
            int bookNum = Integer.parseInt(scanner.nextLine());
            if (bookNum < 1 || bookNum > books.size()) {
                System.out.println("Invalid book number.");
                return;
            }

            Book bookSelected = books.get(bookNum - 1);

            if (bookSelected.checkOut()) {
                System.out.println("Book checked out successfully: " + bookSelected);
            } else {
                System.out.println("Book is already checked out.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void returnBook(Scanner scanner, ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("Checked out books: ");
        boolean hasCheckedOut = false;

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (!book.getIsAvailable()) {
                System.out.println((i+1) + ". " + book);
                hasCheckedOut = true;
            }
        }

        if(!hasCheckedOut) {
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.println("Enter the number of the book to return: ");
        try {
            int bookNum = Integer.parseInt(scanner.nextLine());
            if (bookNum < 1 || bookNum > books.size()) {
                System.out.println("Invalid book number.");
                return;
            }
            Book bookSelected = books.get(bookNum - 1);
            if (bookSelected.returnBook()) {
                System.out.println("Book returned successfully: " + bookSelected);
            } else {
                System.out.println("Book was not checked out.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void sortBooks(Scanner scanner, ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("Sort by:" +
                "\n1. Title" +
                "\n2. Author" +
                "\n3. Publication Year" +
                "\nEnter your choice: ");
        try {
            int sortChoice = Integer.parseInt(scanner.nextLine());

            switch (sortChoice) {
                case 1:
                    Collections.sort(books, new Comparator<Book>() {
                        @Override
                        public int compare(Book b1, Book b2) {
                            return b1.getBookTitle().compareToIgnoreCase(b1.getBookTitle());
                        }
                    });
                    System.out.println("Books sorted by title.");
                    break;
                case 2:
                    Collections.sort(books, new Comparator<Book>() {
                        @Override
                        public int compare(Book b1, Book b2) {
                            return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
                        }
                    });
                    System.out.println("Books sorted by author.");
                    break;
                case 3:
                    Collections.sort(books, new Comparator<Book>() {
                        @Override
                        public int compare(Book b1, Book b2) {
                            return Integer.compare(b1.getPublicationYear(), b2.getPublicationYear());
                        }
                    });
                    System.out.println("Books sorted by publication year.");
                    break;
                default:
                    System.out.println("Invalid input");
                    return;
            }

            viewAllBooks(books);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void viewAvailableBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        boolean found = false;
        for (int i=0;i<books.size();i++) {
            Book book = books.get(i);
            if (book.getIsAvailable()) {
                System.out.println((i+1) + ". " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently available.");
        }
    }
}


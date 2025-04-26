import java.util.Scanner;

public class BooksMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        while(true) {
            System.out.println("Press 1 to view books, " +
                    "2 to add books, 3 to compare prices, any other key to exit");
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
                } else {
                    System.out.println("One of the books is null!");
                }
            } else {
                break;
            }
        }
    }
}

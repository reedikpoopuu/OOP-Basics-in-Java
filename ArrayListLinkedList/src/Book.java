public class Book {
    private String bookTitle;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String bookTitle, String author, int publicationYear) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Title: " + bookTitle + " |Author: " + author + " |Year: "
                + publicationYear + " |Available: " + (isAvailable? "yes": "no");
    }

    public String getBookTitle() {
        return bookTitle;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean status) {
        this.isAvailable = status;
    }

    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        } else {
            return false;
        }
    }
}
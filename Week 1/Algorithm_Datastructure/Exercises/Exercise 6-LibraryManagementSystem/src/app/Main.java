package app;

import model.Book;
import service.BookSearchService;
import util.BookData;

public class Main {

    public static void main(String[] args) {

        BookSearchService service = new BookSearchService();

        Book[] books = BookData.getBooks();

        System.out.println("Linear Search:");
        Book result1 = service.linearSearch(books, "Algorithms");

        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Book not found");
        }

        Book[] sortedBooks = BookData.getSortedBooks();

        System.out.println("\nBinary Search:");
        Book result2 = service.binarySearch(sortedBooks, "Algorithms");

        if (result2 != null) {
            System.out.println(result2);
        } else {
            System.out.println("Book not found");
        }
    }
}
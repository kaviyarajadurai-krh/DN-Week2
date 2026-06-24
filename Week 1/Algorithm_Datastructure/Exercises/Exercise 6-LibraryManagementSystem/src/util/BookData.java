package util;

import model.Book;

import java.util.Arrays;
import java.util.Comparator;

public class BookData {

    public static Book[] getBooks() {

        return new Book[]{
                new Book(101, "Java Basics", "James"),
                new Book(102, "Algorithms", "CLRS"),
                new Book(103, "Data Structures", "Mark"),
                new Book(104, "Python Guide", "Guido"),
                new Book(105, "Spring Boot", "Pivotal")
        };
    }

    public static Book[] getSortedBooks() {

        Book[] books = getBooks();

        Arrays.sort(
                books,
                Comparator.comparing(Book::getTitle)
        );

        return books;
    }
}
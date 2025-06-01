package org.example.hibernatedemo;

import org.example.hibernatedemo.dao.BookDao;
import org.example.hibernatedemo.model.Book;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        BookDao bookDao = new BookDao();
        // Create and save a new book
        Book book = new Book();

        book.setTitle("Hibernate in Action");
        book.setAuthor("Gavin King");
        book.setPrice(49.99);
        bookDao.saveBook(book);
        System.out.println("Book saved.");

        // Fetch and print all books
        List<Book> books = bookDao.getAllBooks();
        books.forEach(b ->
                        System.out.println(b.getTitle() +
                        " - " + b.getAuthor() +
                        " - " + b.getPrice())
        );

        // Update a book
        book.setPrice(39.99);
        bookDao.updateBook(book);
        System.out.println("Book updated.");

        // Fetch and print the updated book
        Book updatedBook = bookDao.getBookById(book.getId());
        System.out.println("Updated Book: " + updatedBook.getTitle() + " - " + updatedBook.getAuthor() +
                " - " + updatedBook.getPrice());

        // Delete a book
        bookDao.deleteBook(updatedBook.getId());
        System.out.println("Book deleted.");

//        Book b=new Book();
//        b.setId(2L);
//        bookDao.deleteBook(b.getId());

    }

}

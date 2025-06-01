package org.example.hibernatedemo.dao;

import jakarta.persistence.*;
import org.example.hibernatedemo.model.Book;
import java.util.List;
public class BookDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");
    public void saveBook(Book book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }
    public void updateBook(Book book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }
    public Book getBookById(Long id) {
        EntityManager em = emf.createEntityManager();
        Book book = em.find(Book.class, id);
        em.close();
        return book;
    }
    public List<Book> getAllBooks() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        List<Book> books = query.getResultList();
        em.close();
        return books;
    }
    public void deleteBook(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
        } else {
            System.out.println("There is No Books!!!");
        }
        em.getTransaction().commit();
        em.close();
    }


}

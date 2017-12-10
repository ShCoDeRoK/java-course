package ru.mipt.java2017.hw3.Application;

import org.hibernate.Session;
import ru.mipt.java2017.hw3.Models.Author;
import ru.mipt.java2017.hw3.Models.Book;
import ru.mipt.java2017.hw3.Models.BookAuthor;
import javax.persistence.EntityManager;

public class DataWriter {

  DataAccess dataAccess;
  Session session;
  EntityManager entityManager;

  public DataWriter(DataAccess dataAccess) {
    this.dataAccess = dataAccess;
    session = dataAccess.session;
    entityManager = dataAccess.entityManager;
  }

  public Long WriteToDatabase(Author author) {
    dataAccess.entityManager.getTransaction().begin();
    dataAccess.entityManager.persist(author);
    dataAccess.entityManager.getTransaction().commit();
    return author.getID();
  }

  public Long WriteToDatabase(Book book) {
    dataAccess.entityManager.getTransaction().begin();
    dataAccess.entityManager.persist(book);
    dataAccess.entityManager.getTransaction().commit();
    return book.getID();
  }

  public void WriteToDatabase(BookAuthor bookAuthor) {
    dataAccess.entityManager.getTransaction().begin();
    dataAccess.entityManager.persist(bookAuthor);
    dataAccess.entityManager.getTransaction().commit();
  }
}
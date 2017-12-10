package ru.mipt.java2017.hw3.Application;

import org.hibernate.Session;
import ru.mipt.java2017.hw3.Models.Book;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

public class Updater {

  Access dataAccess;
  Session session;
  EntityManager entityManager;

  public Long UpdateDatabase(Book book) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
    Predicate isbnEqual = criteriaBuilder.equal(query.from(Book.class).get("ISBN"), book.getISBN());
    query.where(isbnEqual);
    Long id = entityManager.createQuery(query).getResultList().get(0).getID();
    Book foundBook = entityManager.find(Book.class, id);
    entityManager.getTransaction().begin();
    foundBook.setTitle(book.getTitle());
    entityManager.getTransaction().commit();
    return foundBook.getID();
  }

  public Updater(Access dataAccess) {
    this.dataAccess = dataAccess;
    session = dataAccess.session;
    entityManager = dataAccess.entityManager;
  }
}
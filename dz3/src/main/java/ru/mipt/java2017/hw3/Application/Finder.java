package ru.mipt.java2017.hw3.Application;

import org.hibernate.Session;
import ru.mipt.java2017.hw3.Models.Author;
import ru.mipt.java2017.hw3.Models.Book;
import ru.mipt.java2017.hw3.Models.BookAuthor;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class Finder {

  Access dataAccess;
  Session session;
  EntityManager entityManager;

  public Finder(Access dataAccess) {
    this.dataAccess = dataAccess;
    session = dataAccess.session;
    entityManager = dataAccess.entityManager;
  }

  public Long getAuthor(Author author) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Author> query = criteriaBuilder.createQuery(Author.class);
    Predicate isbnEqual = criteriaBuilder.equal(query.from(Author.class).get("Name"), author.getName());
    query.where(isbnEqual);
    if (entityManager.createQuery(query).getResultList().isEmpty()) {
      return 0l;
    } else {
      return entityManager.createQuery(query).getResultList().get(0).getID();
    }
  }

  public List<BookAuthor> getAllBooksAuthors() {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<BookAuthor> query = criteriaBuilder.createQuery(BookAuthor.class);
    query.select(query.from(BookAuthor.class));
    return entityManager.createQuery(query).getResultList();
  }

  public List<Author> getAllAuthors() {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Author> query = criteriaBuilder.createQuery(Author.class);
    query.select(query.from(Author.class));
    return entityManager.createQuery(query).getResultList();
  }

  public List<Book> getAllBooks() {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
    query.select(query.from(Book.class));
    return entityManager.createQuery(query).getResultList();
  }

  public boolean FindFromDatabase(Book book) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
    Predicate isbnEqual = criteriaBuilder.equal(query.from(Book.class).get("ISBN"), book.getISBN());
    query.where(isbnEqual);
    return !entityManager.createQuery(query).getResultList().isEmpty();
  }
}
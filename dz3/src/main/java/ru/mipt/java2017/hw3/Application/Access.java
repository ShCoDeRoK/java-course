package ru.mipt.java2017.hw3.Application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mipt.java2017.hw3.Models.Author;
import ru.mipt.java2017.hw3.Models.Book;
import ru.mipt.java2017.hw3.Models.BookAuthor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Access {

  private static SessionFactory sessionFactory;
  Session session;
  private static EntityManagerFactory entityManagerFactory;
  public EntityManager entityManager;

  static private void StaticAdd(String connection) {
    Configuration configuration = new Configuration();
    configuration.addAnnotatedClass(Book.class);
    configuration.addAnnotatedClass(Author.class);
    configuration.addAnnotatedClass(BookAuthor.class);
    configuration.configure();
    sessionFactory = configuration.buildSessionFactory();
    Map<String, String> map = new HashMap<>();
    map.put("hibernate.connection.url", connection);
    entityManagerFactory = Persistence.createEntityManagerFactory("myDb", map);
  }

  public Access(String connectionString) {
    session = null;
    entityManager = null;
    StaticAdd(connectionString);
    session = sessionFactory.openSession();
    entityManager = entityManagerFactory.createEntityManager();
  }

  public static void shutdown() {
    sessionFactory.close();
    entityManagerFactory.close();
  }
}